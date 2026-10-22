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
import com.huachenjie.login.page.password.SetPasswordActivity;
import com.huachenjie.login.page.password.SetPasswordVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivityPasswordSetBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f34654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SetPasswordActivity.a f10013a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SetPasswordVM f10014a;

    @NonNull
    public final EditText b;

    public LoginActivityPasswordSetBinding(Object obj, View view, int i, EditText editText, EditText editText2) {
        super(obj, view, i);
        this.f34654a = editText;
        this.b = editText2;
    }

    public static LoginActivityPasswordSetBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivityPasswordSetBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivityPasswordSetBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_password_set);
    }

    @NonNull
    public static LoginActivityPasswordSetBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivityPasswordSetBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivityPasswordSetBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivityPasswordSetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_password_set, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivityPasswordSetBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivityPasswordSetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_password_set, null, false, obj);
    }

    @Nullable
    public SetPasswordActivity.a f() {
        return this.f10013a;
    }

    @Nullable
    public SetPasswordVM g() {
        return this.f10014a;
    }

    public abstract void l(@Nullable SetPasswordActivity.a aVar);

    public abstract void m(@Nullable SetPasswordVM setPasswordVM);
}
