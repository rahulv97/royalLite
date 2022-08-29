package com.statusmaker_photoeditor_music.videoplayer.statussaver.activity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.ViewPager;

import com.cd.statussaver.R;
import com.cd.statussaver.databinding.ActivityGalleryBinding;
import com.statusmaker_photoeditor_music.videoplayer.radio.MainActivity;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.fragment.FBDownloadedFragment;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.fragment.InstaDownloadedFragment;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.fragment.LikeeDownloadedFragment;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.fragment.RoposoDownloadedFragment;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.fragment.SharechatDownloadedFragment;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.fragment.SnackVideoDownloadedFragment;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.fragment.TikTokDownloadedFragment;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.fragment.TwitterDownloadedFragment;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.fragment.WhatsAppDowndlededFragment;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.AppLangSessionManager;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.statusmaker_photoeditor_music.videoplayer.themes.StatusGalleryScreen;
import com.statusmaker_photoeditor_music.videoplayer.themes.WhatsappScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.createFileFolder;

public class GalleryActivity  extends AppCompatActivity {
    GalleryActivity activity;
    ActivityGalleryBinding binding;
    private AdView mAdView;
    AppLangSessionManager appLangSessionManager;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_gallery);
        activity = this;

        appLangSessionManager = new AppLangSessionManager(activity);
        setLocale(appLangSessionManager.getLanguage());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        initViews();


        InterstitialAd.load(this,getString(R.string.admob_interstitial_ad), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                // The mInterstitialAd reference will be null until
                // an ad is loaded.
                mInterstitialAd = interstitialAd;
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                // Handle the error
                mInterstitialAd = null;
            }
        });






    }

    public void initViews() {
        setupViewPager(binding.viewpager);
        binding.tabs.setupWithViewPager(binding.viewpager);
        binding.imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(GalleryActivity.this);
                    GalleryActivity.super.onBackPressed();

                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                    GalleryActivity.super.onBackPressed();
                }

            }
        });

        for (int i = 0; i < binding.tabs.getTabCount(); i++) {
            TextView tv=(TextView) LayoutInflater.from(activity).inflate(com.royalplayer.lite.R.layout.theme1_custom_tab,null);
            binding.tabs.getTabAt(i).setCustomView(tv);
        }

        StatusGalleryScreen statusGalleryScreen = new StatusGalleryScreen();

        RelativeLayout downloader_parent = binding.downloaderParent;

        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme = theme_pref.getString("Theme", "default");

        if (current_theme.equals("theme1")){
            statusGalleryScreen.theme1Activity(activity, downloader_parent);
        }
        else if (current_theme.equals("theme2")){
            statusGalleryScreen.theme2Activity(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_1))){
            statusGalleryScreen.flat_theme1(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_2))){
            statusGalleryScreen.flat_theme2(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_3))){
            statusGalleryScreen.flat_theme3(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_4))){
            statusGalleryScreen.flat_theme4(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_5))){
            statusGalleryScreen.flat_theme5(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_6))){
            statusGalleryScreen.flat_theme6(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_7))){
            statusGalleryScreen.flat_theme7(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_8))){
            statusGalleryScreen.flat_theme8(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_9))){
            statusGalleryScreen.flat_theme9(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_10))){
            statusGalleryScreen.flat_theme10(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_11))){
            statusGalleryScreen.flat_theme11(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_12))){
            statusGalleryScreen.flat_theme12(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_13))){
            statusGalleryScreen.flat_theme13(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_14))){
            statusGalleryScreen.flat_theme14(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_15))){
            statusGalleryScreen.flat_theme15(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_16))){
            statusGalleryScreen.flat_theme16(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_17))){
            statusGalleryScreen.flat_theme17(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_18))){
            statusGalleryScreen.flat_theme18(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_19))){
            statusGalleryScreen.flat_theme19(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_20))){
            statusGalleryScreen.flat_theme20(activity, downloader_parent);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_1))){
            statusGalleryScreen.grad_theme1(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_2))){
            statusGalleryScreen.grad_theme2(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_3))){
            statusGalleryScreen.grad_theme3(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_4))){
            statusGalleryScreen.grad_theme4(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_5))){
            statusGalleryScreen.grad_theme5(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_6))){
            statusGalleryScreen.grad_theme6(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_7))){
            statusGalleryScreen.grad_theme7(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_8))){
            statusGalleryScreen.grad_theme8(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_9))){
            statusGalleryScreen.grad_theme9(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_10))){
            statusGalleryScreen.grad_theme10(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_11))){
            statusGalleryScreen.grad_theme11(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_12))){
            statusGalleryScreen.grad_theme12(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_13))){
            statusGalleryScreen.grad_theme13(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_14))){
            statusGalleryScreen.grad_theme14(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_15))){
            statusGalleryScreen.grad_theme15(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_16))){
            statusGalleryScreen.grad_theme16(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_17))){
            statusGalleryScreen.grad_theme17(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_18))){
            statusGalleryScreen.grad_theme18(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_19))){
            statusGalleryScreen.grad_theme19(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_20))){
            statusGalleryScreen.grad_theme20(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto1))){
            statusGalleryScreen.picto_theme1(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto2))){
            statusGalleryScreen.picto_theme2(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto3))){
            statusGalleryScreen.picto_theme3(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto4))){
            statusGalleryScreen.picto_theme4(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto5))){
            statusGalleryScreen.picto_theme5(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto6))){
            statusGalleryScreen.picto_theme6(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto7))){
            statusGalleryScreen.picto_theme7(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto8))){
            statusGalleryScreen.picto_theme8(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto9))){
            statusGalleryScreen.picto_theme9(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto10))){
            statusGalleryScreen.picto_theme10(activity, downloader_parent);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto11))){
            statusGalleryScreen.picto_theme11(activity, downloader_parent);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto12))){
            statusGalleryScreen.picto_theme12(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto13))){
            statusGalleryScreen.picto_theme13(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto14))){
            statusGalleryScreen.picto_theme14(activity, downloader_parent);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto15))){
            statusGalleryScreen.picto_theme15(activity, downloader_parent);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto16))){
            statusGalleryScreen.picto_theme16(activity, downloader_parent);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto17))){
            statusGalleryScreen.picto_theme17(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto18))){
            statusGalleryScreen.picto_theme18(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto19))){
            statusGalleryScreen.picto_theme19(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto20))){
            statusGalleryScreen.picto_theme20(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto21))){
            statusGalleryScreen.picto_theme21(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto22))){
            statusGalleryScreen.picto_theme22(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto23))){
            statusGalleryScreen.picto_theme23(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto24))){
            statusGalleryScreen.picto_theme24(activity, downloader_parent);
        }
        else if (current_theme.equals("CustomTheme")){
            statusGalleryScreen.customTheme(activity, downloader_parent);
        }
        else {

        }

        binding.viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        createFileFolder();
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(activity.getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new SnackVideoDownloadedFragment(), "Snack Video");
        adapter.addFragment(new SharechatDownloadedFragment(), "Sharechat");
        adapter.addFragment(new RoposoDownloadedFragment(), "Roposo");
        adapter.addFragment(new InstaDownloadedFragment(), "Instagram");
        adapter.addFragment(new WhatsAppDowndlededFragment(), "Whatsapp");
        adapter.addFragment(new TikTokDownloadedFragment(), "TikTok");
        adapter.addFragment(new FBDownloadedFragment(), "Facebook");
        adapter.addFragment(new TwitterDownloadedFragment(), "Twitter");
        adapter.addFragment(new LikeeDownloadedFragment(), "Likee");

        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);

    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }

    @Override
    public void onBackPressed() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(GalleryActivity.this);
            GalleryActivity.super.onBackPressed();

        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
            GalleryActivity.super.onBackPressed();
        }
    }
}
