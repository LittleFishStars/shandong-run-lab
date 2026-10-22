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
import com.huachenjie.works.external.bean.WorkItemBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemWorksFirstBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public WorkItemBean f37093a;

    public WorksItemWorksFirstBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemWorksFirstBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemWorksFirstBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemWorksFirstBinding) ViewDataBinding.bind(component, view, R.layout.works_item_works_first);
    }

    @NonNull
    public static WorksItemWorksFirstBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemWorksFirstBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksFirstBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemWorksFirstBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_first, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksFirstBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemWorksFirstBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_first, null, false, component);
    }

    @Nullable
    public WorkItemBean f() {
        return this.f37093a;
    }

    public abstract void k(@Nullable WorkItemBean vm);
}
