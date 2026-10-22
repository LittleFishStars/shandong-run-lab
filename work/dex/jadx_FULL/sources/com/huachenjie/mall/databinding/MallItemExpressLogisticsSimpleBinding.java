package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressLogisticsBean;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemExpressLogisticsSimpleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34999a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExpressLogisticsBean f10796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f10797a;

    @NonNull
    public final TextView b;

    public MallItemExpressLogisticsSimpleBinding(Object obj, View view, int i, TextView textView, TextView textView2, BLView bLView) {
        super(obj, view, i);
        this.f34999a = textView;
        this.b = textView2;
        this.f10797a = bLView;
    }

    public static MallItemExpressLogisticsSimpleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemExpressLogisticsSimpleBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemExpressLogisticsSimpleBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_express_logistics_simple);
    }

    @NonNull
    public static MallItemExpressLogisticsSimpleBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemExpressLogisticsSimpleBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemExpressLogisticsSimpleBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemExpressLogisticsSimpleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_express_logistics_simple, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemExpressLogisticsSimpleBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemExpressLogisticsSimpleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_express_logistics_simple, null, false, obj);
    }

    @Nullable
    public ExpressLogisticsBean f() {
        return this.f10796a;
    }

    public abstract void k(@Nullable ExpressLogisticsBean expressLogisticsBean);
}
