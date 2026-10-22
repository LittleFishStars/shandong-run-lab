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
public abstract class ChannelItemTopicListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ManageTopic f33315a;

    public ChannelItemTopicListBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemTopicListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemTopicListBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemTopicListBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_topic_list);
    }

    @NonNull
    public static ChannelItemTopicListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemTopicListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemTopicListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemTopicListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_topic_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemTopicListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemTopicListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_topic_list, null, false, obj);
    }

    @Nullable
    public ManageTopic f() {
        return this.f33315a;
    }

    public abstract void k(@Nullable ManageTopic manageTopic);
}
