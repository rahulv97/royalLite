package com.statusmaker_photoeditor_music.videoplayer.radio.ui.settings;



import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.statusmaker_photoeditor_music.videoplayer.radio.data.repositories.SettingsRepository;

class SettingsFactory extends ViewModelProvider.NewInstanceFactory {
    private SettingsRepository repository;

    public SettingsFactory(SettingsRepository repository) {
        this.repository = repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SettingsViewModel(repository);
    }
}
