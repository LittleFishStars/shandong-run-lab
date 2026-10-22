package com.huachenjie.mall.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import com.huachenjie.mall.bean.ExpressCompanyBean;
import com.zj.adlib.hk0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class MallItemExpressCompanyBindingImpl extends MallItemExpressCompanyBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f34991a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f10774a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f10775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10777a;

    public MallItemExpressCompanyBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f10774a, f34991a));
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f10775a;
            this.f10775a = 0L;
        }
        ExpressCompanyBean expressCompanyBean = ((MallItemExpressCompanyBinding) this).f34990a;
        long j2 = j & 3;
        String shipperName = (j2 == 0 || expressCompanyBean == null) ? null : expressCompanyBean.getShipperName();
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.f10777a, shipperName);
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f10775a != 0;
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f10775a = 2L;
        }
        requestRebind();
    }

    @Override // com.huachenjie.mall.databinding.MallItemExpressCompanyBinding
    public void k(@Nullable ExpressCompanyBean expressCompanyBean) {
        ((MallItemExpressCompanyBinding) this).f34990a = expressCompanyBean;
        synchronized (this) {
            this.f10775a |= 1;
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

    public MallItemExpressCompanyBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f10775a = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f10776a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f10777a = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
