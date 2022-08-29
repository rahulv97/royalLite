package com.statusmaker_photoeditor_music.videoplayer.radio.data.network;

import java.io.IOException;

public class NoConnectivityException extends IOException {

    @Override
    public String getMessage() {
        return "No connectivity exception";
    }

}
