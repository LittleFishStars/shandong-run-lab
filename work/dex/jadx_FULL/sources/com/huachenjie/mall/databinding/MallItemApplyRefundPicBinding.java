package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ApplyRefundFileBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemApplyRefundPicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34976a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ApplyRefundFileBean f10726a;

    public MallItemApplyRefundPicBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f34976a = imageView;
    }

    public static MallItemApplyRefundPicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemApplyRefundPicBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemApplyRefundPicBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_apply_refund_pic);
    }

    @NonNull
    public static MallItemApplyRefundPicBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemApplyRefundPicBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemApplyRefundPicBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemApplyRefundPicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_apply_refund_pic, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemApplyRefundPicBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemApplyRefundPicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_apply_refund_pic, null, false, obj);
    }

    @Nullable
    public ApplyRefundFileBean f() {
        return this.f10726a;
    }

    public abstract void k(@Nullable ApplyRefundFileBean applyRefundFileBean);
}
