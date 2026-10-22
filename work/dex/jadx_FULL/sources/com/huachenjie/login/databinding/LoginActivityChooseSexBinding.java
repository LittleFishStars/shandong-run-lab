package com.huachenjie.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.login.R;
import com.huachenjie.login.page.info.sex.ChooseSexActivity;
import com.huachenjie.login.page.info.sex.ChooseSexVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivityChooseSexBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckBox f34627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9950a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseSexActivity.a f9951a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseSexVM f9952a;

    @NonNull
    public final CheckBox b;

    public LoginActivityChooseSexBinding(Object obj, View view, int i, CheckBox checkBox, LinearLayout linearLayout, CheckBox checkBox2) {
        super(obj, view, i);
        this.f34627a = checkBox;
        this.f9950a = linearLayout;
        this.b = checkBox2;
    }

    public static LoginActivityChooseSexBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivityChooseSexBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivityChooseSexBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_choose_sex);
    }

    @NonNull
    public static LoginActivityChooseSexBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivityChooseSexBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivityChooseSexBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivityChooseSexBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_choose_sex, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivityChooseSexBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivityChooseSexBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_choose_sex, null, false, obj);
    }

    @Nullable
    public ChooseSexActivity.a f() {
        return this.f9951a;
    }

    @Nullable
    public ChooseSexVM g() {
        return this.f9952a;
    }

    public abstract void l(@Nullable ChooseSexActivity.a aVar);

    public abstract void m(@Nullable ChooseSexVM chooseSexVM);
}
