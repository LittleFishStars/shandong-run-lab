package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.activities_run.dialog.DanmuDialog;
import com.huachenjie.run.page.activities_run.dialog.DanmuDialogVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunDialogDanmuBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f35524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DanmuDialog.a f11688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DanmuDialogVM f11689a;

    public RunDialogDanmuBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35524a = recyclerView;
    }

    public static RunDialogDanmuBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunDialogDanmuBinding d(@NonNull View view, @Nullable Object component) {
        return (RunDialogDanmuBinding) ViewDataBinding.bind(component, view, R.layout.run_dialog_danmu);
    }

    @NonNull
    public static RunDialogDanmuBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunDialogDanmuBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunDialogDanmuBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunDialogDanmuBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_danmu, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunDialogDanmuBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunDialogDanmuBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_danmu, null, false, component);
    }

    @Nullable
    public DanmuDialog.a f() {
        return this.f11688a;
    }

    @Nullable
    public DanmuDialogVM g() {
        return this.f11689a;
    }

    public abstract void l(@Nullable DanmuDialog.a click);

    public abstract void m(@Nullable DanmuDialogVM vm);
}
