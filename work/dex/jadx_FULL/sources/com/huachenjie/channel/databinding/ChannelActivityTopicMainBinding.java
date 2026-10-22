package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.topic_main.TopicMainActivity;
import com.huachenjie.channel.page.topic_main.TopicMainVM;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityTopicMainBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33134a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TopicMainActivity.a f7706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TopicMainVM f7707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f7708a;

    @NonNull
    public final BLImageView b;

    public ChannelActivityTopicMainBinding(Object obj, View view, int i, BLImageView bLImageView, BLImageView bLImageView2, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f7708a = bLImageView;
        this.b = bLImageView2;
        this.f33134a = recyclerView;
    }

    public static ChannelActivityTopicMainBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityTopicMainBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityTopicMainBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_topic_main);
    }

    @NonNull
    public static ChannelActivityTopicMainBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityTopicMainBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityTopicMainBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityTopicMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_topic_main, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityTopicMainBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityTopicMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_topic_main, null, false, obj);
    }

    @Nullable
    public TopicMainActivity.a f() {
        return this.f7706a;
    }

    @Nullable
    public TopicMainVM g() {
        return this.f7707a;
    }

    public abstract void l(@Nullable TopicMainActivity.a aVar);

    public abstract void m(@Nullable TopicMainVM topicMainVM);
}
