package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.search.result.child.SearchResultChannelModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentSearchResultChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f36953a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f14319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f14320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchResultChannelModel f14321a;

    public WorksFragmentSearchResultChannelBinding(Object _bindingComponent, View _root, int _localFieldCount, SwipeRefreshLayout refreshLayout, StateLayout stateLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14319a = refreshLayout;
        this.f14320a = stateLayout;
    }

    public static WorksFragmentSearchResultChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentSearchResultChannelBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentSearchResultChannelBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_search_result_channel);
    }

    @NonNull
    public static WorksFragmentSearchResultChannelBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentSearchResultChannelBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchResultChannelBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentSearchResultChannelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_result_channel, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchResultChannelBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentSearchResultChannelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_result_channel, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f36953a;
    }

    @Nullable
    public SearchResultChannelModel g() {
        return this.f14321a;
    }

    public abstract void l(@Nullable SearchResultChannelModel vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
