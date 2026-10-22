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
import com.huachenjie.login.page.account.LoginAccountActivity;
import com.huachenjie.login.page.account.LoginAccountVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivityAccountBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f34612a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LoginLayoutProtocolCheckboxBinding f9915a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public LoginAccountActivity.a f9916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public LoginAccountVM f9917a;

    public LoginActivityAccountBinding(Object obj, View view, int i, EditText editText, LoginLayoutProtocolCheckboxBinding loginLayoutProtocolCheckboxBinding) {
        super(obj, view, i);
        this.f34612a = editText;
        this.f9915a = loginLayoutProtocolCheckboxBinding;
    }

    public static LoginActivityAccountBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivityAccountBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivityAccountBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_account);
    }

    @NonNull
    public static LoginActivityAccountBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivityAccountBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivityAccountBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivityAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_account, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivityAccountBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivityAccountBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_account, null, false, obj);
    }

    @Nullable
    public LoginAccountActivity.a f() {
        return this.f9916a;
    }

    @Nullable
    public LoginAccountVM g() {
        return this.f9917a;
    }

    public abstract void l(@Nullable LoginAccountActivity.a aVar);

    public abstract void m(@Nullable LoginAccountVM loginAccountVM);
}
