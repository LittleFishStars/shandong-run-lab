package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeam;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemManageChatTeamBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyChannelChatTeam f8020a;

    public ChannelItemManageChatTeamBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f33262a = imageView;
    }

    public static ChannelItemManageChatTeamBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemManageChatTeamBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemManageChatTeamBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_manage_chat_team);
    }

    @NonNull
    public static ChannelItemManageChatTeamBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemManageChatTeamBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageChatTeamBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemManageChatTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_chat_team, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageChatTeamBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemManageChatTeamBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_chat_team, null, false, obj);
    }

    @Nullable
    public MyChannelChatTeam f() {
        return this.f8020a;
    }

    public abstract void k(@Nullable MyChannelChatTeam myChannelChatTeam);
}
