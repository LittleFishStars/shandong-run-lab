package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.mall.R;
import com.huachenjie.mall.dialog.shop_order.ChooseShopOrderFragment;
import com.huachenjie.mall.dialog.shop_order.ChooseShopOrderVm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallFragmentChooseShopOrderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f34943a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f10650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f10651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseShopOrderFragment f10652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChooseShopOrderVm f10653a;

    public MallFragmentChooseShopOrderBinding(Object obj, View view, int i, RecyclerView recyclerView, StateLayout stateLayout, TextView textView) {
        super(obj, view, i);
        this.f10650a = recyclerView;
        this.f10651a = stateLayout;
        this.f34943a = textView;
    }

    public static MallFragmentChooseShopOrderBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallFragmentChooseShopOrderBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallFragmentChooseShopOrderBinding) ViewDataBinding.bind(obj, view, R.layout.mall_fragment_choose_shop_order);
    }

    @NonNull
    public static MallFragmentChooseShopOrderBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallFragmentChooseShopOrderBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallFragmentChooseShopOrderBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallFragmentChooseShopOrderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_choose_shop_order, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallFragmentChooseShopOrderBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallFragmentChooseShopOrderBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_fragment_choose_shop_order, null, false, obj);
    }

    @Nullable
    public ChooseShopOrderFragment f() {
        return this.f10652a;
    }

    @Nullable
    public ChooseShopOrderVm g() {
        return this.f10653a;
    }

    public abstract void l(@Nullable ChooseShopOrderFragment chooseShopOrderFragment);

    public abstract void m(@Nullable ChooseShopOrderVm chooseShopOrderVm);
}
