package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.personal.ChangeNickNameActivity;
import com.huachenjie.compat.page.personal.ChangeNickNameVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ActivityChangeNickNameBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f34024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9084a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChangeNickNameActivity.b f9085a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChangeNickNameVM f9086a;

    public ActivityChangeNickNameBinding(Object obj, View view, int i, EditText editText, TextView textView) {
        super(obj, view, i);
        this.f34024a = editText;
        this.f9084a = textView;
    }

    public static ActivityChangeNickNameBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityChangeNickNameBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityChangeNickNameBinding) ViewDataBinding.bind(obj, view, R.layout.activity_change_nick_name);
    }

    @NonNull
    public static ActivityChangeNickNameBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityChangeNickNameBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityChangeNickNameBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityChangeNickNameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_change_nick_name, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityChangeNickNameBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityChangeNickNameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_change_nick_name, null, false, obj);
    }

    @Nullable
    public ChangeNickNameActivity.b f() {
        return this.f9085a;
    }

    @Nullable
    public ChangeNickNameVM g() {
        return this.f9086a;
    }

    public abstract void l(@Nullable ChangeNickNameActivity.b bVar);

    public abstract void m(@Nullable ChangeNickNameVM changeNickNameVM);
}
