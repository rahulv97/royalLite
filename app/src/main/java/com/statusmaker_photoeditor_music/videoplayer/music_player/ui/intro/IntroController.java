package com.statusmaker_photoeditor_music.videoplayer.music_player.ui.intro;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.widget.fragmentnavigationcontroller.FragmentNavigationController;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.widget.fragmentnavigationcontroller.NavigationFragment;

import static com.statusmaker_photoeditor_music.videoplayer.music_player.ui.widget.fragmentnavigationcontroller.NavigationFragment.PRESENT_STYLE_DEFAULT;

/**
 * Controller này tự động loại bỏ giao diện màn hình chính và hiển thị các màn hình (PermissionRequire, NoSongInLibrary) khi cần
 */
public class IntroController {
    private static final String TAG = "IntroController";

    FragmentNavigationController mNavigationController;

    public FragmentNavigationController getNavigationController() {
        return mNavigationController;
    }

    public IntroController() {

    }

    public void init(AppCompatActivity activity, Bundle savedInstanceState) {
        initBackStack(activity, savedInstanceState);

    }

    private boolean isNavigationControllerInit() {
        return null != mNavigationController;
    }

    public void presentFragment(NavigationFragment fragment) {
        Log.d(TAG, "presentFragment");
        if (isNavigationControllerInit()) {
            Log.d(TAG, "presentFragment: INIT");
//            Random r = new Random();
//            mNavigationController.setPresentStyle(r.nextInt(39)+1); //exclude NONE present style
            mNavigationController.setPresentStyle(fragment.getPresentTransition());

            //setTheme(fragment.isWhiteTheme());
            mNavigationController.presentFragment(fragment, true);

        }
    }

    private void initBackStack(AppCompatActivity activity, Bundle savedInstanceState) {
        FragmentManager fm = activity.getSupportFragmentManager();
        mNavigationController = FragmentNavigationController.navigationController(fm, R.id.back_wall_container);
        mNavigationController.setAbleToPopRoot(true);
        mNavigationController.setPresentStyle(PRESENT_STYLE_DEFAULT);
        mNavigationController.setDuration(250);
        mNavigationController.setInterpolator(new AccelerateDecelerateInterpolator());
        mNavigationController.presentFragment(new PermissionRequiredFragment());
        // mNavigationController.presentFragment(new MainFragment());
    }
}
