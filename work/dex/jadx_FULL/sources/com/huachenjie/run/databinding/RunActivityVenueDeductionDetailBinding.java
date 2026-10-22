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
import com.huachenjie.run.page.venue_deduction.VenueDeductionDetailVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityVenueDeductionDetailBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f35512a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LayoutToolbarBindingBinding f11657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public VenueDeductionDetailVM f11658a;

    public RunActivityVenueDeductionDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, RecyclerView recyclerView, LayoutToolbarBindingBinding titleBar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35512a = recyclerView;
        this.f11657a = titleBar;
    }

    public static RunActivityVenueDeductionDetailBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityVenueDeductionDetailBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityVenueDeductionDetailBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_venue_deduction_detail);
    }

    @NonNull
    public static RunActivityVenueDeductionDetailBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityVenueDeductionDetailBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityVenueDeductionDetailBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityVenueDeductionDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_venue_deduction_detail, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityVenueDeductionDetailBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityVenueDeductionDetailBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_venue_deduction_detail, null, false, component);
    }

    @Nullable
    public VenueDeductionDetailVM f() {
        return this.f11658a;
    }

    public abstract void k(@Nullable VenueDeductionDetailVM vm);
}
