package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpecValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemGoodsSpecificationPreviewBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public GoodsDetailSpecValue f35013a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f10836a;

    public MallItemGoodsSpecificationPreviewBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemGoodsSpecificationPreviewBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemGoodsSpecificationPreviewBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemGoodsSpecificationPreviewBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_goods_specification_preview);
    }

    @NonNull
    public static MallItemGoodsSpecificationPreviewBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemGoodsSpecificationPreviewBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemGoodsSpecificationPreviewBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemGoodsSpecificationPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_goods_specification_preview, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemGoodsSpecificationPreviewBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemGoodsSpecificationPreviewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_goods_specification_preview, null, false, obj);
    }

    @Nullable
    public GoodsDetailSpecValue f() {
        return this.f35013a;
    }

    @Nullable
    public Integer g() {
        return this.f10836a;
    }

    public abstract void l(@Nullable GoodsDetailSpecValue goodsDetailSpecValue);

    public abstract void m(@Nullable Integer num);
}
