package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.merchants.MerchantsActivity;
import com.huachenjie.mall.page.merchants.MerchantsVM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityMerchantsBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f10278a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f10279a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Toolbar f10280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager f10281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout f10282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AppBarLayout f10283a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AvatarView f10284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MerchantsActivity.a f10285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MerchantsVM f10286a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f10287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10288a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    public MallActivityMerchantsBinding(Object obj, View view, int i, AppBarLayout appBarLayout, AvatarView avatarView, BLLinearLayout bLLinearLayout, ImageView imageView, SlidingTabLayout slidingTabLayout, Toolbar toolbar, BLTextView bLTextView, TextView textView, TextView textView2, TextView textView3, View view2, ViewPager viewPager) {
        super(obj, view, i);
        this.f10283a = appBarLayout;
        this.f10284a = avatarView;
        this.f10287a = bLLinearLayout;
        this.f10278a = imageView;
        this.f10282a = slidingTabLayout;
        this.f10280a = toolbar;
        this.f10288a = bLTextView;
        this.f10279a = textView;
        this.b = textView2;
        this.c = textView3;
        this.f34816a = view2;
        this.f10281a = viewPager;
    }

    public static MallActivityMerchantsBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityMerchantsBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityMerchantsBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_merchants);
    }

    @NonNull
    public static MallActivityMerchantsBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityMerchantsBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityMerchantsBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityMerchantsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_merchants, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityMerchantsBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityMerchantsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_merchants, null, false, obj);
    }

    @Nullable
    public MerchantsActivity.a f() {
        return this.f10285a;
    }

    @Nullable
    public MerchantsVM g() {
        return this.f10286a;
    }

    public abstract void l(@Nullable MerchantsActivity.a aVar);

    public abstract void m(@Nullable MerchantsVM merchantsVM);
}
