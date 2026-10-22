package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
public abstract class MallItemShippingAddressBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10913a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShippingAddressBean f10915a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    public MallItemShippingAddressBinding(Object obj, View view, int i, View view2, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.f35036a = view2;
        this.f10912a = imageView;
        this.f10913a = linearLayout;
        this.f10914a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.g = textView7;
    }

    public static MallItemShippingAddressBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemShippingAddressBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemShippingAddressBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_shipping_address);
    }

    @NonNull
    public static MallItemShippingAddressBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemShippingAddressBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemShippingAddressBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemShippingAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_shipping_address, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemShippingAddressBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemShippingAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_shipping_address, null, false, obj);
    }

    @Nullable
    public ShippingAddressBean f() {
        return this.f10915a;
    }

    public abstract void k(@Nullable ShippingAddressBean shippingAddressBean);
}
