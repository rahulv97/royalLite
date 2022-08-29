package com.statusmaker_photoeditor_music.videoplayer.radio;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.preference.PreferenceManager;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.VideoSelectorActivity;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.AppActivity;
import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.responses.Radio;
import com.royalplayer.lite.databinding.ActivityMainBinding;
import com.statusmaker_photoeditor_music.videoplayer.radio.radio.PlaybackStatus;
import com.statusmaker_photoeditor_music.videoplayer.radio.ui.player.PlayerViewModel;
import com.statusmaker_photoeditor_music.videoplayer.radio.utils.AdsUtil;
import com.statusmaker_photoeditor_music.videoplayer.radio.utils.AppUtil;
import com.statusmaker_photoeditor_music.videoplayer.themes.RadioMainScreen;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements
        BottomNavigationView.OnNavigationItemSelectedListener,
        SlidingUpPanelLayout.PanelSlideListener,
        View.OnClickListener {

    private static final String TAG = "MainActivity";
    NavController navController;

    ActivityMainBinding mainBinding;

    PlayerViewModel viewModel;
    ObjectAnimator rotateAnimator;
    ObjectAnimator rotateAnimator2;

    private InterstitialAd mInterstitialAd = new InterstitialAd(this);

    boolean exitFlag = false;
    boolean minimizeFlag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        Window window = MainActivity.this.getWindow();
        window.setStatusBarColor(MainActivity.this.getResources().getColor(R.color.def_statusbar));

        MobileAds.initialize(this, initializationStatus -> {
        });

        AdsUtil.loadBannerAd(this, mainBinding.adLayout);
        AdsUtil.loadInterstitialAd(this, mInterstitialAd);

        //hide player on first run
        mainBinding.slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);

        mainBinding.slidingLayout.addPanelSlideListener(this);
        mainBinding.slidingLayout.getChildAt(1).setOnClickListener(null);

        //2 rotate animator for radio logo, for COLLAPSED and EXPANDED state
        rotateAnimator = getRotateAnimator(mainBinding.playerLayout.radioLogoImageView);
        rotateAnimator2 = getRotateAnimator(mainBinding.playerLayout.minRadioLogoImageView);

        viewModel = new ViewModelProvider(this).get(PlayerViewModel.class);

        observeValues();

        mainBinding.setPlayerViewModel(viewModel);

        mainBinding.navView.setOnNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_search, R.id.navigation_home, R.id.navigation_settings)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);


        mainBinding.navView.getMenu().getItem(1).setChecked(true);

        mainBinding.cardView.setOnClickListener(this);
        mainBinding.playerLayout.btnMinimize.setOnClickListener(this);
        mainBinding.playerLayout.btnClose.setOnClickListener(this);

        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme = theme_pref.getString("Theme", "default");

        RadioMainScreen radioMainScreen = new RadioMainScreen();

        if (current_theme.equals("theme1")){
            radioMainScreen.theme1(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals("theme2")){
            radioMainScreen.theme2(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_1))){
            radioMainScreen.flat_theme1(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_2))){
            radioMainScreen.flat_theme2(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_3))){
            radioMainScreen.flat_theme3(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_4))){
            radioMainScreen.flat_theme4(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_5))){
            radioMainScreen.flat_theme5(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_6))){
            radioMainScreen.flat_theme6(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_7))){
            radioMainScreen.flat_theme7(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_8))){
            radioMainScreen.flat_theme8(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_9))){
            radioMainScreen.flat_theme9(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_10))){
            radioMainScreen.flat_theme10(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_11))){
            radioMainScreen.flat_theme11(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_12))){
            radioMainScreen.flat_theme12(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_13))){
            radioMainScreen.flat_theme13(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_14))){
            radioMainScreen.flat_theme14(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_15))){
            radioMainScreen.flat_theme15(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_16))){
            radioMainScreen.flat_theme16(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_17))){
            radioMainScreen.flat_theme17(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_18))){
            radioMainScreen.flat_theme18(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_19))){
            radioMainScreen.flat_theme19(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_20))){
            radioMainScreen.flat_theme20(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_1))){
            radioMainScreen.grad_theme1(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_2))){
            radioMainScreen.grad_theme2(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_3))){
            radioMainScreen.grad_theme3(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_4))){
            radioMainScreen.grad_theme4(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_5))){
            radioMainScreen.grad_theme5(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_6))){
            radioMainScreen.grad_theme6(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_7))){
            radioMainScreen.grad_theme7(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_8))){
            radioMainScreen.grad_theme8(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_9))){
            radioMainScreen.grad_theme9(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_10))){
            radioMainScreen.grad_theme10(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_11))){
            radioMainScreen.grad_theme11(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_12))){
            radioMainScreen.grad_theme12(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_13))){
            radioMainScreen.grad_theme13(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_14))){
            radioMainScreen.grad_theme14(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_15))){
            radioMainScreen.grad_theme15(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_16))){
            radioMainScreen.grad_theme16(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_17))){
            radioMainScreen.grad_theme17(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_18))){
            radioMainScreen.grad_theme18(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_19))){
            radioMainScreen.grad_theme19(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_20))){
            radioMainScreen.grad_theme20(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto1))){
            radioMainScreen.picto_theme1(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto2))){
            radioMainScreen.picto_theme2(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto3))){
            radioMainScreen.picto_theme3(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto4))){
            radioMainScreen.picto_theme4(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto5))){
            radioMainScreen.picto_theme5(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto6))){
            radioMainScreen.picto_theme6(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto7))){
            radioMainScreen.picto_theme7(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto8))){
            radioMainScreen.picto_theme8(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto9))){
            radioMainScreen.picto_theme9(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto10))){
            radioMainScreen.picto_theme10(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto11))){
            radioMainScreen.picto_theme11(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto12))){
            radioMainScreen.picto_theme12(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto13))){
            radioMainScreen.picto_theme13(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto14))){
            radioMainScreen.picto_theme14(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto15))){
            radioMainScreen.picto_theme15(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto16))){
            radioMainScreen.picto_theme16(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto17))){
            radioMainScreen.picto_theme17(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto18))){
            radioMainScreen.picto_theme18(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto19))){
            radioMainScreen.picto_theme19(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto20))){
            radioMainScreen.picto_theme20(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto21))){
            radioMainScreen.picto_theme21(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto22))){
            radioMainScreen.picto_theme22(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto23))){
            radioMainScreen.picto_theme23(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else if (current_theme.equals("CustomTheme")){
            radioMainScreen.customTheme(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
}
else if (current_theme.equals(String.valueOf(R.drawable.picto24))){
            radioMainScreen.picto_theme24(MainActivity.this, findViewById(R.id.container_main), findViewById(R.id.toolbar_rad),
                    mainBinding.playerLayout.bottomSheetPlayer, mainBinding.playerLayout.imageView2);
        }
        else {

        }

    }

    public void observeValues() {
        viewModel.getRadio().observe(this, radio -> mainBinding.playerLayout.setRadio(radio));

        viewModel.getFavoriteListLiveData().observe(this, favorites -> {
            for (Radio fav : favorites) {
                Log.e(TAG, "observeValues: " + fav.getName());
            }
        });

        viewModel.getIsInFavorites().observe(this, isInFavorites -> {
            if (isInFavorites)
                mainBinding.playerLayout.favoritesButton.setImageResource(R.drawable.ic_heart_f);
            else mainBinding.playerLayout.favoritesButton.setImageResource(R.drawable.ic_heart);
        });

        viewModel.getIsNextBtnDisabled().observe(this, isNextBtnDisabled -> {
            if (!isNextBtnDisabled)
                mainBinding.playerLayout.nextButton.setColorFilter(ContextCompat.getColor(this, R.color.colorWhite), android.graphics.PorterDuff.Mode.SRC_IN);
            else
                mainBinding.playerLayout.nextButton.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimaryDarkShadeDisabled), android.graphics.PorterDuff.Mode.SRC_IN);
        });

        viewModel.getIsPrevBtnDisabled().observe(this, isPrevBtnDisabled -> {
            if (!isPrevBtnDisabled)
                mainBinding.playerLayout.previousButton.setColorFilter(ContextCompat.getColor(this, R.color.colorWhite), android.graphics.PorterDuff.Mode.SRC_IN);
            else
                mainBinding.playerLayout.previousButton.setColorFilter(ContextCompat.getColor(this, R.color.colorPrimaryDarkShadeDisabled), android.graphics.PorterDuff.Mode.SRC_IN);
        });

        viewModel.getTimerText().observe(this, timerText -> {
            if (!timerText.equalsIgnoreCase("none")) {
                mainBinding.playerLayout.timerText.setVisibility(View.VISIBLE);
                mainBinding.playerLayout.timerText.setText(timerText);
            } else {
                mainBinding.playerLayout.timerText.setVisibility(View.GONE);
            }
        });

        viewModel.getReportResponseLiveData().observe(this, response -> {
            Toast.makeText(this, response.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onClick(View view) {
        int resId = view.getId();

        if (resId == mainBinding.cardView.getId()) {
            loadInterstitialAd();
            mainBinding.cardView.setCardBackgroundColor(getResources().getColor(R.color.white));
            navController.navigate(R.id.navigation_home);
            mainBinding.navView.getMenu().getItem(1).setChecked(true);
        }

        if (resId == mainBinding.playerLayout.btnMinimize.getId())
            mainBinding.slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);

        if (resId == mainBinding.playerLayout.btnClose.getId()) {
            mainBinding.slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
            viewModel.stopPlayer();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.navigation_home) {
            mainBinding.cardView.setCardBackgroundColor(getResources().getColor(R.color.white)); // will change the background color of the card view to green
            navController.navigate(R.id.navigation_home);

        } else if (id == R.id.navigation_search) {
            mainBinding.cardView.setCardBackgroundColor(getResources().getColor(R.color.colorGrey));
            navController.navigate(R.id.navigation_search);
        } else if (id == R.id.navigation_settings) {
            mainBinding.cardView.setCardBackgroundColor(getResources().getColor(R.color.colorGrey));
            navController.navigate(R.id.navigation_settings);
        }

        loadInterstitialAd();


        return true;
    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {

        if (slideOffset > 0) {
            //changing opacity of view while sliding.
            float alpha = 1 - slideOffset;
            mainBinding.navView.setAlpha(alpha);
            mainBinding.cardView.setAlpha(alpha);
            mainBinding.adLayout.setAlpha(alpha);
            mainBinding.playerLayout.playerContent.setAlpha(slideOffset);
            mainBinding.playerLayout.minimizedLayout.setAlpha(alpha);

            //slide bottomNav up or down
            mainBinding.navView.setTranslationY(mainBinding.cardView.getHeight() * slideOffset);
            mainBinding.cardView.setTranslationY(mainBinding.cardView.getHeight() * slideOffset);
        }


    }

    @Override
    public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
        if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
            AppUtil.setMargins(mainBinding.holder, 0, 0, 0, 0);
            mainBinding.playerLayout.minimizedLayout.setVisibility(View.GONE);
            mainBinding.adLayout.setVisibility(View.GONE);
        }
        if (newState == SlidingUpPanelLayout.PanelState.COLLAPSED) {
            AppUtil.setMargins(mainBinding.holder, 0, 0, 0, 260);
            mainBinding.playerLayout.minimizedLayout.setVisibility(View.VISIBLE);
            mainBinding.adLayout.setVisibility(View.VISIBLE);
        }

        if (newState == SlidingUpPanelLayout.PanelState.HIDDEN)
            AppUtil.setMargins(mainBinding.holder, 0, 0, 0, 0);


    }


    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.unbind();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.bind();
    }

    @Subscribe
    public void onEvent(String status) {

        switch (status) {
            case PlaybackStatus.PLAYING:
                startRotation();
                break;

            case PlaybackStatus.LOADING:

                // loading

                break;


            case PlaybackStatus.ERROR:
                stopRotation();
                Toast.makeText(this, "Error loading radio.", Toast.LENGTH_SHORT).show();
                break;

            case PlaybackStatus.PAUSED:
                stopRotation();
                break;

        }

        if (status.equals(PlaybackStatus.PLAYING)) {
            mainBinding.playerLayout.playStopImageView.setImageResource(R.drawable.ic_stop);
            mainBinding.playerLayout.minBtnPlay.setImageResource(R.drawable.ic_stop);
        } else {
            mainBinding.playerLayout.playStopImageView.setImageResource(R.drawable.ic_play);
            mainBinding.playerLayout.minBtnPlay.setImageResource(R.drawable.ic_play);
        }

        if (status.equals(PlaybackStatus.LOADING)) {
            mainBinding.playerLayout.progressCircular.setVisibility(View.VISIBLE);
            mainBinding.playerLayout.miniProgressCircular.setVisibility(View.VISIBLE);
        } else {
            mainBinding.playerLayout.progressCircular.setVisibility(View.INVISIBLE);
            mainBinding.playerLayout.miniProgressCircular.setVisibility(View.INVISIBLE);
        }


    }

    private ObjectAnimator getRotateAnimator(ImageView imageView) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, View.ROTATION, 0f, 360f)
                .setDuration(8000);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setRepeatMode(ObjectAnimator.RESTART);
        animator.setInterpolator(new LinearInterpolator());
        return animator;
    }

    private void startRotation() {
        rotateAnimator.start();
        rotateAnimator2.start();
    }

    private void stopRotation() {
        rotateAnimator.pause();
        rotateAnimator2.pause();
    }

    public void play(List<Radio> radioList, int position) {

        Radio radio = radioList.get(position);
        viewModel.setPosition(position);
        viewModel.setRadioList(radioList);
        viewModel.setRadio(radio);

        if (mainBinding.slidingLayout.getPanelState() == SlidingUpPanelLayout.PanelState.HIDDEN)
            mainBinding.slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);

        viewModel.play(radio);
    }

    public void hidePlayer() {
        mainBinding.slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);
    }

    @Override
    public void onBackPressed() {

        if (exitFlag) {
            exitFlag = false;
            if (navController.popBackStack()) {
                startActivity(new Intent(MainActivity.this, AppActivity.class));
                finish();
            }else finishAffinity();
        } else if (minimizeFlag) {
            minimizeFlag = false;
            moveTaskToBack(true);
        } else {
            startActivity(new Intent(MainActivity.this, AppActivity.class));
            finish();
        }

    }

    //for loading InterstitialAd
    public void loadInterstitialAd() {
        AdsUtil.ADS_LOAD_COUNT += 1;


        if (AdsUtil.ADS_LOAD_COUNT == AdsUtil.SHOW_ADS_WHEN_TAB_COUNT)
            AdsUtil.showInterstitialAd(mInterstitialAd);

    }

}
