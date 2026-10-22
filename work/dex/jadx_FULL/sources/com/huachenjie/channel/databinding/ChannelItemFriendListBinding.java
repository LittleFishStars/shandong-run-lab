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
public abstract class ChannelItemFriendListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public FriendListBean f33245a;

    public ChannelItemFriendListBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemFriendListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemFriendListBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemFriendListBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_friend_list);
    }

    @NonNull
    public static ChannelItemFriendListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemFriendListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemFriendListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemFriendListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_friend_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemFriendListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemFriendListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_friend_list, null, false, obj);
    }

    @Nullable
    public FriendListBean f() {
        return this.f33245a;
    }

    public abstract void k(@Nullable FriendListBean friendListBean);
}
