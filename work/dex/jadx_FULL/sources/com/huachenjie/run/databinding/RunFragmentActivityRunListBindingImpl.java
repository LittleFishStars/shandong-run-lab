package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.run.page.activities_run.ActivityRunListAdapter;
import com.huachenjie.run.page.activities_run.ActivityRunListFragmentVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunFragmentActivityRunListBindingImpl extends RunFragmentActivityRunListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35568a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11802a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11803a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f11804a;

    public RunFragmentActivityRunListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 1, f11802a, f35568a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f11803a;
            this.f11803a = 0L;
        }
        ActivityRunListFragmentVM activityRunListFragmentVM = ((RunFragmentActivityRunListBinding) this).f35567a;
        long j2 = j & 7;
        ActivityRunListAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<ActivityRunListAdapter> mutableLiveDataI = activityRunListFragmentVM != null ? activityRunListFragmentVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f11804a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11803a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11803a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunFragmentActivityRunListBinding
    public void k(@Nullable ActivityRunListFragmentVM Vm) {
        ((RunFragmentActivityRunListBinding) this).f35567a = Vm;
        synchronized (this) {
            this.f11803a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<ActivityRunListAdapter> VmAdapter, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f11803a |= 1;
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
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.p0 != variableId) {
            return false;
        }
        k((ActivityRunListFragmentVM) variable);
        return true;
    }

    public RunFragmentActivityRunListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1);
        this.f11803a = -1L;
        RecyclerView recyclerView = (RecyclerView) bindings[0];
        this.f11804a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
