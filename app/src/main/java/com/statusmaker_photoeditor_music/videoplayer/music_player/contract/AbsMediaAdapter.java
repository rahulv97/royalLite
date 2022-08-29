package com.statusmaker_photoeditor_music.videoplayer.music_player.contract;

import android.content.Context;
import androidx.annotation.NonNull;
import android.view.View;

import com.statusmaker_photoeditor_music.videoplayer.music_player.model.Media;
import com.statusmaker_photoeditor_music.videoplayer.music_player.util.Tool;

/**
 * Implements these features:
 * <br> Menu button click
 * <br> Long press
 */
public abstract class AbsMediaAdapter<VH extends AbsBindAbleHolder, I extends Media> extends AbsDataAdapter<VH, I> {
    private static final String TAG = "AbsMediaAdapter";

    protected Context mContext;
    protected int mMediaPlayDataItem = -1;
    protected String mName = TAG;

    public static final String PLAY_STATE_CHANGED = "play_state_changed";
    public static final String SONG_PREVIEW_CHANGED = "song_preview_changed";
    public static final String PALETTE_CHANGED = "palette_changed";

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public AbsMediaAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public void destroy() {
        mContext = null;
        super.destroy();
    }

    protected abstract void onMenuItemClick(final int positionInData);

    protected boolean onLongPressedItem(AbsBindAbleHolder holder, final int position) {
        Tool.vibrate(mContext);
        return true;
    }

    public void notifyOnMediaStateChanged(final String whichChanged) {
    }

 /*   public final void notifyOnMediaStateChanged() {
        notifyOnMediaStateChanged(PLAY_STATE_CHANGED);
    }*/

    boolean isMediaPlayItemAvailable() {
        return -1 < mMediaPlayDataItem && mMediaPlayDataItem < getData().size();
    }

    public class AbsMediaHolder<I extends Media> extends AbsBindAbleHolder<I> implements View.OnClickListener, View.OnLongClickListener {
        public AbsMediaHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }

        @Override
        public boolean onLongClick(View view) {
            return onLongPressedItem(this,getAdapterPosition());
        }
    }
}
