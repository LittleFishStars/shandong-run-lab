package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.address.reward.RewardShippingAddressActivity;
import com.huachenjie.mall.page.address.reward.RewardShippingAddressVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityRewardShippingAddressBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f10372a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RewardShippingAddressActivity.a f10374a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RewardShippingAddressVM f10375a;

    public MallActivityRewardShippingAddressBinding(Object obj, View view, int i, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f34850a = recyclerView;
        this.f10373a = layoutToolbarBindingBinding;
    }

    public static MallActivityRewardShippingAddressBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityRewardShippingAddressBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityRewardShippingAddressBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_reward_shipping_address);
    }

    @NonNull
    public static MallActivityRewardShippingAddressBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityRewardShippingAddressBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityRewardShippingAddressBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityRewardShippingAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_reward_shipping_address, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityRewardShippingAddressBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityRewardShippingAddressBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_reward_shipping_address, null, false, obj);
    }

    @Nullable
    public RewardShippingAddressActivity.a f() {
        return this.f10374a;
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener g() {
        return this.f10372a;
    }

    @Nullable
    public RewardShippingAddressVM h() {
        return this.f10375a;
    }

    public abstract void m(@Nullable RewardShippingAddressActivity.a aVar);

    public abstract void n(@Nullable RewardShippingAddressVM rewardShippingAddressVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
