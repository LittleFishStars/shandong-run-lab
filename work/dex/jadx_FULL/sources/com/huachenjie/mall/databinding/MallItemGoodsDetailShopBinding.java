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
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailShop;
import com.huachenjie.mall.page.goods_detail.item_binder.ShopItemBinder;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemGoodsDetailShopBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10809a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10810a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailShop f10812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShopItemBinder.ShopItemAdapter f10813a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10814a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public MallItemGoodsDetailShopBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, BLTextView bLTextView, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.f10809a = imageView;
        this.f10811a = recyclerView;
        this.f10814a = bLTextView;
        this.f10810a = textView;
        this.b = textView2;
        this.c = textView3;
        this.f35005a = view2;
    }

    public static MallItemGoodsDetailShopBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemGoodsDetailShopBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemGoodsDetailShopBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_goods_detail_shop);
    }

    @NonNull
    public static MallItemGoodsDetailShopBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemGoodsDetailShopBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemGoodsDetailShopBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemGoodsDetailShopBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_goods_detail_shop, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemGoodsDetailShopBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemGoodsDetailShopBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_goods_detail_shop, null, false, obj);
    }

    @Nullable
    public ShopItemBinder.ShopItemAdapter f() {
        return this.f10813a;
    }

    @Nullable
    public GoodsDetailShop g() {
        return this.f10812a;
    }

    public abstract void l(@Nullable ShopItemBinder.ShopItemAdapter shopItemAdapter);

    public abstract void m(@Nullable GoodsDetailShop goodsDetailShop);
}
