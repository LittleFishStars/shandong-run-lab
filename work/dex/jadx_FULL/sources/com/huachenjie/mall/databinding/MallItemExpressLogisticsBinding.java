package com.huachenjie.mall.databinding;

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
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.ExpressLogisticsBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemExpressLogisticsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f34994a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExpressLogisticsBean f10782a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public MallItemExpressLogisticsBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.f34994a = imageView;
        this.f10781a = textView;
        this.b = textView2;
        this.c = textView3;
    }

    public static MallItemExpressLogisticsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemExpressLogisticsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemExpressLogisticsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_express_logistics);
    }

    @NonNull
    public static MallItemExpressLogisticsBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemExpressLogisticsBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemExpressLogisticsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemExpressLogisticsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_express_logistics, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemExpressLogisticsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemExpressLogisticsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_express_logistics, null, false, obj);
    }

    @Nullable
    public ExpressLogisticsBean f() {
        return this.f10782a;
    }

    public abstract void k(@Nullable ExpressLogisticsBean expressLogisticsBean);
}
