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
import com.huachenjie.channel.bean.my_channel.MyChannelTopicChat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemMyChannelTopicChatBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public MyChannelTopicChat f33286a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f8082a;

    public ChannelItemMyChannelTopicChatBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemMyChannelTopicChatBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemMyChannelTopicChatBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemMyChannelTopicChatBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_my_channel_topic_chat);
    }

    @NonNull
    public static ChannelItemMyChannelTopicChatBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemMyChannelTopicChatBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelTopicChatBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemMyChannelTopicChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_topic_chat, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelTopicChatBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemMyChannelTopicChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_topic_chat, null, false, obj);
    }

    @Nullable
    public MyChannelTopicChat f() {
        return this.f33286a;
    }

    @Nullable
    public Boolean g() {
        return this.f8082a;
    }

    public abstract void l(@Nullable MyChannelTopicChat myChannelTopicChat);

    public abstract void m(@Nullable Boolean bool);
}
