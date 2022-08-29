package com.statusmaker_photoeditor_music.videoplayer.radio.data.repositories;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.MyApi;
import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.SafeApiRequest;
import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.SetupRetrofit;
import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.responses.RadioList;
import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.responses.SearchCategories;

import java.util.List;

public class SearchRadioRepository extends SafeApiRequest {

    MyApi myApi;
    Context context;
    public SearchRadioRepository(Context context) {
        SetupRetrofit setupRetrofit = new SetupRetrofit(context);
        this.myApi = SetupRetrofit.createService(MyApi.class);
    }

    public MutableLiveData<RadioList> discoverAllRadio() {
        return callRetrofitObjectResponse(context, myApi.getRadioListObject("radio-list"));
    }

    public MutableLiveData<List<SearchCategories>> getAllSearchFilterCategory() {
        return callRetrofit(context, myApi.getAllSearchFilterCategory("category-list"));
    }
}


