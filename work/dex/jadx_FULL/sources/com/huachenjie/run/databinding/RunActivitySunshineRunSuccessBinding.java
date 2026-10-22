package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessActivity;
import com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessVM;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivitySunshineRunSuccessBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11629a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11630a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11631a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Barrier f11632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f11634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRunSuccessActivity.a f11635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRunSuccessVM f11636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11637a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f11638b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11639b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final Barrier f11640b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f11641c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f11642d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f11643e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public RunActivitySunshineRunSuccessBinding(Object _bindingComponent, View _root, int _localFieldCount, Barrier barrierHeaderBottom, Barrier barrierHeaderEnd, FrameLayout flExpressAd, FrameLayout flFd, ImageView ivAwardArrow, ImageView ivBrand, ImageView ivMoodBtnBg, ImageView ivMoodBtnCoin, ImageView ivTrophy, BLLinearLayout llAwardInfo, LinearLayout llSportsPointMall, ConstraintLayout moodSubmitBtn, RecyclerView rvMood, TextView tvCalorie, TextView tvCongrats, TextView tvDistance, TextView tvDistanceLabel, TextView tvGoalReached, TextView tvMoodBtnReward, TextView tvMoodBtnText, TextView tvMoodQuestion, TextView tvSpeed) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11632a = barrierHeaderBottom;
        this.f11640b = barrierHeaderEnd;
        this.f35506a = flExpressAd;
        this.b = flFd;
        this.f11629a = ivAwardArrow;
        this.f11638b = ivBrand;
        this.c = ivMoodBtnBg;
        this.d = ivMoodBtnCoin;
        this.e = ivTrophy;
        this.f11637a = llAwardInfo;
        this.f11630a = llSportsPointMall;
        this.f11633a = moodSubmitBtn;
        this.f11634a = rvMood;
        this.f11631a = tvCalorie;
        this.f11639b = tvCongrats;
        this.f11641c = tvDistance;
        this.f11642d = tvDistanceLabel;
        this.f11643e = tvGoalReached;
        this.f = tvMoodBtnReward;
        this.g = tvMoodBtnText;
        this.h = tvMoodQuestion;
        this.i = tvSpeed;
    }

    public static RunActivitySunshineRunSuccessBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivitySunshineRunSuccessBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivitySunshineRunSuccessBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_sunshine_run_success);
    }

    @NonNull
    public static RunActivitySunshineRunSuccessBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivitySunshineRunSuccessBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivitySunshineRunSuccessBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivitySunshineRunSuccessBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_sunshine_run_success, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivitySunshineRunSuccessBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivitySunshineRunSuccessBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_sunshine_run_success, null, false, component);
    }

    @Nullable
    public SunshineRunSuccessActivity.a f() {
        return this.f11635a;
    }

    @Nullable
    public SunshineRunSuccessVM g() {
        return this.f11636a;
    }

    public abstract void l(@Nullable SunshineRunSuccessActivity.a click);

    public abstract void m(@Nullable SunshineRunSuccessVM vm);
}
