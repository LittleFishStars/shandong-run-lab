package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.bean.ClockTime;
import com.huachenjie.sport.R;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemAttendancePeriodBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ClockTime f13528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13529a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f13530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f13531a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f13532b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLView f13533b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Bindable
    public Integer f13534b;

    public ItemAttendancePeriodBinding(Object obj, View view, int i, BLView bLView, BLView bLView2, TextView textView, BLTextView bLTextView, TextView textView2, BLTextView bLTextView2) {
        super(obj, view, i);
        this.f13530a = bLView;
        this.f13533b = bLView2;
        this.f36491a = textView;
        this.f13529a = bLTextView;
        this.b = textView2;
        this.f13532b = bLTextView2;
    }

    public static ItemAttendancePeriodBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAttendancePeriodBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemAttendancePeriodBinding) ViewDataBinding.bind(obj, view, R.layout.item_attendance_period);
    }

    @NonNull
    public static ItemAttendancePeriodBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemAttendancePeriodBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemAttendancePeriodBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemAttendancePeriodBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_attendance_period, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemAttendancePeriodBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemAttendancePeriodBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_attendance_period, null, false, obj);
    }

    @Nullable
    public Integer f() {
        return this.f13531a;
    }

    @Nullable
    public Integer g() {
        return this.f13534b;
    }

    @Nullable
    public ClockTime h() {
        return this.f13528a;
    }

    public abstract void m(@Nullable Integer num);

    public abstract void n(@Nullable Integer num);

    public abstract void o(@Nullable ClockTime clockTime);
}
