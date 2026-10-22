package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityGoodsDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewStubProxy f34797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final MallLayoutGoodsDetailToolbarBinding f10226a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailActivity.ClickProxy f10227a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailVM f10228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f10229a;

    public MallActivityGoodsDetailBinding(Object obj, View view, int i, MallLayoutGoodsDetailToolbarBinding mallLayoutGoodsDetailToolbarBinding, RecyclerView recyclerView, BLView bLView, ViewStubProxy viewStubProxy) {
        super(obj, view, i);
        this.f10226a = mallLayoutGoodsDetailToolbarBinding;
        this.f10225a = recyclerView;
        this.f10229a = bLView;
        this.f34797a = viewStubProxy;
    }

    public static MallActivityGoodsDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityGoodsDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityGoodsDetailBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_goods_detail);
    }

    @NonNull
    public static MallActivityGoodsDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityGoodsDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityGoodsDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityGoodsDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_goods_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityGoodsDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityGoodsDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_goods_detail, null, false, obj);
    }

    @Nullable
    public GoodsDetailActivity.ClickProxy f() {
        return this.f10227a;
    }

    @Nullable
    public GoodsDetailVM g() {
        return this.f10228a;
    }

    public abstract void l(@Nullable GoodsDetailActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable GoodsDetailVM goodsDetailVM);
}
