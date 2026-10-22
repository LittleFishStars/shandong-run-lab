package com.huachenjie.college.databinding;

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
import com.huachenjie.college.R;
import com.huachenjie.college.page.point_activity.PointActivityListVM;
import com.huachenjie.common.page.statelayout.StateLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class CollegeActivityPointActivityListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f8369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PointActivityListVM f8370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f8371a;

    public CollegeActivityPointActivityListBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f33561a = recyclerView;
        this.f8371a = stateLayout;
    }

    public static CollegeActivityPointActivityListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CollegeActivityPointActivityListBinding d(@NonNull View view, @Nullable Object obj) {
        return (CollegeActivityPointActivityListBinding) ViewDataBinding.bind(obj, view, R.layout.college_activity_point_activity_list);
    }

    @NonNull
    public static CollegeActivityPointActivityListBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static CollegeActivityPointActivityListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static CollegeActivityPointActivityListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (CollegeActivityPointActivityListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_activity_point_activity_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static CollegeActivityPointActivityListBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (CollegeActivityPointActivityListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.college_activity_point_activity_list, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f8369a;
    }

    @Nullable
    public PointActivityListVM g() {
        return this.f8370a;
    }

    public abstract void l(@Nullable PointActivityListVM pointActivityListVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
