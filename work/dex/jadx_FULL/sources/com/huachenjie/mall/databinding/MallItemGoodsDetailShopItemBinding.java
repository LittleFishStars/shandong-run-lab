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
import com.huachenjie.mall.external.bean.CommodityBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemGoodsDetailShopItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public CommodityBean f35007a;

    public MallItemGoodsDetailShopItemBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemGoodsDetailShopItemBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemGoodsDetailShopItemBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemGoodsDetailShopItemBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_goods_detail_shop_item);
    }

    @NonNull
    public static MallItemGoodsDetailShopItemBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemGoodsDetailShopItemBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemGoodsDetailShopItemBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemGoodsDetailShopItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_goods_detail_shop_item, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemGoodsDetailShopItemBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemGoodsDetailShopItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_goods_detail_shop_item, null, false, obj);
    }

    @Nullable
    public CommodityBean f() {
        return this.f35007a;
    }

    public abstract void k(@Nullable CommodityBean commodityBean);
}
