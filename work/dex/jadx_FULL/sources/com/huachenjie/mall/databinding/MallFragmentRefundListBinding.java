package com.huachenjie.mall.databinding;

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
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.refund.RefundListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallFragmentRefundListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f34963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RefundListVM f10698a;

    public MallFragmentRefundListBinding(Object obj, View view, int i, StateLayout stateLayout) {
        super(obj, view, i);
        this.f10697a = stateLayout;
    }

    public static MallFragmentRefundListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallFragmentRefundListBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallFragmentRefundListBinding) ViewDataBinding.bind(obj, view, R.layout.mall_fragment_refund_list);
    }

    @NonNull
    public static MallFragmentRefundListBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallFragmentRefundListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallFragmentRefundListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallFragmentRefundListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_refund_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallFragmentRefundListBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallFragmentRefundListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_refund_list, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f34963a;
    }

    @Nullable
    public RefundListVM g() {
        return this.f10698a;
    }

    public abstract void l(@Nullable RefundListVM refundListVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
