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
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.huachenjie.run.widget.RunActionButton;
import com.noober.background.view.BLRelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunDialogPauseBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35549a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutPauseHeaderBinding f11752a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRunVM f11753a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunActionButton f11754a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f11755a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RunActionButton f11756b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public RunDialogPauseBinding(Object _bindingComponent, View _root, int _localFieldCount, BLRelativeLayout clRest, RunLayoutPauseHeaderBinding pauseHeader, RunActionButton quitRunView, RunActionButton resumeRunView, TextView tvRestMin, TextView tvRestMinUnit, TextView tvRestSec, TextView tvRestSecUnit, TextView tvRestTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11755a = clRest;
        this.f11752a = pauseHeader;
        this.f11754a = quitRunView;
        this.f11756b = resumeRunView;
        this.f35549a = tvRestMin;
        this.b = tvRestMinUnit;
        this.c = tvRestSec;
        this.d = tvRestSecUnit;
        this.e = tvRestTitle;
    }

    public static RunDialogPauseBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunDialogPauseBinding d(@NonNull View view, @Nullable Object component) {
        return (RunDialogPauseBinding) ViewDataBinding.bind(component, view, R.layout.run_dialog_pause);
    }

    @NonNull
    public static RunDialogPauseBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunDialogPauseBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunDialogPauseBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunDialogPauseBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_pause, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunDialogPauseBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunDialogPauseBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_pause, null, false, component);
    }

    @Nullable
    public SunshineRunVM f() {
        return this.f11753a;
    }

    public abstract void k(@Nullable SunshineRunVM vm);
}
