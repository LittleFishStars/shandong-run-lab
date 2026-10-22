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
import com.huachenjie.login.page.info.portrait.ChoosePortraitActivity;
import com.huachenjie.login.page.info.portrait.ChoosePortraitVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivityChoosePortraitBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ChoosePortraitActivity.ClickProxy f34622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChoosePortraitVM f9938a;

    public LoginActivityChoosePortraitBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static LoginActivityChoosePortraitBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivityChoosePortraitBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivityChoosePortraitBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_choose_portrait);
    }

    @NonNull
    public static LoginActivityChoosePortraitBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivityChoosePortraitBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivityChoosePortraitBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivityChoosePortraitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_choose_portrait, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivityChoosePortraitBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivityChoosePortraitBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_choose_portrait, null, false, obj);
    }

    @Nullable
    public ChoosePortraitActivity.ClickProxy f() {
        return this.f34622a;
    }

    @Nullable
    public ChoosePortraitVM g() {
        return this.f9938a;
    }

    public abstract void l(@Nullable ChoosePortraitActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable ChoosePortraitVM choosePortraitVM);
}
