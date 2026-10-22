package com.huachenjie.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.login.R;
import com.huachenjie.login.page.info.alumnus.GenerateAlumnusActivity;
import com.huachenjie.login.page.info.alumnus.GenerateAlumnusModel;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class LoginActivityGenerateAlumnusBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9987a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GenerateAlumnusActivity.a f9989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GenerateAlumnusModel f9990a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f9991a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9992b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9993b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f9994c;

    @NonNull
    public final TextView d;

    public LoginActivityGenerateAlumnusBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, BLImageView bLImageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f34644a = imageView;
        this.b = imageView2;
        this.f9991a = bLImageView;
        this.f9987a = linearLayout;
        this.f9992b = linearLayout2;
        this.c = linearLayout3;
        this.f9988a = textView;
        this.f9993b = textView2;
        this.f9994c = textView3;
        this.d = textView4;
    }

    public static LoginActivityGenerateAlumnusBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LoginActivityGenerateAlumnusBinding d(@NonNull View view, @Nullable Object obj) {
        return (LoginActivityGenerateAlumnusBinding) ViewDataBinding.bind(obj, view, R.layout.login_activity_generate_alumnus);
    }

    @NonNull
    public static LoginActivityGenerateAlumnusBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LoginActivityGenerateAlumnusBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LoginActivityGenerateAlumnusBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (LoginActivityGenerateAlumnusBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_generate_alumnus, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static LoginActivityGenerateAlumnusBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (LoginActivityGenerateAlumnusBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.login_activity_generate_alumnus, null, false, obj);
    }

    @Nullable
    public GenerateAlumnusActivity.a f() {
        return this.f9989a;
    }

    @Nullable
    public GenerateAlumnusModel g() {
        return this.f9990a;
    }

    public abstract void l(@Nullable GenerateAlumnusActivity.a aVar);

    public abstract void m(@Nullable GenerateAlumnusModel generateAlumnusModel);
}
