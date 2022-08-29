package com.statusmaker_photoeditor_music.videoplayer.statussaver.activity;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.adapter.StoriesListAdapter;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.adapter.UserListAdapter;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.api.CommonClassForAPI;
import com.cd.statussaver.databinding.ActivityInstagramBinding;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.interfaces.UserListInterface;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.model.Edge;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.model.EdgeSidecarToChildren;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.model.ResponseModel;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.model.story.FullDetailModel;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.model.story.StoryModel;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.model.story.TrayModel;
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
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.statusmaker_photoeditor_music.videoplayer.themes.DownloadersScreen1;

import java.io.File;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Locale;

import io.reactivex.observers.DisposableObserver;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.RootDirectoryInsta;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.createFileFolder;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.startDownload;

public class InstagramActivity extends AppCompatActivity implements UserListInterface {
    private ActivityInstagramBinding binding;
    private InstagramActivity activity;
    Context context;
    private ClipboardManager clipBoard;
    CommonClassForAPI commonClassForAPI;
    private String PhotoUrl;
    private String VideoUrl;


    private InterstitialAd mInterstitialAd;

    AppLangSessionManager appLangSessionManager;
    UserListAdapter userListAdapter;
    StoriesListAdapter storiesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_instagram);

        context = activity = this;

        appLangSessionManager = new AppLangSessionManager(activity);
        setLocale(appLangSessionManager.getLanguage());


        commonClassForAPI = CommonClassForAPI.getInstance(activity);
        createFileFolder();

        AdsUtils.showGoogleBannerAd(InstagramActivity.this,binding.adView);
        InterstitialAdsINIT();

        initViews();

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
                GetInstagramData();
                showInterstitial();
            }
        }
        else {

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
        context = activity = this;
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


//        Glide.with(activity)
//                .load(R.drawable.insta1)
//                .into(binding.layoutHowTo.imHowto1);
//
//        Glide.with(activity)
//                .load(R.drawable.insta2)
//                .into(binding.layoutHowTo.imHowto2);
//
//        Glide.with(activity)
//                .load(R.drawable.insta3)
//                .into(binding.layoutHowTo.imHowto3);
//
//        Glide.with(activity)
//                .load(R.drawable.insta4)
//                .into(binding.layoutHowTo.imHowto4);


        binding.layoutHowTo.tvHowTo1.setText(getResources().getString(R.string.opn_insta));
        binding.layoutHowTo.tvHowTo3.setText(getResources().getString(R.string.opn_insta));
        if (!SharePrefs.getInstance(activity).getBoolean(SharePrefs.ISSHOWHOWTOINSTA)) {
            SharePrefs.getInstance(activity).putBoolean(SharePrefs.ISSHOWHOWTOINSTA,true);
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
                GetInstagramData();
                showInterstitial();
            }


        });

        binding.tvPaste.setOnClickListener(v -> {
            PasteText();
        });
        binding.LLOpenInstagram.setOnClickListener(v -> {
            Utils.OpenApp(activity,"com.instagram.android");
        });

        GridLayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        binding.RVUserList.setLayoutManager(mLayoutManager);
        binding.RVUserList.setNestedScrollingEnabled(false);
        mLayoutManager.setOrientation(RecyclerView.HORIZONTAL);


        if (SharePrefs.getInstance(activity).getBoolean(SharePrefs.ISINSTALOGIN)) {
            layoutCondition();
            callStoriesApi();
            binding.SwitchLogin.setChecked(true);
        }else {
            binding.SwitchLogin.setChecked(false);
        }

        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,
                        LoginActivity.class);
                startActivityForResult(intent, 100);
            }
        });

        binding.RLLoginInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!SharePrefs.getInstance(activity).getBoolean(SharePrefs.ISINSTALOGIN)) {
                    Intent intent = new Intent(activity,
                            LoginActivity.class);
                    startActivityForResult(intent, 100);
                }else {
                    AlertDialog.Builder ab = new AlertDialog.Builder(activity);
                    ab.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            SharePrefs.getInstance(activity).putBoolean(SharePrefs.ISINSTALOGIN, false);
                            SharePrefs.getInstance(activity).putString(SharePrefs.COOKIES, "");
                            SharePrefs.getInstance(activity).putString(SharePrefs.CSRF, "");
                            SharePrefs.getInstance(activity).putString(SharePrefs.SESSIONID, "");
                            SharePrefs.getInstance(activity).putString(SharePrefs.USERID, "");

                            if (SharePrefs.getInstance(activity).getBoolean(SharePrefs.ISINSTALOGIN)){
                                binding.SwitchLogin.setChecked(true);
                            }else {
                                binding.SwitchLogin.setChecked(false);
                                binding.RVUserList.setVisibility(View.GONE);
                                binding.RVStories.setVisibility(View.GONE);
                                binding.tvViewStories.setText(activity.getResources().getText(R.string.view_stories));
                                binding.tvLogin.setVisibility(View.VISIBLE);
                            }
                            dialog.cancel();

                        }
                    });
                    ab.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert = ab.create();
                    alert.setTitle(getResources().getString(R.string.do_u_want_to_download_media_from_pvt));
                    alert.show();
                }

            }
        });

        GridLayoutManager mLayoutManager1 = new GridLayoutManager(getApplicationContext(), 3);
        binding.RVStories.setLayoutManager(mLayoutManager1);
        binding.RVStories.setNestedScrollingEnabled(false);
        mLayoutManager1.setOrientation(RecyclerView.VERTICAL);

    }
    public void layoutCondition(){
        binding.tvViewStories.setText(activity.getResources().getString(R.string.stories));
        binding.tvLogin.setVisibility(View.GONE);

    }

    public void GetInstagramData() {
        try {
            createFileFolder();
            URL url = new URL(binding.etText.getText().toString());
            String host = url.getHost();
            Log.e("initViews: ", host);
            if (host.equals("www.instagram.com")) {
                callDownload(binding.etText.getText().toString());
            } else {
                Utils.setToast(activity, getResources().getString(R.string.enter_valid_url));
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(InstagramActivity.this, e.toString(), Toast.LENGTH_LONG).show();
            
        }
    }

    private void PasteText() {
        try {
            binding.etText.setText("");
            String CopyIntent = getIntent().getStringExtra("CopyIntent");
            if (CopyIntent.equals("")) {
                if (!(clipBoard.hasPrimaryClip())) {

                } else if (!(clipBoard.getPrimaryClipDescription().hasMimeType(MIMETYPE_TEXT_PLAIN))) {
                    if (clipBoard.getPrimaryClip().getItemAt(0).getText().toString().contains("www.instagram.com")) {
                        binding.etText.setText(clipBoard.getPrimaryClip().getItemAt(0).getText().toString());
                    }

                } else {
                    ClipData.Item item = clipBoard.getPrimaryClip().getItemAt(0);
                    if (item.getText().toString().contains("www.instagram.com")) {
                        binding.etText.setText(item.getText().toString());
                    }

                }
            } else {
                if (CopyIntent.contains("www.instagram.com")) {
                    binding.etText.setText(CopyIntent);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    private String getUrlWithoutParameters(String url) {
        try {
            URI uri = new URI(url);
            return new URI(uri.getScheme(),
                    uri.getAuthority(),
                    uri.getPath(),
                    null, // Ignore the query part of the input url
                    uri.getFragment()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            
            Utils.setToast(activity, getResources().getString(R.string.enter_valid_url));
            return "";
        }
    }



    public void callDownload(String Url) {
        String UrlWithoutQP = getUrlWithoutParameters(Url);
        UrlWithoutQP = UrlWithoutQP + "?__a=1";
        try {
            Utils utils = new Utils(activity);
            if (utils.isNetworkAvailable()) {
                if (commonClassForAPI != null) {

                    try {
                        Utils.showProgressDialog(activity);
                        commonClassForAPI.callResult(instaObserver, UrlWithoutQP,
                                "ds_user_id="+SharePrefs.getInstance(activity).getString(SharePrefs.USERID)
                                        +"; sessionid="+SharePrefs.getInstance(activity).getString(SharePrefs.SESSIONID));
                       // Toast.makeText(InstagramActivity.this,"common api is not null", Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        Toast.makeText(InstagramActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                    }

                }
                else {
                   // Toast.makeText(InstagramActivity.this, "Common api is null", Toast.LENGTH_LONG).show();
                }
            } else {
                Utils.setToast(activity, getResources().getString(R.string.no_net_conn));
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(InstagramActivity.this, e.toString(), Toast.LENGTH_LONG).show();
            

        }
    }


    private DisposableObserver<JsonObject> instaObserver = new DisposableObserver<JsonObject>() {
        @Override
        public void onNext(JsonObject versionList) {
            Utils.hideProgressDialog(activity);

                Log.e("onNext: ", versionList.toString());
                Type listType = new TypeToken<ResponseModel>() {
                }.getType();
                ResponseModel responseModel = new Gson().fromJson(versionList.toString(), listType);
                EdgeSidecarToChildren edgeSidecarToChildren = responseModel.getGraphql().getShortcode_media().getEdge_sidecar_to_children();
                if (edgeSidecarToChildren != null) {
                    List<Edge> edgeArrayList = edgeSidecarToChildren.getEdges();
                    for (int i = 0; i < edgeArrayList.size(); i++) {
                        if (edgeArrayList.get(i).getNode().isIs_video()) {
                            VideoUrl = edgeArrayList.get(i).getNode().getVideo_url();
                            startDownload(VideoUrl, RootDirectoryInsta, activity, getVideoFilenameFromURL(VideoUrl));
                            binding.etText.setText("");
                            VideoUrl = "";

                        } else {
                            PhotoUrl = edgeArrayList.get(i).getNode().getDisplay_resources().get(edgeArrayList.get(i).getNode().getDisplay_resources().size() - 1).getSrc();
                            startDownload(PhotoUrl, RootDirectoryInsta, activity, getImageFilenameFromURL(PhotoUrl));
                            PhotoUrl = "";
                            binding.etText.setText("");
                        }
                    }
                } else {
                    boolean isVideo = responseModel.getGraphql().getShortcode_media().isIs_video();
                    if (isVideo) {
                        VideoUrl = responseModel.getGraphql().getShortcode_media().getVideo_url();
                        //new DownloadFileFromURL().execute(VideoUrl,getFilenameFromURL(VideoUrl));
                        startDownload(VideoUrl, RootDirectoryInsta, activity, getVideoFilenameFromURL(VideoUrl));
                        VideoUrl = "";
                        binding.etText.setText("");
                    } else {
                        PhotoUrl = responseModel.getGraphql().getShortcode_media().getDisplay_resources()
                                .get(responseModel.getGraphql().getShortcode_media().getDisplay_resources().size() - 1).getSrc();
                        startDownload(PhotoUrl, RootDirectoryInsta, activity, getImageFilenameFromURL(PhotoUrl));
                        PhotoUrl = "";
                        binding.etText.setText("");
                        // new DownloadFileFromURL().execute(PhotoUrl,getFilenameFromURL(PhotoUrl));
                    }
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

    public String getImageFilenameFromURL(String url) {
        try {
            return new File(new URL(url).getPath().toString()).getName();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            
            return System.currentTimeMillis() + ".png";
        }
    }

    public String getVideoFilenameFromURL(String url) {
        try {
            return new File(new URL(url).getPath().toString()).getName();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return System.currentTimeMillis() + ".mp4";
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instaObserver.dispose();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 100 && resultCode == RESULT_OK) {
                String requiredValue = data.getStringExtra("key");
                if (SharePrefs.getInstance(activity).getBoolean(SharePrefs.ISINSTALOGIN)){
                    binding.SwitchLogin.setChecked(true);
                    layoutCondition();
                    callStoriesApi();
                } else {
                    binding.SwitchLogin.setChecked(false);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(InstagramActivity.this, ex.toString(), Toast.LENGTH_LONG).show();
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


    private void callStoriesApi() {
        try {
            Utils utils = new Utils(activity);
            if (utils.isNetworkAvailable()) {
                if (commonClassForAPI != null) {
                    binding.prLoadingBar.setVisibility(View.VISIBLE);
                    commonClassForAPI.getStories(storyObserver, "ds_user_id=" + SharePrefs.getInstance(activity).getString(SharePrefs.USERID)
                            + "; sessionid=" + SharePrefs.getInstance(activity).getString(SharePrefs.SESSIONID));
                }
            } else {
                Utils.setToast(activity, activity
                        .getResources().getString(R.string.no_net_conn));
            }
        } catch (Exception e) {
            e.printStackTrace();
            

        }


    }

    private DisposableObserver<StoryModel> storyObserver = new DisposableObserver<StoryModel>() {
        @Override
        public void onNext(StoryModel response) {
            binding.RVUserList.setVisibility(View.VISIBLE);
            binding.prLoadingBar.setVisibility(View.GONE);
            try {
                userListAdapter = new UserListAdapter(activity, response.getTray(), activity);
                binding.RVUserList.setAdapter(userListAdapter);
                userListAdapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
                
            }
        }

        @Override
        public void onError(Throwable e) {
            binding.prLoadingBar.setVisibility(View.GONE);
            e.printStackTrace();
            
        }

        @Override
        public void onComplete() {
            binding.prLoadingBar.setVisibility(View.GONE);
        }
    };

    @Override
    public void userListClick(int position, TrayModel trayModel) {
        callStoriesDetailApi(String.valueOf(trayModel.getUser().getPk()));
    }

    private void callStoriesDetailApi(String UserId) {
        try {
            Utils utils = new Utils(activity);
            if (utils.isNetworkAvailable()) {
                if (commonClassForAPI != null) {
                    binding.prLoadingBar.setVisibility(View.VISIBLE);
                    commonClassForAPI.getFullDetailFeed(storyDetailObserver, UserId, "ds_user_id=" + SharePrefs.getInstance(activity).getString(SharePrefs.USERID)
                            + "; sessionid=" + SharePrefs.getInstance(activity).getString(SharePrefs.SESSIONID));
                }
            } else {
                Utils.setToast(activity, activity
                        .getResources().getString(R.string.no_net_conn));
            }
        } catch (Exception e) {
            e.printStackTrace();
            

        }
    }

    private DisposableObserver<FullDetailModel> storyDetailObserver = new DisposableObserver<FullDetailModel>() {
        @Override
        public void onNext(FullDetailModel response) {
            binding.RVUserList.setVisibility(View.VISIBLE);
            binding.prLoadingBar.setVisibility(View.GONE);
            try {
                    storiesListAdapter = new StoriesListAdapter(activity, response.getReel_feed().getItems());
                    binding.RVStories.setAdapter(storiesListAdapter);
                    storiesListAdapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
                
            }
        }

        @Override
        public void onError(Throwable e) {
            binding.prLoadingBar.setVisibility(View.GONE);
            e.printStackTrace();
            
        }

        @Override
        public void onComplete() {
            binding.prLoadingBar.setVisibility(View.GONE);
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showInterstitial();
    }
}
