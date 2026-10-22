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
import androidx.constraintlayout.widget.Barrier;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.calendar.CalendarView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.attendance.AttendanceClickHandler;
import com.huachenjie.sport.page.mine.attendance.AttendanceSubVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmentAttendanceOutClassBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RelativeLayout f13440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Barrier f13442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CalendarView f13443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendanceClickHandler f13444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendanceSubVM f13445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f13446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f13447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13448a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f13449b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13450b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13451b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f13452b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f13453c;

    @NonNull
    public final ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f13454d;

    @NonNull
    public final ImageView e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f13455e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    public FragmentAttendanceOutClassBinding(Object obj, View view, int i, Barrier barrier, CalendarView calendarView, BLConstraintLayout bLConstraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view2, View view3, BLLinearLayout bLLinearLayout, LinearLayout linearLayout, ImageView imageView5, LinearLayout linearLayout2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, BLTextView bLTextView, TextView textView7, TextView textView8, TextView textView9, BLTextView bLTextView2) {
        super(obj, view, i);
        this.f13442a = barrier;
        this.f13443a = calendarView;
        this.f13446a = bLConstraintLayout;
        this.f13438a = imageView;
        this.f13449b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.f36463a = view2;
        this.b = view3;
        this.f13447a = bLLinearLayout;
        this.f13439a = linearLayout;
        this.e = imageView5;
        this.f13450b = linearLayout2;
        this.f13440a = relativeLayout;
        this.f13441a = textView;
        this.f13451b = textView2;
        this.f13453c = textView3;
        this.f13454d = textView4;
        this.f13455e = textView5;
        this.f = textView6;
        this.f13448a = bLTextView;
        this.g = textView7;
        this.h = textView8;
        this.i = textView9;
        this.f13452b = bLTextView2;
    }

    public static FragmentAttendanceOutClassBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentAttendanceOutClassBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentAttendanceOutClassBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_attendance_out_class);
    }

    @NonNull
    public static FragmentAttendanceOutClassBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentAttendanceOutClassBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentAttendanceOutClassBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentAttendanceOutClassBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_attendance_out_class, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentAttendanceOutClassBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentAttendanceOutClassBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_attendance_out_class, null, false, obj);
    }

    @Nullable
    public AttendanceClickHandler f() {
        return this.f13444a;
    }

    @Nullable
    public AttendanceSubVM g() {
        return this.f13445a;
    }

    public abstract void l(@Nullable AttendanceClickHandler attendanceClickHandler);

    public abstract void m(@Nullable AttendanceSubVM attendanceSubVM);
}
