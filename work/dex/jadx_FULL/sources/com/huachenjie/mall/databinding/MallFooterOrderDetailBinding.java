package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.order_detail.OrderDetailActivity;
import com.huachenjie.mall.page.order_detail.OrderDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallFooterOrderDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34936a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderDetailActivity.ClickProxy f10627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrderDetailVM f10628a;

    @NonNull
    public final LinearLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f10629b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final LinearLayout d;

    public MallFooterOrderDetailBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.f10625a = linearLayout;
        this.b = linearLayout2;
        this.c = linearLayout3;
        this.d = linearLayout4;
        this.f10626a = textView;
        this.f10629b = textView2;
        this.f34936a = view2;
    }

    public static MallFooterOrderDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallFooterOrderDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallFooterOrderDetailBinding) ViewDataBinding.bind(obj, view, R.layout.mall_footer_order_detail);
    }

    @NonNull
    public static MallFooterOrderDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallFooterOrderDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallFooterOrderDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallFooterOrderDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_footer_order_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallFooterOrderDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallFooterOrderDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_footer_order_detail, null, false, obj);
    }

    @Nullable
    public OrderDetailActivity.ClickProxy f() {
        return this.f10627a;
    }

    @Nullable
    public OrderDetailVM g() {
        return this.f10628a;
    }

    public abstract void l(@Nullable OrderDetailActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable OrderDetailVM orderDetailVM);
}
