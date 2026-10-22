package com.huachenjie.works.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.zj.adlib.qk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksItemWorkListPictureBindingImpl extends WorksItemWorkListPictureBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f37078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f14717a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f14718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final WorksItemWorkDetailListBinding f14719a;

    @NonNull
    public final FrameLayout b;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f14717a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"works_item_work_detail_list"}, new int[]{1}, new int[]{R.layout.works_item_work_detail_list});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f37078a = sparseIntArray;
        sparseIntArray.put(R.id.image_container, 2);
    }

    public WorksItemWorkListPictureBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, f14717a, f37078a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f14718a;
            this.f14718a = 0L;
        }
        WorkDetailBean workDetailBean = ((WorksItemWorkListPictureBinding) this).f14716a;
        if ((j & 3) != 0) {
            this.f14719a.k(workDetailBean);
        }
        ViewDataBinding.executeBindingsOn(this.f14719a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f14718a != 0) {
                return true;
            }
            return this.f14719a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14718a = 2L;
        }
        this.f14719a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksItemWorkListPictureBinding
    public void k(@Nullable WorkDetailBean Vm) {
        ((WorksItemWorkListPictureBinding) this).f14716a = Vm;
        synchronized (this) {
            this.f14718a |= 1;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f14719a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 != variableId) {
            return false;
        }
        k((WorkDetailBean) variable);
        return true;
    }

    public WorksItemWorkListPictureBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (FrameLayout) bindings[2]);
        this.f14718a = -1L;
        WorksItemWorkDetailListBinding worksItemWorkDetailListBinding = (WorksItemWorkDetailListBinding) bindings[1];
        this.f14719a = worksItemWorkDetailListBinding;
        setContainedBinding(worksItemWorkDetailListBinding);
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.b = frameLayout;
        frameLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
