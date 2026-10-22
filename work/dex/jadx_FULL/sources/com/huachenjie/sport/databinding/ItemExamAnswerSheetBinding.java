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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemExamAnswerSheetBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public Boolean f36499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f13563a;

    public ItemExamAnswerSheetBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ItemExamAnswerSheetBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemExamAnswerSheetBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemExamAnswerSheetBinding) ViewDataBinding.bind(obj, view, R.layout.item_exam_answer_sheet);
    }

    @NonNull
    public static ItemExamAnswerSheetBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemExamAnswerSheetBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemExamAnswerSheetBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemExamAnswerSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_answer_sheet, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemExamAnswerSheetBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemExamAnswerSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_answer_sheet, null, false, obj);
    }

    @Nullable
    public Boolean f() {
        return this.f36499a;
    }

    @Nullable
    public Integer g() {
        return this.f13563a;
    }

    public abstract void l(@Nullable Integer num);

    public abstract void setChecked(@Nullable Boolean bool);
}
