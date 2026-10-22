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
import com.huachenjie.login.page.welcome.WelcomeLoginActivity;
import com.huachenjie.login.page.welcome.WelcomeLoginVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivityWecomeLoginBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f34675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LoginLayoutProtocolCheckboxBinding f10059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WelcomeLoginActivity.a f10060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WelcomeLoginVM f10061a;

    public LoginActivityWecomeLoginBinding(Object obj, View view, int i, EditText editText, LoginLayoutProtocolCheckboxBinding loginLayoutProtocolCheckboxBinding) {
        super(obj, view, i);
        this.f34675a = editText;
        this.f10059a = loginLayoutProtocolCheckboxBinding;
    }

    public static LoginActivityWecomeLoginBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivityWecomeLoginBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivityWecomeLoginBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_wecome_login);
    }

    @NonNull
    public static LoginActivityWecomeLoginBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivityWecomeLoginBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivityWecomeLoginBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivityWecomeLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_wecome_login, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivityWecomeLoginBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivityWecomeLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_wecome_login, null, false, obj);
    }

    @Nullable
    public WelcomeLoginActivity.a f() {
        return this.f10060a;
    }

    @Nullable
    public WelcomeLoginVM g() {
        return this.f10061a;
    }

    public abstract void l(@Nullable WelcomeLoginActivity.a aVar);

    public abstract void m(@Nullable WelcomeLoginVM welcomeLoginVM);
}
