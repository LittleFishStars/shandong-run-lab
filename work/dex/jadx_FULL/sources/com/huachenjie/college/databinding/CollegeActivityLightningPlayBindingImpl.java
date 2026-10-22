package com.huachenjie.college.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.college.R;
import com.huachenjie.common.base.data_binding.BaseTitleVM;
import com.zj.adlib.uk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CollegeActivityLightningPlayBindingImpl extends CollegeActivityLightningPlayBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f33560a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f8367a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f8368a;

    @NonNull
    public final FrameLayout b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f33560a = sparseIntArray;
        sparseIntArray.put(R.id.flContainer, 1);
    }

    public CollegeActivityLightningPlayBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f8367a, f33560a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f8368a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8368a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8368a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.college.databinding.CollegeActivityLightningPlayBinding
    public void k(@Nullable BaseTitleVM baseTitleVM) {
        ((CollegeActivityLightningPlayBinding) this).f8366a = baseTitleVM;
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

    public CollegeActivityLightningPlayBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[1]);
        this.f8368a = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.b = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
