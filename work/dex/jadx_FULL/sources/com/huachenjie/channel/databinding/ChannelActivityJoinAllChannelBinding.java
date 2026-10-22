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
import com.huachenjie.channel.page.all_channel.JoinAllChannelVM;
import com.huachenjie.common.widget.SelectBoldTabLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityJoinAllChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f33084a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public JoinAllChannelVM f7559a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SelectBoldTabLayout f7560a;

    public ChannelActivityJoinAllChannelBinding(Object obj, View view, int i, SelectBoldTabLayout selectBoldTabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f7560a = selectBoldTabLayout;
        this.f33084a = viewPager2;
    }

    public static ChannelActivityJoinAllChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityJoinAllChannelBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityJoinAllChannelBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_join_all_channel);
    }

    @NonNull
    public static ChannelActivityJoinAllChannelBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityJoinAllChannelBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityJoinAllChannelBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityJoinAllChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_join_all_channel, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityJoinAllChannelBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityJoinAllChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_join_all_channel, null, false, obj);
    }

    @Nullable
    public JoinAllChannelVM f() {
        return this.f7559a;
    }

    public abstract void k(@Nullable JoinAllChannelVM joinAllChannelVM);
}
