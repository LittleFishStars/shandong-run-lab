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
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.my_order.MyOrderListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallFragmentMyOrderListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f10683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyOrderListVM f10685a;

    public MallFragmentMyOrderListBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f34957a = recyclerView;
        this.f10684a = stateLayout;
    }

    public static MallFragmentMyOrderListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallFragmentMyOrderListBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallFragmentMyOrderListBinding) ViewDataBinding.bind(obj, view, R.layout.mall_fragment_my_order_list);
    }

    @NonNull
    public static MallFragmentMyOrderListBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallFragmentMyOrderListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallFragmentMyOrderListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallFragmentMyOrderListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_my_order_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallFragmentMyOrderListBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallFragmentMyOrderListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_my_order_list, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f10683a;
    }

    @Nullable
    public MyOrderListVM g() {
        return this.f10685a;
    }

    public abstract void l(@Nullable MyOrderListVM myOrderListVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
