package com.statusmaker_photoeditor_music.videoplayer.live_tv;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.themes.TvDashboardScreen;

public class TVDashboard extends AppCompatActivity {

    ImageView nbc, bbc, b4u_kadak, punjab_zindabad, dd_national, dd_sports, jhanjar_tv, cnbc_awaas, ndtv_24x7, punjaab_tv, tv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvdashboard);

        nbc = findViewById(R.id.nbc);
        bbc = findViewById(R.id.bbc);

        b4u_kadak = findViewById(R.id.b4u_kadak);
        punjab_zindabad = findViewById(R.id.punjab_zindabad);
        dd_national = findViewById(R.id.dd_national);
        dd_sports = findViewById(R.id.dd_sports);
        jhanjar_tv = findViewById(R.id.jhanjar_tv);
        cnbc_awaas = findViewById(R.id.cnbc_awaas);
        ndtv_24x7 = findViewById(R.id.ndtv_24x7);
        punjaab_tv = findViewById(R.id.punjaab_tv);
        tv_back = findViewById(R.id.tv_back);

        RelativeLayout head_tv = findViewById(R.id.head_tv);

        TvDashboardScreen tvDashboardScreen = new TvDashboardScreen();

        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme = theme_pref.getString("Theme", "default");

        if (current_theme.equals("theme1")){
            tvDashboardScreen.theme1(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals("theme2")){
            tvDashboardScreen.theme2(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_1))){
            tvDashboardScreen.flat_theme1(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_2))){
            tvDashboardScreen.flat_theme2(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_3))){
            tvDashboardScreen.flat_theme3(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_4))){
            tvDashboardScreen.flat_theme4(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_5))){
            tvDashboardScreen.flat_theme5(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_6))){
            tvDashboardScreen.flat_theme6(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_7))){
            tvDashboardScreen.flat_theme7(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_8))){
            tvDashboardScreen.flat_theme8(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_9))){
            tvDashboardScreen.flat_theme9(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_10))){
            tvDashboardScreen.flat_theme10(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_11))){
            tvDashboardScreen.flat_theme11(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_12))){
            tvDashboardScreen.flat_theme12(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_13))){
            tvDashboardScreen.flat_theme13(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_14))){
            tvDashboardScreen.flat_theme14(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_15))){
            tvDashboardScreen.flat_theme15(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_16))){
            tvDashboardScreen.flat_theme16(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_17))){
            tvDashboardScreen.flat_theme17(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_18))){
            tvDashboardScreen.flat_theme18(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_19))){
            tvDashboardScreen.flat_theme19(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_20))){
            tvDashboardScreen.flat_theme20(TVDashboard.this, head_tv);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_1))){
            tvDashboardScreen.grad_theme1(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_2))){
            tvDashboardScreen.grad_theme2(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_3))){
            tvDashboardScreen.grad_theme3(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_4))){
            tvDashboardScreen.grad_theme4(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_5))){
            tvDashboardScreen.grad_theme5(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_6))){
            tvDashboardScreen.grad_theme6(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_7))){
            tvDashboardScreen.grad_theme7(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_8))){
            tvDashboardScreen.grad_theme8(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_9))){
            tvDashboardScreen.grad_theme9(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_10))){
            tvDashboardScreen.grad_theme10(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_11))){
            tvDashboardScreen.grad_theme11(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_12))){
            tvDashboardScreen.grad_theme12(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_13))){
            tvDashboardScreen.grad_theme13(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_14))){
            tvDashboardScreen.grad_theme14(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_15))){
            tvDashboardScreen.grad_theme15(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_16))){
            tvDashboardScreen.grad_theme16(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_17))){
            tvDashboardScreen.grad_theme17(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_18))){
            tvDashboardScreen.grad_theme18(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_19))){
            tvDashboardScreen.grad_theme19(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_20))){
            tvDashboardScreen.grad_theme20(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto1))){
            tvDashboardScreen.picto_theme1(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto2))){
            tvDashboardScreen.picto_theme2(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto3))){
            tvDashboardScreen.picto_theme3(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto4))){
            tvDashboardScreen.picto_theme4(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto5))){
            tvDashboardScreen.picto_theme5(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto6))){
            tvDashboardScreen.picto_theme6(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto7))){
            tvDashboardScreen.picto_theme7(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto8))){
            tvDashboardScreen.picto_theme8(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto9))){
            tvDashboardScreen.picto_theme9(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto10))){
            tvDashboardScreen.picto_theme10(TVDashboard.this, head_tv);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto11))){
            tvDashboardScreen.picto_theme11(TVDashboard.this, head_tv);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto12))){
            tvDashboardScreen.picto_theme12(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto13))){
            tvDashboardScreen.picto_theme13(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto14))){
            tvDashboardScreen.picto_theme14(TVDashboard.this, head_tv);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto15))){
            tvDashboardScreen.picto_theme15(TVDashboard.this, head_tv);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto16))){
            tvDashboardScreen.picto_theme16(TVDashboard.this, head_tv);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto17))){
            tvDashboardScreen.picto_theme17(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto18))){
            tvDashboardScreen.picto_theme18(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto19))){
            tvDashboardScreen.picto_theme19(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto20))){
            tvDashboardScreen.picto_theme20(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto21))){
            tvDashboardScreen.picto_theme21(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto22))){
            tvDashboardScreen.picto_theme22(TVDashboard.this, head_tv);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto23))){
            tvDashboardScreen.picto_theme23(TVDashboard.this, head_tv);
        }

else if (current_theme.equals(String.valueOf(R.drawable.picto24))){
            tvDashboardScreen.picto_theme24(TVDashboard.this, head_tv);
        }
        else {

        }



        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TVDashboard.super.onBackPressed();
            }
        });


        b4u_kadak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TVDashboard.this, MainActivity.class);
                intent.putExtra("ChannelUrl", "http://103.199.160.85/Content/moviehouse/Live/Channel(MovieHouse)/index.m3u8");
                intent.putExtra("ChannelName", "B4U Kadak");
                startActivity(intent);
            }
        });

        punjab_zindabad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TVDashboard.this, MainActivity.class);
                intent.putExtra("ChannelUrl", "http://stream.pztv.online/pztv/tracks-v1a1/mono.m3u8");
                intent.putExtra("ChannelName", "Punjabi Zindabad");
                startActivity(intent);
            }
        });

        dd_national.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TVDashboard.this, MainActivity.class);
                intent.putExtra("ChannelUrl", "http://103.199.161.254/Content/ddnational/Live/Channel(DDNational)/index.m3u8");
                intent.putExtra("ChannelName", "DD National");
                startActivity(intent);
            }
        });

        dd_sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TVDashboard.this, MainActivity.class);
                intent.putExtra("ChannelUrl", "http://103.199.161.254/Content/ddsports/Live/Channel(DDSPORTS)/index.m3u8");
                intent.putExtra("ChannelName", "DD Sports");
                startActivity(intent);
            }
        });

        jhanjar_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TVDashboard.this, MainActivity.class);
                intent.putExtra("ChannelUrl", "http://159.203.9.134/hls/jhanjar_music/jhanjar_music.m3u8");
                intent.putExtra("ChannelName", "Jhanjar Music");
                startActivity(intent);
            }
        });

        cnbc_awaas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TVDashboard.this, MainActivity.class);
                intent.putExtra("ChannelUrl", "https://cnbcawaaz-lh.akamaihd.net/i/cnbcawaaz_1@174872/index_5_av-p.m3u8");
                intent.putExtra("ChannelName", "CNBC Awaaz");
                startActivity(intent);
            }
        });

        ndtv_24x7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TVDashboard.this, MainActivity.class);
                intent.putExtra("ChannelUrl", "https://ndtv24x7elemarchana.akamaized.net/hls/live/2003678/ndtv24x7/master.m3u8");
                intent.putExtra("ChannelName", "NDTV 24x7");
                startActivity(intent);
            }
        });

        punjaab_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TVDashboard.this, MainActivity.class);
                intent.putExtra("ChannelUrl", "http://158.69.124.9:1935/5aabtv/5aabtv/playlist.m3u8");
                intent.putExtra("ChannelName", "5aab TV");
                startActivity(intent);
            }
        });


        nbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TVDashboard.this, MainActivity.class);
                intent.putExtra("ChannelUrl", "https://nbcnews2.akamaized.net/hls/live/723426/NBCNewsPlaymaker24x7Linear99a3a827-ua/master.m3u8");
                intent.putExtra("ChannelName", "NBC News");
                startActivity(intent);
            }
        });

        bbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TVDashboard.this, MainActivity.class);
                intent.putExtra("ChannelName", "BBC News");
                intent.putExtra("ChannelUrl", "https://1111296894.rsc.cdn77.org/LS-ATL-54548-11/index.m3u8");
                startActivity(intent);
            }
        });

    }
}
