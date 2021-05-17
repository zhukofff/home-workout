package com.example.gym.ui;

import com.example.gym.repository.WorkoutRepository;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeViewModel_AssistedFactory_Factory implements Factory<HomeViewModel_AssistedFactory> {
  private final Provider<WorkoutRepository> repositoryProvider;

  public HomeViewModel_AssistedFactory_Factory(Provider<WorkoutRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public HomeViewModel_AssistedFactory get() {
    return newInstance(repositoryProvider);
  }

  public static HomeViewModel_AssistedFactory_Factory create(
      Provider<WorkoutRepository> repositoryProvider) {
    return new HomeViewModel_AssistedFactory_Factory(repositoryProvider);
  }

  public static HomeViewModel_AssistedFactory newInstance(Provider<WorkoutRepository> repository) {
    return new HomeViewModel_AssistedFactory(repository);
  }
}
