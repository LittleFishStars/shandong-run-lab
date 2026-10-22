package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.ShadowFrameLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.page.sun_run.SunshineRunActivity;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.huachenjie.run.widget.AutoPauseView;
import com.huachenjie.run.widget.PaceErrorView;
import com.huachenjie.run.widget.RunActionButton;
import com.huachenjie.run.widget.RunStatusBottomSheet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivitySunshineRunBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowFrameLayout f11615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutSunRunQualifyConditionsBinding f11616a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutSunRunSideToolbarBinding f11617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRunActivity.a f11618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRunVM f11619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AutoPauseView f11620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PaceErrorView f11621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunActionButton f11622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunStatusBottomSheet f11623a;

    public RunActivitySunshineRunBinding(Object _bindingComponent, View _root, int _localFieldCount, AutoPauseView autoPauseView, FrameLayout mapContainer, PaceErrorView paceErrorView, RunLayoutSunRunQualifyConditionsBinding qualifyConditions, RunActionButton quitRunView, RunStatusBottomSheet runStatusSheet, RunLayoutSunRunSideToolbarBinding sideToolbar, ShadowFrameLayout tvCreditSwordTip) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11620a = autoPauseView;
        this.f35504a = mapContainer;
        this.f11621a = paceErrorView;
        this.f11616a = qualifyConditions;
        this.f11622a = quitRunView;
        this.f11623a = runStatusSheet;
        this.f11617a = sideToolbar;
        this.f11615a = tvCreditSwordTip;
    }

    public static RunActivitySunshineRunBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivitySunshineRunBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivitySunshineRunBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_sunshine_run);
    }

    @NonNull
    public static RunActivitySunshineRunBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivitySunshineRunBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivitySunshineRunBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivitySunshineRunBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_sunshine_run, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivitySunshineRunBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivitySunshineRunBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_sunshine_run, null, false, component);
    }

    @Nullable
    public SunshineRunActivity.a f() {
        return this.f11618a;
    }

    @Nullable
    public SunshineRunVM g() {
        return this.f11619a;
    }

    public abstract void l(@Nullable SunshineRunActivity.a click);

    public abstract void m(@Nullable SunshineRunVM vm);
}
