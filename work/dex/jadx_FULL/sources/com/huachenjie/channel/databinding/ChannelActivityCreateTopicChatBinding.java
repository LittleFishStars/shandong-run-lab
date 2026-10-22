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
import com.huachenjie.channel.page.manage_channel.topic_chat.CreateTopicChatActivity;
import com.huachenjie.channel.page.manage_channel.topic_chat.CreateTopicChatVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityCreateTopicChatBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public CreateTopicChatActivity.ClickProxy f33067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CreateTopicChatVM f7512a;

    public ChannelActivityCreateTopicChatBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelActivityCreateTopicChatBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityCreateTopicChatBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityCreateTopicChatBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_create_topic_chat);
    }

    @NonNull
    public static ChannelActivityCreateTopicChatBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityCreateTopicChatBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityCreateTopicChatBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityCreateTopicChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_create_topic_chat, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityCreateTopicChatBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityCreateTopicChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_create_topic_chat, null, false, obj);
    }

    @Nullable
    public CreateTopicChatActivity.ClickProxy f() {
        return this.f33067a;
    }

    @Nullable
    public CreateTopicChatVM g() {
        return this.f7512a;
    }

    public abstract void l(@Nullable CreateTopicChatActivity.ClickProxy clickProxy);

    public abstract void m(@Nullable CreateTopicChatVM createTopicChatVM);
}
