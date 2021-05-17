package com.example.gym.repository;

import com.example.gym.db.WorkoutCategoryDao;
import com.example.gym.db.WorkoutDao;
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
public final class WorkoutRepository_Factory implements Factory<WorkoutRepository> {
  private final Provider<WorkoutDao> workoutDaoProvider;

  private final Provider<WorkoutCategoryDao> categoryDaoProvider;

  public WorkoutRepository_Factory(Provider<WorkoutDao> workoutDaoProvider,
      Provider<WorkoutCategoryDao> categoryDaoProvider) {
    this.workoutDaoProvider = workoutDaoProvider;
    this.categoryDaoProvider = categoryDaoProvider;
  }

  @Override
  public WorkoutRepository get() {
    return newInstance(workoutDaoProvider.get(), categoryDaoProvider.get());
  }

  public static WorkoutRepository_Factory create(Provider<WorkoutDao> workoutDaoProvider,
      Provider<WorkoutCategoryDao> categoryDaoProvider) {
    return new WorkoutRepository_Factory(workoutDaoProvider, categoryDaoProvider);
  }

  public static WorkoutRepository newInstance(WorkoutDao workoutDao,
      WorkoutCategoryDao categoryDao) {
    return new WorkoutRepository(workoutDao, categoryDao);
  }
}
