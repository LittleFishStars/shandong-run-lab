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
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.home.R;
import com.huachenjie.home.page.union_search.UnionGoodsSearchVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeActivityUnionGoodsSearchBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34220a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f9338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonSearchView f9339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public UnionGoodsSearchVM f9340a;

    public HomeActivityUnionGoodsSearchBinding(Object obj, View view, int i, RecyclerView recyclerView, CommonSearchView commonSearchView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f34220a = recyclerView;
        this.f9339a = commonSearchView;
        this.f9338a = stateLayout;
    }

    public static HomeActivityUnionGoodsSearchBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeActivityUnionGoodsSearchBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeActivityUnionGoodsSearchBinding) ViewDataBinding.bind(obj, view, R.layout.home_activity_union_goods_search);
    }

    @NonNull
    public static HomeActivityUnionGoodsSearchBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeActivityUnionGoodsSearchBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeActivityUnionGoodsSearchBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeActivityUnionGoodsSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_union_goods_search, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeActivityUnionGoodsSearchBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeActivityUnionGoodsSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_union_goods_search, null, false, obj);
    }

    @Nullable
    public UnionGoodsSearchVM f() {
        return this.f9340a;
    }

    public abstract void k(@Nullable UnionGoodsSearchVM unionGoodsSearchVM);
}
