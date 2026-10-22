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
import com.huachenjie.mall.bean.MyRefundBean;
import com.huachenjie.mall.widget.PriceView;
import com.noober.background.view.BLButton;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemRefundListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyRefundBean f10877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final PriceView f10878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLButton f10879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f10880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10881a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10882a;

    @NonNull
    public final TextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLButton f10883b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public MallItemRefundListBinding(Object obj, View view, int i, BLLinearLayout bLLinearLayout, BLButton bLButton, BLTextView bLTextView, BLButton bLButton2, ImageView imageView, BLImageView bLImageView, TextView textView, TextView textView2, PriceView priceView, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.f10881a = bLLinearLayout;
        this.f10879a = bLButton;
        this.f10882a = bLTextView;
        this.f10883b = bLButton2;
        this.f35025a = imageView;
        this.f10880a = bLImageView;
        this.f10876a = textView;
        this.b = textView2;
        this.f10878a = priceView;
        this.c = textView3;
        this.d = textView4;
        this.e = textView5;
        this.f = textView6;
    }

    public static MallItemRefundListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemRefundListBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemRefundListBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_refund_list);
    }

    @NonNull
    public static MallItemRefundListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemRefundListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemRefundListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemRefundListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_refund_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemRefundListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemRefundListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_refund_list, null, false, obj);
    }

    @Nullable
    public MyRefundBean f() {
        return this.f10877a;
    }

    public abstract void k(@Nullable MyRefundBean myRefundBean);
}
