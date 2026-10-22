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
import com.huachenjie.mall.page.shopping_message.ShoppingMessageVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityShoppingMessageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f10445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShoppingMessageVM f10448a;

    public MallActivityShoppingMessageBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f34875a = recyclerView;
        this.f10447a = stateLayout;
        this.f10446a = layoutToolbarBindingBinding;
    }

    public static MallActivityShoppingMessageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityShoppingMessageBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityShoppingMessageBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_shopping_message);
    }

    @NonNull
    public static MallActivityShoppingMessageBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityShoppingMessageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityShoppingMessageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityShoppingMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_shopping_message, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityShoppingMessageBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityShoppingMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_shopping_message, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f10445a;
    }

    @Nullable
    public ShoppingMessageVM g() {
        return this.f10448a;
    }

    public abstract void l(@Nullable ShoppingMessageVM shoppingMessageVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
