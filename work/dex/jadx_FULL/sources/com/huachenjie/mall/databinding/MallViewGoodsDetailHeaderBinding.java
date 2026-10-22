package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.goods_detail.GoodsDetailActivity;
import com.huachenjie.mall.page.goods_detail.GoodsDetailVM;
import com.huachenjie.mall.page.goods_detail.preview.ImagePreviewView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallViewGoodsDetailHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewStubProxy f35082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailActivity.ClickProxy f11034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsDetailVM f11035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImagePreviewView f11036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f11037a;

    public MallViewGoodsDetailHeaderBinding(Object obj, View view, int i, ImagePreviewView imagePreviewView, ViewStubProxy viewStubProxy) {
        super(obj, view, i);
        this.f11036a = imagePreviewView;
        this.f35082a = viewStubProxy;
    }

    public static MallViewGoodsDetailHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallViewGoodsDetailHeaderBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallViewGoodsDetailHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.mall_view_goods_detail_header);
    }

    @NonNull
    public static MallViewGoodsDetailHeaderBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallViewGoodsDetailHeaderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallViewGoodsDetailHeaderBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallViewGoodsDetailHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_goods_detail_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallViewGoodsDetailHeaderBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallViewGoodsDetailHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_goods_detail_header, null, false, obj);
    }

    @Nullable
    public Integer f() {
        return this.f11037a;
    }

    @Nullable
    public GoodsDetailActivity.ClickProxy g() {
        return this.f11034a;
    }

    @Nullable
    public GoodsDetailVM h() {
        return this.f11035a;
    }

    public abstract void m(@Nullable Integer num);

    public abstract void n(@Nullable GoodsDetailActivity.ClickProxy clickProxy);

    public abstract void o(@Nullable GoodsDetailVM goodsDetailVM);
}
