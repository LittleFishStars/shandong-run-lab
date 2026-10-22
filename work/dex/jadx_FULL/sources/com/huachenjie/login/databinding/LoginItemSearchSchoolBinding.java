package com.huachenjie.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.login.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginItemSearchSchoolBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SchoolInfo f34683a;

    public LoginItemSearchSchoolBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static LoginItemSearchSchoolBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginItemSearchSchoolBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginItemSearchSchoolBinding) ViewDataBinding.bind(obj, view, R.layout.login_item_search_school);
    }

    @NonNull
    public static LoginItemSearchSchoolBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginItemSearchSchoolBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginItemSearchSchoolBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginItemSearchSchoolBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_item_search_school, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginItemSearchSchoolBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginItemSearchSchoolBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_item_search_school, null, false, obj);
    }

    @Nullable
    public SchoolInfo f() {
        return this.f34683a;
    }

    public abstract void k(@Nullable SchoolInfo schoolInfo);
}
