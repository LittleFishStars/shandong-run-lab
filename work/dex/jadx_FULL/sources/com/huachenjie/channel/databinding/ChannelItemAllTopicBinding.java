package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelTopicBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemAllTopicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelTopicBean f7919a;

    @NonNull
    public final TextView b;

    public ChannelItemAllTopicBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f33224a = textView;
        this.b = textView2;
    }

    public static ChannelItemAllTopicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemAllTopicBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemAllTopicBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_all_topic);
    }

    @NonNull
    public static ChannelItemAllTopicBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemAllTopicBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemAllTopicBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemAllTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_all_topic, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemAllTopicBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemAllTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_all_topic, null, false, obj);
    }

    @Nullable
    public ChannelTopicBean f() {
        return this.f7919a;
    }

    public abstract void k(@Nullable ChannelTopicBean channelTopicBean);
}
