package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.progress.GradientRoundProgress;
import com.huachenjie.run.R;
import com.huachenjie.run.page.sun_run.SunshineRunVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutPauseHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35682a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12112a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12113a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final GradientRoundProgress f12114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRunVM f12115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f12118a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f12119b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLView f12120b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    public RunLayoutPauseHeaderBinding(Object _bindingComponent, View _root, int _localFieldCount, BLConstraintLayout clMetrics, ImageView ivMoreTarget, BLConstraintLayout llConditions, ConstraintLayout llMoreTarget, GradientRoundProgress progressRing, TextView tvCondDis, TextView tvCondSpeed, TextView tvCondTitle, TextView tvDistance, TextView tvDistanceLabel, TextView tvDurationLabel, TextView tvDurationValue, TextView tvMinKmLabel, TextView tvMinKmValue, TextView tvMoreTargetKm, TextView tvMoreTargetLabel, TextView tvPaceLabel, TextView tvPaceValue, BLTextView tvProgressPercent, BLView vHandle, BLView vMoreTargetBg) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f12116a = clMetrics;
        this.f35682a = ivMoreTarget;
        this.f12119b = llConditions;
        this.f12113a = llMoreTarget;
        this.f12114a = progressRing;
        this.f12112a = tvCondDis;
        this.b = tvCondSpeed;
        this.c = tvCondTitle;
        this.d = tvDistance;
        this.e = tvDistanceLabel;
        this.f = tvDurationLabel;
        this.g = tvDurationValue;
        this.h = tvMinKmLabel;
        this.i = tvMinKmValue;
        this.j = tvMoreTargetKm;
        this.k = tvMoreTargetLabel;
        this.l = tvPaceLabel;
        this.m = tvPaceValue;
        this.f12117a = tvProgressPercent;
        this.f12118a = vHandle;
        this.f12120b = vMoreTargetBg;
    }

    public static RunLayoutPauseHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutPauseHeaderBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutPauseHeaderBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_pause_header);
    }

    @NonNull
    public static RunLayoutPauseHeaderBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutPauseHeaderBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutPauseHeaderBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutPauseHeaderBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_pause_header, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutPauseHeaderBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutPauseHeaderBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_pause_header, null, false, component);
    }

    @Nullable
    public SunshineRunVM f() {
        return this.f12115a;
    }

    public abstract void k(@Nullable SunshineRunVM vm);
}
