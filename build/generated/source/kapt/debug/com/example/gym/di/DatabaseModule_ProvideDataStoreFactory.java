package com.example.gym.di;

import android.content.Context;
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
public final class DatabaseModule_ProvideDataStoreFactory implements Factory<NonExistentClass> {
  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideDataStoreFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NonExistentClass get() {
    return provideDataStore(contextProvider.get());
  }

  public static DatabaseModule_ProvideDataStoreFactory create(Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideDataStoreFactory(contextProvider);
  }

  public static NonExistentClass provideDataStore(Context context) {
    return Preconditions.checkNotNull(DatabaseModule.INSTANCE.provideDataStore(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
