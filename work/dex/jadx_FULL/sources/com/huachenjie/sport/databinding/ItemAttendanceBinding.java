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
import com.huachenjie.sport.bean.AttendanceRecordBean;
import com.huachenjie.sport.page.mine.attendance.AttendanceAdapter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemAttendanceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendanceRecordBean f13520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AttendanceAdapter.a f13521a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13522b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public ItemAttendanceBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.f36488a = imageView;
        this.b = imageView2;
        this.f13519a = textView;
        this.f13522b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
    }

    public static ItemAttendanceBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAttendanceBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemAttendanceBinding) ViewDataBinding.bind(obj, view, R.layout.item_attendance);
    }

    @NonNull
    public static ItemAttendanceBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemAttendanceBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemAttendanceBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemAttendanceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_attendance, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemAttendanceBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemAttendanceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_attendance, null, false, obj);
    }

    @Nullable
    public AttendanceAdapter.a f() {
        return this.f13521a;
    }

    @Nullable
    public AttendanceRecordBean g() {
        return this.f13520a;
    }

    public abstract void l(@Nullable AttendanceAdapter.a aVar);

    public abstract void m(@Nullable AttendanceRecordBean attendanceRecordBean);
}
