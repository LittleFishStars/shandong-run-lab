package com.huachenjie.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.login.R;
import com.huachenjie.login.page.school_certification.SchoolCertificationVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivitySchoolCertificationBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LayoutToolbarBindingBinding f34664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SchoolCertificationVM f10031a;

    public LoginActivitySchoolCertificationBinding(Object obj, View view, int i, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f34664a = layoutToolbarBindingBinding;
    }

    public static LoginActivitySchoolCertificationBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivitySchoolCertificationBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivitySchoolCertificationBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_school_certification);
    }

    @NonNull
    public static LoginActivitySchoolCertificationBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivitySchoolCertificationBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivitySchoolCertificationBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivitySchoolCertificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_school_certification, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivitySchoolCertificationBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivitySchoolCertificationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_school_certification, null, false, obj);
    }

    @Nullable
    public SchoolCertificationVM f() {
        return this.f10031a;
    }

    public abstract void k(@Nullable SchoolCertificationVM schoolCertificationVM);
}
