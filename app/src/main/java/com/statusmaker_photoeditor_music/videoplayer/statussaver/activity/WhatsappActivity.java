package com.statusmaker_photoeditor_music.videoplayer.statussaver.activity;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
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
import com.cd.statussaver.databinding.ActivityWhatsappBinding;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.fragment.WhatsappImageFragment;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.fragment.WhatsappVideoFragment;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.AdsUtils;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.AppLangSessionManager;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils;
import com.statusmaker_photoeditor_music.videoplayer.themes.DownloadersScreen1;
import com.statusmaker_photoeditor_music.videoplayer.themes.WhatsappScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.createFileFolder;

public class WhatsappActivity extends AppCompatActivity {
    private ActivityWhatsappBinding binding;
    private WhatsappActivity activity;

    AppLangSessionManager appLangSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_whatsapp);
        activity = this;
        createFileFolder();
        initViews();

        appLangSessionManager = new AppLangSessionManager(activity);
        setLocale(appLangSessionManager.getLanguage());


        AdsUtils.showGoogleBannerAd(activity,binding.adView);

        /*RelativeLayout downloader_parent = findViewById(com.royalplayer.lite.R.id.downloader_parent);

        DownloadersScreen1 downloadersScreen1 = new DownloadersScreen1();
        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme = theme_pref.getString("Theme", "default");

        if (current_theme.equals("theme1")){
            downloadersScreen1.theme1(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else if (current_theme.equals("theme2")){
            downloadersScreen1.theme2(activity, downloader_parent, binding.loginBtn1, binding.tvPaste);
        }
        else {

        }*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        activity = this;
    }

    private void initViews() {
        setupViewPager(binding.viewpager);
        binding.tabs.setupWithViewPager(binding.viewpager);
        binding.imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        for (int i = 0; i < binding.tabs.getTabCount(); i++) {
            TextView tv=(TextView) LayoutInflater.from(activity).inflate(com.royalplayer.lite.R.layout.theme1_custom_tab,null);
            binding.tabs.getTabAt(i).setCustomView(tv);

        }

        WhatsappScreen whatsappScreen = new WhatsappScreen();

        RelativeLayout downloader_parent = findViewById(com.royalplayer.lite.R.id.downloader_parent);

        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme = theme_pref.getString("Theme", "default");

        if (current_theme.equals("theme1")){
            whatsappScreen.theme1Activity(activity, downloader_parent);
        }
        else if (current_theme.equals("theme2")){
            whatsappScreen.theme2Activity(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_1))){
            whatsappScreen.flat_theme1(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_2))){
            whatsappScreen.flat_theme2(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_3))){
            whatsappScreen.flat_theme3(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_4))){
            whatsappScreen.flat_theme4(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_5))){
            whatsappScreen.flat_theme5(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_6))){
            whatsappScreen.flat_theme6(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_7))){
            whatsappScreen.flat_theme7(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_8))){
            whatsappScreen.flat_theme8(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_9))){
            whatsappScreen.flat_theme9(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_10))){
            whatsappScreen.flat_theme10(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_11))){
            whatsappScreen.flat_theme11(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_12))){
            whatsappScreen.flat_theme12(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_13))){
            whatsappScreen.flat_theme13(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_14))){
            whatsappScreen.flat_theme14(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_15))){
            whatsappScreen.flat_theme15(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_16))){
            whatsappScreen.flat_theme16(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_17))){
            whatsappScreen.flat_theme17(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_18))){
            whatsappScreen.flat_theme18(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_19))){
            whatsappScreen.flat_theme19(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_20))){
            whatsappScreen.flat_theme20(activity, downloader_parent);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_1))){
            whatsappScreen.grad_theme1(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_2))){
            whatsappScreen.grad_theme2(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_3))){
            whatsappScreen.grad_theme3(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_4))){
            whatsappScreen.grad_theme4(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_5))){
            whatsappScreen.grad_theme5(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_6))){
            whatsappScreen.grad_theme6(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_7))){
            whatsappScreen.grad_theme7(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_8))){
            whatsappScreen.grad_theme8(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_9))){
            whatsappScreen.grad_theme9(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_10))){
            whatsappScreen.grad_theme10(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_11))){
            whatsappScreen.grad_theme11(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_12))){
            whatsappScreen.grad_theme12(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_13))){
            whatsappScreen.grad_theme13(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_14))){
            whatsappScreen.grad_theme14(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_15))){
            whatsappScreen.grad_theme15(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_16))){
            whatsappScreen.grad_theme16(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_17))){
            whatsappScreen.grad_theme17(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_18))){
            whatsappScreen.grad_theme18(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_19))){
            whatsappScreen.grad_theme19(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_20))){
            whatsappScreen.grad_theme20(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto1))){
            whatsappScreen.picto_theme1(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto2))){
            whatsappScreen.picto_theme2(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto3))){
            whatsappScreen.picto_theme3(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto4))){
            whatsappScreen.picto_theme4(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto5))){
            whatsappScreen.picto_theme5(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto6))){
            whatsappScreen.picto_theme6(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto7))){
            whatsappScreen.picto_theme7(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto8))){
            whatsappScreen.picto_theme8(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto9))){
            whatsappScreen.picto_theme9(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto10))){
            whatsappScreen.picto_theme10(activity, downloader_parent);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto11))){
            whatsappScreen.picto_theme11(activity, downloader_parent);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto12))){
            whatsappScreen.picto_theme12(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto13))){
            whatsappScreen.picto_theme13(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto14))){
            whatsappScreen.picto_theme14(activity, downloader_parent);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto15))){
            whatsappScreen.picto_theme15(activity, downloader_parent);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto16))){
            whatsappScreen.picto_theme16(activity, downloader_parent);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto17))){
            whatsappScreen.picto_theme17(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto18))){
            whatsappScreen.picto_theme18(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto19))){
            whatsappScreen.picto_theme19(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto20))){
            whatsappScreen.picto_theme20(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto21))){
            whatsappScreen.picto_theme21(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto22))){
            whatsappScreen.picto_theme22(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto23))){
            whatsappScreen.picto_theme23(activity, downloader_parent);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto24))){
            whatsappScreen.picto_theme24(activity, downloader_parent);
        }
        else if (current_theme.equals("CustomTheme")){
            whatsappScreen.customTheme(activity, downloader_parent);
        }
        else {

        }


        binding.LLOpenWhatsapp.setOnClickListener(v -> {
            Utils.OpenApp(activity,"com.whatsapp");
        });
    }
    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(activity.getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new WhatsappImageFragment(), getResources().getString(R.string.images));
        adapter.addFragment(new WhatsappVideoFragment(), getResources().getString(R.string.videos));
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);

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


}
