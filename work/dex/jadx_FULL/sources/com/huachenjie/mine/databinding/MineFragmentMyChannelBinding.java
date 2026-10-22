package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.home.channel.MyChannelVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineFragmentMyChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f35329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyChannelVM f11284a;

    public MineFragmentMyChannelBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MineFragmentMyChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineFragmentMyChannelBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineFragmentMyChannelBinding) ViewDataBinding.bind(obj, view, R.layout.mine_fragment_my_channel);
    }

    @NonNull
    public static MineFragmentMyChannelBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineFragmentMyChannelBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineFragmentMyChannelBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineFragmentMyChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_my_channel, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineFragmentMyChannelBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineFragmentMyChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_my_channel, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f35329a;
    }

    @Nullable
    public MyChannelVM g() {
        return this.f11284a;
    }

    public abstract void l(@Nullable MyChannelVM myChannelVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
