package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.exam.ExamListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityExamListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LayoutToolbarBindingBinding f36399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f13232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonSearchView f13233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExamListVM f13234a;

    public ActivityExamListBinding(Object obj, View view, int i, CommonSearchView commonSearchView, StateLayout stateLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f13233a = commonSearchView;
        this.f13232a = stateLayout;
        this.f36399a = layoutToolbarBindingBinding;
    }

    public static ActivityExamListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityExamListBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityExamListBinding) ViewDataBinding.bind(obj, view, R.layout.activity_exam_list);
    }

    @NonNull
    public static ActivityExamListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityExamListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityExamListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityExamListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exam_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityExamListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityExamListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exam_list, null, false, obj);
    }

    @Nullable
    public ExamListVM f() {
        return this.f13234a;
    }

    public abstract void k(@Nullable ExamListVM examListVM);
}
