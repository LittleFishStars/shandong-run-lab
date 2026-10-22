package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.home.R;
import com.huachenjie.home.page.rebate_goods_list.RebateGoodsUnionVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeFragmentRebateGoodsListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34260a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f9446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RebateGoodsUnionVM f9447a;

    public HomeFragmentRebateGoodsListBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f34260a = recyclerView;
        this.f9446a = stateLayout;
    }

    public static HomeFragmentRebateGoodsListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeFragmentRebateGoodsListBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeFragmentRebateGoodsListBinding) ViewDataBinding.bind(obj, view, R.layout.home_fragment_rebate_goods_list);
    }

    @NonNull
    public static HomeFragmentRebateGoodsListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeFragmentRebateGoodsListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeFragmentRebateGoodsListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeFragmentRebateGoodsListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_fragment_rebate_goods_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeFragmentRebateGoodsListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeFragmentRebateGoodsListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_fragment_rebate_goods_list, null, false, obj);
    }

    @Nullable
    public RebateGoodsUnionVM f() {
        return this.f9447a;
    }

    public abstract void k(@Nullable RebateGoodsUnionVM rebateGoodsUnionVM);
}
