package com.statusmaker_photoeditor_music.videoplayer.radio.ui.home;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.radio.MainActivity;
import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.responses.Radio;
import com.statusmaker_photoeditor_music.videoplayer.radio.utils.AdsUtil;
import com.statusmaker_photoeditor_music.videoplayer.themes.RadioHomeDialScreen;
import com.statusmaker_photoeditor_music.videoplayer.themes.RadioMainScreen;

import java.util.List;

public class HomeDialog extends DialogFragment {

    private View rootView;
    private HomeListener listener;
    List<Radio> radioList;
    String type;
    String title;


    public static HomeDialog newInstance(HomeListener listener, List<Radio> radioList, String type, String title) {
        HomeDialog dialog = new HomeDialog();
        dialog.listener = listener;
        dialog.radioList = radioList;
        dialog.type = type;
        dialog.title = title;
        return dialog;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        initViews();
        AlertDialog alertDialog = new AlertDialog.Builder(getContext(), android.R.style.Theme_Light_NoTitleBar_Fullscreen)
                .setView(rootView)
                .setCancelable(false)
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        alertDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        return alertDialog;
    }

    private void initViews() {

        rootView = LayoutInflater.from(getContext())
                .inflate(R.layout.dialog_genre_country, null, false);

        ((TextView) rootView.findViewById(R.id.textView)).setText(title);
        rootView.findViewById(R.id.backBtn).setOnClickListener(view -> dismiss());
        RecyclerView recyclerView = rootView.findViewById(R.id.dialogRecyclerView);
        LinearLayout adLayoutContainer  = rootView.findViewById(R.id.adLayoutDialog);
        AdsUtil.loadBannerAd(getContext(), adLayoutContainer);


        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(getContext());

        String current_theme = theme_pref.getString("Theme", "default");

        RadioHomeDialScreen radioHomeDialScreen = new RadioHomeDialScreen();

        if (current_theme.equals("theme1")){
            radioHomeDialScreen.theme1(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals("theme2")){
            radioHomeDialScreen.theme2(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_1))){
            radioHomeDialScreen.flat_theme1(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_2))){
            radioHomeDialScreen.flat_theme2(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_3))){
            radioHomeDialScreen.flat_theme3(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_4))){
            radioHomeDialScreen.flat_theme4(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_5))){
            radioHomeDialScreen.flat_theme5(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_6))){
            radioHomeDialScreen.flat_theme6(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_7))){
            radioHomeDialScreen.flat_theme7(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_8))){
            radioHomeDialScreen.flat_theme8(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_9))){
            radioHomeDialScreen.flat_theme9(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_10))){
            radioHomeDialScreen.flat_theme10(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_11))){
            radioHomeDialScreen.flat_theme11(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_12))){
            radioHomeDialScreen.flat_theme12(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_13))){
            radioHomeDialScreen.flat_theme13(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_14))){
            radioHomeDialScreen.flat_theme14(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_15))){
            radioHomeDialScreen.flat_theme15(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_16))){
            radioHomeDialScreen.flat_theme16(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_17))){
            radioHomeDialScreen.flat_theme17(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_18))){
            radioHomeDialScreen.flat_theme18(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_19))){
            radioHomeDialScreen.flat_theme19(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.flat_theme_20))){
            radioHomeDialScreen.flat_theme20(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_1))){
            radioHomeDialScreen.grad_theme1(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_2))){
            radioHomeDialScreen.grad_theme2(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_3))){
            radioHomeDialScreen.grad_theme3(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_4))){
            radioHomeDialScreen.grad_theme4(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_5))){
            radioHomeDialScreen.grad_theme5(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_6))){
            radioHomeDialScreen.grad_theme6(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_7))){
            radioHomeDialScreen.grad_theme7(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_8))){
            radioHomeDialScreen.grad_theme8(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_9))){
            radioHomeDialScreen.grad_theme9(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_10))){
            radioHomeDialScreen.grad_theme10(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_11))){
            radioHomeDialScreen.grad_theme11(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_12))){
            radioHomeDialScreen.grad_theme12(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_13))){
            radioHomeDialScreen.grad_theme13(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_14))){
            radioHomeDialScreen.grad_theme14(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_15))){
            radioHomeDialScreen.grad_theme15(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_16))){
            radioHomeDialScreen.grad_theme16(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_17))){
            radioHomeDialScreen.grad_theme17(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_18))){
            radioHomeDialScreen.grad_theme18(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_19))){
            radioHomeDialScreen.grad_theme19(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.grad_theme_20))){
            radioHomeDialScreen.grad_theme20(rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto1))){
            radioHomeDialScreen.picto_theme1(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto2))){
            radioHomeDialScreen.picto_theme2(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto3))){
            radioHomeDialScreen.picto_theme3(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto4))){
            radioHomeDialScreen.picto_theme4(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto5))){
            radioHomeDialScreen.picto_theme5(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto6))){
            radioHomeDialScreen.picto_theme6(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto7))){
            radioHomeDialScreen.picto_theme7(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto8))){
            radioHomeDialScreen.picto_theme8(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto9))){
            radioHomeDialScreen.picto_theme9(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto10))){
            radioHomeDialScreen.picto_theme10(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto11))){
            radioHomeDialScreen.picto_theme11(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto12))){
            radioHomeDialScreen.picto_theme12(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto13))){
            radioHomeDialScreen.picto_theme13(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto14))){
            radioHomeDialScreen.picto_theme14(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto15))){
            radioHomeDialScreen.picto_theme15(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto16))){
            radioHomeDialScreen.picto_theme16(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }

        else if (current_theme.equals(String.valueOf(R.drawable.picto17))){
            radioHomeDialScreen.picto_theme17(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto18))){
            radioHomeDialScreen.picto_theme18(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto19))){
            radioHomeDialScreen.picto_theme19(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto20))){
            radioHomeDialScreen.picto_theme20(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto21))){
            radioHomeDialScreen.picto_theme21(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto22))){
            radioHomeDialScreen.picto_theme22(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals(String.valueOf(R.drawable.picto23))){
            radioHomeDialScreen.picto_theme23(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        else if (current_theme.equals("CustomTheme")){
            radioHomeDialScreen.customTheme(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
}
else if (current_theme.equals(String.valueOf(R.drawable.picto24))){
            radioHomeDialScreen.picto_theme24(getActivity(), rootView.findViewById(R.id.rad_dlg_gen_cont));
        }
        
        else {

        }

        initRecyclerView(recyclerView);

    }

    //set adapter for country and genres
    private void initRecyclerView(RecyclerView recyclerView) {

        if (type.equalsIgnoreCase("country") || type.equalsIgnoreCase("genres") || type.equalsIgnoreCase("language")) {
            HomeDialogListAdapter homeListAdapter = new HomeDialogListAdapter(type, radioList, listener);
            recyclerView.setAdapter(homeListAdapter);
        } else {
            CountryGenreRadioListAdapter countryGenreRadioListAdapter = new CountryGenreRadioListAdapter(type, radioList, listener);
            recyclerView.setAdapter(countryGenreRadioListAdapter);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(true);
    }


}
