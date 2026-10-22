package com.huachenjie.im.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.zj.adlib.yk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ActivitySignalTowerBindingImpl extends ActivitySignalTowerBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34408a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f9654a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f9655a;

    public ActivitySignalTowerBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f9654a, f34408a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9655a;
            this.f9655a = 0L;
        }
        BaseVM baseVM = ((ActivitySignalTowerBinding) this).f9653a;
        long j2 = j & 7;
        int iSafeUnbox = 0;
        if (j2 != 0) {
            MutableLiveData<Integer> mutableLiveData = baseVM != null ? baseVM.f33644a : null;
            updateLiveDataRegistration(0, mutableLiveData);
            iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveData != null ? mutableLiveData.getValue() : null);
        }
        int i = iSafeUnbox;
        if (j2 != 0) {
            CommonBindingAdapter.O(((ActivitySignalTowerBinding) this).f34407a, 0, i, 0, 0, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9655a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9655a = 4L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.im.databinding.ActivitySignalTowerBinding
    public void k(@Nullable BaseVM baseVM) {
        ((ActivitySignalTowerBinding) this).f9653a = baseVM;
        synchronized (this) {
            this.f9655a |= 2;
        }
        notifyPropertyChanged(yk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i != yk0.f46050a) {
            return false;
        }
        synchronized (this) {
            this.f9655a |= 1;
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
        if (yk0.p0 != i) {
            return false;
        }
        k((BaseVM) obj);
        return true;
    }

    public ActivitySignalTowerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[0]);
        this.f9655a = -1L;
        ((ActivitySignalTowerBinding) this).f34407a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
