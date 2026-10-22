package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.flyco.tablayout.CommonTabLayout;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.attendance.AttendanceActivity;
import com.huachenjie.sport.page.mine.attendance.AttendanceVM;
import com.noober.background.view.BLFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityAttendanceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f36351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonTabLayout f13093a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f13094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendanceActivity.a f13095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendanceVM f13096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f13097a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    public ActivityAttendanceBinding(Object obj, View view, int i, FrameLayout frameLayout, AvatarView avatarView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, CommonTabLayout commonTabLayout, BLFrameLayout bLFrameLayout) {
        super(obj, view, i);
        this.f36351a = frameLayout;
        this.f13094a = avatarView;
        this.f13092a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.f13093a = commonTabLayout;
        this.f13097a = bLFrameLayout;
    }

    public static ActivityAttendanceBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAttendanceBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityAttendanceBinding) ViewDataBinding.bind(obj, view, R.layout.activity_attendance);
    }

    @NonNull
    public static ActivityAttendanceBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityAttendanceBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAttendanceBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAttendanceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_attendance, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityAttendanceBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAttendanceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_attendance, null, false, obj);
    }

    @Nullable
    public AttendanceActivity.a f() {
        return this.f13095a;
    }

    @Nullable
    public AttendanceVM g() {
        return this.f13096a;
    }

    public abstract void l(@Nullable AttendanceActivity.a aVar);

    public abstract void m(@Nullable AttendanceVM attendanceVM);
}
