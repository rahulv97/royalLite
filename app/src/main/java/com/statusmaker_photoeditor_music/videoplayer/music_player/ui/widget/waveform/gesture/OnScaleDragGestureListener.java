package com.statusmaker_photoeditor_music.videoplayer.music_player.ui.widget.waveform.gesture;

/**
 * Created by trung on 9/7/2017.
 */

public interface OnScaleDragGestureListener {
    void onDrag(float dx, float dy);

    void onFling(float startX, float startY, float velocityX, float velocityY);

    void onScaleBegin();

    void onScale(float scaleFactor, float focusX, float focusY);

    void onScaleEnd();
}