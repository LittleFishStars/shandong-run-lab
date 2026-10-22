package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.account.ChangePasswordActivity;
import com.huachenjie.compat.page.account.ChangePasswordVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ActivityChangePasswordBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CheckBox f34028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f9094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChangePasswordActivity.a f9096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChangePasswordVM f9097a;

    @NonNull
    public final CheckBox b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final EditText f9098b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9099b;

    @NonNull
    public final EditText c;

    public ActivityChangePasswordBinding(Object obj, View view, int i, CheckBox checkBox, CheckBox checkBox2, EditText editText, EditText editText2, EditText editText3, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f34028a = checkBox;
        this.b = checkBox2;
        this.f9094a = editText;
        this.f9098b = editText2;
        this.c = editText3;
        this.f9095a = textView;
        this.f9099b = textView2;
    }

    public static ActivityChangePasswordBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChangePasswordBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityChangePasswordBinding) ViewDataBinding.bind(obj, view, R.layout.activity_change_password);
    }

    @NonNull
    public static ActivityChangePasswordBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityChangePasswordBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityChangePasswordBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityChangePasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_change_password, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityChangePasswordBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityChangePasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_change_password, null, false, obj);
    }

    @Nullable
    public ChangePasswordActivity.a f() {
        return this.f9096a;
    }

    @Nullable
    public ChangePasswordVM g() {
        return this.f9097a;
    }

    public abstract void l(@Nullable ChangePasswordActivity.a aVar);

    public abstract void m(@Nullable ChangePasswordVM changePasswordVM);
}
