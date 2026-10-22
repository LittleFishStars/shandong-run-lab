package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailSpecValue;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemGoodsSpecificationBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10829a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailSpecValue f10830a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10831a;

    public MallItemGoodsSpecificationBinding(Object obj, View view, int i, ImageView imageView, BLLinearLayout bLLinearLayout, TextView textView) {
        super(obj, view, i);
        this.f35011a = imageView;
        this.f10831a = bLLinearLayout;
        this.f10829a = textView;
    }

    public static MallItemGoodsSpecificationBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemGoodsSpecificationBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemGoodsSpecificationBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_goods_specification);
    }

    @NonNull
    public static MallItemGoodsSpecificationBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemGoodsSpecificationBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemGoodsSpecificationBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemGoodsSpecificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_goods_specification, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemGoodsSpecificationBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemGoodsSpecificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_goods_specification, null, false, obj);
    }

    @Nullable
    public GoodsDetailSpecValue f() {
        return this.f10830a;
    }

    public abstract void k(@Nullable GoodsDetailSpecValue goodsDetailSpecValue);
}
