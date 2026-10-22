package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.common.widget.ShadowLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.huodong.HuodongDetailActivity;
import com.huachenjie.sport.page.mine.huodong.HuodongDetailVM;
import com.huachenjie.sport.widget.HuodongSignButton;
import com.huachenjie.sport.widget.HuodongStatusWidget;
import com.huachenjie.sport.widget.ProgressBarView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityHuodongDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13254a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final NestedScrollView f13256a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f13257a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f13258a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowLayout f13259a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HuodongDetailActivity.a f13260a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HuodongDetailVM f13261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final HuodongSignButton f13262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final HuodongStatusWidget f13263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ProgressBarView f13264a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13265b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13266b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f13267b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f13268c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f13269c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f13270d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f13271e;

    @NonNull
    public final ImageView f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f13272f;

    @NonNull
    public final ImageView g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @NonNull
    public final TextView f13273g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    public ActivityHuodongDetailBinding(Object obj, View view, int i, ShadowConstraintLayout shadowConstraintLayout, ShadowLayout shadowLayout, ShadowConstraintLayout shadowConstraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, ProgressBarView progressBarView, HuodongSignButton huodongSignButton, NestedScrollView nestedScrollView, LayoutToolbarBindingBinding layoutToolbarBindingBinding, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, View view2, HuodongStatusWidget huodongStatusWidget) {
        super(obj, view, i);
        this.f13258a = shadowConstraintLayout;
        this.f13259a = shadowLayout;
        this.f13267b = shadowConstraintLayout2;
        this.f13253a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f = imageView6;
        this.g = imageView7;
        this.f13255a = linearLayoutCompat;
        this.f13266b = linearLayoutCompat2;
        this.f13269c = linearLayoutCompat3;
        this.f13264a = progressBarView;
        this.f13262a = huodongSignButton;
        this.f13256a = nestedScrollView;
        this.f13257a = layoutToolbarBindingBinding;
        this.f13254a = textView;
        this.f13265b = textView2;
        this.f13268c = textView3;
        this.f13270d = textView4;
        this.f13271e = textView5;
        this.f13272f = textView6;
        this.f13273g = textView7;
        this.h = textView8;
        this.i = textView9;
        this.j = textView10;
        this.k = textView11;
        this.f36406a = view2;
        this.f13263a = huodongStatusWidget;
    }

    public static ActivityHuodongDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityHuodongDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityHuodongDetailBinding) ViewDataBinding.bind(obj, view, R.layout.activity_huodong_detail);
    }

    @NonNull
    public static ActivityHuodongDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityHuodongDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityHuodongDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityHuodongDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_huodong_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityHuodongDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityHuodongDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_huodong_detail, null, false, obj);
    }

    @Nullable
    public HuodongDetailActivity.a f() {
        return this.f13260a;
    }

    @Nullable
    public HuodongDetailVM g() {
        return this.f13261a;
    }

    public abstract void l(@Nullable HuodongDetailActivity.a aVar);

    public abstract void m(@Nullable HuodongDetailVM huodongDetailVM);
}
