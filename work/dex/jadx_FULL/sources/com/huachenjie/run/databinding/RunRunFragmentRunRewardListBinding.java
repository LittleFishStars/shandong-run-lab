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
import com.huachenjie.run.page.run_reward.RunRewardListVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunRunFragmentRunRewardListBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public RunRewardListVM f35743a;

    public RunRunFragmentRunRewardListBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static RunRunFragmentRunRewardListBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunRunFragmentRunRewardListBinding d(@NonNull View view, @Nullable Object component) {
        return (RunRunFragmentRunRewardListBinding) ViewDataBinding.bind(component, view, R.layout.run_run_fragment_run_reward_list);
    }

    @NonNull
    public static RunRunFragmentRunRewardListBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunRunFragmentRunRewardListBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunRunFragmentRunRewardListBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunRunFragmentRunRewardListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_run_fragment_run_reward_list, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunRunFragmentRunRewardListBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunRunFragmentRunRewardListBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_run_fragment_run_reward_list, null, false, component);
    }

    @Nullable
    public RunRewardListVM f() {
        return this.f35743a;
    }

    public abstract void k(@Nullable RunRewardListVM vm);
}
