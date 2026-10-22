package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_detail.RunDetailActivity;
import com.huachenjie.run.page.run_detail.RunDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final NestedScrollView f11445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutMetricsBinding f11446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutPaceListBinding f11447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutRunFaceDetectBinding f11448a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutRunFaceMachineBinding f11449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutRunRecordStatusBinding f11450a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutRunVisionBinding f11451a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutStaticsBinding f11452a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutStepListBinding f11453a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailActivity.a f11454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailVM f11455a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f11456b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11457b;

    public RunActivityDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout flMapContainer, ImageView ivBack, ImageView ivShare, RunLayoutRunFaceDetectBinding layoutFaceDetect, RunLayoutRunFaceMachineBinding layoutFaceMachine, RunLayoutMetricsBinding layoutMetrics, RunLayoutPaceListBinding layoutPace, RunLayoutStaticsBinding layoutStatics, RunLayoutRunRecordStatusBinding layoutStatusLog, RunLayoutStepListBinding layoutStep, RunLayoutRunVisionBinding layoutVision, LinearLayout llContent, LinearLayout llListEnd, NestedScrollView nsv, FrameLayout titleBar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35454a = flMapContainer;
        this.f11443a = ivBack;
        this.f11456b = ivShare;
        this.f11448a = layoutFaceDetect;
        this.f11449a = layoutFaceMachine;
        this.f11446a = layoutMetrics;
        this.f11447a = layoutPace;
        this.f11452a = layoutStatics;
        this.f11450a = layoutStatusLog;
        this.f11453a = layoutStep;
        this.f11451a = layoutVision;
        this.f11444a = llContent;
        this.f11457b = llListEnd;
        this.f11445a = nsv;
        this.b = titleBar;
    }

    public static RunActivityDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityDetailBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityDetailBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_detail);
    }

    @NonNull
    public static RunActivityDetailBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityDetailBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityDetailBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_detail, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityDetailBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_detail, null, false, component);
    }

    @Nullable
    public RunDetailActivity.a f() {
        return this.f11454a;
    }

    @Nullable
    public RunDetailVM g() {
        return this.f11455a;
    }

    public abstract void l(@Nullable RunDetailActivity.a click);

    public abstract void m(@Nullable RunDetailVM vm);
}
