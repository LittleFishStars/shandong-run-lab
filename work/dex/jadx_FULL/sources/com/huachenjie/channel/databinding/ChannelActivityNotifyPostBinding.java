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
import com.huachenjie.channel.page.notify.post.NotifyPostVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityNotifyPostBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f33103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NotifyPostVM f7618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SelectBoldTabLayout f7620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f7621a;

    public ChannelActivityNotifyPostBinding(Object obj, View view, int i, SelectBoldTabLayout selectBoldTabLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding, BLView bLView, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f7620a = selectBoldTabLayout;
        this.f7619a = layoutToolbarBindingBinding;
        this.f7621a = bLView;
        this.f33103a = viewPager2;
    }

    public static ChannelActivityNotifyPostBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityNotifyPostBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityNotifyPostBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_notify_post);
    }

    @NonNull
    public static ChannelActivityNotifyPostBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityNotifyPostBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityNotifyPostBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityNotifyPostBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_notify_post, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityNotifyPostBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityNotifyPostBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_notify_post, null, false, obj);
    }

    @Nullable
    public NotifyPostVM f() {
        return this.f7618a;
    }

    public abstract void k(@Nullable NotifyPostVM notifyPostVM);
}
