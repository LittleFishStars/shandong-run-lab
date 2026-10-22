package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.pay.PayResultActivity;
import com.huachenjie.mall.page.pay.PayResultVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityPayResultBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34832a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PayResultActivity.a f10320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public PayResultVM f10321a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10322a;

    @NonNull
    public final BLTextView b;

    public MallActivityPayResultBinding(Object obj, View view, int i, LayoutToolbarBindingBinding layoutToolbarBindingBinding, TextView textView, BLTextView bLTextView, BLTextView bLTextView2) {
        super(obj, view, i);
        this.f10319a = layoutToolbarBindingBinding;
        this.f34832a = textView;
        this.f10322a = bLTextView;
        this.b = bLTextView2;
    }

    public static MallActivityPayResultBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityPayResultBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityPayResultBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_pay_result);
    }

    @NonNull
    public static MallActivityPayResultBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityPayResultBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityPayResultBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityPayResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_pay_result, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityPayResultBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityPayResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_pay_result, null, false, obj);
    }

    @Nullable
    public PayResultActivity.a f() {
        return this.f10320a;
    }

    @Nullable
    public PayResultVM g() {
        return this.f10321a;
    }

    public abstract void l(@Nullable PayResultActivity.a aVar);

    public abstract void m(@Nullable PayResultVM payResultVM);
}
