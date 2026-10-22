package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityWearableDeductionDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f35514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f11662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WearableDeductionDetailVM f11663a;

    public RunActivityWearableDeductionDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, LayoutToolbarBindingBinding titleBar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35514a = recyclerView;
        this.f11662a = titleBar;
    }

    public static RunActivityWearableDeductionDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityWearableDeductionDetailBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityWearableDeductionDetailBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_wearable_deduction_detail);
    }

    @NonNull
    public static RunActivityWearableDeductionDetailBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityWearableDeductionDetailBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityWearableDeductionDetailBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityWearableDeductionDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_wearable_deduction_detail, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityWearableDeductionDetailBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityWearableDeductionDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_wearable_deduction_detail, null, false, component);
    }

    @Nullable
    public WearableDeductionDetailVM f() {
        return this.f11663a;
    }

    public abstract void k(@Nullable WearableDeductionDetailVM vm);
}
