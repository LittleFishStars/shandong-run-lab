package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.PromoSlotBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemHomeGoodsMallBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PromoSlotBean f9478a;

    @NonNull
    public final TextView b;

    public HomeItemHomeGoodsMallBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f34273a = imageView;
        this.f9477a = textView;
        this.b = textView2;
    }

    public static HomeItemHomeGoodsMallBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemHomeGoodsMallBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemHomeGoodsMallBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_home_goods_mall);
    }

    @NonNull
    public static HomeItemHomeGoodsMallBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemHomeGoodsMallBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemHomeGoodsMallBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemHomeGoodsMallBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_home_goods_mall, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemHomeGoodsMallBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemHomeGoodsMallBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_home_goods_mall, null, false, obj);
    }

    @Nullable
    public PromoSlotBean f() {
        return this.f9478a;
    }

    public abstract void k(@Nullable PromoSlotBean promoSlotBean);
}
