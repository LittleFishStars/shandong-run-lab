package com.huachenjie.im.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.im.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LayoutContactEmptyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f9881a;

    public LayoutContactEmptyBinding(Object obj, View view, int i, LottieAnimationView lottieAnimationView, TextView textView) {
        super(obj, view, i);
        this.f9881a = lottieAnimationView;
        this.f34500a = textView;
    }

    public static LayoutContactEmptyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutContactEmptyBinding d(@NonNull View view, @Nullable Object obj) {
        return (LayoutContactEmptyBinding) ViewDataBinding.bind(obj, view, R.layout.layout_contact_empty);
    }

    @NonNull
    public static LayoutContactEmptyBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutContactEmptyBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutContactEmptyBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LayoutContactEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_contact_empty, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LayoutContactEmptyBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutContactEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_contact_empty, null, false, obj);
    }
}
