package com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.librarypage.genre;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.statusmaker_photoeditor_music.videoplayer.music_player.model.Song;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.widget.bubblepicker.model.PickerItem;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.widget.bubblepicker.rendering.PickerAdapter;
import com.statusmaker_photoeditor_music.videoplayer.music_player.util.MusicUtil;

public class SongPickerAdapter extends PickerAdapter<Song> {

    public SongPickerAdapter(Context context) {
        super(context);
    }

    @Override
    public boolean onBindItem(PickerItem item, boolean create, int i) {
        super.onBindItem(item,create,i);
        Song song = mData.get(i);
        item.setTitle(song.title);
        item.setRadiusUnit(PickerItem.SIZE_RANDOM);
        // Glide
        Glide.with(mContext).load(MusicUtil.getMediaStoreAlbumCoverUri(song.albumId)).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                item.setBackgroundImage(resource);
                SongPickerAdapter.this.notifyBackImageUpdated(i);
            }
        });

        return true;
    }
}
