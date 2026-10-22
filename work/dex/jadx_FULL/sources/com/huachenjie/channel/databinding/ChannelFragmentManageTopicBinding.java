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
import com.huachenjie.channel.page.manage_channel.topic.ManageTopicVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentManageTopicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ManageTopicVM f33188a;

    public ChannelFragmentManageTopicBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ChannelFragmentManageTopicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentManageTopicBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentManageTopicBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_manage_topic);
    }

    @NonNull
    public static ChannelFragmentManageTopicBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentManageTopicBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentManageTopicBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentManageTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_manage_topic, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentManageTopicBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentManageTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_manage_topic, null, false, obj);
    }

    @Nullable
    public ManageTopicVM f() {
        return this.f33188a;
    }

    public abstract void k(@Nullable ManageTopicVM manageTopicVM);
}
