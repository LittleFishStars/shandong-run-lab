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
import com.huachenjie.home.bean.PointsGoodsBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemPointsGoodStuffBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9513a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f9515a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PointsGoodsBean f9516a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public HomeItemPointsGoodStuffBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f34285a = imageView;
        this.f9515a = constraintLayout;
        this.f9513a = linearLayout;
        this.f9514a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    public static HomeItemPointsGoodStuffBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemPointsGoodStuffBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemPointsGoodStuffBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_points_good_stuff);
    }

    @NonNull
    public static HomeItemPointsGoodStuffBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemPointsGoodStuffBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemPointsGoodStuffBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemPointsGoodStuffBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_points_good_stuff, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemPointsGoodStuffBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemPointsGoodStuffBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_points_good_stuff, null, false, obj);
    }

    @Nullable
    public PointsGoodsBean f() {
        return this.f9516a;
    }

    public abstract void k(@Nullable PointsGoodsBean pointsGoodsBean);
}
