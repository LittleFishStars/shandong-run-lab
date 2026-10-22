package com.huachenjie.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.CommonSearchViewV2;
import com.huachenjie.login.R;
import com.huachenjie.login.page.school.SearchSchoolActivity;
import com.huachenjie.login.page.school.SearchSchoolVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivitySearchSchoolBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CommonSearchViewV2 f34668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchSchoolActivity.a f10041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchSchoolVM f10042a;

    public LoginActivitySearchSchoolBinding(Object obj, View view, int i, CommonSearchViewV2 commonSearchViewV2) {
        super(obj, view, i);
        this.f34668a = commonSearchViewV2;
    }

    public static LoginActivitySearchSchoolBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivitySearchSchoolBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivitySearchSchoolBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_search_school);
    }

    @NonNull
    public static LoginActivitySearchSchoolBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivitySearchSchoolBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivitySearchSchoolBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivitySearchSchoolBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_search_school, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivitySearchSchoolBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivitySearchSchoolBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_search_school, null, false, obj);
    }

    @Nullable
    public SearchSchoolActivity.a f() {
        return this.f10041a;
    }

    @Nullable
    public SearchSchoolVM g() {
        return this.f10042a;
    }

    public abstract void l(@Nullable SearchSchoolActivity.a aVar);

    public abstract void m(@Nullable SearchSchoolVM searchSchoolVM);
}
