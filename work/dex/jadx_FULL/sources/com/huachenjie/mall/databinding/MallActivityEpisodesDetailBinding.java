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
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.video.AliVideoView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity;
import com.huachenjie.mall.page.episodes_detail.EpisodesDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallActivityEpisodesDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f34789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f10196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f10197a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final AliVideoView f10198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EpisodesDetailActivity.a f10199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EpisodesDetailVM f10200a;

    public MallActivityEpisodesDetailBinding(Object obj, View view, int i, SlidingTabLayout2 slidingTabLayout2, LayoutToolbarBindingBinding layoutToolbarBindingBinding, AliVideoView aliVideoView, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.f10196a = slidingTabLayout2;
        this.f10197a = layoutToolbarBindingBinding;
        this.f10198a = aliVideoView;
        this.f34789a = viewPager2;
    }

    public static MallActivityEpisodesDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallActivityEpisodesDetailBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallActivityEpisodesDetailBinding) ViewDataBinding.bind(obj, view, R.layout.mall_activity_episodes_detail);
    }

    @NonNull
    public static MallActivityEpisodesDetailBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallActivityEpisodesDetailBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallActivityEpisodesDetailBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallActivityEpisodesDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_episodes_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallActivityEpisodesDetailBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallActivityEpisodesDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_activity_episodes_detail, null, false, obj);
    }

    @Nullable
    public EpisodesDetailActivity.a f() {
        return this.f10199a;
    }

    @Nullable
    public EpisodesDetailVM g() {
        return this.f10200a;
    }

    public abstract void l(@Nullable EpisodesDetailActivity.a aVar);

    public abstract void m(@Nullable EpisodesDetailVM episodesDetailVM);
}
