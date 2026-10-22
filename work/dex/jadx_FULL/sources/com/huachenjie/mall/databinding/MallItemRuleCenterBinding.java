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
import com.huachenjie.mall.bean.RuleCenterBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemRuleCenterBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public RuleCenterBean f35031a;

    public MallItemRuleCenterBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemRuleCenterBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemRuleCenterBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemRuleCenterBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_rule_center);
    }

    @NonNull
    public static MallItemRuleCenterBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemRuleCenterBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemRuleCenterBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemRuleCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_rule_center, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemRuleCenterBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemRuleCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_rule_center, null, false, obj);
    }

    @Nullable
    public RuleCenterBean f() {
        return this.f35031a;
    }

    public abstract void k(@Nullable RuleCenterBean ruleCenterBean);
}
