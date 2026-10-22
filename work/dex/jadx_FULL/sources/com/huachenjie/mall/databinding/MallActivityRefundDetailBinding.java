package com.huachenjie.mall.databinding;

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
import androidx.coroutines.ViewStubProxy;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.refund_detail.RefundDetailActivity;
import com.huachenjie.mall.page.refund_detail.RefundDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityRefundDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewStubProxy f10340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10341a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RefundDetailActivity.ClickProxy f10343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RefundDetailVM f10344a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10345b;

    @NonNull
    public final LinearLayout c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f10346c;

    @NonNull
    public final LinearLayout d;

    @NonNull
    public final LinearLayout e;

    public MallActivityRefundDetailBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding, TextView textView, TextView textView2, TextView textView3, ViewStubProxy viewStubProxy) {
        super(obj, view, i);
        this.f34839a = imageView;
        this.f10338a = linearLayout;
        this.b = linearLayout2;
        this.c = linearLayout3;
        this.d = linearLayout4;
        this.e = linearLayout5;
        this.f10341a = recyclerView;
        this.f10342a = layoutToolbarBindingBinding;
        this.f10339a = textView;
        this.f10345b = textView2;
        this.f10346c = textView3;
        this.f10340a = viewStubProxy;
    }

    public static MallActivityRefundDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityRefundDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityRefundDetailBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_refund_detail);
    }

    @NonNull
    public static MallActivityRefundDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityRefundDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityRefundDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityRefundDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_refund_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityRefundDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityRefundDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_refund_detail, null, false, obj);
    }

    @Nullable
    public RefundDetailActivity.ClickProxy f() {
        return this.f10343a;
    }

    @Nullable
    public RefundDetailVM g() {
        return this.f10344a;
    }

    public abstract void l(@Nullable RefundDetailActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable RefundDetailVM refundDetailVM);
}
