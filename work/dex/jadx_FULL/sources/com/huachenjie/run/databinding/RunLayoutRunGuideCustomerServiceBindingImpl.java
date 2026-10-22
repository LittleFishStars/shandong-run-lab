package com.huachenjie.run.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.lk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunLayoutRunGuideCustomerServiceBindingImpl extends RunLayoutRunGuideCustomerServiceBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f35691a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f12143a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f12144a;

    public RunLayoutRunGuideCustomerServiceBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 1, f12143a, f35691a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f12144a;
            this.f12144a = 0L;
        }
        View.OnClickListener onClickListener = ((RunLayoutRunGuideCustomerServiceBinding) this).f35690a;
        if ((j & 3) != 0) {
            CommonBindingAdapter.q(((RunLayoutRunGuideCustomerServiceBinding) this).f12142a, onClickListener, null);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12144a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12144a = 2L;
        }
        requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.huachenjie.run.databinding.RunLayoutRunGuideCustomerServiceBinding
    public void setOnClick(@Nullable View.OnClickListener OnClick) {
        ((RunLayoutRunGuideCustomerServiceBinding) this).f35690a = OnClick;
        synchronized (this) {
            this.f12144a |= 1;
        }
        notifyPropertyChanged(lk0.M);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (lk0.M != variableId) {
            return false;
        }
        setOnClick((View.OnClickListener) variable);
        return true;
    }

    public RunLayoutRunGuideCustomerServiceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BLLinearLayout) bindings[0]);
        this.f12144a = -1L;
        ((RunLayoutRunGuideCustomerServiceBinding) this).f12142a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
