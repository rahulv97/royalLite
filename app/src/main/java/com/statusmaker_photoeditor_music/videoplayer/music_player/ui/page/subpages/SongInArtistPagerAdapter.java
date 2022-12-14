package com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.subpages;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.music_player.helper.menu.SongMenuHelper;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.librarypage.song.SongChildAdapter;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.bottomsheet.OptionBottomSheet;

public class SongInArtistPagerAdapter extends SongChildAdapter {
    private static final String TAG = "SongInArtistPagerAdapter";

    public SongInArtistPagerAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0) return R.layout.item_sort_song_child;
        return R.layout.item_song_bigger;
    }

    @Override
    protected void onMenuItemClick(int positionInData) {
        OptionBottomSheet
                .newInstance(SongMenuHelper.SONG_ARTIST_OPTION,getData().get(positionInData))
                .show(((AppCompatActivity)mContext).getSupportFragmentManager(), "song_popup_menu");
    }
}
