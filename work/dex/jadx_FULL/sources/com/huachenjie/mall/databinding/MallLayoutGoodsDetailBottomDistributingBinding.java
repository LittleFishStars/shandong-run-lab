package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallLayoutGoodsDetailBottomDistributingBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CardView f10980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailActivity.ClickProxy f10981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailVM f10982a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10983b;

    public MallLayoutGoodsDetailBottomDistributingBinding(Object obj, View view, int i, CardView cardView, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f10980a = cardView;
        this.f35060a = imageView;
        this.b = imageView2;
        this.f10979a = textView;
        this.f10983b = textView2;
    }

    public static MallLayoutGoodsDetailBottomDistributingBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallLayoutGoodsDetailBottomDistributingBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallLayoutGoodsDetailBottomDistributingBinding) ViewDataBinding.bind(obj, view, R.layout.mall_layout_goods_detail_bottom_distributing);
    }

    @NonNull
    public static MallLayoutGoodsDetailBottomDistributingBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallLayoutGoodsDetailBottomDistributingBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallLayoutGoodsDetailBottomDistributingBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallLayoutGoodsDetailBottomDistributingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_layout_goods_detail_bottom_distributing, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallLayoutGoodsDetailBottomDistributingBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallLayoutGoodsDetailBottomDistributingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_layout_goods_detail_bottom_distributing, null, false, obj);
    }

    @Nullable
    public GoodsDetailActivity.ClickProxy f() {
        return this.f10981a;
    }

    @Nullable
    public GoodsDetailVM g() {
        return this.f10982a;
    }

    public abstract void l(@Nullable GoodsDetailActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable GoodsDetailVM goodsDetailVM);
}
