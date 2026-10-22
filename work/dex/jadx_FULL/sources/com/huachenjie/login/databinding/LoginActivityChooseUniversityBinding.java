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
import com.huachenjie.login.page.info.university.ChooseUniversityActivity;
import com.huachenjie.login.page.info.university.ChooseUniversityVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivityChooseUniversityBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ChooseUniversityActivity.a f34634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseUniversityVM f9965a;

    public LoginActivityChooseUniversityBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static LoginActivityChooseUniversityBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivityChooseUniversityBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivityChooseUniversityBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_choose_university);
    }

    @NonNull
    public static LoginActivityChooseUniversityBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivityChooseUniversityBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivityChooseUniversityBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivityChooseUniversityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_choose_university, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivityChooseUniversityBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivityChooseUniversityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_choose_university, null, false, obj);
    }

    @Nullable
    public ChooseUniversityActivity.a f() {
        return this.f34634a;
    }

    @Nullable
    public ChooseUniversityVM g() {
        return this.f9965a;
    }

    public abstract void l(@Nullable ChooseUniversityActivity.a aVar);

    public abstract void m(@Nullable ChooseUniversityVM chooseUniversityVM);
}
