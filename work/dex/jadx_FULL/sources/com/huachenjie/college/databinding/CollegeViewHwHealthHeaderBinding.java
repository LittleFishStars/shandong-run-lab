package com.huachenjie.college.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.college.R;
import com.huachenjie.college.page.hw_health.HWHealthActivity;
import com.huachenjie.college.page.hw_health.HWHealthVM;
import com.noober.background.view.BLRelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeViewHwHealthHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HWHealthActivity.a f8445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HWHealthVM f8446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f8447a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f8448b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    public CollegeViewHwHealthHeaderBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, BLRelativeLayout bLRelativeLayout, BLRelativeLayout bLRelativeLayout2) {
        super(obj, view, i);
        this.f33591a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f8447a = bLRelativeLayout;
        this.f8448b = bLRelativeLayout2;
    }

    public static CollegeViewHwHealthHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeViewHwHealthHeaderBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeViewHwHealthHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.college_view_hw_health_header);
    }

    @NonNull
    public static CollegeViewHwHealthHeaderBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeViewHwHealthHeaderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeViewHwHealthHeaderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeViewHwHealthHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_view_hw_health_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeViewHwHealthHeaderBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeViewHwHealthHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_view_hw_health_header, null, false, obj);
    }

    @Nullable
    public HWHealthActivity.a f() {
        return this.f8445a;
    }

    @Nullable
    public HWHealthVM g() {
        return this.f8446a;
    }

    public abstract void l(@Nullable HWHealthActivity.a aVar);

    public abstract void m(@Nullable HWHealthVM hWHealthVM);
}
