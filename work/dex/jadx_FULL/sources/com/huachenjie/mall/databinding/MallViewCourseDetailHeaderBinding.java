package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.course_detail.CourseDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallViewCourseDetailHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CourseDetailVM f11017a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public MallViewCourseDetailHeaderBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f35077a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static MallViewCourseDetailHeaderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallViewCourseDetailHeaderBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallViewCourseDetailHeaderBinding) ViewDataBinding.bind(obj, view, R.layout.mall_view_course_detail_header);
    }

    @NonNull
    public static MallViewCourseDetailHeaderBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallViewCourseDetailHeaderBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallViewCourseDetailHeaderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallViewCourseDetailHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_course_detail_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallViewCourseDetailHeaderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallViewCourseDetailHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_view_course_detail_header, null, false, obj);
    }

    @Nullable
    public CourseDetailVM f() {
        return this.f11017a;
    }

    public abstract void k(@Nullable CourseDetailVM courseDetailVM);
}
