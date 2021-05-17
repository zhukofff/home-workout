package com.example.gym.databinding;
import com.example.gym.R;
import com.example.gym.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class CategoryViewItemBindingImpl extends CategoryViewItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CategoryViewItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private CategoryViewItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.TextView) bindings[4]
            , (android.widget.ImageView) bindings[1]
            , (com.google.android.material.card.MaterialCardView) bindings[0]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            );
        this.categoryDescription.setTag(null);
        this.categoryImage.setTag(null);
        this.categoryItemContainer.setTag(null);
        this.categoryOverview.setTag(null);
        this.categoryTitle.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.category == variableId) {
            setCategory((com.example.gym.model.WorkoutCategory) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCategory(@Nullable com.example.gym.model.WorkoutCategory Category) {
        this.mCategory = Category;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.category);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        com.example.gym.model.WorkoutCategory category = mCategory;
        java.lang.String categoryId = null;
        java.lang.String CategoryOverview1 = null;
        java.lang.String CategoryTitle1 = null;
        java.lang.String CategoryDescription1 = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (category != null) {
                    // read category.id
                    categoryId = category.getId();
                    // read category.overview
                    CategoryOverview1 = category.getOverview();
                    // read category.title
                    CategoryTitle1 = category.getTitle();
                    // read category.description
                    CategoryDescription1 = category.getDescription();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.categoryDescription, CategoryDescription1);
            com.example.gym.util.BindingUtilsKt.bindImage(this.categoryImage, categoryId);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.categoryOverview, CategoryOverview1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.categoryTitle, CategoryTitle1);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): category
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}