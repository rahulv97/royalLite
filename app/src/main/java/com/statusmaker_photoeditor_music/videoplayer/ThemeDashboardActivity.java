package com.statusmaker_photoeditor_music.videoplayer;

import static com.statusmaker_photoeditor_music.videoplayer.ShowThemesActivity.tvCoin;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.preference.PreferenceManager;

import com.bumptech.glide.Glide;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.AppActivity;
import com.yalantis.ucrop.UCrop;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ThemeDashboardActivity extends AppCompatActivity {

    CardView flat_btn, grad_btn, picto_btn, cust_btn;
    ImageView back_btn, imageView;
    public static final int REQUEST_IMAGE = 404;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_dashboard);

        flat_btn = findViewById(R.id.flat_btn);
        grad_btn = findViewById(R.id.grad_btn);
        back_btn = findViewById(R.id.back_btn);
        picto_btn = findViewById(R.id.picto_btn);
        cust_btn = findViewById(R.id.cust_btn);
        imageView = findViewById(R.id.imageView);
        SharedPreferences sh = getSharedPreferences("Coins", MODE_APPEND);
        SharedPreferences ss = getSharedPreferences("Coins", MODE_PRIVATE);
        SharedPreferences.Editor edit = ss.edit();
        int c = sh.getInt("Number", 0);
        cust_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(ThemeDashboardActivity.this)
                        .setTitle("Premium Theme!")
                        .setMessage("You can purchase the theme for 100000 Coins. Do you want to proceed?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                if (c >= 100000) {
                                    Intent intent = new Intent();
                                    intent.setType("image/*");
                                    intent.setAction(Intent.ACTION_GET_CONTENT);
                                    startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_IMAGE);
                                    edit.putInt("Number", c - 10);
                                    edit.commit();
                                } else {
                                    Toast.makeText(getApplicationContext(), "You don't have sufficient coins!!", Toast.LENGTH_SHORT).show();
                                }


                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .show();
            }
        });

        picto_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemeDashboardActivity.this, ShowThemesActivity.class);
                intent.putExtra("ThemeName", "Pictorial Themes");
                startActivity(intent);
            }
        });
        flat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemeDashboardActivity.this, ShowThemesActivity.class);
                intent.putExtra("ThemeName", "Flat Themes");
                startActivity(intent);
            }
        });

        grad_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemeDashboardActivity.this, ShowThemesActivity.class);
                intent.putExtra("ThemeName", "Gradient Themes");
                startActivity(intent);
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemeDashboardActivity.super.onBackPressed();
            }
        });

        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme = theme_pref.getString("Theme", "default");


        SharedPreferences theme_pref2 = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme2 = theme_pref2.getString("CustImg", "default");

        if (current_theme.equals("CustomTheme")) {
            Glide.with(ThemeDashboardActivity.this).load(Uri.fromFile(new File(current_theme2))).into(imageView);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGE) {

            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int height = displayMetrics.heightPixels;
            int width = displayMetrics.widthPixels;

            Uri uri = data.getData();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
            String currentDateandTime = sdf.format(new Date());

            SharedPreferences theme_pref1 = PreferenceManager.getDefaultSharedPreferences(ThemeDashboardActivity.this);
            SharedPreferences.Editor editor_theme1 = theme_pref1.edit();
            editor_theme1.putString("CustImg", "/storage/emulated/0/RoyalPlayer/theme_img_" + currentDateandTime + ".jpg");
            editor_theme1.commit();

            UCrop.of(uri,
                    Uri.fromFile(new File("/storage/emulated/0/RoyalPlayer/theme_img_" + currentDateandTime + ".jpg"))).withAspectRatio(width, height)
                    .start(ThemeDashboardActivity.this);
        } else {

        }

        if (resultCode == RESULT_OK && requestCode == UCrop.REQUEST_CROP) {
            final Uri resultUri = UCrop.getOutput(data);

            Glide.with(ThemeDashboardActivity.this).load(resultUri).into(imageView);

            SharedPreferences theme_pref1 = PreferenceManager.getDefaultSharedPreferences(ThemeDashboardActivity.this);
            SharedPreferences.Editor editor_theme1 = theme_pref1.edit();
            editor_theme1.putString("Theme", "CustomTheme");
            editor_theme1.commit();

        } else if (resultCode == UCrop.RESULT_ERROR) {
            final Throwable cropError = UCrop.getError(data);
            Toast.makeText(ThemeDashboardActivity.this, cropError.toString(), Toast.LENGTH_LONG).show();
        }

    }

}