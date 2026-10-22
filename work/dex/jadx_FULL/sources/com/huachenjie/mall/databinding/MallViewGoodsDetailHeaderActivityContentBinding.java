package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLRelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallViewGoodsDetailHeaderActivityContentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f11022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ExpandableTextView f11024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailActivity.ClickProxy f11025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailVM f11026a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f11027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f11028a;

    @NonNull
    public final TextView b;

    public MallViewGoodsDetailHeaderActivityContentBinding(Object obj, View view, int i, RelativeLayout relativeLayout, BLRelativeLayout bLRelativeLayout, ExpandableTextView expandableTextView, TextView textView, PriceView priceView, TextView textView2, View view2) {
        super(obj, view, i);
        this.f11022a = relativeLayout;
        this.f11028a = bLRelativeLayout;
        this.f11024a = expandableTextView;
        this.f11023a = textView;
        this.f11027a = priceView;
        this.b = textView2;
        this.f35079a = view2;
    }

    public static MallViewGoodsDetailHeaderActivityContentBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallViewGoodsDetailHeaderActivityContentBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallViewGoodsDetailHeaderActivityContentBinding) ViewDataBinding.bind(obj, view, R.layout.mall_view_goods_detail_header_activity_content);
    }

    @NonNull
    public static MallViewGoodsDetailHeaderActivityContentBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallViewGoodsDetailHeaderActivityContentBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallViewGoodsDetailHeaderActivityContentBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallViewGoodsDetailHeaderActivityContentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_goods_detail_header_activity_content, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallViewGoodsDetailHeaderActivityContentBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallViewGoodsDetailHeaderActivityContentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_goods_detail_header_activity_content, null, false, obj);
    }

    @Nullable
    public GoodsDetailActivity.ClickProxy f() {
        return this.f11025a;
    }

    @Nullable
    public GoodsDetailVM g() {
        return this.f11026a;
    }

    public abstract void l(@Nullable GoodsDetailActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable GoodsDetailVM goodsDetailVM);
}
