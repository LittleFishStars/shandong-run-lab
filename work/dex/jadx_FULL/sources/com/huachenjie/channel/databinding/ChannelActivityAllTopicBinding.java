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
import com.huachenjie.channel.page.all_topic.AllTopicVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityAllTopicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public AllTopicVM f33036a;

    public ChannelActivityAllTopicBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelActivityAllTopicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityAllTopicBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityAllTopicBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_all_topic);
    }

    @NonNull
    public static ChannelActivityAllTopicBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityAllTopicBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAllTopicBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityAllTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_all_topic, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityAllTopicBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityAllTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_all_topic, null, false, obj);
    }

    @Nullable
    public AllTopicVM f() {
        return this.f33036a;
    }

    public abstract void k(@Nullable AllTopicVM allTopicVM);
}
