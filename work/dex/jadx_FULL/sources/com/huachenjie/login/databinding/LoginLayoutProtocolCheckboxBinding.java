package com.huachenjie.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.login.R;
import com.huachenjie.login.page.base.BaseLoginVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginLayoutProtocolCheckboxBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckBox f34685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10085a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseLoginVM f10086a;

    public LoginLayoutProtocolCheckboxBinding(Object obj, View view, int i, CheckBox checkBox, TextView textView) {
        super(obj, view, i);
        this.f34685a = checkBox;
        this.f10085a = textView;
    }

    public static LoginLayoutProtocolCheckboxBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginLayoutProtocolCheckboxBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginLayoutProtocolCheckboxBinding) ViewDataBinding.bind(obj, view, R.layout.login_layout_protocol_checkbox);
    }

    @NonNull
    public static LoginLayoutProtocolCheckboxBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginLayoutProtocolCheckboxBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginLayoutProtocolCheckboxBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginLayoutProtocolCheckboxBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_layout_protocol_checkbox, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginLayoutProtocolCheckboxBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginLayoutProtocolCheckboxBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_layout_protocol_checkbox, null, false, obj);
    }

    @Nullable
    public BaseLoginVM f() {
        return this.f10086a;
    }

    public abstract void k(@Nullable BaseLoginVM baseLoginVM);
}
