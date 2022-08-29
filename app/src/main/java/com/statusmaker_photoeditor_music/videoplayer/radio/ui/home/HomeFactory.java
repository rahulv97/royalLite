package com.statusmaker_photoeditor_music.videoplayer.radio.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.statusmaker_photoeditor_music.videoplayer.radio.data.repositories.HomeRepository;
import com.statusmaker_photoeditor_music.videoplayer.radio.data.repositories.PlayerRepository;

class HomeFactory extends ViewModelProvider.NewInstanceFactory {
    private HomeRepository repository;
    private PlayerRepository playerRepository;

    public HomeFactory(HomeRepository repository, PlayerRepository playerRepository) {
        this.repository = repository;
        this.playerRepository = playerRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HomeViewModel(repository,playerRepository);
    }
}
