package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.page.geofence.GeoFenceActivityVM;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunActivityRunGeoGuideV3Binding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ViewPager f35486a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CommonTabLayout f11534a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GeoFenceActivityVM f11535a;

    public RunActivityRunGeoGuideV3Binding(Object _bindingComponent, View _root, int _localFieldCount, CommonTabLayout tabLayout, ViewPager viewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11534a = tabLayout;
        this.f35486a = viewPager;
    }

    public static RunActivityRunGeoGuideV3Binding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunActivityRunGeoGuideV3Binding d(@NonNull View view, @Nullable Object component) {
        return (RunActivityRunGeoGuideV3Binding) ViewDataBinding.bind(component, view, R.layout.run_activity_run_geo_guide_v3);
    }

    @NonNull
    public static RunActivityRunGeoGuideV3Binding g(@NonNull LayoutInflater inflater) {
        return j(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunActivityRunGeoGuideV3Binding h(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return i(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunActivityRunGeoGuideV3Binding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunActivityRunGeoGuideV3Binding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_run_geo_guide_v3, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunActivityRunGeoGuideV3Binding j(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunActivityRunGeoGuideV3Binding) ViewDataBinding.inflateInternal(inflater, R.layout.run_activity_run_geo_guide_v3, null, false, component);
    }

    @Nullable
    public GeoFenceActivityVM f() {
        return this.f11535a;
    }

    public abstract void k(@Nullable GeoFenceActivityVM mState);
}
