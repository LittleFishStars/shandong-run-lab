package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.page.activities_run.ActivityRunListVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunActivityActivityRunListBindingImpl extends RunActivityActivityRunListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f11418a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        f11415a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{1}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f35445a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.run.R.id.tabLayout, 2);
        sparseIntArray.put(com.huachenjie.run.R.id.viewPager, 3);
    }

    public RunActivityActivityRunListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, f11415a, f35445a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11416a;
            this.f11416a = 0L;
        }
        ActivityRunListVM activityRunListVM = ((RunActivityActivityRunListBinding) this).f11414a;
        long j2 = j & 7;
        BindingTitleBean value = null;
        if (j2 != 0) {
            MutableLiveData<BindingTitleBean> mutableLiveDataI = activityRunListVM != null ? activityRunListVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            this.f11418a.k(value);
        }
        ViewDataBinding.executeBindingsOn(this.f11418a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f11416a != 0) {
                return true;
            }
            return this.f11418a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11416a = 4L;
        }
        this.f11418a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunActivityActivityRunListBinding
    public void k(@Nullable ActivityRunListVM Vm) {
        ((RunActivityActivityRunListBinding) this).f11414a = Vm;
        synchronized (this) {
            this.f11416a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11416a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return l((MutableLiveData) object, fieldId);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f11418a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((ActivityRunListVM) variable);
        return true;
    }

    public RunActivityActivityRunListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (SlidingTabLayout2) bindings[2], (ViewPager2) bindings[3]);
        this.f11416a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) bindings[1];
        this.f11418a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f11417a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
