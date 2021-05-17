package com.example.gym.di;

import android.app.Application;
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
public final class DatabaseModule_ProvideDatabaseFactory implements Factory<NonExistentClass> {
  private final Provider<Application> appProvider;

  public DatabaseModule_ProvideDatabaseFactory(Provider<Application> appProvider) {
    this.appProvider = appProvider;
  }

  @Override
  public NonExistentClass get() {
    return provideDatabase(appProvider.get());
  }

  public static DatabaseModule_ProvideDatabaseFactory create(Provider<Application> appProvider) {
    return new DatabaseModule_ProvideDatabaseFactory(appProvider);
  }

  public static NonExistentClass provideDatabase(Application app) {
    return Preconditions.checkNotNull(DatabaseModule.INSTANCE.provideDatabase(app), "Cannot return null from a non-@Nullable @Provides method");
  }
}
