package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.login.AuthorizeVerifyActivity;
import com.huachenjie.compat.page.login.vm.AuthorizeVerifyVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ActivityAuthorizeVerifyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34000a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RadioButton f9021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RadioGroup f9022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AuthorizeVerifyActivity.c f9024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AuthorizeVerifyVM f9025a;

    @NonNull
    public final RadioButton b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9026b;

    public ActivityAuthorizeVerifyBinding(Object obj, View view, int i, RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f9022a = radioGroup;
        this.f9021a = radioButton;
        this.b = radioButton2;
        this.f34000a = imageView;
        this.f9023a = textView;
        this.f9026b = textView2;
    }

    public static ActivityAuthorizeVerifyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAuthorizeVerifyBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityAuthorizeVerifyBinding) ViewDataBinding.bind(obj, view, R.layout.activity_authorize_verify);
    }

    @NonNull
    public static ActivityAuthorizeVerifyBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityAuthorizeVerifyBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAuthorizeVerifyBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAuthorizeVerifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_authorize_verify, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityAuthorizeVerifyBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAuthorizeVerifyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_authorize_verify, null, false, obj);
    }

    @Nullable
    public AuthorizeVerifyActivity.c f() {
        return this.f9024a;
    }

    @Nullable
    public AuthorizeVerifyVM g() {
        return this.f9025a;
    }

    public abstract void l(@Nullable AuthorizeVerifyActivity.c cVar);

    public abstract void m(@Nullable AuthorizeVerifyVM authorizeVerifyVM);
}
