package com.statusmaker_photoeditor_music.videoplayer;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.royalplayer.lite.R;
import com.yalantis.ucrop.UCrop;

import java.io.File;

public class CustImageSelectActivity extends AppCompatActivity {

    Button sel_img;
    ImageView imageView;

    public static final int REQUEST_IMAGE = 404;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cust_image_select);

        sel_img = findViewById(R.id.sel_img);
        imageView = findViewById(R.id.imageView);



        sel_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_IMAGE);


            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_IMAGE){

            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int height = displayMetrics.heightPixels;
            int width = displayMetrics.widthPixels;

            Uri uri = data.getData();

            UCrop.of(uri,
                    Uri.fromFile(new File("/storage/emulated/0/RoyalPlayer/theme_img.jpg"))).withAspectRatio(width, height)
                    .start(CustImageSelectActivity.this);
        }else {

        }

        if (resultCode == RESULT_OK && requestCode == UCrop.REQUEST_CROP) {
            final Uri resultUri = UCrop.getOutput(data);

            Glide.with(CustImageSelectActivity.this).load(resultUri).into(imageView);

            SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(CustImageSelectActivity.this);
            SharedPreferences.Editor editor_theme = theme_pref.edit();
            editor_theme.putString("Theme", "CustomTheme");
            editor_theme.commit();

        } else if (resultCode == UCrop.RESULT_ERROR) {
            final Throwable cropError = UCrop.getError(data);
        }

    }
}