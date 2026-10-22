package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.PosterBackgroundBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemPosterBgBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PosterBackgroundBean f10865a;

    @Bindable
    public String f;

    public MallItemPosterBgBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f35021a = imageView;
    }

    public static MallItemPosterBgBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemPosterBgBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemPosterBgBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_poster_bg);
    }

    @NonNull
    public static MallItemPosterBgBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemPosterBgBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemPosterBgBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemPosterBgBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_poster_bg, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemPosterBgBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemPosterBgBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_poster_bg, null, false, obj);
    }

    @Nullable
    public PosterBackgroundBean f() {
        return this.f10865a;
    }

    @Nullable
    public String g() {
        return this.f;
    }

    public abstract void l(@Nullable PosterBackgroundBean posterBackgroundBean);

    public abstract void m(@Nullable String str);
}
