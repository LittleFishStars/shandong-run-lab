package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.video.AliVideoView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.course_detail.CourseDetailActivity;
import com.huachenjie.mall.page.course_detail.CourseDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityCourseDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10183a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AliVideoView f10184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CourseDetailActivity.a f10185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CourseDetailVM f10186a;

    public MallActivityCourseDetailBinding(Object obj, View view, int i, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding, AliVideoView aliVideoView) {
        super(obj, view, i);
        this.f34785a = recyclerView;
        this.f10183a = layoutToolbarBindingBinding;
        this.f10184a = aliVideoView;
    }

    public static MallActivityCourseDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityCourseDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityCourseDetailBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_course_detail);
    }

    @NonNull
    public static MallActivityCourseDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityCourseDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityCourseDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityCourseDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_course_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityCourseDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityCourseDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_course_detail, null, false, obj);
    }

    @Nullable
    public CourseDetailActivity.a f() {
        return this.f10185a;
    }

    @Nullable
    public CourseDetailVM g() {
        return this.f10186a;
    }

    public abstract void l(@Nullable CourseDetailActivity.a aVar);

    public abstract void m(@Nullable CourseDetailVM courseDetailVM);
}
