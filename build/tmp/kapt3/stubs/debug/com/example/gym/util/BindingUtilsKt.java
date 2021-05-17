package com.example.gym.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007\u001a\u001c\u0010\n\u001a\u00020\u0001*\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bH\u0007\u00a8\u0006\f"}, d2 = {"bindImage", "", "Landroid/widget/ImageView;", "code", "", "bindList", "Landroidx/recyclerview/widget/RecyclerView;", "list", "", "Lcom/example/gym/model/WorkoutCategory;", "bindRecyclerView", "Lcom/example/gym/model/Workout;", "app_debug"})
public final class BindingUtilsKt {
    
    /**
     * BindingAdapter используемый для отправки списка тренировок к [WorkoutAdapter]
     */
    @androidx.databinding.BindingAdapter(value = {"listData"})
    public static final void bindRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$bindRecyclerView, @org.jetbrains.annotations.Nullable()
    java.util.List<com.example.gym.model.Workout> list) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"srcImage"})
    public static final void bindImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView $this$bindImage, @org.jetbrains.annotations.Nullable()
    java.lang.String code) {
    }
    
    /**
     * BindingAdapter, используемый для отправки списка категорий к [WorkoutCategoryAdapter]
     */
    @androidx.databinding.BindingAdapter(value = {"categoryListData"})
    public static final void bindList(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView $this$bindList, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.gym.model.WorkoutCategory> list) {
    }
}