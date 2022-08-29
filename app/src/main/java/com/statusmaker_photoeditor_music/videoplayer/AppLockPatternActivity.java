package com.statusmaker_photoeditor_music.videoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.themes.AppLockPatternScreen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import io.paperdb.Paper;

public class AppLockPatternActivity extends AppCompatActivity {

    String save_pattern_key = "pattern_code";

    String final_pattern;

    PatternLockView choose_pattern, verify_pattern;

    AppLockPatternScreen appLockPatternScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        appLockPatternScreen = new AppLockPatternScreen();

        Paper.init(this);

        String save_pattern = Paper.book().read(save_pattern_key);

        if (save_pattern != null && !save_pattern.equals("null")){
            setContentView(R.layout.lock_screen);
            verify_pattern = findViewById(R.id.verify_pattern);

            RelativeLayout lock_screen_main = findViewById(R.id.lock_screen_main);

            SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

            String current_theme = theme_pref.getString("Theme", "default");

            if (current_theme.equals("theme1")){
                appLockPatternScreen.theme1(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals("theme2")){
                appLockPatternScreen.theme2(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_1))){
                appLockPatternScreen.flat_theme1(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_2))){
                appLockPatternScreen.flat_theme2(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_3))){
                appLockPatternScreen.flat_theme3(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_4))){
                appLockPatternScreen.flat_theme4(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_5))){
                appLockPatternScreen.flat_theme5(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_6))){
                appLockPatternScreen.flat_theme6(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_7))){
                appLockPatternScreen.flat_theme7(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_8))){
                appLockPatternScreen.flat_theme8(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_9))){
                appLockPatternScreen.flat_theme9(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_10))){
                appLockPatternScreen.flat_theme10(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_11))){
                appLockPatternScreen.flat_theme11(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_12))){
                appLockPatternScreen.flat_theme12(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_13))){
                appLockPatternScreen.flat_theme13(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_14))){
                appLockPatternScreen.flat_theme14(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_15))){
                appLockPatternScreen.flat_theme15(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_16))){
                appLockPatternScreen.flat_theme16(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_17))){
                appLockPatternScreen.flat_theme17(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_18))){
                appLockPatternScreen.flat_theme18(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_19))){
                appLockPatternScreen.flat_theme19(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_20))){
                appLockPatternScreen.flat_theme20(AppLockPatternActivity.this, lock_screen_main);
            }

            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_1))){
                appLockPatternScreen.grad_theme1(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_2))){
                appLockPatternScreen.grad_theme2(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_3))){
                appLockPatternScreen.grad_theme3(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_4))){
                appLockPatternScreen.grad_theme4(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_5))){
                appLockPatternScreen.grad_theme5(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_6))){
                appLockPatternScreen.grad_theme6(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_7))){
                appLockPatternScreen.grad_theme7(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_8))){
                appLockPatternScreen.grad_theme8(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_9))){
                appLockPatternScreen.grad_theme9(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_10))){
                appLockPatternScreen.grad_theme10(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_11))){
                appLockPatternScreen.grad_theme11(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_12))){
                appLockPatternScreen.grad_theme12(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_13))){
                appLockPatternScreen.grad_theme13(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_14))){
                appLockPatternScreen.grad_theme14(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_15))){
                appLockPatternScreen.grad_theme15(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_16))){
                appLockPatternScreen.grad_theme16(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_17))){
                appLockPatternScreen.grad_theme17(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_18))){
                appLockPatternScreen.grad_theme18(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_19))){
                appLockPatternScreen.grad_theme19(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_20))){
                appLockPatternScreen.grad_theme20(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto1))){
                appLockPatternScreen.picto_theme1(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto2))){
                appLockPatternScreen.picto_theme2(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto3))){
                appLockPatternScreen.picto_theme3(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto4))){
                appLockPatternScreen.picto_theme4(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto5))){
                appLockPatternScreen.picto_theme5(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto6))){
                appLockPatternScreen.picto_theme6(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto7))){
                appLockPatternScreen.picto_theme7(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto8))){
                appLockPatternScreen.picto_theme8(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto9))){
                appLockPatternScreen.picto_theme9(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto10))){
                appLockPatternScreen.picto_theme10(AppLockPatternActivity.this, lock_screen_main);
            }

            else if (current_theme.equals(String.valueOf(R.drawable.picto11))){
                appLockPatternScreen.picto_theme11(AppLockPatternActivity.this, lock_screen_main);
            }

            else if (current_theme.equals(String.valueOf(R.drawable.picto12))){
                appLockPatternScreen.picto_theme12(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto13))){
                appLockPatternScreen.picto_theme13(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto14))){
                appLockPatternScreen.picto_theme14(AppLockPatternActivity.this, lock_screen_main);
            }

            else if (current_theme.equals(String.valueOf(R.drawable.picto15))){
                appLockPatternScreen.picto_theme15(AppLockPatternActivity.this, lock_screen_main);
            }

            else if (current_theme.equals(String.valueOf(R.drawable.picto16))){
                appLockPatternScreen.picto_theme16(AppLockPatternActivity.this, lock_screen_main);
            }

            else if (current_theme.equals(String.valueOf(R.drawable.picto17))){
                appLockPatternScreen.picto_theme17(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto18))){
                appLockPatternScreen.picto_theme18(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto19))){
                appLockPatternScreen.picto_theme19(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto20))){
                appLockPatternScreen.picto_theme20(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto21))){
                appLockPatternScreen.picto_theme21(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto22))){
                appLockPatternScreen.picto_theme22(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto23))){
                appLockPatternScreen.picto_theme23(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals(String.valueOf(R.drawable.picto24))){
                appLockPatternScreen.picto_theme24(AppLockPatternActivity.this, lock_screen_main);
            }
            else if (current_theme.equals("CustomTheme")){
                appLockPatternScreen.customTheme(AppLockPatternActivity.this, lock_screen_main);
            }
            else {

            }

            verify_pattern.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() {

                }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) {

                }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {
                    final_pattern = PatternLockUtils.patternToString(verify_pattern, pattern);
                    if (final_pattern.equals(save_pattern)){

                        hide_file();

                        startActivity(new Intent(AppLockPatternActivity.this, HiddenVideos.class));
                        finish();
                    }
                    else {
                        Toast.makeText(AppLockPatternActivity.this, "Wrong Pattern", Toast.LENGTH_LONG).show();

                        new Thread(){
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(1000);
                                    verify_pattern.clearPattern();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();

                    }
                }

                @Override
                public void onCleared() {

                }
            });
        }

        else {
            setContentView(R.layout.activity_app_lock_pattern);
            choose_pattern = findViewById(R.id.choose_pattern);

            RelativeLayout header_main_lock = findViewById(R.id.header_main_lock);

            SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(this);

            String current_theme = theme_pref.getString("Theme", "default");

            if (current_theme.equals("theme1")){
                appLockPatternScreen.theme1(AppLockPatternActivity.this, header_main_lock);

            }
            else if (current_theme.equals("theme2")){
                appLockPatternScreen.theme2(AppLockPatternActivity.this, header_main_lock);

            }
            else {

            }

            choose_pattern.addPatternLockListener(new PatternLockViewListener() {
                @Override
                public void onStarted() {

                }

                @Override
                public void onProgress(List<PatternLockView.Dot> progressPattern) {

                }

                @Override
                public void onComplete(List<PatternLockView.Dot> pattern) {
                    String temp_pattern = PatternLockUtils.patternToString(choose_pattern, pattern);

                    if (temp_pattern.length() >= 4) {
                        final_pattern = PatternLockUtils.patternToString(choose_pattern, pattern);
                        Paper.book().write(save_pattern_key, final_pattern);

                        hide_file();

                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);

                    } else {
                        Toast.makeText(AppLockPatternActivity.this, "Please Choose At Least 4 dots", Toast.LENGTH_LONG).show();

                        new Thread(){
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(1000);
                                    choose_pattern.clearPattern();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();
                    }


                }

                @Override
                public void onCleared() {

                }
            });
        }


    }

    InputStream in = null;
    OutputStream out = null;

    public void hide_file(){

        try {
            String task = getIntent().getStringExtra("Task");
            String inputPath = getIntent().getStringExtra("FilePath");

            String outputPath = "/storage/emulated/0/Android/media/.video_v/";

            File infile = new File(inputPath);

            String inputFile = infile.getName();

            if (task.equals("HideFile")){
                in = new FileInputStream(inputPath);
                out = new FileOutputStream(outputPath + inputFile);

                byte[] buffer = new byte[1024];
                int read;
                while ((read = in.read(buffer)) != -1) {
                    out.write(buffer, 0, read);
                }
                in.close();
                in = null;

                // write the output file
                out.flush();
                out.close();
                out = null;

                // delete the original file
                deleteImage(new File(inputPath));
                videoSelectorActivity.videoDelete(getIntent().getIntExtra("position", 0));


            }else {

            }
        }catch (Exception e){

        }



    }

    VideoSelectorActivity videoSelectorActivity;

    private void deleteImage(File file) {
        // Set up the projection (we only need the ID)
        String[] projection = {MediaStore.Video.Media._ID};

        // Match on the file path
        String selection = MediaStore.Video.Media.DATA + " = ?";
        String[] selectionArgs = new String[]{file.getAbsolutePath()};

        // Query for the ID of the media matching the file path
        Uri queryUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = getContentResolver();
        Cursor c = contentResolver.query(queryUri, projection, selection, selectionArgs, null);
        if (c.moveToFirst()) {
            // We found the ID. Deleting the item via the content provider will also remove the file
            long id = c.getLong(c.getColumnIndexOrThrow(MediaStore.Video.Media._ID));
            Uri deleteUri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id);
            contentResolver.delete(deleteUri, null, null);
        } else {
            // File not found in media store DB
        }
        c.close();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AppLockPatternActivity.this, VideoSelectorActivity.class));
        finish();
    }
}