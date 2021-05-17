package com.example.gym.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t0\bJ\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/gym/repository/WorkoutRepository;", "", "workoutDao", "Lcom/example/gym/db/WorkoutDao;", "categoryDao", "Lcom/example/gym/db/WorkoutCategoryDao;", "(Lcom/example/gym/db/WorkoutDao;Lcom/example/gym/db/WorkoutCategoryDao;)V", "getCategories", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/gym/model/WorkoutCategory;", "getWorkout", "Landroidx/lifecycle/LiveData;", "Lcom/example/gym/model/Workout;", "id", "", "getWorkouts", "update", "", "workout", "(Lcom/example/gym/model/Workout;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class WorkoutRepository {
    private final com.example.gym.db.WorkoutDao workoutDao = null;
    private final com.example.gym.db.WorkoutCategoryDao categoryDao = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.gym.model.Workout>> getWorkouts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.gym.model.Workout> getWorkout(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.example.gym.model.Workout workout, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.gym.model.WorkoutCategory>> getCategories() {
        return null;
    }
    
    @javax.inject.Inject()
    public WorkoutRepository(@org.jetbrains.annotations.NotNull()
    com.example.gym.db.WorkoutDao workoutDao, @org.jetbrains.annotations.NotNull()
    com.example.gym.db.WorkoutCategoryDao categoryDao) {
        super();
    }
}