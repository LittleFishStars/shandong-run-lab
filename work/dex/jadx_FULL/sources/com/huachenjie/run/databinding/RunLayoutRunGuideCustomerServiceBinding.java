package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.noober.background.view.BLLinearLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunLayoutRunGuideCustomerServiceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public View.OnClickListener f35690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f12142a;

    public RunLayoutRunGuideCustomerServiceBinding(Object _bindingComponent, View _root, int _localFieldCount, BLLinearLayout tvQA) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f12142a = tvQA;
    }

    public static RunLayoutRunGuideCustomerServiceBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunLayoutRunGuideCustomerServiceBinding d(@NonNull View view, @Nullable Object component) {
        return (RunLayoutRunGuideCustomerServiceBinding) ViewDataBinding.bind(component, view, R.layout.run_layout_run_guide_customer_service);
    }

    @NonNull
    public static RunLayoutRunGuideCustomerServiceBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunLayoutRunGuideCustomerServiceBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunGuideCustomerServiceBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunLayoutRunGuideCustomerServiceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_guide_customer_service, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunLayoutRunGuideCustomerServiceBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunLayoutRunGuideCustomerServiceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_layout_run_guide_customer_service, null, false, component);
    }

    @Nullable
    public View.OnClickListener f() {
        return this.f35690a;
    }

    public abstract void setOnClick(@Nullable View.OnClickListener onClick);
}
