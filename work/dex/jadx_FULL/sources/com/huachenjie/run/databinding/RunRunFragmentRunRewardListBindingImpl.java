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
import com.huachenjie.run.page.run_reward.RunRewardListAdapter;
import com.huachenjie.run.page.run_reward.RunRewardListVM;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunRunFragmentRunRewardListBindingImpl extends RunRunFragmentRunRewardListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35744a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12301a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12302a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12303a;

    public RunRunFragmentRunRewardListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 1, f12301a, f35744a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f12302a;
            this.f12302a = 0L;
        }
        RunRewardListVM runRewardListVM = ((RunRunFragmentRunRewardListBinding) this).f35743a;
        long j2 = j & 7;
        RunRewardListAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<RunRewardListAdapter> mutableLiveDataK = runRewardListVM != null ? runRewardListVM.k() : null;
            updateLiveDataRegistration(0, mutableLiveDataK);
            if (mutableLiveDataK != null) {
                value = mutableLiveDataK.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f12303a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12302a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12302a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunRunFragmentRunRewardListBinding
    public void k(@Nullable RunRewardListVM Vm) {
        ((RunRunFragmentRunRewardListBinding) this).f35743a = Vm;
        synchronized (this) {
            this.f12302a |= 2;
        }
        notifyPropertyChanged(lk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<RunRewardListAdapter> VmAdapter, int fieldId) {
        if (fieldId != lk0.f43086a) {
            return false;
        }
        synchronized (this) {
            this.f12302a |= 1;
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
        k((RunRewardListVM) variable);
        return true;
    }

    public RunRunFragmentRunRewardListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1);
        this.f12302a = -1L;
        RecyclerView recyclerView = (RecyclerView) bindings[0];
        this.f12303a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
