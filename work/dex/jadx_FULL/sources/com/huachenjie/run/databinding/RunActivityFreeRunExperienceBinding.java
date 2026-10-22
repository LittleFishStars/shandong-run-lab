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
import com.huachenjie.run.page.free_run.FreeRunExperienceActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityFreeRunExperienceBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public FreeRunExperienceActivity.a f35464a;

    public RunActivityFreeRunExperienceBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static RunActivityFreeRunExperienceBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityFreeRunExperienceBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityFreeRunExperienceBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_free_run_experience);
    }

    @NonNull
    public static RunActivityFreeRunExperienceBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityFreeRunExperienceBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityFreeRunExperienceBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityFreeRunExperienceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_free_run_experience, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityFreeRunExperienceBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityFreeRunExperienceBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_free_run_experience, null, false, component);
    }

    @Nullable
    public FreeRunExperienceActivity.a f() {
        return this.f35464a;
    }

    public abstract void k(@Nullable FreeRunExperienceActivity.a click);
}
