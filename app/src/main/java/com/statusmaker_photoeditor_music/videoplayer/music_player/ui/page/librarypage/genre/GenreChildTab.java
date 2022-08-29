package com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.librarypage.genre;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.MusicServiceFragment;

import butterknife.BindDimen;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class GenreChildTab extends MusicServiceFragment {
    public static final String TAG="GenreChildTab";

    public static GenreChildTab newInstance() {
        return new GenreChildTab();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.genre_child_tab,container,false);
    }

    @BindDimen(R.dimen.minimum_bottom_back_stack_margin)
    float mMinBottomPadding;

    @BindDimen(R.dimen._16dp)
    float m16Dp;

    private Unbinder mUnbinder;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this,view);
    }

    @Override
    public void onMediaStoreChanged() {}

    @Override
    public void onDestroyView() {

        if(mUnbinder!=null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
        super.onDestroyView();
    }
}

