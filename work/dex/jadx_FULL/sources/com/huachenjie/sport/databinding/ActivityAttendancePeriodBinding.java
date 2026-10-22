package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.attendance.period.AttendancePeriodActivity;
import com.huachenjie.sport.page.mine.attendance.period.AttendancePeriodVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityAttendancePeriodBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public AttendancePeriodActivity.a f36357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendancePeriodVM f13106a;

    public ActivityAttendancePeriodBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ActivityAttendancePeriodBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAttendancePeriodBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityAttendancePeriodBinding) ViewDataBinding.bind(obj, view, R.layout.activity_attendance_period);
    }

    @NonNull
    public static ActivityAttendancePeriodBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityAttendancePeriodBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAttendancePeriodBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAttendancePeriodBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_attendance_period, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityAttendancePeriodBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAttendancePeriodBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_attendance_period, null, false, obj);
    }

    @Nullable
    public AttendancePeriodActivity.a f() {
        return this.f36357a;
    }

    @Nullable
    public AttendancePeriodVM g() {
        return this.f13106a;
    }

    public abstract void l(@Nullable AttendancePeriodActivity.a aVar);

    public abstract void m(@Nullable AttendancePeriodVM attendancePeriodVM);
}
