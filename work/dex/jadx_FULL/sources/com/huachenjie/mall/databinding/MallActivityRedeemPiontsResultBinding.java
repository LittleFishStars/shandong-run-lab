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
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.redeem_points.RedeemPointsResultActivity;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityRedeemPiontsResultBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34836a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleViewModel f10331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RedeemPointsResultActivity.a f10332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10333a;

    public MallActivityRedeemPiontsResultBinding(Object obj, View view, int i, LayoutToolbarBindingBinding layoutToolbarBindingBinding, TextView textView, BLTextView bLTextView) {
        super(obj, view, i);
        this.f10330a = layoutToolbarBindingBinding;
        this.f34836a = textView;
        this.f10333a = bLTextView;
    }

    public static MallActivityRedeemPiontsResultBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityRedeemPiontsResultBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityRedeemPiontsResultBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_redeem_pionts_result);
    }

    @NonNull
    public static MallActivityRedeemPiontsResultBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityRedeemPiontsResultBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityRedeemPiontsResultBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityRedeemPiontsResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_redeem_pionts_result, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityRedeemPiontsResultBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityRedeemPiontsResultBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_redeem_pionts_result, null, false, obj);
    }

    @Nullable
    public RedeemPointsResultActivity.a f() {
        return this.f10332a;
    }

    @Nullable
    public BaseTitleViewModel g() {
        return this.f10331a;
    }

    public abstract void l(@Nullable RedeemPointsResultActivity.a aVar);

    public abstract void m(@Nullable BaseTitleViewModel baseTitleViewModel);
}
