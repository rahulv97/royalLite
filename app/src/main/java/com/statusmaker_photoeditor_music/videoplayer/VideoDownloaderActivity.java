package com.statusmaker_photoeditor_music.videoplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.FacebookActivity;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.GalleryActivity;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.InstagramActivity;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.LikeeActivity;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.MainActivity;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.RoposoActivity;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.ShareChatActivity;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.SnackVideoActivity;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.TikTokActivity;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.TwitterActivity;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.WhatsappActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.AppActivity;
import com.statusmaker_photoeditor_music.videoplayer.themes.VideoDownloaderScreen;

import java.net.MalformedURLException;
import java.net.URL;

public class VideoDownloaderActivity extends AppCompatActivity {

    RelativeLayout rvLikee,
    rvInsta,
    rvWhatsApp,
    rvTikTok,
    rvFB,
    rvTwitter,
    rvGallery,
    rvAbout,
    rvShareApp,
    rvRateApp,
    rvMoreApp,
    rvSnack,
    rvShareChat,
    rvRoposo;


    SnackVideoActivity snackVideoActivity;
    ShareChatActivity shareChatActivity;
    RoposoActivity roposoActivity;
    LikeeActivity likeeActivity;
    InstagramActivity instagramActivity;
    TikTokActivity tikTokActivity;
    FacebookActivity facebookActivity;
    TwitterActivity twitterActivity;

    EditText et_text;
    TextView login_btn1;

    RelativeLayout foot_music, foot_video, foot_photo, foot_vid_down, foot_vid_make, foot_more, video_downloader_parent, app_footer;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_downloader);



        rvLikee = findViewById(R.id.rvLikee);
        rvInsta = findViewById(R.id.rvInsta);
        rvWhatsApp = findViewById(R.id.rvWhatsApp);
        rvTikTok = findViewById(R.id.rvTikTok);
        rvFB = findViewById(R.id.rvFB);
        rvTwitter = findViewById(R.id.rvTwitter);
        rvGallery = findViewById(R.id.rvGallery);
        rvAbout = findViewById(R.id.rvAbout);
        rvShareApp = findViewById(R.id.rvShareApp);
        rvRateApp = findViewById(R.id.rvRateApp);
        rvMoreApp = findViewById(R.id.rvMoreApp);
        rvSnack = findViewById(R.id.rvSnack);
        rvShareChat = findViewById(R.id.rvShareChat);
        rvRoposo = findViewById(R.id.rvRoposo);

        foot_video = findViewById(R.id.foot_vid);
        foot_music = findViewById(R.id.foot_music);
        
        foot_vid_down = findViewById(R.id.foot_vid_down);
        
        foot_more = findViewById(R.id.foot_more);
        video_downloader_parent = findViewById(R.id.video_downloader_parent);
        app_footer = findViewById(R.id.app_footer);

        et_text = findViewById(R.id.et_text);
        login_btn1 = findViewById(R.id.login_btn1);

        VideoDownloaderScreen videoDownloaderScreen = new VideoDownloaderScreen();
        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme = theme_pref.getString("Theme", "default");

        if (current_theme.equals("theme1")){
            videoDownloaderScreen.theme1(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);

        }
        else if (current_theme.equals("theme2")){
            videoDownloaderScreen.theme2(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);

        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_1))){
            videoDownloaderScreen.flat_theme1(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_2))){
            videoDownloaderScreen.flat_theme2(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_3))){
            videoDownloaderScreen.flat_theme3(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_4))){
            videoDownloaderScreen.flat_theme4(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_5))){
            videoDownloaderScreen.flat_theme5(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_6))){
            videoDownloaderScreen.flat_theme6(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_7))){
            videoDownloaderScreen.flat_theme7(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_8))){
            videoDownloaderScreen.flat_theme8(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_9))){
            videoDownloaderScreen.flat_theme9(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_10))){
            videoDownloaderScreen.flat_theme10(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_11))){
            videoDownloaderScreen.flat_theme11(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_12))){
            videoDownloaderScreen.flat_theme12(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_13))){
            videoDownloaderScreen.flat_theme13(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_14))){
            videoDownloaderScreen.flat_theme14(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_15))){
            videoDownloaderScreen.flat_theme15(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_16))){
            videoDownloaderScreen.flat_theme16(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_17))){
            videoDownloaderScreen.flat_theme17(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_18))){
            videoDownloaderScreen.flat_theme18(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_19))){
            videoDownloaderScreen.flat_theme19(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_20))){
            videoDownloaderScreen.flat_theme20(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_1))){
            videoDownloaderScreen.grad_theme1(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_2))){
            videoDownloaderScreen.grad_theme2(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_3))){
            videoDownloaderScreen.grad_theme3(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_4))){
            videoDownloaderScreen.grad_theme4(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_5))){
            videoDownloaderScreen.grad_theme5(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_6))){
            videoDownloaderScreen.grad_theme6(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_7))){
            videoDownloaderScreen.grad_theme7(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_8))){
            videoDownloaderScreen.grad_theme8(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_9))){
            videoDownloaderScreen.grad_theme9(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_10))){
            videoDownloaderScreen.grad_theme10(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_11))){
            videoDownloaderScreen.grad_theme11(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_12))){
            videoDownloaderScreen.grad_theme12(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_13))){
            videoDownloaderScreen.grad_theme13(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_14))){
            videoDownloaderScreen.grad_theme14(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_15))){
            videoDownloaderScreen.grad_theme15(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_16))){
            videoDownloaderScreen.grad_theme16(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_17))){
            videoDownloaderScreen.grad_theme17(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_18))){
            videoDownloaderScreen.grad_theme18(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_19))){
            videoDownloaderScreen.grad_theme19(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_20))){
            videoDownloaderScreen.grad_theme20(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto1))){
            videoDownloaderScreen.picto_theme1(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto2))){
            videoDownloaderScreen.picto_theme2(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto3))){
            videoDownloaderScreen.picto_theme3(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto4))){
            videoDownloaderScreen.picto_theme4(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto5))){
            videoDownloaderScreen.picto_theme5(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto6))){
            videoDownloaderScreen.picto_theme6(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto7))){
            videoDownloaderScreen.picto_theme7(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto8))){
            videoDownloaderScreen.picto_theme8(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto9))){
            videoDownloaderScreen.picto_theme9(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto10))){
            videoDownloaderScreen.picto_theme10(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto11))){
            videoDownloaderScreen.picto_theme11(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto12))){
            videoDownloaderScreen.picto_theme12(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto13))){
            videoDownloaderScreen.picto_theme13(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto14))){
            videoDownloaderScreen.picto_theme14(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto15))){
            videoDownloaderScreen.picto_theme15(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto16))){
            videoDownloaderScreen.picto_theme16(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto17))){
            videoDownloaderScreen.picto_theme17(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto18))){
            videoDownloaderScreen.picto_theme18(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto19))){
            videoDownloaderScreen.picto_theme19(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto20))){
            videoDownloaderScreen.picto_theme20(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto21))){
            videoDownloaderScreen.picto_theme21(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto22))){
            videoDownloaderScreen.picto_theme22(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto23))){
            videoDownloaderScreen.picto_theme23(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        else if (current_theme.equals("CustomTheme")){
            videoDownloaderScreen.customTheme(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
}
else if (current_theme.equals(String.valueOf(R.drawable.picto24))){
            videoDownloaderScreen.picto_theme24(VideoDownloaderActivity.this, video_downloader_parent, login_btn1, app_footer);
        }
        
        else {

        }

        login_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_text.getText().toString().isEmpty()){
                    Toast.makeText(VideoDownloaderActivity.this,  getResources().getString(com.cd.statussaver.R.string.enter_url), Toast.LENGTH_LONG).show();
                }
                else if (!Patterns.WEB_URL.matcher(et_text.getText().toString()).matches()) {
                    Toast.makeText(VideoDownloaderActivity.this,  getResources().getString(com.cd.statussaver.R.string.enter_valid_url), Toast.LENGTH_LONG).show();
                }
                else {
                    URL url = null;
                    try {
                        url = new URL(et_text.getText().toString());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    String host = url.getHost();
                    if (host.contains("roposo")) {
                        Intent intent = new Intent(VideoDownloaderActivity.this, RoposoActivity.class);
                        intent.putExtra("DownloadNow", "DownloadNow");
                        intent.putExtra("DownloadUrl", et_text.getText().toString());
                        startActivity(intent);
                    }
                    else if (host.contains("snackvideo")){
                        Intent intent = new Intent(VideoDownloaderActivity.this, SnackVideoActivity.class);
                        intent.putExtra("DownloadNow", "DownloadNow");
                        intent.putExtra("DownloadUrl", et_text.getText().toString());
                        startActivity(intent);
                    }
                    else  if (host.contains("sharechat")) {
                        Intent intent = new Intent(VideoDownloaderActivity.this, ShareChatActivity.class);
                        intent.putExtra("DownloadNow", "DownloadNow");
                        intent.putExtra("DownloadUrl", et_text.getText().toString());
                        startActivity(intent);
                    }
                    else if (host.contains("likee")) {
                        Intent intent = new Intent(VideoDownloaderActivity.this, LikeeActivity.class);
                        intent.putExtra("DownloadNow", "DownloadNow");
                        intent.putExtra("DownloadUrl", et_text.getText().toString());
                        startActivity(intent);
                    }

                    else if (host.equals("www.instagram.com")) {
                        Intent intent = new Intent(VideoDownloaderActivity.this, InstagramActivity.class);
                        intent.putExtra("DownloadNow", "DownloadNow");
                        intent.putExtra("DownloadUrl", et_text.getText().toString());
                        startActivity(intent);
                    }
                    else if (host.contains("tiktok")) {
                        Intent intent = new Intent(VideoDownloaderActivity.this, TikTokActivity.class);
                        intent.putExtra("DownloadNow", "DownloadNow");
                        intent.putExtra("DownloadUrl", et_text.getText().toString());
                        startActivity(intent);
                    }
                    if (host.contains("facebook.com")) {
                        Intent intent = new Intent(VideoDownloaderActivity.this, FacebookActivity.class);
                        intent.putExtra("DownloadNow", "DownloadNow");
                        intent.putExtra("DownloadUrl", et_text.getText().toString());
                        startActivity(intent);
                    }
                    else if (host.contains("twitter.com")) {
                        Intent intent = new Intent(VideoDownloaderActivity.this, TwitterActivity.class);
                        intent.putExtra("DownloadNow", "DownloadNow");
                        intent.putExtra("DownloadUrl", et_text.getText().toString());
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(VideoDownloaderActivity.this, "This URL is not supported for now", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        foot_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoDownloaderActivity.this, VideoSelectorActivity.class);
                startActivity(intent);
                finish();
            }
        });



        foot_vid_down.setBackgroundResource(R.drawable.selected_footer);

        foot_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideoDownloaderActivity.this, AppActivity.class);
                startActivity(intent);
                finish();
            }
        });

        foot_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoDownloaderActivity.this, MoreOptionsActivity.class);
                startActivity(intent);
                finish();
            }
        });




        rvLikee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callLikeeActivity();
            }
        });
        rvInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callInstaActivity();
            }
        });
        rvWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callWhatsappActivity();
            }
        });
        rvTikTok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTikTokActivity();
            }
        });
        rvFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFacebookActivity();
            }
        });
        rvTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTwitterActivity();
            }
        });
        rvGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callGalleryActivity();
            }
        });
        rvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        rvShareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callShareChatActivity();
            }
        });
        rvRateApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        rvMoreApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        rvSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callSnackVideoActivity();
            }
        });
        rvShareChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callShareChatActivity();
            }
        });
        rvRoposo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRoposoActivity();
            }
        });

    }

    public void callLikeeActivity() {
        Intent i = new Intent(this, LikeeActivity.class);
        //i.putExtra("CopyIntent", CopyValue);
        i.putExtra("DownloadNow", "NoDownloadNow");
        startActivity(i);
    }

    public void callInstaActivity() {
        Intent i = new Intent(this, InstagramActivity.class);
        //i.putExtra("CopyIntent", CopyValue);
        i.putExtra("DownloadNow", "NoDownloadNow");
        startActivity(i);
    }


    public void callWhatsappActivity() {
        Intent i = new Intent(this, WhatsappActivity.class);
        startActivity(i);
    }

    public void callTikTokActivity() {
        Intent i = new Intent(this, TikTokActivity.class);
        i.putExtra("DownloadNow", "NoDownloadNow");
        //i.putExtra("CopyIntent", CopyValue);
        startActivity(i);
    }

    public void callFacebookActivity() {
        Intent i = new Intent(this, FacebookActivity.class);
        i.putExtra("DownloadNow", "NoDownloadNow");
        //i.putExtra("CopyIntent", CopyValue);
        startActivity(i);

    }

    public void callTwitterActivity() {
        Intent i = new Intent(this, TwitterActivity.class);
        i.putExtra("DownloadNow", "NoDownloadNow");
        //i.putExtra("CopyIntent", CopyValue);
        startActivity(i);
    }


    public void callGalleryActivity() {
        Intent i = new Intent(this, GalleryActivity.class);
        i.putExtra("DownloadNow", "NoDownloadNow");
        startActivity(i);
    }

    public void callRoposoActivity() {
        Intent i = new Intent(this, RoposoActivity.class);
        i.putExtra("DownloadNow", "NoDownloadNow");
        //i.putExtra("CopyIntent", CopyValue);
        startActivity(i);
    }

    public void callShareChatActivity() {
        Intent i = new Intent(this, ShareChatActivity.class);
        i.putExtra("DownloadNow", "NoDownloadNow");
        //i.putExtra("CopyIntent", CopyValue);
        startActivity(i);
    }

    public void callSnackVideoActivity() {
        Intent i = new Intent(this, SnackVideoActivity.class);
        i.putExtra("DownloadNow", "NoDownloadNow");
        //i.putExtra("CopyIntent", CopyValue);
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Quit Application")
                .setMessage("Are you sure you want to Exit the Application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        VideoDownloaderActivity.super.onBackPressed();
                    }

                })
                .setNegativeButton("No", null)
                .show();

    }
}