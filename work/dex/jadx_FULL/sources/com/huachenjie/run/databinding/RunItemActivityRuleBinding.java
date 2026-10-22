package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.bean.ActivityRunRule;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunItemActivityRuleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public ActivityRunRule f35605a;

    public RunItemActivityRuleBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static RunItemActivityRuleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunItemActivityRuleBinding d(@NonNull View view, @Nullable Object component) {
        return (RunItemActivityRuleBinding) ViewDataBinding.bind(component, view, R.layout.run_item_activity_rule);
    }

    @NonNull
    public static RunItemActivityRuleBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunItemActivityRuleBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunItemActivityRuleBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunItemActivityRuleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_activity_rule, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunItemActivityRuleBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunItemActivityRuleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_activity_rule, null, false, component);
    }

    @Nullable
    public ActivityRunRule f() {
        return this.f35605a;
    }

    public abstract void k(@Nullable ActivityRunRule mState);
}
