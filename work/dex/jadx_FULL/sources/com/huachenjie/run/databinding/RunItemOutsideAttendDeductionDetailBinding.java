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
import com.huachenjie.run.bean.OutsideDeductionRecordBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunItemOutsideAttendDeductionDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OutsideDeductionRecordBean f11952a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public RunItemOutsideAttendDeductionDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView tvDeductionKmTitle, TextView tvDeductionTimesTitle, TextView tvDeductionTitle, TextView tvDeductionUseTimeTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35622a = tvDeductionKmTitle;
        this.b = tvDeductionTimesTitle;
        this.c = tvDeductionTitle;
        this.d = tvDeductionUseTimeTitle;
    }

    public static RunItemOutsideAttendDeductionDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunItemOutsideAttendDeductionDetailBinding d(@NonNull View view, @Nullable Object component) {
        return (RunItemOutsideAttendDeductionDetailBinding) ViewDataBinding.bind(component, view, R.layout.run_item_outside_attend_deduction_detail);
    }

    @NonNull
    public static RunItemOutsideAttendDeductionDetailBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunItemOutsideAttendDeductionDetailBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunItemOutsideAttendDeductionDetailBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunItemOutsideAttendDeductionDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_outside_attend_deduction_detail, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunItemOutsideAttendDeductionDetailBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunItemOutsideAttendDeductionDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_outside_attend_deduction_detail, null, false, component);
    }

    @Nullable
    public OutsideDeductionRecordBean f() {
        return this.f11952a;
    }

    public abstract void k(@Nullable OutsideDeductionRecordBean bean);
}
