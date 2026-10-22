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
import com.huachenjie.login.page.info.nickname.FillNicknameActivity;
import com.huachenjie.login.page.info.nickname.FillNicknameVM;
import com.noober.background.view.BLEditText;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivityFillNicknameBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public FillNicknameActivity.a f34640a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FillNicknameVM f9978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLEditText f9979a;

    public LoginActivityFillNicknameBinding(Object obj, View view, int i, BLEditText bLEditText) {
        super(obj, view, i);
        this.f9979a = bLEditText;
    }

    public static LoginActivityFillNicknameBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivityFillNicknameBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivityFillNicknameBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_fill_nickname);
    }

    @NonNull
    public static LoginActivityFillNicknameBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivityFillNicknameBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivityFillNicknameBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivityFillNicknameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_fill_nickname, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivityFillNicknameBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivityFillNicknameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_fill_nickname, null, false, obj);
    }

    @Nullable
    public FillNicknameActivity.a f() {
        return this.f34640a;
    }

    @Nullable
    public FillNicknameVM g() {
        return this.f9978a;
    }

    public abstract void l(@Nullable FillNicknameActivity.a aVar);

    public abstract void m(@Nullable FillNicknameVM fillNicknameVM);
}
