package com.huachenjie.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.login.R;
import com.huachenjie.login.page.password.PasswordActivity;
import com.huachenjie.login.page.password.PasswordVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivityPasswordBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f34647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PasswordActivity.a f9999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PasswordVM f10000a;

    public LoginActivityPasswordBinding(Object obj, View view, int i, EditText editText) {
        super(obj, view, i);
        this.f34647a = editText;
    }

    public static LoginActivityPasswordBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivityPasswordBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivityPasswordBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_password);
    }

    @NonNull
    public static LoginActivityPasswordBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivityPasswordBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivityPasswordBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivityPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_password, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivityPasswordBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivityPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_password, null, false, obj);
    }

    @Nullable
    public PasswordActivity.a f() {
        return this.f9999a;
    }

    @Nullable
    public PasswordVM g() {
        return this.f10000a;
    }

    public abstract void l(@Nullable PasswordActivity.a aVar);

    public abstract void m(@Nullable PasswordVM passwordVM);
}
