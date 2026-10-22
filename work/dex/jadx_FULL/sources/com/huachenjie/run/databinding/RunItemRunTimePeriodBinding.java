package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.bean.RunTimeAreaData;
import com.huachenjie.run.R;
import com.huachenjie.run.widget.RunTimeAreaChipView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunItemRunTimePeriodBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public RunTimeAreaData f35633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunTimeAreaChipView f11975a;

    public RunItemRunTimePeriodBinding(Object _bindingComponent, View _root, int _localFieldCount, RunTimeAreaChipView tvTimeInfo) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11975a = tvTimeInfo;
    }

    public static RunItemRunTimePeriodBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunItemRunTimePeriodBinding d(@NonNull View view, @Nullable Object component) {
        return (RunItemRunTimePeriodBinding) ViewDataBinding.bind(component, view, R.layout.run_item_run_time_period);
    }

    @NonNull
    public static RunItemRunTimePeriodBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunItemRunTimePeriodBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunItemRunTimePeriodBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunItemRunTimePeriodBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_run_time_period, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunItemRunTimePeriodBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunItemRunTimePeriodBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_run_time_period, null, false, component);
    }

    @Nullable
    public RunTimeAreaData f() {
        return this.f35633a;
    }

    public abstract void k(@Nullable RunTimeAreaData data);
}
