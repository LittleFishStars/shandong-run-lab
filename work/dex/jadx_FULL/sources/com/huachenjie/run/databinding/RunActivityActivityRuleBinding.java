package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.run.R;
import com.huachenjie.run.page.activities_run.DetailActivity;
import com.huachenjie.run.page.activities_run.DetailActivityVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityActivityRuleBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f35441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetailActivity.a f11405a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public DetailActivityVM f11406a;

    @NonNull
    public final RelativeLayout b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11407b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final TextView h;

    public RunActivityActivityRuleBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout rlHaveChance, RelativeLayout rlNoChance, TextView tvDisName, TextView tvDisValue, TextView tvLeftCount, TextView tvLeftCount2, TextView tvLeftName, TextView tvLeftName2, TextView tvStart, TextView tvStart2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35441a = rlHaveChance;
        this.b = rlNoChance;
        this.f11404a = tvDisName;
        this.f11407b = tvDisValue;
        this.c = tvLeftCount;
        this.d = tvLeftCount2;
        this.e = tvLeftName;
        this.f = tvLeftName2;
        this.g = tvStart;
        this.h = tvStart2;
    }

    public static RunActivityActivityRuleBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityActivityRuleBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityActivityRuleBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_activity_rule);
    }

    @NonNull
    public static RunActivityActivityRuleBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityActivityRuleBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityActivityRuleBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityActivityRuleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_activity_rule, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityActivityRuleBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityActivityRuleBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_activity_rule, null, false, component);
    }

    @Nullable
    public DetailActivity.a f() {
        return this.f11405a;
    }

    @Nullable
    public DetailActivityVM g() {
        return this.f11406a;
    }

    public abstract void l(@Nullable DetailActivity.a click);

    public abstract void m(@Nullable DetailActivityVM vm);
}
