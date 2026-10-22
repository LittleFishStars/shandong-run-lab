package com.huachenjie.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.login.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginItemChoosePortraitBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public Boolean f34679a;

    @Bindable
    public String f;

    public LoginItemChoosePortraitBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static LoginItemChoosePortraitBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginItemChoosePortraitBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginItemChoosePortraitBinding) ViewDataBinding.bind(obj, view, R.layout.login_item_choose_portrait);
    }

    @NonNull
    public static LoginItemChoosePortraitBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginItemChoosePortraitBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginItemChoosePortraitBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginItemChoosePortraitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_item_choose_portrait, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginItemChoosePortraitBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginItemChoosePortraitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_item_choose_portrait, null, false, obj);
    }

    @Nullable
    public Boolean f() {
        return this.f34679a;
    }

    @Nullable
    public String g() {
        return this.f;
    }

    public abstract void l(@Nullable Boolean bool);

    public abstract void m(@Nullable String str);
}
