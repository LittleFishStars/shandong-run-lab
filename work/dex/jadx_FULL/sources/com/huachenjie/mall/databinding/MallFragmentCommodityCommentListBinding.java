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
import com.huachenjie.mall.page.comment.list.CommodityCommentListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallFragmentCommodityCommentListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34949a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f10666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommodityCommentListVM f10668a;

    public MallFragmentCommodityCommentListBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f34949a = recyclerView;
        this.f10667a = stateLayout;
    }

    public static MallFragmentCommodityCommentListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallFragmentCommodityCommentListBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallFragmentCommodityCommentListBinding) ViewDataBinding.bind(obj, view, R.layout.mall_fragment_commodity_comment_list);
    }

    @NonNull
    public static MallFragmentCommodityCommentListBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallFragmentCommodityCommentListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallFragmentCommodityCommentListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallFragmentCommodityCommentListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_commodity_comment_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallFragmentCommodityCommentListBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallFragmentCommodityCommentListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_commodity_comment_list, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f10666a;
    }

    @Nullable
    public CommodityCommentListVM g() {
        return this.f10668a;
    }

    public abstract void l(@Nullable CommodityCommentListVM commodityCommentListVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
