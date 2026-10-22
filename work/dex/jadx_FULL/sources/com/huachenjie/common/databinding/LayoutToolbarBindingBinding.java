package com.huachenjie.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class LayoutToolbarBindingBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f8702a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BindingTitleBean f8703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f8704a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    public LayoutToolbarBindingBinding(Object _bindingComponent, View _root, int _localFieldCount, ConstraintLayout clTitle, ImageView ivRightIcon, ImageView ivRightSubIcon, ImageView titleLeftBt, ImageView titleLeftSubBt, TextView tvRightText, BLView vRightRedDot) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f8702a = clTitle;
        this.f33786a = ivRightIcon;
        this.b = ivRightSubIcon;
        this.c = titleLeftBt;
        this.d = titleLeftSubBt;
        this.f8701a = tvRightText;
        this.f8704a = vRightRedDot;
    }

    public static LayoutToolbarBindingBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static LayoutToolbarBindingBinding d(@NonNull View view, @Nullable Object component) {
        return (LayoutToolbarBindingBinding) ViewDataBinding.bind(component, view, R.layout.layout_toolbar_binding);
    }

    @NonNull
    public static LayoutToolbarBindingBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static LayoutToolbarBindingBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static LayoutToolbarBindingBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (LayoutToolbarBindingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_toolbar_binding, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static LayoutToolbarBindingBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (LayoutToolbarBindingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.layout_toolbar_binding, null, false, component);
    }

    @Nullable
    public BindingTitleBean f() {
        return this.f8703a;
    }

    public abstract void k(@Nullable BindingTitleBean title);
}
