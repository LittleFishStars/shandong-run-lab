package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public abstract class MallItemOrderDetailGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderGoodsBean f10860a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f10861a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10862a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public MallItemOrderDetailGoodsBinding(Object obj, View view, int i, BLImageView bLImageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, PriceView priceView, TextView textView4) {
        super(obj, view, i);
        this.f10862a = bLImageView;
        this.f35019a = linearLayout;
        this.f10859a = textView;
        this.b = textView2;
        this.c = textView3;
        this.f10861a = priceView;
        this.d = textView4;
    }

    public static MallItemOrderDetailGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemOrderDetailGoodsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemOrderDetailGoodsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_order_detail_goods);
    }

    @NonNull
    public static MallItemOrderDetailGoodsBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemOrderDetailGoodsBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemOrderDetailGoodsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemOrderDetailGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_order_detail_goods, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemOrderDetailGoodsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemOrderDetailGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_order_detail_goods, null, false, obj);
    }

    @Nullable
    public OrderGoodsBean f() {
        return this.f10860a;
    }

    public abstract void k(@Nullable OrderGoodsBean orderGoodsBean);
}
