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
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.FansAndAttentionsModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineActivityFansOrAttentionsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f35290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f11183a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f11184a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f11185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FansAndAttentionsModel f11186a;

    public MineActivityFansOrAttentionsBinding(Object obj, View view, int i, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f11184a = swipeRefreshLayout;
        this.f35290a = recyclerView;
        this.f11185a = layoutToolbarBindingBinding;
    }

    public static MineActivityFansOrAttentionsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineActivityFansOrAttentionsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineActivityFansOrAttentionsBinding) ViewDataBinding.bind(obj, view, R.layout.mine_activity_fans_or_attentions);
    }

    @NonNull
    public static MineActivityFansOrAttentionsBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineActivityFansOrAttentionsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineActivityFansOrAttentionsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineActivityFansOrAttentionsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_activity_fans_or_attentions, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineActivityFansOrAttentionsBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineActivityFansOrAttentionsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_activity_fans_or_attentions, null, false, obj);
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener f() {
        return this.f11183a;
    }

    @Nullable
    public FansAndAttentionsModel g() {
        return this.f11186a;
    }

    public abstract void l(@Nullable FansAndAttentionsModel fansAndAttentionsModel);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
