package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.home.R;
import com.huachenjie.home.page.reward_record.RewardRecordActivity;
import com.huachenjie.home.page.reward_record.RewardRecordVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeActivityRewardRecordBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f9330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RewardRecordActivity.a f9331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RewardRecordVM f9332a;

    public HomeActivityRewardRecordBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f34217a = recyclerView;
        this.f9330a = stateLayout;
    }

    public static HomeActivityRewardRecordBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeActivityRewardRecordBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeActivityRewardRecordBinding) ViewDataBinding.bind(obj, view, R.layout.home_activity_reward_record);
    }

    @NonNull
    public static HomeActivityRewardRecordBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeActivityRewardRecordBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeActivityRewardRecordBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeActivityRewardRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_reward_record, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeActivityRewardRecordBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeActivityRewardRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_reward_record, null, false, obj);
    }

    @Nullable
    public RewardRecordActivity.a f() {
        return this.f9331a;
    }

    @Nullable
    public RewardRecordVM g() {
        return this.f9332a;
    }

    public abstract void l(@Nullable RewardRecordActivity.a aVar);

    public abstract void m(@Nullable RewardRecordVM rewardRecordVM);
}
