package com.huachenjie.run.databinding;

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
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.run.R;
import com.huachenjie.run.dialog.AllFenceListDialog;
import com.huachenjie.run.dialog.AllFenceListVM;
import com.noober.background.view.BLConstraintLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunDialogAllFenceListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11680a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RecyclerView f11681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AllFenceListDialog.a f11682a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AllFenceListVM f11683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLConstraintLayout f11684a;

    public RunDialogAllFenceListBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView disRecycler, ImageView ivClose, BLConstraintLayout rlRight, TextView tvCloseDrawer) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11681a = disRecycler;
        this.f35521a = ivClose;
        this.f11684a = rlRight;
        this.f11680a = tvCloseDrawer;
    }

    public static RunDialogAllFenceListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunDialogAllFenceListBinding d(@NonNull View view, @Nullable Object component) {
        return (RunDialogAllFenceListBinding) ViewDataBinding.bind(component, view, R.layout.run_dialog_all_fence_list);
    }

    @NonNull
    public static RunDialogAllFenceListBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunDialogAllFenceListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunDialogAllFenceListBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunDialogAllFenceListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_all_fence_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunDialogAllFenceListBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunDialogAllFenceListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_all_fence_list, null, false, component);
    }

    @Nullable
    public AllFenceListDialog.a f() {
        return this.f11682a;
    }

    @Nullable
    public AllFenceListVM g() {
        return this.f11683a;
    }

    public abstract void l(@Nullable AllFenceListDialog.a click);

    public abstract void m(@Nullable AllFenceListVM vm);
}
