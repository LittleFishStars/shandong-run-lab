package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.mall.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemShippingAddressModifyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10920a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShippingAddressBean f10921a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public MallItemShippingAddressModifyBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f35038a = linearLayout;
        this.f10920a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    public static MallItemShippingAddressModifyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemShippingAddressModifyBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemShippingAddressModifyBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_shipping_address_modify);
    }

    @NonNull
    public static MallItemShippingAddressModifyBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemShippingAddressModifyBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemShippingAddressModifyBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemShippingAddressModifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_shipping_address_modify, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemShippingAddressModifyBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemShippingAddressModifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_shipping_address_modify, null, false, obj);
    }

    @Nullable
    public ShippingAddressBean f() {
        return this.f10921a;
    }

    public abstract void k(@Nullable ShippingAddressBean shippingAddressBean);
}
