package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.mall.bean.ExpressCompanyBean;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemExpressCompanyNameBindingImpl extends MallItemExpressCompanyNameBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34993a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10778a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10779a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10780a;

    public MallItemExpressCompanyNameBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 1, f10778a, f34993a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10779a;
            this.f10779a = 0L;
        }
        ExpressCompanyBean expressCompanyBean = ((MallItemExpressCompanyNameBinding) this).f34992a;
        long j2 = j & 3;
        String shipperName = (j2 == 0 || expressCompanyBean == null) ? null : expressCompanyBean.getShipperName();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f10780a, shipperName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10779a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10779a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemExpressCompanyNameBinding
    public void k(@Nullable ExpressCompanyBean expressCompanyBean) {
        ((MallItemExpressCompanyNameBinding) this).f34992a = expressCompanyBean;
        synchronized (this) {
            this.f10779a |= 1;
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
        k((ExpressCompanyBean) obj);
        return true;
    }

    public MallItemExpressCompanyNameBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10779a = -1L;
        TextView textView = (TextView) objArr[0];
        this.f10780a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
