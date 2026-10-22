package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.bean.OrderGoodsBean;
import com.huachenjie.mall.R;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemMyOrderGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35017a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderGoodsBean f10853a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f10854a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10855a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public MallItemMyOrderGoodsBinding(Object obj, View view, int i, BLImageView bLImageView, TextView textView, TextView textView2, PriceView priceView, TextView textView3) {
        super(obj, view, i);
        this.f10855a = bLImageView;
        this.f35017a = textView;
        this.b = textView2;
        this.f10854a = priceView;
        this.c = textView3;
    }

    public static MallItemMyOrderGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemMyOrderGoodsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemMyOrderGoodsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_my_order_goods);
    }

    @NonNull
    public static MallItemMyOrderGoodsBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemMyOrderGoodsBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemMyOrderGoodsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemMyOrderGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_my_order_goods, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemMyOrderGoodsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemMyOrderGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_my_order_goods, null, false, obj);
    }

    @Nullable
    public OrderGoodsBean f() {
        return this.f10853a;
    }

    public abstract void k(@Nullable OrderGoodsBean orderGoodsBean);
}
