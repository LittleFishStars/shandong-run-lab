package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.GoodStuffBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemGoodStuffBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9465a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9466a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodStuffBean f9467a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public HomeItemGoodStuffBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.f34269a = imageView;
        this.f9466a = constraintLayout;
        this.f9464a = linearLayout;
        this.f9465a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
    }

    public static HomeItemGoodStuffBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemGoodStuffBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemGoodStuffBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_good_stuff);
    }

    @NonNull
    public static HomeItemGoodStuffBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemGoodStuffBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemGoodStuffBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemGoodStuffBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_good_stuff, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemGoodStuffBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemGoodStuffBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_good_stuff, null, false, obj);
    }

    @Nullable
    public GoodStuffBean f() {
        return this.f9467a;
    }

    public abstract void k(@Nullable GoodStuffBean goodStuffBean);
}
