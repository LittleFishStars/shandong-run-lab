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
import com.huachenjie.works.page.alumni.good_stuff.GoodStuffFragment;
import com.huachenjie.works.page.alumni.good_stuff.GoodStuffVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentGoodStuffBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager f14197a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout f14198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodStuffFragment.a f14199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GoodStuffVM f14200a;

    public WorksFragmentGoodStuffBinding(Object _bindingComponent, View _root, int _localFieldCount, SlidingTabLayout tabLayout, View vStatusSpace, ViewPager viewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14198a = tabLayout;
        this.f36908a = vStatusSpace;
        this.f14197a = viewPager;
    }

    public static WorksFragmentGoodStuffBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentGoodStuffBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentGoodStuffBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_good_stuff);
    }

    @NonNull
    public static WorksFragmentGoodStuffBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentGoodStuffBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentGoodStuffBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentGoodStuffBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_good_stuff, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentGoodStuffBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentGoodStuffBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_good_stuff, null, false, component);
    }

    @Nullable
    public GoodStuffFragment.a f() {
        return this.f14199a;
    }

    @Nullable
    public GoodStuffVM g() {
        return this.f14200a;
    }

    public abstract void l(@Nullable GoodStuffFragment.a click);

    public abstract void m(@Nullable GoodStuffVM vm);
}
