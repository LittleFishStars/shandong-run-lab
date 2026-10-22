package com.huachenjie.home.databinding;

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
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.base.view.RoundImageView;
import com.huachenjie.home.R;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemRewardRecordBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RewardInfoBean f9523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RoundImageView f9524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9525a;

    public HomeItemRewardRecordBinding(Object obj, View view, int i, RoundImageView roundImageView, View view2, LinearLayout linearLayout, BLTextView bLTextView, TextView textView) {
        super(obj, view, i);
        this.f9524a = roundImageView;
        this.f34287a = view2;
        this.f9521a = linearLayout;
        this.f9525a = bLTextView;
        this.f9522a = textView;
    }

    public static HomeItemRewardRecordBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemRewardRecordBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemRewardRecordBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_reward_record);
    }

    @NonNull
    public static HomeItemRewardRecordBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemRewardRecordBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemRewardRecordBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemRewardRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_reward_record, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemRewardRecordBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemRewardRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_reward_record, null, false, obj);
    }

    @Nullable
    public RewardInfoBean f() {
        return this.f9523a;
    }

    public abstract void k(@Nullable RewardInfoBean rewardInfoBean);
}
