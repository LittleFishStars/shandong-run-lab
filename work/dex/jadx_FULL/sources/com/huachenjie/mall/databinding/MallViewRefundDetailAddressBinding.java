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
import com.huachenjie.base.bean.mall.ShippingAddressBean;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.refund_detail.RefundDetailActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallViewRefundDetailAddressBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35099a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShippingAddressBean f11087a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RefundDetailActivity.ClickProxy f11088a;

    public MallViewRefundDetailAddressBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f35099a = textView;
    }

    public static MallViewRefundDetailAddressBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallViewRefundDetailAddressBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallViewRefundDetailAddressBinding) ViewDataBinding.bind(obj, view, R.layout.mall_view_refund_detail_address);
    }

    @NonNull
    public static MallViewRefundDetailAddressBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallViewRefundDetailAddressBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallViewRefundDetailAddressBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallViewRefundDetailAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_refund_detail_address, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallViewRefundDetailAddressBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallViewRefundDetailAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_refund_detail_address, null, false, obj);
    }

    @Nullable
    public ShippingAddressBean f() {
        return this.f11087a;
    }

    @Nullable
    public RefundDetailActivity.ClickProxy g() {
        return this.f11088a;
    }

    public abstract void l(@Nullable ShippingAddressBean shippingAddressBean);

    public abstract void m(@Nullable RefundDetailActivity.ClickProxy clickProxy);
}
