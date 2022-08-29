package com.statusmaker_photoeditor_music.videoplayer.themes;

import android.annotation.SuppressLint;
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

public class DownloadersScreen1 {
    public void theme1(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.yellow));

        downloader_parent.setBackgroundResource(R.drawable.theme1);
        login_btn1.setBackgroundResource(R.drawable.theme1);
        tv_paste.setBackgroundResource(R.drawable.theme1);

    }

    public void theme2(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.theme2));

        downloader_parent.setBackgroundResource(R.drawable.theme2);
        login_btn1.setBackgroundResource(R.drawable.theme2);
        tv_paste.setBackgroundResource(R.drawable.theme2);

    }
    
    public void flat_theme1(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_1));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_1);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_1);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_1);
    }

    public void flat_theme2(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_2));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_2);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_2);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_2);
    }

    public void flat_theme3(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_3));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_3);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_3);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_3);
    }

    public void flat_theme4(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_4));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_4);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_4);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_4);
    }

    public void flat_theme5(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_5));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_5);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_5);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_5);
    }

    public void flat_theme6(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_6));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_6);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_6);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_6);
    }

    public void flat_theme7(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_7));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_7);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_7);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_7);
    }
    public void flat_theme8(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_8));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_8);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_8);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_8);
    }
    public void flat_theme9(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_9));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_9);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_9);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_9);
    }
    public void flat_theme10(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_10));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_10);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_10);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_10);
    }
    public void flat_theme11(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_11));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_11);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_11);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_11);
    }
    public void flat_theme12(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_12));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_12);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_12);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_12);
    }
    public void flat_theme13(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_13));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_13);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_13);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_13);
    }
    public void flat_theme14(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_14));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_14);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_14);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_14);
    }
    public void flat_theme15(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_15));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_15);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_15);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_15);
    }
    public void flat_theme16(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_16));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_16);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_16);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_16);
    }
    public void flat_theme17(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_17));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_17);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_17);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_17);
    }
    public void flat_theme18(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_18));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_18);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_18);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_18);
    }
    public void flat_theme19(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_19));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_19);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_19);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_19);
    }
    public void flat_theme20(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_20));

        downloader_parent.setBackgroundResource(R.drawable.flat_theme_20);
        login_btn1.setBackgroundResource(R.drawable.flat_theme_20);
        tv_paste.setBackgroundResource(R.drawable.flat_theme_20);
    }


    public void grad_theme1(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_1));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_1);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_1);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_1);
    }

    public void grad_theme2(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_2));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_2);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_2);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_2);
    }

    public void grad_theme3(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_3));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_3);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_3);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_3);
    }

    public void grad_theme4(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_4));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_4);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_4);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_4);
    }

    public void grad_theme5(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_5));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_5);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_5);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_5);
    }

    public void grad_theme6(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_6));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_6);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_6);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_6);
    }

    public void grad_theme7(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_7));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_7);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_7);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_7);
    }
    public void grad_theme8(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_8));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_8);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_8);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_8);
    }
    public void grad_theme9(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_9));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_9);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_9);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_9);
    }
    public void grad_theme10(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_10));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_10);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_10);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_10);
    }
    public void grad_theme11(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_11));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_11);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_11);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_11);
    }
    public void grad_theme12(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_12));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_12);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_12);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_12);
    }
    public void grad_theme13(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_13));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_13);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_13);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_13);
    }
    public void grad_theme14(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_14));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_14);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_14);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_14);
    }
    public void grad_theme15(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_15));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_15);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_15);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_15);
    }
    public void grad_theme16(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_16));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_16);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_16);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_16);
    }
    public void grad_theme17(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_17));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_17);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_17);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_17);
    }
    public void grad_theme18(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_18));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_18);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_18);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_18);
    }
    public void grad_theme19(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_19));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_19);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_19);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_19);
    }
    public void grad_theme20(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){

        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_20));

        downloader_parent.setBackgroundResource(R.drawable.grad_theme_20);
        login_btn1.setBackgroundResource(R.drawable.grad_theme_20);
        tv_paste.setBackgroundResource(R.drawable.grad_theme_20);
    }

    
    public void picto_theme1(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));

        GlideApp.with(activity).load(R.drawable.picto1).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme2(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));

        GlideApp.with(activity).load(R.drawable.picto2).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }
    
    public void picto_theme3(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));

        GlideApp.with(activity).load(R.drawable.picto3).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }
    
    public void picto_theme4(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));

        GlideApp.with(activity).load(R.drawable.picto4).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }
    
    public void picto_theme5(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));

        GlideApp.with(activity).load(R.drawable.picto5).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }
    
    public void picto_theme6(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));

        GlideApp.with(activity).load(R.drawable.picto6).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }
    
    public void picto_theme7(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));

        GlideApp.with(activity).load(R.drawable.picto7).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }
    
    public void picto_theme8(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));

        GlideApp.with(activity).load(R.drawable.picto8).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }
    
    public void picto_theme9(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));

        GlideApp.with(activity).load(R.drawable.picto9).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme10(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));

        GlideApp.with(activity).load(R.drawable.picto10).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme11(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));

        GlideApp.with(activity).load(R.drawable.picto11).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme12(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));

        GlideApp.with(activity).load(R.drawable.picto12).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme13(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));

        GlideApp.with(activity).load(R.drawable.picto13).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme14(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));

        GlideApp.with(activity).load(R.drawable.picto14).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme15(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));

        GlideApp.with(activity).load(R.drawable.picto15).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme16(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));

        GlideApp.with(activity).load(R.drawable.picto16).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme17(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));

        GlideApp.with(activity).load(R.drawable.picto17).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme18(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));

        GlideApp.with(activity).load(R.drawable.picto18).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme19(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));

        GlideApp.with(activity).load(R.drawable.picto19).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme20(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));

        GlideApp.with(activity).load(R.drawable.picto20).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme21(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));

        GlideApp.with(activity).load(R.drawable.picto21).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme22(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));

        GlideApp.with(activity).load(R.drawable.picto22).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    
    public void picto_theme23(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));

        GlideApp.with(activity).load(R.drawable.picto23).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }
    
    public void picto_theme24(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));

        GlideApp.with(activity).load(R.drawable.picto24).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);

                }
            }
        });
    }

    public void customTheme(Activity activity, RelativeLayout downloader_parent, TextView login_btn1, TextView tv_paste){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        login_btn1.setBackgroundColor(activity.getResources().getColor(R.color.black));
        tv_paste.setBackgroundColor(activity.getResources().getColor(R.color.black));

        SharedPreferences theme_pref2 = PreferenceManager.getDefaultSharedPreferences(activity);

        String current_theme2 = theme_pref2.getString("CustImg", "default");

        GlideApp.with(activity).load(Uri.fromFile(new File(current_theme2))).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    downloader_parent.setBackground(resource);
                }
            }
        });
    }


}
