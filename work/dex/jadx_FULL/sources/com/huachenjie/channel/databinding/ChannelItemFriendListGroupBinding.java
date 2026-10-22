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
import com.huachenjie.channel.bean.FriendListBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemFriendListGroupBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public FriendListBean f33247a;

    public ChannelItemFriendListGroupBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemFriendListGroupBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemFriendListGroupBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemFriendListGroupBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_friend_list_group);
    }

    @NonNull
    public static ChannelItemFriendListGroupBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemFriendListGroupBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemFriendListGroupBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemFriendListGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_friend_list_group, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemFriendListGroupBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemFriendListGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_friend_list_group, null, false, obj);
    }

    @Nullable
    public FriendListBean f() {
        return this.f33247a;
    }

    public abstract void k(@Nullable FriendListBean friendListBean);
}
