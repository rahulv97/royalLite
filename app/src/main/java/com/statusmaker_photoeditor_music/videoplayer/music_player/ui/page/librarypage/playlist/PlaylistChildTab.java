package com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.librarypage.playlist;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.MusicServiceActivity;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.MusicServiceFragment;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.subpages.PlaylistPagerFragment;
import com.statusmaker_photoeditor_music.videoplayer.music_player.loader.medialoader.PlaylistLoader;
import com.statusmaker_photoeditor_music.videoplayer.music_player.model.Playlist;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.featurepage.FeaturePlaylistAdapter;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.widget.fragmentnavigationcontroller.NavigationFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlaylistChildTab extends MusicServiceFragment implements FeaturePlaylistAdapter.PlaylistClickListener {
    public static final String TAG ="PlaylistChildTab";

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    PlaylistChildAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.playlist_child_tab,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        mAdapter = new PlaylistChildAdapter(getActivity(),true);
        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);


        if(getActivity() instanceof MusicServiceActivity) {
            ((MusicServiceActivity)getActivity()).addMusicServiceEventListener(this);
        }
        refreshData();
    }
    private void refreshData() {
        if(getActivity() !=null)
      mAdapter.setData(PlaylistLoader.getAllPlaylistsWithAuto(getActivity()));
    }

    @Override
    public void onClickPlaylist(Playlist playlist, @org.jetbrains.annotations.Nullable Bitmap bitmap) {
        NavigationFragment sf = PlaylistPagerFragment.newInstance(getContext(),playlist,bitmap);
        Fragment parentFragment = getParentFragment();
        if(parentFragment instanceof NavigationFragment)
            ((NavigationFragment)parentFragment).getNavigationController().presentFragment(sf);
    }

    @Override
    public void onMediaStoreChanged() {
        refreshData();
    }

}
