package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.CommonSearchView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.express_company.ExpressCompanyVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityExpressCompanyBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LayoutToolbarBindingBinding f34793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonSearchView f10211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExpressCompanyVM f10212a;

    public MallActivityExpressCompanyBinding(Object obj, View view, int i, CommonSearchView commonSearchView, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f10211a = commonSearchView;
        this.f34793a = layoutToolbarBindingBinding;
    }

    public static MallActivityExpressCompanyBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityExpressCompanyBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityExpressCompanyBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_express_company);
    }

    @NonNull
    public static MallActivityExpressCompanyBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityExpressCompanyBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityExpressCompanyBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityExpressCompanyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_express_company, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityExpressCompanyBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityExpressCompanyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_express_company, null, false, obj);
    }

    @Nullable
    public ExpressCompanyVM f() {
        return this.f10212a;
    }

    public abstract void k(@Nullable ExpressCompanyVM expressCompanyVM);
}
