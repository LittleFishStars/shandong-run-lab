package com.huachenjie.compat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.compat.R;
import com.huachenjie.compat.page.personal.PersonalV2Activity;
import com.huachenjie.compat.page.personal.PersonalV2VM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class ActivityPersonalV2Binding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34040a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PersonalV2Activity.e f9123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PersonalV2VM f9124a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9125b;

    @NonNull
    public final ImageView c;

    public ActivityPersonalV2Binding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f34040a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.f9122a = textView;
        this.f9125b = textView2;
    }

    public static ActivityPersonalV2Binding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityPersonalV2Binding d(@NonNull View view, @Nullable Object obj) {
        return (ActivityPersonalV2Binding) ViewDataBinding.bind(obj, view, R.layout.activity_personal_v2);
    }

    @NonNull
    public static ActivityPersonalV2Binding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ActivityPersonalV2Binding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityPersonalV2Binding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityPersonalV2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_personal_v2, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ActivityPersonalV2Binding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityPersonalV2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_personal_v2, null, false, obj);
    }

    @Nullable
    public PersonalV2Activity.e f() {
        return this.f9123a;
    }

    @Nullable
    public PersonalV2VM g() {
        return this.f9124a;
    }

    public abstract void l(@Nullable PersonalV2Activity.e eVar);

    public abstract void m(@Nullable PersonalV2VM personalV2VM);
}
