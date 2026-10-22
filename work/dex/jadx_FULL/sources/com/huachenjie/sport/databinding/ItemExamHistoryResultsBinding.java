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
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemExamHistoryResultsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13570a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExamDetailData f13571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f13572a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public ItemExamHistoryResultsBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, BLTextView bLTextView, TextView textView4, TextView textView5, View view2) {
        super(obj, view, i);
        this.f13570a = constraintLayout;
        this.f13568a = linearLayout;
        this.f13569a = textView;
        this.b = textView2;
        this.c = textView3;
        this.f13572a = bLTextView;
        this.d = textView4;
        this.e = textView5;
        this.f36501a = view2;
    }

    public static ItemExamHistoryResultsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemExamHistoryResultsBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemExamHistoryResultsBinding) ViewDataBinding.bind(obj, view, R.layout.item_exam_history_results);
    }

    @NonNull
    public static ItemExamHistoryResultsBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemExamHistoryResultsBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemExamHistoryResultsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemExamHistoryResultsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_history_results, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemExamHistoryResultsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemExamHistoryResultsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_exam_history_results, null, false, obj);
    }

    @Nullable
    public ExamDetailData f() {
        return this.f13571a;
    }

    public abstract void k(@Nullable ExamDetailData examDetailData);
}
