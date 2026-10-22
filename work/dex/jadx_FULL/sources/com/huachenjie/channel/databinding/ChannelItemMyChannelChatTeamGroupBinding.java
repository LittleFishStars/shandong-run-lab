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
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeamGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemMyChannelChatTeamGroupBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public MyChannelChatTeamGroup f33278a;

    public ChannelItemMyChannelChatTeamGroupBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemMyChannelChatTeamGroupBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemMyChannelChatTeamGroupBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemMyChannelChatTeamGroupBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_my_channel_chat_team_group);
    }

    @NonNull
    public static ChannelItemMyChannelChatTeamGroupBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemMyChannelChatTeamGroupBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelChatTeamGroupBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemMyChannelChatTeamGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_chat_team_group, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelChatTeamGroupBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemMyChannelChatTeamGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_chat_team_group, null, false, obj);
    }

    @Nullable
    public MyChannelChatTeamGroup f() {
        return this.f33278a;
    }

    public abstract void k(@Nullable MyChannelChatTeamGroup myChannelChatTeamGroup);
}
