package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallViewOrderDetailDeliverBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderDetailBean f11074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderDetailActivity.ClickProxy f11075a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11076b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public MallViewOrderDetailDeliverBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2) {
        super(obj, view, i);
        this.f11072a = imageView;
        this.b = imageView2;
        this.f11073a = textView;
        this.f11076b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.f35092a = view2;
    }

    public static MallViewOrderDetailDeliverBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallViewOrderDetailDeliverBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallViewOrderDetailDeliverBinding) ViewDataBinding.bind(obj, view, R.layout.mall_view_order_detail_deliver);
    }

    @NonNull
    public static MallViewOrderDetailDeliverBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallViewOrderDetailDeliverBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallViewOrderDetailDeliverBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallViewOrderDetailDeliverBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_order_detail_deliver, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallViewOrderDetailDeliverBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallViewOrderDetailDeliverBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_order_detail_deliver, null, false, obj);
    }

    @Nullable
    public OrderDetailBean f() {
        return this.f11074a;
    }

    @Nullable
    public OrderDetailActivity.ClickProxy g() {
        return this.f11075a;
    }

    public abstract void l(@Nullable OrderDetailBean orderDetailBean);

    public abstract void m(@Nullable OrderDetailActivity.ClickProxy clickProxy);
}
