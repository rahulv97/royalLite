package com.statusmaker_photoeditor_music.videoplayer.themes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.preference.PreferenceManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.ThemeDashboardActivity;
import com.statusmaker_photoeditor_music.videoplayer.music_player.glide.GlideApp;

import java.io.File;

public class VideoSelectorScreen {

    public void theme1(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.yellow));

        header_main.setBackgroundResource(R.drawable.theme1);
        video_selector_main.setBackgroundResource(R.drawable.theme1);
        app_footer.setBackgroundResource(R.drawable.theme1);
    }

    public void theme2(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.theme2));

        header_main.setBackgroundResource(R.drawable.theme2);
        video_selector_main.setBackgroundResource(R.drawable.theme2);
        app_footer.setBackgroundResource(R.drawable.theme2);
    }

    public void flat_theme1(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_1));

        header_main.setBackgroundResource(R.drawable.flat_theme_1);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_1);
        app_footer.setBackgroundResource(R.drawable.flat_theme_1);
    }

    public void flat_theme2(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_2));

        header_main.setBackgroundResource(R.drawable.flat_theme_2);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_2);
        app_footer.setBackgroundResource(R.drawable.flat_theme_2);
    }

    public void flat_theme3(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_3));

        header_main.setBackgroundResource(R.drawable.flat_theme_3);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_3);
        app_footer.setBackgroundResource(R.drawable.flat_theme_3);
    }

    public void flat_theme4(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_4));

        header_main.setBackgroundResource(R.drawable.flat_theme_4);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_4);
        app_footer.setBackgroundResource(R.drawable.flat_theme_4);
    }

    public void flat_theme5(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_5));

        header_main.setBackgroundResource(R.drawable.flat_theme_5);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_5);
        app_footer.setBackgroundResource(R.drawable.flat_theme_5);
    }

    public void flat_theme6(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_6));

        header_main.setBackgroundResource(R.drawable.flat_theme_6);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_6);
        app_footer.setBackgroundResource(R.drawable.flat_theme_6);
    }

    public void flat_theme7(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_7));

        header_main.setBackgroundResource(R.drawable.flat_theme_7);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_7);
        app_footer.setBackgroundResource(R.drawable.flat_theme_7);
    }

    public void flat_theme8(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_8));

        header_main.setBackgroundResource(R.drawable.flat_theme_8);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_8);
        app_footer.setBackgroundResource(R.drawable.flat_theme_8);
    }

    public void flat_theme9(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_9));

        header_main.setBackgroundResource(R.drawable.flat_theme_9);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_9);
        app_footer.setBackgroundResource(R.drawable.flat_theme_9);
    }

    public void flat_theme10(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_10));

        header_main.setBackgroundResource(R.drawable.flat_theme_10);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_10);
        app_footer.setBackgroundResource(R.drawable.flat_theme_10);
    }

    public void flat_theme11(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_11));

        header_main.setBackgroundResource(R.drawable.flat_theme_11);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_11);
        app_footer.setBackgroundResource(R.drawable.flat_theme_11);
    }

    public void flat_theme12(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_12));

        header_main.setBackgroundResource(R.drawable.flat_theme_12);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_12);
        app_footer.setBackgroundResource(R.drawable.flat_theme_12);
    }

    public void flat_theme13(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_13));

        header_main.setBackgroundResource(R.drawable.flat_theme_13);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_13);
        app_footer.setBackgroundResource(R.drawable.flat_theme_13);
    }

    public void flat_theme14(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_14));

        header_main.setBackgroundResource(R.drawable.flat_theme_14);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_14);
        app_footer.setBackgroundResource(R.drawable.flat_theme_14);
    }

    public void flat_theme15(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_15));

        header_main.setBackgroundResource(R.drawable.flat_theme_15);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_15);
        app_footer.setBackgroundResource(R.drawable.flat_theme_15);
    }

    public void flat_theme16(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_16));

        header_main.setBackgroundResource(R.drawable.flat_theme_16);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_16);
        app_footer.setBackgroundResource(R.drawable.flat_theme_16);
    }

    public void flat_theme17(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_17));

        header_main.setBackgroundResource(R.drawable.flat_theme_17);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_17);
        app_footer.setBackgroundResource(R.drawable.flat_theme_17);
    }
    public void flat_theme18(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_18));

        header_main.setBackgroundResource(R.drawable.flat_theme_18);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_18);
        app_footer.setBackgroundResource(R.drawable.flat_theme_18);
    }
    public void flat_theme19(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_19));

        header_main.setBackgroundResource(R.drawable.flat_theme_19);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_19);
        app_footer.setBackgroundResource(R.drawable.flat_theme_19);
    }

    public void flat_theme20(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_20));

        header_main.setBackgroundResource(R.drawable.flat_theme_20);
        video_selector_main.setBackgroundResource(R.drawable.flat_theme_20);
        app_footer.setBackgroundResource(R.drawable.flat_theme_20);
    }

    public void grad_theme1(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_1));

        header_main.setBackgroundResource(R.drawable.grad_theme_1);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_1);
        app_footer.setBackgroundResource(R.drawable.grad_theme_1);
    }

    public void grad_theme2(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_2));

        header_main.setBackgroundResource(R.drawable.grad_theme_2);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_2);
        app_footer.setBackgroundResource(R.drawable.grad_theme_2);
    }

    public void grad_theme3(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_3));

        header_main.setBackgroundResource(R.drawable.grad_theme_3);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_3);
        app_footer.setBackgroundResource(R.drawable.grad_theme_3);
    }

    public void grad_theme4(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_4));

        header_main.setBackgroundResource(R.drawable.grad_theme_4);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_4);
        app_footer.setBackgroundResource(R.drawable.grad_theme_4);
    }

    public void grad_theme5(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_5));

        header_main.setBackgroundResource(R.drawable.grad_theme_5);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_5);
        app_footer.setBackgroundResource(R.drawable.grad_theme_5);
    }

    public void grad_theme6(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_6));

        header_main.setBackgroundResource(R.drawable.grad_theme_6);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_6);
        app_footer.setBackgroundResource(R.drawable.grad_theme_6);
    }

    public void grad_theme7(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_7));

        header_main.setBackgroundResource(R.drawable.grad_theme_7);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_7);
        app_footer.setBackgroundResource(R.drawable.grad_theme_7);
    }

    public void grad_theme8(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_8));

        header_main.setBackgroundResource(R.drawable.grad_theme_8);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_8);
        app_footer.setBackgroundResource(R.drawable.grad_theme_8);
    }

    public void grad_theme9(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_9));

        header_main.setBackgroundResource(R.drawable.grad_theme_9);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_9);
        app_footer.setBackgroundResource(R.drawable.grad_theme_9);
    }

    public void grad_theme10(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_10));

        header_main.setBackgroundResource(R.drawable.grad_theme_10);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_10);
        app_footer.setBackgroundResource(R.drawable.grad_theme_10);
    }

    public void grad_theme11(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_11));

        header_main.setBackgroundResource(R.drawable.grad_theme_11);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_11);
        app_footer.setBackgroundResource(R.drawable.grad_theme_11);
    }

    public void grad_theme12(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_12));

        header_main.setBackgroundResource(R.drawable.grad_theme_12);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_12);
        app_footer.setBackgroundResource(R.drawable.grad_theme_12);
    }

    public void grad_theme13(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_13));

        header_main.setBackgroundResource(R.drawable.grad_theme_13);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_13);
        app_footer.setBackgroundResource(R.drawable.grad_theme_13);
    }

    public void grad_theme14(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_14));

        header_main.setBackgroundResource(R.drawable.grad_theme_14);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_14);
        app_footer.setBackgroundResource(R.drawable.grad_theme_14);
    }

    public void grad_theme15(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_15));

        header_main.setBackgroundResource(R.drawable.grad_theme_15);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_15);
        app_footer.setBackgroundResource(R.drawable.grad_theme_15);
    }

    public void grad_theme16(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_16));

        header_main.setBackgroundResource(R.drawable.grad_theme_16);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_16);
        app_footer.setBackgroundResource(R.drawable.grad_theme_16);
    }

    public void grad_theme17(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_17));

        header_main.setBackgroundResource(R.drawable.grad_theme_17);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_17);
        app_footer.setBackgroundResource(R.drawable.grad_theme_17);
    }
    public void grad_theme18(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_18));

        header_main.setBackgroundResource(R.drawable.grad_theme_18);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_18);
        app_footer.setBackgroundResource(R.drawable.grad_theme_18);
    }
    public void grad_theme19(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_19));

        header_main.setBackgroundResource(R.drawable.grad_theme_19);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_19);
        app_footer.setBackgroundResource(R.drawable.grad_theme_19);
    }

    public void grad_theme20(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_20));

        header_main.setBackgroundResource(R.drawable.grad_theme_20);
        video_selector_main.setBackgroundResource(R.drawable.grad_theme_20);
        app_footer.setBackgroundResource(R.drawable.grad_theme_20);
    }

    public void picto_theme1(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto1).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme2(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto2).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme3(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto3).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme4(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto4).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme5(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto5).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme6(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto6).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme7(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto7).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme8(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto8).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme9(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto9).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme10(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto10).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme11(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto11).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme12(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto12).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme13(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto13).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme14(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto14).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme15(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto15).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme16(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto16).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme17(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto17).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme18(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto18).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme19(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto19).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme20(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto20).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme21(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto21).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme22(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto22).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme23(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto23).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void picto_theme24(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        GlideApp.with(activity).load(R.drawable.picto24).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });

    }

    public void customTheme(Activity activity, RelativeLayout header_main, RelativeLayout video_selector_main, RelativeLayout app_footer){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        header_main.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        app_footer.setBackgroundColor(activity.getResources().getColor(R.color.transparent));

        SharedPreferences theme_pref2 = PreferenceManager.getDefaultSharedPreferences(activity);

        String current_theme2 = theme_pref2.getString("CustImg", "default");

        GlideApp.with(activity).load(Uri.fromFile(new File(current_theme2))).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });
    }




}
