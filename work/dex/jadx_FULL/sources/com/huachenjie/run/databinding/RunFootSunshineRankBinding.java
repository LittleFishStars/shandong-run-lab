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
import com.huachenjie.run.page.rankinglist.SunshineRankingVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunFootSunshineRankBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Bindable
    public SunshineRankingVM f35565a;

    public RunFootSunshineRankBinding(Object _bindingComponent, View _root, int _localFieldCount) {
        super(_bindingComponent, _root, _localFieldCount);
    }

    public static RunFootSunshineRankBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunFootSunshineRankBinding d(@NonNull View view, @Nullable Object component) {
        return (RunFootSunshineRankBinding) ViewDataBinding.bind(component, view, R.layout.run_foot_sunshine_rank);
    }

    @NonNull
    public static RunFootSunshineRankBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunFootSunshineRankBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunFootSunshineRankBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunFootSunshineRankBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_foot_sunshine_rank, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunFootSunshineRankBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunFootSunshineRankBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_foot_sunshine_rank, null, false, component);
    }

    @Nullable
    public SunshineRankingVM f() {
        return this.f35565a;
    }

    public abstract void k(@Nullable SunshineRankingVM vm);
}
