package com.statusmaker_photoeditor_music.videoplayer.radio.ui.search;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.responses.Radio;
import com.royalplayer.lite.databinding.IndividualRadioSearchBinding;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SettingListViewHolder> {

    private List<Radio> radioLists;
    private SearchListener listener;

    public SearchAdapter(List<Radio> radioArrayList, SearchListener listener) {
        this.radioLists = radioArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SettingListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        IndividualRadioSearchBinding individualRadioBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.individual_radio_search, parent, false);
        return new SettingListViewHolder(individualRadioBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingListViewHolder settingListViewHolder, int position) {
        Radio radio = radioLists.get(position);
        settingListViewHolder.individualRadioBinding.setData(radio);
        settingListViewHolder.individualRadioBinding.getRoot().setOnClickListener(view -> listener.onRadioClicked(radioLists,position));
    }

    @Override
    public int getItemCount() {
        return radioLists.size();
    }

    static class SettingListViewHolder extends RecyclerView.ViewHolder {

        private IndividualRadioSearchBinding individualRadioBinding;

        public SettingListViewHolder(IndividualRadioSearchBinding individualRadioBinding) {
            super(individualRadioBinding.getRoot());
            this.individualRadioBinding = individualRadioBinding;
        }
    }

    //filtered radio list after performing search
    public void setFilteredList(List<Radio>radioList){
        this.radioLists = radioList;
        notifyDataSetChanged();
    }


}
