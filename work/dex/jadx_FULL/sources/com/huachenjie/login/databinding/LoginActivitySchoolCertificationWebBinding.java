package com.huachenjie.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.login.R;
import com.huachenjie.login.page.school_certification.SchoolCertificationWebWM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivitySchoolCertificationWebBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final WebView f34666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SchoolCertificationWebWM f10037a;

    public LoginActivitySchoolCertificationWebBinding(Object obj, View view, int i, LayoutToolbarBindingBinding layoutToolbarBindingBinding, WebView webView) {
        super(obj, view, i);
        this.f10036a = layoutToolbarBindingBinding;
        this.f34666a = webView;
    }

    public static LoginActivitySchoolCertificationWebBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivitySchoolCertificationWebBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivitySchoolCertificationWebBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_school_certification_web);
    }

    @NonNull
    public static LoginActivitySchoolCertificationWebBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivitySchoolCertificationWebBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivitySchoolCertificationWebBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivitySchoolCertificationWebBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_school_certification_web, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivitySchoolCertificationWebBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivitySchoolCertificationWebBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_school_certification_web, null, false, obj);
    }

    @Nullable
    public SchoolCertificationWebWM f() {
        return this.f10037a;
    }

    public abstract void k(@Nullable SchoolCertificationWebWM schoolCertificationWebWM);
}
