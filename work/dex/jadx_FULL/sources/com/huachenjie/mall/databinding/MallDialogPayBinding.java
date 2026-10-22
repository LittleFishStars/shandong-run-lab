package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.dialog.pay.PayDialog;
import com.huachenjie.mall.dialog.pay.PayVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallDialogPayBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RadioButton f34927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RadioGroup f10602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10603a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PayDialog.a f10604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PayVM f10605a;

    @NonNull
    public final RadioButton b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10606b;

    public MallDialogPayBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f34927a = radioButton;
        this.b = radioButton2;
        this.f10602a = radioGroup;
        this.f10603a = textView;
        this.f10606b = textView2;
    }

    public static MallDialogPayBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallDialogPayBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallDialogPayBinding) ViewDataBinding.bind(obj, view, R.layout.mall_dialog_pay);
    }

    @NonNull
    public static MallDialogPayBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallDialogPayBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallDialogPayBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallDialogPayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_pay, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallDialogPayBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallDialogPayBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_dialog_pay, null, false, obj);
    }

    @Nullable
    public PayDialog.a f() {
        return this.f10604a;
    }

    @Nullable
    public PayVM g() {
        return this.f10605a;
    }

    public abstract void l(@Nullable PayDialog.a aVar);

    public abstract void m(@Nullable PayVM payVM);
}
