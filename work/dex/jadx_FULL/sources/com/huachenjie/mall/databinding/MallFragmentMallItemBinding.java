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
import com.huachenjie.mall.page.home_tab.MallItemVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallFragmentMallItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34954a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f10676a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10677a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MallItemVM f10678a;

    public MallFragmentMallItemBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f34954a = recyclerView;
        this.f10677a = stateLayout;
    }

    public static MallFragmentMallItemBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallFragmentMallItemBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallFragmentMallItemBinding) ViewDataBinding.bind(obj, view, R.layout.mall_fragment_mall_item);
    }

    @NonNull
    public static MallFragmentMallItemBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallFragmentMallItemBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallFragmentMallItemBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallFragmentMallItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_mall_item, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallFragmentMallItemBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallFragmentMallItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_mall_item, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f10676a;
    }

    @Nullable
    public MallItemVM g() {
        return this.f10678a;
    }

    public abstract void l(@Nullable MallItemVM mallItemVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
