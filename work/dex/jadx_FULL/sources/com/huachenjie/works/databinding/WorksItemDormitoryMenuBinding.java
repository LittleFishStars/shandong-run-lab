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
import com.huachenjie.works.bean.DormitoryMenuBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemDormitoryMenuBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public DormitoryMenuBean f37027a;

    public WorksItemDormitoryMenuBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemDormitoryMenuBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemDormitoryMenuBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemDormitoryMenuBinding) ViewDataBinding.bind(component, view, R.layout.works_item_dormitory_menu);
    }

    @NonNull
    public static WorksItemDormitoryMenuBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemDormitoryMenuBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemDormitoryMenuBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemDormitoryMenuBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_dormitory_menu, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemDormitoryMenuBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemDormitoryMenuBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_dormitory_menu, null, false, component);
    }

    @Nullable
    public DormitoryMenuBean f() {
        return this.f37027a;
    }

    public abstract void k(@Nullable DormitoryMenuBean bean);
}
