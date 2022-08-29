package com.statusmaker_photoeditor_music.videoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.royalplayer.lite.R;

public class ThemeActivity extends AppCompatActivity {

    RelativeLayout rec_theme1, rec_theme2;
    ImageView theme_tick1, theme_tick2;

    String current_theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);

        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor_theme = theme_pref.edit();

        rec_theme1  = findViewById(R.id.rec_theme1);
        rec_theme2  = findViewById(R.id.rec_theme2);
        theme_tick1  = findViewById(R.id.theme_tick1);
        theme_tick2  = findViewById(R.id.theme_tick2);

        rec_theme1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theme_tick1.setVisibility(View.VISIBLE);
                theme_tick2.setVisibility(View.GONE);
                editor_theme.putString("Theme", "theme1");
                editor_theme.commit();
            }
        });

        rec_theme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theme_tick1.setVisibility(View.GONE);
                theme_tick2.setVisibility(View.VISIBLE);
                editor_theme.putString("Theme", "theme2");
                editor_theme.commit();
            }
        });

        current_theme = theme_pref.getString("Theme", "default");

        if (current_theme.equals("theme1")){
            theme_tick1.setVisibility(View.VISIBLE);
            theme_tick2.setVisibility(View.GONE);
        }
        else if (current_theme.equals("theme2")){
            theme_tick1.setVisibility(View.GONE);
            theme_tick2.setVisibility(View.VISIBLE);
        }
        else {
            theme_tick1.setVisibility(View.GONE);
            theme_tick2.setVisibility(View.GONE);
        }


    }
}