package com.statusmaker_photoeditor_music.videoplayer.themes;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.music_player.glide.GlideApp;

import java.io.File;

public class RadioMainScreen {
    public void theme1(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout , ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.yellow));

        relativeLayout.setBackgroundResource(R.drawable.theme1);
        toolbar.setBackgroundResource(R.drawable.theme1);
        constraintLayout.setBackgroundResource(R.drawable.theme1);
        imageView.setImageResource(R.drawable.theme1);
    }

    public void theme2(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.theme2));

        relativeLayout.setBackgroundResource(R.drawable.theme2);
        toolbar.setBackgroundResource(R.drawable.theme2);
        constraintLayout.setBackgroundResource(R.drawable.theme2);
        imageView.setImageResource(R.drawable.theme2);
    }

    public void flat_theme1(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_1));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_1);
        toolbar.setBackgroundResource(R.drawable.flat_theme_1);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_1);
        imageView.setImageResource(R.drawable.flat_theme_1);
    }
    public void flat_theme2(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_2));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_2);
        toolbar.setBackgroundResource(R.drawable.flat_theme_2);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_2);
        imageView.setImageResource(R.drawable.flat_theme_2);
    }
    public void flat_theme3(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_3));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_3);
        toolbar.setBackgroundResource(R.drawable.flat_theme_3);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_3);
        imageView.setImageResource(R.drawable.flat_theme_3);
    }
    public void flat_theme4(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_4));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_4);
        toolbar.setBackgroundResource(R.drawable.flat_theme_4);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_4);
        imageView.setImageResource(R.drawable.flat_theme_4);
    }
    public void flat_theme5(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_5));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_5);
        toolbar.setBackgroundResource(R.drawable.flat_theme_5);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_5);
        imageView.setImageResource(R.drawable.flat_theme_5);
    }
    public void flat_theme6(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_6));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_6);
        toolbar.setBackgroundResource(R.drawable.flat_theme_6);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_6);
        imageView.setImageResource(R.drawable.flat_theme_6);
    }
    public void flat_theme7(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_7));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_7);
        toolbar.setBackgroundResource(R.drawable.flat_theme_7);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_7);
        imageView.setImageResource(R.drawable.flat_theme_7);
    }
    public void flat_theme8(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_8));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_8);
        toolbar.setBackgroundResource(R.drawable.flat_theme_8);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_8);
        imageView.setImageResource(R.drawable.flat_theme_8);
    }
    public void flat_theme9(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_9));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_9);
        toolbar.setBackgroundResource(R.drawable.flat_theme_9);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_9);
        imageView.setImageResource(R.drawable.flat_theme_9);
    }
    public void flat_theme10(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_10));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_10);
        toolbar.setBackgroundResource(R.drawable.flat_theme_10);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_10);
        imageView.setImageResource(R.drawable.flat_theme_10);
    }
    public void flat_theme11(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_11));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_11);
        toolbar.setBackgroundResource(R.drawable.flat_theme_11);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_11);
        imageView.setImageResource(R.drawable.flat_theme_11);
    }
    public void flat_theme12(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_12));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_12);
        toolbar.setBackgroundResource(R.drawable.flat_theme_12);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_12);
        imageView.setImageResource(R.drawable.flat_theme_12);
    }
    public void flat_theme13(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_13));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_13);
        toolbar.setBackgroundResource(R.drawable.flat_theme_13);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_13);
        imageView.setImageResource(R.drawable.flat_theme_13);
    }
    public void flat_theme14(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_14));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_14);
        toolbar.setBackgroundResource(R.drawable.flat_theme_14);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_14);
        imageView.setImageResource(R.drawable.flat_theme_14);
    }
    public void flat_theme15(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_15));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_15);
        toolbar.setBackgroundResource(R.drawable.flat_theme_15);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_15);
        imageView.setImageResource(R.drawable.flat_theme_15);
    }
    public void flat_theme16(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_16));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_16);
        toolbar.setBackgroundResource(R.drawable.flat_theme_16);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_16);
        imageView.setImageResource(R.drawable.flat_theme_16);
    }
    public void flat_theme17(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_17));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_17);
        toolbar.setBackgroundResource(R.drawable.flat_theme_17);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_17);
        imageView.setImageResource(R.drawable.flat_theme_17);
    }
    public void flat_theme18(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_18));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_18);
        toolbar.setBackgroundResource(R.drawable.flat_theme_18);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_18);
        imageView.setImageResource(R.drawable.flat_theme_18);
    }
    public void flat_theme19(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_19));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_19);
        toolbar.setBackgroundResource(R.drawable.flat_theme_19);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_19);
        imageView.setImageResource(R.drawable.flat_theme_19);
    }
    public void flat_theme20(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.flat_clr_20));

        relativeLayout.setBackgroundResource(R.drawable.flat_theme_20);
        toolbar.setBackgroundResource(R.drawable.flat_theme_20);
        constraintLayout.setBackgroundResource(R.drawable.flat_theme_20);
        imageView.setImageResource(R.drawable.flat_theme_20);
    }

    public void grad_theme1(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_1));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_1);
        toolbar.setBackgroundResource(R.drawable.grad_theme_1);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_1);
        imageView.setImageResource(R.drawable.grad_theme_1);
    }
    public void grad_theme2(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_2));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_2);
        toolbar.setBackgroundResource(R.drawable.grad_theme_2);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_2);
        imageView.setImageResource(R.drawable.grad_theme_2);
    }
    public void grad_theme3(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_3));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_3);
        toolbar.setBackgroundResource(R.drawable.grad_theme_3);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_3);
        imageView.setImageResource(R.drawable.grad_theme_3);
    }
    public void grad_theme4(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_4));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_4);
        toolbar.setBackgroundResource(R.drawable.grad_theme_4);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_4);
        imageView.setImageResource(R.drawable.grad_theme_4);
    }
    public void grad_theme5(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_5));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_5);
        toolbar.setBackgroundResource(R.drawable.grad_theme_5);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_5);
        imageView.setImageResource(R.drawable.grad_theme_5);
    }
    public void grad_theme6(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_6));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_6);
        toolbar.setBackgroundResource(R.drawable.grad_theme_6);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_6);
        imageView.setImageResource(R.drawable.grad_theme_6);
    }
    public void grad_theme7(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_7));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_7);
        toolbar.setBackgroundResource(R.drawable.grad_theme_7);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_7);
        imageView.setImageResource(R.drawable.grad_theme_7);
    }
    public void grad_theme8(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_8));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_8);
        toolbar.setBackgroundResource(R.drawable.grad_theme_8);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_8);
        imageView.setImageResource(R.drawable.grad_theme_8);
    }
    public void grad_theme9(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_9));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_9);
        toolbar.setBackgroundResource(R.drawable.grad_theme_9);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_9);
        imageView.setImageResource(R.drawable.grad_theme_9);
    }
    public void grad_theme10(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_10));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_10);
        toolbar.setBackgroundResource(R.drawable.grad_theme_10);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_10);
        imageView.setImageResource(R.drawable.grad_theme_10);
    }
    public void grad_theme11(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_11));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_11);
        toolbar.setBackgroundResource(R.drawable.grad_theme_11);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_11);
        imageView.setImageResource(R.drawable.grad_theme_11);
    }
    public void grad_theme12(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_12));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_12);
        toolbar.setBackgroundResource(R.drawable.grad_theme_12);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_12);
        imageView.setImageResource(R.drawable.grad_theme_12);
    }
    public void grad_theme13(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_13));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_13);
        toolbar.setBackgroundResource(R.drawable.grad_theme_13);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_13);
        imageView.setImageResource(R.drawable.grad_theme_13);
    }
    public void grad_theme14(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_14));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_14);
        toolbar.setBackgroundResource(R.drawable.grad_theme_14);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_14);
        imageView.setImageResource(R.drawable.grad_theme_14);
    }
    public void grad_theme15(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_15));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_15);
        toolbar.setBackgroundResource(R.drawable.grad_theme_15);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_15);
        imageView.setImageResource(R.drawable.grad_theme_15);
    }
    public void grad_theme16(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_16));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_16);
        toolbar.setBackgroundResource(R.drawable.grad_theme_16);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_16);
        imageView.setImageResource(R.drawable.grad_theme_16);
    }
    public void grad_theme17(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_17));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_17);
        toolbar.setBackgroundResource(R.drawable.grad_theme_17);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_17);
        imageView.setImageResource(R.drawable.grad_theme_17);
    }
    public void grad_theme18(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_18));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_18);
        toolbar.setBackgroundResource(R.drawable.grad_theme_18);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_18);
        imageView.setImageResource(R.drawable.grad_theme_18);
    }
    public void grad_theme19(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_19));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_19);
        toolbar.setBackgroundResource(R.drawable.grad_theme_19);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_19);
        imageView.setImageResource(R.drawable.grad_theme_19);
    }
    public void grad_theme20(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.grad_clr_20));

        relativeLayout.setBackgroundResource(R.drawable.grad_theme_20);
        toolbar.setBackgroundResource(R.drawable.grad_theme_20);
        constraintLayout.setBackgroundResource(R.drawable.grad_theme_20);
        imageView.setImageResource(R.drawable.grad_theme_20);
    }

    public void picto_theme1(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr1));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr1));

        GlideApp.with(activity).load(R.drawable.picto1).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme2(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr2));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr2));

        GlideApp.with(activity).load(R.drawable.picto2).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme3(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr3));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr3));

        GlideApp.with(activity).load(R.drawable.picto3).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme4(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr4));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr4));

        GlideApp.with(activity).load(R.drawable.picto4).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme5(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr5));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr5));

        GlideApp.with(activity).load(R.drawable.picto5).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme6(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr6));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr6));

        GlideApp.with(activity).load(R.drawable.picto6).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme7(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr7));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr7));

        GlideApp.with(activity).load(R.drawable.picto7).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme8(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr8));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr8));

        GlideApp.with(activity).load(R.drawable.picto8).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme9(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr9));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr9));

        GlideApp.with(activity).load(R.drawable.picto9).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme10(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr10));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr10));

        GlideApp.with(activity).load(R.drawable.picto10).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme11(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr11));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr11));

        GlideApp.with(activity).load(R.drawable.picto11).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme12(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr12));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr12));

        GlideApp.with(activity).load(R.drawable.picto12).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme13(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr13));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr13));

        GlideApp.with(activity).load(R.drawable.picto13).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme14(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr14));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr14));

        GlideApp.with(activity).load(R.drawable.picto14).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme15(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr15));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr15));

        GlideApp.with(activity).load(R.drawable.picto15).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme16(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr16));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr16));

        GlideApp.with(activity).load(R.drawable.picto16).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme17(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr17));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr17));

        GlideApp.with(activity).load(R.drawable.picto17).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme18(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr18));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr18));

        GlideApp.with(activity).load(R.drawable.picto18).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme19(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr19));

        GlideApp.with(activity).load(R.drawable.picto19).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme20(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr20));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr20));

        GlideApp.with(activity).load(R.drawable.picto20).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme21(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr21));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr21));

        GlideApp.with(activity).load(R.drawable.picto21).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme22(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr22));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr22));

        GlideApp.with(activity).load(R.drawable.picto22).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme23(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr23));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr23));

        GlideApp.with(activity).load(R.drawable.picto23).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void picto_theme24(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.picto_clr24));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.picto_clr24));

        GlideApp.with(activity).load(R.drawable.picto24).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);

                }
            }
        });
    }

    public void customTheme(Activity activity, RelativeLayout relativeLayout, Toolbar toolbar, ConstraintLayout constraintLayout, ImageView imageView){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.black));

        toolbar.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
        imageView.setBackgroundColor(activity.getResources().getColor(R.color.black));

        SharedPreferences theme_pref2 = PreferenceManager.getDefaultSharedPreferences(activity);

        String current_theme2 = theme_pref2.getString("CustImg", "default");

        GlideApp.with(activity).load(Uri.fromFile(new File(current_theme2))).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.setBackground(resource);
                    constraintLayout.setBackground(resource);
                }
            }
        });
    }


}
