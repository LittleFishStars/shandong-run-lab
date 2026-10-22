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
import com.huachenjie.mall.page.search.SearchResultGoodsModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallFragmentSearchResultGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f10704a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f10705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchResultGoodsModel f10707a;

    public MallFragmentSearchResultGoodsBinding(Object obj, View view, int i, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, StateLayout stateLayout) {
        super(obj, view, i);
        this.f34966a = recyclerView;
        this.f10705a = swipeRefreshLayout;
        this.f10706a = stateLayout;
    }

    public static MallFragmentSearchResultGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallFragmentSearchResultGoodsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallFragmentSearchResultGoodsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_fragment_search_result_goods);
    }

    @NonNull
    public static MallFragmentSearchResultGoodsBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallFragmentSearchResultGoodsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallFragmentSearchResultGoodsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallFragmentSearchResultGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_search_result_goods, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallFragmentSearchResultGoodsBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallFragmentSearchResultGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_search_result_goods, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f10704a;
    }

    @Nullable
    public SearchResultGoodsModel g() {
        return this.f10707a;
    }

    public abstract void l(@Nullable SearchResultGoodsModel searchResultGoodsModel);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
