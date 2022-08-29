package com.statusmaker_photoeditor_music.videoplayer.themes;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.music_player.glide.GlideApp;

import java.io.File;

public class PuzzleViewScreen {
    public void theme1(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
            ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
            ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
            ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.yellow));

        linearLayout.setBackgroundResource(R.drawable.theme1);
        recyclerView.setBackgroundResource(R.drawable.theme1);
        constraintLayout1.setBackgroundResource(R.drawable.theme1);
        constraintLayout2.setBackgroundResource(R.drawable.theme1);
        constraintLayout3.setBackgroundResource(R.drawable.theme1);
        constraintLayout4.setBackgroundResource(R.drawable.theme1);
        constraintLayout5.setBackgroundResource(R.drawable.theme1);
        constraintLayout6.setBackgroundResource(R.drawable.theme1);
        constraintLayout7.setBackgroundResource(R.drawable.theme1);
        constraintLayout8.setBackgroundResource(R.drawable.theme1);
        constraintLayout9.setBackgroundResource(R.drawable.theme1);
        constraintLayout10.setBackgroundResource(R.drawable.theme1);
    }

    public void theme2(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.theme2));

        linearLayout.setBackgroundResource(R.drawable.theme2);
        recyclerView.setBackgroundResource(R.drawable.theme2);
        constraintLayout1.setBackgroundResource(R.drawable.theme2);
        constraintLayout2.setBackgroundResource(R.drawable.theme2);
        constraintLayout3.setBackgroundResource(R.drawable.theme2);
        constraintLayout4.setBackgroundResource(R.drawable.theme2);
        constraintLayout5.setBackgroundResource(R.drawable.theme2);
        constraintLayout6.setBackgroundResource(R.drawable.theme2);
        constraintLayout7.setBackgroundResource(R.drawable.theme2);
        constraintLayout8.setBackgroundResource(R.drawable.theme2);
        constraintLayout9.setBackgroundResource(R.drawable.theme2);
        constraintLayout10.setBackgroundResource(R.drawable.theme2);


    }


    public void flat_theme1(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_1));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_1);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_1);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_1);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_1);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_1);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_1);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_1);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_1);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_1);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_1);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_1);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_1);
    }
    public void flat_theme2(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_2));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_2);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_2);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_2);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_2);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_2);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_2);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_2);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_2);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_2);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_2);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_2);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_2);
    }
    public void flat_theme3(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_3));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_3);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_3);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_3);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_3);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_3);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_3);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_3);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_3);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_3);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_3);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_3);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_3);
    }
    public void flat_theme4(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_4));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_4);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_4);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_4);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_4);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_4);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_4);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_4);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_4);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_4);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_4);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_4);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_4);
    }
    public void flat_theme5(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_5));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_5);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_5);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_5);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_5);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_5);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_5);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_5);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_5);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_5);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_5);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_5);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_5);
    }
    public void flat_theme6(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_6));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_6);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_6);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_6);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_6);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_6);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_6);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_6);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_6);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_6);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_6);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_6);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_6);
    }
    public void flat_theme7(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_7));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_7);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_7);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_7);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_7);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_7);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_7);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_7);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_7);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_7);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_7);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_7);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_7);
    }
    public void flat_theme8(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_8));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_8);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_8);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_8);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_8);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_8);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_8);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_8);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_8);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_8);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_8);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_8);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_8);
    }
    public void flat_theme9(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_9));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_9);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_9);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_9);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_9);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_9);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_9);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_9);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_9);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_9);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_9);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_9);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_9);
    }
    public void flat_theme10(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_10));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_10);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_10);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_10);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_10);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_10);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_10);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_10);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_10);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_10);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_10);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_10);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_10);
    }
    public void flat_theme11(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_11));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_11);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_11);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_11);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_11);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_11);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_11);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_11);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_11);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_11);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_11);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_11);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_11);
    }
    public void flat_theme12(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_12));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_12);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_12);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_12);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_12);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_12);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_12);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_12);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_12);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_12);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_12);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_12);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_12);
    }
    public void flat_theme13(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_13));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_13);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_13);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_13);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_13);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_13);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_13);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_13);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_13);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_13);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_13);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_13);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_13);
    }
    public void flat_theme14(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_14));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_14);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_14);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_14);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_14);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_14);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_14);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_14);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_14);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_14);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_14);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_14);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_14);
    }
    public void flat_theme15(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_15));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_15);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_15);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_15);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_15);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_15);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_15);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_15);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_15);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_15);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_15);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_15);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_15);
    }
    public void flat_theme16(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_16));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_16);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_16);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_16);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_16);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_16);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_16);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_16);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_16);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_16);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_16);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_16);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_16);
    }
    public void flat_theme17(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_17));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_17);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_17);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_17);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_17);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_17);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_17);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_17);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_17);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_17);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_17);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_17);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_17);
    }
    public void flat_theme18(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_18));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_18);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_18);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_18);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_18);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_18);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_18);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_18);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_18);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_18);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_18);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_18);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_18);
    }
    public void flat_theme19(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_19));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_19);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_19);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_19);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_19);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_19);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_19);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_19);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_19);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_19);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_19);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_19);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_19);
    }
    public void flat_theme20(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                       ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                       ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                       ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_20));

        linearLayout.setBackgroundResource(R.drawable.flat_theme_20);
        recyclerView.setBackgroundResource(R.drawable.flat_theme_20);
        constraintLayout1.setBackgroundResource(R.drawable.flat_theme_20);
        constraintLayout2.setBackgroundResource(R.drawable.flat_theme_20);
        constraintLayout3.setBackgroundResource(R.drawable.flat_theme_20);
        constraintLayout4.setBackgroundResource(R.drawable.flat_theme_20);
        constraintLayout5.setBackgroundResource(R.drawable.flat_theme_20);
        constraintLayout6.setBackgroundResource(R.drawable.flat_theme_20);
        constraintLayout7.setBackgroundResource(R.drawable.flat_theme_20);
        constraintLayout8.setBackgroundResource(R.drawable.flat_theme_20);
        constraintLayout9.setBackgroundResource(R.drawable.flat_theme_20);
        constraintLayout10.setBackgroundResource(R.drawable.flat_theme_20);
    }



    public void grad_theme1(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                            ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                            ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                            ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_1));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_1);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_1);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_1);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_1);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_1);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_1);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_1);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_1);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_1);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_1);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_1);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_1);
    }
    public void grad_theme2(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                            ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                            ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                            ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_2));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_2);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_2);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_2);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_2);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_2);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_2);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_2);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_2);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_2);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_2);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_2);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_2);
    }
    public void grad_theme3(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                            ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                            ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                            ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_3));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_3);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_3);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_3);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_3);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_3);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_3);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_3);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_3);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_3);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_3);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_3);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_3);
    }
    public void grad_theme4(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                            ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                            ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                            ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_4));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_4);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_4);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_4);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_4);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_4);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_4);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_4);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_4);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_4);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_4);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_4);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_4);
    }
    public void grad_theme5(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                            ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                            ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                            ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_5));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_5);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_5);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_5);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_5);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_5);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_5);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_5);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_5);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_5);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_5);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_5);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_5);
    }
    public void grad_theme6(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                            ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                            ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                            ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_6));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_6);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_6);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_6);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_6);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_6);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_6);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_6);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_6);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_6);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_6);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_6);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_6);
    }
    public void grad_theme7(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                            ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                            ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                            ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_7));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_7);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_7);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_7);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_7);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_7);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_7);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_7);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_7);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_7);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_7);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_7);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_7);
    }
    public void grad_theme8(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                            ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                            ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                            ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_8));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_8);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_8);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_8);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_8);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_8);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_8);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_8);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_8);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_8);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_8);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_8);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_8);
    }
    public void grad_theme9(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                            ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                            ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                            ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_9));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_9);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_9);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_9);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_9);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_9);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_9);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_9);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_9);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_9);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_9);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_9);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_9);
    }
    public void grad_theme10(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_10));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_10);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_10);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_10);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_10);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_10);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_10);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_10);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_10);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_10);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_10);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_10);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_10);
    }
    public void grad_theme11(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_11));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_11);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_11);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_11);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_11);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_11);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_11);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_11);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_11);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_11);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_11);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_11);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_11);
    }
    public void grad_theme12(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_12));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_12);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_12);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_12);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_12);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_12);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_12);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_12);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_12);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_12);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_12);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_12);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_12);
    }
    public void grad_theme13(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_13));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_13);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_13);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_13);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_13);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_13);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_13);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_13);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_13);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_13);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_13);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_13);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_13);
    }
    public void grad_theme14(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_14));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_14);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_14);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_14);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_14);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_14);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_14);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_14);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_14);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_14);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_14);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_14);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_14);
    }
    public void grad_theme15(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_15));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_15);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_15);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_15);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_15);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_15);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_15);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_15);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_15);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_15);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_15);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_15);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_15);
    }
    public void grad_theme16(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_16));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_16);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_16);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_16);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_16);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_16);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_16);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_16);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_16);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_16);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_16);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_16);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_16);
    }
    public void grad_theme17(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_17));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_17);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_17);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_17);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_17);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_17);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_17);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_17);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_17);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_17);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_17);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_17);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_17);
    }
    public void grad_theme18(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_18));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_18);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_18);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_18);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_18);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_18);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_18);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_18);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_18);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_18);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_18);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_18);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_18);
    }
    public void grad_theme19(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_19));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_19);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_19);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_19);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_19);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_19);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_19);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_19);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_19);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_19);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_19);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_19);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_19);
    }
    public void grad_theme20(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_20));

        linearLayout.setBackgroundResource(R.drawable.grad_theme_20);
        recyclerView.setBackgroundResource(R.drawable.grad_theme_20);
        constraintLayout1.setBackgroundResource(R.drawable.grad_theme_20);
        constraintLayout2.setBackgroundResource(R.drawable.grad_theme_20);
        constraintLayout3.setBackgroundResource(R.drawable.grad_theme_20);
        constraintLayout4.setBackgroundResource(R.drawable.grad_theme_20);
        constraintLayout5.setBackgroundResource(R.drawable.grad_theme_20);
        constraintLayout6.setBackgroundResource(R.drawable.grad_theme_20);
        constraintLayout7.setBackgroundResource(R.drawable.grad_theme_20);
        constraintLayout8.setBackgroundResource(R.drawable.grad_theme_20);
        constraintLayout9.setBackgroundResource(R.drawable.grad_theme_20);
        constraintLayout10.setBackgroundResource(R.drawable.grad_theme_20);

    }


    public void picto_theme1(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr1));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));

        GlideApp.with(activity).load(R.drawable.picto1).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme2(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr2));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));

        GlideApp.with(activity).load(R.drawable.picto2).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme3(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr3));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));

        GlideApp.with(activity).load(R.drawable.picto3).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme4(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr4));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));

        GlideApp.with(activity).load(R.drawable.picto4).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme5(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr5));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));

        GlideApp.with(activity).load(R.drawable.picto5).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme6(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr6));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));

        GlideApp.with(activity).load(R.drawable.picto6).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme7(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr7));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));

        GlideApp.with(activity).load(R.drawable.picto7).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme8(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr8));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));

        GlideApp.with(activity).load(R.drawable.picto8).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme9(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr9));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));

        GlideApp.with(activity).load(R.drawable.picto9).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme10(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                              ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                              ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                              ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr10));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));

        GlideApp.with(activity).load(R.drawable.picto10).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme11(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                              ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                              ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                              ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr11));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));

        GlideApp.with(activity).load(R.drawable.picto11).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme12(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                              ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                              ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                              ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr12));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));

        GlideApp.with(activity).load(R.drawable.picto12).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme13(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                              ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                              ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                              ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr13));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));

        GlideApp.with(activity).load(R.drawable.picto13).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme14(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                              ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                              ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                              ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr14));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));

        GlideApp.with(activity).load(R.drawable.picto14).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme15(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                              ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                              ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                              ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr15));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));

        GlideApp.with(activity).load(R.drawable.picto15).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme16(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                              ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                              ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                              ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr16));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));

        GlideApp.with(activity).load(R.drawable.picto16).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme17(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                              ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                              ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                              ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr17));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));

        GlideApp.with(activity).load(R.drawable.picto17).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme18(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                              ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                              ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                              ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr18));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));

        GlideApp.with(activity).load(R.drawable.picto18).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme19(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                              ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                              ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                              ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr19));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));

        GlideApp.with(activity).load(R.drawable.picto19).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme20(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                              ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                              ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                              ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr20));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));

        GlideApp.with(activity).load(R.drawable.picto20).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme21(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr21));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));

        GlideApp.with(activity).load(R.drawable.picto21).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme22(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr22));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));

        GlideApp.with(activity).load(R.drawable.picto22).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme23(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr23));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));

        GlideApp.with(activity).load(R.drawable.picto23).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme24(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                             ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                             ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                             ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr24));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));

        GlideApp.with(activity).load(R.drawable.picto24).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);

                }
            }
        });
    }

    public void customTheme(Activity activity, LinearLayout linearLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout1,
                            ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4,
                            ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7,
                            ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.black));
        recyclerView.setBackgroundColor(activity.getResources().getColor(R.color.black));
        constraintLayout1.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        constraintLayout2.setBackgroundColor(activity.getResources().getColor(R.color.black));
        constraintLayout3.setBackgroundColor(activity.getResources().getColor(R.color.black));
        constraintLayout4.setBackgroundColor(activity.getResources().getColor(R.color.black));
        constraintLayout5.setBackgroundColor(activity.getResources().getColor(R.color.black));
        constraintLayout6.setBackgroundColor(activity.getResources().getColor(R.color.black));
        constraintLayout7.setBackgroundColor(activity.getResources().getColor(R.color.black));
        constraintLayout8.setBackgroundColor(activity.getResources().getColor(R.color.black));
        constraintLayout9.setBackgroundColor(activity.getResources().getColor(R.color.black));

        SharedPreferences theme_pref2 = PreferenceManager.getDefaultSharedPreferences(activity);

        String current_theme2 = theme_pref2.getString("CustImg", "default");

        GlideApp.with(activity).load(Uri.fromFile(new File(current_theme2))).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout10.setBackground(resource);
                }
            }
        });
    }

}
