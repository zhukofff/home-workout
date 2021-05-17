package com.example.gym.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import error.NonExistentClass;
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
public final class DatabaseModule_ProvideWorkoutDaoFactory implements Factory<NonExistentClass> {
  private final Provider<NonExistentClass> dbProvider;

  public DatabaseModule_ProvideWorkoutDaoFactory(Provider<NonExistentClass> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public NonExistentClass get() {
    return provideWorkoutDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideWorkoutDaoFactory create(
      Provider<NonExistentClass> dbProvider) {
    return new DatabaseModule_ProvideWorkoutDaoFactory(dbProvider);
  }

  public static NonExistentClass provideWorkoutDao(NonExistentClass db) {
    return Preconditions.checkNotNull(DatabaseModule.INSTANCE.provideWorkoutDao(db), "Cannot return null from a non-@Nullable @Provides method");
  }
}
