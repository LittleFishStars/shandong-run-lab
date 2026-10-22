package com.huachenjie.works.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.works.R;
import com.huachenjie.works.page.alumni.original.OriginalChannelVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksFragmentOriginalChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f36919a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ViewPager2 f14224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SelectBoldTabLayout f14225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public OriginalChannelVM f14226a;

    public WorksFragmentOriginalChannelBinding(Object _bindingComponent, View _root, int _localFieldCount, SelectBoldTabLayout tabLayout, View vStatusSpace, ViewPager2 viewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f14225a = tabLayout;
        this.f36919a = vStatusSpace;
        this.f14224a = viewPager;
    }

    public static WorksFragmentOriginalChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksFragmentOriginalChannelBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksFragmentOriginalChannelBinding) ViewDataBinding.bind(component, view, R.layout.works_fragment_original_channel);
    }

    @NonNull
    public static WorksFragmentOriginalChannelBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksFragmentOriginalChannelBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksFragmentOriginalChannelBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksFragmentOriginalChannelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_original_channel, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksFragmentOriginalChannelBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksFragmentOriginalChannelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_fragment_original_channel, null, false, component);
    }

    @Nullable
    public OriginalChannelVM f() {
        return this.f14226a;
    }

    public abstract void k(@Nullable OriginalChannelVM vm);
}
