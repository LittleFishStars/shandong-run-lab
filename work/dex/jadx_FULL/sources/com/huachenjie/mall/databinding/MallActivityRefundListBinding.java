package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.refund.RefundListAVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityRefundListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LayoutToolbarBindingBinding f34844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RefundListAVM f10359a;

    public MallActivityRefundListBinding(Object obj, View view, int i, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f34844a = layoutToolbarBindingBinding;
    }

    public static MallActivityRefundListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityRefundListBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityRefundListBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_refund_list);
    }

    @NonNull
    public static MallActivityRefundListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityRefundListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityRefundListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityRefundListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_refund_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityRefundListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityRefundListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_refund_list, null, false, obj);
    }

    @Nullable
    public RefundListAVM f() {
        return this.f10359a;
    }

    public abstract void k(@Nullable RefundListAVM refundListAVM);
}
