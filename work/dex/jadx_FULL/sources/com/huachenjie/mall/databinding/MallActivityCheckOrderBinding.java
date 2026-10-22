package com.huachenjie.mall.databinding;

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
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.check_order.CheckOrderActivity;
import com.huachenjie.mall.page.check_order.CheckOrderVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityCheckOrderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CheckOrderActivity.ClickProxy f10156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CheckOrderVM f10157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10158a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10159b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    @NonNull
    public final TextView i;

    @NonNull
    public final TextView j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    public MallActivityCheckOrderBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, BLTextView bLTextView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        super(obj, view, i);
        this.f34776a = imageView;
        this.b = imageView2;
        this.f10155a = textView;
        this.f10158a = bLTextView;
        this.f10159b = textView2;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
        this.g = textView7;
        this.h = textView8;
        this.i = textView9;
        this.j = textView10;
        this.k = textView11;
        this.l = textView12;
    }

    public static MallActivityCheckOrderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityCheckOrderBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityCheckOrderBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_check_order);
    }

    @NonNull
    public static MallActivityCheckOrderBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityCheckOrderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityCheckOrderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityCheckOrderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_check_order, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityCheckOrderBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityCheckOrderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_check_order, null, false, obj);
    }

    @Nullable
    public CheckOrderActivity.ClickProxy f() {
        return this.f10156a;
    }

    @Nullable
    public CheckOrderVM g() {
        return this.f10157a;
    }

    public abstract void l(@Nullable CheckOrderActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable CheckOrderVM checkOrderVM);
}
