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
import com.huachenjie.sport.bean.ExamListData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemExamListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13585a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExamListData f13586a;

    @NonNull
    public final ImageView b;

    public ItemExamListBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, View view2) {
        super(obj, view, i);
        this.f13584a = imageView;
        this.b = imageView2;
        this.f13585a = textView;
        this.f36505a = view2;
    }

    public static ItemExamListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemExamListBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemExamListBinding) ViewDataBinding.bind(obj, view, R.layout.item_exam_list);
    }

    @NonNull
    public static ItemExamListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemExamListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemExamListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemExamListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemExamListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemExamListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_list, null, false, obj);
    }

    @Nullable
    public ExamListData f() {
        return this.f13586a;
    }

    public abstract void k(@Nullable ExamListData examListData);
}
