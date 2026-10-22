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
import com.huachenjie.base.bean.MyOrderBean;
import com.huachenjie.mall.R;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemMyOrderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35015a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyOrderBean f10843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f10844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f10845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10846a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLButton f10847b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final BLButton f10848c;

    @NonNull
    public final BLButton d;

    @NonNull
    public final BLButton e;

    @NonNull
    public final BLButton f;

    @NonNull
    public final BLButton g;

    @NonNull
    public final BLButton h;

    public MallItemMyOrderBinding(Object obj, View view, int i, BLButton bLButton, BLButton bLButton2, BLButton bLButton3, BLButton bLButton4, BLButton bLButton5, BLButton bLButton6, BLButton bLButton7, BLButton bLButton8, BLImageView bLImageView, LinearLayout linearLayout, PriceView priceView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f10845a = bLButton;
        this.f10847b = bLButton2;
        this.f10848c = bLButton3;
        this.d = bLButton4;
        this.e = bLButton5;
        this.f = bLButton6;
        this.g = bLButton7;
        this.h = bLButton8;
        this.f10846a = bLImageView;
        this.f35015a = linearLayout;
        this.f10844a = priceView;
        this.f10842a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static MallItemMyOrderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemMyOrderBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemMyOrderBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_my_order);
    }

    @NonNull
    public static MallItemMyOrderBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemMyOrderBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemMyOrderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemMyOrderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_my_order, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemMyOrderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemMyOrderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_my_order, null, false, obj);
    }

    @Nullable
    public MyOrderBean f() {
        return this.f10843a;
    }

    public abstract void k(@Nullable MyOrderBean myOrderBean);
}
