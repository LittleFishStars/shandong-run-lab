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
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.page.rankinglist.SunshineRankingFragment;
import com.huachenjie.run.page.rankinglist.SunshineRankingVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunFragmentSunshineRankingBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RecyclerView f35591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final StateLayout f11864a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRankingFragment.c f11865a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRankingVM f11866a;

    public RunFragmentSunshineRankingBinding(Object _bindingComponent, View _root, int _localFieldCount, StateLayout stateLayout, RecyclerView sunshineRankingRv) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11864a = stateLayout;
        this.f35591a = sunshineRankingRv;
    }

    public static RunFragmentSunshineRankingBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunFragmentSunshineRankingBinding d(@NonNull View view, @Nullable Object component) {
        return (RunFragmentSunshineRankingBinding) ViewDataBinding.bind(component, view, R.layout.run_fragment_sunshine_ranking);
    }

    @NonNull
    public static RunFragmentSunshineRankingBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunFragmentSunshineRankingBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunFragmentSunshineRankingBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunFragmentSunshineRankingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_fragment_sunshine_ranking, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunFragmentSunshineRankingBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunFragmentSunshineRankingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_fragment_sunshine_ranking, null, false, component);
    }

    @Nullable
    public SunshineRankingFragment.c f() {
        return this.f11865a;
    }

    @Nullable
    public SunshineRankingVM g() {
        return this.f11866a;
    }

    public abstract void l(@Nullable SunshineRankingFragment.c scroll);

    public abstract void m(@Nullable SunshineRankingVM vm);
}
