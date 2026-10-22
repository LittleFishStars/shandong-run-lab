package com.huachenjie.mall.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.mall.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class MallItemSearchTextSwitchBinding extends ViewDataBinding {

    @Bindable
    public String f;

    public MallItemSearchTextSwitchBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static MallItemSearchTextSwitchBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static MallItemSearchTextSwitchBinding d(@NonNull View view, @Nullable Object obj) {
        return (MallItemSearchTextSwitchBinding) ViewDataBinding.bind(obj, view, R.layout.mall_item_search_text_switch);
    }

    @NonNull
    public static MallItemSearchTextSwitchBinding g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static MallItemSearchTextSwitchBinding h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static MallItemSearchTextSwitchBinding i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (MallItemSearchTextSwitchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_search_text_switch, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static MallItemSearchTextSwitchBinding j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (MallItemSearchTextSwitchBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mall_item_search_text_switch, null, false, obj);
    }

    @Nullable
    public String f() {
        return this.f;
    }

    public abstract void k(@Nullable String str);
}
