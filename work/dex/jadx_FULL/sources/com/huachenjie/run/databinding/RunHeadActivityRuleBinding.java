package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.bean.ActivityRunDetailBean;
import com.huachenjie.common.binding_adapter.FlowAdapter;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunHeadActivityRuleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Flow f35594a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ActivityRunDetailBean f11870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public FlowAdapter f11871a;

    public RunHeadActivityRuleBinding(Object _bindingComponent, View _root, int _localFieldCount, Flow timeFlow) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35594a = timeFlow;
    }

    public static RunHeadActivityRuleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunHeadActivityRuleBinding d(@NonNull View view, @Nullable Object component) {
        return (RunHeadActivityRuleBinding) ViewDataBinding.bind(component, view, R.layout.run_head_activity_rule);
    }

    @NonNull
    public static RunHeadActivityRuleBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunHeadActivityRuleBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunHeadActivityRuleBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunHeadActivityRuleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_head_activity_rule, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunHeadActivityRuleBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunHeadActivityRuleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_head_activity_rule, null, false, component);
    }

    @Nullable
    public FlowAdapter f() {
        return this.f11871a;
    }

    @Nullable
    public ActivityRunDetailBean g() {
        return this.f11870a;
    }

    public abstract void l(@Nullable FlowAdapter flowAdapter);

    public abstract void m(@Nullable ActivityRunDetailBean mState);
}
