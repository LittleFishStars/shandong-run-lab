package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.check_order.OrderRemarkDialog;
import com.huachenjie.mall.page.check_order.OrderRemarkVM;
import com.noober.background.view.BLEditText;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallDialogOrderRemarkBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10589a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderRemarkDialog.a f10590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderRemarkVM f10591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLEditText f10592a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f10593a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10594a;

    public MallDialogOrderRemarkBinding(Object obj, View view, int i, BLEditText bLEditText, BLRelativeLayout bLRelativeLayout, BLTextView bLTextView, TextView textView, View view2) {
        super(obj, view, i);
        this.f10592a = bLEditText;
        this.f10593a = bLRelativeLayout;
        this.f10594a = bLTextView;
        this.f10589a = textView;
        this.f34922a = view2;
    }

    public static MallDialogOrderRemarkBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallDialogOrderRemarkBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallDialogOrderRemarkBinding) ViewDataBinding.bind(obj, view, R.layout.mall_dialog_order_remark);
    }

    @NonNull
    public static MallDialogOrderRemarkBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallDialogOrderRemarkBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallDialogOrderRemarkBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallDialogOrderRemarkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_order_remark, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallDialogOrderRemarkBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallDialogOrderRemarkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_order_remark, null, false, obj);
    }

    @Nullable
    public OrderRemarkDialog.a f() {
        return this.f10590a;
    }

    @Nullable
    public OrderRemarkVM g() {
        return this.f10591a;
    }

    public abstract void l(@Nullable OrderRemarkDialog.a aVar);

    public abstract void m(@Nullable OrderRemarkVM orderRemarkVM);
}
