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
public abstract class MallItemExpressCompanyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ExpressCompanyBean f34990a;

    public MallItemExpressCompanyBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemExpressCompanyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemExpressCompanyBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemExpressCompanyBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_express_company);
    }

    @NonNull
    public static MallItemExpressCompanyBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemExpressCompanyBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemExpressCompanyBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemExpressCompanyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_express_company, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemExpressCompanyBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemExpressCompanyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_express_company, null, false, obj);
    }

    @Nullable
    public ExpressCompanyBean f() {
        return this.f34990a;
    }

    public abstract void k(@Nullable ExpressCompanyBean expressCompanyBean);
}
