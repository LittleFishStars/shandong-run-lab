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
public abstract class HomeItemSearchTextSwitchBinding extends ViewDataBinding {

    @Bindable
    public String f;

    public HomeItemSearchTextSwitchBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static HomeItemSearchTextSwitchBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static HomeItemSearchTextSwitchBinding d(@NonNull View view, @Nullable Object obj) {
        return (HomeItemSearchTextSwitchBinding) ViewDataBinding.bind(obj, view, R.layout.home_item_search_text_switch);
    }

    @NonNull
    public static HomeItemSearchTextSwitchBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static HomeItemSearchTextSwitchBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static HomeItemSearchTextSwitchBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (HomeItemSearchTextSwitchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_search_text_switch, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static HomeItemSearchTextSwitchBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (HomeItemSearchTextSwitchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.home_item_search_text_switch, null, false, obj);
    }

    @Nullable
    public String f() {
        return this.f;
    }

    public abstract void k(@Nullable String str);
}
