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
import com.huachenjie.channel.page.organize.OrganizeActivity;
import com.huachenjie.channel.page.organize.OrganizeVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityOrganizeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f33105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f7625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f7626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeActivity.a f7627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OrganizeVM f7628a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7629a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f7630a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f7631a;

    public ChannelActivityOrganizeBinding(Object obj, View view, int i, BLTextView bLTextView, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding, BLView bLView) {
        super(obj, view, i);
        this.f7630a = bLTextView;
        this.f33105a = recyclerView;
        this.f7626a = swipeRefreshLayout;
        this.f7629a = layoutToolbarBindingBinding;
        this.f7631a = bLView;
    }

    public static ChannelActivityOrganizeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityOrganizeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityOrganizeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_organize);
    }

    @NonNull
    public static ChannelActivityOrganizeBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityOrganizeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityOrganizeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_organize, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityOrganizeBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityOrganizeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_organize, null, false, obj);
    }

    @Nullable
    public OrganizeActivity.a f() {
        return this.f7627a;
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener g() {
        return this.f7625a;
    }

    @Nullable
    public OrganizeVM h() {
        return this.f7628a;
    }

    public abstract void m(@Nullable OrganizeActivity.a aVar);

    public abstract void n(@Nullable OrganizeVM organizeVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
