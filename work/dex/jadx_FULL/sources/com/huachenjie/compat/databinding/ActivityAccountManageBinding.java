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
import com.huachenjie.compat.page.account.AccountManageActivity;
import com.huachenjie.compat.page.account.AccountManageVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ActivityAccountManageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public AccountManageActivity.a f33989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AccountManageVM f8992a;

    public ActivityAccountManageBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ActivityAccountManageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAccountManageBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityAccountManageBinding) ViewDataBinding.bind(obj, view, R.layout.activity_account_manage);
    }

    @NonNull
    public static ActivityAccountManageBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityAccountManageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAccountManageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAccountManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_account_manage, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityAccountManageBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAccountManageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_account_manage, null, false, obj);
    }

    @Nullable
    public AccountManageActivity.a f() {
        return this.f33989a;
    }

    @Nullable
    public AccountManageVM g() {
        return this.f8992a;
    }

    public abstract void l(@Nullable AccountManageActivity.a aVar);

    public abstract void m(@Nullable AccountManageVM accountManageVM);
}
