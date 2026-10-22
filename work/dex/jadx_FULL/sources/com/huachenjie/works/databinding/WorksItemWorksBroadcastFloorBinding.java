package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.works.R;
import com.huachenjie.works.external.bean.WorkItemBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksItemWorksBroadcastFloorBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f37087a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f14749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WorkItemBean f14750a;

    public WorksItemWorksBroadcastFloorBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivImage, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f37087a = ivImage;
        this.f14749a = tvTitle;
    }

    public static WorksItemWorksBroadcastFloorBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksItemWorksBroadcastFloorBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksItemWorksBroadcastFloorBinding) ViewDataBinding.bind(component, view, R.layout.works_item_works_broadcast_floor);
    }

    @NonNull
    public static WorksItemWorksBroadcastFloorBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksItemWorksBroadcastFloorBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksBroadcastFloorBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksItemWorksBroadcastFloorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_broadcast_floor, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksItemWorksBroadcastFloorBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksItemWorksBroadcastFloorBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_item_works_broadcast_floor, null, false, component);
    }

    @Nullable
    public WorkItemBean f() {
        return this.f14750a;
    }

    public abstract void k(@Nullable WorkItemBean vm);
}
