package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.huachenjie.run.widget.RunActionButton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutRunStatusSheetBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f35696a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutPauseHeaderBinding f12157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRunVM f12158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunActionButton f12159a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public RunLayoutRunStatusSheetBinding(Object _bindingComponent, View _root, int _localFieldCount, RunActionButton actionButton, LinearLayout llCollapsedHeader, RunLayoutPauseHeaderBinding pauseHeader, TextView tvDuration, TextView tvRunKm, TextView tvRunKmLabel, TextView tvTargetKm) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f12159a = actionButton;
        this.f35696a = llCollapsedHeader;
        this.f12157a = pauseHeader;
        this.f12156a = tvDuration;
        this.b = tvRunKm;
        this.c = tvRunKmLabel;
        this.d = tvTargetKm;
    }

    public static RunLayoutRunStatusSheetBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutRunStatusSheetBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutRunStatusSheetBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_run_status_sheet);
    }

    @NonNull
    public static RunLayoutRunStatusSheetBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutRunStatusSheetBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunStatusSheetBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutRunStatusSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_status_sheet, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunStatusSheetBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutRunStatusSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_status_sheet, null, false, component);
    }

    @Nullable
    public SunshineRunVM f() {
        return this.f12158a;
    }

    public abstract void k(@Nullable SunshineRunVM vm);
}
