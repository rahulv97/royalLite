package com.statusmaker_photoeditor_music.videoplayer.radio.ui.search;



import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.statusmaker_photoeditor_music.videoplayer.radio.data.repositories.SearchRadioRepository;

class SearchFactory extends ViewModelProvider.NewInstanceFactory {
    private SearchRadioRepository repository;

    public SearchFactory(SearchRadioRepository repository) {
        this.repository = repository;
    }
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new SearchViewModel(repository);
    }
}
