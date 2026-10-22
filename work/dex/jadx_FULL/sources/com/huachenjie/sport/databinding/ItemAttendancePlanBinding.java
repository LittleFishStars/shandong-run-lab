package com.huachenjie.sport.databinding;

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
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.AttendancePlanBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemAttendancePlanBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendancePlanBean f13540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f13541a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f13542b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13543b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Bindable
    public Integer f13544b;

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

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    public ItemAttendancePlanBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, View view2, View view3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        super(obj, view, i);
        this.f13538a = imageView;
        this.f13542b = imageView2;
        this.f36493a = view2;
        this.b = view3;
        this.f13539a = textView;
        this.f13543b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.g = textView7;
        this.h = textView8;
        this.i = textView9;
        this.j = textView10;
        this.k = textView11;
        this.l = textView12;
    }

    public static ItemAttendancePlanBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAttendancePlanBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemAttendancePlanBinding) ViewDataBinding.bind(obj, view, R.layout.item_attendance_plan);
    }

    @NonNull
    public static ItemAttendancePlanBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemAttendancePlanBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemAttendancePlanBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemAttendancePlanBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_attendance_plan, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemAttendancePlanBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemAttendancePlanBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_attendance_plan, null, false, obj);
    }

    @Nullable
    public Integer f() {
        return this.f13541a;
    }

    @Nullable
    public Integer g() {
        return this.f13544b;
    }

    @Nullable
    public AttendancePlanBean h() {
        return this.f13540a;
    }

    public abstract void m(@Nullable Integer num);

    public abstract void n(@Nullable Integer num);

    public abstract void o(@Nullable AttendancePlanBean attendancePlanBean);
}
