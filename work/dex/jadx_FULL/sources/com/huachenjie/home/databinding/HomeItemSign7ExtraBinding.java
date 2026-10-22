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
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.SignBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemSign7ExtraBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f9532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SignBean f9533a;

    public HomeItemSign7ExtraBinding(Object obj, View view, int i, ImageView imageView, LottieAnimationView lottieAnimationView) {
        super(obj, view, i);
        this.f34290a = imageView;
        this.f9532a = lottieAnimationView;
    }

    public static HomeItemSign7ExtraBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemSign7ExtraBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemSign7ExtraBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_sign_7_extra);
    }

    @NonNull
    public static HomeItemSign7ExtraBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemSign7ExtraBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemSign7ExtraBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemSign7ExtraBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_sign_7_extra, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemSign7ExtraBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemSign7ExtraBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_sign_7_extra, null, false, obj);
    }

    @Nullable
    public SignBean f() {
        return this.f9533a;
    }

    public abstract void k(@Nullable SignBean signBean);
}
