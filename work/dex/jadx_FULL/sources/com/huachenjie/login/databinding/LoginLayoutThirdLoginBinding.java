package com.huachenjie.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.login.R;
import com.huachenjie.login.page.base.ThirdLoginInterface;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginLayoutThirdLoginBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10091a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ThirdLoginInterface f10092a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10093b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public LoginLayoutThirdLoginBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2, View view3) {
        super(obj, view, i);
        this.f10091a = textView;
        this.f10093b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.f34688a = view2;
        this.b = view3;
    }

    public static LoginLayoutThirdLoginBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginLayoutThirdLoginBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginLayoutThirdLoginBinding) ViewDataBinding.bind(obj, view, R.layout.login_layout_third_login);
    }

    @NonNull
    public static LoginLayoutThirdLoginBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginLayoutThirdLoginBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginLayoutThirdLoginBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginLayoutThirdLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_layout_third_login, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginLayoutThirdLoginBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginLayoutThirdLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_layout_third_login, null, false, obj);
    }

    @Nullable
    public ThirdLoginInterface f() {
        return this.f10092a;
    }

    public abstract void k(@Nullable ThirdLoginInterface thirdLoginInterface);
}
