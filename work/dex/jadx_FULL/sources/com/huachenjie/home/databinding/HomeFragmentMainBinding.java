package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.ViewStubProxy;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.huachenjie.home.HomeFragment;
import com.huachenjie.home.HomeVM;
import com.huachenjie.home.R;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeFragmentMainBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f34251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final FrameLayout f9410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f9411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f9413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CoordinatorLayout f9414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewStubProxy f9415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SwipeRefreshLayout.OnRefreshListener f9417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SwipeRefreshLayout f9418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AppBarLayout f9419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HomeFragment.ClickProxy f9420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public HomeVM f9421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f9422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f9423a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final Banner f9424a;

    @NonNull
    public final View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final ImageView f9425b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f9426b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f9427b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9428b;

    @NonNull
    public final View c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final ImageView f9429c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final RecyclerView f9430c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    public HomeFragmentMainBinding(Object obj, View view, int i, AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, SwipeRefreshLayout swipeRefreshLayout, LinearLayout linearLayout2, TextView textView2, BLTextView bLTextView, View view2, BLView bLView, View view3, View view4, Banner banner, ViewStubProxy viewStubProxy) {
        super(obj, view, i);
        this.f9419a = appBarLayout;
        this.f9414a = coordinatorLayout;
        this.f9410a = frameLayout;
        this.f9413a = textView;
        this.f9411a = imageView;
        this.f9425b = imageView2;
        this.f9429c = imageView3;
        this.d = imageView4;
        this.e = imageView5;
        this.f9412a = linearLayout;
        this.f9416a = recyclerView;
        this.f9428b = recyclerView2;
        this.f9430c = recyclerView3;
        this.f9418a = swipeRefreshLayout;
        this.f9426b = linearLayout2;
        this.f9427b = textView2;
        this.f9422a = bLTextView;
        this.f34251a = view2;
        this.f9423a = bLView;
        this.b = view3;
        this.c = view4;
        this.f9424a = banner;
        this.f9415a = viewStubProxy;
    }

    public static HomeFragmentMainBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeFragmentMainBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeFragmentMainBinding) ViewDataBinding.bind(obj, view, R.layout.home_fragment_main);
    }

    @NonNull
    public static HomeFragmentMainBinding i(@NonNull LayoutInflater layoutInflater) {
        return l(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeFragmentMainBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return k(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeFragmentMainBinding k(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeFragmentMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_fragment_main, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeFragmentMainBinding l(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeFragmentMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_fragment_main, null, false, obj);
    }

    @Nullable
    public HomeFragment.ClickProxy f() {
        return this.f9420a;
    }

    @Nullable
    public SwipeRefreshLayout.OnRefreshListener g() {
        return this.f9417a;
    }

    @Nullable
    public HomeVM h() {
        return this.f9421a;
    }

    public abstract void m(@Nullable HomeFragment.ClickProxy clickProxy);

    public abstract void n(@Nullable HomeVM homeVM);

    public abstract void setRefresh(@Nullable SwipeRefreshLayout.OnRefreshListener onRefreshListener);
}
