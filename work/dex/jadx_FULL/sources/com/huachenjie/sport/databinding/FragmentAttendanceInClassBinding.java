package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.calendar.CalendarView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.attendance.AttendanceClickHandler;
import com.huachenjie.sport.page.mine.attendance.AttendanceSubVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmentAttendanceInClassBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36458a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f13422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13423a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CalendarView f13424a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendanceClickHandler f13425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendanceSubVM f13426a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f13427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13428a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f13429b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13430b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f13431c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public FragmentAttendanceInClassBinding(Object obj, View view, int i, CalendarView calendarView, ImageView imageView, ImageView imageView2, ImageView imageView3, View view2, View view3, BLLinearLayout bLLinearLayout, LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, BLTextView bLTextView) {
        super(obj, view, i);
        this.f13424a = calendarView;
        this.f13420a = imageView;
        this.f13429b = imageView2;
        this.c = imageView3;
        this.f36458a = view2;
        this.b = view3;
        this.f13427a = bLLinearLayout;
        this.f13421a = linearLayout;
        this.f13422a = relativeLayout;
        this.f13423a = textView;
        this.f13430b = textView2;
        this.f13431c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.f13428a = bLTextView;
    }

    public static FragmentAttendanceInClassBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAttendanceInClassBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentAttendanceInClassBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_attendance_in_class);
    }

    @NonNull
    public static FragmentAttendanceInClassBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentAttendanceInClassBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentAttendanceInClassBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentAttendanceInClassBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_attendance_in_class, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentAttendanceInClassBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentAttendanceInClassBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_attendance_in_class, null, false, obj);
    }

    @Nullable
    public AttendanceClickHandler f() {
        return this.f13425a;
    }

    @Nullable
    public AttendanceSubVM g() {
        return this.f13426a;
    }

    public abstract void l(@Nullable AttendanceClickHandler attendanceClickHandler);

    public abstract void m(@Nullable AttendanceSubVM attendanceSubVM);
}
