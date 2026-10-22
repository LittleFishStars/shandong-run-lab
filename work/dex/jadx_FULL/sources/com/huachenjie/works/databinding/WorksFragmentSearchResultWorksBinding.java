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
import com.huachenjie.works.page.search.result.child.SearchResultWorksModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentSearchResultWorksBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f14333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f14334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f14335a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchResultWorksModel f14336a;

    public WorksFragmentSearchResultWorksBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, SwipeRefreshLayout refreshLayout, StateLayout stateLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36959a = recyclerView;
        this.f14334a = refreshLayout;
        this.f14335a = stateLayout;
    }

    public static WorksFragmentSearchResultWorksBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentSearchResultWorksBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentSearchResultWorksBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_search_result_works);
    }

    @NonNull
    public static WorksFragmentSearchResultWorksBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentSearchResultWorksBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchResultWorksBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentSearchResultWorksBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_result_works, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchResultWorksBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentSearchResultWorksBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_result_works, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f14333a;
    }

    @Nullable
    public SearchResultWorksModel g() {
        return this.f14336a;
    }

    public abstract void l(@Nullable SearchResultWorksModel vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
