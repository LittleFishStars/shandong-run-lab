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
import com.huachenjie.works.bean.WorksDetailMenuBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemWorksDetailMenuBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public WorksDetailMenuBean f37091a;

    public WorksItemWorksDetailMenuBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemWorksDetailMenuBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemWorksDetailMenuBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemWorksDetailMenuBinding) ViewDataBinding.bind(component, view, R.layout.works_item_works_detail_menu);
    }

    @NonNull
    public static WorksItemWorksDetailMenuBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemWorksDetailMenuBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksDetailMenuBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemWorksDetailMenuBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_detail_menu, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksDetailMenuBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemWorksDetailMenuBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_detail_menu, null, false, component);
    }

    @Nullable
    public WorksDetailMenuBean f() {
        return this.f37091a;
    }

    public abstract void k(@Nullable WorksDetailMenuBean bean);
}
