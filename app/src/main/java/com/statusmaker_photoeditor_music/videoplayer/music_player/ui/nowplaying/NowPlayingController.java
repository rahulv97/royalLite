package com.statusmaker_photoeditor_music.videoplayer.music_player.ui.nowplaying;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bullhead.equalizer.DialogEqualizerFragment;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.statusmaker_photoeditor_music.videoplayer.MainActivity;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.ShowThemesActivity;
import com.statusmaker_photoeditor_music.videoplayer.ThemeDashboardActivity;
import com.statusmaker_photoeditor_music.videoplayer.music_player.glide.GlideApp;
import com.statusmaker_photoeditor_music.videoplayer.music_player.helper.menu.SongMenuHelper;
import com.statusmaker_photoeditor_music.videoplayer.music_player.loader.medialoader.SongLoader;
import com.statusmaker_photoeditor_music.videoplayer.music_player.service.MusicPlayerRemote;
import com.statusmaker_photoeditor_music.videoplayer.music_player.service.MusicServiceEventListener;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.AppActivity;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.CardLayerController;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.MusicServiceActivity;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.page.CardLayerFragment;

import com.statusmaker_photoeditor_music.videoplayer.music_player.model.Song;

import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.bottomsheet.OptionBottomSheet;
import com.statusmaker_photoeditor_music.videoplayer.music_player.ui.widget.avsb.AudioVisualSeekBar;
import com.statusmaker_photoeditor_music.videoplayer.music_player.util.SortOrder;
import com.statusmaker_photoeditor_music.videoplayer.music_player.util.Tool;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.statusmaker_photoeditor_music.videoplayer.music_player.service.MusicPlayerRemote.musicService;

public class NowPlayingController extends CardLayerFragment implements MusicServiceEventListener, AudioVisualSeekBar.OnSeekBarChangeListener, PalettePickerAdapter.OnColorChangedListener {
    private static final String TAG ="NowPlayingController";
    @BindView(R.id.root) CardView mRoot;
    @BindView(R.id.dim_view) View mDimView;
    private float mMaxRadius= 18;

    @BindView(R.id.eq_open)
    ImageView eq_open;

    @BindView(R.id.mus_theme_btn)
    ImageView mus_theme_btn;

    @BindView(R.id.minimize_bar) View mMinimizeBar;

    @BindView(R.id.recycler_view)
   RecyclerView mRecyclerView;

    DialogEqualizerFragment fragment;


    /*@BindView(R.id.view_pager)
    ViewPager2 mViewPager;*/

    @BindView(R.id.menu_button) View mMenuButton;

    @BindView(R.id.visual_seek_bar)
    AudioVisualSeekBar mVisualSeekBar;
    @BindView(R.id.time_text_view) TextView mTimeTextView;
    @BindView(R.id.big_title) TextView mBigTitle;
    @BindView(R.id.big_artist) TextView mBigArtist;
    private NowPlayingAdapter mAdapter;
    @BindView(R.id.color_picker_recycler_view) RecyclerView mColorPickerRecyclerView;
    private PalettePickerAdapter mPalettePickerAdapter;

    @OnClick(R.id.menu_button)
    void more() {
        if(getActivity() !=null)
            OptionBottomSheet
                    .newInstance(SongMenuHelper.NOW_PLAYING_OPTION,MusicPlayerRemote.getCurrentSong())
                    .show(getActivity().getSupportFragmentManager(), "song_popup_menu");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.now_playing_controller,container,false);
    }

    SnapHelper snapHelper = new PagerSnapHelper();
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        mMaxRadius = getResources().getDimension(R.dimen.max_radius_layer);
        mTitle.setSelected(true);

        mAdapter = new NowPlayingAdapter(getActivity());
        //mRecyclerView.setPageTransformer(false, new SliderTransformer());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        //mViewPager.setAdapter(mAdapter);

        snapHelper.attachToRecyclerView(mRecyclerView);

        mPalettePickerAdapter = new PalettePickerAdapter(this);
        mColorPickerRecyclerView.setAdapter(mPalettePickerAdapter);
        mColorPickerRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));


        //mViewPager.setOnTouchListener((v, event) -> mLayerController.streamOnTouchEvent(mRoot,event));
        mRecyclerView.setOnTouchListener((v, event) -> mCardLayerController.dispatchOnTouchEvent(mRoot,event));
        mVisualSeekBar.setOnTouchListener((v, event) -> mCardLayerController.dispatchOnTouchEvent(mRoot, event) &&  event.getAction()!=MotionEvent.ACTION_DOWN);

        mVisualSeekBar.setOnSeekBarChangeListener(this);
        Log.d(TAG, "onViewCreated");
       if(getActivity() instanceof MusicServiceActivity) ((AppActivity)getActivity()).addMusicServiceEventListener(this,true);
       setUp();



        mus_theme_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getActivity().moveTaskToBack (true);
                Intent intent = new Intent(getContext(), ShowThemesActivity.class);
                intent.putExtra("ThemeName", "Music Player Themes");
                startActivity(intent);
            }
        });

        eq_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = DialogEqualizerFragment.newBuilder()
                        .setAudioSessionId(musicService.getAudioSessionId())
                        .themeColor(ContextCompat.getColor(getContext(), R.color.eq_back))
                        .textColor(ContextCompat.getColor(getContext(), R.color.white))
                        .accentAlpha(ContextCompat.getColor(getContext(), R.color.white))
                        .darkColor(ContextCompat.getColor(getContext(), R.color.eq_red))
                        .setAccentColor(ContextCompat.getColor(getContext(), R.color.eq_red))
                        .build();
                fragment.show(getFragmentManager(), "eq");

            }
        });



        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(getContext());

        String current_theme = theme_pref.getString("MusicTheme", "default");



        if (current_theme.equals(String.valueOf(R.drawable.music1))){
            GlideApp.with(getActivity()).load(R.drawable.music1).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music2))){
            GlideApp.with(getActivity()).load(R.drawable.music2).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music3))){
            GlideApp.with(getActivity()).load(R.drawable.music3).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music4))){
            GlideApp.with(getActivity()).load(R.drawable.music4).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music5))){
            GlideApp.with(getActivity()).load(R.drawable.music5).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music6))){
            GlideApp.with(getActivity()).load(R.drawable.music6).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music7))){
            GlideApp.with(getActivity()).load(R.drawable.music7).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music8))){
            GlideApp.with(getActivity()).load(R.drawable.music8).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else {
            
        }
        

    }

    @Override
    public void onDestroyView() {

        if(getActivity() instanceof MusicServiceActivity) ((AppActivity)getActivity()).removeMusicServiceEventListener(this);
        super.onDestroyView();
    }

    /*
     *
     *  Implement MusicServiceEventListener
     *
     */

    @Override
    public void onServiceConnected() {
        Log.d(TAG, "onServiceConnected");
      setUp();
    }

    @Override
    public void onServiceDisconnected() {
        Log.d(TAG, "onServiceDisconnected");
    }

    @Override
    public void onQueueChanged() {
        Log.d(TAG, "onQueueChanged");
        updateQueue();
    }

    @Override
    public void onPlayingMetaChanged() {
        Log.d(TAG, "onPlayingMetaChanged");
        updatePlayingSongInfo();
        updateQueuePosition();
    }

    @Override
    public void onPlayStateChanged() {
        Log.d(TAG, "onPlayStateChanged");
        updatePlayPauseState();
        mVisualSeekBar.postDelayed(mUpdateProgress,10);
    }

    @Override
    public void onRepeatModeChanged() {
        Log.d(TAG, "onRepeatModeChanged");
        /*
        Unused
         */
    }

    @Override
    public void onShuffleModeChanged() {
        Log.d(TAG, "onShuffleModeChanged");
        /*
        Unused
         */
    }

    @Override
    public void onMediaStoreChanged() {
        Log.d(TAG, "onMediaStoreChanged");
        updateQueue();
    }

    @Override
    public void onPaletteChanged() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            /*((RippleDrawable)mPlayPauseButton.getBackground()).setColor(ColorStateList.valueOf(Tool.getBaseColor()));
            ((RippleDrawable)mPrevButton.getBackground()).setColor(ColorStateList.valueOf(Tool.getBaseColor()));
            ((RippleDrawable)mMenuButton.getBackground()).setColor(ColorStateList.valueOf(Tool.getBaseColor()));
            ((RippleDrawable)mNextButton.getBackground()).setColor(ColorStateList.valueOf(Tool.getBaseColor()));
            ((RippleDrawable)mPlaylistTitle.getBackground()).setColor(ColorStateList.valueOf(Tool.getBaseColor()));*/
        }
        onColorPaletteReady(Tool.ColorOne,Tool.ColorTwo,Tool.AlphaOne,Tool.AlphaTwo);
    }

    /*
     *
     *   End of Implementing MusicServiceEventListener
    *
    */

    private void updateQueue() {
        mAdapter.setData(MusicPlayerRemote.getPlayingQueue());
    }

    private void updateQueuePosition() {
        try {
            int pos = MusicPlayerRemote.getPosition();
            if(pos>=0)
            mRecyclerView.smoothScrollToPosition(MusicPlayerRemote.getPosition());
            //mViewPager.setCurrentItem(MusicPlayerRemote.getPosition());
        } catch (Exception ignore) {}
    }
    public void setUp() {
        updatePlayingSongInfo();
        updatePlayPauseState();
        updateQueue();
        updateQueuePosition();
    }

    private void setRadius(float value) {
        if(mRoot!=null) {
            float valueTemp;
            if(value>1) valueTemp=1;
            else if(value<=0.1f) valueTemp = 0;
            else valueTemp = value;
            mRoot.setRadius(mMaxRadius * valueTemp);
        }
    }

    @Override
    public void onUpdateLayer(ArrayList<CardLayerController.CardLayerAttribute> attrs, ArrayList<Integer> actives, int me) {

        if(mRoot==null) return;
        if(me ==1) {
            mDimView.setAlpha(0.3f*(attrs.get(actives.get(0)).getRuntimePercent()));
          //  mRoot.setRoundNumber( attrs.get(actives.get(0)).getRuntimePercent(),true);
            setRadius( attrs.get(actives.get(0)).getRuntimePercent());
        } else
        {
            //  other, active_i >1
            // min = 0.3
            // max = 0.45
            float min = 0.3f, max =0.65f;
            float hieu = max - min;
            float heSo_sau = (me-1.0f)/(me-0.75f); // 1/2, 2/3,3/4, 4/5, 5/6 ...
            float heSo_truoc =  (me-2.0f)/(me-0.75f); // 0/1, 1/2, 2/3, ...
            float darken = min + hieu*heSo_truoc + hieu*(heSo_sau - heSo_truoc)*attrs.get(actives.get(0)).getRuntimePercent();
            // Log.d(TAG, "darken = " + darken);
            mDimView.setAlpha(darken);
            setRadius(1);
        }
      //  checkStatusStyle();
    }

    @Override
    public void onTranslateChanged(CardLayerController.CardLayerAttribute attr) {
        //Log.d(TAG, "onTranslateChanged : pc = "+attr.getRuntimePercent()+", recycler_width = "+mRecyclerView.getWidth());
        if(getMaxPositionType()) {
            setRadius(0);

        }
        else{ setRadius(attr.getRuntimePercent());

       }

        mConstraintRoot.setProgress(attr.getRuntimePercent());
        // sync time text view
        if(mConstraintRoot.getProgress()!=0&&!mTimeTextIsSync) {
            mTimeTextView.setText(timeTextViewTemp);
            Log.d(TAG, "onTranslateChanged: timeTextView : "+timeTextViewTemp);

        }
        if(mConstraintRoot.getProgress()==0||mConstraintRoot.getProgress()==1)
            try {
                mRecyclerView.scrollToPosition(MusicPlayerRemote.getPosition());

                //mViewPager.setCurrentItem(MusicPlayerRemote.getPosition());
            } catch (Exception ignore) {}
        //checkStatusStyle();
    }
    public void checkStatusStyle(){
        if(mConstraintRoot.getProgress()>=0.9&&mDimView.getAlpha()<=0.1
        ) {
            if(getActivity() instanceof AppActivity)
            ((AppActivity)getActivity()).setTheme(true);
        } else {
            if(getActivity() instanceof AppActivity)
            ((AppActivity)getActivity()).setTheme(false);
        }
    }

    @Override
    public int minPosition(Context context,int h) {
        return (int) (context.getResources().getDimension(R.dimen.bottom_navigation_height)+ context.getResources().getDimension(R.dimen.now_laying_height_in_minimize_mode));
    }

    @Override
    public String tag() {
        return TAG;
    }

    @OnClick({R.id.play_pause_button,R.id.button_right})
    void playOrPause() {
        MusicPlayerRemote.playOrPause();
/*        Handler handler = new Handler();
        handler.postDelayed(MusicPlayerRemote::playOrPause,50);*/
    }
    @OnClick(R.id.prev_button)
    void goToPrevSong() {
        MusicPlayerRemote.back();
   /*     Handler handler = new Handler();
        handler.postDelayed(MusicPlayerRemote::back,50);*/
    }
    @OnClick(R.id.next_button)
    void goToNextSong() {
        MusicPlayerRemote.playNextSong();
/*        Handler handler = new Handler();
        handler.postDelayed(MusicPlayer::next,100);*/
    }
    void updatePlayPauseState(){
        if(MusicPlayerRemote.isPlaying()) {
            mButtonRight.setImageResource(R.drawable.ic_pause_black_24dp);
            mPlayPauseButton.setImageResource(R.drawable.pause_round);
        } else {
            mButtonRight.setImageResource(R.drawable.ic_play_white_36dp);
            mPlayPauseButton.setImageResource(R.drawable.play_round);
        }
    }

    @BindView(R.id.title) TextView mTitle;
    @BindView(R.id.playlist_title) TextView mPlaylistTitle;
    @BindView(R.id.button_right)
    ImageView mButtonRight;
    @BindView(R.id.prev_button) ImageView mPrevButton;
    @BindView(R.id.next_button) ImageView mNextButton;

    @BindView(R.id.play_pause_button)
    ImageView mPlayPauseButton;

    @OnClick(R.id.playlist_title)
    void popUpPlayingList() {
        Activity activity = getActivity();
        if(activity instanceof AppActivity) {
            ((AppActivity)getActivity()).popUpPlaylistTab();
        }
    }
    private void updatePlayingSongInfo() {
       Song song = MusicPlayerRemote.getCurrentSong();
       if(song==null||song.id==-1) {
           ArrayList<Song> list = SongLoader.getAllSongs(mPlayPauseButton.getContext(), SortOrder.SongSortOrder.SONG_DATE);
           if(list.isEmpty()) return;
           MusicPlayerRemote.openQueue(list,0,false);
           return;
       }
        mTitle.setText(String.format("%s %s %s", song.title, getString(R.string.middle_dot), song.artistName));
        mBigTitle.setText(song.title);
        mBigArtist.setText(song.artistName);

        String path = song.data;
        long duration = song.duration;
        if(duration>0&&path!=null&&!path.isEmpty() && mVisualSeekBar.getCurrentSongID() != song.id) {
            Log.d(TAG, "start visualize "+ path +"dur = "+ duration+", pos = "+ MusicPlayerRemote.getSongProgressMillis());
            mVisualSeekBar.visualize(song, duration, MusicPlayerRemote.getSongProgressMillis());
        } else {
            Log.d(TAG, "ignore visualize "+path);
        }

        mVisualSeekBar.postDelayed(mUpdateProgress,10);
        if(getActivity() instanceof MusicServiceActivity)
            ((MusicServiceActivity)getActivity()).refreshPalette();
    }


    private void onColorPaletteReady(int color1, int color2, float alpha1, float alpha2) {
        Log.d(TAG, "onColorPaletteReady :"+color1+", "+color2+", "+alpha1+", "+alpha2);
        /*mPlayPauseButton.setColorFilter(Tool.getBaseColor());
        mPrevButton.setColorFilter(color2);
        mNextButton.setColorFilter(color2);

      //  mTimeTextView.setTextColor(color1);
     //   (mTimeTextView.getBackground()).setColorFilter(color1, PorterDuff.Mode.SRC_IN);

       // mBigTitle.setTextColor(Tool.lighter(color1,0.5f));
       // mBigArtist.setAlpha(alpha2);
        mBigArtist.setTextColor(color2);
        mVisualSeekBar.updateDrawProperties();*/

    }

    @BindView(R.id.constraint_root)
    MotionLayout mConstraintRoot;
/*
   private void addAnimationOperations() {
        final boolean[] set = {false};
        ConstraintSet constraint1 = new ConstraintSet();
        constraint1.clone(mConstraintRoot);

        ConstraintSet constraint2 = new ConstraintSet();
        constraint2.clone(getContext(),R.layout.now_playing_controller_alt);

        mButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(mConstraintRoot);
                ConstraintSet constraintSet = (set[0]) ? constraint1 : constraint2;
                constraintSet.applyTo(mConstraintRoot);
                set[0] =!set[0];
            }
        });

    }
    */

    @Override
    public boolean onGestureDetected(int gesture) {
        if(gesture== CardLayerController.SINGLE_TAP_UP) {
            CardLayerController.CardLayerAttribute a = getCardLayerController().getMyAttr(this);
            if(a!=null) {
                if(a.getState()== CardLayerController.CardLayerAttribute.MINIMIZED)
                    a.animateToMax();
                else
                    a.animateToMin();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getMaxPositionType() {
        return true;
    }

    @Override
    public void onColorChanged(int position, int newColor) {
      //  mBigTitle.setTextColor(newColor);
    }


    private static class CustomDecoration extends RecyclerView.ItemDecoration {
        public CustomDecoration() {
            super();
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        fragmentPaused = true;
    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(getContext());

        String current_theme = theme_pref.getString("MusicTheme", "default");



        if (current_theme.equals(String.valueOf(R.drawable.music1))){
            GlideApp.with(getActivity()).load(R.drawable.music1).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music2))){
            GlideApp.with(getActivity()).load(R.drawable.music2).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music3))){
            GlideApp.with(getActivity()).load(R.drawable.music3).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music4))){
            GlideApp.with(getActivity()).load(R.drawable.music4).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music5))){
            GlideApp.with(getActivity()).load(R.drawable.music5).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music6))){
            GlideApp.with(getActivity()).load(R.drawable.music6).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music7))){
            GlideApp.with(getActivity()).load(R.drawable.music7).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else if (current_theme.equals(String.valueOf(R.drawable.music8))){
            GlideApp.with(getActivity()).load(R.drawable.music8).into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mConstraintRoot.setBackground(resource);

                    }
                }
            });
        }
        else {

        }

        new CountDownTimer(70, 1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                try {
                    fragment.onStop();
                }catch (Exception e){
                    Log.d("frag", e.getMessage());
                }
            }
        }.start();


        fragmentPaused = false;
        if(mVisualSeekBar!=null) {
            mVisualSeekBar.postDelayed(mUpdateProgress,10);
        }
    }

    ////////////////////////////////
    /// VISUAL SEEK BAR IMPLEMENTED
    ////////////////////////////////

    private boolean isTouchedVisualSeekbar = false;
    private int overflowcounter=0;
    boolean fragmentPaused = false;
    // seekbar
    public Runnable mUpdateProgress = new Runnable() {
        @Override
        public void run() {
            long position = MusicPlayerRemote.getSongProgressMillis();

            if(!isTouchedVisualSeekbar)
                setTextTime(position,MusicPlayerRemote.getSongDurationMillis());

            if(mVisualSeekBar!=null) {
                mVisualSeekBar.setProgress((int) position);
                //TODO: Set elapsedTime
            }
            overflowcounter--;
            if(MusicPlayerRemote.isPlaying()) {
                //TODO: ???
                int delay = (int) (150 -(position)%100);
                if(overflowcounter<0 && !fragmentPaused) {
                    overflowcounter ++;
                    mVisualSeekBar.postDelayed(mUpdateProgress,delay);
                }
            }
        }
    };
    @Override
    public void onSeekBarSeekTo(AudioVisualSeekBar seekBar, int position) {
        MusicPlayerRemote.seekTo(position);
    }

    @Override
    public void onSeekBarTouchDown(AudioVisualSeekBar seekBar) {
        isTouchedVisualSeekbar = true;
    }

    @Override
    public void onSeekBarTouchUp(AudioVisualSeekBar seekBar) {
        isTouchedVisualSeekbar = false;
    }

    @Override
    public void onSeekBarSeeking(int seekingValue) {
        setTextTime(seekingValue,MusicPlayerRemote.getSongDurationMillis());
    }
    private void setTextTime(long pos, long duration) {
        int minute = (int) (pos/1000/60);
        int second = (int) (pos/1000-  minute*60);
        int dur_minute = (int) (duration/1000/60);
        int dur_second = (int) (duration/1000 - dur_minute*60);

        String text ="";
        if(minute<10) text+="0";
        text+=minute+":";
        if(second<10) text+="0";
        text+= second+" | ";
        if(dur_minute<10) text+="0";
        text+= dur_minute+":";
        if(dur_second<10) text+="0";
        text+=dur_second;
        if(mConstraintRoot.getProgress()!=0) {
            mTimeTextView.setText(text);
            //Log.d(TAG, "setTextTime: "+text);
            mTimeTextIsSync = true;
        }
        else {
            mTimeTextIsSync = false;
            timeTextViewTemp = text;
        }
    }

    private boolean mTimeTextIsSync = false;

    private String timeTextViewTemp = "00:00";
}
