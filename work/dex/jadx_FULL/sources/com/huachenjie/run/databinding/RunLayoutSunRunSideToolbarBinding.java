package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.sun_run.SunshineRunActivity;
import com.huachenjie.run.page.sun_run.SunshineRunVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutSunRunSideToolbarBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SunshineRunActivity.a f35719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRunVM f12227a;

    public RunLayoutSunRunSideToolbarBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static RunLayoutSunRunSideToolbarBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutSunRunSideToolbarBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutSunRunSideToolbarBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_sun_run_side_toolbar);
    }

    @NonNull
    public static RunLayoutSunRunSideToolbarBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutSunRunSideToolbarBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutSunRunSideToolbarBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutSunRunSideToolbarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_sun_run_side_toolbar, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutSunRunSideToolbarBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutSunRunSideToolbarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_sun_run_side_toolbar, null, false, component);
    }

    @Nullable
    public SunshineRunActivity.a f() {
        return this.f35719a;
    }

    @Nullable
    public SunshineRunVM g() {
        return this.f12227a;
    }

    public abstract void l(@Nullable SunshineRunActivity.a click);

    public abstract void m(@Nullable SunshineRunVM vm);
}
