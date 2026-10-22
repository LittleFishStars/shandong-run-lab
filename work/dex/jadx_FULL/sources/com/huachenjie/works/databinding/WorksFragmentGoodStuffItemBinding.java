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
import com.huachenjie.works.page.alumni.good_stuff.GoodStuffItemVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentGoodStuffItemBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36911a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f14206a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f14207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f14208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodStuffItemVM f14209a;

    public WorksFragmentGoodStuffItemBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, SwipeRefreshLayout refreshLayout, StateLayout stateLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36911a = recyclerView;
        this.f14207a = refreshLayout;
        this.f14208a = stateLayout;
    }

    public static WorksFragmentGoodStuffItemBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentGoodStuffItemBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentGoodStuffItemBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_good_stuff_item);
    }

    @NonNull
    public static WorksFragmentGoodStuffItemBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentGoodStuffItemBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentGoodStuffItemBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentGoodStuffItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_good_stuff_item, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentGoodStuffItemBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentGoodStuffItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_good_stuff_item, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f14206a;
    }

    @Nullable
    public GoodStuffItemVM g() {
        return this.f14209a;
    }

    public abstract void l(@Nullable GoodStuffItemVM vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
