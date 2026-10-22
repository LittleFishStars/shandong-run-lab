package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_detail.RunDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutRunVisionBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailVM f12165a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public RunLayoutRunVisionBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView tvActualTitle, TextView tvRequireTitle, TextView tvVisionTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35699a = tvActualTitle;
        this.b = tvRequireTitle;
        this.c = tvVisionTitle;
    }

    public static RunLayoutRunVisionBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutRunVisionBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutRunVisionBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_run_vision);
    }

    @NonNull
    public static RunLayoutRunVisionBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutRunVisionBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunVisionBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutRunVisionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_vision, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunVisionBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutRunVisionBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_vision, null, false, component);
    }

    @Nullable
    public RunDetailVM f() {
        return this.f12165a;
    }

    public abstract void k(@Nullable RunDetailVM vm);
}
