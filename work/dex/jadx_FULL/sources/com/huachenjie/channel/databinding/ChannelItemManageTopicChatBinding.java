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
import com.huachenjie.channel.bean.manage_topic_chat.ManageTopicChat;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemManageTopicChatBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f8035a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ManageTopicChat f8036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f8037a;

    public ChannelItemManageTopicChatBinding(Object obj, View view, int i, ImageView imageView, BLTextView bLTextView, TextView textView) {
        super(obj, view, i);
        this.f33270a = imageView;
        this.f8037a = bLTextView;
        this.f8035a = textView;
    }

    public static ChannelItemManageTopicChatBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemManageTopicChatBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemManageTopicChatBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_manage_topic_chat);
    }

    @NonNull
    public static ChannelItemManageTopicChatBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemManageTopicChatBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageTopicChatBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemManageTopicChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_topic_chat, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageTopicChatBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemManageTopicChatBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_topic_chat, null, false, obj);
    }

    @Nullable
    public ManageTopicChat f() {
        return this.f8036a;
    }

    public abstract void k(@Nullable ManageTopicChat manageTopicChat);
}
