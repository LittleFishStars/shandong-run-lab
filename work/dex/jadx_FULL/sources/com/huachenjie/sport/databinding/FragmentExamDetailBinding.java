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
import com.huachenjie.sport.bean.ExamDetailData;
import com.huachenjie.sport.page.mine.exam.ExamDetailActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class FragmentExamDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36474a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExamDetailData f13472a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExamDetailActivity.a f13473a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13474b;

    @NonNull
    public final TextView c;

    public FragmentExamDetailBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f36474a = imageView;
        this.b = imageView2;
        this.f13471a = textView;
        this.f13474b = textView2;
        this.c = textView3;
    }

    public static FragmentExamDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentExamDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (FragmentExamDetailBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_exam_detail);
    }

    @NonNull
    public static FragmentExamDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FragmentExamDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentExamDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentExamDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_exam_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static FragmentExamDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentExamDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_exam_detail, null, false, obj);
    }

    @Nullable
    public ExamDetailActivity.a f() {
        return this.f13473a;
    }

    @Nullable
    public ExamDetailData g() {
        return this.f13472a;
    }

    public abstract void l(@Nullable ExamDetailActivity.a aVar);

    public abstract void m(@Nullable ExamDetailData examDetailData);
}
