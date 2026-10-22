package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.run.R;
import com.huachenjie.run.page.activities_run.ActivityRunListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityActivityRunListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f35444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f11413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public ActivityRunListVM f11414a;

    public RunActivityActivityRunListBinding(Object _bindingComponent, View _root, int _localFieldCount, SlidingTabLayout2 tabLayout, ViewPager2 viewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11413a = tabLayout;
        this.f35444a = viewPager;
    }

    public static RunActivityActivityRunListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityActivityRunListBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityActivityRunListBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_activity_run_list);
    }

    @NonNull
    public static RunActivityActivityRunListBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityActivityRunListBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityActivityRunListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityActivityRunListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_activity_run_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityActivityRunListBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityActivityRunListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_activity_run_list, null, false, component);
    }

    @Nullable
    public ActivityRunListVM f() {
        return this.f11414a;
    }

    public abstract void k(@Nullable ActivityRunListVM vm);
}
