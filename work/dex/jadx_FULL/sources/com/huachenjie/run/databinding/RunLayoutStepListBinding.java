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
import com.github.mikephil.charting.charts.LineChart;
import com.huachenjie.run.R;
import com.huachenjie.run.page.run_detail.RunDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutStepListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TextView f35711a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LineChart f12199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RunDetailVM f12200a;

    @NonNull
    public final TextView b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public RunLayoutStepListBinding(Object _bindingComponent, View _root, int _localFieldCount, LineChart chartStep, TextView tvAverageStepsTitle, TextView tvChartUnit, TextView tvStepSuggest, TextView tvStepTitle, TextView tvTotalSteps, TextView tvTotalStepsTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f12199a = chartStep;
        this.f35711a = tvAverageStepsTitle;
        this.b = tvChartUnit;
        this.c = tvStepSuggest;
        this.d = tvStepTitle;
        this.e = tvTotalSteps;
        this.f = tvTotalStepsTitle;
    }

    public static RunLayoutStepListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutStepListBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutStepListBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_step_list);
    }

    @NonNull
    public static RunLayoutStepListBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutStepListBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutStepListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutStepListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_step_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutStepListBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutStepListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_step_list, null, false, component);
    }

    @Nullable
    public RunDetailVM f() {
        return this.f12200a;
    }

    public abstract void k(@Nullable RunDetailVM vm);
}
