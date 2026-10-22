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
import com.huachenjie.channel.page.notify.post.NotifyPostCommentVM;
import com.huachenjie.common.page.statelayout.StateLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentNotifyPostCommentBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f7881a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f7882a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public NotifyPostCommentVM f7883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7884a;

    public ChannelFragmentNotifyPostCommentBinding(Object obj, View view, int i, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f7882a = swipeRefreshLayout;
        this.f33210a = recyclerView;
        this.f7884a = stateLayout;
    }

    public static ChannelFragmentNotifyPostCommentBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentNotifyPostCommentBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentNotifyPostCommentBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_notify_post_comment);
    }

    @NonNull
    public static ChannelFragmentNotifyPostCommentBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentNotifyPostCommentBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentNotifyPostCommentBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentNotifyPostCommentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_notify_post_comment, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentNotifyPostCommentBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentNotifyPostCommentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_notify_post_comment, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f7881a;
    }

    @Nullable
    public NotifyPostCommentVM g() {
        return this.f7883a;
    }

    public abstract void l(@Nullable NotifyPostCommentVM notifyPostCommentVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
