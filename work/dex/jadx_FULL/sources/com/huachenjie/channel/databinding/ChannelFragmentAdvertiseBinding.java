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
import com.huachenjie.channel.page.advertise.AdvertiseVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelFragmentAdvertiseBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f7765a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f7766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AdvertiseVM f7767a;

    public ChannelFragmentAdvertiseBinding(Object obj, View view, int i, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        super(obj, view, i);
        this.f33158a = recyclerView;
        this.f7766a = swipeRefreshLayout;
    }

    public static ChannelFragmentAdvertiseBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelFragmentAdvertiseBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelFragmentAdvertiseBinding) ViewDataBinding.bind(obj, view, R.layout.channel_fragment_advertise);
    }

    @NonNull
    public static ChannelFragmentAdvertiseBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelFragmentAdvertiseBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentAdvertiseBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelFragmentAdvertiseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_advertise, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelFragmentAdvertiseBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelFragmentAdvertiseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_fragment_advertise, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f7765a;
    }

    @Nullable
    public AdvertiseVM g() {
        return this.f7767a;
    }

    public abstract void l(@Nullable AdvertiseVM advertiseVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
