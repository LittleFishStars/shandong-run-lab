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
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.my_order.MyOrderVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityMyOrderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f34820a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SelectBoldTabLayout f10298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MyOrderVM f10299a;

    public MallActivityMyOrderBinding(Object obj, View view, int i, SelectBoldTabLayout selectBoldTabLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f10298a = selectBoldTabLayout;
        this.f10297a = layoutToolbarBindingBinding;
        this.f34820a = viewPager2;
    }

    public static MallActivityMyOrderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityMyOrderBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityMyOrderBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_my_order);
    }

    @NonNull
    public static MallActivityMyOrderBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityMyOrderBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityMyOrderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityMyOrderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_my_order, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityMyOrderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityMyOrderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_my_order, null, false, obj);
    }

    @Nullable
    public MyOrderVM f() {
        return this.f10299a;
    }

    public abstract void k(@Nullable MyOrderVM myOrderVM);
}
