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
import com.huachenjie.base.bean.MyOrderBean;
import com.huachenjie.mall.R;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemChooseShopOrderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f34980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyOrderBean f10734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f10735a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10736a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public MallItemChooseShopOrderBinding(Object obj, View view, int i, BLImageView bLImageView, LinearLayout linearLayout, PriceView priceView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f10736a = bLImageView;
        this.f34980a = linearLayout;
        this.f10735a = priceView;
        this.f10733a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static MallItemChooseShopOrderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemChooseShopOrderBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemChooseShopOrderBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_choose_shop_order);
    }

    @NonNull
    public static MallItemChooseShopOrderBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemChooseShopOrderBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemChooseShopOrderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemChooseShopOrderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_choose_shop_order, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemChooseShopOrderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemChooseShopOrderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_choose_shop_order, null, false, obj);
    }

    @Nullable
    public MyOrderBean f() {
        return this.f10734a;
    }

    public abstract void k(@Nullable MyOrderBean myOrderBean);
}
