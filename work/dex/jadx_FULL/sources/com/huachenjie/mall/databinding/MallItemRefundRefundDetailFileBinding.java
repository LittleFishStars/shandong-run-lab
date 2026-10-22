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
import com.huachenjie.mall.bean.AttachmentBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemRefundRefundDetailFileBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public AttachmentBean f35027a;

    public MallItemRefundRefundDetailFileBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemRefundRefundDetailFileBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemRefundRefundDetailFileBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemRefundRefundDetailFileBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_refund_refund_detail_file);
    }

    @NonNull
    public static MallItemRefundRefundDetailFileBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemRefundRefundDetailFileBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemRefundRefundDetailFileBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemRefundRefundDetailFileBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_refund_refund_detail_file, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemRefundRefundDetailFileBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemRefundRefundDetailFileBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_refund_refund_detail_file, null, false, obj);
    }

    @Nullable
    public AttachmentBean f() {
        return this.f35027a;
    }

    public abstract void k(@Nullable AttachmentBean attachmentBean);
}
