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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.notify.broad_build.NotifyBroadLikeVM;
import com.huachenjie.common.page.statelayout.StateLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentNotifyLikeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f7874a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f7875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NotifyBroadLikeVM f7876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7877a;

    public ChannelFragmentNotifyLikeBinding(Object obj, View view, int i, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f7875a = swipeRefreshLayout;
        this.f33207a = recyclerView;
        this.f7877a = stateLayout;
    }

    public static ChannelFragmentNotifyLikeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentNotifyLikeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentNotifyLikeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_notify_like);
    }

    @NonNull
    public static ChannelFragmentNotifyLikeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentNotifyLikeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentNotifyLikeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentNotifyLikeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_notify_like, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentNotifyLikeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentNotifyLikeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_notify_like, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f7874a;
    }

    @Nullable
    public NotifyBroadLikeVM g() {
        return this.f7876a;
    }

    public abstract void l(@Nullable NotifyBroadLikeVM notifyBroadLikeVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
