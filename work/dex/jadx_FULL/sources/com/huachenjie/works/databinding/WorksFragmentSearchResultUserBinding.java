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
import com.huachenjie.works.page.search.result.child.SearchResultUserModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentSearchResultUserBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f14326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f14327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f14328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchResultUserModel f14329a;

    public WorksFragmentSearchResultUserBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, SwipeRefreshLayout refreshLayout, StateLayout stateLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36956a = recyclerView;
        this.f14327a = refreshLayout;
        this.f14328a = stateLayout;
    }

    public static WorksFragmentSearchResultUserBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentSearchResultUserBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentSearchResultUserBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_search_result_user);
    }

    @NonNull
    public static WorksFragmentSearchResultUserBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentSearchResultUserBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchResultUserBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentSearchResultUserBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_result_user, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchResultUserBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentSearchResultUserBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_result_user, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f14326a;
    }

    @Nullable
    public SearchResultUserModel g() {
        return this.f14329a;
    }

    public abstract void l(@Nullable SearchResultUserModel vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
