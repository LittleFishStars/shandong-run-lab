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
import com.huachenjie.mall.external.page.CommodityVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallFragmentCommodityBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f10659a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommodityVM f10661a;

    public MallFragmentCommodityBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f34946a = recyclerView;
        this.f10660a = stateLayout;
    }

    public static MallFragmentCommodityBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallFragmentCommodityBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallFragmentCommodityBinding) ViewDataBinding.bind(obj, view, R.layout.mall_fragment_commodity);
    }

    @NonNull
    public static MallFragmentCommodityBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallFragmentCommodityBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallFragmentCommodityBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallFragmentCommodityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_commodity, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallFragmentCommodityBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallFragmentCommodityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_commodity, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f10659a;
    }

    @Nullable
    public CommodityVM g() {
        return this.f10661a;
    }

    public abstract void l(@Nullable CommodityVM commodityVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
