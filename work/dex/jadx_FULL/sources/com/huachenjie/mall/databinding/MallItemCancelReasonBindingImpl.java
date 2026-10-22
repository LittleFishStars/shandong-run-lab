package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.CompoundButtonBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.mall.bean.OrderReasonBean;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemCancelReasonBindingImpl extends MallItemCancelReasonBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34979a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10730a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RadioButton f10732a;

    public MallItemCancelReasonBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f10730a, f34979a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        boolean zIsChecked;
        String desc;
        synchronized (this) {
            j = this.f10731a;
            this.f10731a = 0L;
        }
        OrderReasonBean orderReasonBean = ((MallItemCancelReasonBinding) this).f34978a;
        long j2 = j & 3;
        if (j2 == 0 || orderReasonBean == null) {
            zIsChecked = false;
            desc = null;
        } else {
            zIsChecked = orderReasonBean.isChecked();
            desc = orderReasonBean.getDesc();
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f10732a, desc);
            CompoundButtonBindingAdapter.setChecked(this.f10732a, zIsChecked);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10731a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10731a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemCancelReasonBinding
    public void k(@Nullable OrderReasonBean orderReasonBean) {
        ((MallItemCancelReasonBinding) this).f34978a = orderReasonBean;
        synchronized (this) {
            this.f10731a |= 1;
        }
        notifyPropertyChanged(hk0.g);
        super.requestRebind();
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (hk0.g != i) {
            return false;
        }
        k((OrderReasonBean) obj);
        return true;
    }

    public MallItemCancelReasonBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10731a = -1L;
        RadioButton radioButton = (RadioButton) objArr[0];
        this.f10732a = radioButton;
        radioButton.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
