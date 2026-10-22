package com.huachenjie.sport.databinding;

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
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class DialogHuodongLimitBottomBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36448a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13397a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13398a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseVM f13399a;

    @NonNull
    public final TextView b;

    public DialogHuodongLimitBottomBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.f13397a = imageView;
        this.f13398a = textView;
        this.b = textView2;
        this.f36448a = view2;
    }

    public static DialogHuodongLimitBottomBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogHuodongLimitBottomBinding d(@NonNull View view, @Nullable Object obj) {
        return (DialogHuodongLimitBottomBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_huodong_limit_bottom);
    }

    @NonNull
    public static DialogHuodongLimitBottomBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogHuodongLimitBottomBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogHuodongLimitBottomBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogHuodongLimitBottomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_huodong_limit_bottom, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static DialogHuodongLimitBottomBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogHuodongLimitBottomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_huodong_limit_bottom, null, false, obj);
    }

    @Nullable
    public BaseVM f() {
        return this.f13399a;
    }

    public abstract void k(@Nullable BaseVM baseVM);
}
