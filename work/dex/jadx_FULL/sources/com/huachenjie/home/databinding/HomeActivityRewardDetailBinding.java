package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.huachenjie.home.page.reward_detail.RewardDetailActivity;
import com.huachenjie.home.page.reward_detail.RewardDetailVM;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeActivityRewardDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RewardDetailActivity.a f9309a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RewardDetailVM f9310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f9311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f9312a;

    public HomeActivityRewardDetailBinding(Object obj, View view, int i, BLFrameLayout bLFrameLayout, BLLinearLayout bLLinearLayout, TextView textView) {
        super(obj, view, i);
        this.f9311a = bLFrameLayout;
        this.f9312a = bLLinearLayout;
        this.f34213a = textView;
    }

    public static HomeActivityRewardDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeActivityRewardDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeActivityRewardDetailBinding) ViewDataBinding.bind(obj, view, R.layout.home_activity_reward_detail);
    }

    @NonNull
    public static HomeActivityRewardDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeActivityRewardDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeActivityRewardDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeActivityRewardDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_reward_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeActivityRewardDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeActivityRewardDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_reward_detail, null, false, obj);
    }

    @Nullable
    public RewardDetailActivity.a f() {
        return this.f9309a;
    }

    @Nullable
    public RewardDetailVM g() {
        return this.f9310a;
    }

    public abstract void l(@Nullable RewardDetailActivity.a aVar);

    public abstract void m(@Nullable RewardDetailVM rewardDetailVM);
}
