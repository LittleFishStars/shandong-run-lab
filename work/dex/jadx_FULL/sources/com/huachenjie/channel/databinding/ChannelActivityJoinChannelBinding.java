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
import com.huachenjie.channel.page.join_channel.JoinChannelModel;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.widget.CommonSearchView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityJoinChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33086a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public JoinChannelModel f7565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonSearchView f7567a;

    public ChannelActivityJoinChannelBinding(Object obj, View view, int i, RecyclerView recyclerView, CommonSearchView commonSearchView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f33086a = recyclerView;
        this.f7567a = commonSearchView;
        this.f7566a = stateLayout;
    }

    public static ChannelActivityJoinChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityJoinChannelBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityJoinChannelBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_join_channel);
    }

    @NonNull
    public static ChannelActivityJoinChannelBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityJoinChannelBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityJoinChannelBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityJoinChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_join_channel, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityJoinChannelBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityJoinChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_join_channel, null, false, obj);
    }

    @Nullable
    public JoinChannelModel f() {
        return this.f7565a;
    }

    public abstract void k(@Nullable JoinChannelModel joinChannelModel);
}
