package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.channel.list.AllChannelListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentListChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f36916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AllChannelListVM f14217a;

    public WorksFragmentListChannelBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksFragmentListChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentListChannelBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentListChannelBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_list_channel);
    }

    @NonNull
    public static WorksFragmentListChannelBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentListChannelBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentListChannelBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentListChannelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_list_channel, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentListChannelBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentListChannelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_list_channel, null, false, component);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f36916a;
    }

    @Nullable
    public AllChannelListVM g() {
        return this.f14217a;
    }

    public abstract void l(@Nullable AllChannelListVM vm);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener refresh);
}
