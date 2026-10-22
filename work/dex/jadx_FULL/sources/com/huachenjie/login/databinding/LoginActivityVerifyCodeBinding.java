package com.huachenjie.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.view.VerifyCodeEditText;
import com.huachenjie.login.R;
import com.huachenjie.login.page.verify_code.VerifyCodeActivity;
import com.huachenjie.login.page.verify_code.VerifyCodeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivityVerifyCodeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final VerifyCodeEditText f34670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public VerifyCodeActivity.ClickProxy f10048a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public VerifyCodeVM f10049a;

    public LoginActivityVerifyCodeBinding(Object obj, View view, int i, VerifyCodeEditText verifyCodeEditText) {
        super(obj, view, i);
        this.f34670a = verifyCodeEditText;
    }

    public static LoginActivityVerifyCodeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivityVerifyCodeBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivityVerifyCodeBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_verify_code);
    }

    @NonNull
    public static LoginActivityVerifyCodeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivityVerifyCodeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivityVerifyCodeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivityVerifyCodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_verify_code, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivityVerifyCodeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivityVerifyCodeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_verify_code, null, false, obj);
    }

    @Nullable
    public VerifyCodeActivity.ClickProxy f() {
        return this.f10048a;
    }

    @Nullable
    public VerifyCodeVM g() {
        return this.f10049a;
    }

    public abstract void l(@Nullable VerifyCodeActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable VerifyCodeVM verifyCodeVM);
}
