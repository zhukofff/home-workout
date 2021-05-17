package com.example.gym.databinding;
import com.example.gym.R;
import com.example.gym.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class FragmentHomeBindingImpl extends FragmentHomeBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.app_bar_home, 2);
        sViewsWithIds.put(R.id.toolbar_home, 3);
        sViewsWithIds.put(R.id.scrollable_layout, 4);
        sViewsWithIds.put(R.id.subtitle_recommended, 5);
        sViewsWithIds.put(R.id.recommended_list, 6);
        sViewsWithIds.put(R.id.subtitle_categories, 7);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.appbar.AppBarLayout) bindings[2]
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            , (androidx.core.widget.NestedScrollView) bindings[4]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[5]
            , (androidx.appcompat.widget.Toolbar) bindings[3]
            );
        this.categoryList.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.viewModel == variableId) {
            setViewModel((com.example.gym.ui.HomeViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.example.gym.ui.HomeViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelCategoriesUiModel((androidx.lifecycle.LiveData<com.example.gym.ui.HomeViewModel.CategoryUiModel>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelCategoriesUiModel(androidx.lifecycle.LiveData<com.example.gym.ui.HomeViewModel.CategoryUiModel> ViewModelCategoriesUiModel, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        androidx.lifecycle.LiveData<com.example.gym.ui.HomeViewModel.CategoryUiModel> viewModelCategoriesUiModel = null;
        java.util.List<com.example.gym.model.WorkoutCategory> viewModelCategoriesUiModelCategories = null;
        com.example.gym.ui.HomeViewModel.CategoryUiModel viewModelCategoriesUiModelGetValue = null;
        com.example.gym.ui.HomeViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x7L) != 0) {



                if (viewModel != null) {
                    // read viewModel.categoriesUiModel
                    viewModelCategoriesUiModel = viewModel.getCategoriesUiModel();
                }
                updateLiveDataRegistration(0, viewModelCategoriesUiModel);


                if (viewModelCategoriesUiModel != null) {
                    // read viewModel.categoriesUiModel.getValue()
                    viewModelCategoriesUiModelGetValue = viewModelCategoriesUiModel.getValue();
                }


                if (viewModelCategoriesUiModelGetValue != null) {
                    // read viewModel.categoriesUiModel.getValue().categories
                    viewModelCategoriesUiModelCategories = viewModelCategoriesUiModelGetValue.getCategories();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            com.example.gym.util.BindingUtilsKt.bindList(this.categoryList, viewModelCategoriesUiModelCategories);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.categoriesUiModel
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}