package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityGoodsSpecificationPreviewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f34799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsSpecificationPreviewActivity.a f10234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsSpecificationPreviewVM f10235a;

    public MallActivityGoodsSpecificationPreviewBinding(Object obj, View view, int i, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f34799a = viewPager2;
    }

    public static MallActivityGoodsSpecificationPreviewBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityGoodsSpecificationPreviewBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityGoodsSpecificationPreviewBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_goods_specification_preview);
    }

    @NonNull
    public static MallActivityGoodsSpecificationPreviewBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityGoodsSpecificationPreviewBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityGoodsSpecificationPreviewBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityGoodsSpecificationPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_goods_specification_preview, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityGoodsSpecificationPreviewBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityGoodsSpecificationPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_goods_specification_preview, null, false, obj);
    }

    @Nullable
    public GoodsSpecificationPreviewActivity.a f() {
        return this.f10234a;
    }

    @Nullable
    public GoodsSpecificationPreviewVM g() {
        return this.f10235a;
    }

    public abstract void l(@Nullable GoodsSpecificationPreviewActivity.a aVar);

    public abstract void m(@Nullable GoodsSpecificationPreviewVM goodsSpecificationPreviewVM);
}
