package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.StrokeTextView;
import com.huachenjie.home.R;
import com.huachenjie.home.page.change_reward.ChangeRewardActivity;
import com.huachenjie.home.page.change_reward.ChangeRewardVM;
import com.noober.background.view.BLRelativeLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeActivityChangeRewardBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager2 f9263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f9264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f9265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StrokeTextView f9266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChangeRewardActivity.a f9267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChangeRewardVM f9268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLRelativeLayout f9269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9270a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLTextView f9271b;

    public HomeActivityChangeRewardBinding(Object obj, View view, int i, ImageView imageView, BLRelativeLayout bLRelativeLayout, SlidingTabLayout2 slidingTabLayout2, LayoutToolbarBindingBinding layoutToolbarBindingBinding, StrokeTextView strokeTextView, BLTextView bLTextView, BLTextView bLTextView2, ImageView imageView2, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f34199a = imageView;
        this.f9269a = bLRelativeLayout;
        this.f9264a = slidingTabLayout2;
        this.f9265a = layoutToolbarBindingBinding;
        this.f9266a = strokeTextView;
        this.f9270a = bLTextView;
        this.f9271b = bLTextView2;
        this.b = imageView2;
        this.f9263a = viewPager2;
    }

    public static HomeActivityChangeRewardBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeActivityChangeRewardBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeActivityChangeRewardBinding) ViewDataBinding.bind(obj, view, R.layout.home_activity_change_reward);
    }

    @NonNull
    public static HomeActivityChangeRewardBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeActivityChangeRewardBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeActivityChangeRewardBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeActivityChangeRewardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_change_reward, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeActivityChangeRewardBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeActivityChangeRewardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_change_reward, null, false, obj);
    }

    @Nullable
    public ChangeRewardActivity.a f() {
        return this.f9267a;
    }

    @Nullable
    public ChangeRewardVM g() {
        return this.f9268a;
    }

    public abstract void l(@Nullable ChangeRewardActivity.a aVar);

    public abstract void m(@Nullable ChangeRewardVM changeRewardVM);
}
