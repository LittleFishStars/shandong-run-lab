package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.MaxHeightScrollView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.activities_run.dialog.ActivityRuleDialogVm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunDialogActivityRuleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayoutCompat f11673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final MaxHeightScrollView f11674a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ActivityRuleDialogVm f11675a;

    @NonNull
    public final LinearLayoutCompat b;

    public RunDialogActivityRuleBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivClose, LinearLayoutCompat llContent, LinearLayoutCompat llRoot, MaxHeightScrollView scroll) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35518a = ivClose;
        this.f11673a = llContent;
        this.b = llRoot;
        this.f11674a = scroll;
    }

    public static RunDialogActivityRuleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunDialogActivityRuleBinding d(@NonNull View view, @Nullable Object component) {
        return (RunDialogActivityRuleBinding) ViewDataBinding.bind(component, view, R.layout.run_dialog_activity_rule);
    }

    @NonNull
    public static RunDialogActivityRuleBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunDialogActivityRuleBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunDialogActivityRuleBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunDialogActivityRuleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_activity_rule, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunDialogActivityRuleBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunDialogActivityRuleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_dialog_activity_rule, null, false, component);
    }

    @Nullable
    public ActivityRuleDialogVm f() {
        return this.f11675a;
    }

    public abstract void k(@Nullable ActivityRuleDialogVm vm);
}
