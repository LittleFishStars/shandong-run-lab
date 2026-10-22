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
import com.huachenjie.mall.bean.TrySeeVideoBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemTrySeeListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public TrySeeVideoBean f35046a;

    public MallItemTrySeeListBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemTrySeeListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemTrySeeListBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemTrySeeListBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_try_see_list);
    }

    @NonNull
    public static MallItemTrySeeListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemTrySeeListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemTrySeeListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemTrySeeListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_try_see_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemTrySeeListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemTrySeeListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_try_see_list, null, false, obj);
    }

    @Nullable
    public TrySeeVideoBean f() {
        return this.f35046a;
    }

    public abstract void k(@Nullable TrySeeVideoBean trySeeVideoBean);
}
