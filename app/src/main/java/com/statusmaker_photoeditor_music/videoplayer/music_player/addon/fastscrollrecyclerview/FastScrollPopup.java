package com.statusmaker_photoeditor_music.videoplayer.music_player.addon.fastscrollrecyclerview;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;

import androidx.annotation.Keep;

public class FastScrollPopup {

    private com.statusmaker_photoeditor_music.videoplayer.music_player.addon.fastscrollrecyclerview.FastScrollRecyclerView mRecyclerView;

    private Resources mRes;

    private int mBackgroundSize;
    private int mCornerRadius;

    private Path mBackgroundPath = new Path();
    private RectF mBackgroundRect = new RectF();
    private Paint mBackgroundPaint;
    private int mBackgroundColor = 0xff000000;

    private Rect mInvalidateRect = new Rect();
    private Rect mTmpRect = new Rect();

    // The absolute bounds of the fast scroller bg
    private Rect mBgBounds = new Rect();

    private String mSectionName;

    private Paint mTextPaint;
    private Rect mTextBounds = new Rect();

    private float mAlpha = 1;

    private ObjectAnimator mAlphaAnimator;
    private boolean mVisible;

    @FastScroller.FastScrollerPopupPosition private int mPosition;

    public FastScrollPopup(Resources resources, com.statusmaker_photoeditor_music.videoplayer.music_player.addon.fastscrollrecyclerview.FastScrollRecyclerView recyclerView) {

        mRes = resources;

        mRecyclerView = recyclerView;

        mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setAlpha(0);

        setTextSize(com.statusmaker_photoeditor_music.videoplayer.music_player.addon.fastscrollrecyclerview.Utils.toScreenPixels(mRes, 56));
        setBackgroundSize(com.statusmaker_photoeditor_music.videoplayer.music_player.addon.fastscrollrecyclerview.Utils.toPixels(mRes, 88));
    }

    public void setBgColor(int color) {
        mBackgroundColor = color;
        mBackgroundPaint.setColor(color);
        mRecyclerView.invalidate(mBgBounds);
    }

    public void setTextColor(int color) {
        mTextPaint.setColor(color);
        mRecyclerView.invalidate(mBgBounds);
    }

    public void setTextSize(int size) {
        mTextPaint.setTextSize(size);
        mRecyclerView.invalidate(mBgBounds);
    }

    public void setBackgroundSize(int size) {
        mBackgroundSize = size;
        mCornerRadius = mBackgroundSize / 2;
        mRecyclerView.invalidate(mBgBounds);
    }

    public void setTypeface(Typeface typeface) {
        mTextPaint.setTypeface(typeface);
        mRecyclerView.invalidate(mBgBounds);
    }

    /**
     * Animates the visibility of the fast scroller popup.
     */
    public void animateVisibility(boolean visible) {
        if (mVisible != visible) {
            mVisible = visible;
            if (mAlphaAnimator != null) {
                mAlphaAnimator.cancel();
            }
            mAlphaAnimator = ObjectAnimator.ofFloat(this, "alpha", visible ? 1f : 0f);
            mAlphaAnimator.setDuration(visible ? 200 : 150);
            mAlphaAnimator.start();
        }
    }

    // Setter/getter for the popup alpha for animations
    @Keep
    public void setAlpha(float alpha) {
        mAlpha = alpha;
        mRecyclerView.invalidate(mBgBounds);
    }

    @Keep
    public float getAlpha() {
        return mAlpha;
    }

    public void setPopupPosition(@FastScroller.FastScrollerPopupPosition int position) {
        mPosition = position;
    }

    @FastScroller.FastScrollerPopupPosition
    public int getPopupPosition() {
        return mPosition;
    }

    private float[] createRadii() {
        if (mPosition == FastScroller.FastScrollerPopupPosition.CENTER) {
            return new float[]{mCornerRadius, mCornerRadius, mCornerRadius, mCornerRadius, mCornerRadius, mCornerRadius, mCornerRadius, mCornerRadius};
        }

        if (com.statusmaker_photoeditor_music.videoplayer.music_player.addon.fastscrollrecyclerview.Utils.isRtl(mRes)) {
            return new float[]{mCornerRadius, mCornerRadius, mCornerRadius, mCornerRadius, mCornerRadius, mCornerRadius, 0, 0};
        } else {
            return new float[]{mCornerRadius, mCornerRadius, mCornerRadius, mCornerRadius, 0, 0, mCornerRadius, mCornerRadius};
        }
    }

    public void draw(Canvas canvas) {
        if (isVisible()) {
            // Draw the fast scroller popup
            int restoreCount = canvas.save();
            canvas.translate(mBgBounds.left, mBgBounds.top);
            mTmpRect.set(mBgBounds);
            mTmpRect.offsetTo(0, 0);

            mBackgroundPath.reset();
            mBackgroundRect.set(mTmpRect);

            float[] radii = createRadii();

            mBackgroundPath.addRoundRect(mBackgroundRect, radii, Path.Direction.CW);

            mBackgroundPaint.setAlpha((int) (Color.alpha(mBackgroundColor) * mAlpha));
            mTextPaint.setAlpha((int) (mAlpha * 255));
            canvas.drawPath(mBackgroundPath, mBackgroundPaint);
            canvas.drawText(mSectionName, (mBgBounds.width() - mTextBounds.width()) / 2,
                    mBgBounds.height() - (mBgBounds.height() - mTextBounds.height()) / 2,
                    mTextPaint);
            canvas.restoreToCount(restoreCount);
        }
    }

    public void setSectionName(String sectionName) {
        if (!sectionName.equals(mSectionName)) {
            mSectionName = sectionName;
            mTextPaint.getTextBounds(sectionName, 0, sectionName.length(), mTextBounds);
            // Update the width to use measureText since that is more accurate
            mTextBounds.right = (int) (mTextBounds.left + mTextPaint.measureText(sectionName));
        }
    }

    /**
     * Updates the bounds for the fast scroller.
     *
     * @return the invalidation rect for this update.
     */
    public Rect updateFastScrollerBounds(com.statusmaker_photoeditor_music.videoplayer.music_player.addon.fastscrollrecyclerview.FastScrollRecyclerView recyclerView, int thumbOffsetY) {
        mInvalidateRect.set(mBgBounds);

        if (isVisible()) {
            // Calculate the dimensions and position of the fast scroller popup
            int edgePadding = recyclerView.getScrollBarWidth();
            int bgPadding = (mBackgroundSize - mTextBounds.height()) / 2;
            int bgHeight = mBackgroundSize;
            int bgWidth = Math.max(mBackgroundSize, mTextBounds.width() + (2 * bgPadding));
            if (mPosition == FastScroller.FastScrollerPopupPosition.CENTER) {
                mBgBounds.left = (recyclerView.getWidth() - bgWidth) / 2;
                mBgBounds.right = mBgBounds.left + bgWidth;
                mBgBounds.top = (recyclerView.getHeight() - bgHeight) / 2;
            } else {
                if (com.statusmaker_photoeditor_music.videoplayer.music_player.addon.fastscrollrecyclerview.Utils.isRtl(mRes)) {
                    mBgBounds.left = (2 * recyclerView.getScrollBarWidth());
                    mBgBounds.right = mBgBounds.left + bgWidth;
                } else {
                    mBgBounds.right = recyclerView.getWidth() - (2 * recyclerView.getScrollBarWidth());
                    mBgBounds.left = mBgBounds.right - bgWidth;
                }
                mBgBounds.top = thumbOffsetY - bgHeight + recyclerView.getScrollBarThumbHeight() / 2;
                mBgBounds.top = Math.max(edgePadding, Math.min(mBgBounds.top, recyclerView.getHeight() - edgePadding - bgHeight));
            }
            mBgBounds.bottom = mBgBounds.top + bgHeight;
        } else {
            mBgBounds.setEmpty();
        }

        // Combine the old and new fast scroller bounds to create the full invalidate rect
        mInvalidateRect.union(mBgBounds);
        return mInvalidateRect;
    }

    public boolean isVisible() {
        return (mAlpha > 0f) && (!TextUtils.isEmpty(mSectionName));
    }
}