package com.statusmaker_photoeditor_music.videoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;

import com.bullhead.equalizer.DialogEqualizerFragment;
import com.bullhead.equalizer.EqualizerFragment;
import com.royalplayer.lite.R;

import static com.statusmaker_photoeditor_music.videoplayer.MainActivity.player;

public class EqualizerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equalizer);
        openEqualizer();
    }

    public void openEqualizer(){


        /* DialogEqualizerFragment fragment = DialogEqualizerFragment.newBuilder()
                        .setAudioSessionId(0)
                        .themeColor(ContextCompat.getColor(EqualizerActivity.this, R.color.flatRed))
                        .textColor(ContextCompat.getColor(EqualizerActivity.this, R.color.white))
                        .accentAlpha(ContextCompat.getColor(EqualizerActivity.this, R.color.flatBlue))
                        .darkColor(ContextCompat.getColor(EqualizerActivity.this, R.color.flatOrange))
                        .setAccentColor(ContextCompat.getColor(EqualizerActivity.this, R.color.flatGreenEnd))
                        .build();
                fragment.show(getSupportFragmentManager(), "eq");*/

                EqualizerFragment equalizerFragment = EqualizerFragment.newBuilder()
                        .setAccentColor(Color.parseColor("#4caf50"))
                        .setAudioSessionId(getIntent().getIntExtra("id", 0))
                        .build();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.eqFrame, equalizerFragment)
                        .commit();


    }



}