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
import com.huachenjie.works.bean.RecommendGoodsBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemWorksDetailGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37089a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14754a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RecommendGoodsBean f14755a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public WorksItemWorksDetailGoodsBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivGoods, TextView tvName, TextView tvPrice, TextView tvSee) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37089a = ivGoods;
        this.f14754a = tvName;
        this.b = tvPrice;
        this.c = tvSee;
    }

    public static WorksItemWorksDetailGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemWorksDetailGoodsBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemWorksDetailGoodsBinding) ViewDataBinding.bind(component, view, R.layout.works_item_works_detail_goods);
    }

    @NonNull
    public static WorksItemWorksDetailGoodsBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemWorksDetailGoodsBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksDetailGoodsBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemWorksDetailGoodsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_detail_goods, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksDetailGoodsBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemWorksDetailGoodsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_detail_goods, null, false, component);
    }

    @Nullable
    public RecommendGoodsBean f() {
        return this.f14755a;
    }

    public abstract void k(@Nullable RecommendGoodsBean bean);
}
