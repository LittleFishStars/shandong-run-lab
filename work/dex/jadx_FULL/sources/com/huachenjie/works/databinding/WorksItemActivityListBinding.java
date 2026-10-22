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
import com.huachenjie.works.bean.MultipleActivityBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemActivityListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public MultipleActivityBean f36993a;

    public WorksItemActivityListBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemActivityListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemActivityListBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemActivityListBinding) ViewDataBinding.bind(component, view, R.layout.works_item_activity_list);
    }

    @NonNull
    public static WorksItemActivityListBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemActivityListBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemActivityListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemActivityListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_activity_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemActivityListBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemActivityListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_activity_list, null, false, component);
    }

    @Nullable
    public MultipleActivityBean f() {
        return this.f36993a;
    }

    public abstract void k(@Nullable MultipleActivityBean bean);
}
