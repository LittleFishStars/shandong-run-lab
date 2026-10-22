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
import com.huachenjie.mall.bean.ExpressCompanyBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemExpressCompanyNameBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ExpressCompanyBean f34992a;

    public MallItemExpressCompanyNameBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemExpressCompanyNameBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemExpressCompanyNameBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemExpressCompanyNameBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_express_company_name);
    }

    @NonNull
    public static MallItemExpressCompanyNameBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemExpressCompanyNameBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemExpressCompanyNameBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemExpressCompanyNameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_express_company_name, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemExpressCompanyNameBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemExpressCompanyNameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_express_company_name, null, false, obj);
    }

    @Nullable
    public ExpressCompanyBean f() {
        return this.f34992a;
    }

    public abstract void k(@Nullable ExpressCompanyBean expressCompanyBean);
}
