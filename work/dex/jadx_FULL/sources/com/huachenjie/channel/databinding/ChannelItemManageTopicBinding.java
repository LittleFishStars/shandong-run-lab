package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.my_channel.MyChannelTopic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemManageTopicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f33268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyChannelTopic f8030a;

    public ChannelItemManageTopicBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.f33268a = imageView;
    }

    public static ChannelItemManageTopicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemManageTopicBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemManageTopicBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_manage_topic);
    }

    @NonNull
    public static ChannelItemManageTopicBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemManageTopicBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageTopicBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemManageTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_topic, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageTopicBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemManageTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_topic, null, false, obj);
    }

    @Nullable
    public MyChannelTopic f() {
        return this.f8030a;
    }

    public abstract void k(@Nullable MyChannelTopic myChannelTopic);
}
