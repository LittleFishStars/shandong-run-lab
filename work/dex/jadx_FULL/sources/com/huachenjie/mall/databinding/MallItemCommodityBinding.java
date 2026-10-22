package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.external.bean.CommodityBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemCommodityBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34982a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f10742a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public CommodityBean f10743a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public MallItemCommodityBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.f34982a = imageView;
        this.f10742a = constraintLayout;
        this.f10741a = textView;
        this.b = textView2;
        this.c = textView3;
        this.d = textView4;
    }

    public static MallItemCommodityBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemCommodityBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemCommodityBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_commodity);
    }

    @NonNull
    public static MallItemCommodityBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemCommodityBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemCommodityBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemCommodityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_commodity, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemCommodityBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemCommodityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_commodity, null, false, obj);
    }

    @Nullable
    public CommodityBean f() {
        return this.f10743a;
    }

    public abstract void k(@Nullable CommodityBean commodityBean);
}
