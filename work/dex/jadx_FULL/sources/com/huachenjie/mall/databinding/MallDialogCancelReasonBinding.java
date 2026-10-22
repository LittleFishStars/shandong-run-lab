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
import com.huachenjie.mall.dialog.cancel_reason.CancelReasonDialog;
import com.huachenjie.mall.dialog.cancel_reason.CancelReasonVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallDialogCancelReasonBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CancelReasonDialog.a f10511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CancelReasonVM f10512a;

    public MallDialogCancelReasonBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f34897a = textView;
    }

    public static MallDialogCancelReasonBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallDialogCancelReasonBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallDialogCancelReasonBinding) ViewDataBinding.bind(obj, view, R.layout.mall_dialog_cancel_reason);
    }

    @NonNull
    public static MallDialogCancelReasonBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallDialogCancelReasonBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallDialogCancelReasonBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallDialogCancelReasonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_cancel_reason, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallDialogCancelReasonBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallDialogCancelReasonBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_cancel_reason, null, false, obj);
    }

    @Nullable
    public CancelReasonDialog.a f() {
        return this.f10511a;
    }

    @Nullable
    public CancelReasonVM g() {
        return this.f10512a;
    }

    public abstract void l(@Nullable CancelReasonDialog.a aVar);

    public abstract void m(@Nullable CancelReasonVM cancelReasonVM);
}
