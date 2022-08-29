package com.statusmaker_photoeditor_music.videoplayer.radio.ui.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.radio.MainActivity;
import com.statusmaker_photoeditor_music.videoplayer.radio.data.repositories.SettingsRepository;
import com.royalplayer.lite.databinding.FragmentSettingsBinding;
import com.statusmaker_photoeditor_music.videoplayer.themes.RadioMainScreen;
import com.statusmaker_photoeditor_music.videoplayer.themes.RadioSettingScreen;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;

public class SettingsFragment extends Fragment {
    private SettingsViewModel settingsViewModel;
    private static final String TAG = "SettingsFragment";
    FragmentSettingsBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        SettingsRepository repository = new SettingsRepository(getContext());
        SettingsFactory factory = new SettingsFactory(repository);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings,container, false);
        settingsViewModel = new ViewModelProvider(this, factory).get(SettingsViewModel.class);

        binding.setLifecycleOwner(this);

        binding.setViewModel(settingsViewModel);

        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(getContext());

        String current_theme = theme_pref.getString("Theme", "default");

        RadioSettingScreen radioSettingScreen = new RadioSettingScreen();

        if (current_theme.equals("theme1")){
            radioSettingScreen.theme1(binding.radSetScr);
        }
        else if (current_theme.equals("theme2")){
            radioSettingScreen.theme2(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_1))){
            radioSettingScreen.flat_theme1(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_2))){
            radioSettingScreen.flat_theme2(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_3))){
            radioSettingScreen.flat_theme3(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_4))){
            radioSettingScreen.flat_theme4(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_5))){
            radioSettingScreen.flat_theme5(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_6))){
            radioSettingScreen.flat_theme6(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_7))){
            radioSettingScreen.flat_theme7(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_8))){
            radioSettingScreen.flat_theme8(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_9))){
            radioSettingScreen.flat_theme9(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_10))){
            radioSettingScreen.flat_theme10(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_11))){
            radioSettingScreen.flat_theme11(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_12))){
            radioSettingScreen.flat_theme12(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_13))){
            radioSettingScreen.flat_theme13(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_14))){
            radioSettingScreen.flat_theme14(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_15))){
            radioSettingScreen.flat_theme15(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_16))){
            radioSettingScreen.flat_theme16(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_17))){
            radioSettingScreen.flat_theme17(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_18))){
            radioSettingScreen.flat_theme18(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_19))){
            radioSettingScreen.flat_theme19(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_20))){
            radioSettingScreen.flat_theme20(binding.radSetScr);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_1))){
            radioSettingScreen.grad_theme1(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_2))){
            radioSettingScreen.grad_theme2(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_3))){
            radioSettingScreen.grad_theme3(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_4))){
            radioSettingScreen.grad_theme4(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_5))){
            radioSettingScreen.grad_theme5(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_6))){
            radioSettingScreen.grad_theme6(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_7))){
            radioSettingScreen.grad_theme7(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_8))){
            radioSettingScreen.grad_theme8(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_9))){
            radioSettingScreen.grad_theme9(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_10))){
            radioSettingScreen.grad_theme10(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_11))){
            radioSettingScreen.grad_theme11(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_12))){
            radioSettingScreen.grad_theme12(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_13))){
            radioSettingScreen.grad_theme13(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_14))){
            radioSettingScreen.grad_theme14(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_15))){
            radioSettingScreen.grad_theme15(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_16))){
            radioSettingScreen.grad_theme16(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_17))){
            radioSettingScreen.grad_theme17(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_18))){
            radioSettingScreen.grad_theme18(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_19))){
            radioSettingScreen.grad_theme19(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_20))){
            radioSettingScreen.grad_theme20(binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto1))){
            radioSettingScreen.picto_theme1(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto2))){
            radioSettingScreen.picto_theme2(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto3))){
            radioSettingScreen.picto_theme3(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto4))){
            radioSettingScreen.picto_theme4(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto5))){
            radioSettingScreen.picto_theme5(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto6))){
            radioSettingScreen.picto_theme6(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto7))){
            radioSettingScreen.picto_theme7(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto8))){
            radioSettingScreen.picto_theme8(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto9))){
            radioSettingScreen.picto_theme9(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto10))){
            radioSettingScreen.picto_theme10(getActivity(), binding.radSetScr);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto11))){
            radioSettingScreen.picto_theme11(getActivity(), binding.radSetScr);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto12))){
            radioSettingScreen.picto_theme12(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto13))){
            radioSettingScreen.picto_theme13(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto14))){
            radioSettingScreen.picto_theme14(getActivity(), binding.radSetScr);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto15))){
            radioSettingScreen.picto_theme15(getActivity(), binding.radSetScr);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto16))){
            radioSettingScreen.picto_theme16(getActivity(), binding.radSetScr);
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto17))){
            radioSettingScreen.picto_theme17(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto18))){
            radioSettingScreen.picto_theme18(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto19))){
            radioSettingScreen.picto_theme19(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto20))){
            radioSettingScreen.picto_theme20(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto21))){
            radioSettingScreen.picto_theme21(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto22))){
            radioSettingScreen.picto_theme22(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto23))){
            radioSettingScreen.picto_theme23(getActivity(), binding.radSetScr);
        }
        else if (current_theme.equals("CustomTheme")){
            radioSettingScreen.customTheme(getActivity(), binding.radSetScr);
}
else if (current_theme.equals(String.valueOf(R.drawable.picto24))){
            radioSettingScreen.picto_theme24(getActivity(), binding.radSetScr);
        }
        else {

        }


        return binding.getRoot();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        settingsViewModel.getFeedbackResponse().observe(getViewLifecycleOwner(), response -> {
            Toast.makeText(getActivity(), response.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }


    @Override
    public void onDetach() {
        super.onDetach();
        binding=null;
    }
}
