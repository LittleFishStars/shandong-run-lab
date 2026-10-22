package com.huachenjie.mine.databinding;

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
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.home.showcase.ShowcaseVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineFragmentShowcaseBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f35338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f11305a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f11306a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ShowcaseVM f11307a;

    public MineFragmentShowcaseBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout) {
        super(obj, view, i);
        this.f35338a = recyclerView;
        this.f11306a = stateLayout;
    }

    public static MineFragmentShowcaseBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineFragmentShowcaseBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineFragmentShowcaseBinding) ViewDataBinding.bind(obj, view, R.layout.mine_fragment_showcase);
    }

    @NonNull
    public static MineFragmentShowcaseBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineFragmentShowcaseBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineFragmentShowcaseBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineFragmentShowcaseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_showcase, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineFragmentShowcaseBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineFragmentShowcaseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_showcase, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f11305a;
    }

    @Nullable
    public ShowcaseVM g() {
        return this.f11307a;
    }

    public abstract void l(@Nullable ShowcaseVM showcaseVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
