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
import com.huachenjie.run.page.activities_run.dialog.GPSErrorDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunDialogGpsErrorBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public GPSErrorDialog.a f35535a;

    public RunDialogGpsErrorBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static RunDialogGpsErrorBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunDialogGpsErrorBinding d(@NonNull View view, @Nullable Object component) {
        return (RunDialogGpsErrorBinding) ViewDataBinding.bind(component, view, R.layout.run_dialog_gps_error);
    }

    @NonNull
    public static RunDialogGpsErrorBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunDialogGpsErrorBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunDialogGpsErrorBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunDialogGpsErrorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_gps_error, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunDialogGpsErrorBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunDialogGpsErrorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_gps_error, null, false, component);
    }

    @Nullable
    public GPSErrorDialog.a f() {
        return this.f35535a;
    }

    public abstract void k(@Nullable GPSErrorDialog.a click);
}
