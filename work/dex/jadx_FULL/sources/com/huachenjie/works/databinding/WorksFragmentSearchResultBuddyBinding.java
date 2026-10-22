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
import com.huachenjie.works.page.search.result.child.SearchResultBuddyModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentSearchResultBuddyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36950a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f14312a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f14313a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f14314a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchResultBuddyModel f14315a;

    public WorksFragmentSearchResultBuddyBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, SwipeRefreshLayout refreshLayout, StateLayout stateLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36950a = recyclerView;
        this.f14313a = refreshLayout;
        this.f14314a = stateLayout;
    }

    public static WorksFragmentSearchResultBuddyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentSearchResultBuddyBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentSearchResultBuddyBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_search_result_buddy);
    }

    @NonNull
    public static WorksFragmentSearchResultBuddyBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentSearchResultBuddyBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchResultBuddyBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentSearchResultBuddyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_result_buddy, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchResultBuddyBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentSearchResultBuddyBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_result_buddy, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f14312a;
    }

    @Nullable
    public SearchResultBuddyModel g() {
        return this.f14315a;
    }

    public abstract void l(@Nullable SearchResultBuddyModel vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
