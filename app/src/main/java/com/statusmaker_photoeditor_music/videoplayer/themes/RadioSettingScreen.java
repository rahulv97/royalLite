package com.statusmaker_photoeditor_music.videoplayer.themes;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.music_player.glide.GlideApp;

import java.io.File;

public class RadioSettingScreen {
    public void theme1(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.theme1);
    }

    public void theme2(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.theme2);
    }

    public void flat_theme1(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_1);
    }
    public void flat_theme2(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_2);
    }
    public void flat_theme3(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_3);
    }
    public void flat_theme4(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_4);
    }
    public void flat_theme5(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_5);
    }
    public void flat_theme6(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_6);
    }
    public void flat_theme7(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_7);
    }
    public void flat_theme8(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_8);
    }
    public void flat_theme9(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_9);
    }
    public void flat_theme10(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_10);
    }
    public void flat_theme11(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_11);
    }
    public void flat_theme12(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_12);
    }
    public void flat_theme13(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_13);
    }
    public void flat_theme14(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_14);
    }
    public void flat_theme15(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_15);
    }
    public void flat_theme16(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_16);
    }
    public void flat_theme17(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_17);
    }
    public void flat_theme18(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_18);
    }
    public void flat_theme19(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_19);
    }
    public void flat_theme20(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.flat_theme_20);
    }

    public void grad_theme1(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_1);
    }
    public void grad_theme2(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_2);
    }
    public void grad_theme3(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_3);
    }
    public void grad_theme4(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_4);
    }
    public void grad_theme5(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_5);
    }
    public void grad_theme6(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_6);
    }
    public void grad_theme7(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_7);
    }
    public void grad_theme8(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_8);
    }
    public void grad_theme9(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_9);
    }
    public void grad_theme10(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_10);
    }
    public void grad_theme11(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_11);
    }
    public void grad_theme12(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_12);
    }
    public void grad_theme13(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_13);
    }
    public void grad_theme14(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_14);
    }
    public void grad_theme15(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_15);
    }
    public void grad_theme16(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_16);
    }
    public void grad_theme17(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_17);
    }
    public void grad_theme18(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_18);
    }
    public void grad_theme19(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_19);
    }
    public void grad_theme20(ScrollView scrollView){
        scrollView.setBackgroundResource(R.drawable.grad_theme_20);
    }

    public void picto_theme1(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto1).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme2(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto2).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme3(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto2).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme4(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto3).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme5(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto5).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme6(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto6).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme7(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto7).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme8(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto8).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme9(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto9).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme10(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto10).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme11(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto11).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme12(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto12).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme13(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto13).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme14(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto14).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme15(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto15).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme16(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto16).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme17(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto17).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme18(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto18).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme19(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto19).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme20(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto20).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme21(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto21).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme22(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto22).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme23(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto23).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }
    public void picto_theme24(Activity activity, ScrollView scrollView){
        GlideApp.with(activity).load(R.drawable.picto24).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);

                }
            }
        });
    }

    public void customTheme(Activity activity, ScrollView scrollView){

        SharedPreferences theme_pref2 = PreferenceManager.getDefaultSharedPreferences(activity);

        String current_theme2 = theme_pref2.getString("CustImg", "default");

        GlideApp.with(activity).load(Uri.fromFile(new File(current_theme2))).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    scrollView.setBackground(resource);
                }
            }
        });
    }

}
