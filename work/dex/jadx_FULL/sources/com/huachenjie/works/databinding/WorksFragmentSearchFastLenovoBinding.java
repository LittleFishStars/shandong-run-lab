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
import com.huachenjie.works.page.search.fast_lenovo.SearchFastLenovoModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentSearchFastLenovoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SearchFastLenovoModel f36944a;

    public WorksFragmentSearchFastLenovoBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksFragmentSearchFastLenovoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentSearchFastLenovoBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentSearchFastLenovoBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_search_fast_lenovo);
    }

    @NonNull
    public static WorksFragmentSearchFastLenovoBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentSearchFastLenovoBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchFastLenovoBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentSearchFastLenovoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_fast_lenovo, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchFastLenovoBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentSearchFastLenovoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_fast_lenovo, null, false, component);
    }

    @Nullable
    public SearchFastLenovoModel f() {
        return this.f36944a;
    }

    public abstract void k(@Nullable SearchFastLenovoModel vm);
}
