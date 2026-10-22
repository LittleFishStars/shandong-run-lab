package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.mall.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivitySelectGoodsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f34857a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f10393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10394a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleViewModel f10395a;

    public MallActivitySelectGoodsBinding(Object obj, View view, int i, SlidingTabLayout2 slidingTabLayout2, LayoutToolbarBindingBinding layoutToolbarBindingBinding, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f10393a = slidingTabLayout2;
        this.f10394a = layoutToolbarBindingBinding;
        this.f34857a = viewPager2;
    }

    public static MallActivitySelectGoodsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivitySelectGoodsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivitySelectGoodsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_select_goods);
    }

    @NonNull
    public static MallActivitySelectGoodsBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivitySelectGoodsBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivitySelectGoodsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivitySelectGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_select_goods, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivitySelectGoodsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivitySelectGoodsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_select_goods, null, false, obj);
    }

    @Nullable
    public BaseTitleViewModel f() {
        return this.f10395a;
    }

    public abstract void k(@Nullable BaseTitleViewModel baseTitleViewModel);
}
