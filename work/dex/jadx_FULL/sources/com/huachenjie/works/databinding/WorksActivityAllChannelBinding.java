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
import com.huachenjie.works.page.channel.list.AllChannelVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class WorksActivityAllChannelBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager f36767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final SlidingTabLayout f13811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public AllChannelVM f13812a;

    public WorksActivityAllChannelBinding(Object _bindingComponent, View _root, int _localFieldCount, SlidingTabLayout tabLayout, ViewPager viewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f13811a = tabLayout;
        this.f36767a = viewPager;
    }

    public static WorksActivityAllChannelBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WorksActivityAllChannelBinding d(@NonNull View view, @Nullable Object component) {
        return (WorksActivityAllChannelBinding) ViewDataBinding.bind(component, view, R.layout.works_activity_all_channel);
    }

    @NonNull
    public static WorksActivityAllChannelBinding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WorksActivityAllChannelBinding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WorksActivityAllChannelBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (WorksActivityAllChannelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_all_channel, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static WorksActivityAllChannelBinding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (WorksActivityAllChannelBinding) ViewDataBinding.inflateInternal(inflater, R.layout.works_activity_all_channel, null, false, component);
    }

    @Nullable
    public AllChannelVM f() {
        return this.f13812a;
    }

    public abstract void k(@Nullable AllChannelVM vm);
}
