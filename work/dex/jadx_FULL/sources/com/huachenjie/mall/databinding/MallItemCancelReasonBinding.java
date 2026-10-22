package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.OrderReasonBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemCancelReasonBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public OrderReasonBean f34978a;

    public MallItemCancelReasonBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemCancelReasonBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemCancelReasonBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemCancelReasonBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_cancel_reason);
    }

    @NonNull
    public static MallItemCancelReasonBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemCancelReasonBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemCancelReasonBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemCancelReasonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_cancel_reason, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemCancelReasonBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemCancelReasonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_cancel_reason, null, false, obj);
    }

    @Nullable
    public OrderReasonBean f() {
        return this.f34978a;
    }

    public abstract void k(@Nullable OrderReasonBean orderReasonBean);
}
