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
import com.huachenjie.channel.page.manage_channel.topic_chat.ManageTopicChatVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentManageTopicChatBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ManageTopicChatVM f33190a;

    public ChannelFragmentManageTopicChatBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelFragmentManageTopicChatBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentManageTopicChatBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentManageTopicChatBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_manage_topic_chat);
    }

    @NonNull
    public static ChannelFragmentManageTopicChatBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentManageTopicChatBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentManageTopicChatBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentManageTopicChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_manage_topic_chat, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentManageTopicChatBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentManageTopicChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_manage_topic_chat, null, false, obj);
    }

    @Nullable
    public ManageTopicChatVM f() {
        return this.f33190a;
    }

    public abstract void k(@Nullable ManageTopicChatVM manageTopicChatVM);
}
