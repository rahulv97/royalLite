package com.statusmaker_photoeditor_music.videoplayer.themes;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.Window;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.music_player.glide.GlideApp;

import java.io.File;

public class CollagePicSelScreen {
    public void theme1(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                       LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.yellow));

        toolbar.setBackgroundResource(R.drawable.theme1);
        constraintLayout.setBackgroundResource(R.drawable.theme1);
        gridView.setBackgroundResource(R.drawable.theme1);
        linearLayout.setBackgroundResource(R.drawable.theme1);
        horizontalScrollView.setBackgroundResource(R.drawable.theme1);

    }

    public void theme2(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                       LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.theme2));

        toolbar.setBackgroundResource(R.drawable.theme2);
        constraintLayout.setBackgroundResource(R.drawable.theme2);
        gridView.setBackgroundResource(R.drawable.theme2);
        linearLayout.setBackgroundResource(R.drawable.theme2);
        horizontalScrollView.setBackgroundResource(R.drawable.theme2);

    }

    public void flat_theme1(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_1));

        toolbar.setBackgroundResource(R.drawable.flat_theme_1);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_1);
        gridView.setBackgroundResource(R.drawable.flat_theme_1);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_1);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_1);
    }

    public void flat_theme2(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_2));

        toolbar.setBackgroundResource(R.drawable.flat_theme_2);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_2);
        gridView.setBackgroundResource(R.drawable.flat_theme_2);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_2);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_2);
    }

    public void flat_theme3(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_3));

        toolbar.setBackgroundResource(R.drawable.flat_theme_3);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_3);
        gridView.setBackgroundResource(R.drawable.flat_theme_3);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_3);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_3);
    }

    public void flat_theme4(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_4));

        toolbar.setBackgroundResource(R.drawable.flat_theme_4);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_4);
        gridView.setBackgroundResource(R.drawable.flat_theme_4);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_4);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_4);
    }

    public void flat_theme5(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_5));

        toolbar.setBackgroundResource(R.drawable.flat_theme_5);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_5);
        gridView.setBackgroundResource(R.drawable.flat_theme_5);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_5);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_5);
    }

    public void flat_theme6(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_6));

        toolbar.setBackgroundResource(R.drawable.flat_theme_6);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_6);
        gridView.setBackgroundResource(R.drawable.flat_theme_6);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_6);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_6);
    }

    public void flat_theme7(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_7));

        toolbar.setBackgroundResource(R.drawable.flat_theme_7);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_7);
        gridView.setBackgroundResource(R.drawable.flat_theme_7);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_7);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_7);
    }

    public void flat_theme8(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_8));

        toolbar.setBackgroundResource(R.drawable.flat_theme_8);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_8);
        gridView.setBackgroundResource(R.drawable.flat_theme_8);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_8);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_8);
    }

    public void flat_theme9(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_9));

        toolbar.setBackgroundResource(R.drawable.flat_theme_9);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_9);
        gridView.setBackgroundResource(R.drawable.flat_theme_9);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_9);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_9);
    }

    public void flat_theme10(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_10));

        toolbar.setBackgroundResource(R.drawable.flat_theme_10);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_10);
        gridView.setBackgroundResource(R.drawable.flat_theme_10);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_10);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_10);
    }

    public void flat_theme11(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_11));

        toolbar.setBackgroundResource(R.drawable.flat_theme_11);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_11);
        gridView.setBackgroundResource(R.drawable.flat_theme_11);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_11);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_11);
    }

    public void flat_theme12(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_12));

        toolbar.setBackgroundResource(R.drawable.flat_theme_12);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_12);
        gridView.setBackgroundResource(R.drawable.flat_theme_12);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_12);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_12);
    }

    public void flat_theme13(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_13));

        toolbar.setBackgroundResource(R.drawable.flat_theme_13);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_13);
        gridView.setBackgroundResource(R.drawable.flat_theme_13);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_13);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_13);
    }

    public void flat_theme14(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_14));

        toolbar.setBackgroundResource(R.drawable.flat_theme_14);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_14);
        gridView.setBackgroundResource(R.drawable.flat_theme_14);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_14);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_14);
    }

    public void flat_theme15(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_15));

        toolbar.setBackgroundResource(R.drawable.flat_theme_15);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_15);
        gridView.setBackgroundResource(R.drawable.flat_theme_15);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_15);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_15);
    }

    public void flat_theme16(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_16));

        toolbar.setBackgroundResource(R.drawable.flat_theme_16);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_16);
        gridView.setBackgroundResource(R.drawable.flat_theme_16);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_16);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_16);
    }

    public void flat_theme17(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_17));

        toolbar.setBackgroundResource(R.drawable.flat_theme_17);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_17);
        gridView.setBackgroundResource(R.drawable.flat_theme_17);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_17);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_17);
    }

    public void flat_theme18(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_18));

        toolbar.setBackgroundResource(R.drawable.flat_theme_18);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_18);
        gridView.setBackgroundResource(R.drawable.flat_theme_18);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_18);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_18);
    }
    public void flat_theme19(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_19));

        toolbar.setBackgroundResource(R.drawable.flat_theme_19);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_19);
        gridView.setBackgroundResource(R.drawable.flat_theme_19);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_19);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_19);
    }

    public void flat_theme20(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_20));

        toolbar.setBackgroundResource(R.drawable.flat_theme_20);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_20);
        gridView.setBackgroundResource(R.drawable.flat_theme_20);
        linearLayout.setBackgroundResource(R.drawable.flat_theme_20);
        horizontalScrollView.setBackgroundResource(R.drawable.flat_theme_20);
    }

    public void grad_theme1(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_1));

        toolbar.setBackgroundResource(R.drawable.grad_theme_1);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_1);
        gridView.setBackgroundResource(R.drawable.grad_theme_1);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_1);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_1);
    }

    public void grad_theme2(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_2));

        toolbar.setBackgroundResource(R.drawable.grad_theme_2);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_2);
        gridView.setBackgroundResource(R.drawable.grad_theme_2);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_2);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_2);
    }

    public void grad_theme3(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_3));

        toolbar.setBackgroundResource(R.drawable.grad_theme_3);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_3);
        gridView.setBackgroundResource(R.drawable.grad_theme_3);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_3);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_3);
    }

    public void grad_theme4(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_4));

        toolbar.setBackgroundResource(R.drawable.grad_theme_4);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_4);
        gridView.setBackgroundResource(R.drawable.grad_theme_4);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_4);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_4);
    }

    public void grad_theme5(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_5));

        toolbar.setBackgroundResource(R.drawable.grad_theme_5);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_5);
        gridView.setBackgroundResource(R.drawable.grad_theme_5);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_5);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_5);
    }

    public void grad_theme6(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_6));

        toolbar.setBackgroundResource(R.drawable.grad_theme_6);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_6);
        gridView.setBackgroundResource(R.drawable.grad_theme_6);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_6);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_6);
    }

    public void grad_theme7(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_7));

        toolbar.setBackgroundResource(R.drawable.grad_theme_7);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_7);
        gridView.setBackgroundResource(R.drawable.grad_theme_7);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_7);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_7);
    }

    public void grad_theme8(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_8));

        toolbar.setBackgroundResource(R.drawable.grad_theme_8);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_8);
        gridView.setBackgroundResource(R.drawable.grad_theme_8);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_8);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_8);
    }

    public void grad_theme9(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_9));

        toolbar.setBackgroundResource(R.drawable.grad_theme_9);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_9);
        gridView.setBackgroundResource(R.drawable.grad_theme_9);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_9);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_9);
    }

    public void grad_theme10(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_10));

        toolbar.setBackgroundResource(R.drawable.grad_theme_10);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_10);
        gridView.setBackgroundResource(R.drawable.grad_theme_10);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_10);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_10);
    }

    public void grad_theme11(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_11));

        toolbar.setBackgroundResource(R.drawable.grad_theme_11);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_11);
        gridView.setBackgroundResource(R.drawable.grad_theme_11);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_11);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_11);
    }

    public void grad_theme12(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_12));

        toolbar.setBackgroundResource(R.drawable.grad_theme_12);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_12);
        gridView.setBackgroundResource(R.drawable.grad_theme_12);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_12);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_12);
    }

    public void grad_theme13(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_13));

        toolbar.setBackgroundResource(R.drawable.grad_theme_13);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_13);
        gridView.setBackgroundResource(R.drawable.grad_theme_13);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_13);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_13);
    }

    public void grad_theme14(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_14));

        toolbar.setBackgroundResource(R.drawable.grad_theme_14);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_14);
        gridView.setBackgroundResource(R.drawable.grad_theme_14);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_14);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_14);
    }

    public void grad_theme15(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_15));

        toolbar.setBackgroundResource(R.drawable.grad_theme_15);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_15);
        gridView.setBackgroundResource(R.drawable.grad_theme_15);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_15);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_15);
    }

    public void grad_theme16(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_16));

        toolbar.setBackgroundResource(R.drawable.grad_theme_16);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_16);
        gridView.setBackgroundResource(R.drawable.grad_theme_16);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_16);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_16);
    }

    public void grad_theme17(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_17));

        toolbar.setBackgroundResource(R.drawable.grad_theme_17);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_17);
        gridView.setBackgroundResource(R.drawable.grad_theme_17);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_17);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_17);
    }

    public void grad_theme18(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_18));

        toolbar.setBackgroundResource(R.drawable.grad_theme_18);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_18);
        gridView.setBackgroundResource(R.drawable.grad_theme_18);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_18);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_18);
    }
    public void grad_theme19(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_19));

        toolbar.setBackgroundResource(R.drawable.grad_theme_19);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_19);
        gridView.setBackgroundResource(R.drawable.grad_theme_19);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_19);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_19);
    }

    public void grad_theme20(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_20));

        toolbar.setBackgroundResource(R.drawable.grad_theme_20);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_20);
        gridView.setBackgroundResource(R.drawable.grad_theme_20);
        linearLayout.setBackgroundResource(R.drawable.grad_theme_20);
        horizontalScrollView.setBackgroundResource(R.drawable.grad_theme_20);
    }

    public void picto_theme1(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto1).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);
                }
            }
        });
    }
    
    public void picto_theme2(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto2).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);
                }
            }
        });
    }
    public void picto_theme3(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto3).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);
                }
            }
        });
    }
    public void picto_theme4(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto4).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme5(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto5).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme6(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto6).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme7(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto7).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme8(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto8).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme9(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto9).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme10(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto10).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme11(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto11).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme12(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto12).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme13(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto13).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme14(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto14).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme15(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto15).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme16(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto16).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme17(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto17).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme18(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto18).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme19(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto19).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme20(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto20).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme21(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto21).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme22(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto22).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme23(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto23).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme24(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                             LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        GlideApp.with(activity).load(R.drawable.picto24).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void customTheme(Activity activity, Toolbar toolbar, ConstraintLayout constraintLayout, GridView gridView,
                            LinearLayout linearLayout, HorizontalScrollView horizontalScrollView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        horizontalScrollView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        gridView.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        linearLayout.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        SharedPreferences theme_pref2 = PreferenceManager.getDefaultSharedPreferences(activity);

        String current_theme2 = theme_pref2.getString("CustImg", "default");

        GlideApp.with(activity).load(Uri.fromFile(new File(current_theme2))).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    constraintLayout.setBackground(resource);
                }
            }
        });
    }

}
