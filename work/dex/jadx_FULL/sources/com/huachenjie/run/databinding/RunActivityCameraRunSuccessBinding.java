package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.run.R;
import com.huachenjie.run.page.sun_run.success.CameraRunSuccessActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityCameraRunSuccessBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleViewModel f11434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CameraRunSuccessActivity.a f11435a;

    @NonNull
    public final FrameLayout b;

    public RunActivityCameraRunSuccessBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout flExpressAd, FrameLayout flFd, TextView tvTip) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35451a = flExpressAd;
        this.b = flFd;
        this.f11433a = tvTip;
    }

    public static RunActivityCameraRunSuccessBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityCameraRunSuccessBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityCameraRunSuccessBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_camera_run_success);
    }

    @NonNull
    public static RunActivityCameraRunSuccessBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityCameraRunSuccessBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityCameraRunSuccessBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityCameraRunSuccessBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_camera_run_success, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityCameraRunSuccessBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityCameraRunSuccessBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_camera_run_success, null, false, component);
    }

    @Nullable
    public CameraRunSuccessActivity.a f() {
        return this.f11435a;
    }

    @Nullable
    public BaseTitleViewModel g() {
        return this.f11434a;
    }

    public abstract void l(@Nullable CameraRunSuccessActivity.a click);

    public abstract void m(@Nullable BaseTitleViewModel vm);
}
