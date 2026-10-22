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
import com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityOutsideAttendDeductionDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f35484a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f11529a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OutsideAttendDeductionDetailVM f11530a;

    public RunActivityOutsideAttendDeductionDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, LayoutToolbarBindingBinding titleBar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35484a = recyclerView;
        this.f11529a = titleBar;
    }

    public static RunActivityOutsideAttendDeductionDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityOutsideAttendDeductionDetailBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityOutsideAttendDeductionDetailBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_outside_attend_deduction_detail);
    }

    @NonNull
    public static RunActivityOutsideAttendDeductionDetailBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityOutsideAttendDeductionDetailBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityOutsideAttendDeductionDetailBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityOutsideAttendDeductionDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_outside_attend_deduction_detail, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityOutsideAttendDeductionDetailBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityOutsideAttendDeductionDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_outside_attend_deduction_detail, null, false, component);
    }

    @Nullable
    public OutsideAttendDeductionDetailVM f() {
        return this.f11530a;
    }

    public abstract void k(@Nullable OutsideAttendDeductionDetailVM vm);
}
