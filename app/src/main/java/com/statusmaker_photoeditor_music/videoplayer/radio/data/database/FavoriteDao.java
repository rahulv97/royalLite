package com.statusmaker_photoeditor_music.videoplayer.radio.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.statusmaker_photoeditor_music.videoplayer.radio.data.network.responses.Radio;

import java.util.List;

@Dao
public interface FavoriteDao {

    @Insert
    void insert(Radio favorite);

    @Query("DELETE FROM favorite_table WHERE radio_id = :radioId")
    void delete(Integer radioId);

    @Query("SELECT * FROM favorite_table ")
    LiveData<List<Radio>> getFavoriteList();



}
