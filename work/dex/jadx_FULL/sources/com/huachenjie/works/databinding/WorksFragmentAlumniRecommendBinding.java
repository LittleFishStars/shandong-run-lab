package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.recommend.RecommendFragment;
import com.huachenjie.works.page.alumni.recommend.RecommendVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentAlumniRecommendBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager f14167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout f14168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RecommendFragment.a f14169a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public RecommendVM f14170a;

    public WorksFragmentAlumniRecommendBinding(Object _bindingComponent, View _root, int _localFieldCount, SlidingTabLayout tabLayout, View vStatusSpace, ViewPager viewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14168a = tabLayout;
        this.f36897a = vStatusSpace;
        this.f14167a = viewPager;
    }

    public static WorksFragmentAlumniRecommendBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentAlumniRecommendBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentAlumniRecommendBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_alumni_recommend);
    }

    @NonNull
    public static WorksFragmentAlumniRecommendBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentAlumniRecommendBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentAlumniRecommendBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentAlumniRecommendBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_alumni_recommend, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentAlumniRecommendBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentAlumniRecommendBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_alumni_recommend, null, false, component);
    }

    @Nullable
    public RecommendFragment.a f() {
        return this.f14169a;
    }

    @Nullable
    public RecommendVM g() {
        return this.f14170a;
    }

    public abstract void l(@Nullable RecommendFragment.a click);

    public abstract void m(@Nullable RecommendVM vm);
}
