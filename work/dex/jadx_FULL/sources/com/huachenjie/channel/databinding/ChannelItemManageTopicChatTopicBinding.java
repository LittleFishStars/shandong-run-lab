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
import com.huachenjie.channel.bean.manage_topic_chat.ManageTopic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemManageTopicChatTopicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ManageTopic f33272a;

    public ChannelItemManageTopicChatTopicBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemManageTopicChatTopicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemManageTopicChatTopicBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemManageTopicChatTopicBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_manage_topic_chat_topic);
    }

    @NonNull
    public static ChannelItemManageTopicChatTopicBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemManageTopicChatTopicBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageTopicChatTopicBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemManageTopicChatTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_topic_chat_topic, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageTopicChatTopicBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemManageTopicChatTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_topic_chat_topic, null, false, obj);
    }

    @Nullable
    public ManageTopic f() {
        return this.f33272a;
    }

    public abstract void k(@Nullable ManageTopic manageTopic);
}
