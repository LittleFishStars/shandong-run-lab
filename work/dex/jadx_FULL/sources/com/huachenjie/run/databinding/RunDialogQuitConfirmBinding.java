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
import com.huachenjie.run.dialog.RunQuitConfirmDialog;
import com.huachenjie.run.page.sun_run.SunshineRunVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunDialogQuitConfirmBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RunLayoutPauseHeaderBinding f35551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunQuitConfirmDialog.a f11760a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRunVM f11761a;

    public RunDialogQuitConfirmBinding(Object _bindingComponent, View _root, int _localFieldCount, RunLayoutPauseHeaderBinding pauseHeader) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35551a = pauseHeader;
    }

    public static RunDialogQuitConfirmBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunDialogQuitConfirmBinding d(@NonNull View view, @Nullable Object component) {
        return (RunDialogQuitConfirmBinding) ViewDataBinding.bind(component, view, R.layout.run_dialog_quit_confirm);
    }

    @NonNull
    public static RunDialogQuitConfirmBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunDialogQuitConfirmBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunDialogQuitConfirmBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunDialogQuitConfirmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_quit_confirm, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunDialogQuitConfirmBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunDialogQuitConfirmBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_quit_confirm, null, false, component);
    }

    @Nullable
    public RunQuitConfirmDialog.a f() {
        return this.f11760a;
    }

    @Nullable
    public SunshineRunVM g() {
        return this.f11761a;
    }

    public abstract void l(@Nullable RunQuitConfirmDialog.a click);

    public abstract void m(@Nullable SunshineRunVM vm);
}
