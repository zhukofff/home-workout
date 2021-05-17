package com.example.gym.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ApplicationComponent.class})
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007\u00a2\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/example/gym/di/DatabaseModule;", "", "()V", "provideDataStore", "error/NonExistentClass", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Lerror/NonExistentClass;", "provideDatabase", "app", "Landroid/app/Application;", "(Landroid/app/Application;)Lerror/NonExistentClass;", "provideWorkoutCategoryDao", "db", "(Lerror/NonExistentClass;)Lerror/NonExistentClass;", "provideWorkoutDao", "app_debug"})
@dagger.Module()
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.gym.di.DatabaseModule INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final error.NonExistentClass provideDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final error.NonExistentClass provideWorkoutDao(@org.jetbrains.annotations.NotNull()
    error.NonExistentClass db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final error.NonExistentClass provideWorkoutCategoryDao(@org.jetbrains.annotations.NotNull()
    error.NonExistentClass db) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final error.NonExistentClass provideDataStore(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    private DatabaseModule() {
        super();
    }
}