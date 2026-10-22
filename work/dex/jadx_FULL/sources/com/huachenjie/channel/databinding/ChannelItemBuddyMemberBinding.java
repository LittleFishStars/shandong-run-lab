package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.notify.BuddyDetailUserBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemBuddyMemberBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public BuddyDetailUserBean f33226a;

    public ChannelItemBuddyMemberBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemBuddyMemberBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemBuddyMemberBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemBuddyMemberBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_buddy_member);
    }

    @NonNull
    public static ChannelItemBuddyMemberBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemBuddyMemberBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemBuddyMemberBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemBuddyMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_buddy_member, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemBuddyMemberBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemBuddyMemberBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_buddy_member, null, false, obj);
    }

    @Nullable
    public BuddyDetailUserBean f() {
        return this.f33226a;
    }

    public abstract void k(@Nullable BuddyDetailUserBean buddyDetailUserBean);
}
