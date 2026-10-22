package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.exam.ExamDetailActivity;
import com.huachenjie.sport.page.mine.exam.ExamDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityExamDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ExamDetailActivity.a f36394a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExamDetailVM f13217a;

    public ActivityExamDetailBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ActivityExamDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityExamDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityExamDetailBinding) ViewDataBinding.bind(obj, view, R.layout.activity_exam_detail);
    }

    @NonNull
    public static ActivityExamDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityExamDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityExamDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityExamDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exam_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityExamDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityExamDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exam_detail, null, false, obj);
    }

    @Nullable
    public ExamDetailActivity.a f() {
        return this.f36394a;
    }

    @Nullable
    public ExamDetailVM g() {
        return this.f13217a;
    }

    public abstract void l(@Nullable ExamDetailActivity.a aVar);

    public abstract void m(@Nullable ExamDetailVM examDetailVM);
}
