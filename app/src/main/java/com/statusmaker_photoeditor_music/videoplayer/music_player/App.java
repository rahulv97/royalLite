package com.statusmaker_photoeditor_music.videoplayer.music_player;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;

import androidx.multidex.BuildConfig;
import androidx.multidex.MultiDex;

import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.AppLangSessionManager;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.messaging.FirebaseMessaging;
import com.royalplayer.lite.R;

import com.statusmaker_photoeditor_music.videoplayer.music_player.util.PreferenceUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;


public class App extends Application {
    private static App mInstance;

    public static synchronized App getInstance() {
        return mInstance;
    }

    public PreferenceUtil getPreferencesUtility() {
        return PreferenceUtil.getInstance(App.this);
    }




    public static int VIDEO_HEIGHT = 1080;
    public static int VIDEO_WIDTH = 1920;
    private static App instance;
    public static boolean isBreak = false;
    ArrayList<String> allFolder;
    int frame = -1;
    public boolean isEditModeEnable = false;
    public boolean isFromSdCardAudio = false;
    public int min_pos = Integer.MAX_VALUE;

    private float second = 2.0f;
    private String selectedFolderId = BuildConfig.FLAVOR;

    public ArrayList<String> videoImages = new ArrayList<>();

    AppLangSessionManager appLangSessionManager;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;


        FirebaseMessaging.getInstance().subscribeToTopic("all");
        appLangSessionManager = new AppLangSessionManager(getApplicationContext());
        setLocale(appLangSessionManager.getLanguage());

        init();
        MobileAds.initialize(getApplicationContext(), getResources().getString(R.string.admob_app_id));
        AudienceNetworkAds.initialize(getApplicationContext());
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                StrictMode.class.getMethod("disableDeathOnFileUriExposure", new Class[0]).invoke( null, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    //    Nammu.init(this);

    }



    private void init() {

        try {
            loadLib();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadLib() {

    }

    public void initArray() {
        this.videoImages = new ArrayList<>();
    }

    public float getSecond() {
        return this.second;
    }

    public void setSecond(float second) {
        this.second = second;
    }



    public void setSelectedFolderId(String selectedFolderId) {
        this.selectedFolderId = selectedFolderId;
    }

    public String getSelectedFolderId() {
        return this.selectedFolderId;
    }












    public void setCurrentTheme(String currentTheme) {
        SharedPreferences.Editor editor = getSharedPreferences("theme", 0).edit();
        editor.putString("current_theme", currentTheme);
        editor.commit();
    }





    public static boolean isMyServiceRunning(Context context, Class<?> serviceClass) {
        for (ActivityManager.RunningServiceInfo service : ((ActivityManager) context.getSystemService(ACTIVITY_SERVICE)).getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public void setFrame(int data) {
        this.frame = data;
    }

    public int getFrame() {
        return this.frame;
    }


    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public void setLocale(String lang) {
        if (lang.equals("")){
            lang="en";
        }
        Log.d("Support",lang+"");
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);


    }

}