package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallActivityCatBindingImpl extends MallActivityCatBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f10154a;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        f10151a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{1}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f34775a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.mall.R.id.container, 2);
    }

    public MallActivityCatBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f10151a, f34775a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10152a;
            this.f10152a = 0L;
        }
        BaseTitleViewModel baseTitleViewModel = ((MallActivityCatBinding) this).f10150a;
        long j2 = j & 7;
        BindingTitleBean value = null;
        if (j2 != 0) {
            MutableLiveData<BindingTitleBean> mutableLiveDataI = baseTitleViewModel != null ? baseTitleViewModel.i() : null;
            updateLiveDataRegistration(0, mutableLiveDataI);
            if (mutableLiveDataI != null) {
                value = mutableLiveDataI.getValue();
            }
        }
        if (j2 != 0) {
            this.f10154a.k(value);
        }
        ViewDataBinding.executeBindingsOn(this.f10154a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f10152a != 0) {
                return true;
            }
            return this.f10154a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10152a = 4L;
        }
        this.f10154a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallActivityCatBinding
    public void k(@Nullable BaseTitleViewModel baseTitleViewModel) {
        ((MallActivityCatBinding) this).f10150a = baseTitleViewModel;
        synchronized (this) {
            this.f10152a |= 2;
        }
        notifyPropertyChanged(hk0.p0);
        super.requestRebind();
    }

    public final boolean l(MutableLiveData<BindingTitleBean> mutableLiveData, int i) {
        if (i != hk0.f42141a) {
            return false;
        }
        synchronized (this) {
            this.f10152a |= 1;
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
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f10154a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.p0 != i) {
            return false;
        }
        k((BaseTitleViewModel) obj);
        return true;
    }

    public MallActivityCatBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (FrameLayout) objArr[2]);
        this.f10152a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) objArr[1];
        this.f10154a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10153a = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
