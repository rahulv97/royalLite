package com.statusmaker_photoeditor_music.videoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.Adapters.HiddenVideoFileAdapter;
import com.statusmaker_photoeditor_music.videoplayer.Adapters.VideoFileAdapter;
import com.statusmaker_photoeditor_music.videoplayer.Adapters.VideoFileAdapterListView;
import com.statusmaker_photoeditor_music.videoplayer.themes.HiddenVideosScreen;

import java.io.File;
import java.util.ArrayList;

public class HiddenVideos extends AppCompatActivity implements VideoDeleteInterface {

    HiddenVideoFileAdapter videoFileAdapterListView;

    RecyclerView file_recycler;

    TextView no_hidden_video;

    RelativeLayout header_main_lock, header_main;

    HiddenVideosScreen hiddenVideosScreen;

    ArrayList<String> file_list = new ArrayList<>();
    String list_layout = "linear";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidden_videos);

        file_recycler = findViewById(R.id.file_recycler);
        no_hidden_video = findViewById(R.id.no_hidden_video);

        header_main_lock = findViewById(R.id.hidden_videos_parent);
        header_main = findViewById(R.id.header_main);

        hiddenVideosScreen = new HiddenVideosScreen();

        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme = theme_pref.getString("Theme", "default");

        if (current_theme.equals("theme1")){
            hiddenVideosScreen.theme1(HiddenVideos.this, header_main_lock, header_main);

        }
        else if (current_theme.equals("theme2")){
            hiddenVideosScreen.theme2(HiddenVideos.this, header_main_lock, header_main);

        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_1))){
            hiddenVideosScreen.flat_theme1(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_2))){
            hiddenVideosScreen.flat_theme2(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_3))){
            hiddenVideosScreen.flat_theme3(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_4))){
            hiddenVideosScreen.flat_theme4(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_5))){
            hiddenVideosScreen.flat_theme5(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_6))){
            hiddenVideosScreen.flat_theme6(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_7))){
            hiddenVideosScreen.flat_theme7(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_8))){
            hiddenVideosScreen.flat_theme8(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_9))){
            hiddenVideosScreen.flat_theme9(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_10))){
            hiddenVideosScreen.flat_theme10(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_11))){
            hiddenVideosScreen.flat_theme11(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_12))){
            hiddenVideosScreen.flat_theme12(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_13))){
            hiddenVideosScreen.flat_theme13(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_14))){
            hiddenVideosScreen.flat_theme14(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_15))){
            hiddenVideosScreen.flat_theme15(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_16))){
            hiddenVideosScreen.flat_theme16(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_17))){
            hiddenVideosScreen.flat_theme17(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_18))){
            hiddenVideosScreen.flat_theme18(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_19))){
            hiddenVideosScreen.flat_theme19(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_20))){
            hiddenVideosScreen.flat_theme20(HiddenVideos.this, header_main_lock, header_main);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_1))){
            hiddenVideosScreen.grad_theme1(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_2))){
            hiddenVideosScreen.grad_theme2(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_3))){
            hiddenVideosScreen.grad_theme3(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_4))){
            hiddenVideosScreen.grad_theme4(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_5))){
            hiddenVideosScreen.grad_theme5(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_6))){
            hiddenVideosScreen.grad_theme6(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_7))){
            hiddenVideosScreen.grad_theme7(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_8))){
            hiddenVideosScreen.grad_theme8(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_9))){
            hiddenVideosScreen.grad_theme9(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_10))){
            hiddenVideosScreen.grad_theme10(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_11))){
            hiddenVideosScreen.grad_theme11(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_12))){
            hiddenVideosScreen.grad_theme12(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_13))){
            hiddenVideosScreen.grad_theme13(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_14))){
            hiddenVideosScreen.grad_theme14(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_15))){
            hiddenVideosScreen.grad_theme15(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_16))){
            hiddenVideosScreen.grad_theme16(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_17))){
            hiddenVideosScreen.grad_theme17(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_18))){
            hiddenVideosScreen.grad_theme18(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_19))){
            hiddenVideosScreen.grad_theme19(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_20))){
            hiddenVideosScreen.grad_theme20(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto1))){
            hiddenVideosScreen.picto_theme1(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto2))){
            hiddenVideosScreen.picto_theme2(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto3))){
            hiddenVideosScreen.picto_theme3(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto4))){
            hiddenVideosScreen.picto_theme4(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto5))){
            hiddenVideosScreen.picto_theme5(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto6))){
            hiddenVideosScreen.picto_theme6(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto7))){
            hiddenVideosScreen.picto_theme7(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto8))){
            hiddenVideosScreen.picto_theme8(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto9))){
            hiddenVideosScreen.picto_theme9(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto10))){
            hiddenVideosScreen.picto_theme10(HiddenVideos.this, header_main_lock, header_main);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto11))){
            hiddenVideosScreen.picto_theme11(HiddenVideos.this, header_main_lock, header_main);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto12))){
            hiddenVideosScreen.picto_theme12(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto13))){
            hiddenVideosScreen.picto_theme13(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto14))){
            hiddenVideosScreen.picto_theme14(HiddenVideos.this, header_main_lock, header_main);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto15))){
            hiddenVideosScreen.picto_theme15(HiddenVideos.this, header_main_lock, header_main);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto16))){
            hiddenVideosScreen.picto_theme16(HiddenVideos.this, header_main_lock, header_main);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto17))){
            hiddenVideosScreen.picto_theme17(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto18))){
            hiddenVideosScreen.picto_theme18(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto19))){
            hiddenVideosScreen.picto_theme19(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto20))){
            hiddenVideosScreen.picto_theme20(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto21))){
            hiddenVideosScreen.picto_theme21(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto22))){
            hiddenVideosScreen.picto_theme22(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto23))){
            hiddenVideosScreen.picto_theme23(HiddenVideos.this, header_main_lock, header_main);
        }
        else if (current_theme.equals("CustomTheme")){
            hiddenVideosScreen.customTheme(HiddenVideos.this, header_main_lock, header_main);
}
else if (current_theme.equals(String.valueOf(R.drawable.picto24))){
            hiddenVideosScreen.picto_theme24(HiddenVideos.this, header_main_lock, header_main);
        }
        else {

        }

        getVideoFiles("/storage/emulated/0/Android/media/.video_v");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(HiddenVideos.this, VideoSelectorActivity.class));
        finish();
    }

    public void getVideoFiles(String folder_path) {
        File directory = new File(folder_path);
        File[] files = directory.listFiles();

        if (files.length==0){
            no_hidden_video.setVisibility(View.VISIBLE);
        }
        else {
            no_hidden_video.setVisibility(View.GONE);
        }

        for (int i=0; i<files.length; i++){
            file_list.add(files[i].getPath());
            Log.e("HiddenFiles", files[i].getName());
        }

        videoFileAdapterListView = new HiddenVideoFileAdapter(file_list, ".video_v", list_layout, HiddenVideos.this, this::videoDelete);
        file_recycler.setLayoutManager(new LinearLayoutManager(HiddenVideos.this));
        file_recycler.setAdapter(videoFileAdapterListView);
        videoFileAdapterListView.notifyDataSetChanged();

    }

    @Override
    public void videoDelete(int position) {
        file_list.remove(position);

        try {
            videoFileAdapterListView.notifyDataSetChanged();
        }catch (Exception e){

        }

    }




    
}