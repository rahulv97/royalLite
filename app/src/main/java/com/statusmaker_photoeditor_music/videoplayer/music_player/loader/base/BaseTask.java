package com.statusmaker_photoeditor_music.videoplayer.music_player.loader.base;

public abstract class BaseTask<T extends BaseMediaLoader> implements Runnable {
    private static final String TAG = "BaseTask";

    private T mManager;
    @Override
    public  final void run() {
        onRunning();
    }
    abstract void onRunning();

}

