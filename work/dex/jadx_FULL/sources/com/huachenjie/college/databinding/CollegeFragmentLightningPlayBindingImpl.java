package com.huachenjie.college.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.dsbridge_webview.WebContentView;
import com.huachenjie.common.base.data_binding.BaseTitleVM;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeFragmentLightningPlayBindingImpl extends CollegeFragmentLightningPlayBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33571a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8393a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8394a;

    public CollegeFragmentLightningPlayBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f8393a, f33571a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f8394a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8394a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8394a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeFragmentLightningPlayBinding
    public void k(@Nullable BaseTitleVM baseTitleVM) {
        ((CollegeFragmentLightningPlayBinding) this).f8392a = baseTitleVM;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (uk0.p0 != i) {
            return false;
        }
        k((BaseTitleVM) obj);
        return true;
    }

    public CollegeFragmentLightningPlayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (WebContentView) objArr[0]);
        this.f8394a = -1L;
        ((CollegeFragmentLightningPlayBinding) this).f33570a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
