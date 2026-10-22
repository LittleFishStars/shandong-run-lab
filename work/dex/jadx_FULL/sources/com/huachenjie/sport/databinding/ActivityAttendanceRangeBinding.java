package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.amap.api.maps.MapView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.attendance.range.AttendanceRangeActivity;
import com.huachenjie.sport.page.mine.attendance.range.AttendanceRangeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityAttendanceRangeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final MapView f36366a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendanceRangeActivity.a f13131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendanceRangeVM f13132a;

    public ActivityAttendanceRangeBinding(Object obj, View view, int i, MapView mapView) {
        super(obj, view, i);
        this.f36366a = mapView;
    }

    public static ActivityAttendanceRangeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAttendanceRangeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityAttendanceRangeBinding) ViewDataBinding.bind(obj, view, R.layout.activity_attendance_range);
    }

    @NonNull
    public static ActivityAttendanceRangeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityAttendanceRangeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAttendanceRangeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAttendanceRangeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_attendance_range, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityAttendanceRangeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAttendanceRangeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_attendance_range, null, false, obj);
    }

    @Nullable
    public AttendanceRangeActivity.a f() {
        return this.f13131a;
    }

    @Nullable
    public AttendanceRangeVM g() {
        return this.f13132a;
    }

    public abstract void l(@Nullable AttendanceRangeActivity.a aVar);

    public abstract void m(@Nullable AttendanceRangeVM attendanceRangeVM);
}
