package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.search.hot_spot.SearchHotSpotModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentSearchHotSpotBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final StateLayout f36946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SearchHotSpotModel f14301a;

    public WorksFragmentSearchHotSpotBinding(Object _bindingComponent, View _root, int _localFieldCount, StateLayout stateView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36946a = stateView;
    }

    public static WorksFragmentSearchHotSpotBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentSearchHotSpotBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentSearchHotSpotBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_search_hot_spot);
    }

    @NonNull
    public static WorksFragmentSearchHotSpotBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentSearchHotSpotBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchHotSpotBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentSearchHotSpotBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_hot_spot, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentSearchHotSpotBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentSearchHotSpotBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_search_hot_spot, null, false, component);
    }

    @Nullable
    public SearchHotSpotModel f() {
        return this.f14301a;
    }

    public abstract void k(@Nullable SearchHotSpotModel vm);
}
