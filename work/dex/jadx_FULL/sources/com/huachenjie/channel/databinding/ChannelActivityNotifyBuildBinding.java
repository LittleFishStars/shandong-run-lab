package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.notify.broad_build.NotifyBroadBuildVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityNotifyBuildBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f33098a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NotifyBroadBuildVM f7603a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SelectBoldTabLayout f7605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f7606a;

    public ChannelActivityNotifyBuildBinding(Object obj, View view, int i, SelectBoldTabLayout selectBoldTabLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding, BLView bLView, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f7605a = selectBoldTabLayout;
        this.f7604a = layoutToolbarBindingBinding;
        this.f7606a = bLView;
        this.f33098a = viewPager2;
    }

    public static ChannelActivityNotifyBuildBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityNotifyBuildBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityNotifyBuildBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_notify_build);
    }

    @NonNull
    public static ChannelActivityNotifyBuildBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityNotifyBuildBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityNotifyBuildBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityNotifyBuildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_notify_build, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityNotifyBuildBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityNotifyBuildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_notify_build, null, false, obj);
    }

    @Nullable
    public NotifyBroadBuildVM f() {
        return this.f7603a;
    }

    public abstract void k(@Nullable NotifyBroadBuildVM notifyBroadBuildVM);
}
