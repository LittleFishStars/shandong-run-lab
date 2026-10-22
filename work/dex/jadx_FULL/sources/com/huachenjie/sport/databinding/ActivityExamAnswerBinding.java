package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.exam.ExamAnswerActivity;
import com.huachenjie.sport.page.mine.exam.ExamAnswerVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityExamAnswerBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13202a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13203a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13204a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ViewPager2.OnPageChangeCallback f13205a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager2 f13206a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExamAnswerActivity.c f13207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExamAnswerVM f13208a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f13209b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13210b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public ActivityExamAnswerBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, View view2, View view3, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f13204a = constraintLayout;
        this.f13202a = imageView;
        this.f13209b = imageView2;
        this.f13203a = textView;
        this.f13210b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.f36390a = view2;
        this.b = view3;
        this.f13206a = viewPager2;
    }

    public static ActivityExamAnswerBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityExamAnswerBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityExamAnswerBinding) ViewDataBinding.bind(obj, view, R.layout.activity_exam_answer);
    }

    @NonNull
    public static ActivityExamAnswerBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityExamAnswerBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityExamAnswerBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityExamAnswerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exam_answer, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityExamAnswerBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityExamAnswerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exam_answer, null, false, obj);
    }

    @Nullable
    public ExamAnswerActivity.c f() {
        return this.f13207a;
    }

    @Nullable
    public ExamAnswerVM g() {
        return this.f13208a;
    }

    @Nullable
    public ViewPager2.OnPageChangeCallback h() {
        return this.f13205a;
    }

    public abstract void m(@Nullable ExamAnswerActivity.c cVar);

    public abstract void n(@Nullable ExamAnswerVM examAnswerVM);

    public abstract void o(@Nullable ViewPager2.OnPageChangeCallback onPageChangeCallback);
}
