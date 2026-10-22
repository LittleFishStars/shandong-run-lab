package com.huachenjie.sport.databinding;

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
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.HuodongBean;
import com.huachenjie.sport.widget.HuodongStatusWidget;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class ItemSchoolyardBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f36524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f13628a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HuodongBean f13629a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final HuodongStatusWidget f13630a;

    @NonNull
    public final ImageView b;

    public ItemSchoolyardBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, HuodongStatusWidget huodongStatusWidget) {
        super(obj, view, i);
        this.f13628a = constraintLayout;
        this.f36524a = imageView;
        this.b = imageView2;
        this.f13627a = textView;
        this.f13630a = huodongStatusWidget;
    }

    public static ItemSchoolyardBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemSchoolyardBinding d(@NonNull View view, @Nullable Object obj) {
        return (ItemSchoolyardBinding) ViewDataBinding.bind(obj, view, R.layout.item_schoolyard);
    }

    @NonNull
    public static ItemSchoolyardBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemSchoolyardBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemSchoolyardBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemSchoolyardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_schoolyard, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ItemSchoolyardBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemSchoolyardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_schoolyard, null, false, obj);
    }

    @Nullable
    public HuodongBean f() {
        return this.f13629a;
    }

    public abstract void k(@Nullable HuodongBean huodongBean);
}
