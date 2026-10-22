package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.express.ExpressLogisticsVm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityExpressLogisticsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f34795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10218a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ExpressLogisticsVm f10219a;

    public MallActivityExpressLogisticsBinding(Object obj, View view, int i, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding) {
        super(obj, view, i);
        this.f34795a = recyclerView;
        this.f10218a = layoutToolbarBindingBinding;
    }

    public static MallActivityExpressLogisticsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityExpressLogisticsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityExpressLogisticsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_express_logistics);
    }

    @NonNull
    public static MallActivityExpressLogisticsBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityExpressLogisticsBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityExpressLogisticsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityExpressLogisticsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_express_logistics, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityExpressLogisticsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityExpressLogisticsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_express_logistics, null, false, obj);
    }

    @Nullable
    public ExpressLogisticsVm f() {
        return this.f10219a;
    }

    public abstract void k(@Nullable ExpressLogisticsVm expressLogisticsVm);
}
