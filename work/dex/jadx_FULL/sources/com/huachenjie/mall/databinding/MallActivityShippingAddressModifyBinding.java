package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.address.modify.ShippingAddressModifyActivity;
import com.huachenjie.mall.page.address.modify.ShippingAddressModifyVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityShippingAddressModifyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f34872a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShippingAddressModifyActivity.a f10436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShippingAddressModifyVM f10437a;

    public MallActivityShippingAddressModifyBinding(Object obj, View view, int i, FrameLayout frameLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f34872a = frameLayout;
        this.f10435a = layoutToolbarBindingBinding;
    }

    public static MallActivityShippingAddressModifyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityShippingAddressModifyBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityShippingAddressModifyBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_shipping_address_modify);
    }

    @NonNull
    public static MallActivityShippingAddressModifyBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityShippingAddressModifyBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityShippingAddressModifyBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityShippingAddressModifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_shipping_address_modify, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityShippingAddressModifyBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityShippingAddressModifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_shipping_address_modify, null, false, obj);
    }

    @Nullable
    public ShippingAddressModifyActivity.a f() {
        return this.f10436a;
    }

    @Nullable
    public ShippingAddressModifyVM g() {
        return this.f10437a;
    }

    public abstract void l(@Nullable ShippingAddressModifyActivity.a aVar);

    public abstract void m(@Nullable ShippingAddressModifyVM shippingAddressModifyVM);
}
