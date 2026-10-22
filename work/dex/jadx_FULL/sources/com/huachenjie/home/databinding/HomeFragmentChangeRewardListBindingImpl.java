package com.huachenjie.home.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.home.page.change_reward.ChangeRewardListAdapter;
import com.huachenjie.home.page.change_reward.ChangeRewardListVM;
import com.zj.adlib.xk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class HomeFragmentChangeRewardListBindingImpl extends HomeFragmentChangeRewardListBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34246a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9399a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9401a;

    public HomeFragmentChangeRewardListBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f9399a, f34246a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9400a;
            this.f9400a = 0L;
        }
        ChangeRewardListVM changeRewardListVM = ((HomeFragmentChangeRewardListBinding) this).f34245a;
        long j2 = j & 7;
        ChangeRewardListAdapter value = null;
        if (j2 != 0) {
            MutableLiveData<ChangeRewardListAdapter> mutableLiveDataI = changeRewardListVM != null ? changeRewardListVM.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            CommonBindingAdapter.g(this.f9401a, value, false, false);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9400a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9400a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.home.databinding.HomeFragmentChangeRewardListBinding
    public void k(@Nullable ChangeRewardListVM changeRewardListVM) {
        ((HomeFragmentChangeRewardListBinding) this).f34245a = changeRewardListVM;
        synchronized (this) {
            this.f9400a |= 2;
        }
        notifyPropertyChanged(xk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<ChangeRewardListAdapter> mutableLiveData, int i) {
        if (i != xk0.f45836a) {
            return false;
        }
        synchronized (this) {
            this.f9400a |= 1;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return l((MutableLiveData) obj, i2);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (xk0.p0 != i) {
            return false;
        }
        k((ChangeRewardListVM) obj);
        return true;
    }

    public HomeFragmentChangeRewardListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f9400a = -1L;
        RecyclerView recyclerView = (RecyclerView) objArr[0];
        this.f9401a = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
