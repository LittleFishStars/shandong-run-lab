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
import com.huachenjie.channel.page.channel_main.topic.ChannelMainTopicVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentChannelMainTopicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ChannelMainTopicVM f33163a;

    public ChannelFragmentChannelMainTopicBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelFragmentChannelMainTopicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentChannelMainTopicBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentChannelMainTopicBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_channel_main_topic);
    }

    @NonNull
    public static ChannelFragmentChannelMainTopicBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentChannelMainTopicBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentChannelMainTopicBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentChannelMainTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_channel_main_topic, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentChannelMainTopicBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentChannelMainTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_channel_main_topic, null, false, obj);
    }

    @Nullable
    public ChannelMainTopicVM f() {
        return this.f33163a;
    }

    public abstract void k(@Nullable ChannelMainTopicVM channelMainTopicVM);
}
