package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.PayActivity;
import com.huachenjie.social_contact.vm.PayVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityPayBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36089a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f12733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PayActivity.a f12734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PayVM f12735a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12737a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f12738b;

    @NonNull
    public final TextView c;

    public ActivityPayBinding(Object obj, View view, int i, ImageView imageView, FrameLayout frameLayout, BLConstraintLayout bLConstraintLayout, LottieAnimationView lottieAnimationView, TextView textView, BLTextView bLTextView, TextView textView2, BLTextView bLTextView2, TextView textView3) {
        super(obj, view, i);
        this.f12731a = imageView;
        this.f36089a = frameLayout;
        this.f12736a = bLConstraintLayout;
        this.f12733a = lottieAnimationView;
        this.f12732a = textView;
        this.f12737a = bLTextView;
        this.b = textView2;
        this.f12738b = bLTextView2;
        this.c = textView3;
    }

    public static ActivityPayBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPayBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityPayBinding) ViewDataBinding.bind(obj, view, R.layout.activity_pay);
    }

    @NonNull
    public static ActivityPayBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityPayBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityPayBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityPayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_pay, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityPayBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityPayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_pay, null, false, obj);
    }

    @Nullable
    public PayActivity.a f() {
        return this.f12734a;
    }

    @Nullable
    public PayVM g() {
        return this.f12735a;
    }

    public abstract void l(@Nullable PayActivity.a aVar);

    public abstract void m(@Nullable PayVM payVM);
}
