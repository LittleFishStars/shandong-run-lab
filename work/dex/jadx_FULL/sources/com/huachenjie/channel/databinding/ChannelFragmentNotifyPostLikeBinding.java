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
import com.huachenjie.channel.page.notify.post.NotifyPostLikeVM;
import com.huachenjie.common.page.statelayout.StateLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentNotifyPostLikeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f7888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f7889a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NotifyPostLikeVM f7890a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7891a;

    public ChannelFragmentNotifyPostLikeBinding(Object obj, View view, int i, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f7889a = swipeRefreshLayout;
        this.f33213a = recyclerView;
        this.f7891a = stateLayout;
    }

    public static ChannelFragmentNotifyPostLikeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentNotifyPostLikeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentNotifyPostLikeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_notify_post_like);
    }

    @NonNull
    public static ChannelFragmentNotifyPostLikeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentNotifyPostLikeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentNotifyPostLikeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentNotifyPostLikeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_notify_post_like, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentNotifyPostLikeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentNotifyPostLikeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_notify_post_like, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f7888a;
    }

    @Nullable
    public NotifyPostLikeVM g() {
        return this.f7890a;
    }

    public abstract void l(@Nullable NotifyPostLikeVM notifyPostLikeVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
