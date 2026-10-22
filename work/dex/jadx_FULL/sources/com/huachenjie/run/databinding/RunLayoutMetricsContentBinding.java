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
import com.huachenjie.run.page.run_detail.RunDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutMetricsContentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public RunDetailVM f35676a;

    public RunLayoutMetricsContentBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static RunLayoutMetricsContentBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutMetricsContentBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutMetricsContentBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_metrics_content);
    }

    @NonNull
    public static RunLayoutMetricsContentBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutMetricsContentBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutMetricsContentBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutMetricsContentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_metrics_content, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutMetricsContentBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutMetricsContentBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_metrics_content, null, false, component);
    }

    @Nullable
    public RunDetailVM f() {
        return this.f35676a;
    }

    public abstract void k(@Nullable RunDetailVM vm);
}
