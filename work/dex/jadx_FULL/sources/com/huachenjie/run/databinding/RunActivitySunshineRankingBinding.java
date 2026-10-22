package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.flyco.tablayout.SlidingTabLayout2;
import com.huachenjie.run.R;
import com.huachenjie.run.page.rankinglist.SunshineRankingActivity;
import com.huachenjie.run.page.rankinglist.SunshineRankingActivityVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivitySunshineRankingBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager2 f11605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout2 f11606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRankingActivity.a f11607a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public SunshineRankingActivityVM f11608a;

    @NonNull
    public final ImageView b;

    public RunActivitySunshineRankingBinding(Object _bindingComponent, View _root, int _localFieldCount, SlidingTabLayout2 sunshineRankingTab, ViewPager2 sunshineRankingVp, ImageView titleLeftBt, ImageView titleRightBt) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11606a = sunshineRankingTab;
        this.f11605a = sunshineRankingVp;
        this.f35500a = titleLeftBt;
        this.b = titleRightBt;
    }

    public static RunActivitySunshineRankingBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivitySunshineRankingBinding d(@NonNull View view, @Nullable Object component) {
        return (RunActivitySunshineRankingBinding) ViewDataBinding.bind(component, view, R.layout.run_activity_sunshine_ranking);
    }

    @NonNull
    public static RunActivitySunshineRankingBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivitySunshineRankingBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivitySunshineRankingBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivitySunshineRankingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_sunshine_ranking, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivitySunshineRankingBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivitySunshineRankingBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_sunshine_ranking, null, false, component);
    }

    @Nullable
    public SunshineRankingActivity.a f() {
        return this.f11607a;
    }

    @Nullable
    public SunshineRankingActivityVM g() {
        return this.f11608a;
    }

    public abstract void l(@Nullable SunshineRankingActivity.a click);

    public abstract void m(@Nullable SunshineRankingActivityVM vm);
}
