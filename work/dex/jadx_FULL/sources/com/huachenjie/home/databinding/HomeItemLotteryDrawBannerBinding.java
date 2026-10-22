package com.huachenjie.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.home.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public abstract class HomeItemLotteryDrawBannerBinding extends ViewDataBinding {

    @Bindable
    public String f;

    public HomeItemLotteryDrawBannerBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static HomeItemLotteryDrawBannerBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemLotteryDrawBannerBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemLotteryDrawBannerBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_lottery_draw_banner);
    }

    @NonNull
    public static HomeItemLotteryDrawBannerBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemLotteryDrawBannerBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemLotteryDrawBannerBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemLotteryDrawBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_lottery_draw_banner, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemLotteryDrawBannerBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemLotteryDrawBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_lottery_draw_banner, null, false, obj);
    }

    @Nullable
    public String f() {
        return this.f;
    }

    public abstract void k(@Nullable String str);
}
