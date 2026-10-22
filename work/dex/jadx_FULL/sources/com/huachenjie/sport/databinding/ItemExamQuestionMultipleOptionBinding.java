package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.CheckImageView;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemExamQuestionMultipleOptionBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckImageView f36509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f13596a;

    @Bindable
    public String f;

    public ItemExamQuestionMultipleOptionBinding(Object obj, View view, int i, CheckImageView checkImageView) {
        super(obj, view, i);
        this.f36509a = checkImageView;
    }

    public static ItemExamQuestionMultipleOptionBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemExamQuestionMultipleOptionBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemExamQuestionMultipleOptionBinding) ViewDataBinding.bind(obj, view, R.layout.item_exam_question_multiple_option);
    }

    @NonNull
    public static ItemExamQuestionMultipleOptionBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemExamQuestionMultipleOptionBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemExamQuestionMultipleOptionBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemExamQuestionMultipleOptionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_question_multiple_option, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemExamQuestionMultipleOptionBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemExamQuestionMultipleOptionBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_question_multiple_option, null, false, obj);
    }

    @Nullable
    public Boolean f() {
        return this.f13596a;
    }

    @Nullable
    public String getData() {
        return this.f;
    }

    public abstract void k(@Nullable String str);

    public abstract void setChecked(@Nullable Boolean bool);
}
