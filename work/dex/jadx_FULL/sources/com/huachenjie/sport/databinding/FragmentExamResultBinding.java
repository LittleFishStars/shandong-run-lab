package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.ExamDetailData;
import com.huachenjie.sport.page.mine.exam.ExamDetailActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmentExamResultBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36477a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13482a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13483a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExamDetailData f13484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExamDetailActivity.a f13485a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13486b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public FragmentExamResultBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2) {
        super(obj, view, i);
        this.f13483a = constraintLayout;
        this.f13481a = linearLayout;
        this.b = linearLayout2;
        this.f13482a = textView;
        this.f13486b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.f36477a = view2;
    }

    public static FragmentExamResultBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamResultBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentExamResultBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_exam_result);
    }

    @NonNull
    public static FragmentExamResultBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentExamResultBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentExamResultBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentExamResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_exam_result, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentExamResultBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentExamResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_exam_result, null, false, obj);
    }

    @Nullable
    public ExamDetailActivity.a f() {
        return this.f13485a;
    }

    @Nullable
    public ExamDetailData g() {
        return this.f13484a;
    }

    public abstract void l(@Nullable ExamDetailActivity.a aVar);

    public abstract void m(@Nullable ExamDetailData examDetailData);
}
