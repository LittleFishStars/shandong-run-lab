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
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksDialogBroadcastFloorDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final WorksItemBroadcastFloorBinding f36834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BroadcastFloorDetailDialog.ClickProxy f14006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public BroadcastFloorDetailVM f14007a;

    public WorksDialogBroadcastFloorDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, WorksItemBroadcastFloorBinding content) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f36834a = content;
    }

    public static WorksDialogBroadcastFloorDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksDialogBroadcastFloorDetailBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksDialogBroadcastFloorDetailBinding) ViewDataBinding.bind(component, view, R.layout.works_dialog_broadcast_floor_detail);
    }

    @NonNull
    public static WorksDialogBroadcastFloorDetailBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksDialogBroadcastFloorDetailBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksDialogBroadcastFloorDetailBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksDialogBroadcastFloorDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_broadcast_floor_detail, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksDialogBroadcastFloorDetailBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksDialogBroadcastFloorDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_dialog_broadcast_floor_detail, null, false, component);
    }

    @Nullable
    public BroadcastFloorDetailDialog.ClickProxy f() {
        return this.f14006a;
    }

    @Nullable
    public BroadcastFloorDetailVM g() {
        return this.f14007a;
    }

    public abstract void l(@Nullable BroadcastFloorDetailDialog.ClickProxy click);

    public abstract void m(@Nullable BroadcastFloorDetailVM vm);
}
