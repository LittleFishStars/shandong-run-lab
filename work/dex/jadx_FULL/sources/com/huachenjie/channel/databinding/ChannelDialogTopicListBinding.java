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
import com.huachenjie.channel.page.manage_channel.topic_chat.TopicListDialog;
import com.huachenjie.channel.page.manage_channel.topic_chat.TopicListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelDialogTopicListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public TopicListDialog.a f33155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public TopicListVM f7758a;

    public ChannelDialogTopicListBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelDialogTopicListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelDialogTopicListBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelDialogTopicListBinding) ViewDataBinding.bind(obj, view, R.layout.channel_dialog_topic_list);
    }

    @NonNull
    public static ChannelDialogTopicListBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelDialogTopicListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelDialogTopicListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelDialogTopicListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_dialog_topic_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelDialogTopicListBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelDialogTopicListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_dialog_topic_list, null, false, obj);
    }

    @Nullable
    public TopicListDialog.a f() {
        return this.f33155a;
    }

    @Nullable
    public TopicListVM g() {
        return this.f7758a;
    }

    public abstract void l(@Nullable TopicListDialog.a aVar);

    public abstract void m(@Nullable TopicListVM topicListVM);
}
