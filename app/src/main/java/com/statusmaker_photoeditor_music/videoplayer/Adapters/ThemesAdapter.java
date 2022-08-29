package com.statusmaker_photoeditor_music.videoplayer.Adapters;

import static android.content.Context.MODE_APPEND;
import static com.facebook.ads.internal.settings.AdSharedPreferences.getSharedPreferences;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import static com.statusmaker_photoeditor_music.videoplayer.ShowThemesActivity.tvCoin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.statusmaker_photoeditor_music.videoplayer.MainActivity;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.VideoDeleteInterface;
import com.statusmaker_photoeditor_music.videoplayer.VideoSelectorActivity;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.AppActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ThemesAdapter extends RecyclerView.Adapter<ThemesAdapter.ViewHolder> {

    ArrayList<Integer> themes;
    ArrayList<Integer> cost;
    Context context;

    private RewardedAd mRewardedAd;


    public ThemesAdapter(ArrayList<Integer> themes, ArrayList<Integer> cost, Context context) {
        this.cost = cost;
        this.themes = themes;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.themes_listview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThemesAdapter.ViewHolder holder, int position) {

        AdRequest adRequest = new AdRequest.Builder().build();

        if (position == 0) {
            RewardedAd.load(context, "ca-app-pub-1071420265996072/3028101324",
                    adRequest, new RewardedAdLoadCallback() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            // Handle the error.
                            Log.d("TAG", loadAdError.getMessage());
                            mRewardedAd = null;
                        }

                        @Override
                        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                            mRewardedAd = rewardedAd;
                            Log.d("TAG", "Ad was loaded.");
                        }
                    });
        }


        Glide.with(context).load(themes.get(position)).into(holder.theme_value);


        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor_theme = theme_pref.edit();

        SharedPreferences mus_theme_pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor mus_editor_theme = mus_theme_pref.edit();

        SharedPreferences sh = context.getSharedPreferences("Coins",Context.MODE_APPEND);

        int c = sh.getInt("Number", 0);
        SharedPreferences sharedPreferences = context.getSharedPreferences("Coins",Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        if (theme_pref.getString("Theme", "default").equals(themes.get(position).toString())) {
            holder.active_img.setVisibility(View.VISIBLE);
        } else if (mus_theme_pref.getString("MusicTheme", "default").equals(themes.get(position).toString())) {

        } else {
            holder.active_img.setVisibility(View.GONE);
        }

        holder.tvCost.setText(cost.get(position)+"");
       // if (position % 3 == 0) {

            holder.theme_prem.setVisibility(View.VISIBLE);
//        } else {
//            //holder.tvCost.setVisibility(View.GONE);
//            holder.theme_prem.setVisibility(View.GONE);
//        }


        holder.theme_value.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                //if (position%3==0) {

                    new AlertDialog.Builder(context)
                            .setTitle("Premium Theme!")
                            .setMessage("You can purchase the theme for " + cost.get(position) + " Coins. Do you want to proceed?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    if (c >= cost.get(position)) {
                                        if (themes.get(position).toString().equals(String.valueOf(R.drawable.music1)) ||
                                                themes.get(position).toString().equals(String.valueOf(R.drawable.music2)) ||
                                                themes.get(position).toString().equals(String.valueOf(R.drawable.music3)) ||
                                                themes.get(position).toString().equals(String.valueOf(R.drawable.music4)) ||
                                                themes.get(position).toString().equals(String.valueOf(R.drawable.music5)) ||
                                                themes.get(position).toString().equals(String.valueOf(R.drawable.music6)) ||
                                                themes.get(position).toString().equals(String.valueOf(R.drawable.music7)) ||
                                                themes.get(position).toString().equals(String.valueOf(R.drawable.music8))) {
                                            mus_editor_theme.putString("MusicTheme", themes.get(position).toString());
                                            mus_editor_theme.commit();

                                            ((Activity) context).finishAffinity();
                                            Intent intent = new Intent(context, AppActivity.class);
                                            context.startActivity(intent);

                                        } else {
                                            editor_theme.putString("Theme", themes.get(position).toString());
                                            editor_theme.commit();
                                            notifyDataSetChanged();
                                        }
                                        myEdit.putInt("Number",c-cost.get(position));
                                        myEdit.commit();
                                        tvCoin.setText(c-cost.get(position)+"");
                                    }
                                    else
                                    {
                                        Toast.makeText(context,"You don't have sufficient coins!!",Toast.LENGTH_SHORT).show();
                                    }


                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            .setNegativeButton(android.R.string.no, null)
                            .show();


//                } else {
//                    if (themes.get(position).toString().equals(String.valueOf(R.drawable.music1)) ||
//                            themes.get(position).toString().equals(String.valueOf(R.drawable.music2)) ||
//                            themes.get(position).toString().equals(String.valueOf(R.drawable.music3)) ||
//                            themes.get(position).toString().equals(String.valueOf(R.drawable.music4)) ||
//                            themes.get(position).toString().equals(String.valueOf(R.drawable.music5)) ||
//                            themes.get(position).toString().equals(String.valueOf(R.drawable.music6)) ||
//                            themes.get(position).toString().equals(String.valueOf(R.drawable.music7)) ||
//                            themes.get(position).toString().equals(String.valueOf(R.drawable.music8))) {
//                        mus_editor_theme.putString("MusicTheme", themes.get(position).toString());
//                        mus_editor_theme.commit();
//
//                        ((Activity) context).finishAffinity();
//                        Intent intent = new Intent(context, AppActivity.class);
//                        context.startActivity(intent);
//
//                    } else {
//                        editor_theme.putString("Theme", themes.get(position).toString());
//                        editor_theme.commit();
//                        notifyDataSetChanged();
//                    }
//                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return themes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView theme_value, active_img, theme_prem;
        TextView tvCost;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            tvCost = itemView.findViewById(R.id.tvCost);
            theme_value = itemView.findViewById(R.id.theme_value);
            active_img = itemView.findViewById(R.id.active_img);
            theme_prem = itemView.findViewById(R.id.theme_prem);

        }

    }

}

