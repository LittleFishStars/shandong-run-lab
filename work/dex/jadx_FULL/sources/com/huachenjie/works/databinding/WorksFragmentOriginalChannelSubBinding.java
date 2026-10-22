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
import com.huachenjie.works.page.alumni.original.OriginalChannelSubVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentOriginalChannelSubBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36921a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f14230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f14231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OriginalChannelSubVM f14232a;

    public WorksFragmentOriginalChannelSubBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvList, StateLayout stateLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36921a = rvList;
        this.f14231a = stateLayout;
    }

    public static WorksFragmentOriginalChannelSubBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentOriginalChannelSubBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentOriginalChannelSubBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_original_channel_sub);
    }

    @NonNull
    public static WorksFragmentOriginalChannelSubBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentOriginalChannelSubBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentOriginalChannelSubBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentOriginalChannelSubBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_original_channel_sub, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentOriginalChannelSubBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentOriginalChannelSubBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_original_channel_sub, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f14230a;
    }

    @Nullable
    public OriginalChannelSubVM g() {
        return this.f14232a;
    }

    public abstract void l(@Nullable OriginalChannelSubVM vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
