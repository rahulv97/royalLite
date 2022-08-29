package com.statusmaker_photoeditor_music.videoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.UriPermission;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Icon;
import android.media.AudioManager;
import android.media.audiofx.LoudnessEnhancer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Rational;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bullhead.equalizer.DialogEqualizerFragment;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.ext.mediasession.MediaSessionConnector;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.material.snackbar.Snackbar;
import com.google.common.io.Files;
import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;
import com.royalplayer.lite.R;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab_back, fab_lock, fab_delete, fab_share;

    private PlaybackStateListener playbackStateListener;
    private BroadcastReceiver mReceiver;
    private AudioManager mAudioManager;
    private MediaSessionCompat mediaSession;
    private DefaultTrackSelector trackSelector;
    public static LoudnessEnhancer loudnessEnhancer;

    private CustomStyledPlayerView playerView;
    public static SimpleExoPlayer player;

    private Object mPictureInPictureParamsBuilder;

    private Prefs mPrefs;
    public static BrightnessControl mBrightnessControl;
    public static boolean haveMedia;
    private boolean setTracks;
    public static boolean controllerVisible;
    public static boolean controllerVisibleFully;
    public static Snackbar snackbar;
    private ExoPlaybackException errorToShow;
    public static int boostLevel = 0;

    private static final int REQUEST_CHOOSER_VIDEO = 1;
    private static final int REQUEST_CHOOSER_SUBTITLE = 2;
    public static final int CONTROLLER_TIMEOUT = 3500;
    private static final String ACTION_MEDIA_CONTROL = "media_control";
    private static final String EXTRA_CONTROL_TYPE = "control_type";
    private static final int REQUEST_PLAY = 1;
    private static final int REQUEST_PAUSE = 2;
    private static final int CONTROL_TYPE_PLAY = 1;
    private static final int CONTROL_TYPE_PAUSE = 2;

    private CoordinatorLayout coordinatorLayout;
    private TextView titleView;
    private ImageButton buttonOpen;
    private ImageButton buttonPiP;
    private ImageButton buttonAspectRatio;

    private boolean restoreOrientationLock;
    private boolean restorePlayState;
    private boolean play;
    private float subtitlesScale = 1.05f;
    private boolean scrubbing;
    private long scrubbingStart;

    DialogEqualizerFragment fragment;

    final Rational rationalLimitWide = new Rational(239, 100);
    final Rational rationalLimitTall = new Rational(100, 239);

    RelativeLayout tutor;

    ImageView open_equaliser;

    Boolean controller_hidden = false;

    int super_position;

    LinearLayout exo_center_controls;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mPrefs = new Prefs(this);
        Utils.setOrientation(this, mPrefs.orientation);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vid_player);

        sharedPreferences = getSharedPreferences("Gesture", Context.MODE_PRIVATE);

        SharedPreferences.Editor editorn = sharedPreferences.edit();
        editorn.putString("Gesture","on");
        editorn.apply();

        tutor = findViewById(R.id.tutor);

        open_equaliser = findViewById(R.id.open_equaliser);

        exo_center_controls = findViewById(R.id.exo_center_controls1);

        open_equaliser.setVisibility(View.VISIBLE);



        new CountDownTimer(150, 1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                fragment = DialogEqualizerFragment.newBuilder()
                        .setAudioSessionId(player.getAudioSessionId())
                        .themeColor(ContextCompat.getColor(MainActivity.this, R.color.eq_back))
                        .textColor(ContextCompat.getColor(MainActivity.this, R.color.white))
                        .accentAlpha(ContextCompat.getColor(MainActivity.this, R.color.white))
                        .darkColor(ContextCompat.getColor(MainActivity.this, R.color.eq_red))
                        .setAccentColor(ContextCompat.getColor(MainActivity.this, R.color.eq_red))
                        .build();
                fragment.show(getSupportFragmentManager(), "eq");

                new CountDownTimer(100, 1000){

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        fragment.onStop();
                    }
                }.start();
            }
        }.start();


        open_equaliser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(MainActivity.this, EqualizerActivity.class);
                intent.putExtra("id", player.getAudioSessionId());
                startActivity(intent);*/
                fragment = DialogEqualizerFragment.newBuilder()
                        .setAudioSessionId(player.getAudioSessionId())
                        .themeColor(ContextCompat.getColor(MainActivity.this, R.color.eq_back))
                        .textColor(ContextCompat.getColor(MainActivity.this, R.color.white))
                        .accentAlpha(ContextCompat.getColor(MainActivity.this, R.color.white))
                        .darkColor(ContextCompat.getColor(MainActivity.this, R.color.eq_red))
                        .setAccentColor(ContextCompat.getColor(MainActivity.this, R.color.eq_red))
                        .build();
                fragment.show(getSupportFragmentManager(), "eq");


               /* EqualizerFragment equalizerFragment = EqualizerFragment.newBuilder()
                        .setAccentColor(Color.parseColor("#4caf50"))
                        .setAudioSessionId(player.getAudioSessionId())
                        .build();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.eqFrame, equalizerFragment)
                        .commit();

                /*Intent intent = new Intent(AudioEffect.ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL);
                intent.putExtra(AudioEffect.EXTRA_AUDIO_SESSION, player.getAudioSessionId());
                startActivityForResult(intent, 123);*/

            }
        });

        fab_back = findViewById(R.id.fab_back);
        fab_lock = findViewById(R.id.fab_lock);
        fab_delete = findViewById(R.id.fab_delete);
        fab_share = findViewById(R.id.fab_share);

        fab_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                releasePlayer();
                int cont_type = getIntent().getIntExtra("Type", 0);

                if (cont_type==0){
                    MainActivity.super.onBackPressed();
                }
                else if (cont_type==1){
                    startActivity(new Intent(MainActivity.this, VideoSelectorActivity.class));
                    finish();
                }
                else if (cont_type==2){
                    startActivity(new Intent(MainActivity.this, HiddenVideos.class));
                    finish();
                }
            }
        });




        if (getIntent().getData() != null) {
            mPrefs.updateMedia(getIntent().getData(), getIntent().getType());
        }


        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        playerView = findViewById(R.id.video_view);

        playerView.setShowNextButton(false);
        playerView.setShowPreviousButton(false);
        playerView.setShowFastForwardButton(false);
        playerView.setShowRewindButton(false);

        playerView.setControllerHideOnTouch(true);
        playerView.setControllerAutoShow(true);

        CustomDefaultTimeBar timeBar = playerView.findViewById(R.id.exo_progress);

        ImageView lock_player = findViewById(R.id.lock_player);
        ImageView ublock_player = findViewById(R.id.ublock_player);
        FrameLayout exo_bottom_bar = findViewById(R.id.exo_bottom_bar);
        FloatingActionsMenu floating = findViewById(R.id.floating);

        findViewById(R.id.take_ss).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.pause();

                long timeb = player.getCurrentPosition() - 1000;
                Log.e("TimebarPosition", timeb+"");

            }
        });

        lock_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exo_center_controls.setVisibility(View.GONE);
                ublock_player.setVisibility(View.VISIBLE);
                lock_player.setVisibility(View.GONE);

                exo_bottom_bar.setVisibility(View.GONE);
                timeBar.setVisibility(View.GONE);
                floating.setVisibility(View.GONE);

                open_equaliser.setVisibility(View.GONE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Gesture","off");
                editor.apply();

            }
        });

        ublock_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exo_center_controls.setVisibility(View.VISIBLE);
                ublock_player.setVisibility(View.GONE);
                lock_player.setVisibility(View.VISIBLE);

                exo_bottom_bar.setVisibility(View.VISIBLE);
                timeBar.setVisibility(View.VISIBLE);
                floating.setVisibility(View.VISIBLE);

                open_equaliser.setVisibility(View.VISIBLE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Gesture","on");
                editor.apply();

            }
        });



        // https://github.com/google/ExoPlayer/issues/5765

        timeBar.setBufferedColor(0xFFD4D4D4);
        timeBar.setScrubberColor(0xFFBA0000);
        timeBar.setPlayedColor(0xFFBA0000);
        timeBar.setUnplayedColor(0xFFEDEDED);

        timeBar.addListener(new TimeBar.OnScrubListener() {
            @Override
            public void onScrubStart(TimeBar timeBar, long position) {
                scrubbing = false;
                scrubbingStart = player.getCurrentPosition();
                reportScrubbing(position);
            }

            @Override
            public void onScrubMove(TimeBar timeBar, long position) {
                reportScrubbing(position);
            }

            @Override
            public void onScrubStop(TimeBar timeBar, long position, boolean canceled) {
                playerView.setCustomErrorMessage(null);
            }
        });

        final StyledPlayerControlView controlView = playerView.findViewById(R.id.exo_controller);
        controlView.setOnApplyWindowInsetsListener((view, windowInsets) -> {
            if (windowInsets != null) {
                view.setPadding(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(),
                        windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                windowInsets.consumeSystemWindowInsets();
            }
            return windowInsets;
        });

        final View exoErrorMessage = playerView.findViewById(R.id.exo_error_message);
        exoErrorMessage.setOnApplyWindowInsetsListener((view, windowInsets) -> {
            if (windowInsets != null) {
                final int bottom = (int) getResources().getDimension(R.dimen.exo_error_message_margin_bottom);

                final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
                layoutParams.setMargins(windowInsets.getSystemWindowInsetLeft() / 2, 0,
                        windowInsets.getSystemWindowInsetRight() / 2, bottom);
                view.setLayoutParams(layoutParams);

                windowInsets.consumeSystemWindowInsets();
            }
            return windowInsets;
        });


        ImageButton exo_next1 = findViewById(R.id.exo_next1);
        ImageButton exo_prev1 = findViewById(R.id.exo_prev1);


        exo_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Next Song", Toast.LENGTH_SHORT).show();
                if (super_position==getIntent().getStringArrayListExtra("VideoFilePath").size()-1){

                }
                else {
                    super_position = super_position+1;
                    player.stop();
                    startVideo(super_position);
                }
            }
        });

        exo_prev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(MainActivity.this, "Previous Song", Toast.LENGTH_SHORT).show();
                if (super_position==0){

                }
                else {
                    super_position = super_position-1;
                    player.stop();
                    startVideo(super_position);
                }
            }
        });



        buttonOpen = new ImageButton(this, null, 0, R.style.ExoStyledControls_Button_Bottom);
        buttonOpen.setImageResource(R.drawable.ic_folder_open_24dp);
        buttonOpen.setId(View.generateViewId());

        buttonOpen.setOnClickListener(view -> openFile(mPrefs.mediaUri));
        buttonOpen.setVisibility(View.GONE);

        buttonOpen.setOnLongClickListener(view -> {
            loadSubtitleFile(mPrefs.mediaUri);
            return true;
        });

        if (isPiPSupported()) {
            mPictureInPictureParamsBuilder = new PictureInPictureParams.Builder();
            updatePictureInPictureActions(R.drawable.ic_play_arrow_24dp, "Play", CONTROL_TYPE_PLAY, REQUEST_PLAY);

            buttonPiP = new ImageButton(this, null, 0, R.style.ExoStyledControls_Button_Bottom);
            buttonPiP.setImageResource(R.drawable.ic_picture_in_picture_alt_24dp);

            buttonPiP.setOnClickListener(view -> {
                playerView.setControllerAutoShow(false);
                playerView.hideController();

                final Format format = player.getVideoFormat();

                if (format != null) {
                    Rational rational;
                    if (Utils.isRotated(format))
                        rational = new Rational(format.height, format.width);
                    else
                        rational = new Rational(format.width, format.height);

                    if (rational.floatValue() > rationalLimitWide.floatValue())
                        rational = rationalLimitWide;
                    else if (rational.floatValue() < rationalLimitTall.floatValue())
                        rational = rationalLimitTall;

                    ((PictureInPictureParams.Builder)mPictureInPictureParamsBuilder).setAspectRatio(rational);
                }

                enterPictureInPictureMode(((PictureInPictureParams.Builder)mPictureInPictureParamsBuilder).build());
            });

            Utils.setButtonEnabled(this, buttonPiP, false);
        }

        buttonAspectRatio = new ImageButton(this, null, 0, R.style.ExoStyledControls_Button_Bottom);
        buttonAspectRatio.setImageResource(R.drawable.ic_aspect_ratio_24dp);
        buttonAspectRatio.setOnClickListener(view -> {
            playerView.setScale(1.f);
            if (playerView.getResizeMode() == AspectRatioFrameLayout.RESIZE_MODE_FIT) {
                playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM);
                Utils.showText(playerView, getString(R.string.video_resize_crop));
            } else {
                // Default mode
                playerView.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIT);
                Utils.showText(playerView, getString(R.string.video_resize_fit));
            }
            // Keep controller UI visible - alternative to resetHideCallbacks()
            playerView.setControllerShowTimeoutMs(MainActivity.CONTROLLER_TIMEOUT);
        });
        Utils.setButtonEnabled(this, buttonAspectRatio, false);

        ImageButton buttonRotation = new ImageButton(this, null, 0, R.style.ExoStyledControls_Button_Bottom);
        buttonRotation.setImageResource(R.drawable.ic_auto_rotate_24dp);
        buttonRotation.setOnClickListener(view -> {
            mPrefs.orientation = Utils.getNextOrientation(mPrefs.orientation);
            Utils.setOrientation(MainActivity.this, mPrefs.orientation);
            Utils.showText(playerView, getString(mPrefs.orientation.description), 2500);

            // Keep controller UI visible - alternative to resetHideCallbacks()
            playerView.setControllerShowTimeoutMs(MainActivity.CONTROLLER_TIMEOUT);
        });

        int padding = getResources().getDimensionPixelOffset(R.dimen.exo_styled_bottom_bar_time_padding);
        FrameLayout centerView = playerView.findViewById(R.id.exo_controls_background);
        titleView = new TextView(this);
        titleView.setBackgroundResource(R.color.exo_bottom_bar_background);
        titleView.setTextColor(Color.WHITE);
        titleView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        titleView.setPadding(padding, padding, padding, padding);
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        titleView.setVisibility(View.GONE);
        titleView.setMaxLines(1);
        titleView.setEllipsize(TextUtils.TruncateAt.END);
        titleView.setTextDirection(View.TEXT_DIRECTION_LOCALE);
        centerView.addView(titleView);

        playbackStateListener = new PlaybackStateListener();

        mBrightnessControl = new BrightnessControl(this);
        if (mPrefs.brightness >= 0) {
            mBrightnessControl.currentBrightnessLevel = mPrefs.brightness;
            mBrightnessControl.setScreenBrightness(mBrightnessControl.levelToBrightness(mBrightnessControl.currentBrightnessLevel));
        }



        final CaptioningManager captioningManager = (CaptioningManager) getSystemService(Context.CAPTIONING_SERVICE);
        final SubtitleView subtitleView = playerView.getSubtitleView();
        if (!captioningManager.isEnabled()) {
            final CaptionStyleCompat captionStyle = new CaptionStyleCompat(Color.WHITE, Color.TRANSPARENT, Color.TRANSPARENT, CaptionStyleCompat.EDGE_TYPE_DROP_SHADOW, Color.BLACK, Typeface.DEFAULT_BOLD);
            if (subtitleView != null)
                subtitleView.setStyle(captionStyle);
        } else {
            subtitlesScale = captioningManager.getFontScale();
            if (subtitleView != null)
                subtitleView.setApplyEmbeddedStyles(false);
        }
        if (subtitleView != null)
            subtitleView.setBottomPaddingFraction(SubtitleView.DEFAULT_BOTTOM_PADDING_FRACTION * 2f / 3f);

        setSubtitleTextSize();

        final LinearLayout exoBasicControls = playerView.findViewById(R.id.exo_basic_controls);
        final ImageButton exoSubtitle = exoBasicControls.findViewById(R.id.exo_subtitle);
        exoBasicControls.removeView(exoSubtitle);

        exoSubtitle.setOnLongClickListener(view -> {
            loadSubtitleFile(mPrefs.mediaUri);
            return true;
        });

        final ImageButton exoSettings = exoBasicControls.findViewById(R.id.exo_settings);
        exoBasicControls.removeView(exoSettings);
        //exoBasicControls.setVisibility(View.GONE);

        final HorizontalScrollView horizontalScrollView = (HorizontalScrollView) getLayoutInflater().inflate(R.layout.controls, null);
        final LinearLayout controls = horizontalScrollView.findViewById(R.id.controls);

        controls.addView(buttonOpen);
        controls.addView(exoSubtitle);
        controls.addView(buttonAspectRatio);
        if (isPiPSupported()) {
            controls.addView(buttonPiP);
        }
        controls.addView(buttonRotation);
        controls.addView(exoSettings);

        exoBasicControls.addView(horizontalScrollView);

        if (Build.VERSION.SDK_INT > 23) {
            horizontalScrollView.setOnScrollChangeListener((view, i, i1, i2, i3) -> {
                // Keep controller UI visible - alternative to resetHideCallbacks()
                playerView.setControllerShowTimeoutMs(MainActivity.CONTROLLER_TIMEOUT);
            });
        }

        playerView.setControllerVisibilityListener(new StyledPlayerControlView.VisibilityListener() {
            @Override
            public void onVisibilityChange(int visibility) {
                controllerVisible = visibility == View.VISIBLE;
                controllerVisibleFully = playerView.isControllerFullyVisible();

                // https://developer.android.com/training/system-ui/immersive
                if (visibility == View.VISIBLE) {
                    Utils.showSystemUi(playerView);
                    // Because when using dpad controls, focus resets to first item in bottom controls bar
                    findViewById(R.id.exo_play_pause).requestFocus();
                } else {
                    Utils.hideSystemUi(playerView);
                }

                if (controllerVisible && playerView.isControllerFullyVisible()) {
                    if (mPrefs.firstRun) {
                        /*TapTargetView.showFor(MainActivity.this,
                                TapTarget.forView(buttonOpen, getString(R.string.onboarding_open_title), getString(R.string.onboarding_open_description))
                                        .outerCircleColor(R.color.green)
                                        .targetCircleColor(R.color.white)
                                        .titleTextSize(22)
                                        .titleTextColor(R.color.white)
                                        .descriptionTextSize(14)
                                        .cancelable(true),
                                new TapTargetView.Listener() {
                                    @Override
                                    public void onTargetClick(TapTargetView view) {
                                        super.onTargetClick(view);
                                        buttonOpen.performClick();
                                    }
                                });*/

                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                        tutor.setVisibility(View.VISIBLE);

                        tutor.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tutor.setVisibility(View.GONE);
                            }
                        });

                        // TODO: Explain gestures?
                        //  "Use vertical and horizontal gestures to change brightness, volume and seek in video"
                        mPrefs.markFirstRun();
                    }
                    if (errorToShow != null) {
                        showError(errorToShow);
                        errorToShow = null;
                    }
                }
            }
        });

        compatTranslucency();

        int typ = getIntent().getIntExtra("Type", 0);

        if (typ==0){
            // Do Nothing
        }
        else {

            try {
                /*super.onStop();
                releasePlayer();*/
            }catch (Exception e){
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
            }

            super_position = getIntent().getIntExtra("Position", 0);
            startVideo(super_position);


        }


        fab_lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minimizeApp();
            }
        });

        fab_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.pause();
                File file = new File(getIntent().getStringArrayListExtra("VideoFilePath").get(super_position));
                deleteImage(file);
                releasePlayer();
                int cont_type = getIntent().getIntExtra("Type", 0);

                if (cont_type==0){
                    MainActivity.super.onBackPressed();
                }
                else if (cont_type==1){
                    startActivity(new Intent(MainActivity.this, VideoSelectorActivity.class));
                    finish();
                }
                else if (cont_type==2){
                    startActivity(new Intent(MainActivity.this, HiddenVideos.class));
                    finish();
                }
            }
        });

        fab_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.pause();

                File file = new File(getIntent().getStringArrayListExtra("VideoFilePath").get(super_position));
                Uri uri = Uri.fromFile(file);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent .setType("video/*");
                intent .putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(intent );
            }
        });






    }



    private void deleteImage(File file) {
        // Set up the projection (we only need the ID)
        String[] projection = {MediaStore.Video.Media._ID};

        // Match on the file path
        String selection = MediaStore.Video.Media.DATA + " = ?";
        String[] selectionArgs = new String[]{file.getAbsolutePath()};

        // Query for the ID of the media matching the file path
        Uri queryUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = getContentResolver();
        Cursor c = contentResolver.query(queryUri, projection, selection, selectionArgs, null);
        if (c.moveToFirst()) {
            // We found the ID. Deleting the item via the content provider will also remove the file
            long id = c.getLong(c.getColumnIndexOrThrow(MediaStore.Video.Media._ID));
            Uri deleteUri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id);
            contentResolver.delete(deleteUri, null, null);
        } else {
            // File not found in media store DB
        }
        c.close();
    }

    @Override
    public void onStart() {
        super.onStart();
        try {
            fragment.onStop();
            Log.d("EqualiserFragment", "stop");
        } catch (Exception e) {
            Log.d("EqualiserFragment", e.toString());
        }
      //  initializePlayer();
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            fragment.onStop();
            Log.d("EqualiserFragment", "stop");
        } catch (Exception e) {
            Log.d("EqualiserFragment", e.toString());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        //releasePlayer();
        try {
            fragment.onStop();
            Log.d("EqualiserFragment", "stop");
        } catch (Exception e) {
            Log.d("EqualiserFragment", e.toString());
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent != null && Intent.ACTION_VIEW.equals(intent.getAction()) && intent.getData() != null) {
            mPrefs.updateMedia(intent.getData(), intent.getType());
            initializePlayer();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                playerView.removeCallbacks(playerView.textClearRunnable);
                Utils.adjustVolume(mAudioManager, playerView, keyCode == KeyEvent.KEYCODE_VOLUME_UP, event.getRepeatCount() == 0);
                return true;
            case KeyEvent.KEYCODE_BUTTON_SELECT:
            case KeyEvent.KEYCODE_BUTTON_START:
            case KeyEvent.KEYCODE_BUTTON_A:
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_NUMPAD_ENTER:
            case KeyEvent.KEYCODE_SPACE:
                if (!controllerVisibleFully) {
                    if (player.isPlaying()) {
                        player.pause();
                    } else {
                        player.play();
                    }
                    return true;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
            case KeyEvent.KEYCODE_BUTTON_L2:
                if (!controllerVisibleFully) {
                    playerView.removeCallbacks(playerView.textClearRunnable);
                    long seekTo = player.getCurrentPosition() - 10_000;
                    if (seekTo < 0)
                        seekTo = 0;
                    player.setSeekParameters(SeekParameters.PREVIOUS_SYNC);
                    player.seekTo(seekTo);
                    playerView.setCustomErrorMessage(Utils.formatMilis(seekTo));
                    return true;
                }
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_BUTTON_R2:
                if (!controllerVisibleFully) {
                    playerView.removeCallbacks(playerView.textClearRunnable);
                    long seekTo = player.getCurrentPosition() + 10_000;
                    long seekMax = player.getDuration();
                    if (seekMax != C.TIME_UNSET && seekTo > seekMax)
                        seekTo = seekMax;
                    MainActivity.player.setSeekParameters(SeekParameters.NEXT_SYNC);
                    player.seekTo(seekTo);
                    playerView.setCustomErrorMessage(Utils.formatMilis(seekTo));
                    return true;
                }
                break;
            case KeyEvent.KEYCODE_BACK:
                break;
            default:
                if (!controllerVisibleFully) {
                    playerView.showController();
                    return true;
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                playerView.postDelayed(playerView.textClearRunnable, CustomStyledPlayerView.MESSAGE_TIMEOUT_KEY);
                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
            case KeyEvent.KEYCODE_BUTTON_L2:
            case KeyEvent.KEYCODE_DPAD_RIGHT:
            case KeyEvent.KEYCODE_BUTTON_R2:
                playerView.postDelayed(playerView.textClearRunnable, CustomStyledPlayerView.MESSAGE_TIMEOUT_KEY);
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);


        if (isInPictureInPictureMode) {
            setSubtitleTextSizePiP();
            playerView.setScale(1.f);
            mReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    if (intent == null || !ACTION_MEDIA_CONTROL.equals(intent.getAction())) {
                        return;
                    }

                    switch (intent.getIntExtra(EXTRA_CONTROL_TYPE, 0)) {
                        case CONTROL_TYPE_PLAY:
                            player.play();
                            break;
                        case CONTROL_TYPE_PAUSE:
                            player.pause();
                            break;
                    }
                }
            };
            registerReceiver(mReceiver, new IntentFilter(ACTION_MEDIA_CONTROL));
        } else {
            setSubtitleTextSize();
            if (mPrefs.resizeMode == AspectRatioFrameLayout.RESIZE_MODE_ZOOM) {
                playerView.setScale(mPrefs.scale);
            }
            if (mReceiver != null) {
                unregisterReceiver(mReceiver);
                mReceiver = null;
            }
            playerView.setControllerAutoShow(true);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (restoreOrientationLock) {
                Settings.System.putInt(getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 0);
                restoreOrientationLock = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (requestCode == REQUEST_CHOOSER_VIDEO) {
            if (resultCode == RESULT_OK) {

                File file = new File("/storage/emulated/0/DCIM/ScreenRecorder/Screenrecorder-2020-10-31-20-04-39-62.mp4");

                final Uri uri = Uri.fromFile(file);


                boolean uriAlreadyTaken = false;

                // https://commonsware.com/blog/2020/06/13/count-your-saf-uri-permission-grants.html
                final ContentResolver contentResolver = getContentResolver();
                for (UriPermission persistedUri : contentResolver.getPersistedUriPermissions()) {
                    if (persistedUri.getUri().equals(uri)) {
                        uriAlreadyTaken = true;
                    } else {
                        contentResolver.releasePersistableUriPermission(persistedUri.getUri(), Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    }
                }

                if (!uriAlreadyTaken) {
                    try {
                        contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                }

                mPrefs.updateMedia(uri, data.getType());
                initializePlayer();
            }
        } else if (requestCode == REQUEST_CHOOSER_SUBTITLE) {
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();

                try {
                    getContentResolver().takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                } catch (SecurityException e) {
                    e.printStackTrace();
                }

                // Convert subtitles to UTF-8 if necessary
                try {
                    final CharsetDetector detector = new CharsetDetector();
                    final BufferedInputStream bufferedInputStream = new BufferedInputStream(getContentResolver().openInputStream(uri));
                    detector.setText(bufferedInputStream);
                    final CharsetMatch charsetMatch = detector.detect();

                    if (!StandardCharsets.ISO_8859_1.displayName().equals(charsetMatch.getName()) &&
                            !StandardCharsets.UTF_8.displayName().equals(charsetMatch.getName())) {
                        String filename = uri.getPath();
                        filename = filename.substring(filename.lastIndexOf("/") + 1);
                        final File file = new File(getCacheDir(), filename);
                        try (FileOutputStream stream = new FileOutputStream(file)) {
                            stream.write(charsetMatch.getString().getBytes());
                            uri = Uri.fromFile(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mPrefs.updateSubtitle(uri);
                initializePlayer();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void initializePlayer() {
        haveMedia = mPrefs.mediaUri != null && (Utils.fileExists(this, mPrefs.mediaUri) || mPrefs.mediaUri.getScheme().startsWith("http"));

        if (player == null) {
            trackSelector = new DefaultTrackSelector(this);
            /*trackSelector.setParameters(
                    trackSelector.buildUponParameters().setMaxVideoSizeSd());*/
            RenderersFactory renderersFactory = new DefaultRenderersFactory(this)
                    .setExtensionRendererMode(DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON);
            // https://github.com/google/ExoPlayer/issues/8571
            final DefaultExtractorsFactory extractorsFactory = new DefaultExtractorsFactory()
                    .setTsExtractorTimestampSearchBytes(1500 * TsExtractor.TS_PACKET_SIZE);
            player = new SimpleExoPlayer.Builder(this, renderersFactory)
                    .setTrackSelector(trackSelector)
                    .setMediaSourceFactory(new DefaultMediaSourceFactory(this, extractorsFactory))
                    .build();
            final AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(C.USAGE_MEDIA)
                    .setContentType(C.CONTENT_TYPE_MOVIE)
                    .build();
            player.setAudioAttributes(audioAttributes, false);
        }

        playerView.setPlayer(player);

        mediaSession = new MediaSessionCompat(this, getString(R.string.app_name));
        MediaSessionConnector mediaSessionConnector = new MediaSessionConnector(mediaSession);
        mediaSessionConnector.setPlayer(player);

        if (haveMedia) {

            playerView.setControllerShowTimeoutMs(CONTROLLER_TIMEOUT);

            playerView.setResizeMode(mPrefs.resizeMode);

            if (mPrefs.resizeMode == AspectRatioFrameLayout.RESIZE_MODE_ZOOM) {
                playerView.setScale(mPrefs.scale);
            } else {
                playerView.setScale(1.f);
            }

            MediaItem.Builder mediaItemBuilder = new MediaItem.Builder()
                    .setUri(mPrefs.mediaUri)
                    .setMimeType(mPrefs.mediaType);
            if (mPrefs.subtitleUri != null && Utils.fileExists(this, mPrefs.subtitleUri)) {
                final String subtitleMime = Utils.getSubtitleMime(mPrefs.subtitleUri);
                final String subtitleLanguage = Utils.getSubtitleLanguage(mPrefs.subtitleUri);
                final String subtitleName = Utils.getFileName(this, mPrefs.subtitleUri);

                MediaItem.Subtitle subtitle = new MediaItem.Subtitle(mPrefs.subtitleUri, subtitleMime, subtitleLanguage, 0, C.ROLE_FLAG_SUBTITLE, subtitleName);
                mediaItemBuilder.setSubtitles(Collections.singletonList(subtitle));
            }
            player.setMediaItem(mediaItemBuilder.build());

            if (loudnessEnhancer != null) {
                loudnessEnhancer.release();
            }
            try {
                int audioSessionId = C.generateAudioSessionIdV21(this);
                loudnessEnhancer = new LoudnessEnhancer(audioSessionId);
                player.setAudioSessionId(audioSessionId);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }

            // When audio session id changes?
            player.addAudioListener(new AudioListener() {
                @Override
                public void onAudioSessionIdChanged(int audioSessionId) {
                    if (loudnessEnhancer != null) {
                        loudnessEnhancer.release();
                    }
                    try {
                        loudnessEnhancer = new LoudnessEnhancer(audioSessionId);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                }
            });

            setTracks = true;

            if (mPrefs.getPosition()==0){
                Log.d("NewOrOld", "It is New Entry");
            }
            else {
                Log.d("NewOrOld", "It is Old Entry");



                {
                    LayoutInflater inflater = getLayoutInflater();
                    View alertLayout = inflater.inflate(R.layout.startover_dialog, null);

                    TextView start_over = alertLayout.findViewById(R.id.start_over);
                    TextView resume_vid = alertLayout.findViewById(R.id.resume_vid);

                    androidx.appcompat.app.AlertDialog.Builder builder =  new androidx.appcompat.app.AlertDialog.Builder(MainActivity.this).setView(alertLayout);

                    final androidx.appcompat.app.AlertDialog dialog = builder.create();

                    // Finally, display the alert dialog
                    dialog.show();

                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                    start_over.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            player.seekTo(0);
                            player.play();
                            dialog.dismiss();
                        }
                    });

                    resume_vid.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            player.play();
                            dialog.dismiss();
                        }
                    });
                }


            }

            play = mPrefs.getPosition() == 0L;
            player.setPlayWhenReady(play);

            player.seekTo(mPrefs.getPosition());

            titleView.setText(Utils.getFileName(this, mPrefs.mediaUri));
            titleView.setVisibility(View.VISIBLE);

            if (buttonPiP != null)
                Utils.setButtonEnabled(this, buttonPiP, true);

            Utils.setButtonEnabled(this, buttonAspectRatio, true);

            player.setHandleAudioBecomingNoisy(true);
            mediaSession.setActive(true);
        } else {

            playerView.setControllerShowTimeoutMs(-1);
            playerView.showController();
        }

        player.addListener(playbackStateListener);
        player.prepare();

        if (restorePlayState) {

            restorePlayState = false;
            playerView.showController();
            player.play();
        }



    }

    private void releasePlayer() {
        if (player != null) {
            mediaSession.setActive(false);
            mediaSession.release();

            mPrefs.updatePosition(player.getCurrentPosition());
            mPrefs.updateBrightness(mBrightnessControl.currentBrightnessLevel);
            mPrefs.updateOrientation();
            mPrefs.updateMeta(getSelectedTrack(C.TRACK_TYPE_AUDIO), getSelectedTrack(C.TRACK_TYPE_TEXT), playerView.getResizeMode(), playerView.getVideoSurfaceView().getScaleX());

            if (player.isPlaying()) {
                restorePlayState = true;
            }
            player.removeListener(playbackStateListener);
            player.release();
            player = null;
        }
    }

    private class PlaybackStateListener implements Player.EventListener{
        @Override
        public void onIsPlayingChanged(boolean isPlaying) {
            playerView.setKeepScreenOn(isPlaying);

            if (isPiPSupported()) {
                if (isPlaying) {
                    updatePictureInPictureActions(R.drawable.ic_pause_24dp, "Pause", CONTROL_TYPE_PAUSE, REQUEST_PAUSE);
                } else {
                    updatePictureInPictureActions(R.drawable.ic_play_arrow_24dp, "Play", CONTROL_TYPE_PLAY, REQUEST_PLAY);
                }
            }
        }

        @Override
        public void onPlaybackStateChanged(int state) {
            if (state == Player.STATE_READY) {
                final Format format = player.getVideoFormat();
                if (format != null) {
                    if (mPrefs.orientation == Utils.Orientation.VIDEO) {
                        if (Utils.isPortrait(format)) {
                            MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
                        } else {
                            MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
                        }
                    }
                }

                if (play) {
                    play = false;
                    playerView.hideController();
                }
            }

            if (setTracks && state == Player.STATE_READY) {
                if (mPrefs.audioTrack >= 0)
                    setSelectedTrack(C.TRACK_TYPE_AUDIO, mPrefs.audioTrack);
                if (mPrefs.subtitleTrack >= 0 && mPrefs.subtitleTrack < getTrackCount(C.TRACK_TYPE_TEXT))
                    setSelectedTrack(C.TRACK_TYPE_TEXT, mPrefs.subtitleTrack);
            }
        }

        @Override
        public void onPlayerError(ExoPlaybackException error) {
            if (controllerVisible && controllerVisibleFully) {
                showError(error);
            } else {
                errorToShow = error;
            }
        }
    }

    private void enableRotation() {
        try {
            if (Settings.System.getInt(getContentResolver(), Settings.System.ACCELEROMETER_ROTATION) == 0) {
                Settings.System.putInt(getContentResolver(), Settings.System.ACCELEROMETER_ROTATION, 1);
                restoreOrientationLock = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openFile(Uri pickerInitialUri) {
        enableRotation();

        final Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("video/*");

        // http://stackoverflow.com/a/31334967/1615876
        intent.putExtra("android.content.extra.SHOW_ADVANCED", true);

        if (Build.VERSION.SDK_INT >= 26)
            intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);

        safelyStartActivityForResult(intent, REQUEST_CHOOSER_VIDEO);
    }

    private void loadSubtitleFile(Uri pickerInitialUri) {
        enableRotation();

        final Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");

        // http://stackoverflow.com/a/31334967/1615876
        intent.putExtra("android.content.extra.SHOW_ADVANCED", true);

        final String[] supportedMimeTypes = {
                MimeTypes.APPLICATION_SUBRIP,
                MimeTypes.TEXT_SSA,
                MimeTypes.TEXT_VTT,
                MimeTypes.APPLICATION_TTML,
                "text/*",
                "application/octet-stream"
        };
        intent.putExtra(Intent.EXTRA_MIME_TYPES, supportedMimeTypes);

        if (Build.VERSION.SDK_INT >= 26)
            intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);

        safelyStartActivityForResult(intent, REQUEST_CHOOSER_SUBTITLE);
    }

    void safelyStartActivityForResult(final Intent intent, final int code) {
        if (intent.resolveActivity(getPackageManager()) == null)
            showSnack(getText(R.string.error_files_missing).toString(), intent.toString());
        else
            startActivityForResult(intent, code);
    }

    public void setSelectedTrack(final int trackType, final int trackIndex) {
        final MappingTrackSelector.MappedTrackInfo mappedTrackInfo = trackSelector.getCurrentMappedTrackInfo();
        if (mappedTrackInfo != null) {
            final DefaultTrackSelector.Parameters parameters = trackSelector.getParameters();
            final DefaultTrackSelector.ParametersBuilder parametersBuilder = parameters.buildUpon();
            for (int rendererIndex = 0; rendererIndex < mappedTrackInfo.getRendererCount(); rendererIndex++) {
                if (mappedTrackInfo.getRendererType(rendererIndex) == trackType) {
                    parametersBuilder.clearSelectionOverrides(rendererIndex).setRendererDisabled(rendererIndex, false);
                    final int [] tracks = {0};
                    final DefaultTrackSelector.SelectionOverride selectionOverride = new DefaultTrackSelector.SelectionOverride(trackIndex, tracks);
                    parametersBuilder.setSelectionOverride(rendererIndex, mappedTrackInfo.getTrackGroups(rendererIndex), selectionOverride);
                }
            }
            trackSelector.setParameters(parametersBuilder);
        }
    }

    public int getSelectedTrack(final int trackType) {
        if (trackSelector != null) {
            final MappingTrackSelector.MappedTrackInfo mappedTrackInfo = trackSelector.getCurrentMappedTrackInfo();
            if (mappedTrackInfo != null) {
                for (int rendererIndex = 0; rendererIndex < mappedTrackInfo.getRendererCount(); rendererIndex++) {
                    if (mappedTrackInfo.getRendererType(rendererIndex) == trackType) {
                        final TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(rendererIndex);
                        final DefaultTrackSelector.SelectionOverride selectionOverride = trackSelector.getParameters().getSelectionOverride(rendererIndex, trackGroups);
                        if (selectionOverride == null || selectionOverride.length <= 0) {
                            break;
                        }
                        return selectionOverride.groupIndex;
                    }
                }
            }
        }
        return -1;
    }

    public int getTrackCount(final int trackType) {
        if (trackSelector != null) {
            final MappingTrackSelector.MappedTrackInfo mappedTrackInfo = trackSelector.getCurrentMappedTrackInfo();
            if (mappedTrackInfo != null) {
                for (int rendererIndex = 0; rendererIndex < mappedTrackInfo.getRendererCount(); rendererIndex++) {
                    if (mappedTrackInfo.getRendererType(rendererIndex) == trackType) {
                        final TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(rendererIndex);
                        return trackGroups.length;
                    }
                }
            }
        }
        return 0;
    }

    void setSubtitleTextSize() {
        setSubtitleTextSize(getResources().getConfiguration().orientation);
    }

    void setSubtitleTextSize(final int orientation) {
        // Tweak text size as fraction size doesn't work well in portrait
        final SubtitleView subtitleView = playerView.getSubtitleView();
        if (subtitleView != null) {
            final float size;
            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
                size = SubtitleView.DEFAULT_TEXT_SIZE_FRACTION * subtitlesScale;
            } else {
                DisplayMetrics metrics = getResources().getDisplayMetrics();
                float ratio = ((float)metrics.heightPixels / (float)metrics.widthPixels);
                if (ratio < 1)
                    ratio = 1 / ratio;
                size = SubtitleView.DEFAULT_TEXT_SIZE_FRACTION * subtitlesScale / ratio;
            }

            subtitleView.setFractionalTextSize(size);
        }
    }

    void setSubtitleTextSizePiP() {
        final SubtitleView subtitleView = playerView.getSubtitleView();
        if (subtitleView != null)
            subtitleView.setFractionalTextSize(SubtitleView.DEFAULT_TEXT_SIZE_FRACTION * 2);
    }

    boolean isPiPSupported() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && getPackageManager().hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE);
    }

    @TargetApi(26)
    void updatePictureInPictureActions(final int iconId, final String title, final int controlType, final int requestCode) {
        final ArrayList<RemoteAction> actions = new ArrayList<>();
        final PendingIntent intent = PendingIntent.getBroadcast(MainActivity.this, requestCode,
                        new Intent(ACTION_MEDIA_CONTROL).putExtra(EXTRA_CONTROL_TYPE, controlType), PendingIntent.FLAG_IMMUTABLE);
        final Icon icon = Icon.createWithResource(MainActivity.this, iconId);
        actions.add(new RemoteAction(icon, title, title, intent));
        ((PictureInPictureParams.Builder)mPictureInPictureParamsBuilder).setActions(actions);
        setPictureInPictureParams(((PictureInPictureParams.Builder)mPictureInPictureParamsBuilder).build());
    }

    private boolean isInPip() {
        if (!isPiPSupported())
            return false;
        return isInPictureInPictureMode();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (!isInPip())
            setSubtitleTextSize(newConfig.orientation);
    }

    void compatTranslucency() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.P) {
            try {
                final Resources resources = getResources();
                final boolean enableTranslucentDecor = resources.getBoolean(resources.getIdentifier("config_enableTranslucentDecor", "bool", "android"));
                if (enableTranslucentDecor) {
                    // Samsung devices running L show transparent status bar instead of translucent one
                    // https://stackoverflow.com/questions/31024072/android-translucent-status-bar-differs-in-different-devices
                    // https://stackoverflow.com/questions/39061975/android-translucent-status-bar-on-samsung-devices
                    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M && Build.MANUFACTURER.toLowerCase().equals("samsung")) {
                        final Window window = getWindow();
                        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                        window.setStatusBarColor(resources.getColor(R.color.exo_bottom_bar_background));
                    }
                } else {
                    // Nexus 10 disables translucent bars
                    // https://forum.xda-developers.com/showthread.php?t=2510252
                    final Window window = getWindow();
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                }
            } catch (Resources.NotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    void showError(ExoPlaybackException error) {
        final String errorGeneral = error.getLocalizedMessage();
        String errorDetailed;

        switch (error.type) {
            case ExoPlaybackException.TYPE_SOURCE:
                errorDetailed = error.getSourceException().getLocalizedMessage();
                break;
            case ExoPlaybackException.TYPE_RENDERER:
                errorDetailed = error.getRendererException().getLocalizedMessage();
                break;
            case ExoPlaybackException.TYPE_UNEXPECTED:
                errorDetailed = error.getUnexpectedException().getLocalizedMessage();
                break;
            case ExoPlaybackException.TYPE_REMOTE:
            default:
                errorDetailed = errorGeneral;
                break;
        }

        showSnack(errorGeneral, errorDetailed);
    }

    void showSnack(final String textPrimary, final String textSecondary) {
        snackbar = Snackbar.make(coordinatorLayout, textPrimary, Snackbar.LENGTH_LONG);
        if (textSecondary != null) {
            snackbar.setAction(R.string.error_details, v -> {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(textSecondary);
                builder.setPositiveButton(android.R.string.ok, (dialogInterface, i) -> dialogInterface.dismiss());
                final AlertDialog dialog = builder.create();
                dialog.show();
            });
        }
        snackbar.setAnchorView(R.id.exo_bottom_bar);
        snackbar.show();
    }

    void reportScrubbing(long position) {
        final long diff = position - scrubbingStart;
        if (Math.abs(diff) > 1000) {
            scrubbing = true;
        }
        if (scrubbing) {
            playerView.clearIcon();
            playerView.setCustomErrorMessage(Utils.formatMilisSign(diff));
        }
        player.seekTo(position);
    }

    public void startVideo(int position){


        File file = new File(getIntent().getStringArrayListExtra("VideoFilePath").get(position));

        final Uri uri = Uri.fromFile(file);


        boolean uriAlreadyTaken = false;

        // https://commonsware.com/blog/2020/06/13/count-your-saf-uri-permission-grants.html
        final ContentResolver contentResolver = getContentResolver();
        for (UriPermission persistedUri : contentResolver.getPersistedUriPermissions()) {
            if (persistedUri.getUri().equals(uri)) {
                uriAlreadyTaken = true;
                Log.e("TestingResume/Start", "Old Video");
            } else {
                contentResolver.releasePersistableUriPermission(persistedUri.getUri(), Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Log.e("TestingResume/Start", "New Video");
            }
        }

        if (!uriAlreadyTaken) {
            try {
                contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Log.e("TestingResume/Start", "Old Video");
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }

        String file_name = file.getName();


        mPrefs.updateMedia(uri, Files.getFileExtension(file_name));
        initializePlayer();
    }


    @Override
    public void onBackPressed() {

        if (findViewById(R.id.lock_player).getVisibility()==View.VISIBLE){
            Log.d("GestureLock", "UnLocked");
            releasePlayer();

            int cont_type = getIntent().getIntExtra("Type", 0);

            if (cont_type==0){
                super.onBackPressed();
            }
            else if (cont_type==1){
                startActivity(new Intent(MainActivity.this, VideoSelectorActivity.class));
                finish();
            }
            else if (cont_type==2){
                startActivity(new Intent(MainActivity.this, HiddenVideos.class));
                finish();
            }
        }
        else {
            Log.d("GestureLock", "Locked");
        }

    }

    public void minimizeApp() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);

        addNotification();

    }

    private void addNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "My Notification");
        builder.setContentTitle("Video Player");
        builder.setContentText(titleView.getText().toString());
        builder.setSmallIcon(R.drawable.app_logo);
        builder.setAutoCancel(true);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);


        builder.setContentIntent(contentIntent);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(1, builder.build());
    }

    private void takeSS(View v){
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            // image naming and path  to include sd card  appending name you choose for file
            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpeg";

            // create bitmap screen capture
            v.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v.getDrawingCache());
            v.setDrawingCacheEnabled(false);

            File imageFile = new File(mPath);

            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            //setting screenshot in imageview
            String filePath = imageFile.getPath();

            Bitmap ssbitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
            //ivpl.setImageBitmap(ssbitmap);
            //sharePath = filePath;

        } catch (Throwable e) {
            // Several error may come out with file handling or DOM
            e.printStackTrace();
        }
    }


}