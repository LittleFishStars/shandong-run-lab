package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.home_tab.MallActivity;
import com.huachenjie.mall.page.home_tab.MallHomeVM;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLLinearLayout;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityMallBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10247a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f10248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager2 f10249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f10250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AppBarLayout f10251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MallActivity.a f10252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MallHomeVM f10253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f10254a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Banner f10256a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final Banner f10257b;

    public MallActivityMallBinding(Object obj, View view, int i, AppBarLayout appBarLayout, Banner banner, LinearLayout linearLayout, ImageView imageView, BLLinearLayout bLLinearLayout, BLConstraintLayout bLConstraintLayout, ImageView imageView2, SlidingTabLayout2 slidingTabLayout2, View view2, ViewPager2 viewPager2, Banner banner2) {
        super(obj, view, i);
        this.f10251a = appBarLayout;
        this.f10256a = banner;
        this.f10248a = linearLayout;
        this.f10247a = imageView;
        this.f10255a = bLLinearLayout;
        this.f10254a = bLConstraintLayout;
        this.b = imageView2;
        this.f10250a = slidingTabLayout2;
        this.f34804a = view2;
        this.f10249a = viewPager2;
        this.f10257b = banner2;
    }

    public static MallActivityMallBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityMallBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityMallBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_mall);
    }

    @NonNull
    public static MallActivityMallBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityMallBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityMallBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityMallBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_mall, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityMallBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityMallBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_mall, null, false, obj);
    }

    @Nullable
    public MallActivity.a f() {
        return this.f10252a;
    }

    @Nullable
    public MallHomeVM g() {
        return this.f10253a;
    }

    public abstract void l(@Nullable MallActivity.a aVar);

    public abstract void m(@Nullable MallHomeVM mallHomeVM);
}
