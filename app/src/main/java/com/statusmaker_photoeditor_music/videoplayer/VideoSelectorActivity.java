package com.statusmaker_photoeditor_music.videoplayer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.Adapters.VideoFileAdapter;
import com.statusmaker_photoeditor_music.videoplayer.Adapters.VideoFileAdapterListView;
import com.statusmaker_photoeditor_music.videoplayer.Adapters.VideoFolderAdapter;
import com.statusmaker_photoeditor_music.videoplayer.Adapters.VideoFolderAdapterListView;
import com.statusmaker_photoeditor_music.videoplayer.live_tv.TVDashboard;
import com.statusmaker_photoeditor_music.videoplayer.music_player.App;
import com.statusmaker_photoeditor_music.videoplayer.music_player.glide.GlideApp;
import com.statusmaker_photoeditor_music.videoplayer.music_player.service.MusicPlayerRemote;
import com.statusmaker_photoeditor_music.videoplayer.music_player.service.MusicService;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.AppActivity;

import com.statusmaker_photoeditor_music.videoplayer.radio.MainActivity;
import com.statusmaker_photoeditor_music.videoplayer.themes.VideoSelectorScreen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VideoSelectorActivity extends AppCompatActivity implements VideoListInterface, VideoDeleteInterface {

    private AdView mAdView;

    RelativeLayout grid_lin;

    LinearLayout live_tv;

    TextView header_txt;

    ArrayList<String> temp_ar = new ArrayList<>();

    RelativeLayout foot_music, foot_video, foot_photo, foot_vid_down, foot_vid_make, foot_more;

    VideoFolderAdapter videoFolderAdapter;

    ArrayList<VideoModel> al_images = new ArrayList<>();

    Boolean boolean_folder = false;

    RecyclerView folder_recycler;

    ArrayList<String> folder_list = new ArrayList<>();

    ArrayList<String> file_paths = new ArrayList<>();


    /************************* Get Files ************************/

    VideoFileAdapter videoFileAdapter;

    VideoFolderAdapterListView videoFolderAdapterListView;
    VideoFileAdapterListView videoFileAdapterListView;

    ArrayList<VideoModel> al_images_file = new ArrayList<>();

    Boolean boolean_file = false;

    RecyclerView file_recycler;

    ArrayList<String> file_list = new ArrayList<>();

    ImageView grid_v, linear_v, theme_img , ivSpinner;

    String list_layout = "linear";

    MusicService service;

    String media_folder_path = "/storage/emulated/0/Android/media";
    String hidden_folder_path = "/storage/emulated/0/Android/media/.video_v";
    String unhidden_folder_path = "/storage/emulated/0/RoyalPlayer";

    VideoSelectorScreen videoSelectorScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_selector);

        folder_recycler = findViewById(R.id.folder_recycler);
        file_recycler = findViewById(R.id.file_recycler);
        live_tv = findViewById(R.id.live_tv);
        ivSpinner = findViewById(R.id.spinner);
        ivSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(VideoSelectorActivity.this,SpinnerActivity.class);
                startActivity(in);
            }
        });

        grid_v = findViewById(R.id.grid_v);
        linear_v = findViewById(R.id.linear_v);
        theme_img = findViewById(R.id.theme_img);

        ImageView video_vault= findViewById(R.id.video_vault);

        theme_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VideoSelectorActivity.this, ThemeDashboardActivity.class));
            }
        });



        live_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(VideoSelectorActivity.this, TVDashboard.class));

                try {
                    if (MusicPlayerRemote.musicService.isPlaying()){
                        MusicPlayerRemote.musicService.pause();
                    }
                }catch (Exception e){

                }

            }
        });


        video_vault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoSelectorActivity.this, AppLockPatternActivity.class);
                intent.putExtra("Task", "DoNothing");
                startActivity(intent);
                finish();
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


        foot_video = findViewById(R.id.foot_vid);
        foot_music = findViewById(R.id.foot_music);
        
        foot_vid_down = findViewById(R.id.foot_vid_down);
        
        header_txt = findViewById(R.id.header_txt);
        grid_lin = findViewById(R.id.grid_lin);
        foot_more = findViewById(R.id.foot_more);

        SharedPreferences app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = app_preferences.edit();


        grid_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid_v.setVisibility(View.GONE);
                linear_v.setVisibility(View.VISIBLE);
                editor.putString("GetView", "linear");
                editor.commit();

                list_layout = "linear";

                videoFolderAdapterListView = new VideoFolderAdapterListView(folder_list,
                        file_paths, list_layout, VideoSelectorActivity.this, VideoSelectorActivity.this::videoListInerface);
                folder_recycler.setLayoutManager(new LinearLayoutManager(VideoSelectorActivity.this));
                folder_recycler.setAdapter(videoFolderAdapterListView);
                videoFolderAdapterListView.notifyDataSetChanged();

            }
        });

        linear_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid_v.setVisibility(View.VISIBLE);
                linear_v.setVisibility(View.GONE);
                editor.putString("GetView", "grid");
                editor.commit();

                list_layout = "grid";

                videoFolderAdapter = new VideoFolderAdapter(folder_list,
                        file_paths, list_layout, VideoSelectorActivity.this, VideoSelectorActivity.this::videoListInerface);
                folder_recycler.setLayoutManager(new GridLayoutManager(VideoSelectorActivity.this, 3));
                folder_recycler.setAdapter(videoFolderAdapter);
                videoFolderAdapter.notifyDataSetChanged();

            }
        });

        list_layout = app_preferences.getString("GetView", "linear");

        if (list_layout.equals("linear")){
            linear_v.setVisibility(View.VISIBLE);
            grid_v.setVisibility(View.GONE);
        }

        if (list_layout.equals("grid")){
            linear_v.setVisibility(View.GONE);
            grid_v.setVisibility(View.VISIBLE);
        }


        foot_vid_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoSelectorActivity.this, VideoDownloaderActivity.class);
                startActivity(intent);
                finish();
            }
        });




        foot_video.setBackgroundResource(R.drawable.selected_footer);

        foot_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideoSelectorActivity.this, AppActivity.class);
                startActivity(intent);
                finish();
            }
        });

        foot_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoSelectorActivity.this, MoreOptionsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        askPermissions();

//        getVideoFolders();



        fetch_theme();

        /*GlideApp.with(this).load(R.drawable.picto1).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    video_selector_main.setBackground(resource);
                }
            }
        });*/



    }

    public ArrayList<VideoModel> getVideoFolders() {
        al_images.clear();
        folder_list.clear();

        int int_position = 0;
        Uri uri;
        Cursor cursor;
        int column_index_data, column_index_folder_name;

        String absolutePathOfImage = null;
        uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA, MediaStore.Video.Media.BUCKET_DISPLAY_NAME};

        final String orderBy = MediaStore.Video.Media.DATE_TAKEN;
        cursor = getApplicationContext().getContentResolver().query(uri, projection, null, null, orderBy + " DESC");

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_folder_name = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME);
        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data);
           // Log.e("Column", absolutePathOfImage);
           // Log.e("Folder", cursor.getString(column_index_folder_name));

            for (int i = 0; i < al_images.size(); i++) {
                if (al_images.get(i).getFolderName().equals(cursor.getString(column_index_folder_name))) {
                    boolean_folder = true;
                    int_position = i;
                    break;
                } else {
                    boolean_folder = false;
                }
            }


            if (boolean_folder) {

                ArrayList<String> al_path = new ArrayList<>();
                al_path.addAll(al_images.get(int_position).getVideoPath());
                al_path.add(absolutePathOfImage);
                al_images.get(int_position).setVideoPath(al_path);

            } else {
                ArrayList<String> al_path = new ArrayList<>();
                al_path.add(absolutePathOfImage);
                VideoModel obj_model = new VideoModel();
                obj_model.setFolderName(cursor.getString(column_index_folder_name));
                obj_model.setVideoPath(al_path);

                al_images.add(obj_model);


            }


        }


        for (int i = 0; i < al_images.size(); i++) {
         //   Log.e("FOLDER", al_images.get(i).getFolderName());

            if (al_images.get(i).getFolderName().equals("0")){
                continue;
            }
            else {
                folder_list.add(al_images.get(i).getFolderName());
            }



            for (int j = 0; j < folder_list.size(); j++) {
                //Log.e("FILE", al_images.get(i).getVideoPath().get(j));

                if (al_images.get(i).getFolderName().equals(folder_list.get(j))){
                    file_paths.add(al_images.get(i).getVideoPath().get(0));

                }


                }

        }



        if (list_layout.equals("linear")){
            linear_v.setVisibility(View.VISIBLE);
            grid_v.setVisibility(View.GONE);
            videoFolderAdapterListView = new VideoFolderAdapterListView(folder_list,
                    file_paths, list_layout, VideoSelectorActivity.this, this::videoListInerface);
            folder_recycler.setLayoutManager(new LinearLayoutManager(VideoSelectorActivity.this));
            folder_recycler.setAdapter(videoFolderAdapterListView);
            videoFolderAdapterListView.notifyDataSetChanged();
        }

        if (list_layout.equals("grid")){
            linear_v.setVisibility(View.GONE);
            grid_v.setVisibility(View.VISIBLE);
            videoFolderAdapter = new VideoFolderAdapter(folder_list,
                    file_paths, list_layout, VideoSelectorActivity.this, this::videoListInerface);
            folder_recycler.setLayoutManager(new GridLayoutManager(VideoSelectorActivity.this, 3));
            folder_recycler.setAdapter(videoFolderAdapter);
            videoFolderAdapter.notifyDataSetChanged();
        }





        return al_images;
    }







    public ArrayList<VideoModel> getVideoFiles(String folder_name) {
        al_images_file.clear();
        file_list.clear();

        int int_position = 0;
        Uri uri;
        Cursor cursor;
        int column_index_data, column_index_folder_name;

        String absolutePathOfImage = null;
        uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA, MediaStore.Video.Media.BUCKET_DISPLAY_NAME};

        final String orderBy = MediaStore.Video.Media.DATE_TAKEN;
        cursor = getApplicationContext().getContentResolver().query(uri, projection, null, null, orderBy + " DESC");

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_folder_name = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME);
        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data);
        //    Log.e("Column", absolutePathOfImage);
          //  Log.e("Folder", cursor.getString(column_index_folder_name));

            for (int i = 0; i < al_images_file.size(); i++) {
                if (al_images_file.get(i).getFolderName().equals(cursor.getString(column_index_folder_name))) {
                    boolean_file = true;
                    int_position = i;
                    break;
                } else {
                    boolean_file = false;
                }
            }


            if (boolean_file) {

                ArrayList<String> al_path = new ArrayList<>();
                al_path.addAll(al_images_file.get(int_position).getVideoPath());
                al_path.add(absolutePathOfImage);
                al_images_file.get(int_position).setVideoPath(al_path);

            } else {
                ArrayList<String> al_path = new ArrayList<>();
                al_path.add(absolutePathOfImage);
                VideoModel obj_model = new VideoModel();
                obj_model.setFolderName(cursor.getString(column_index_folder_name));
                obj_model.setVideoPath(al_path);

                al_images_file.add(obj_model);


            }


        }


        for (int i = 0; i < al_images_file.size(); i++) {
           // Log.e("FOLDER", al_images_file.get(i).getFolderName());
            //file_list.add(al_images_file.get(i).getFolderName());
            for (int j = 0; j < al_images_file.get(i).getVideoPath().size(); j++) {
              //  Log.e("FILE", al_images_file.get(i).getVideoPath().get(j));
                if (al_images_file.get(i).getFolderName().equals(folder_name)){
                    file_list.add(al_images_file.get(i).getVideoPath().get(j));
                }
            }
        }




        if (list_layout.equals("linear")){
            linear_v.setVisibility(View.VISIBLE);
            grid_v.setVisibility(View.GONE);
            videoFileAdapterListView = new VideoFileAdapterListView(file_list, folder_name, list_layout, VideoSelectorActivity.this, this::videoDelete);
            file_recycler.setLayoutManager(new LinearLayoutManager(VideoSelectorActivity.this));
            file_recycler.setAdapter(videoFileAdapterListView);
            videoFileAdapterListView.notifyDataSetChanged();
        }

        if (list_layout.equals("grid")){
            linear_v.setVisibility(View.GONE);
            grid_v.setVisibility(View.VISIBLE);



            videoFileAdapter = new VideoFileAdapter(file_list, folder_name, list_layout, VideoSelectorActivity.this, this::videoDelete);
            file_recycler.setLayoutManager(new GridLayoutManager(VideoSelectorActivity.this, 3));
            file_recycler.setAdapter(videoFileAdapter);
            videoFileAdapter.notifyDataSetChanged();
        }





        return al_images_file;
    }


    @Override
    public void videoListInerface(View view, String folder_name) {
        folder_recycler.setVisibility(View.GONE);
        file_recycler.setVisibility(View.VISIBLE);
        grid_lin.setVisibility(View.GONE);
        getVideoFiles(folder_name);
        header_txt.setText(folder_name);
    }


    @Override
    public void onBackPressed() {
        if (file_recycler.getVisibility()==View.VISIBLE){
            folder_recycler.setVisibility(View.VISIBLE);
            file_recycler.setVisibility(View.GONE);
            grid_lin.setVisibility(View.VISIBLE);
            boolean_file = false;
            boolean_folder = false;
            getVideoFolders();
            header_txt.setText("Royal Player");
        }
        else {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Quit Application")
                    .setMessage("Are you sure you want to Exit the Application?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            VideoSelectorActivity.super.onBackPressed();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();


        }

    }

    FileOutputStream outStream;

    public void askPermissions(){
        Dexter.withContext(VideoSelectorActivity.this).withPermissions("android.permission.BROADCAST_STICKY",
                "android.permission.SET_WALLPAPER",
                "android.permission.WAKE_LOCK",
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE",
                "android.permission.ACCESS_NETWORK_STATE",
                "android.permission.BROADCAST_STICKY",
                "android.permission.RECEIVE_BOOT_COMPLETED",
                "android.permission.FOREGROUND_SERVICE",
                "android.permission.VIBRATE",
                "android.permission.CAMERA")
                .withListener(new MultiplePermissionsListener() {
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        if (multiplePermissionsReport.areAllPermissionsGranted()) {

                        }
                        if (multiplePermissionsReport.isAnyPermissionPermanentlyDenied()) {
                            //SettingDialog.showSettingDialog(VideoSelectorActivity.this);
                        }
                    }

                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).withErrorListener(dexterError -> Toast.makeText(VideoSelectorActivity.this, "Error occurred! ", Toast.LENGTH_SHORT)
                .show()).onSameThread().check();

        getVideoFolders();

        File unhiden_folder = new File(unhidden_folder_path);

        if (unhiden_folder.exists() && unhiden_folder.isDirectory()){

        }
        else {
            unhiden_folder.mkdir();
        }

        File dir = new File(media_folder_path);
        if(dir.exists() && dir.isDirectory()) {
            File hidden_folder = new File(hidden_folder_path);
            if (!hidden_folder.exists()){
                hidden_folder.mkdir();
            }

        }
        else {
            dir.mkdir();
            File hidden_folder = new File(hidden_folder_path);
            hidden_folder.mkdir();
        }

        File file1 = new File("/storage/emulated/0/Android/media/r.jpg");
        if (file1.exists()) {

        }else {



        }

    }


    @Override
    public void videoDelete(int position) {
        file_list.remove(position);

        try {
            videoFileAdapter.notifyDataSetChanged();
        }catch (Exception e){

        }
        try {
            videoFileAdapterListView.notifyDataSetChanged();
        }catch (Exception e){

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        fetch_theme();
    }

    public void fetch_theme(){

        RelativeLayout header_main = findViewById(R.id.header_main);
        RelativeLayout video_selector_main = findViewById(R.id.video_selector_main);
        RelativeLayout app_footer = findViewById(R.id.app_footer);

        videoSelectorScreen = new VideoSelectorScreen();

        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

        String current_theme = theme_pref.getString("Theme", "default");

        if (current_theme.equals("theme1")){
            videoSelectorScreen.theme1(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals("theme2")){
            videoSelectorScreen.theme2(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_1))){
            videoSelectorScreen.flat_theme1(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_2))){
            videoSelectorScreen.flat_theme2(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_3))){
            videoSelectorScreen.flat_theme3(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_4))){
            videoSelectorScreen.flat_theme4(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_5))){
            videoSelectorScreen.flat_theme5(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_6))){
            videoSelectorScreen.flat_theme6(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_7))){
            videoSelectorScreen.flat_theme7(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_8))){
            videoSelectorScreen.flat_theme8(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_9))){
            videoSelectorScreen.flat_theme9(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_10))){
            videoSelectorScreen.flat_theme10(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_11))){
            videoSelectorScreen.flat_theme11(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_12))){
            videoSelectorScreen.flat_theme12(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_13))){
            videoSelectorScreen.flat_theme13(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_14))){
            videoSelectorScreen.flat_theme14(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_15))){
            videoSelectorScreen.flat_theme15(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_16))){
            videoSelectorScreen.flat_theme16(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_17))){
            videoSelectorScreen.flat_theme17(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_18))){
            videoSelectorScreen.flat_theme18(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_19))){
            videoSelectorScreen.flat_theme19(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_20))){
            videoSelectorScreen.flat_theme20(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_1))){
            videoSelectorScreen.grad_theme1(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_2))){
            videoSelectorScreen.grad_theme2(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_3))){
            videoSelectorScreen.grad_theme3(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_4))){
            videoSelectorScreen.grad_theme4(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_5))){
            videoSelectorScreen.grad_theme5(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_6))){
            videoSelectorScreen.grad_theme6(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_7))){
            videoSelectorScreen.grad_theme7(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_8))){
            videoSelectorScreen.grad_theme8(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_9))){
            videoSelectorScreen.grad_theme9(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_10))){
            videoSelectorScreen.grad_theme10(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_11))){
            videoSelectorScreen.grad_theme11(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_12))){
            videoSelectorScreen.grad_theme12(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_13))){
            videoSelectorScreen.grad_theme13(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_14))){
            videoSelectorScreen.grad_theme14(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_15))){
            videoSelectorScreen.grad_theme15(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_16))){
            videoSelectorScreen.grad_theme16(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_17))){
            videoSelectorScreen.grad_theme17(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_18))){
            videoSelectorScreen.grad_theme18(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_19))){
            videoSelectorScreen.grad_theme19(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_20))){
            videoSelectorScreen.grad_theme20(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto1))){
            videoSelectorScreen.picto_theme1(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto2))){
            videoSelectorScreen.picto_theme2(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto3))){
            videoSelectorScreen.picto_theme3(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto4))){
            videoSelectorScreen.picto_theme4(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto5))){
            videoSelectorScreen.picto_theme5(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto6))){
            videoSelectorScreen.picto_theme6(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto7))){
            videoSelectorScreen.picto_theme7(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto8))){
            videoSelectorScreen.picto_theme8(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto9))){
            videoSelectorScreen.picto_theme9(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto10))){
            videoSelectorScreen.picto_theme10(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto11))){
            videoSelectorScreen.picto_theme11(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto12))){
            videoSelectorScreen.picto_theme12(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto13))){
            videoSelectorScreen.picto_theme13(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto14))){
            videoSelectorScreen.picto_theme14(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto15))){
            videoSelectorScreen.picto_theme15(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto16))){
            videoSelectorScreen.picto_theme16(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto17))){
            videoSelectorScreen.picto_theme17(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto18))){
            videoSelectorScreen.picto_theme18(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto19))){
            videoSelectorScreen.picto_theme19(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto20))){
            videoSelectorScreen.picto_theme20(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto21))){
            videoSelectorScreen.picto_theme21(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto22))){
            videoSelectorScreen.picto_theme22(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto23))){
            videoSelectorScreen.picto_theme23(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }
        else if (current_theme.equals("CustomTheme")){
            videoSelectorScreen.customTheme(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }

else if (current_theme.equals(String.valueOf(R.drawable.picto24))){
            videoSelectorScreen.picto_theme24(VideoSelectorActivity.this, header_main, video_selector_main, app_footer);
        }

        else {

        }
    }

}
