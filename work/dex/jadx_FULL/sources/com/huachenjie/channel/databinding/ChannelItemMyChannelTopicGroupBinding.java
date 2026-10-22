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
import com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemMyChannelTopicGroupBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public MyChannelTopicGroup f33288a;

    public ChannelItemMyChannelTopicGroupBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemMyChannelTopicGroupBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemMyChannelTopicGroupBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemMyChannelTopicGroupBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_my_channel_topic_group);
    }

    @NonNull
    public static ChannelItemMyChannelTopicGroupBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemMyChannelTopicGroupBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelTopicGroupBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemMyChannelTopicGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_topic_group, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelTopicGroupBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemMyChannelTopicGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_topic_group, null, false, obj);
    }

    @Nullable
    public MyChannelTopicGroup f() {
        return this.f33288a;
    }

    public abstract void k(@Nullable MyChannelTopicGroup myChannelTopicGroup);
}
