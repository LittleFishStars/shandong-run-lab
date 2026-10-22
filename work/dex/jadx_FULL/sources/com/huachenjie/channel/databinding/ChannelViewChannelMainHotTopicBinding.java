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
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.channel_main.topic.ChannelMainHotTopicAdapter;
import com.huachenjie.channel.page.channel_main.topic.ChannelMainTopicFragment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelViewChannelMainHotTopicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f8226a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelMainHotTopicAdapter f8227a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelMainTopicFragment.a f8228a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f8229a;

    public ChannelViewChannelMainHotTopicBinding(Object obj, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.f8226a = recyclerView;
        this.f33330a = textView;
    }

    public static ChannelViewChannelMainHotTopicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelViewChannelMainHotTopicBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelViewChannelMainHotTopicBinding) ViewDataBinding.bind(obj, view, R.layout.channel_view_channel_main_hot_topic);
    }

    @NonNull
    public static ChannelViewChannelMainHotTopicBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelViewChannelMainHotTopicBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelViewChannelMainHotTopicBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelViewChannelMainHotTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_view_channel_main_hot_topic, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelViewChannelMainHotTopicBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelViewChannelMainHotTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_view_channel_main_hot_topic, null, false, obj);
    }

    @Nullable
    public ChannelMainHotTopicAdapter f() {
        return this.f8227a;
    }

    @Nullable
    public ChannelMainTopicFragment.a g() {
        return this.f8228a;
    }

    @Nullable
    public Boolean h() {
        return this.f8229a;
    }

    public abstract void m(@Nullable ChannelMainHotTopicAdapter channelMainHotTopicAdapter);

    public abstract void n(@Nullable ChannelMainTopicFragment.a aVar);

    public abstract void o(@Nullable Boolean bool);
}
