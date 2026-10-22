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
import com.huachenjie.sport.page.mine.exam.ExamQuestionAdapter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemExamQuestionBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ExamQuestionAdapter f36507a;

    public ItemExamQuestionBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ItemExamQuestionBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemExamQuestionBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemExamQuestionBinding) ViewDataBinding.bind(obj, view, R.layout.item_exam_question);
    }

    @NonNull
    public static ItemExamQuestionBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemExamQuestionBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemExamQuestionBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemExamQuestionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_question, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemExamQuestionBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemExamQuestionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_question, null, false, obj);
    }

    @Nullable
    public ExamQuestionAdapter f() {
        return this.f36507a;
    }

    public abstract void k(@Nullable ExamQuestionAdapter examQuestionAdapter);
}
