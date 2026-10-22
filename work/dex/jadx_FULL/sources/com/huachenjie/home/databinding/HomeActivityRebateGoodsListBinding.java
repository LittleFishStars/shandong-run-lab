package com.huachenjie.home.databinding;

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
import com.huachenjie.home.R;
import com.huachenjie.home.page.rebate_goods_list.RebateGoodsListActivity;
import com.huachenjie.home.page.rebate_goods_list.RebateGoodsListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeActivityRebateGoodsListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f34210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f9299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RebateGoodsListActivity.a f9300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RebateGoodsListVM f9301a;

    public HomeActivityRebateGoodsListBinding(Object obj, View view, int i, SlidingTabLayout2 slidingTabLayout2, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f9299a = slidingTabLayout2;
        this.f34210a = viewPager2;
    }

    public static HomeActivityRebateGoodsListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeActivityRebateGoodsListBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeActivityRebateGoodsListBinding) ViewDataBinding.bind(obj, view, R.layout.home_activity_rebate_goods_list);
    }

    @NonNull
    public static HomeActivityRebateGoodsListBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeActivityRebateGoodsListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeActivityRebateGoodsListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeActivityRebateGoodsListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_rebate_goods_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeActivityRebateGoodsListBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeActivityRebateGoodsListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_activity_rebate_goods_list, null, false, obj);
    }

    @Nullable
    public RebateGoodsListActivity.a f() {
        return this.f9300a;
    }

    @Nullable
    public RebateGoodsListVM g() {
        return this.f9301a;
    }

    public abstract void l(@Nullable RebateGoodsListActivity.a aVar);

    public abstract void m(@Nullable RebateGoodsListVM rebateGoodsListVM);
}
