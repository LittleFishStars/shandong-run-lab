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
import com.huachenjie.channel.page.my_channel.my_organize.MyOrganizeActivity;
import com.huachenjie.channel.page.my_channel.my_organize.MyOrganizeVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityMyOrganizeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f7586a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f7587a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyOrganizeActivity.a f7588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyOrganizeVM f7589a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f7591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7592a;

    public ChannelActivityMyOrganizeBinding(Object obj, View view, int i, BLTextView bLTextView, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, StateLayout stateLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f7592a = bLTextView;
        this.f33092a = recyclerView;
        this.f7587a = swipeRefreshLayout;
        this.f7591a = stateLayout;
        this.f7590a = layoutToolbarBindingBinding;
    }

    public static ChannelActivityMyOrganizeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityMyOrganizeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityMyOrganizeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_my_organize);
    }

    @NonNull
    public static ChannelActivityMyOrganizeBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityMyOrganizeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityMyOrganizeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityMyOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_my_organize, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityMyOrganizeBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityMyOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_my_organize, null, false, obj);
    }

    @Nullable
    public MyOrganizeActivity.a f() {
        return this.f7588a;
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener g() {
        return this.f7586a;
    }

    @Nullable
    public MyOrganizeVM h() {
        return this.f7589a;
    }

    public abstract void m(@Nullable MyOrganizeActivity.a aVar);

    public abstract void n(@Nullable MyOrganizeVM myOrganizeVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
