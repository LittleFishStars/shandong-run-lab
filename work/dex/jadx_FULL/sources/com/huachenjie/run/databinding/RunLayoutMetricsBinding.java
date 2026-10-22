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
public abstract class RunLayoutMetricsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RunLayoutMetricsContentBinding f35674a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailVM f12094a;

    public RunLayoutMetricsBinding(Object _bindingComponent, View _root, int _localFieldCount, RunLayoutMetricsContentBinding layoutMetricsContent) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35674a = layoutMetricsContent;
    }

    public static RunLayoutMetricsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutMetricsBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutMetricsBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_metrics);
    }

    @NonNull
    public static RunLayoutMetricsBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutMetricsBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutMetricsBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutMetricsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_metrics, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutMetricsBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutMetricsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_metrics, null, false, component);
    }

    @Nullable
    public RunDetailVM f() {
        return this.f12094a;
    }

    public abstract void k(@Nullable RunDetailVM vm);
}
