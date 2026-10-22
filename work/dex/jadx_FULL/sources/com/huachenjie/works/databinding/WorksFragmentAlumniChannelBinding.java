package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.channel.AlumniChannelVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentAlumniChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36894a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f14157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f14159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f14160a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AlumniChannelVM f14161a;

    @NonNull
    public final View b;

    public WorksFragmentAlumniChannelBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivHeaderImage, RecyclerView recyclerView, SwipeRefreshLayout refreshLayout, View vMask, View vStatusSpace) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14157a = ivHeaderImage;
        this.f14158a = recyclerView;
        this.f14160a = refreshLayout;
        this.f36894a = vMask;
        this.b = vStatusSpace;
    }

    public static WorksFragmentAlumniChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentAlumniChannelBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentAlumniChannelBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_alumni_channel);
    }

    @NonNull
    public static WorksFragmentAlumniChannelBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentAlumniChannelBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentAlumniChannelBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentAlumniChannelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_alumni_channel, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentAlumniChannelBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentAlumniChannelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_alumni_channel, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f14159a;
    }

    @Nullable
    public AlumniChannelVM g() {
        return this.f14161a;
    }

    public abstract void l(@Nullable AlumniChannelVM vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
