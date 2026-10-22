package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.huachenjie.channel.R;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityAdvertiseBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager f33022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout f7375a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleViewModel f7376a;

    public ChannelActivityAdvertiseBinding(Object obj, View view, int i, SlidingTabLayout slidingTabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.f7375a = slidingTabLayout;
        this.f33022a = viewPager;
    }

    public static ChannelActivityAdvertiseBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityAdvertiseBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityAdvertiseBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_advertise);
    }

    @NonNull
    public static ChannelActivityAdvertiseBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityAdvertiseBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAdvertiseBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityAdvertiseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_advertise, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAdvertiseBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityAdvertiseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_advertise, null, false, obj);
    }

    @Nullable
    public BaseTitleViewModel f() {
        return this.f7376a;
    }

    public abstract void k(@Nullable BaseTitleViewModel baseTitleViewModel);
}
