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
import com.huachenjie.mine.page.history.fragment.HistoryTopicViewModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineFragmentHistoryTopicBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f35320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f11258a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HistoryTopicViewModel f11259a;

    public MineFragmentHistoryTopicBinding(Object obj, View view, int i, StateLayout stateLayout) {
        super(obj, view, i);
        this.f11258a = stateLayout;
    }

    public static MineFragmentHistoryTopicBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineFragmentHistoryTopicBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineFragmentHistoryTopicBinding) ViewDataBinding.bind(obj, view, R.layout.mine_fragment_history_topic);
    }

    @NonNull
    public static MineFragmentHistoryTopicBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineFragmentHistoryTopicBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineFragmentHistoryTopicBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineFragmentHistoryTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_history_topic, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineFragmentHistoryTopicBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineFragmentHistoryTopicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_history_topic, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f35320a;
    }

    @Nullable
    public HistoryTopicViewModel g() {
        return this.f11259a;
    }

    public abstract void l(@Nullable HistoryTopicViewModel historyTopicViewModel);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
