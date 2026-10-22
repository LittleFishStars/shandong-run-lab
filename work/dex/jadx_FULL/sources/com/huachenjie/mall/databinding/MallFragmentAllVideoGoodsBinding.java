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
import com.huachenjie.mall.page.video_enter.AllVideoGoodsVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallFragmentAllVideoGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34940a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f10643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AllVideoGoodsVM f10645a;

    public MallFragmentAllVideoGoodsBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f34940a = recyclerView;
        this.f10644a = stateLayout;
    }

    public static MallFragmentAllVideoGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallFragmentAllVideoGoodsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallFragmentAllVideoGoodsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_fragment_all_video_goods);
    }

    @NonNull
    public static MallFragmentAllVideoGoodsBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallFragmentAllVideoGoodsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallFragmentAllVideoGoodsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallFragmentAllVideoGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_all_video_goods, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallFragmentAllVideoGoodsBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallFragmentAllVideoGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_all_video_goods, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f10643a;
    }

    @Nullable
    public AllVideoGoodsVM g() {
        return this.f10645a;
    }

    public abstract void l(@Nullable AllVideoGoodsVM allVideoGoodsVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
