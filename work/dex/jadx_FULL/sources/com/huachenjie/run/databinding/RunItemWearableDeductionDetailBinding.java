package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.WearableDeductionRecordBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunItemWearableDeductionDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public WearableDeductionRecordBean f11996a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public RunItemWearableDeductionDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView tvDeductionKmTitle, TextView tvDeductionTimesTitle, TextView tvDeductionTitle, TextView tvDeductionUseTimeTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35641a = tvDeductionKmTitle;
        this.b = tvDeductionTimesTitle;
        this.c = tvDeductionTitle;
        this.d = tvDeductionUseTimeTitle;
    }

    public static RunItemWearableDeductionDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunItemWearableDeductionDetailBinding d(@NonNull View view, @Nullable Object component) {
        return (RunItemWearableDeductionDetailBinding) ViewDataBinding.bind(component, view, R.layout.run_item_wearable_deduction_detail);
    }

    @NonNull
    public static RunItemWearableDeductionDetailBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunItemWearableDeductionDetailBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunItemWearableDeductionDetailBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunItemWearableDeductionDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_wearable_deduction_detail, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunItemWearableDeductionDetailBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunItemWearableDeductionDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_wearable_deduction_detail, null, false, component);
    }

    @Nullable
    public WearableDeductionRecordBean f() {
        return this.f11996a;
    }

    public abstract void k(@Nullable WearableDeductionRecordBean bean);
}
