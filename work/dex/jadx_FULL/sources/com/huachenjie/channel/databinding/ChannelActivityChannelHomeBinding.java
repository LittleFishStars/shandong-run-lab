package com.huachenjie.channel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.channel.R;
import com.huachenjie.channel.page.channel_home.ChannelHomeActivity;
import com.huachenjie.channel.page.channel_home.ChannelHomeVM;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.noober.background.view.BLView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class ChannelActivityChannelHomeBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f33045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f7441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f7442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager2 f7443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelHomeActivity.a f7444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ChannelHomeVM f7445a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f7446a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLView f7447a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final BLView f7448b;

    @NonNull
    public final BLView c;

    public ChannelActivityChannelHomeBinding(Object obj, View view, int i, BLView bLView, ImageView imageView, FrameLayout frameLayout, BLView bLView2, ImageView imageView2, RecyclerView recyclerView, LayoutToolbarBindingBinding layoutToolbarBindingBinding, BLView bLView3, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f7447a = bLView;
        this.f7441a = imageView;
        this.f33045a = frameLayout;
        this.f7448b = bLView2;
        this.b = imageView2;
        this.f7442a = recyclerView;
        this.f7446a = layoutToolbarBindingBinding;
        this.c = bLView3;
        this.f7443a = viewPager2;
    }

    public static ChannelActivityChannelHomeBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ChannelActivityChannelHomeBinding d(@NonNull View view, @Nullable Object obj) {
        return (ChannelActivityChannelHomeBinding) ViewDataBinding.bind(obj, view, R.layout.channel_activity_channel_home);
    }

    @NonNull
    public static ChannelActivityChannelHomeBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ChannelActivityChannelHomeBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ChannelActivityChannelHomeBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ChannelActivityChannelHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_channel_home, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ChannelActivityChannelHomeBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ChannelActivityChannelHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.channel_activity_channel_home, null, false, obj);
    }

    @Nullable
    public ChannelHomeActivity.a f() {
        return this.f7444a;
    }

    @Nullable
    public ChannelHomeVM g() {
        return this.f7445a;
    }

    public abstract void l(@Nullable ChannelHomeActivity.a aVar);

    public abstract void m(@Nullable ChannelHomeVM channelHomeVM);
}
