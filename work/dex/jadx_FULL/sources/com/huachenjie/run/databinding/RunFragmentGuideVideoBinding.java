package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.view.CustomVideoView;
import com.huachenjie.run.R;
import com.huachenjie.run.page.geofence.GeoFenceV2VM;
import com.huachenjie.run.page.geofence.VideoGuideFragment;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunFragmentGuideVideoBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CustomVideoView f35587a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutRunGuideCustomerServiceBinding f11851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutRunGuideTipBinding f11852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GeoFenceV2VM f11853a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public VideoGuideFragment.a f11854a;

    public RunFragmentGuideVideoBinding(Object _bindingComponent, View _root, int _localFieldCount, RunLayoutRunGuideCustomerServiceBinding includeCs, RunLayoutRunGuideTipBinding includeTip, CustomVideoView playView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11851a = includeCs;
        this.f11852a = includeTip;
        this.f35587a = playView;
    }

    public static RunFragmentGuideVideoBinding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunFragmentGuideVideoBinding d(@NonNull View view, @Nullable Object component) {
        return (RunFragmentGuideVideoBinding) ViewDataBinding.bind(component, view, R.layout.run_fragment_guide_video);
    }

    @NonNull
    public static RunFragmentGuideVideoBinding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunFragmentGuideVideoBinding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunFragmentGuideVideoBinding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunFragmentGuideVideoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_fragment_guide_video, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunFragmentGuideVideoBinding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunFragmentGuideVideoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.run_fragment_guide_video, null, false, component);
    }

    @Nullable
    public VideoGuideFragment.a f() {
        return this.f11854a;
    }

    @Nullable
    public GeoFenceV2VM g() {
        return this.f11853a;
    }

    public abstract void l(@Nullable VideoGuideFragment.a click);

    public abstract void m(@Nullable GeoFenceV2VM mState);
}
