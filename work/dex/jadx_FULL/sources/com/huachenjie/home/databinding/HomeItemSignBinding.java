package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.SignBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemSignBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f34292a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SignBean f9538a;

    public HomeItemSignBinding(Object obj, View view, int i, LottieAnimationView lottieAnimationView) {
        super(obj, view, i);
        this.f34292a = lottieAnimationView;
    }

    public static HomeItemSignBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemSignBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemSignBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_sign);
    }

    @NonNull
    public static HomeItemSignBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemSignBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemSignBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemSignBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_sign, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemSignBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemSignBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_sign, null, false, obj);
    }

    @Nullable
    public SignBean f() {
        return this.f9538a;
    }

    public abstract void k(@Nullable SignBean signBean);
}
