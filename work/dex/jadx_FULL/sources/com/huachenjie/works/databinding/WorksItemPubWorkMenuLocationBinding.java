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
import com.huachenjie.works.bean.publish.PubWorkLocationItemBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemPubWorkMenuLocationBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public PubWorkLocationItemBean f37051a;

    public WorksItemPubWorkMenuLocationBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemPubWorkMenuLocationBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemPubWorkMenuLocationBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemPubWorkMenuLocationBinding) ViewDataBinding.bind(component, view, R.layout.works_item_pub_work_menu_location);
    }

    @NonNull
    public static WorksItemPubWorkMenuLocationBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemPubWorkMenuLocationBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemPubWorkMenuLocationBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemPubWorkMenuLocationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_pub_work_menu_location, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemPubWorkMenuLocationBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemPubWorkMenuLocationBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_pub_work_menu_location, null, false, component);
    }

    @Nullable
    public PubWorkLocationItemBean f() {
        return this.f37051a;
    }

    public abstract void k(@Nullable PubWorkLocationItemBean bean);
}
