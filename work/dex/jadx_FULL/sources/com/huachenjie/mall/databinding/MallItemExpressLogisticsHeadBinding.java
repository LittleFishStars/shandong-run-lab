package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressLogisticsOutBean;
import com.huachenjie.mall.page.express.ExpressLogisticsActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemExpressLogisticsHeadBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ExpressLogisticsOutBean f34996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExpressLogisticsActivity.a f10787a;

    public MallItemExpressLogisticsHeadBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemExpressLogisticsHeadBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemExpressLogisticsHeadBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemExpressLogisticsHeadBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_express_logistics_head);
    }

    @NonNull
    public static MallItemExpressLogisticsHeadBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemExpressLogisticsHeadBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemExpressLogisticsHeadBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemExpressLogisticsHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_express_logistics_head, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemExpressLogisticsHeadBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemExpressLogisticsHeadBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_express_logistics_head, null, false, obj);
    }

    @Nullable
    public ExpressLogisticsOutBean f() {
        return this.f34996a;
    }

    @Nullable
    public ExpressLogisticsActivity.a g() {
        return this.f10787a;
    }

    public abstract void l(@Nullable ExpressLogisticsOutBean expressLogisticsOutBean);

    public abstract void m(@Nullable ExpressLogisticsActivity.a aVar);
}
