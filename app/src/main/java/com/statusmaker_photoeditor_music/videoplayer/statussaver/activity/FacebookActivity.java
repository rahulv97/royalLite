package com.statusmaker_photoeditor_music.videoplayer.statussaver.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
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
import com.cd.statussaver.databinding.ActivityFacebookBinding;
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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;
import static android.content.ContentValues.TAG;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.RootDirectoryFacebook;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.createFileFolder;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.startDownload;

public class FacebookActivity extends AppCompatActivity {
    ActivityFacebookBinding binding;
    FacebookActivity activity;
    CommonClassForAPI commonClassForAPI;
    private String VideoUrl;
    private ClipboardManager clipBoard;

    private InterstitialAd mInterstitialAd;
    AppLangSessionManager appLangSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_facebook);
        activity = this;

        appLangSessionManager = new AppLangSessionManager(activity);
        setLocale(appLangSessionManager.getLanguage());

        commonClassForAPI = CommonClassForAPI.getInstance(activity);
        createFileFolder();
        initViews();


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
                GetFacebookData();
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
                onBackPressed();
                showInterstitial();
            }
        });
        binding.imInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.layoutHowTo.LLHowToLayout.setVisibility(View.GONE);
            }
        });



        /*Glide.with(activity)
                .load(R.drawable.fb1)
                .into(binding.layoutHowTo.imHowto1);

        Glide.with(activity)
                .load(R.drawable.fb2)
                .into(binding.layoutHowTo.imHowto2);

        Glide.with(activity)
                .load(R.drawable.fb3)
                .into(binding.layoutHowTo.imHowto3);

        Glide.with(activity)
                .load(R.drawable.fb4)
                .into(binding.layoutHowTo.imHowto4);*/


        binding.layoutHowTo.tvHowTo1.setText(getResources().getString(R.string.opn_fb));
        binding.layoutHowTo.tvHowTo3.setText(getResources().getString(R.string.copy_video_link_frm_fb));

        if (!SharePrefs.getInstance(activity).getBoolean(SharePrefs.ISSHOWHOWTOFB)) {
            SharePrefs.getInstance(activity).putBoolean(SharePrefs.ISSHOWHOWTOFB,true);
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
                GetFacebookData();
                showInterstitial();
            }
        });

        binding.tvPaste.setOnClickListener(v -> {
            PasteText();
        });
        binding.LLOpenFacebbook.setOnClickListener(v -> {
            Utils.OpenApp(activity,"com.facebook.katana");
        });


    }

    public void GetFacebookData() {
        try {
            createFileFolder();
            URL url = new URL(binding.etText.getText().toString());
            String host = url.getHost();
            Log.e("initViews: ", host);

            if (host.contains("facebook.com") || host.contains("fb.watch")) {
                Utils.showProgressDialog(activity);
                new callGetFacebookData().execute(binding.etText.getText().toString());
            } else {
                Utils.setToast(activity, getResources().getString(R.string.enter_valid_url));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void PasteText() {
        try {
            binding.etText.setText("");
            String CopyIntent = getIntent().getStringExtra("CopyIntent");
            if (CopyIntent.equals("")) {
                if (!(clipBoard.hasPrimaryClip())) {

                } else if (!(clipBoard.getPrimaryClipDescription().hasMimeType(MIMETYPE_TEXT_PLAIN))) {
                    if (clipBoard.getPrimaryClip().getItemAt(0).getText().toString().contains("facebook.com")) {
                        binding.etText.setText(clipBoard.getPrimaryClip().getItemAt(0).getText().toString());
                    }

                } else {
                    ClipData.Item item = clipBoard.getPrimaryClip().getItemAt(0);
                    if (item.getText().toString().contains("facebook.com")) {
                        binding.etText.setText(item.getText().toString());
                    }

                }
            }else {
                if (CopyIntent.contains("facebook.com")) {
                    binding.etText.setText(CopyIntent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class callGetFacebookData extends AsyncTask<String, Void, Document> {
        Document facebookDoc;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Document doInBackground(String... urls) {
            try {
                facebookDoc = Jsoup.connect(urls[0]).get();
            } catch (IOException e) {
                e.printStackTrace();
                Log.d(TAG, "doInBackground: Error");
            }
            return facebookDoc;
        }

        protected void onPostExecute(Document result) {
            Utils.hideProgressDialog(activity);
            try {

                VideoUrl = result.select("meta[property=\"og:video\"]").last().attr("content");
                Log.e("onPostExecute: ", VideoUrl);
                if (!VideoUrl.equals("")) {
                    try {
                        startDownload(VideoUrl, RootDirectoryFacebook, activity, getFilenameFromURL(VideoUrl));
                        VideoUrl = "";
                        binding.etText.setText("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    public String getFilenameFromURL(String url) {
        try {
            return new File(new URL(url).getPath()).getName()+".mp4";
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return System.currentTimeMillis() + ".mp4";
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


        mInterstitialAd = new InterstitialAd(this);
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
        showInterstitial();
        super.onBackPressed();
    }
}