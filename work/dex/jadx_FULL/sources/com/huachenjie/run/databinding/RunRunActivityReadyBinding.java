package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.activities_run.ReadyActivity;
import com.huachenjie.run.page.activities_run.ReadyVM;
import com.huachenjie.run.widget.DisplayOnlyDanMuView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunRunActivityReadyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35735a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f12266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f12268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ReadyActivity.ClickProxy f12269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ReadyVM f12270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DisplayOnlyDanMuView f12271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f12274a;

    @NonNull
    public final FrameLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12275b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12276b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLView f12277b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public RunRunActivityReadyBinding(Object _bindingComponent, View _root, int _localFieldCount, LayoutToolbarBindingBinding clTitle, DisplayOnlyDanMuView danMuView, FrameLayout flFd, FrameLayout flMapContainer, ImageView ivGo, BLLinearLayout llGoalCard, BLLinearLayout llStatsCard, BLTextView tvGoalTip, TextView tvGoalValue, TextView tvNfcCheckIn, TextView tvRunningCount, TextView tvSendDanmu, TextView tvTotalDistance, BLView vBottomGradient, BLView vTopGradient) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f12268a = clTitle;
        this.f12271a = danMuView;
        this.f35735a = flFd;
        this.b = flMapContainer;
        this.f12266a = ivGo;
        this.f12272a = llGoalCard;
        this.f12276b = llStatsCard;
        this.f12273a = tvGoalTip;
        this.f12267a = tvGoalValue;
        this.f12275b = tvNfcCheckIn;
        this.c = tvRunningCount;
        this.d = tvSendDanmu;
        this.e = tvTotalDistance;
        this.f12274a = vBottomGradient;
        this.f12277b = vTopGradient;
    }

    public static RunRunActivityReadyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunRunActivityReadyBinding d(@NonNull View view, @Nullable Object component) {
        return (RunRunActivityReadyBinding) ViewDataBinding.bind(component, view, R.layout.run_run_activity_ready);
    }

    @NonNull
    public static RunRunActivityReadyBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunRunActivityReadyBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunRunActivityReadyBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunRunActivityReadyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_run_activity_ready, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunRunActivityReadyBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunRunActivityReadyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_run_activity_ready, null, false, component);
    }

    @Nullable
    public ReadyActivity.ClickProxy f() {
        return this.f12269a;
    }

    @Nullable
    public ReadyVM g() {
        return this.f12270a;
    }

    public abstract void l(@Nullable ReadyActivity.ClickProxy click);

    public abstract void m(@Nullable ReadyVM vm);
}
