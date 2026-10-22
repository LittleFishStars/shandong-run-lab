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
import com.huachenjie.mall.bean.ApplyRefundFileBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemApplyRefundPicAddBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ApplyRefundFileBean f34974a;

    public MallItemApplyRefundPicAddBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemApplyRefundPicAddBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemApplyRefundPicAddBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemApplyRefundPicAddBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_apply_refund_pic_add);
    }

    @NonNull
    public static MallItemApplyRefundPicAddBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemApplyRefundPicAddBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemApplyRefundPicAddBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemApplyRefundPicAddBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_apply_refund_pic_add, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemApplyRefundPicAddBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemApplyRefundPicAddBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_apply_refund_pic_add, null, false, obj);
    }

    @Nullable
    public ApplyRefundFileBean f() {
        return this.f34974a;
    }

    public abstract void k(@Nullable ApplyRefundFileBean applyRefundFileBean);
}
