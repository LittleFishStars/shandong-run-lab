package com.huachenjie.compat.databinding;

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
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.about_as.AboutAsActivity;
import com.huachenjie.compat.page.about_as.AboutAsVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ActivityAboutAsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f8979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AboutAsActivity.a f8981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AboutAsVM f8982a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public ActivityAboutAsBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.f33982a = imageView;
        this.f8979a = linearLayout;
        this.f8980a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
    }

    public static ActivityAboutAsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAboutAsBinding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityAboutAsBinding) ViewDataBinding.bind(obj, view, R.layout.activity_about_as);
    }

    @NonNull
    public static ActivityAboutAsBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityAboutAsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAboutAsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAboutAsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_about_as, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityAboutAsBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAboutAsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_about_as, null, false, obj);
    }

    @Nullable
    public AboutAsActivity.a f() {
        return this.f8981a;
    }

    @Nullable
    public AboutAsVM g() {
        return this.f8982a;
    }

    public abstract void l(@Nullable AboutAsActivity.a aVar);

    public abstract void m(@Nullable AboutAsVM aboutAsVM);
}
