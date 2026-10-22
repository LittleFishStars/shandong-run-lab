package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.pay.RewardPaySucActivity;
import com.huachenjie.mall.page.pay.RewardPaySucVM;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityRewardPaySucBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public RewardPaySucActivity.a f34846a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RewardPaySucVM f10363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10364a;

    @NonNull
    public final BLTextView b;

    public MallActivityRewardPaySucBinding(Object obj, View view, int i, BLTextView bLTextView, BLTextView bLTextView2) {
        super(obj, view, i);
        this.f10364a = bLTextView;
        this.b = bLTextView2;
    }

    public static MallActivityRewardPaySucBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityRewardPaySucBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityRewardPaySucBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_reward_pay_suc);
    }

    @NonNull
    public static MallActivityRewardPaySucBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityRewardPaySucBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityRewardPaySucBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityRewardPaySucBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_reward_pay_suc, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityRewardPaySucBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityRewardPaySucBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_reward_pay_suc, null, false, obj);
    }

    @Nullable
    public RewardPaySucActivity.a f() {
        return this.f34846a;
    }

    @Nullable
    public RewardPaySucVM g() {
        return this.f10363a;
    }

    public abstract void l(@Nullable RewardPaySucActivity.a aVar);

    public abstract void m(@Nullable RewardPaySucVM rewardPaySucVM);
}
