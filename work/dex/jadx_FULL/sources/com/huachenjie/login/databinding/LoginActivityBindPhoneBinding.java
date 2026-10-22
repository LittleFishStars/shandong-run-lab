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
import com.huachenjie.login.page.bind.BindPhoneActivity;
import com.huachenjie.login.page.bind.BindPhoneVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivityBindPhoneBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f34617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BindPhoneActivity.ClickProxy f9928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BindPhoneVM f9929a;

    public LoginActivityBindPhoneBinding(Object obj, View view, int i, EditText editText) {
        super(obj, view, i);
        this.f34617a = editText;
    }

    public static LoginActivityBindPhoneBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivityBindPhoneBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivityBindPhoneBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_bind_phone);
    }

    @NonNull
    public static LoginActivityBindPhoneBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivityBindPhoneBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivityBindPhoneBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivityBindPhoneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_bind_phone, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivityBindPhoneBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivityBindPhoneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_bind_phone, null, false, obj);
    }

    @Nullable
    public BindPhoneActivity.ClickProxy f() {
        return this.f9928a;
    }

    @Nullable
    public BindPhoneVM g() {
        return this.f9929a;
    }

    public abstract void l(@Nullable BindPhoneActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable BindPhoneVM bindPhoneVM);
}
