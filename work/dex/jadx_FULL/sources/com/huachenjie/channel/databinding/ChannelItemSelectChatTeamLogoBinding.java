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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemSelectChatTeamLogoBinding extends ViewDataBinding {

    @Bindable
    public String f;

    public ChannelItemSelectChatTeamLogoBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemSelectChatTeamLogoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemSelectChatTeamLogoBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemSelectChatTeamLogoBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_select_chat_team_logo);
    }

    @NonNull
    public static ChannelItemSelectChatTeamLogoBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemSelectChatTeamLogoBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemSelectChatTeamLogoBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemSelectChatTeamLogoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_select_chat_team_logo, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemSelectChatTeamLogoBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemSelectChatTeamLogoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_select_chat_team_logo, null, false, obj);
    }

    @Nullable
    public String f() {
        return this.f;
    }

    public abstract void k(@Nullable String str);
}
