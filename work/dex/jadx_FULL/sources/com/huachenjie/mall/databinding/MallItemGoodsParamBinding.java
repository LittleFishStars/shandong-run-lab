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
import com.huachenjie.mall.bean.goods_detail.GoodsDetailAttribute;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemGoodsParamBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public GoodsDetailAttribute f35009a;

    public MallItemGoodsParamBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemGoodsParamBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemGoodsParamBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemGoodsParamBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_goods_param);
    }

    @NonNull
    public static MallItemGoodsParamBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemGoodsParamBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemGoodsParamBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemGoodsParamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_goods_param, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemGoodsParamBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemGoodsParamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_goods_param, null, false, obj);
    }

    @Nullable
    public GoodsDetailAttribute f() {
        return this.f35009a;
    }

    public abstract void k(@Nullable GoodsDetailAttribute goodsDetailAttribute);
}
