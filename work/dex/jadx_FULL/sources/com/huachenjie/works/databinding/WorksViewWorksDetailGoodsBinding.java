package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.GoodsRecommendData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksViewWorksDetailGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14819a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodsRecommendData f14820a;

    public WorksViewWorksDetailGoodsBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivArrow, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37122a = ivArrow;
        this.f14819a = tvName;
    }

    public static WorksViewWorksDetailGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksViewWorksDetailGoodsBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksViewWorksDetailGoodsBinding) ViewDataBinding.bind(component, view, R.layout.works_view_works_detail_goods);
    }

    @NonNull
    public static WorksViewWorksDetailGoodsBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksViewWorksDetailGoodsBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksViewWorksDetailGoodsBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksViewWorksDetailGoodsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_view_works_detail_goods, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksViewWorksDetailGoodsBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksViewWorksDetailGoodsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_view_works_detail_goods, null, false, component);
    }

    @Nullable
    public GoodsRecommendData f() {
        return this.f14820a;
    }

    public abstract void k(@Nullable GoodsRecommendData bean);
}
