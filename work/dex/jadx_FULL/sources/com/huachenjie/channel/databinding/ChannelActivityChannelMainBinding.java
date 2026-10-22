package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.channel_main.ChannelMainActivity;
import com.huachenjie.channel.page.channel_main.ChannelMainVM;
import com.noober.background.view.BLImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityChannelMainBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f33049a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager2 f7454a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f7455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AppBarLayout f7456a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CollapsingToolbarLayout f7457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ChannelLayoutChannelMainHeaderBinding f7458a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelMainActivity.a f7459a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelMainVM f7460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLImageView f7461a;

    @NonNull
    public final BLImageView b;

    public ChannelActivityChannelMainBinding(Object obj, View view, int i, AppBarLayout appBarLayout, ConstraintLayout constraintLayout, CollapsingToolbarLayout collapsingToolbarLayout, BLImageView bLImageView, BLImageView bLImageView2, ChannelLayoutChannelMainHeaderBinding channelLayoutChannelMainHeaderBinding, SlidingTabLayout2 slidingTabLayout2, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f7456a = appBarLayout;
        this.f33049a = constraintLayout;
        this.f7457a = collapsingToolbarLayout;
        this.f7461a = bLImageView;
        this.b = bLImageView2;
        this.f7458a = channelLayoutChannelMainHeaderBinding;
        this.f7455a = slidingTabLayout2;
        this.f7454a = viewPager2;
    }

    public static ChannelActivityChannelMainBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityChannelMainBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityChannelMainBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_channel_main);
    }

    @NonNull
    public static ChannelActivityChannelMainBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityChannelMainBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityChannelMainBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityChannelMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_channel_main, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityChannelMainBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityChannelMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_channel_main, null, false, obj);
    }

    @Nullable
    public ChannelMainActivity.a f() {
        return this.f7459a;
    }

    @Nullable
    public ChannelMainVM g() {
        return this.f7460a;
    }

    public abstract void l(@Nullable ChannelMainActivity.a aVar);

    public abstract void m(@Nullable ChannelMainVM channelMainVM);
}
