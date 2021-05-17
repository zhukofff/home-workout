package com.example.gym;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.example.gym.databinding.ActivityMainBindingImpl;
import com.example.gym.databinding.CategoryViewItemBindingImpl;
import com.example.gym.databinding.ContentMainBindingImpl;
import com.example.gym.databinding.FragmentHomeBindingImpl;
import com.example.gym.databinding.WorkoutGridItemBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;

@Generated("Android Data Binding")
public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYMAIN = 1;

  private static final int LAYOUT_CATEGORYVIEWITEM = 2;

  private static final int LAYOUT_CONTENTMAIN = 3;

  private static final int LAYOUT_FRAGMENTHOME = 4;

  private static final int LAYOUT_WORKOUTGRIDITEM = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.gym.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.gym.R.layout.category_view_item, LAYOUT_CATEGORYVIEWITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.gym.R.layout.content_main, LAYOUT_CONTENTMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.gym.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.example.gym.R.layout.workout_grid_item, LAYOUT_WORKOUTGRIDITEM);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_CATEGORYVIEWITEM: {
          if ("layout/category_view_item_0".equals(tag)) {
            return new CategoryViewItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for category_view_item is invalid. Received: " + tag);
        }
        case  LAYOUT_CONTENTMAIN: {
          if ("layout/content_main_0".equals(tag)) {
            return new ContentMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for content_main is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_WORKOUTGRIDITEM: {
          if ("layout/workout_grid_item_0".equals(tag)) {
            return new WorkoutGridItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for workout_grid_item is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(5);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "category");
      sKeys.put(2, "clickListener");
      sKeys.put(3, "viewModel");
      sKeys.put(4, "workout");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/activity_main_0", com.example.gym.R.layout.activity_main);
      sKeys.put("layout/category_view_item_0", com.example.gym.R.layout.category_view_item);
      sKeys.put("layout/content_main_0", com.example.gym.R.layout.content_main);
      sKeys.put("layout/fragment_home_0", com.example.gym.R.layout.fragment_home);
      sKeys.put("layout/workout_grid_item_0", com.example.gym.R.layout.workout_grid_item);
    }
  }
}
