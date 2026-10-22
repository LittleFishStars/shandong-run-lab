package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.bean.RunTimeAreaData;
import com.huachenjie.run.widget.RunTimeAreaChipView;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunItemRunTimePeriodBindingImpl extends RunItemRunTimePeriodBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35634a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f11976a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f11977a;

    public RunItemRunTimePeriodBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 1, f11976a, f35634a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f11977a = 0L;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f11977a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f11977a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.run.databinding.RunItemRunTimePeriodBinding
    public void k(@Nullable RunTimeAreaData Data) {
        ((RunItemRunTimePeriodBinding) this).f35633a = Data;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.o != variableId) {
            return false;
        }
        k((RunTimeAreaData) variable);
        return true;
    }

    public RunItemRunTimePeriodBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RunTimeAreaChipView) bindings[0]);
        this.f11977a = -1L;
        ((RunItemRunTimePeriodBinding) this).f11975a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
