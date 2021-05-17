package com.example.gym.db;

import java.lang.System;

@androidx.room.Database(entities = {com.example.gym.model.Workout.class, com.example.gym.model.WorkoutCategory.class}, version = 1)
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/example/gym/db/GymDatabase;", "Landroidx/room/RoomDatabase;", "()V", "categoryDao", "Lcom/example/gym/db/WorkoutCategoryDao;", "getCategoryDao", "()Lcom/example/gym/db/WorkoutCategoryDao;", "workoutDao", "Lcom/example/gym/db/WorkoutDao;", "getWorkoutDao", "()Lcom/example/gym/db/WorkoutDao;", "app_debug"})
public abstract class GymDatabase extends androidx.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.gym.db.WorkoutDao getWorkoutDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.gym.db.WorkoutCategoryDao getCategoryDao();
    
    public GymDatabase() {
        super();
    }
}