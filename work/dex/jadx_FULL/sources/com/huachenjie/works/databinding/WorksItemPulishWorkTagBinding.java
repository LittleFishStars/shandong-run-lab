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
import com.huachenjie.works.bean.WorksTagBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemPulishWorkTagBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public WorksTagBean f37064a;

    public WorksItemPulishWorkTagBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static WorksItemPulishWorkTagBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemPulishWorkTagBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemPulishWorkTagBinding) ViewDataBinding.bind(component, view, R.layout.works_item_pulish_work_tag);
    }

    @NonNull
    public static WorksItemPulishWorkTagBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemPulishWorkTagBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemPulishWorkTagBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemPulishWorkTagBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_pulish_work_tag, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemPulishWorkTagBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemPulishWorkTagBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_pulish_work_tag, null, false, component);
    }

    @Nullable
    public WorksTagBean f() {
        return this.f37064a;
    }

    public abstract void k(@Nullable WorksTagBean bean);
}
