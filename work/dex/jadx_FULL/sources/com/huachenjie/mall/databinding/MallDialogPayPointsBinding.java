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
import com.huachenjie.mall.dialog.pay_points.PayPointsDialog;
import com.huachenjie.mall.dialog.pay_points.PayPointsVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallDialogPayPointsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PayPointsDialog.a f10614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PayPointsVM f10615a;

    @NonNull
    public final TextView b;

    public MallDialogPayPointsBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f34931a = textView;
        this.b = textView2;
    }

    public static MallDialogPayPointsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallDialogPayPointsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallDialogPayPointsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_dialog_pay_points);
    }

    @NonNull
    public static MallDialogPayPointsBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallDialogPayPointsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallDialogPayPointsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallDialogPayPointsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_pay_points, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallDialogPayPointsBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallDialogPayPointsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_pay_points, null, false, obj);
    }

    @Nullable
    public PayPointsDialog.a f() {
        return this.f10614a;
    }

    @Nullable
    public PayPointsVM g() {
        return this.f10615a;
    }

    public abstract void l(@Nullable PayPointsDialog.a aVar);

    public abstract void m(@Nullable PayPointsVM payPointsVM);
}
