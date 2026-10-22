package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.run.R;
import com.huachenjie.run.page.geofence.RunModeGuideActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityRunModeGuideBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f35488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleViewModel f11540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunModeGuideActivity.a f11541a;

    public RunActivityRunModeGuideBinding(Object _bindingComponent, View _root, int _localFieldCount, LottieAnimationView lottie) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35488a = lottie;
    }

    public static RunActivityRunModeGuideBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityRunModeGuideBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityRunModeGuideBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_run_mode_guide);
    }

    @NonNull
    public static RunActivityRunModeGuideBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityRunModeGuideBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityRunModeGuideBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityRunModeGuideBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_run_mode_guide, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityRunModeGuideBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityRunModeGuideBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_run_mode_guide, null, false, component);
    }

    @Nullable
    public RunModeGuideActivity.a f() {
        return this.f11541a;
    }

    @Nullable
    public BaseTitleViewModel g() {
        return this.f11540a;
    }

    public abstract void l(@Nullable RunModeGuideActivity.a click);

    public abstract void m(@Nullable BaseTitleViewModel vm);
}
