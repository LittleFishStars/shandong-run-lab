package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.details.goods.WorksDetailsGoodsFragment;
import com.huachenjie.works.page.details.goods.WorksDetailsGoodsVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentWorksDetailGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f36971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f14363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f14364a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorksDetailsGoodsFragment f14365a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorksDetailsGoodsVM f14366a;

    public WorksFragmentWorksDetailGoodsBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView rvList, StateLayout stateLayout, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14363a = rvList;
        this.f14364a = stateLayout;
        this.f36971a = tvTitle;
    }

    public static WorksFragmentWorksDetailGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentWorksDetailGoodsBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentWorksDetailGoodsBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_works_detail_goods);
    }

    @NonNull
    public static WorksFragmentWorksDetailGoodsBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentWorksDetailGoodsBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentWorksDetailGoodsBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentWorksDetailGoodsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_works_detail_goods, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentWorksDetailGoodsBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentWorksDetailGoodsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_works_detail_goods, null, false, component);
    }

    @Nullable
    public WorksDetailsGoodsFragment f() {
        return this.f14365a;
    }

    @Nullable
    public WorksDetailsGoodsVM g() {
        return this.f14366a;
    }

    public abstract void l(@Nullable WorksDetailsGoodsFragment fragment);

    public abstract void m(@Nullable WorksDetailsGoodsVM vm);
}
