package com.statusmaker_photoeditor_music.videoplayer.themes;

import android.app.Activity;
import android.view.Window;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.Toolbar;

import com.royalplayer.lite.R;

public class MakerImageSelectScreen {
    public void theme1(Activity activity, Toolbar toolbar, RelativeLayout relativeLayout){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.yellow));

        toolbar.setBackgroundResource(R.drawable.theme1);
        relativeLayout.setBackgroundResource(R.drawable.theme1);

    }

    public void theme2(Activity activity, Toolbar toolbar, RelativeLayout relativeLayout){
        Window window = activity.getWindow();
        window.setStatusBarColor(activity.getResources().getColor(R.color.theme2));

        toolbar.setBackgroundResource(R.drawable.theme2);
        relativeLayout.setBackgroundResource(R.drawable.theme2);

    }

}
