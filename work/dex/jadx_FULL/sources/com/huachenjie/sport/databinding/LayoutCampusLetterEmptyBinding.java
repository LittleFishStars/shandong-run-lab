package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class LayoutCampusLetterEmptyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13660a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f13661a;

    public LayoutCampusLetterEmptyBinding(Object obj, View view, int i, LottieAnimationView lottieAnimationView, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.f13661a = lottieAnimationView;
        this.f13660a = constraintLayout;
        this.f36537a = textView;
    }

    public static LayoutCampusLetterEmptyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutCampusLetterEmptyBinding d(@NonNull View view, @Nullable Object obj) {
        return (LayoutCampusLetterEmptyBinding) ViewDataBinding.bind(obj, view, R.layout.layout_campus_letter_empty);
    }

    @NonNull
    public static LayoutCampusLetterEmptyBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutCampusLetterEmptyBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutCampusLetterEmptyBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LayoutCampusLetterEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_campus_letter_empty, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LayoutCampusLetterEmptyBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutCampusLetterEmptyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_campus_letter_empty, null, false, obj);
    }
}
