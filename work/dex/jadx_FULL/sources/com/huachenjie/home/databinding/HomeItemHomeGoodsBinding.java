package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.PromoSlotBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemHomeGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PromoSlotBean f9472a;

    public HomeItemHomeGoodsBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f34271a = imageView;
    }

    public static HomeItemHomeGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemHomeGoodsBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemHomeGoodsBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_home_goods);
    }

    @NonNull
    public static HomeItemHomeGoodsBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemHomeGoodsBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemHomeGoodsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemHomeGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_home_goods, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemHomeGoodsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemHomeGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_home_goods, null, false, obj);
    }

    @Nullable
    public PromoSlotBean f() {
        return this.f9472a;
    }

    public abstract void k(@Nullable PromoSlotBean promoSlotBean);
}
