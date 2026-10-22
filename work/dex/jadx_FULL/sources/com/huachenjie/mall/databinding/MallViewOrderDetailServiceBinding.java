package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.widget.OrderDetailServiceView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallViewOrderDetailServiceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public OrderDetailServiceView.a f35095a;

    public MallViewOrderDetailServiceBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallViewOrderDetailServiceBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallViewOrderDetailServiceBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallViewOrderDetailServiceBinding) ViewDataBinding.bind(obj, view, R.layout.mall_view_order_detail_service);
    }

    @NonNull
    public static MallViewOrderDetailServiceBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallViewOrderDetailServiceBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallViewOrderDetailServiceBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallViewOrderDetailServiceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_order_detail_service, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallViewOrderDetailServiceBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallViewOrderDetailServiceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_order_detail_service, null, false, obj);
    }

    @Nullable
    public OrderDetailServiceView.a f() {
        return this.f35095a;
    }

    public abstract void k(@Nullable OrderDetailServiceView.a aVar);
}
