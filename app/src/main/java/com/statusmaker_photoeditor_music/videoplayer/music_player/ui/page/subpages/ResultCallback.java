package com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.subpages;

import com.statusmaker_photoeditor_music.videoplayer.music_player.addon.lastfm.rest.model.LastFmArtist;

import java.util.ArrayList;

public interface ResultCallback {
    void onSuccess(LastFmArtist lastFmArtist);
    void onFailure(Exception e);
    void onSuccess(ArrayList<String> mResult);
}