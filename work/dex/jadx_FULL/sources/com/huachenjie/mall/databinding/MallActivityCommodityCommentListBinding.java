package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.mall.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityCommodityCommentListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager f34783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout f10177a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10178a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BaseTitleViewModel f10179a;

    public MallActivityCommodityCommentListBinding(Object obj, View view, int i, SlidingTabLayout slidingTabLayout, LayoutToolbarBindingBinding layoutToolbarBindingBinding, ViewPager viewPager) {
        super(obj, view, i);
        this.f10177a = slidingTabLayout;
        this.f10178a = layoutToolbarBindingBinding;
        this.f34783a = viewPager;
    }

    public static MallActivityCommodityCommentListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityCommodityCommentListBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityCommodityCommentListBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_commodity_comment_list);
    }

    @NonNull
    public static MallActivityCommodityCommentListBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityCommodityCommentListBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityCommodityCommentListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityCommodityCommentListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_commodity_comment_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityCommodityCommentListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityCommodityCommentListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_commodity_comment_list, null, false, obj);
    }

    @Nullable
    public BaseTitleViewModel f() {
        return this.f10179a;
    }

    public abstract void k(@Nullable BaseTitleViewModel baseTitleViewModel);
}
