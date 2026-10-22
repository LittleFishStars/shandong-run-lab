package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.attendance.rule.AttendanceRuleActivity;
import com.huachenjie.sport.page.mine.attendance.rule.AttendanceRuleVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityAttendanceRuleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13140a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13141a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f13142a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendanceRuleActivity.a f13143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendanceRuleVM f13144a;

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

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public ActivityAttendanceRuleBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, RoundImageView roundImageView, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        super(obj, view, i);
        this.f13141a = constraintLayout;
        this.f13142a = roundImageView;
        this.f36370a = view2;
        this.f13140a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.g = textView7;
        this.h = textView8;
        this.i = textView9;
    }

    public static ActivityAttendanceRuleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAttendanceRuleBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityAttendanceRuleBinding) ViewDataBinding.bind(obj, view, R.layout.activity_attendance_rule);
    }

    @NonNull
    public static ActivityAttendanceRuleBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityAttendanceRuleBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAttendanceRuleBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAttendanceRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_attendance_rule, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityAttendanceRuleBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAttendanceRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_attendance_rule, null, false, obj);
    }

    @Nullable
    public AttendanceRuleActivity.a f() {
        return this.f13143a;
    }

    @Nullable
    public AttendanceRuleVM g() {
        return this.f13144a;
    }

    public abstract void l(@Nullable AttendanceRuleActivity.a aVar);

    public abstract void m(@Nullable AttendanceRuleVM attendanceRuleVM);
}
