package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.AttendancePeriodView;
import com.huachenjie.common.bean.SignPeriod;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemAttendanceRuleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final AttendancePeriodView f36495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SignPeriod f13548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f13549a;

    @Bindable
    public Integer b;

    public ItemAttendanceRuleBinding(Object obj, View view, int i, AttendancePeriodView attendancePeriodView) {
        super(obj, view, i);
        this.f36495a = attendancePeriodView;
    }

    public static ItemAttendanceRuleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAttendanceRuleBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemAttendanceRuleBinding) ViewDataBinding.bind(obj, view, R.layout.item_attendance_rule);
    }

    @NonNull
    public static ItemAttendanceRuleBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemAttendanceRuleBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemAttendanceRuleBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemAttendanceRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_attendance_rule, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemAttendanceRuleBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemAttendanceRuleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_attendance_rule, null, false, obj);
    }

    @Nullable
    public Integer f() {
        return this.f13549a;
    }

    @Nullable
    public Integer g() {
        return this.b;
    }

    @Nullable
    public SignPeriod h() {
        return this.f13548a;
    }

    public abstract void m(@Nullable Integer num);

    public abstract void n(@Nullable Integer num);

    public abstract void o(@Nullable SignPeriod signPeriod);
}
