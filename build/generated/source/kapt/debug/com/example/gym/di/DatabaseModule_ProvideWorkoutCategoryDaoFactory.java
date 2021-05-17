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
public final class DatabaseModule_ProvideWorkoutCategoryDaoFactory implements Factory<NonExistentClass> {
  private final Provider<NonExistentClass> dbProvider;

  public DatabaseModule_ProvideWorkoutCategoryDaoFactory(Provider<NonExistentClass> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public NonExistentClass get() {
    return provideWorkoutCategoryDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideWorkoutCategoryDaoFactory create(
      Provider<NonExistentClass> dbProvider) {
    return new DatabaseModule_ProvideWorkoutCategoryDaoFactory(dbProvider);
  }

  public static NonExistentClass provideWorkoutCategoryDao(NonExistentClass db) {
    return Preconditions.checkNotNull(DatabaseModule.INSTANCE.provideWorkoutCategoryDao(db), "Cannot return null from a non-@Nullable @Provides method");
  }
}
