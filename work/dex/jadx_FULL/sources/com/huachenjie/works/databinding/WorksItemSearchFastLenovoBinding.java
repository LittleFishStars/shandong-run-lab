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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemSearchFastLenovoBinding extends ViewDataBinding {

    @Bindable
    public String f;

    public WorksItemSearchFastLenovoBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemSearchFastLenovoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemSearchFastLenovoBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemSearchFastLenovoBinding) ViewDataBinding.bind(component, view, R.layout.works_item_search_fast_lenovo);
    }

    @NonNull
    public static WorksItemSearchFastLenovoBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemSearchFastLenovoBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemSearchFastLenovoBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemSearchFastLenovoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_search_fast_lenovo, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemSearchFastLenovoBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemSearchFastLenovoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_search_fast_lenovo, null, false, component);
    }

    @Nullable
    public String f() {
        return this.f;
    }

    public abstract void k(@Nullable String bean);
}
