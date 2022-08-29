package com.statusmaker_photoeditor_music.videoplayer.statussaver.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
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
import com.cd.statussaver.databinding.ActivitySnackvideoBinding;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.AdsUtils;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.AppLangSessionManager;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.SharePrefs;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.statusmaker_photoeditor_music.videoplayer.themes.DownloadersScreen1;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import io.reactivex.observers.DisposableObserver;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;
import static android.content.ContentValues.TAG;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.RootDirectorySnackVideo;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.createFileFolder;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.startDownload;

public class SnackVideoActivity extends AppCompatActivity {
    private ActivitySnackvideoBinding binding;
    SnackVideoActivity activity;
    CommonClassForAPI commonClassForAPI;
    private String VideoUrl;
    private ClipboardManager clipBoard;
    AppLangSessionManager appLangSessionManager;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_snackvideo);
        activity = this;
        commonClassForAPI = CommonClassForAPI.getInstance(activity);
        createFileFolder();
        initViews();

        appLangSessionManager = new AppLangSessionManager(activity);
        setLocale(appLangSessionManager.getLanguage());

        AdsUtils.showGoogleBannerAd(activity, binding.adView);
        InterstitialAdsINIT();

        String taskk = getIntent().getStringExtra("DownloadNow");
        if (taskk.equals("DownloadNow")){
            String LL = getIntent().getStringExtra("DownloadUrl");
            binding.etText.setText(LL);
            if (LL.equals("")) {
                Utils.setToast(activity, getResources().getString(R.string.enter_url));
                finish();
            } else if (!Patterns.WEB_URL.matcher(LL).matches()) {
                Utils.setToast(activity, getResources().getString(R.string.enter_valid_url));
                finish();
            } else {
                GetsnackvideoData();
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

        binding.imBack.setOnClickListener(view -> onBackPressed());
        binding.imInfo.setOnClickListener(view -> binding.layoutHowTo.LLHowToLayout.setVisibility(View.GONE));

//        Glide.with(activity)
//                .load(R.drawable.sn1)
//                .into(binding.layoutHowTo.imHowto1);
//
//        Glide.with(activity)
//                .load(R.drawable.sn2)
//                .into(binding.layoutHowTo.imHowto2);
//
//        Glide.with(activity)
//                .load(R.drawable.sn1)
//                .into(binding.layoutHowTo.imHowto3);
//
//        Glide.with(activity)
//                .load(R.drawable.sn2)
//                .into(binding.layoutHowTo.imHowto4);

        binding.layoutHowTo.tvHowToHeadOne.setVisibility(View.GONE);
        binding.layoutHowTo.LLHowToOne.setVisibility(View.GONE);
        binding.layoutHowTo.tvHowToHeadTwo.setText(getResources().getString(R.string.how_to_download));
        binding.layoutHowTo.tvHowTo1.setText(getResources().getString(R.string.open_snack));
        binding.layoutHowTo.tvHowTo3.setText(getResources().getString(R.string.cop_link_from_snack));
        if (!SharePrefs.getInstance(activity).getBoolean(SharePrefs.ISSHOWHOWTOSNACK)) {
            SharePrefs.getInstance(activity).putBoolean(SharePrefs.ISSHOWHOWTOSNACK, true);
            binding.layoutHowTo.LLHowToLayout.setVisibility(View.GONE);
        } else {
            binding.layoutHowTo.LLHowToLayout.setVisibility(View.GONE);
        }


        binding.loginBtn1.setOnClickListener(v -> {
            String LL = binding.etText.getText().toString();
            if (LL.equals("")) {
                Utils.setToast(activity, getResources().getString(R.string.enter_url));
            } else if (!Patterns.WEB_URL.matcher(LL).matches()) {
                Utils.setToast(activity, getResources().getString(R.string.enter_valid_url));
            } else {
                GetsnackvideoData();
            }
        });

        binding.tvPaste.setOnClickListener(v -> {
            PasteText();
        });

        binding.LLOpenTwitter.setOnClickListener(v -> {
            Utils.OpenApp(activity, "com.kwai.bulldog");
        });
    }

    public void GetsnackvideoData() {
        try {
            createFileFolder();
            URL url = new URL(binding.etText.getText().toString());
            String host = url.getHost();
            if (host.contains("snackvideo")){
                Utils.showProgressDialog(activity);
                new callGetsnackvideoData().execute(binding.etText.getText().toString());
            }else if (host.contains("sck.io")) {
                getUrlData(binding.etText.getText().toString());

                showInterstitial();
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
                    if (clipBoard.getPrimaryClip().getItemAt(0).getText().toString().contains("snackvideo")||clipBoard.getPrimaryClip().getItemAt(0).getText().toString().contains("sck.io")) {
                        binding.etText.setText(clipBoard.getPrimaryClip().getItemAt(0).getText().toString());
                    }

                } else {
                    ClipData.Item item = clipBoard.getPrimaryClip().getItemAt(0);
                    if (item.getText().toString().contains("snackvideo")||item.getText().toString().contains("sck.io")) {
                        binding.etText.setText(item.getText().toString());
                    }

                }
            } else {
                if (CopyIntent.contains("snackvideo")||CopyIntent.contains("sck.io")) {
                    binding.etText.setText(CopyIntent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getUrlData(String str) {

        URI uri;
        try {
            uri = new URI(str);
        } catch (Exception e) {
            e.printStackTrace();
            uri = null;
        }
        String[] split = uri.getPath().split("/");
        String str2 = split[split.length - 1];
        String str3 = "android";
        String str4 = "8c46a905";
        StringBuilder sb = new StringBuilder("ANDROID_");
        sb.append(Settings.Secure.getString(getContentResolver(), "android_id"));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add("mod=OnePlus(ONEPLUS A5000)");
        arrayList.add("lon=0");
        arrayList.add("country_code=in");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("did=");
        sb2.append(sb);
        arrayList.add(sb2.toString());
        arrayList.add("app=1");
        arrayList.add("oc=UNKNOWN");
        arrayList.add("egid=");
        arrayList.add("ud=0");
        arrayList.add("c=GOOGLE_PLAY");
        arrayList.add("sys=KWAI_BULLDOG_ANDROID_9");
        arrayList.add("appver=2.7.1.153");
        arrayList.add("mcc=0");
        arrayList.add("language=en-in");
        arrayList.add("lat=0");
        arrayList.add("ver=2.7");
        arrayList2.addAll(arrayList);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("shortKey=");
        sb3.append(str2);
        arrayList2.add(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append("os=");
        sb4.append(str3);
        arrayList2.add(sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append("client_key=");
        sb5.append(str4);
        arrayList2.add(sb5.toString());
        try {
            Collections.sort(arrayList2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }

        String clockKey = com.yxcorp.gifshow.util.CPU.getClockData(this, TextUtils.join("", arrayList2).getBytes(Charset.forName("UTF-8")), 0);

        StringBuilder sb6 = new StringBuilder();
        sb6.append("https://g-api.snackvideo.com/rest/bulldog/share/get?");
        sb6.append(TextUtils.join("&", arrayList));
        try {
            Utils utils = new Utils(activity);
            if (utils.isNetworkAvailable()) {
                if (commonClassForAPI != null) {
                    Utils.showProgressDialog(activity);
                    commonClassForAPI.callSnackVideoData(observer,sb6.toString(),str2,str3,clockKey,str4);
                }
            } else {
                Utils.setToast(activity, getResources().getString(R.string.no_net_conn));
            }


            showInterstitial();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private DisposableObserver<JsonObject> observer = new DisposableObserver<JsonObject>() {
        @Override
        public void onNext(JsonObject jsonObject) {
            Utils.hideProgressDialog(activity);
            try {
                JsonObject photo = jsonObject.get("photo").getAsJsonObject();
                JsonArray mainArray = photo.get("main_mv_urls").getAsJsonArray();
                VideoUrl = mainArray.get(0).getAsJsonObject().get("url").getAsString();
                startDownload(VideoUrl, RootDirectorySnackVideo, activity, "snackvideo_"+System.currentTimeMillis() + ".mp4");
                VideoUrl = "";
                binding.etText.setText("");

                showInterstitial();

            } catch (Exception e) {
                e.printStackTrace();
                Utils.setToast(activity,getResources().getString(R.string.no_media_on_snackvideo));
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
    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
    }

    class callGetsnackvideoData extends AsyncTask<String, Void, Document> {
        Document snackvideoDoc;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Document doInBackground(String... urls) {
            try {
                snackvideoDoc = Jsoup.connect(urls[0]).get();
            } catch (IOException e) {
                e.printStackTrace();
                Log.d(TAG, "doInBackground: Error");
            }
            return snackvideoDoc;
        }

        protected void onPostExecute(Document result) {
            Utils.hideProgressDialog(activity);
            try {
                Elements element = result.select("script");
                String URL = "";
                for (Element script : element) {
                    String a = script.data();
                    if (a.contains("window.__INITIAL_STATE__")) {
                        a= a.substring(a.indexOf("{"),a.indexOf("};"))+"}";
                        URL = a;
                        break;
                    }
                }
                if (!URL.equals("")) {
                    try {
                        JSONObject jsonObject = new JSONObject(URL);
                        VideoUrl = jsonObject.getJSONObject("sharePhoto").getString("mp4Url");
                        String Url = jsonObject.getString("shortUrl");
                        getUrlData(Url);
                        VideoUrl = "";
                        binding.etText.setText("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
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


    }


    private void showInterstitial() {
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    //InterstitialAd : End


}