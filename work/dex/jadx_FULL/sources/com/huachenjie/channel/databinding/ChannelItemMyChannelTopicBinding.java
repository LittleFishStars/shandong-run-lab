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
import com.huachenjie.channel.bean.my_channel.MyChannelTopic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemMyChannelTopicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public MyChannelTopic f33284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f8075a;

    public ChannelItemMyChannelTopicBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelItemMyChannelTopicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemMyChannelTopicBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemMyChannelTopicBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_my_channel_topic);
    }

    @NonNull
    public static ChannelItemMyChannelTopicBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemMyChannelTopicBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelTopicBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemMyChannelTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_topic, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemMyChannelTopicBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemMyChannelTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_my_channel_topic, null, false, obj);
    }

    @Nullable
    public MyChannelTopic f() {
        return this.f33284a;
    }

    @Nullable
    public Boolean g() {
        return this.f8075a;
    }

    public abstract void l(@Nullable MyChannelTopic myChannelTopic);

    public abstract void m(@Nullable Boolean bool);
}
