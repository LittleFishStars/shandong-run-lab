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
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemMyChannelChatTeamBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public MyChannelChatTeam f33276a;

    public ChannelItemMyChannelChatTeamBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemMyChannelChatTeamBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemMyChannelChatTeamBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemMyChannelChatTeamBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_my_channel_chat_team);
    }

    @NonNull
    public static ChannelItemMyChannelChatTeamBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemMyChannelChatTeamBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelChatTeamBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemMyChannelChatTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_chat_team, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelChatTeamBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemMyChannelChatTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_chat_team, null, false, obj);
    }

    @Nullable
    public MyChannelChatTeam f() {
        return this.f33276a;
    }

    public abstract void k(@Nullable MyChannelChatTeam myChannelChatTeam);
}
