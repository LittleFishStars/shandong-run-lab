package com.huachenjie.works.databinding;

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
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.school.ThisSchoolFragment;
import com.huachenjie.works.page.alumni.school.ThisSchoolVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentThisSchoolBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f14341a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f14342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ThisSchoolFragment.ClickProxy f14343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ThisSchoolVM f14344a;

    public WorksFragmentThisSchoolBinding(Object _bindingComponent, View _root, int _localFieldCount, SwipeRefreshLayout refreshLayout, RecyclerView rvList, View vStatusSpace) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14342a = refreshLayout;
        this.f14340a = rvList;
        this.f36962a = vStatusSpace;
    }

    public static WorksFragmentThisSchoolBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentThisSchoolBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentThisSchoolBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_this_school);
    }

    @NonNull
    public static WorksFragmentThisSchoolBinding i(@NonNull LayoutInflater inflater) {
        return l(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentThisSchoolBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return k(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentThisSchoolBinding k(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentThisSchoolBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_this_school, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentThisSchoolBinding l(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentThisSchoolBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_this_school, null, false, component);
    }

    @Nullable
    public ThisSchoolFragment.ClickProxy f() {
        return this.f14343a;
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener g() {
        return this.f14341a;
    }

    @Nullable
    public ThisSchoolVM h() {
        return this.f14344a;
    }

    public abstract void m(@Nullable ThisSchoolFragment.ClickProxy click);

    public abstract void n(@Nullable ThisSchoolVM vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
