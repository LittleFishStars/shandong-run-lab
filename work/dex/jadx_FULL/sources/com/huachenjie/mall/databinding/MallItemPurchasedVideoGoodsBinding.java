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
import com.huachenjie.mall.bean.MyCourseOrEpisodesBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemPurchasedVideoGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public MyCourseOrEpisodesBean f35023a;

    public MallItemPurchasedVideoGoodsBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemPurchasedVideoGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemPurchasedVideoGoodsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemPurchasedVideoGoodsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_purchased_video_goods);
    }

    @NonNull
    public static MallItemPurchasedVideoGoodsBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemPurchasedVideoGoodsBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemPurchasedVideoGoodsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemPurchasedVideoGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_purchased_video_goods, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemPurchasedVideoGoodsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemPurchasedVideoGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_purchased_video_goods, null, false, obj);
    }

    @Nullable
    public MyCourseOrEpisodesBean f() {
        return this.f35023a;
    }

    public abstract void k(@Nullable MyCourseOrEpisodesBean myCourseOrEpisodesBean);
}
