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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.address.ShippingAddressActivity;
import com.huachenjie.mall.page.address.ShippingAddressVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityShippingAddressBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f10399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShippingAddressActivity.a f10401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShippingAddressVM f10402a;

    public MallActivityShippingAddressBinding(Object obj, View view, int i, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f34859a = recyclerView;
        this.f10400a = layoutToolbarBindingBinding;
    }

    public static MallActivityShippingAddressBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityShippingAddressBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityShippingAddressBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_shipping_address);
    }

    @NonNull
    public static MallActivityShippingAddressBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityShippingAddressBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityShippingAddressBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityShippingAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_shipping_address, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityShippingAddressBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityShippingAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_shipping_address, null, false, obj);
    }

    @Nullable
    public ShippingAddressActivity.a f() {
        return this.f10401a;
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener g() {
        return this.f10399a;
    }

    @Nullable
    public ShippingAddressVM h() {
        return this.f10402a;
    }

    public abstract void m(@Nullable ShippingAddressActivity.a aVar);

    public abstract void n(@Nullable ShippingAddressVM shippingAddressVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
