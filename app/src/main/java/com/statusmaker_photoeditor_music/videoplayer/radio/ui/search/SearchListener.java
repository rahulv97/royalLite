package com.statusmaker_photoeditor_music.videoplayer.radio.ui.search;

import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.responses.Radio;

import java.util.List;

public interface SearchListener {

    void onRadioClicked(List<Radio> radioList, int position);
}
