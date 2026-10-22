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
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.rule_center.RuleCenterVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityRuleCenterBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34854a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f10385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10386a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RuleCenterVM f10387a;

    public MallActivityRuleCenterBinding(Object obj, View view, int i, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f34854a = recyclerView;
        this.f10386a = layoutToolbarBindingBinding;
    }

    public static MallActivityRuleCenterBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityRuleCenterBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityRuleCenterBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_rule_center);
    }

    @NonNull
    public static MallActivityRuleCenterBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityRuleCenterBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityRuleCenterBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityRuleCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_rule_center, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityRuleCenterBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityRuleCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_rule_center, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f10385a;
    }

    @Nullable
    public RuleCenterVM g() {
        return this.f10387a;
    }

    public abstract void l(@Nullable RuleCenterVM ruleCenterVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
