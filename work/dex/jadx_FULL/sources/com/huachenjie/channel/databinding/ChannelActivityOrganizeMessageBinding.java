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
import com.huachenjie.channel.page.my_channel.organize_message.OrganizeMessageVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityOrganizeMessageBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f7661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f7662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeMessageVM f7663a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7665a;

    public ChannelActivityOrganizeMessageBinding(Object obj, View view, int i, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, StateLayout stateLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f33118a = recyclerView;
        this.f7662a = swipeRefreshLayout;
        this.f7665a = stateLayout;
        this.f7664a = layoutToolbarBindingBinding;
    }

    public static ChannelActivityOrganizeMessageBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityOrganizeMessageBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityOrganizeMessageBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_organize_message);
    }

    @NonNull
    public static ChannelActivityOrganizeMessageBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityOrganizeMessageBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityOrganizeMessageBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityOrganizeMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_organize_message, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityOrganizeMessageBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityOrganizeMessageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_organize_message, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f7661a;
    }

    @Nullable
    public OrganizeMessageVM g() {
        return this.f7663a;
    }

    public abstract void l(@Nullable OrganizeMessageVM organizeMessageVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
