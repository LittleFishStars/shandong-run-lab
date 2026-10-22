package com.huachenjie.shandong_school.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.shandong_school.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class ActivitySplashBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12639a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12640a;

    @NonNull
    public final ImageView b;

    public ActivitySplashBinding(Object obj, View view, int i, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.f36025a = frameLayout;
        this.f12639a = imageView;
        this.b = imageView2;
        this.f12640a = textView;
    }

    public static ActivitySplashBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySplashBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivitySplashBinding) ViewDataBinding.bind(obj, view, R.layout.activity_splash);
    }

    @NonNull
    public static ActivitySplashBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivitySplashBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySplashBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySplashBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_splash, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivitySplashBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySplashBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_splash, null, false, obj);
    }
}
