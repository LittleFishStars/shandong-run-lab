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
import androidx.recyclerview.widget.GridLayoutManager;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.exam.ExamAnswerSheetVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogBottomExamAnswerSheetBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GridLayoutManager f13386a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExamAnswerSheetVM f13387a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public DialogBottomExamAnswerSheetBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f36443a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    public static DialogBottomExamAnswerSheetBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBottomExamAnswerSheetBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogBottomExamAnswerSheetBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_bottom_exam_answer_sheet);
    }

    @NonNull
    public static DialogBottomExamAnswerSheetBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogBottomExamAnswerSheetBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogBottomExamAnswerSheetBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogBottomExamAnswerSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_bottom_exam_answer_sheet, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogBottomExamAnswerSheetBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogBottomExamAnswerSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_bottom_exam_answer_sheet, null, false, obj);
    }

    @Nullable
    public GridLayoutManager f() {
        return this.f13386a;
    }

    @Nullable
    public ExamAnswerSheetVM g() {
        return this.f13387a;
    }

    public abstract void l(@Nullable GridLayoutManager gridLayoutManager);

    public abstract void m(@Nullable ExamAnswerSheetVM examAnswerSheetVM);
}
