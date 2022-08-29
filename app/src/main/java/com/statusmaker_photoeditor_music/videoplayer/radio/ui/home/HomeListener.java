package com.statusmaker_photoeditor_music.videoplayer.radio.ui.home;

import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.responses.Radio;

import java.util.List;

public interface HomeListener {
    void onRadioClicked(List<Radio> radioList, int position, String type);
    void onMoreClicked(List<Radio> radioList, int position, String type, String title);
}
