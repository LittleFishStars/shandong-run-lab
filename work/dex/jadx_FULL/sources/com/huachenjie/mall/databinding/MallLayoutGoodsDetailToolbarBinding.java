package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.flyco.tablayout.CommonTabLayout;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallLayoutGoodsDetailToolbarBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35069a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11000a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonTabLayout f11001a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailActivity.ClickProxy f11002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f11003a;

    @NonNull
    public final ImageView b;

    public MallLayoutGoodsDetailToolbarBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, CommonTabLayout commonTabLayout) {
        super(obj, view, i);
        this.f35069a = frameLayout;
        this.f11000a = imageView;
        this.b = imageView2;
        this.f11001a = commonTabLayout;
    }

    public static MallLayoutGoodsDetailToolbarBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallLayoutGoodsDetailToolbarBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallLayoutGoodsDetailToolbarBinding) ViewDataBinding.bind(obj, view, R.layout.mall_layout_goods_detail_toolbar);
    }

    @NonNull
    public static MallLayoutGoodsDetailToolbarBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallLayoutGoodsDetailToolbarBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallLayoutGoodsDetailToolbarBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallLayoutGoodsDetailToolbarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_layout_goods_detail_toolbar, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallLayoutGoodsDetailToolbarBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallLayoutGoodsDetailToolbarBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_layout_goods_detail_toolbar, null, false, obj);
    }

    @Nullable
    public GoodsDetailActivity.ClickProxy f() {
        return this.f11002a;
    }

    @Nullable
    public Integer g() {
        return this.f11003a;
    }

    public abstract void l(@Nullable GoodsDetailActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable Integer num);
}
