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
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.history.fragment.HistoryChannelViewModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineFragmentHistoryChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f35317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f11250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HistoryChannelViewModel f11251a;

    public MineFragmentHistoryChannelBinding(Object obj, View view, int i, StateLayout stateLayout) {
        super(obj, view, i);
        this.f11250a = stateLayout;
    }

    public static MineFragmentHistoryChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineFragmentHistoryChannelBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineFragmentHistoryChannelBinding) ViewDataBinding.bind(obj, view, R.layout.mine_fragment_history_channel);
    }

    @NonNull
    public static MineFragmentHistoryChannelBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineFragmentHistoryChannelBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineFragmentHistoryChannelBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineFragmentHistoryChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_history_channel, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineFragmentHistoryChannelBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineFragmentHistoryChannelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_history_channel, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f35317a;
    }

    @Nullable
    public HistoryChannelViewModel g() {
        return this.f11251a;
    }

    public abstract void l(@Nullable HistoryChannelViewModel historyChannelViewModel);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
