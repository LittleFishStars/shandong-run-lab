package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_index.RunIndexActivity;
import com.huachenjie.run.page.run_index.RunIndexVM;
import com.huachenjie.run.widget.GoalProgressView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutIndexHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f12059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f12060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12061a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f12062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunIndexActivity.a f12063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunIndexVM f12064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final GoalProgressView f12065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f12067a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f12068b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12069b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12070b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f12071b;

    @NonNull
    public final TextView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f12072c;

    public RunLayoutIndexHeaderBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout clActivityRun, ConstraintLayout clGoalCard, GoalProgressView goalProgress, ImageView ivActivityRunBg, ImageView ivGoalBg, LinearLayout llGoalKm, BLLinearLayout llMedalFreeBar, ConstraintLayout llPlanRow, BLLinearLayout llStaticsInfo, RecyclerView rvDeduction, BLTextView tvActivityRunEnter, TextView tvProgressLabel, TextView tvRunPlanName, TextView tvSchoolName, BLTextView tvSwitchRunPlan) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f12061a = clActivityRun;
        this.f12069b = clGoalCard;
        this.f12065a = goalProgress;
        this.f35664a = ivActivityRunBg;
        this.b = ivGoalBg;
        this.f12059a = llGoalKm;
        this.f12066a = llMedalFreeBar;
        this.f12072c = llPlanRow;
        this.f12070b = llStaticsInfo;
        this.f12062a = rvDeduction;
        this.f12067a = tvActivityRunEnter;
        this.f12060a = tvProgressLabel;
        this.f12068b = tvRunPlanName;
        this.c = tvSchoolName;
        this.f12071b = tvSwitchRunPlan;
    }

    public static RunLayoutIndexHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutIndexHeaderBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutIndexHeaderBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_index_header);
    }

    @NonNull
    public static RunLayoutIndexHeaderBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutIndexHeaderBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutIndexHeaderBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutIndexHeaderBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_index_header, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutIndexHeaderBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutIndexHeaderBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_index_header, null, false, component);
    }

    @Nullable
    public RunIndexActivity.a f() {
        return this.f12063a;
    }

    @Nullable
    public RunIndexVM g() {
        return this.f12064a;
    }

    public abstract void l(@Nullable RunIndexActivity.a click);

    public abstract void m(@Nullable RunIndexVM vm);
}
