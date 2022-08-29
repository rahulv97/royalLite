package com.statusmaker_photoeditor_music.videoplayer.statussaver.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.preference.PreferenceManager;

import com.bumptech.glide.Glide;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.api.CommonClassForAPI;
import com.cd.statussaver.databinding.ActivityTwitterBinding;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.model.TwitterResponse;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.AdsUtils;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.AppLangSessionManager;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.SharePrefs;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.statusmaker_photoeditor_music.videoplayer.themes.DownloadersScreen1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import io.reactivex.observers.DisposableObserver;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.RootDirectoryTwitter;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.createFileFolder;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.startDownload;

public class TwitterActivity extends AppCompatActivity {
    private ActivityTwitterBinding binding;
    TwitterActivity activity;
    CommonClassForAPI commonClassForAPI;
    private String VideoUrl;
    private ClipboardManager clipBoard;



    AppLangSessionManager appLangSessionManager;
    private InterstitialAd mInterstitialAd ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_twitter);
        activity = this;
        commonClassForAPI = CommonClassForAPI.getInstance(activity);
        createFileFolder();
        initViews();

        appLangSessionManager = new AppLangSessionManager(activity);
        setLocale(appLangSessionManager.getLanguage());

        AdsUtils.showGoogleBannerAd(activity,binding.adView);
        InterstitialAdsINIT();


        String taskk = getIntent().getStringExtra("DownloadNow");
        if (taskk.equals("DownloadNow")) {
            String LL = getIntent().getStringExtra("DownloadUrl");
            binding.etText.setText(LL);
            if (LL.equals("")) {
                Utils.setToast(activity, getResources().getString(R.string.enter_url));
                finish();
            } else if (!Patterns.WEB_URL.matcher(LL).matches()) {
                Utils.setToast(activity, getResources().getString(R.string.enter_valid_url));
                finish();
            } else {
                Utils.showProgressDialog(activity);
                GetTwitterData();
                showInterstitial();
            }
        }

        RelativeLayout downloader_parent = findViewById(R.id.downloader_parent);

        DownloadersScreen1 downloadersScreen1 = new DownloadersScreen1();
        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme = theme_pref.getString("Theme", "default");

        if (current_theme.equals("theme1")){
            downloadersScreen1.theme1(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals("theme2")){
            downloadersScreen1.theme2(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_1))){
            downloadersScreen1.flat_theme1(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_2))){
            downloadersScreen1.flat_theme2(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_3))){
            downloadersScreen1.flat_theme3(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_4))){
            downloadersScreen1.flat_theme4(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_5))){
            downloadersScreen1.flat_theme5(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_6))){
            downloadersScreen1.flat_theme6(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_7))){
            downloadersScreen1.flat_theme7(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_8))){
            downloadersScreen1.flat_theme8(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_9))){
            downloadersScreen1.flat_theme9(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_10))){
            downloadersScreen1.flat_theme10(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_11))){
            downloadersScreen1.flat_theme11(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_12))){
            downloadersScreen1.flat_theme12(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_13))){
            downloadersScreen1.flat_theme13(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_14))){
            downloadersScreen1.flat_theme14(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_15))){
            downloadersScreen1.flat_theme15(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_16))){
            downloadersScreen1.flat_theme16(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_17))){
            downloadersScreen1.flat_theme17(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_18))){
            downloadersScreen1.flat_theme18(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_19))){
            downloadersScreen1.flat_theme19(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_20))){
            downloadersScreen1.flat_theme20(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_1))){
            downloadersScreen1.grad_theme1(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_2))){
            downloadersScreen1.grad_theme2(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_3))){
            downloadersScreen1.grad_theme3(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_4))){
            downloadersScreen1.grad_theme4(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_5))){
            downloadersScreen1.grad_theme5(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_6))){
            downloadersScreen1.grad_theme6(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_7))){
            downloadersScreen1.grad_theme7(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_8))){
            downloadersScreen1.grad_theme8(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_9))){
            downloadersScreen1.grad_theme9(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_10))){
            downloadersScreen1.grad_theme10(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_11))){
            downloadersScreen1.grad_theme11(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_12))){
            downloadersScreen1.grad_theme12(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_13))){
            downloadersScreen1.grad_theme13(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_14))){
            downloadersScreen1.grad_theme14(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_15))){
            downloadersScreen1.grad_theme15(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_16))){
            downloadersScreen1.grad_theme16(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_17))){
            downloadersScreen1.grad_theme17(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_18))){
            downloadersScreen1.grad_theme18(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_19))){
            downloadersScreen1.grad_theme19(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_20))){
            downloadersScreen1.grad_theme20(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto1))){
            downloadersScreen1.picto_theme1(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto2))){
            downloadersScreen1.picto_theme2(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto3))){
            downloadersScreen1.picto_theme3(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto4))){
            downloadersScreen1.picto_theme4(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto5))){
            downloadersScreen1.picto_theme5(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto6))){
            downloadersScreen1.picto_theme6(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto7))){
            downloadersScreen1.picto_theme7(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto8))){
            downloadersScreen1.picto_theme8(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto9))){
            downloadersScreen1.picto_theme9(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto10))){
            downloadersScreen1.picto_theme10(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto11))){
            downloadersScreen1.picto_theme11(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto12))){
            downloadersScreen1.picto_theme12(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto13))){
            downloadersScreen1.picto_theme13(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto14))){
            downloadersScreen1.picto_theme14(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto15))){
            downloadersScreen1.picto_theme15(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto16))){
            downloadersScreen1.picto_theme16(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto17))){
            downloadersScreen1.picto_theme17(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto18))){
            downloadersScreen1.picto_theme18(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto19))){
            downloadersScreen1.picto_theme19(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto20))){
            downloadersScreen1.picto_theme20(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto21))){
            downloadersScreen1.picto_theme21(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto22))){
            downloadersScreen1.picto_theme22(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto23))){
            downloadersScreen1.picto_theme23(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals("CustomTheme")){
            downloadersScreen1.customTheme(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
}
else if (current_theme.equals(String.valueOf(R.drawable.picto24))){
            downloadersScreen1.picto_theme24(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else {

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        activity = this;
        assert activity != null;
        clipBoard = (ClipboardManager) activity.getSystemService(CLIPBOARD_SERVICE);
        PasteText();
    }

    private void initViews() {
        clipBoard = (ClipboardManager) activity.getSystemService(CLIPBOARD_SERVICE);

        binding.imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitial();
                onBackPressed();
            }
        });
        binding.imInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.layoutHowTo.LLHowToLayout.setVisibility(View.GONE);
            }
        });



//        Glide.with(activity)
//                .load(R.drawable.tw1)
//                .into(binding.layoutHowTo.imHowto1);
//
//        Glide.with(activity)
//                .load(R.drawable.tw2)
//                .into(binding.layoutHowTo.imHowto2);
//
//        Glide.with(activity)
//                .load(R.drawable.tw3)
//                .into(binding.layoutHowTo.imHowto3);
//
//        Glide.with(activity)
//                .load(R.drawable.tw4)
//                .into(binding.layoutHowTo.imHowto4);



        binding.layoutHowTo.tvHowTo1.setText(getResources().getString(R.string.open_twitter));
        binding.layoutHowTo.tvHowTo3.setText(getResources().getString(R.string.open_twitter));
        if (!SharePrefs.getInstance(activity).getBoolean(SharePrefs.ISSHOWHOWTOTWITTER)) {
            SharePrefs.getInstance(activity).putBoolean(SharePrefs.ISSHOWHOWTOTWITTER,true);
            binding.layoutHowTo.LLHowToLayout.setVisibility(View.GONE);
        }else {
            binding.layoutHowTo.LLHowToLayout.setVisibility(View.GONE);
        }


        binding.loginBtn1.setOnClickListener(v -> {
            String LL = binding.etText.getText().toString();
            if (LL.equals("")) {
                Utils.setToast(activity, getResources().getString(R.string.enter_url));
            } else if (!Patterns.WEB_URL.matcher(LL).matches()) {
                Utils.setToast(activity, getResources().getString(R.string.enter_valid_url));
            } else {
                Utils.showProgressDialog(activity);
                GetTwitterData();
                showInterstitial();
            }
        });

        binding.tvPaste.setOnClickListener(v -> {
            PasteText();
        });

        binding.LLOpenTwitter.setOnClickListener(v -> {
            Utils.OpenApp(activity,"com.twitter.android");
        });
    }

    public void GetTwitterData() {
        try {
            createFileFolder();
            URL url = new URL(binding.etText.getText().toString());
            String host = url.getHost();
            if (host.contains("twitter.com")) {
                Long id = getTweetId(binding.etText.getText().toString());
                if (id != null) {
                    callGetTwitterData(String.valueOf(id));
                }
            } else {
                Utils.setToast(activity, getResources().getString(R.string.enter_url));
            }

            showInterstitial();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Long getTweetId(String s) {
        try {
            String[] split = s.split("\\/");
            String id = split[5].split("\\?")[0];
            return Long.parseLong(id);
        } catch (Exception e) {
            Log.d("TAG", "getTweetId: " + e.getLocalizedMessage());
            return null;
        }
    }

    private void PasteText() {
        try {
            binding.etText.setText("");
            String CopyIntent = getIntent().getStringExtra("CopyIntent");
            if (CopyIntent.equals("")) {

                if (!(clipBoard.hasPrimaryClip())) {

                } else if (!(clipBoard.getPrimaryClipDescription().hasMimeType(MIMETYPE_TEXT_PLAIN))) {
                    if (clipBoard.getPrimaryClip().getItemAt(0).getText().toString().contains("twitter.com")) {
                        binding.etText.setText(clipBoard.getPrimaryClip().getItemAt(0).getText().toString());
                    }

                } else {
                    ClipData.Item item = clipBoard.getPrimaryClip().getItemAt(0);
                    if (item.getText().toString().contains("twitter.com")) {
                        binding.etText.setText(item.getText().toString());
                    }

                }
            } else {
                if (CopyIntent.contains("twitter.com")) {
                    binding.etText.setText(CopyIntent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void callGetTwitterData(String id) {
        String URL = "https://twittervideodownloaderpro.com/twittervideodownloadv2/index.php";
        try {
            Utils utils = new Utils(activity);
            if (utils.isNetworkAvailable()) {
                if (commonClassForAPI != null) {
                    Utils.showProgressDialog(activity);
                    commonClassForAPI.callTwitterApi(observer,URL,id);
                }
            } else {
                Utils.setToast(activity, getResources().getString(R.string.no_net_conn));
            }

            showInterstitial();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    private DisposableObserver<TwitterResponse> observer = new DisposableObserver<TwitterResponse>() {
        @Override
        public void onNext(TwitterResponse twitterResponse) {
            Utils.hideProgressDialog(activity);
            try {
                VideoUrl = twitterResponse.getVideos().get(0).getUrl();
                if (twitterResponse.getVideos().get(0).getType().equals("image")){
                    startDownload(VideoUrl, RootDirectoryTwitter, activity, getFilenameFromURL(VideoUrl,"image"));
                    binding.etText.setText("");
                }else {
                    VideoUrl = twitterResponse.getVideos().get(twitterResponse.getVideos().size()-1).getUrl();
                    startDownload(VideoUrl, RootDirectoryTwitter, activity, getFilenameFromURL(VideoUrl,"mp4"));
                    binding.etText.setText("");

                    showInterstitial();
                }

            } catch (Exception e) {
                e.printStackTrace();
                Utils.setToast(activity,getResources().getString(R.string.no_media_on_tweet));
            }
        }

        @Override
        public void onError(Throwable e) {
            Utils.hideProgressDialog(activity);
            e.printStackTrace();

        }

        @Override
        public void onComplete() {
            Utils.hideProgressDialog(activity);
        }
    };


    public String getFilenameFromURL(String url, String type) {
        if (type.equals("image")){
            try {
                return new File(new URL(url).getPath()).getName() + "";
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return System.currentTimeMillis() + ".jpg";
            }
        }else {
            try {
                return new File(new URL(url).getPath()).getName() + "";
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return System.currentTimeMillis() + ".mp4";
            }
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


    //InterstitialAd : Start

    public void InterstitialAdsINIT(){

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });


        mInterstitialAd = new com.google.android.gms.ads.InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.admob_interstitial_ad));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdClicked() {

                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the interstitial ad is closed.
            }
        });

    }


    private void showInterstitial() {
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    //InterstitialAd : End


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showInterstitial();
    }
}