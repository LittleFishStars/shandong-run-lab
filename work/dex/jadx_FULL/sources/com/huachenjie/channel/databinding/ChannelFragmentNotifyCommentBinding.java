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
import com.huachenjie.channel.page.notify.broad_build.NotifyBroadCommentVM;
import com.huachenjie.common.page.statelayout.StateLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentNotifyCommentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f7856a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f7857a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NotifyBroadCommentVM f7858a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7859a;

    public ChannelFragmentNotifyCommentBinding(Object obj, View view, int i, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f7857a = swipeRefreshLayout;
        this.f33200a = recyclerView;
        this.f7859a = stateLayout;
    }

    public static ChannelFragmentNotifyCommentBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentNotifyCommentBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentNotifyCommentBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_notify_comment);
    }

    @NonNull
    public static ChannelFragmentNotifyCommentBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentNotifyCommentBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentNotifyCommentBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentNotifyCommentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_notify_comment, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentNotifyCommentBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentNotifyCommentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_notify_comment, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f7856a;
    }

    @Nullable
    public NotifyBroadCommentVM g() {
        return this.f7858a;
    }

    public abstract void l(@Nullable NotifyBroadCommentVM notifyBroadCommentVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
