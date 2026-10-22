package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.EpisodeItemBean;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemEpisodesListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f34988a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public EpisodeItemBean f10766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f10767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f10768a;

    public MallItemEpisodesListBinding(Object obj, View view, int i, LottieAnimationView lottieAnimationView, BLTextView bLTextView) {
        super(obj, view, i);
        this.f34988a = lottieAnimationView;
        this.f10767a = bLTextView;
    }

    public static MallItemEpisodesListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemEpisodesListBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemEpisodesListBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_episodes_list);
    }

    @NonNull
    public static MallItemEpisodesListBinding h(@NonNull LayoutInflater layoutInflater) {
        return k(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemEpisodesListBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return j(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemEpisodesListBinding j(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemEpisodesListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_episodes_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemEpisodesListBinding k(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemEpisodesListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_episodes_list, null, false, obj);
    }

    @Nullable
    public EpisodeItemBean f() {
        return this.f10766a;
    }

    @Nullable
    public Boolean g() {
        return this.f10768a;
    }

    public abstract void l(@Nullable EpisodeItemBean episodeItemBean);

    public abstract void m(@Nullable Boolean bool);
}
