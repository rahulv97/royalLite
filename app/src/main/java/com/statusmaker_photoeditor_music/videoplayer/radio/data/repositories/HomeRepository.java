package com.statusmaker_photoeditor_music.videoplayer.radio.data.repositories;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.MyApi;
import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.SafeApiRequest;
import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.SetupRetrofit;
import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.responses.RadioList;

import java.util.List;

public class HomeRepository extends SafeApiRequest {

    MyApi myApi;
    Context context;
    public HomeRepository(Context context) {
        this.context=context;
        SetupRetrofit setupRetrofit = new SetupRetrofit(context);
        this.myApi = SetupRetrofit.createService(MyApi.class);
    }

    public MutableLiveData<List<RadioList>> getHomeItems() {
        return (MutableLiveData<List<RadioList>>) callRetrofit(context, myApi.getRadioList("new-launcher"));
    }

    public MutableLiveData<RadioList> getHomeRadioListItems(String type, String id) {
        return (MutableLiveData<RadioList>) callRetrofitObjectResponse(context, myApi.getHomeRadioList("radio-list", type, id));
    }

}


