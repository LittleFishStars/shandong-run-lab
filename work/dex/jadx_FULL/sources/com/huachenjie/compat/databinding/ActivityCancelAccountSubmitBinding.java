package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.account.CancelAccountSubmitVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ActivityCancelAccountSubmitBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public CancelAccountSubmitVM f34016a;

    public ActivityCancelAccountSubmitBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ActivityCancelAccountSubmitBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityCancelAccountSubmitBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityCancelAccountSubmitBinding) ViewDataBinding.bind(obj, view, R.layout.activity_cancel_account_submit);
    }

    @NonNull
    public static ActivityCancelAccountSubmitBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityCancelAccountSubmitBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityCancelAccountSubmitBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityCancelAccountSubmitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_cancel_account_submit, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityCancelAccountSubmitBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityCancelAccountSubmitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_cancel_account_submit, null, false, obj);
    }

    @Nullable
    public CancelAccountSubmitVM f() {
        return this.f34016a;
    }

    public abstract void k(@Nullable CancelAccountSubmitVM cancelAccountSubmitVM);
}
