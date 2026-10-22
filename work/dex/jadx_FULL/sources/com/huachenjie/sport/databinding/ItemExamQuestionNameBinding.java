package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemExamQuestionNameBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36511a;

    @Bindable
    public String f;

    public ItemExamQuestionNameBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f36511a = textView;
    }

    public static ItemExamQuestionNameBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemExamQuestionNameBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemExamQuestionNameBinding) ViewDataBinding.bind(obj, view, R.layout.item_exam_question_name);
    }

    @NonNull
    public static ItemExamQuestionNameBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemExamQuestionNameBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemExamQuestionNameBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemExamQuestionNameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_question_name, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemExamQuestionNameBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemExamQuestionNameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_question_name, null, false, obj);
    }

    @Nullable
    public String getData() {
        return this.f;
    }

    public abstract void i(@Nullable String str);
}
