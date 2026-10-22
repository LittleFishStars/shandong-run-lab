package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.huachenjie.mall.page.order_detail.OrderDetailVM;
import com.noober.background.view.BLButton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityOrderDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10303a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderDetailActivity.ClickProxy f10304a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderDetailVM f10305a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f10306a;

    @NonNull
    public final BLButton b;

    @NonNull
    public final BLButton c;

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

    public MallActivityOrderDetailBinding(Object obj, View view, int i, BLButton bLButton, BLButton bLButton2, BLButton bLButton3, BLButton bLButton4, BLButton bLButton5, BLButton bLButton6, BLButton bLButton7, BLButton bLButton8, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f10306a = bLButton;
        this.b = bLButton2;
        this.c = bLButton3;
        this.d = bLButton4;
        this.e = bLButton5;
        this.f = bLButton6;
        this.g = bLButton7;
        this.h = bLButton8;
        this.f34822a = recyclerView;
        this.f10303a = layoutToolbarBindingBinding;
    }

    public static MallActivityOrderDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityOrderDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityOrderDetailBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_order_detail);
    }

    @NonNull
    public static MallActivityOrderDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityOrderDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityOrderDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityOrderDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_order_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityOrderDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityOrderDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_order_detail, null, false, obj);
    }

    @Nullable
    public OrderDetailActivity.ClickProxy f() {
        return this.f10304a;
    }

    @Nullable
    public OrderDetailVM g() {
        return this.f10305a;
    }

    public abstract void l(@Nullable OrderDetailActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable OrderDetailVM orderDetailVM);
}
