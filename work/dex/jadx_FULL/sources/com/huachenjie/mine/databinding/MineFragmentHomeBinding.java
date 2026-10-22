package com.huachenjie.mine.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.mine.R;
import com.huachenjie.mine.page.home.MineFragment;
import com.huachenjie.mine.page.home.MineVM;
import com.huachenjie.works.external.widget.UserLaoButton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MineFragmentHomeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Toolbar f11267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ConstraintLayout f11268a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager f11269a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout f11270a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AppBarLayout f11271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final MineLayoutMineHeaderBinding f11272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MineFragment.a f11273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public MineVM f11274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final UserLaoButton f11275a;

    @NonNull
    public final ImageView b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    public MineFragmentHomeBinding(Object obj, View view, int i, AppBarLayout appBarLayout, LinearLayout linearLayout, UserLaoButton userLaoButton, ConstraintLayout constraintLayout, MineLayoutMineHeaderBinding mineLayoutMineHeaderBinding, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, SlidingTabLayout slidingTabLayout, Toolbar toolbar, ViewPager viewPager) {
        super(obj, view, i);
        this.f11271a = appBarLayout;
        this.f11266a = linearLayout;
        this.f11275a = userLaoButton;
        this.f11268a = constraintLayout;
        this.f11272a = mineLayoutMineHeaderBinding;
        this.f35323a = imageView;
        this.b = imageView2;
        this.c = imageView3;
        this.d = imageView4;
        this.f11270a = slidingTabLayout;
        this.f11267a = toolbar;
        this.f11269a = viewPager;
    }

    public static MineFragmentHomeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MineFragmentHomeBinding d(@NonNull View view, @Nullable Object obj) {
        return (MineFragmentHomeBinding) ViewDataBinding.bind(obj, view, R.layout.mine_fragment_home);
    }

    @NonNull
    public static MineFragmentHomeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MineFragmentHomeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MineFragmentHomeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MineFragmentHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_home, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MineFragmentHomeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MineFragmentHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mine_fragment_home, null, false, obj);
    }

    @Nullable
    public MineFragment.a f() {
        return this.f11273a;
    }

    @Nullable
    public MineVM g() {
        return this.f11274a;
    }

    public abstract void l(@Nullable MineFragment.a aVar);

    public abstract void m(@Nullable MineVM mineVM);
}
