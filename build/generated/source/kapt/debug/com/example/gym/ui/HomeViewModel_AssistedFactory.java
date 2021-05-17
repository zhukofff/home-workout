package com.example.gym.ui;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelAssistedFactory;
import androidx.lifecycle.SavedStateHandle;
import com.example.gym.repository.WorkoutRepository;
import java.lang.Override;
import javax.annotation.Generated;
import javax.inject.Inject;
import javax.inject.Provider;

@Generated("androidx.hilt.AndroidXHiltProcessor")
public final class HomeViewModel_AssistedFactory implements ViewModelAssistedFactory<HomeViewModel> {
  private final Provider<WorkoutRepository> repository;

  @Inject
  HomeViewModel_AssistedFactory(Provider<WorkoutRepository> repository) {
    this.repository = repository;
  }

  @Override
  @NonNull
  public HomeViewModel create(SavedStateHandle arg0) {
    return new HomeViewModel(repository.get());
  }
}
