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
import com.huachenjie.channel.page.all_channel.JoinAllChannelFVM;
import com.huachenjie.common.page.statelayout.StateLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentJoinAllChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f7788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public JoinAllChannelFVM f7789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7790a;

    public ChannelFragmentJoinAllChannelBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f33170a = recyclerView;
        this.f7790a = stateLayout;
    }

    public static ChannelFragmentJoinAllChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentJoinAllChannelBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentJoinAllChannelBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_join_all_channel);
    }

    @NonNull
    public static ChannelFragmentJoinAllChannelBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentJoinAllChannelBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentJoinAllChannelBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentJoinAllChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_join_all_channel, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentJoinAllChannelBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentJoinAllChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_join_all_channel, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f7788a;
    }

    @Nullable
    public JoinAllChannelFVM g() {
        return this.f7789a;
    }

    public abstract void l(@Nullable JoinAllChannelFVM joinAllChannelFVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
