package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.search.SearchHotSpotItemBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemSearchHotSpotBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SearchHotSpotItemBean f37067a;

    public WorksItemSearchHotSpotBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemSearchHotSpotBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemSearchHotSpotBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemSearchHotSpotBinding) ViewDataBinding.bind(component, view, R.layout.works_item_search_hot_spot);
    }

    @NonNull
    public static WorksItemSearchHotSpotBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemSearchHotSpotBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemSearchHotSpotBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemSearchHotSpotBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_search_hot_spot, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemSearchHotSpotBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemSearchHotSpotBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_search_hot_spot, null, false, component);
    }

    @Nullable
    public SearchHotSpotItemBean f() {
        return this.f37067a;
    }

    public abstract void k(@Nullable SearchHotSpotItemBean bean);
}
