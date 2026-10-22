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
import com.huachenjie.channel.bean.my_channel.MyChannelTopicGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelItemManageTopicGroupBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f33274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyChannelTopicGroup f8046a;

    @NonNull
    public final TextView b;

    public ChannelItemManageTopicGroupBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.f33274a = textView;
        this.b = textView2;
    }

    public static ChannelItemManageTopicGroupBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelItemManageTopicGroupBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelItemManageTopicGroupBinding) ViewDataBinding.bind(obj, view, R.layout.channel_item_manage_topic_group);
    }

    @NonNull
    public static ChannelItemManageTopicGroupBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelItemManageTopicGroupBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageTopicGroupBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelItemManageTopicGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_topic_group, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelItemManageTopicGroupBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelItemManageTopicGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_item_manage_topic_group, null, false, obj);
    }

    @Nullable
    public MyChannelTopicGroup f() {
        return this.f8046a;
    }

    public abstract void k(@Nullable MyChannelTopicGroup myChannelTopicGroup);
}
