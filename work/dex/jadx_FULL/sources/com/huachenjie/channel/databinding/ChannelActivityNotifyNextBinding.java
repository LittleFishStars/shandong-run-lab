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
import com.huachenjie.channel.page.notify.base.BaseNotifyNextModel;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityNotifyNextBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f7610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f7611a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseNotifyNextModel f7612a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7613a;

    public ChannelActivityNotifyNextBinding(Object obj, View view, int i, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f7611a = swipeRefreshLayout;
        this.f33100a = recyclerView;
        this.f7613a = layoutToolbarBindingBinding;
    }

    public static ChannelActivityNotifyNextBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityNotifyNextBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityNotifyNextBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_notify_next);
    }

    @NonNull
    public static ChannelActivityNotifyNextBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityNotifyNextBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityNotifyNextBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityNotifyNextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_notify_next, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityNotifyNextBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityNotifyNextBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_notify_next, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f7610a;
    }

    @Nullable
    public BaseNotifyNextModel g() {
        return this.f7612a;
    }

    public abstract void l(@Nullable BaseNotifyNextModel baseNotifyNextModel);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
