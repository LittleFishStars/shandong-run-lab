package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemGoodStuffBannerBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Banner f34267a;

    public HomeItemGoodStuffBannerBinding(Object obj, View view, int i, Banner banner) {
        super(obj, view, i);
        this.f34267a = banner;
    }

    public static HomeItemGoodStuffBannerBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemGoodStuffBannerBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemGoodStuffBannerBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_good_stuff_banner);
    }

    @NonNull
    public static HomeItemGoodStuffBannerBinding e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemGoodStuffBannerBinding f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemGoodStuffBannerBinding g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemGoodStuffBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_good_stuff_banner, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemGoodStuffBannerBinding h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemGoodStuffBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_good_stuff_banner, null, false, obj);
    }
}
