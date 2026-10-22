package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.home.R;
import com.huachenjie.home.dialog.reward.RewardInfoDialog;
import com.huachenjie.home.dialog.reward.RewardInfoVM;
import com.noober.background.view.BLFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeDialogRewardInfoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LottieAnimationView f9368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RewardInfoDialog.a f9369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RewardInfoVM f9370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLFrameLayout f9371a;

    @NonNull
    public final ImageView b;

    public HomeDialogRewardInfoBinding(Object obj, View view, int i, BLFrameLayout bLFrameLayout, ImageView imageView, ImageView imageView2, LottieAnimationView lottieAnimationView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.f9371a = bLFrameLayout;
        this.f34233a = imageView;
        this.b = imageView2;
        this.f9368a = lottieAnimationView;
        this.f9367a = linearLayout;
    }

    public static HomeDialogRewardInfoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeDialogRewardInfoBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeDialogRewardInfoBinding) ViewDataBinding.bind(obj, view, R.layout.home_dialog_reward_info);
    }

    @NonNull
    public static HomeDialogRewardInfoBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeDialogRewardInfoBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeDialogRewardInfoBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeDialogRewardInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_dialog_reward_info, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeDialogRewardInfoBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeDialogRewardInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_dialog_reward_info, null, false, obj);
    }

    @Nullable
    public RewardInfoDialog.a f() {
        return this.f9369a;
    }

    @Nullable
    public RewardInfoVM g() {
        return this.f9370a;
    }

    public abstract void l(@Nullable RewardInfoDialog.a aVar);

    public abstract void m(@Nullable RewardInfoVM rewardInfoVM);
}
