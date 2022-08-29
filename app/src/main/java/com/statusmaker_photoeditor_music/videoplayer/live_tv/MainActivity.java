package com.statusmaker_photoeditor_music.videoplayer.live_tv;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.royalplayer.lite.R;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    ProgressBar progressBar;
    ImageView tv_back;
    TextView channel_name;
    RelativeLayout controlView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.tv_activity_main);

        videoView = findViewById(R.id.videoView);
        progressBar = findViewById(R.id.progressBar);
        channel_name = findViewById(R.id.channel_name);
        controlView = findViewById(R.id.controlView);

        String channel_url = getIntent().getStringExtra("ChannelUrl");

        videoView.setVideoPath(channel_url);
        videoView.start();

        tv_back = findViewById(R.id.tv_back);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.super.onBackPressed();
            }
        });

        channel_name.setText(getIntent().getStringExtra("ChannelName"));

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
                        switch (what) {
                            case MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START: {
                                progressBar.setVisibility(View.GONE);
                                return true;
                            }
                            case MediaPlayer.MEDIA_INFO_BUFFERING_START: {
                                progressBar.setVisibility(View.VISIBLE);
                                return true;
                            }
                            case MediaPlayer.MEDIA_INFO_BUFFERING_END: {
                                progressBar.setVisibility(View.GONE);
                                return true;
                            }
                        }
                        return false;
                    }
                });
            }
        });



        videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlView.setVisibility(View.VISIBLE);
                new CountDownTimer(10000, 1000){

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        controlView.setVisibility(View.GONE);
                    }
                }.start();
            }
        });

        controlView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controlView.setVisibility(View.GONE);
            }
        });



    }
}
