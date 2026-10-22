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
import com.huachenjie.works.page.broadcast_floor.BroadcastFloorListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentBroadcastFloorBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36902a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f14181a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f14182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BroadcastFloorListVM f14183a;

    public WorksFragmentBroadcastFloorBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, StateLayout stateLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36902a = recyclerView;
        this.f14182a = stateLayout;
    }

    public static WorksFragmentBroadcastFloorBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentBroadcastFloorBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentBroadcastFloorBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_broadcast_floor);
    }

    @NonNull
    public static WorksFragmentBroadcastFloorBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentBroadcastFloorBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentBroadcastFloorBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentBroadcastFloorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_broadcast_floor, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentBroadcastFloorBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentBroadcastFloorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_broadcast_floor, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f14181a;
    }

    @Nullable
    public BroadcastFloorListVM g() {
        return this.f14183a;
    }

    public abstract void l(@Nullable BroadcastFloorListVM vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
