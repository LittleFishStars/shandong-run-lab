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
import com.huachenjie.mall.page.video_enter.PurchasedVideoGoodsVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallFragmentPurchasedVideoGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34960a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f10690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PurchasedVideoGoodsVM f10692a;

    public MallFragmentPurchasedVideoGoodsBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f34960a = recyclerView;
        this.f10691a = stateLayout;
    }

    public static MallFragmentPurchasedVideoGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallFragmentPurchasedVideoGoodsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallFragmentPurchasedVideoGoodsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_fragment_purchased_video_goods);
    }

    @NonNull
    public static MallFragmentPurchasedVideoGoodsBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallFragmentPurchasedVideoGoodsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallFragmentPurchasedVideoGoodsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallFragmentPurchasedVideoGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_purchased_video_goods, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallFragmentPurchasedVideoGoodsBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallFragmentPurchasedVideoGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_purchased_video_goods, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f10690a;
    }

    @Nullable
    public PurchasedVideoGoodsVM g() {
        return this.f10692a;
    }

    public abstract void l(@Nullable PurchasedVideoGoodsVM purchasedVideoGoodsVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
