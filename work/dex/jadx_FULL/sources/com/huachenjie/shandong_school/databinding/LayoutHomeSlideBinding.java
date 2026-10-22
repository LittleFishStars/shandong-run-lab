package com.huachenjie.shandong_school.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.shandong_school.R;
import com.huachenjie.shandong_school.home.HomeActivity;
import com.huachenjie.shandong_school.home.HomeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class LayoutHomeSlideBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HomeActivity.a f12646a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HomeVM f12647a;

    public LayoutHomeSlideBinding(Object obj, View view, int i, FrameLayout frameLayout) {
        super(obj, view, i);
        this.f36028a = frameLayout;
    }

    public static LayoutHomeSlideBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutHomeSlideBinding d(@NonNull View view, @Nullable Object obj) {
        return (LayoutHomeSlideBinding) ViewDataBinding.bind(obj, view, R.layout.layout_home_slide);
    }

    @NonNull
    public static LayoutHomeSlideBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutHomeSlideBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutHomeSlideBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LayoutHomeSlideBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_home_slide, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LayoutHomeSlideBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LayoutHomeSlideBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.layout_home_slide, null, false, obj);
    }

    @Nullable
    public HomeActivity.a f() {
        return this.f12646a;
    }

    @Nullable
    public HomeVM g() {
        return this.f12647a;
    }

    public abstract void l(@Nullable HomeActivity.a aVar);

    public abstract void m(@Nullable HomeVM homeVM);
}
