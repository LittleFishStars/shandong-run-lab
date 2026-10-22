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
import com.huachenjie.mall.external.page.share_goods.SelectGoodsVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallFragmentSelectGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SelectGoodsVM f34969a;

    public MallFragmentSelectGoodsBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallFragmentSelectGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallFragmentSelectGoodsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallFragmentSelectGoodsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_fragment_select_goods);
    }

    @NonNull
    public static MallFragmentSelectGoodsBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallFragmentSelectGoodsBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallFragmentSelectGoodsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallFragmentSelectGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_select_goods, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallFragmentSelectGoodsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallFragmentSelectGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_select_goods, null, false, obj);
    }

    @Nullable
    public SelectGoodsVM f() {
        return this.f34969a;
    }

    public abstract void k(@Nullable SelectGoodsVM selectGoodsVM);
}
