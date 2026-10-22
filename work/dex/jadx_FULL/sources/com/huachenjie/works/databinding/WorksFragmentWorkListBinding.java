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
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.external.base.BaseWorksListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentWorkListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36968a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f14356a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f14357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f14358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseWorksListVM f14359a;

    public WorksFragmentWorkListBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, SwipeRefreshLayout refreshLayout, StateLayout stateLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36968a = recyclerView;
        this.f14357a = refreshLayout;
        this.f14358a = stateLayout;
    }

    public static WorksFragmentWorkListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentWorkListBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentWorkListBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_work_list);
    }

    @NonNull
    public static WorksFragmentWorkListBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentWorkListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentWorkListBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentWorkListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_work_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentWorkListBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentWorkListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_work_list, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f14356a;
    }

    @Nullable
    public BaseWorksListVM g() {
        return this.f14359a;
    }

    public abstract void l(@Nullable BaseWorksListVM vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
