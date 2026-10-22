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
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.page.campus_wall.post.list.PostListActivity;
import com.huachenjie.works.page.campus_wall.post.list.PostListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivityHotListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f36780a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f13866a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f13867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PostListActivity.a f13868a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PostListVM f13869a;

    public WorksActivityHotListBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, LayoutToolbarBindingBinding toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36780a = recyclerView;
        this.f13867a = toolbar;
    }

    public static WorksActivityHotListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivityHotListBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivityHotListBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_hot_list);
    }

    @NonNull
    public static WorksActivityHotListBinding i(@NonNull LayoutInflater inflater) {
        return l(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivityHotListBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return k(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivityHotListBinding k(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivityHotListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_hot_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivityHotListBinding l(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivityHotListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_hot_list, null, false, component);
    }

    @Nullable
    public PostListActivity.a f() {
        return this.f13868a;
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener g() {
        return this.f13866a;
    }

    @Nullable
    public PostListVM h() {
        return this.f13869a;
    }

    public abstract void m(@Nullable PostListActivity.a click);

    public abstract void n(@Nullable PostListVM vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
