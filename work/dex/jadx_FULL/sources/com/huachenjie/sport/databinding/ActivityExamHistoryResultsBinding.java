package com.huachenjie.sport.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.exam.ExamHistoryResultsVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ActivityExamHistoryResultsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36396a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f13224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExamHistoryResultsVM f13225a;

    public ActivityExamHistoryResultsBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f36396a = recyclerView;
    }

    public static ActivityExamHistoryResultsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityExamHistoryResultsBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityExamHistoryResultsBinding) ViewDataBinding.bind(obj, view, R.layout.activity_exam_history_results);
    }

    @NonNull
    public static ActivityExamHistoryResultsBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityExamHistoryResultsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityExamHistoryResultsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityExamHistoryResultsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exam_history_results, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityExamHistoryResultsBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityExamHistoryResultsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_exam_history_results, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f13224a;
    }

    @Nullable
    public ExamHistoryResultsVM g() {
        return this.f13225a;
    }

    public abstract void l(@Nullable ExamHistoryResultsVM examHistoryResultsVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
