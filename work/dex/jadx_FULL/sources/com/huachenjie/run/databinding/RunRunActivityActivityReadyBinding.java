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
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.activities_run.ActivityReadyActivity;
import com.huachenjie.run.page.activities_run.ActivityReadyVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunRunActivityActivityReadyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f12257a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ActivityReadyActivity.a f12258a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ActivityReadyVM f12259a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12260a;

    public RunRunActivityActivityReadyBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout flMapContainer, LayoutToolbarBindingBinding toolbar, BLTextView tvTargetDistance) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35732a = flMapContainer;
        this.f12257a = toolbar;
        this.f12260a = tvTargetDistance;
    }

    public static RunRunActivityActivityReadyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunRunActivityActivityReadyBinding d(@NonNull View view, @Nullable Object component) {
        return (RunRunActivityActivityReadyBinding) ViewDataBinding.bind(component, view, R.layout.run_run_activity_activity_ready);
    }

    @NonNull
    public static RunRunActivityActivityReadyBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunRunActivityActivityReadyBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunRunActivityActivityReadyBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunRunActivityActivityReadyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_run_activity_activity_ready, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunRunActivityActivityReadyBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunRunActivityActivityReadyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_run_activity_activity_ready, null, false, component);
    }

    @Nullable
    public ActivityReadyActivity.a f() {
        return this.f12258a;
    }

    @Nullable
    public ActivityReadyVM g() {
        return this.f12259a;
    }

    public abstract void l(@Nullable ActivityReadyActivity.a click);

    public abstract void m(@Nullable ActivityReadyVM vm);
}
