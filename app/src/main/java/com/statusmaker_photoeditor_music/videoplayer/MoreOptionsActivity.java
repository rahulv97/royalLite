package com.statusmaker_photoeditor_music.videoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.AppActivity;
import com.statusmaker_photoeditor_music.videoplayer.themes.StatusPhotosMoreScreen;

public class MoreOptionsActivity extends AppCompatActivity {

    RelativeLayout foot_music, foot_video, foot_photo, foot_vid_down, foot_vid_make, foot_more;

    CardView share_royal, rate_royal, more_royal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_options);

        share_royal = findViewById(R.id.share_roayal);
        rate_royal = findViewById(R.id.rate_royal);
        more_royal = findViewById(R.id.more_royal);

        foot_video = findViewById(R.id.foot_vid);
        foot_music = findViewById(R.id.foot_music);
        
        foot_vid_down = findViewById(R.id.foot_vid_down);
        
        foot_more = findViewById(R.id.foot_more);

        foot_vid_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreOptionsActivity.this, VideoDownloaderActivity.class);
                startActivity(intent);
                finish();
            }
        });

        foot_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreOptionsActivity.this, com.statusmaker_photoeditor_music.videoplayer.VideoSelectorActivity.class);
                startActivity(intent);
                finish();
            }
        });



        foot_more.setBackgroundResource(R.drawable.selected_footer);

        foot_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreOptionsActivity.this, AppActivity.class);
                startActivity(intent);
                finish();
            }
        });



        share_royal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String appLink = "\nhttps://play.google.com/store/apps/details?id=" + getPackageName();
                Intent sendInt = new Intent(Intent.ACTION_SEND);
                sendInt.putExtra(Intent.EXTRA_SUBJECT, "Royal Player");
                sendInt.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_app_message) + appLink);
                sendInt.setType("text/plain");
                startActivity(Intent.createChooser(sendInt, "Share"));
            }
        });

        rate_royal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String appName = getPackageName();
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appName)));
                }
            }
        });

        more_royal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String appName = getPackageName();
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=A%26A+Developer&hl=en")));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=A%26A+Developer&hl=en")));
                }            }
        });

        RelativeLayout downloader_parent = findViewById(R.id.more_activity);
        RelativeLayout footer = findViewById(R.id.app_footer);

        StatusPhotosMoreScreen statusPhotosMoreScreen = new StatusPhotosMoreScreen();
        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme = theme_pref.getString("Theme", "default");

        if (current_theme.equals("theme1")){
            statusPhotosMoreScreen.theme1(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals("theme2")){
            statusPhotosMoreScreen.theme2(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_1))){
            statusPhotosMoreScreen.flat_theme1(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_2))){
            statusPhotosMoreScreen.flat_theme2(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_3))){
            statusPhotosMoreScreen.flat_theme3(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_4))){
            statusPhotosMoreScreen.flat_theme4(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_5))){
            statusPhotosMoreScreen.flat_theme5(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_6))){
            statusPhotosMoreScreen.flat_theme6(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_7))){
            statusPhotosMoreScreen.flat_theme7(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_8))){
            statusPhotosMoreScreen.flat_theme8(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_9))){
            statusPhotosMoreScreen.flat_theme9(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_10))){
            statusPhotosMoreScreen.flat_theme10(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_11))){
            statusPhotosMoreScreen.flat_theme11(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_12))){
            statusPhotosMoreScreen.flat_theme12(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_13))){
            statusPhotosMoreScreen.flat_theme13(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_14))){
            statusPhotosMoreScreen.flat_theme14(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_15))){
            statusPhotosMoreScreen.flat_theme15(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_16))){
            statusPhotosMoreScreen.flat_theme16(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_17))){
            statusPhotosMoreScreen.flat_theme17(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_18))){
            statusPhotosMoreScreen.flat_theme18(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_19))){
            statusPhotosMoreScreen.flat_theme19(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_20))){
            statusPhotosMoreScreen.flat_theme20(MoreOptionsActivity.this, downloader_parent, footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_1))){
            statusPhotosMoreScreen.grad_theme1(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_2))){
            statusPhotosMoreScreen.grad_theme2(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_3))){
            statusPhotosMoreScreen.grad_theme3(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_4))){
            statusPhotosMoreScreen.grad_theme4(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_5))){
            statusPhotosMoreScreen.grad_theme5(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_6))){
            statusPhotosMoreScreen.grad_theme6(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_7))){
            statusPhotosMoreScreen.grad_theme7(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_8))){
            statusPhotosMoreScreen.grad_theme8(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_9))){
            statusPhotosMoreScreen.grad_theme9(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_10))){
            statusPhotosMoreScreen.grad_theme10(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_11))){
            statusPhotosMoreScreen.grad_theme11(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_12))){
            statusPhotosMoreScreen.grad_theme12(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_13))){
            statusPhotosMoreScreen.grad_theme13(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_14))){
            statusPhotosMoreScreen.grad_theme14(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_15))){
            statusPhotosMoreScreen.grad_theme15(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_16))){
            statusPhotosMoreScreen.grad_theme16(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_17))){
            statusPhotosMoreScreen.grad_theme17(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_18))){
            statusPhotosMoreScreen.grad_theme18(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_19))){
            statusPhotosMoreScreen.grad_theme19(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_20))){
            statusPhotosMoreScreen.grad_theme20(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto1))){
            statusPhotosMoreScreen.picto_theme1(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto2))){
            statusPhotosMoreScreen.picto_theme2(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto3))){
            statusPhotosMoreScreen.picto_theme3(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto4))){
            statusPhotosMoreScreen.picto_theme4(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto5))){
            statusPhotosMoreScreen.picto_theme5(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto6))){
            statusPhotosMoreScreen.picto_theme6(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto7))){
            statusPhotosMoreScreen.picto_theme7(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto8))){
            statusPhotosMoreScreen.picto_theme8(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto9))){
            statusPhotosMoreScreen.picto_theme9(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto10))){
            statusPhotosMoreScreen.picto_theme10(MoreOptionsActivity.this, downloader_parent, footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto11))){
            statusPhotosMoreScreen.picto_theme11(MoreOptionsActivity.this, downloader_parent, footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto12))){
            statusPhotosMoreScreen.picto_theme12(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto13))){
            statusPhotosMoreScreen.picto_theme13(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto14))){
            statusPhotosMoreScreen.picto_theme14(MoreOptionsActivity.this, downloader_parent, footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto15))){
            statusPhotosMoreScreen.picto_theme15(MoreOptionsActivity.this, downloader_parent, footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto16))){
            statusPhotosMoreScreen.picto_theme16(MoreOptionsActivity.this, downloader_parent, footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto17))){
            statusPhotosMoreScreen.picto_theme17(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto18))){
            statusPhotosMoreScreen.picto_theme18(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto19))){
            statusPhotosMoreScreen.picto_theme19(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto20))){
            statusPhotosMoreScreen.picto_theme20(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto21))){
            statusPhotosMoreScreen.picto_theme21(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto22))){
            statusPhotosMoreScreen.picto_theme22(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto23))){
            statusPhotosMoreScreen.picto_theme23(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else if (current_theme.equals("CustomTheme")){
            statusPhotosMoreScreen.customTheme(MoreOptionsActivity.this, downloader_parent, footer);
}
else if (current_theme.equals(String.valueOf(R.drawable.picto24))){
            statusPhotosMoreScreen.picto_theme24(MoreOptionsActivity.this, downloader_parent, footer);
        }
        else {

        }


    }
}