package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.StrokeTextView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.rule.RuleV3Activity;
import com.huachenjie.run.page.rule.RuleV3VM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivitySchoolRuleV3Binding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11560a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StrokeTextView f11561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RuleV3Activity.a f11562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RuleV3VM f11563a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11564a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public RunActivitySchoolRuleV3Binding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivBack, TextView tvDayMaxDistance, TextView tvDisAndTimes, TextView tvDisAndTimesLabel, TextView tvDisMin, BLTextView tvHeaderSetting, TextView tvSchoolRuleHeaderTip, StrokeTextView tvSchoolRuleHeaderTitle, TextView tvWeekMaxDistance) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35494a = ivBack;
        this.f11560a = tvDayMaxDistance;
        this.b = tvDisAndTimes;
        this.c = tvDisAndTimesLabel;
        this.d = tvDisMin;
        this.f11564a = tvHeaderSetting;
        this.e = tvSchoolRuleHeaderTip;
        this.f11561a = tvSchoolRuleHeaderTitle;
        this.f = tvWeekMaxDistance;
    }

    public static RunActivitySchoolRuleV3Binding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivitySchoolRuleV3Binding d(@NonNull View view, @Nullable Object component) {
        return (RunActivitySchoolRuleV3Binding) ViewDataBinding.bind(component, view, R.layout.run_activity_school_rule_v3);
    }

    @NonNull
    public static RunActivitySchoolRuleV3Binding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivitySchoolRuleV3Binding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivitySchoolRuleV3Binding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivitySchoolRuleV3Binding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_school_rule_v3, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivitySchoolRuleV3Binding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivitySchoolRuleV3Binding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_school_rule_v3, null, false, component);
    }

    @Nullable
    public RuleV3Activity.a f() {
        return this.f11562a;
    }

    @Nullable
    public RuleV3VM g() {
        return this.f11563a;
    }

    public abstract void l(@Nullable RuleV3Activity.a click);

    public abstract void m(@Nullable RuleV3VM vm);
}
