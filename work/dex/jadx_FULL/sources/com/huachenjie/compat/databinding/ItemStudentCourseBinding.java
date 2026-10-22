package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.bean.CourseInfo;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ItemStudentCourseBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CourseInfo f9211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9212a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public ItemStudentCourseBinding(Object obj, View view, int i, BLTextView bLTextView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f9212a = bLTextView;
        this.f34071a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    public static ItemStudentCourseBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemStudentCourseBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemStudentCourseBinding) ViewDataBinding.bind(obj, view, R.layout.item_student_course);
    }

    @NonNull
    public static ItemStudentCourseBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemStudentCourseBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemStudentCourseBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemStudentCourseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_student_course, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemStudentCourseBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemStudentCourseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_student_course, null, false, obj);
    }

    @Nullable
    public CourseInfo f() {
        return this.f9211a;
    }

    public abstract void k(@Nullable CourseInfo courseInfo);
}
