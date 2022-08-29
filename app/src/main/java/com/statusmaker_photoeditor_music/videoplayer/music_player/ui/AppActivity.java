package com.statusmaker_photoeditor_music.videoplayer.music_player.ui;

import static com.statusmaker_photoeditor_music.videoplayer.music_player.service.MusicPlayerRemote.musicService;
import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;

import com.bullhead.equalizer.DialogEqualizerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.statusmaker_photoeditor_music.videoplayer.MoreOptionsActivity;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.VideoDownloaderActivity;
import com.statusmaker_photoeditor_music.videoplayer.VideoSelectorActivity;
import com.statusmaker_photoeditor_music.videoplayer.music_player.App;
import com.statusmaker_photoeditor_music.videoplayer.music_player.service.MusicPlayerRemote;
import com.statusmaker_photoeditor_music.videoplayer.music_player.service.MusicService;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.intro.IntroController;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.settingpage.SettingTabFragment;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.playingqueue.PlayingQueueController;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.BackStackController;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.nowplaying.NowPlayingController;
import com.statusmaker_photoeditor_music.videoplayer.music_player.util.NavigationUtil;
import com.statusmaker_photoeditor_music.videoplayer.radio.MainActivity;
import com.statusmaker_photoeditor_music.videoplayer.themes.MusicMainScreen;

import butterknife.BindView;

public class AppActivity extends MusicServiceActivity {
    private static final String TAG = "AppActivity";
    private static final int CODE_PERMISSIONS_WRITE_STORAGE = 1;


    @BindView(R.id.appRoot)
    public RelativeLayout mAppRootView;

    @BindView(R.id.layer_container)
    public FrameLayout mLayerContainerView;

    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;

    RelativeLayout foot_music, foot_vid, foot_photo, foot_vid_down, foot_vid_make, foot_more;

    private void bindView() {
        mAppRootView = findViewById(R.id.appRoot);
        mLayerContainerView = findViewById(R.id.layer_container);
        mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
    }

    public BackStackController mBackStackController;
    public NowPlayingController mNowPlayingController;
    public PlayingQueueController mPlayingQueueController;

    public CardLayerController getCardLayerController() {
        return mCardLayerController;
    }

    public CardLayerController mCardLayerController;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult) {
        switch (requestCode) {
            case CODE_PERMISSIONS_WRITE_STORAGE: {
                if (grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        // Granted
                        onPermissionGranted();
                    } else onPermissionDenied();
                }
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public interface PermissionListener {
        void onPermissionGranted();

        void onPermissionDenied();
    }

    private PermissionListener mPermissionListener;

    public void setPermissionListener(PermissionListener listener) {
        mPermissionListener = listener;

    }

    public void removePermissionListener() {
        mPermissionListener = null;
    }

    private void onPermissionGranted() {
        if (mPermissionListener != null) mPermissionListener.onPermissionGranted();
    }

    private void onPermissionDenied() {
        if (mPermissionListener != null) mPermissionListener.onPermissionDenied();
    }

    DialogEqualizerFragment fragment;

    IntroController mIntroController;
    private boolean mUseDynamicTheme = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        /*if (!App.getInstance().getPreferencesUtility().isFirstTime()) {
            mUseDynamicTheme = false;
            App.getInstance().getPreferencesUtility().notFirstTime();
            setTheme(R.style.AppTheme);
            Log.d(TAG, "onCreate: not the first time");
        } else Log.d(TAG, "onCreate: the first time");
        if (mUseDynamicTheme)
            setTheme(R.style.AppThemeNoWallpaper);*/

        App.getInstance().getPreferencesUtility().notFirstTime();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        bindView();


        findViewById(R.id.imageView4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AppActivity.this, MainActivity.class));

                try {
                    if (MusicPlayerRemote.musicService.isPlaying()){
                        MusicPlayerRemote.musicService.pause();
                    }
                }catch (Exception e){

                }
            }
        });

        foot_music = findViewById(R.id.foot_music);
        foot_vid = findViewById(R.id.foot_vid);

        
        foot_vid_down = findViewById(R.id.foot_vid_down);
        
        foot_more = findViewById(R.id.foot_more);



        new CountDownTimer(1000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                fragment = DialogEqualizerFragment.newBuilder()
                        .setAudioSessionId(musicService.getAudioSessionId())
                        .themeColor(ContextCompat.getColor(AppActivity.this, R.color.eq_back))
                        .textColor(ContextCompat.getColor(AppActivity.this, R.color.white))
                        .accentAlpha(ContextCompat.getColor(AppActivity.this, R.color.white))
                        .darkColor(ContextCompat.getColor(AppActivity.this, R.color.eq_red))
                        .setAccentColor(ContextCompat.getColor(AppActivity.this, R.color.eq_red))
                        .build();
                fragment.show(getSupportFragmentManager(), "eq");

                new CountDownTimer(100, 1000){

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        fragment.onStop();
                    }
                }.start();
            }
        }.start();


        foot_vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack (true);
                Intent intent = new Intent(AppActivity.this, VideoSelectorActivity.class);
                startActivity(intent);
                //finish();
            }
        });

        foot_music.setBackgroundResource(R.drawable.selected_footer);

        foot_vid_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack (true);
                Intent intent = new Intent(AppActivity.this, VideoDownloaderActivity.class);
                startActivity(intent);
                //finish();
            }
        });


        foot_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack (true);
                Intent intent = new Intent(AppActivity.this, MoreOptionsActivity.class);
                startActivity(intent);
                //finish();
            }
        });


        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        mAppRootView.post(new Runnable() {
            @Override
            public void run() {
                boolean isPermissionGranted = checkSelfPermission();
                if (!isPermissionGranted) {

                    if (mIntroController == null) {
                        mIntroController = new IntroController();
                    }

                    mIntroController.init(AppActivity.this, savedInstanceState);
                } else {
                    showMainUI();
                }
                if (mUseDynamicTheme) {
                    mAppRootView.postDelayed(() ->
                                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER, WindowManager.LayoutParams.FLAG_SHOW_WALLPAPER)
                            , 0);
                }
            }
        });

        MusicMainScreen musicMainScreen = new MusicMainScreen();

        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme = theme_pref.getString("Theme", "default");



        if (current_theme.equals(String.valueOf(R.drawable.flat_theme_1))){
            musicMainScreen.flat_theme1(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_2))){
            musicMainScreen.flat_theme2(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_3))){
            musicMainScreen.flat_theme3(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_4))){
            musicMainScreen.flat_theme4(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_5))){
            musicMainScreen.flat_theme5(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_6))){
            musicMainScreen.flat_theme6(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_7))){
            musicMainScreen.flat_theme7(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_8))){
            musicMainScreen.flat_theme8(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_9))){
            musicMainScreen.flat_theme9(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_10))){
            musicMainScreen.flat_theme10(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_11))){
            musicMainScreen.flat_theme11(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_12))){
            musicMainScreen.flat_theme12(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_13))){
            musicMainScreen.flat_theme13(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_14))){
            musicMainScreen.flat_theme14(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_15))){
            musicMainScreen.flat_theme15(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_16))){
            musicMainScreen.flat_theme16(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_17))){
            musicMainScreen.flat_theme17(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_18))){
            musicMainScreen.flat_theme18(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_19))){
            musicMainScreen.flat_theme19(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_20))){
            musicMainScreen.flat_theme20(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_1))){
            musicMainScreen.grad_theme1(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_2))){
            musicMainScreen.grad_theme2(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_3))){
            musicMainScreen.grad_theme3(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_4))){
            musicMainScreen.grad_theme4(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_5))){
            musicMainScreen.grad_theme5(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_6))){
            musicMainScreen.grad_theme6(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_7))){
            musicMainScreen.grad_theme7(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_8))){
            musicMainScreen.grad_theme8(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_9))){
            musicMainScreen.grad_theme9(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_10))){
            musicMainScreen.grad_theme10(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_11))){
            musicMainScreen.grad_theme11(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_12))){
            musicMainScreen.grad_theme12(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_13))){
            musicMainScreen.grad_theme13(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_14))){
            musicMainScreen.grad_theme14(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_15))){
            musicMainScreen.grad_theme15(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_16))){
            musicMainScreen.grad_theme16(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_17))){
            musicMainScreen.grad_theme17(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_18))){
            musicMainScreen.grad_theme18(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_19))){
            musicMainScreen.grad_theme19(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_20))){
            musicMainScreen.grad_theme20(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto1))){
            musicMainScreen.picto_theme1(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto2))){
            musicMainScreen.picto_theme2(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto3))){
            musicMainScreen.picto_theme3(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto4))){
            musicMainScreen.picto_theme4(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto5))){
            musicMainScreen.picto_theme5(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto6))){
            musicMainScreen.picto_theme6(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto7))){
            musicMainScreen.picto_theme7(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto8))){
            musicMainScreen.picto_theme8(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto9))){
            musicMainScreen.picto_theme9(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto10))){
            musicMainScreen.picto_theme10(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto11))){
            musicMainScreen.picto_theme11(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto12))){
            musicMainScreen.picto_theme12(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto13))){
            musicMainScreen.picto_theme13(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto14))){
            musicMainScreen.picto_theme14(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto15))){
            musicMainScreen.picto_theme15(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto16))){
            musicMainScreen.picto_theme16(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto17))){
            musicMainScreen.picto_theme17(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto18))){
            musicMainScreen.picto_theme18(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto19))){
            musicMainScreen.picto_theme19(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto20))){
            musicMainScreen.picto_theme20(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto21))){
            musicMainScreen.picto_theme21(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto22))){
            musicMainScreen.picto_theme22(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto23))){
            musicMainScreen.picto_theme23(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else if (current_theme.equals("CustomTheme")){
            musicMainScreen.customTheme(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                    findViewById(R.id.app_footer));
}
else if (current_theme.equals(String.valueOf(R.drawable.picto24))){
            musicMainScreen.picto_theme24(AppActivity.this, findViewById(R.id.appRoot), findViewById(R.id.bottom_navigation_parent),
                findViewById(R.id.app_footer));
        }
        else {

        }
        
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mCardLayerController != null) mCardLayerController.onConfigurationChanged(newConfig);

        Log.d("CheckResult", "Configuration Changed");
    }

    public void showMainUI() {
       /* remove the intro navigation */
        if (mIntroController != null) {
            removePermissionListener();
            mIntroController.getNavigationController().popAllFragments();
        }

        //runLoading();
        mCardLayerController = new CardLayerController(this);
        mBackStackController = new BackStackController();
        mNowPlayingController = new NowPlayingController();
        mPlayingQueueController = new PlayingQueueController();

        mBackStackController.attachBottomNavigationView(this);

        mCardLayerController.init(mLayerContainerView, mBackStackController, mNowPlayingController, mPlayingQueueController);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CheckResult", "OnStart");
        try {
            fragment.onStop();
        }catch (Exception e){
            Log.d("f", e.getMessage());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CheckResult", "Resumed");
        new CountDownTimer(1500, 1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                //try {
                    fragment.onStop();
                Log.d("fdf", fragment.toString());
                /*}catch (Exception e){
                    Log.d("f", e.getMessage());
                }*/
            }
        }.start();


    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
      //  Log.d(TAG, "onNewIntent: ");
        mAppRootView.post(() -> handlePlaybackIntent(intent));
        Log.d("CheckResult", "New Intent");
    }

    public boolean checkSelfPermission() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    public void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                }, CODE_PERMISSIONS_WRITE_STORAGE);

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                        },
                        CODE_PERMISSIONS_WRITE_STORAGE);

            }
        } else onPermissionGranted();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onServiceConnected() {
        super.onServiceConnected();
        if (mAppRootView != null)
            mAppRootView.post(() -> handlePlaybackIntent(getIntent()));
    }

    @Override
    public void onBackPressed() {
        if (mCardLayerController != null && mCardLayerController.onBackPressed()) {
            /* does layer controller consume back pressed event */
            return;
        }

        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Quit Application")
                .setMessage("Are you sure you want to Exit the Application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //AppActivity.super.onBackPressed();
                        moveTaskToBack (true);
                    }

                })
                .setNegativeButton("No", null)
                .show();
        /* other wise */
        //super.onBackPressed();
    }

    public void setTheme(boolean white) {
     //   Log.d(TAG, "setTheme: " + white);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View root = mAppRootView;
            if (root != null && !white)
                root.setSystemUiVisibility(0);
            else if (root != null)
                root.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }

    public boolean backStackStreamOnTouchEvent(MotionEvent event) {
        if (mBackStackController != null) return mBackStackController.streamOnTouchEvent(event);
        return false;
    }

    private void handlePlaybackIntent(@Nullable Intent intent) {
        if (intent == null) {
          //  Log.d(TAG, "handlePlaybackIntent : null intent");
            return;
        }

        Uri uri = intent.getData();
        String mimeType = intent.getType();
        boolean handled = false;

        // log
        if (uri != null)
            Log.d(TAG, "handlePlaybackIntent: uri_path = " + uri.getPath());
        else
          //  Log.d(TAG, "handlePlaybackIntent: uri_path = null");
      //  Log.d(TAG, "handlePlaybackIntent: mimeType = " + mimeType);

       // Log.d(TAG, "handlePlaybackIntent: action = " + intent.getAction());

        if (intent.getAction() != null && intent.getAction().equals(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH)) {
         //   Log.d(TAG, "handlePlaybackIntent: type media play from search");
            handled = true;
        }

        if (uri != null && uri.toString().length() > 0) {
           // Log.d(TAG, "handlePlaybackIntent: type play file");
            MusicPlayerRemote.playFromUri(uri);
            NavigationUtil.navigateToNowPlayingController(this);
            handled = true;
        } else if (MediaStore.Audio.Playlists.CONTENT_TYPE.equals(mimeType)) {
         //   Log.d(TAG, "handlePlaybackIntent: type playlist");
            handled = true;
        } else if (MediaStore.Audio.Albums.CONTENT_TYPE.equals(mimeType)) {
          //  Log.d(TAG, "handlePlaybackIntent: type album");
            handled = true;
        } else if (MediaStore.Audio.Artists.CONTENT_TYPE.equals(mimeType)) {
          //  Log.d(TAG, "handlePlaybackIntent: type artist");
            handled = true;
        } else if (!handled && MusicService.ACTION_ON_CLICK_NOTIFICATION.equals(intent.getAction())) {
            NavigationUtil.navigateToNowPlayingController(this);
            handled = true;
        } else if (!handled) {
          //  Log.d(TAG, "handlePlaybackIntent: unhandled: " + intent.getAction());
        }

        //NavigationUtil.navigateToNowPlayingController(this);

        if (handled)
            setIntent(new Intent());
    }

    public void popUpPlaylistTab() {
        if (mPlayingQueueController != null) mPlayingQueueController.popUp();
    }

    public BackStackController getBackStackController() {
        return mBackStackController;
    }

    public NowPlayingController getNowPlayingController() {
        return mNowPlayingController;
    }

    public PlayingQueueController getPlayingQueueController() {
        return mPlayingQueueController;
    }
}
