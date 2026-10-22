package com.huachenjie.mall.databinding;

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
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.try_see_list.TrySeeListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityTrySeeListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34882a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f10465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10466a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TrySeeListVM f10468a;

    public MallActivityTrySeeListBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f34882a = recyclerView;
        this.f10467a = stateLayout;
        this.f10466a = layoutToolbarBindingBinding;
    }

    public static MallActivityTrySeeListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityTrySeeListBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityTrySeeListBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_try_see_list);
    }

    @NonNull
    public static MallActivityTrySeeListBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityTrySeeListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityTrySeeListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityTrySeeListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_try_see_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityTrySeeListBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityTrySeeListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_try_see_list, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f10465a;
    }

    @Nullable
    public TrySeeListVM g() {
        return this.f10468a;
    }

    public abstract void l(@Nullable TrySeeListVM trySeeListVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
