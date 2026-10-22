package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.view.ExpandableTextView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallViewGoodsDetailHeaderContentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35087a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f11051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ExpandableTextView f11054a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailVM f11055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f11056a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11057a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11058b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ExpandableTextView f11059b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final PriceView f11060b;

    @NonNull
    public final View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f11061c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final PriceView f11062c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    public MallViewGoodsDetailHeaderContentBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, FrameLayout frameLayout, PriceView priceView, TextView textView, BLTextView bLTextView, TextView textView2, ExpandableTextView expandableTextView, TextView textView3, TextView textView4, ExpandableTextView expandableTextView2, PriceView priceView2, PriceView priceView3, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view2, View view3, View view4) {
        super(obj, view, i);
        this.f11053a = constraintLayout;
        this.f11051a = frameLayout;
        this.f11056a = priceView;
        this.f11052a = textView;
        this.f11057a = bLTextView;
        this.f11058b = textView2;
        this.f11054a = expandableTextView;
        this.f11061c = textView3;
        this.d = textView4;
        this.f11059b = expandableTextView2;
        this.f11060b = priceView2;
        this.f11062c = priceView3;
        this.e = textView5;
        this.f = textView6;
        this.g = textView7;
        this.h = textView8;
        this.f35087a = view2;
        this.b = view3;
        this.c = view4;
    }

    public static MallViewGoodsDetailHeaderContentBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallViewGoodsDetailHeaderContentBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallViewGoodsDetailHeaderContentBinding) ViewDataBinding.bind(obj, view, R.layout.mall_view_goods_detail_header_content);
    }

    @NonNull
    public static MallViewGoodsDetailHeaderContentBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallViewGoodsDetailHeaderContentBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallViewGoodsDetailHeaderContentBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallViewGoodsDetailHeaderContentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_goods_detail_header_content, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallViewGoodsDetailHeaderContentBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallViewGoodsDetailHeaderContentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_goods_detail_header_content, null, false, obj);
    }

    @Nullable
    public GoodsDetailVM f() {
        return this.f11055a;
    }

    public abstract void k(@Nullable GoodsDetailVM goodsDetailVM);
}
