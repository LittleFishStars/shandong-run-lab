package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelChatTeamGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemManageChatTeamGroupBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyChannelChatTeamGroup f8026a;

    @NonNull
    public final TextView b;

    public ChannelItemManageChatTeamGroupBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f33264a = imageView;
        this.f8025a = textView;
        this.b = textView2;
    }

    public static ChannelItemManageChatTeamGroupBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemManageChatTeamGroupBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemManageChatTeamGroupBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_manage_chat_team_group);
    }

    @NonNull
    public static ChannelItemManageChatTeamGroupBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemManageChatTeamGroupBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageChatTeamGroupBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemManageChatTeamGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_chat_team_group, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageChatTeamGroupBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemManageChatTeamGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_chat_team_group, null, false, obj);
    }

    @Nullable
    public MyChannelChatTeamGroup f() {
        return this.f8026a;
    }

    public abstract void k(@Nullable MyChannelChatTeamGroup myChannelChatTeamGroup);
}
