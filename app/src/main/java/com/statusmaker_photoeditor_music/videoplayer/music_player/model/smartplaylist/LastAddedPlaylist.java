package com.statusmaker_photoeditor_music.videoplayer.music_player.model.smartplaylist;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.music_player.loader.medialoader.LastAddedLoader;
import com.statusmaker_photoeditor_music.videoplayer.music_player.model.Song;
import com.statusmaker_photoeditor_music.videoplayer.music_player.util.MusicUtil;
import com.statusmaker_photoeditor_music.videoplayer.music_player.util.PreferenceUtil;

import java.util.ArrayList;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public class LastAddedPlaylist extends AbsSmartPlaylist {

    public LastAddedPlaylist(@NonNull Context context) {
        super(context.getString(R.string.playlist_last_added), R.drawable.ic_library_add_white_24dp);
    }

    @NonNull
    @Override
    public String getInfoString(@NonNull Context context) {
        String cutoff = PreferenceUtil.getInstance(context).getLastAddedCutoffText(context);

        return MusicUtil.buildInfoString(
            cutoff,
            super.getInfoString(context)
        );
    }

    @NonNull
    @Override
    public ArrayList<Song> getSongs(@NonNull Context context) {
        return LastAddedLoader.getLastAddedSongs(context);
    }

    @Override
    public void clear(@NonNull Context context) {
    }

    @Override
    public boolean isClearable() {
        return false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected LastAddedPlaylist(Parcel in) {
        super(in);
    }

    public static final Parcelable.Creator<LastAddedPlaylist> CREATOR = new Parcelable.Creator<LastAddedPlaylist>() {
        public LastAddedPlaylist createFromParcel(Parcel source) {
            return new LastAddedPlaylist(source);
        }

        public LastAddedPlaylist[] newArray(int size) {
            return new LastAddedPlaylist[size];
        }
    };
}
