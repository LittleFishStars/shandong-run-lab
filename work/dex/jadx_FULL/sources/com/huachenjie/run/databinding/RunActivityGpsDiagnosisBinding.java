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
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.activities_run.GPSDiagnosisVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityGpsDiagnosisBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f35470a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f11489a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GPSDiagnosisVM f11490a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11491b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public RunActivityGpsDiagnosisBinding(Object _bindingComponent, View _root, int _localFieldCount, LayoutToolbarBindingBinding toolbar, TextView tvAccuracy, TextView tvNum, TextView tvSpeed, TextView tvWay, TextView vSide, View vSideAfter, View vSideFront) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11489a = toolbar;
        this.f11488a = tvAccuracy;
        this.f11491b = tvNum;
        this.c = tvSpeed;
        this.d = tvWay;
        this.e = vSide;
        this.f35470a = vSideAfter;
        this.b = vSideFront;
    }

    public static RunActivityGpsDiagnosisBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityGpsDiagnosisBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityGpsDiagnosisBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_gps_diagnosis);
    }

    @NonNull
    public static RunActivityGpsDiagnosisBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityGpsDiagnosisBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityGpsDiagnosisBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityGpsDiagnosisBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_gps_diagnosis, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityGpsDiagnosisBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityGpsDiagnosisBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_gps_diagnosis, null, false, component);
    }

    @Nullable
    public GPSDiagnosisVM f() {
        return this.f11490a;
    }

    public abstract void k(@Nullable GPSDiagnosisVM vm);
}
