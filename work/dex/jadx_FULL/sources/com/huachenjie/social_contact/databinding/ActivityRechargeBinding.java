package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.page.RechargeActivity;
import com.huachenjie.social_contact.vm.PayVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityRechargeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12747a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f12748a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RechargeActivity.a f12749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PayVM f12750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12751a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f12752a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLView f12753b;

    public ActivityRechargeBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, BLConstraintLayout bLConstraintLayout, ImageView imageView, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2, BLView bLView, BLView bLView2) {
        super(obj, view, i);
        this.f12747a = constraintLayout;
        this.f12751a = bLConstraintLayout;
        this.f36095a = imageView;
        this.f12748a = lottieAnimationView;
        this.f12746a = textView;
        this.b = textView2;
        this.f12752a = bLView;
        this.f12753b = bLView2;
    }

    public static ActivityRechargeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityRechargeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityRechargeBinding) ViewDataBinding.bind(obj, view, R.layout.activity_recharge);
    }

    @NonNull
    public static ActivityRechargeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityRechargeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityRechargeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityRechargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_recharge, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityRechargeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityRechargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_recharge, null, false, obj);
    }

    @Nullable
    public RechargeActivity.a f() {
        return this.f12749a;
    }

    @Nullable
    public PayVM g() {
        return this.f12750a;
    }

    public abstract void l(@Nullable RechargeActivity.a aVar);

    public abstract void m(@Nullable PayVM payVM);
}
