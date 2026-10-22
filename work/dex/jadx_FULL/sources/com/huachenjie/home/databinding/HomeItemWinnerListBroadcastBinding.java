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
public abstract class HomeItemWinnerListBroadcastBinding extends ViewDataBinding {

    @Bindable
    public String f;

    public HomeItemWinnerListBroadcastBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static HomeItemWinnerListBroadcastBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemWinnerListBroadcastBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemWinnerListBroadcastBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_winner_list_broadcast);
    }

    @NonNull
    public static HomeItemWinnerListBroadcastBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemWinnerListBroadcastBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemWinnerListBroadcastBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemWinnerListBroadcastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_winner_list_broadcast, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemWinnerListBroadcastBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemWinnerListBroadcastBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_winner_list_broadcast, null, false, obj);
    }

    @Nullable
    public String f() {
        return this.f;
    }

    public abstract void k(@Nullable String str);
}
