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
import com.huachenjie.base.bean.mall.OrderDetailBean;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallViewOrderDetailAddressBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35089a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderDetailBean f11065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderDetailActivity.ClickProxy f11066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11067a;

    @NonNull
    public final TextView b;

    public MallViewOrderDetailAddressBinding(Object obj, View view, int i, BLTextView bLTextView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f11067a = bLTextView;
        this.f35089a = textView;
        this.b = textView2;
    }

    public static MallViewOrderDetailAddressBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallViewOrderDetailAddressBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallViewOrderDetailAddressBinding) ViewDataBinding.bind(obj, view, R.layout.mall_view_order_detail_address);
    }

    @NonNull
    public static MallViewOrderDetailAddressBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallViewOrderDetailAddressBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallViewOrderDetailAddressBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallViewOrderDetailAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_order_detail_address, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallViewOrderDetailAddressBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallViewOrderDetailAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_order_detail_address, null, false, obj);
    }

    @Nullable
    public OrderDetailBean f() {
        return this.f11065a;
    }

    @Nullable
    public OrderDetailActivity.ClickProxy g() {
        return this.f11066a;
    }

    public abstract void l(@Nullable OrderDetailBean orderDetailBean);

    public abstract void m(@Nullable OrderDetailActivity.ClickProxy clickProxy);
}
