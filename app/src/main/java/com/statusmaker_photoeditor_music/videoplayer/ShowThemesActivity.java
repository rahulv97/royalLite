package com.statusmaker_photoeditor_music.videoplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.Adapters.ThemesAdapter;

import java.util.ArrayList;

public class ShowThemesActivity extends AppCompatActivity {

    ImageView back_btn;
    RecyclerView themesRecycler;
    ThemesAdapter themesAdapter;
    ArrayList<Integer> themes = new ArrayList<>();
    ArrayList<Integer> cost = new ArrayList<>();
    public static TextView tvCoin;
    TextView themeType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_themes);

        tvCoin = findViewById(R.id.tvCoin);
        SharedPreferences sp = getSharedPreferences("Coins",MODE_APPEND);
        int coin = sp.getInt("Number",0);
        tvCoin.setText(coin+"");
        if (getIntent().getStringExtra("ThemeName").equals("Flat Themes")){
            themes.add(R.drawable.flat_theme_1);
            cost.add(0);
            themes.add(R.drawable.flat_theme_2);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_3);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_4);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_5);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_6);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_7);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_8);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_9);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_10);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_11);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_12);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_13);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_14);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_15);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_16);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_17);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_18);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_19);
            cost.add(10000);
            themes.add(R.drawable.flat_theme_20);
            cost.add(10000);

        }

        if (getIntent().getStringExtra("ThemeName").equals("Gradient Themes")){
            themes.add(R.drawable.grad_theme_1);
            themes.add(R.drawable.grad_theme_2);
            themes.add(R.drawable.grad_theme_3);
            themes.add(R.drawable.grad_theme_4);
            themes.add(R.drawable.grad_theme_5);
            themes.add(R.drawable.grad_theme_6);
            themes.add(R.drawable.grad_theme_7);
            themes.add(R.drawable.grad_theme_8);
            themes.add(R.drawable.grad_theme_9);
            themes.add(R.drawable.grad_theme_10);
            themes.add(R.drawable.grad_theme_11);
            themes.add(R.drawable.grad_theme_12);
            themes.add(R.drawable.grad_theme_13);
            themes.add(R.drawable.grad_theme_14);
            themes.add(R.drawable.grad_theme_15);
            themes.add(R.drawable.grad_theme_16);
            themes.add(R.drawable.grad_theme_17);
            themes.add(R.drawable.grad_theme_18);
            themes.add(R.drawable.grad_theme_19);
            themes.add(R.drawable.grad_theme_20);
            cost.add(0);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);
            cost.add(30000);


        }

        if (getIntent().getStringExtra("ThemeName").equals("Pictorial Themes")){
            themes.add(R.drawable.picto1);
            themes.add(R.drawable.picto2);
            themes.add(R.drawable.picto3);
            themes.add(R.drawable.picto4);
            themes.add(R.drawable.picto5);
            themes.add(R.drawable.picto6);
            themes.add(R.drawable.picto7);
            themes.add(R.drawable.picto8);
            themes.add(R.drawable.picto9);
            themes.add(R.drawable.picto10);
            themes.add(R.drawable.picto11);
            themes.add(R.drawable.picto12);
            themes.add(R.drawable.picto13);
            themes.add(R.drawable.picto14);
            themes.add(R.drawable.picto15);
            themes.add(R.drawable.picto16);
            themes.add(R.drawable.picto17);
            themes.add(R.drawable.picto18);
            themes.add(R.drawable.picto19);
            themes.add(R.drawable.picto20);
            themes.add(R.drawable.picto21);
            themes.add(R.drawable.picto22);
            themes.add(R.drawable.picto23);
            themes.add(R.drawable.picto24);
            cost.add(0);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
            cost.add(50000);
        }

        if (getIntent().getStringExtra("ThemeName").equals("Music Player Themes")) {
            themes.add(R.drawable.music1);
            themes.add(R.drawable.music2);
            themes.add(R.drawable.music3);
            themes.add(R.drawable.music4);
            themes.add(R.drawable.music5);
            themes.add(R.drawable.music6);
            themes.add(R.drawable.music7);
            themes.add(R.drawable.music8);
            cost.add(0);
            cost.add(15000);
            cost.add(15000);
            cost.add(15000);
            cost.add(15000);
            cost.add(15000);
            cost.add(15000);
            cost.add(15000);
        }

        themesRecycler = findViewById(R.id.themesRecycler);
        themeType = findViewById(R.id.themeType);
        back_btn = findViewById(R.id.back_btn);

        themeType.setText(getIntent().getStringExtra("ThemeName"));

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowThemesActivity.super.onBackPressed();
            }
        });

        themesAdapter = new ThemesAdapter(themes,cost, ShowThemesActivity.this);
        themesRecycler.setLayoutManager(new GridLayoutManager(ShowThemesActivity.this, 2));
        themesRecycler.setAdapter(themesAdapter);
        themesAdapter.notifyDataSetChanged();

    }
}