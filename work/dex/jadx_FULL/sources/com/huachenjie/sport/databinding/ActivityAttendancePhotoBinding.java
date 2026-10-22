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
import com.huachenjie.sport.page.mine.attendance.photo.AttendancePhotoActivity;
import com.huachenjie.sport.page.mine.attendance.photo.AttendancePhotoVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityAttendancePhotoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public AttendancePhotoActivity.a f36359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendancePhotoVM f13113a;

    public ActivityAttendancePhotoBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ActivityAttendancePhotoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAttendancePhotoBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityAttendancePhotoBinding) ViewDataBinding.bind(obj, view, R.layout.activity_attendance_photo);
    }

    @NonNull
    public static ActivityAttendancePhotoBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityAttendancePhotoBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAttendancePhotoBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAttendancePhotoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_attendance_photo, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityAttendancePhotoBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAttendancePhotoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_attendance_photo, null, false, obj);
    }

    @Nullable
    public AttendancePhotoActivity.a f() {
        return this.f36359a;
    }

    @Nullable
    public AttendancePhotoVM g() {
        return this.f13113a;
    }

    public abstract void l(@Nullable AttendancePhotoActivity.a aVar);

    public abstract void m(@Nullable AttendancePhotoVM attendancePhotoVM);
}
