package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public abstract class MallLayoutGoodsDetailBottomPointBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CardView f35064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailActivity.ClickProxy f10989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailVM f10990a;

    public MallLayoutGoodsDetailBottomPointBinding(Object obj, View view, int i, CardView cardView) {
        super(obj, view, i);
        this.f35064a = cardView;
    }

    public static MallLayoutGoodsDetailBottomPointBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallLayoutGoodsDetailBottomPointBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallLayoutGoodsDetailBottomPointBinding) ViewDataBinding.bind(obj, view, R.layout.mall_layout_goods_detail_bottom_point);
    }

    @NonNull
    public static MallLayoutGoodsDetailBottomPointBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallLayoutGoodsDetailBottomPointBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallLayoutGoodsDetailBottomPointBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallLayoutGoodsDetailBottomPointBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_layout_goods_detail_bottom_point, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallLayoutGoodsDetailBottomPointBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallLayoutGoodsDetailBottomPointBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_layout_goods_detail_bottom_point, null, false, obj);
    }

    @Nullable
    public GoodsDetailActivity.ClickProxy f() {
        return this.f10989a;
    }

    @Nullable
    public GoodsDetailVM g() {
        return this.f10990a;
    }

    public abstract void l(@Nullable GoodsDetailActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable GoodsDetailVM goodsDetailVM);
}
