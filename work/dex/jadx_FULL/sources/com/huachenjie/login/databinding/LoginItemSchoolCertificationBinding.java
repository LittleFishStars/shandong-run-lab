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
import com.huachenjie.login.bean.SchoolCertificationBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginItemSchoolCertificationBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SchoolCertificationBean f34681a;

    public LoginItemSchoolCertificationBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static LoginItemSchoolCertificationBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginItemSchoolCertificationBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginItemSchoolCertificationBinding) ViewDataBinding.bind(obj, view, R.layout.login_item_school_certification);
    }

    @NonNull
    public static LoginItemSchoolCertificationBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginItemSchoolCertificationBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginItemSchoolCertificationBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginItemSchoolCertificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_item_school_certification, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginItemSchoolCertificationBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginItemSchoolCertificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_item_school_certification, null, false, obj);
    }

    @Nullable
    public SchoolCertificationBean f() {
        return this.f34681a;
    }

    public abstract void k(@Nullable SchoolCertificationBean schoolCertificationBean);
}
