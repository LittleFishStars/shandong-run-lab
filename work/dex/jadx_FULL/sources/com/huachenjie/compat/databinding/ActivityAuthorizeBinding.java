package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.login.AuthorizeActivity;
import com.huachenjie.compat.page.login.vm.AuthorizeVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ActivityAuthorizeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final EditText f33996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9010a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9011a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AuthorizeActivity.a f9012a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AuthorizeVM f9013a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public ActivityAuthorizeBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3, EditText editText, TextView textView4) {
        super(obj, view, i);
        this.f9010a = imageView;
        this.f9011a = textView;
        this.b = textView2;
        this.c = textView3;
        this.f33996a = editText;
        this.d = textView4;
    }

    public static ActivityAuthorizeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAuthorizeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityAuthorizeBinding) ViewDataBinding.bind(obj, view, R.layout.activity_authorize);
    }

    @NonNull
    public static ActivityAuthorizeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityAuthorizeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAuthorizeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAuthorizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_authorize, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityAuthorizeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAuthorizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_authorize, null, false, obj);
    }

    @Nullable
    public AuthorizeActivity.a f() {
        return this.f9012a;
    }

    @Nullable
    public AuthorizeVM g() {
        return this.f9013a;
    }

    public abstract void l(@Nullable AuthorizeActivity.a aVar);

    public abstract void m(@Nullable AuthorizeVM authorizeVM);
}
