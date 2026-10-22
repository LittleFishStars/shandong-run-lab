package com.huachenjie.social_contact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.dialog.BuySuccessDialog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogBuySuccessBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BuySuccessDialog.a f12844a;

    public DialogBuySuccessBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f36127a = textView;
    }

    public static DialogBuySuccessBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBuySuccessBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogBuySuccessBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_buy_success);
    }

    @NonNull
    public static DialogBuySuccessBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogBuySuccessBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogBuySuccessBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogBuySuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_buy_success, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogBuySuccessBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogBuySuccessBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_buy_success, null, false, obj);
    }

    @Nullable
    public BuySuccessDialog.a f() {
        return this.f12844a;
    }

    public abstract void k(@Nullable BuySuccessDialog.a aVar);
}
