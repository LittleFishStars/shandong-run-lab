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
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.social_contact.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogLoadingTipBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseVM f12885a;

    public DialogLoadingTipBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.f36147a = textView;
    }

    public static DialogLoadingTipBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogLoadingTipBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogLoadingTipBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_loading_tip);
    }

    @NonNull
    public static DialogLoadingTipBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogLoadingTipBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogLoadingTipBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogLoadingTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_loading_tip, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogLoadingTipBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogLoadingTipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_loading_tip, null, false, obj);
    }

    @Nullable
    public BaseVM f() {
        return this.f12885a;
    }

    public abstract void k(@Nullable BaseVM baseVM);
}
