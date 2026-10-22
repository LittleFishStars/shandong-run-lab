package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.huachenjie.mall.page.order_detail.OrderDetailVM;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallHeaderOrderDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewStubProxy f10714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderDetailActivity.ClickProxy f10715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderDetailVM f10716a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10717a;

    @NonNull
    public final ViewStubProxy b;

    public MallHeaderOrderDetailBinding(Object obj, View view, int i, BLImageView bLImageView, TextView textView, ViewStubProxy viewStubProxy, ViewStubProxy viewStubProxy2) {
        super(obj, view, i);
        this.f10717a = bLImageView;
        this.f34971a = textView;
        this.f10714a = viewStubProxy;
        this.b = viewStubProxy2;
    }

    public static MallHeaderOrderDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallHeaderOrderDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallHeaderOrderDetailBinding) ViewDataBinding.bind(obj, view, R.layout.mall_header_order_detail);
    }

    @NonNull
    public static MallHeaderOrderDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallHeaderOrderDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallHeaderOrderDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallHeaderOrderDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_header_order_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallHeaderOrderDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallHeaderOrderDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_header_order_detail, null, false, obj);
    }

    @Nullable
    public OrderDetailActivity.ClickProxy f() {
        return this.f10715a;
    }

    @Nullable
    public OrderDetailVM g() {
        return this.f10716a;
    }

    public abstract void l(@Nullable OrderDetailActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable OrderDetailVM orderDetailVM);
}
