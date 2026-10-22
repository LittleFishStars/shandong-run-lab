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
public abstract class MallItemRewardShippingAddressBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10890a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10891a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10892a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShippingAddressBean f10893a;

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

    public MallItemRewardShippingAddressBinding(Object obj, View view, int i, View view2, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.f35029a = view2;
        this.f10890a = imageView;
        this.f10891a = linearLayout;
        this.f10892a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.g = textView7;
    }

    public static MallItemRewardShippingAddressBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemRewardShippingAddressBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemRewardShippingAddressBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_reward_shipping_address);
    }

    @NonNull
    public static MallItemRewardShippingAddressBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemRewardShippingAddressBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemRewardShippingAddressBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemRewardShippingAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_reward_shipping_address, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemRewardShippingAddressBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemRewardShippingAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_reward_shipping_address, null, false, obj);
    }

    @Nullable
    public ShippingAddressBean f() {
        return this.f10893a;
    }

    public abstract void k(@Nullable ShippingAddressBean shippingAddressBean);
}
