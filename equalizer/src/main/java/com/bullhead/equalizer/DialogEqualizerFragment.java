package com.bullhead.equalizer;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.media.audiofx.BassBoost;
import android.media.audiofx.Equalizer;
import android.media.audiofx.PresetReverb;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.DialogFragment;

import com.db.chart.model.LineSet;
import com.db.chart.view.AxisController;
import com.db.chart.view.ChartView;
import com.db.chart.view.LineChartView;

import java.util.ArrayList;


public class DialogEqualizerFragment extends DialogFragment {
    public static final  String ARG_AUDIO_SESSIOIN_ID = "audio_session_id";
    private static final String TAG                   = DialogEqualizerFragment.class.getSimpleName();
    private static       int    accentAlpha           = Color.BLUE;
    private static       int    darkBackground        = Color.GRAY;
    private static       int    textColor             = Color.WHITE;
    private static       int    themeColor            = Color.parseColor("#B24242");
    private static       int    backgroundColor       = Color.WHITE;
    private static       int    themeRes              = 0;
    private static       String titleString           = "";
    private static       int    titleRes              = 0;

    private Equalizer        mEqualizer;
    private BassBoost        bassBoost;
    private PresetReverb     presetReverb;
    private LineSet          dataset;
    private LineChartView    chart;
    private float[]          points;
    private int              y            = 0;
    private SeekBar[]        seekBarFinal = new SeekBar[5];
    private Spinner          presetSpinner;
    private Context          ctx;
    private int              audioSesionId;
    private TextView         titleTextView;
    private AnalogController bassController;
    private AnalogController reverbController;

    SharedPreferences sharedPreferences;

    int progress_bass, progress_3d , seekProgress1, seekProgress2, seekProgress3, seekProgress4, seekProgress5;

    String preset_name;


    public DialogEqualizerFragment() {
        // Required empty public constructor
    }

    private static DialogEqualizerFragment newInstance(int audioSessionId) {

        Bundle args = new Bundle();
        args.putInt(ARG_AUDIO_SESSIOIN_ID, audioSessionId);

        DialogEqualizerFragment fragment = new DialogEqualizerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public int getTheme() {
        if (themeRes != 0) return themeRes;
        else return super.getTheme();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Settings.isEditing = true;

        if (getArguments() != null && getArguments().containsKey(ARG_AUDIO_SESSIOIN_ID)) {
            audioSesionId = getArguments().getInt(ARG_AUDIO_SESSIOIN_ID);
        }

        if (Settings.equalizerModel == null) {
            Settings.equalizerModel = new EqualizerModel();
            Settings.equalizerModel.setReverbPreset(PresetReverb.PRESET_NONE);
            Settings.equalizerModel.setBassStrength((short) (1000 / 19));
        }

        mEqualizer = new Equalizer(0, audioSesionId);

        bassBoost = new BassBoost(0, audioSesionId);
        bassBoost.setEnabled(true);
        BassBoost.Settings bassBoostSettingTemp = bassBoost.getProperties();
        BassBoost.Settings bassBoostSetting     = new BassBoost.Settings(bassBoostSettingTemp.toString());
        bassBoostSetting.strength = Settings.equalizerModel.getBassStrength();
        bassBoost.setProperties(bassBoostSetting);

        presetReverb = new PresetReverb(0, audioSesionId);
        presetReverb.setPreset(Settings.equalizerModel.getReverbPreset());
        presetReverb.setEnabled(true);

        mEqualizer.setEnabled(true);

        if (Settings.presetPos == 0) {
            for (short bandIdx = 0; bandIdx < mEqualizer.getNumberOfBands(); bandIdx++) {
                mEqualizer.setBandLevel(bandIdx, (short) Settings.seekbarpos[bandIdx]);
            }
        } else {
            mEqualizer.usePreset((short) Settings.presetPos);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ctx = context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_fragment_equalizer, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView backBtn = view.findViewById(R.id.equalizer_back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("PresetName", presetSpinner.getSelectedItem().toString());
                editor.apply();
                onStop();
            }
        });
        backBtn.setColorFilter(textColor);
        view.findViewById(R.id.equalizerLayout).setBackgroundColor(backgroundColor);

        titleTextView = view.findViewById(R.id.equalizer_fragment_title);
        titleTextView.setTextColor(textColor);
        if (titleRes != 0) {
            try {
                titleTextView.setText(getString(titleRes));
            } catch (Exception e) {
                Log.e(TAG, "onViewCreated: unable to set title because " + e.getLocalizedMessage());
            }
        } else if (!TextUtils.isEmpty(titleString)) {
            titleTextView.setText(titleString);
        }
        SwitchCompat equalizerSwitch = view.findViewById(R.id.equalizer_switch);
        equalizerSwitch.setChecked(true);
        equalizerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mEqualizer.setEnabled(isChecked);
                bassBoost.setEnabled(isChecked);
                presetReverb.setEnabled(isChecked);
            }
        });


        presetSpinner = view.findViewById(R.id.equalizer_preset_spinner);
        presetSpinner.getBackground().setColorFilter(textColor, PorterDuff.Mode.SRC_ATOP);

        chart = view.findViewById(R.id.lineChart);
        Paint paint = new Paint();
        dataset = new LineSet();

        bassController   = view.findViewById(R.id.controllerBass);
        reverbController = view.findViewById(R.id.controller3D);

        bassController.setLabel("BASS");
        reverbController.setLabel("3D");


        bassController.circlePaint2.setColor(themeColor);
        bassController.linePaint.setColor(themeColor);
        bassController.invalidate();
        reverbController.circlePaint2.setColor(themeColor);
        reverbController.linePaint.setColor(themeColor);
        reverbController.invalidate();

        if (!Settings.isEqualizerReloaded) {
            int x = 0;
            if (bassBoost != null) {
                try {
                    x = ((bassBoost.getRoundedStrength() * 19) / 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (presetReverb != null) {
                try {
                    y = (presetReverb.getPreset() * 19) / 6;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (x == 0) {
                bassController.setProgress(1);
            } else {
                bassController.setProgress(x);
            }

            if (y == 0) {
                reverbController.setProgress(1);
            } else {
                reverbController.setProgress(y);
            }
        } else {
            int x = ((Settings.bassStrength * 19) / 1000);
            y = (Settings.reverbPreset * 19) / 6;
            if (x == 0) {
                bassController.setProgress(1);
            } else {
                bassController.setProgress(x);
            }

            if (y == 0) {
                reverbController.setProgress(1);
            } else {
                reverbController.setProgress(y);
            }
        }


        sharedPreferences = getContext().getSharedPreferences("EqualizerData", Context.MODE_PRIVATE);

        progress_bass = sharedPreferences.getInt("ProgressBass", 0);
        progress_3d = sharedPreferences.getInt("Progress3D", 0);

        seekProgress1 = sharedPreferences.getInt("SeekProgress1", 1500);
        seekProgress2 = sharedPreferences.getInt("SeekProgress2", 1500);
        seekProgress3 = sharedPreferences.getInt("SeekProgress3", 1500);
        seekProgress4 = sharedPreferences.getInt("SeekProgress4", 1500);
        seekProgress5 = sharedPreferences.getInt("SeekProgress5", 1500);

        bassController.setProgress(progress_bass);
        Settings.bassStrength = (short) (((float) 1000 / 19) * (progress_bass));
        try {
            bassBoost.setStrength(Settings.bassStrength);
            Settings.equalizerModel.setBassStrength(Settings.bassStrength);
        } catch (Exception e) {
            e.printStackTrace();
        }

        reverbController.setProgress(progress_3d);
        Settings.reverbPreset = (short) ((progress_3d * 6) / 19);
        Settings.equalizerModel.setReverbPreset(Settings.reverbPreset);
        try {
            presetReverb.setPreset(Settings.reverbPreset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        y = 19;

        bassController.setOnProgressChangedListener(new AnalogController.onProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress) {
                Log.e("ProgessBass", String.valueOf(progress));
                Settings.bassStrength = (short) (((float) 1000 / 19) * (progress));

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("ProgressBass", progress);
                editor.apply();

                try {
                    bassBoost.setStrength(Settings.bassStrength);
                    Settings.equalizerModel.setBassStrength(Settings.bassStrength);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        reverbController.setOnProgressChangedListener(new AnalogController.onProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress) {
                Settings.reverbPreset = (short) ((progress * 6) / 19);
                Settings.equalizerModel.setReverbPreset(Settings.reverbPreset);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("Progress3D", progress);
                editor.apply();

                try {
                    presetReverb.setPreset(Settings.reverbPreset);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                y = progress;
            }
        });

        TextView equalizerHeading = new TextView(ctx);
        equalizerHeading.setText(R.string.eq);
        equalizerHeading.setTextSize(20);
        equalizerHeading.setGravity(Gravity.CENTER_HORIZONTAL);

        short numberOfFrequencyBands = 5;

        points = new float[numberOfFrequencyBands];

        final short lowerEqualizerBandLevel = mEqualizer.getBandLevelRange()[0];
        final short upperEqualizerBandLevel = mEqualizer.getBandLevelRange()[1];

        for (short i = 0; i < numberOfFrequencyBands; i++) {
            final short    equalizerBandIndex      = i;
            final TextView frequencyHeaderTextView = new TextView(ctx);
            frequencyHeaderTextView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            frequencyHeaderTextView.setGravity(Gravity.CENTER_HORIZONTAL);
            frequencyHeaderTextView.setTextColor(textColor);
            frequencyHeaderTextView.setText((mEqualizer.getCenterFreq(equalizerBandIndex) / 1000) + "Hz");

            LinearLayout seekBarRowLayout = new LinearLayout(ctx);
            seekBarRowLayout.setOrientation(LinearLayout.VERTICAL);

            TextView lowerEqualizerBandLevelTextView = new TextView(ctx);
            lowerEqualizerBandLevelTextView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            ));
            lowerEqualizerBandLevelTextView.setTextColor(textColor);
            lowerEqualizerBandLevelTextView.setText((lowerEqualizerBandLevel / 100) + "dB");

            TextView upperEqualizerBandLevelTextView = new TextView(ctx);
            lowerEqualizerBandLevelTextView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            upperEqualizerBandLevelTextView.setTextColor(textColor);
            upperEqualizerBandLevelTextView.setText((upperEqualizerBandLevel / 100) + "dB");

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            layoutParams.weight = 1;

            SeekBar  seekBar  = new SeekBar(ctx);
            TextView textView = new TextView(ctx);
            switch (i) {
                case 0:
                    seekBar = view.findViewById(R.id.seekBar1);
                    textView = view.findViewById(R.id.textView1);
                    break;
                case 1:
                    seekBar = view.findViewById(R.id.seekBar2);
                    textView = view.findViewById(R.id.textView2);
                    break;
                case 2:
                    seekBar = view.findViewById(R.id.seekBar3);
                    textView = view.findViewById(R.id.textView3);
                    break;
                case 3:
                    seekBar = view.findViewById(R.id.seekBar4);
                    textView = view.findViewById(R.id.textView4);
                    break;
                case 4:
                    seekBar = view.findViewById(R.id.seekBar5);
                    textView = view.findViewById(R.id.textView5);
                    break;
            }


            seekBarFinal[i] = seekBar;
            seekBar.getProgressDrawable().setColorFilter(new PorterDuffColorFilter(Color.DKGRAY, PorterDuff.Mode.SRC_IN));
            seekBar.getThumb().setColorFilter(new PorterDuffColorFilter(themeColor, PorterDuff.Mode.SRC_IN));
            seekBar.setId(i);
//            seekBar.setLayoutParams(layoutParams);
            seekBar.setMax(upperEqualizerBandLevel - lowerEqualizerBandLevel);

            textView.setText(frequencyHeaderTextView.getText());
            textView.setTextColor(textColor);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            if (Settings.isEqualizerReloaded) {
                points[i] = Settings.seekbarpos[i] - lowerEqualizerBandLevel;
                dataset.addPoint(frequencyHeaderTextView.getText().toString(), points[i]);
                seekBar.setProgress(Settings.seekbarpos[i] - lowerEqualizerBandLevel);
            } else {
                points[i] = mEqualizer.getBandLevel(equalizerBandIndex) - lowerEqualizerBandLevel;
                dataset.addPoint(frequencyHeaderTextView.getText().toString(), points[i]);
                seekBar.setProgress(mEqualizer.getBandLevel(equalizerBandIndex) - lowerEqualizerBandLevel);
                Settings.seekbarpos[i]       = mEqualizer.getBandLevel(equalizerBandIndex);
                Settings.isEqualizerReloaded = true;
            }

            switch (i) {
                case 0:
                    seekBar.setProgress(seekProgress1);
                    mEqualizer.setBandLevel(equalizerBandIndex, (short) (seekProgress1 + lowerEqualizerBandLevel));
                    points[0]                                  = mEqualizer.getBandLevel(equalizerBandIndex) - lowerEqualizerBandLevel;
                    Settings.seekbarpos[0]                     = (seekProgress1 + lowerEqualizerBandLevel);
                    Settings.equalizerModel.getSeekbarpos()[0] = (seekProgress1 + lowerEqualizerBandLevel);
                    //dataset.updateValues(points);
                    chart.notifyDataUpdate();
                    break;
                case 1:
                    seekBar.setProgress(seekProgress2);
                    mEqualizer.setBandLevel(equalizerBandIndex, (short) (seekProgress2 + lowerEqualizerBandLevel));
                    points[1]                                  = mEqualizer.getBandLevel(equalizerBandIndex) - lowerEqualizerBandLevel;
                    Settings.seekbarpos[1]                     = (seekProgress2 + lowerEqualizerBandLevel);
                    Settings.equalizerModel.getSeekbarpos()[1] = (seekProgress2 + lowerEqualizerBandLevel);
                    //dataset.updateValues(points);
                    chart.notifyDataUpdate();
                    break;
                case 2:
                    seekBar.setProgress(seekProgress3);
                    mEqualizer.setBandLevel(equalizerBandIndex, (short) (seekProgress3 + lowerEqualizerBandLevel));
                    points[2]                                  = mEqualizer.getBandLevel(equalizerBandIndex) - lowerEqualizerBandLevel;
                    Settings.seekbarpos[2]                     = (seekProgress3 + lowerEqualizerBandLevel);
                    Settings.equalizerModel.getSeekbarpos()[2] = (seekProgress3 + lowerEqualizerBandLevel);
                   // dataset.updateValues(points);
                    chart.notifyDataUpdate();
                    break;
                case 3:
                    seekBar.setProgress(seekProgress4);
                    mEqualizer.setBandLevel(equalizerBandIndex, (short) (seekProgress4 + lowerEqualizerBandLevel));
                    points[3]                                  = mEqualizer.getBandLevel(equalizerBandIndex) - lowerEqualizerBandLevel;
                    Settings.seekbarpos[3]                     = (seekProgress4 + lowerEqualizerBandLevel);
                    Settings.equalizerModel.getSeekbarpos()[3] = (seekProgress4 + lowerEqualizerBandLevel);
                    //dataset.updateValues(points);
                    chart.notifyDataUpdate();
                    break;
                case 4:
                    seekBar.setProgress(seekProgress5);
                    mEqualizer.setBandLevel(equalizerBandIndex, (short) (seekProgress5 + lowerEqualizerBandLevel));
                    points[4]                                  = mEqualizer.getBandLevel(equalizerBandIndex) - lowerEqualizerBandLevel;
                    Settings.seekbarpos[4]                     = (seekProgress5 + lowerEqualizerBandLevel);
                    Settings.equalizerModel.getSeekbarpos()[4] = (seekProgress5 + lowerEqualizerBandLevel);
                   // dataset.updateValues(points);
                    chart.notifyDataUpdate();
                    break;
            }

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    Log.d("EqBand", seekBar.getId()+"");

                    if (seekBar.getId()==0){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("SeekProgress1", progress);
                        editor.apply();
                    }

                    if (seekBar.getId()==1){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("SeekProgress2", progress);
                        editor.apply();
                    }

                    if (seekBar.getId()==2){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("SeekProgress3", progress);
                        editor.apply();
                    }

                    if (seekBar.getId()==3){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("SeekProgress4", progress);
                        editor.apply();
                    }

                    if (seekBar.getId()==4){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("SeekProgress5", progress);
                        editor.apply();
                    }

                    mEqualizer.setBandLevel(equalizerBandIndex, (short) (progress + lowerEqualizerBandLevel));
                    points[seekBar.getId()]                                  = mEqualizer.getBandLevel(equalizerBandIndex) - lowerEqualizerBandLevel;
                    Settings.seekbarpos[seekBar.getId()]                     = (progress + lowerEqualizerBandLevel);
                    Settings.equalizerModel.getSeekbarpos()[seekBar.getId()] = (progress + lowerEqualizerBandLevel);
                    dataset.updateValues(points);
                    chart.notifyDataUpdate();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    presetSpinner.setSelection(0);
                    Settings.presetPos = 0;
                    Settings.equalizerModel.setPresetPos(0);
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

        }

        equalizeSound();



        paint.setColor(textColor);
        paint.setStrokeWidth((float) (1.10 * Settings.ratio));

        dataset.setColor(themeColor);
        dataset.setSmooth(true);
        dataset.setThickness(5);

        chart.setXAxis(false);
        chart.setYAxis(false);

        chart.setYLabels(AxisController.LabelPosition.NONE);
        chart.setXLabels(AxisController.LabelPosition.NONE);
        chart.setGrid(ChartView.GridType.NONE, 7, 10, paint);

        chart.setAxisBorderValues(-300, 3300);

        chart.addData(dataset);
        chart.show();

        Button mEndButton = new Button(ctx);
        mEndButton.setBackgroundColor(themeColor);
        mEndButton.setTextColor(textColor);


    }


    public TextView getTitleTextView() {
        return titleTextView;
    }

    public AnalogController getBassController() {
        return bassController;
    }

    public AnalogController getReverbController() {
        return reverbController;
    }


    public void equalizeSound() {
        ArrayList<String> equalizerPresetNames = new ArrayList<>();
        ArrayAdapter<String> equalizerPresetSpinnerAdapter = new ArrayAdapter<>(ctx,
                R.layout.spinner_item,
                equalizerPresetNames);
        equalizerPresetSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        equalizerPresetNames.add("Custom");

        for (short i = 0; i < mEqualizer.getNumberOfPresets(); i++) {
            equalizerPresetNames.add(mEqualizer.getPresetName(i));
        }

        presetSpinner.setAdapter(equalizerPresetSpinnerAdapter);
        if (Settings.isEqualizerReloaded && Settings.presetPos != 0) {
            presetSpinner.setSelection(Settings.presetPos);
        }

        presetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    if (position != 0) {
                        mEqualizer.usePreset((short) (position - 1));
                        Settings.presetPos = position;
                        short numberOfFreqBands = 5;

                        final short lowerEqualizerBandLevel = mEqualizer.getBandLevelRange()[0];

                        for (short i = 0; i < numberOfFreqBands; i++) {
                            seekBarFinal[i].setProgress(mEqualizer.getBandLevel(i) - lowerEqualizerBandLevel);
                            points[i]                                  = mEqualizer.getBandLevel(i) - lowerEqualizerBandLevel;
                            Settings.seekbarpos[i]                     = mEqualizer.getBandLevel(i);
                            Settings.equalizerModel.getSeekbarpos()[i] = mEqualizer.getBandLevel(i);
                        }
                        dataset.updateValues(points);
                        chart.notifyDataUpdate();
                    }
                } catch (Exception e) {
                    Toast.makeText(ctx, "Error while updating Equalizer", Toast.LENGTH_SHORT).show();
                }
                Settings.equalizerModel.setPresetPos(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        preset_name = sharedPreferences.getString("PresetName", "Normal");;

        presetSpinner.setSelection(equalizerPresetSpinnerAdapter.getPosition(preset_name));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mEqualizer != null) {
            mEqualizer.release();
        }

        if (bassBoost != null) {
            bassBoost.release();
        }

        if (presetReverb != null) {
            presetReverb.release();
        }

        Settings.isEditing = false;

    }

    public static class Builder {
        private int id = -1;

        public Builder setThemeRes(int res) {
            themeRes = res;
            return this;
        }

        public Builder setAudioSessionId(int id) {
            this.id = id;
            return this;
        }

        public Builder setAccentColor(int color) {
            themeColor = color;
            return this;
        }

        public Builder themeColor(int color) {
            backgroundColor = color;
            return this;
        }

        public Builder textColor(int color) {
            textColor = color;
            return this;
        }

        public Builder darkColor(int color) {
            darkBackground = color;
            return this;
        }

        public Builder accentAlpha(int color) {
            accentAlpha = color;
            return this;
        }

        public Builder title(@StringRes int title) {
            titleRes = title;
            return this;
        }

        public Builder title(@NonNull String title) {
            titleString = title;
            return this;
        }

        public DialogEqualizerFragment build() {
            return DialogEqualizerFragment.newInstance(id);
        }
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("PresetName", presetSpinner.getSelectedItem().toString());
        editor.apply();
        onStop();
    }
}