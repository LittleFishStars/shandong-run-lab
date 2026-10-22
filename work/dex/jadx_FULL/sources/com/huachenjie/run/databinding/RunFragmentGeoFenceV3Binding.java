package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.widget.CheckTextView;
import com.huachenjie.common.widget.ShadowConstraintLayout;
import com.huachenjie.run.R;
import com.huachenjie.run.page.geofence.GeoFenceFragment;
import com.huachenjie.run.page.geofence.GeoFenceV2VM;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunFragmentGeoFenceV3Binding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f35581a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f11833a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckTextView f11835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ShadowConstraintLayout f11836a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutRunGuideCustomerServiceBinding f11837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final RunLayoutRunGuideTipBinding f11838a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GeoFenceFragment.a f11839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GeoFenceV2VM f11840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLLinearLayout f11841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final BLTextView f11842a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f11843b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public RunFragmentGeoFenceV3Binding(Object _bindingComponent, View _root, int _localFieldCount, ShadowConstraintLayout bottomContentLayout, FrameLayout flMapContainer, RunLayoutRunGuideCustomerServiceBinding includeCs, RunLayoutRunGuideTipBinding includeTip, ImageView ivOpenTime, ImageView ivRunTypeTitle, BLLinearLayout llGuideAnim, TextView tvFenceMore, TextView tvGeoFenceTitle, CheckTextView tvOpenStatus, TextView tvOpenTimeTitle, TextView tvOpenTimeValue, TextView tvRunTypeName, BLTextView tvRunTypeTip, TextView tvRunTypeTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f11836a = bottomContentLayout;
        this.f35581a = flMapContainer;
        this.f11837a = includeCs;
        this.f11838a = includeTip;
        this.f11833a = ivOpenTime;
        this.b = ivRunTypeTitle;
        this.f11841a = llGuideAnim;
        this.f11834a = tvFenceMore;
        this.f11843b = tvGeoFenceTitle;
        this.f11835a = tvOpenStatus;
        this.c = tvOpenTimeTitle;
        this.d = tvOpenTimeValue;
        this.e = tvRunTypeName;
        this.f11842a = tvRunTypeTip;
        this.f = tvRunTypeTitle;
    }

    public static RunFragmentGeoFenceV3Binding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunFragmentGeoFenceV3Binding d(@NonNull View view, @Nullable Object component) {
        return (RunFragmentGeoFenceV3Binding) ViewDataBinding.bind(component, view, R.layout.run_fragment_geo_fence_v3);
    }

    @NonNull
    public static RunFragmentGeoFenceV3Binding h(@NonNull LayoutInflater inflater) {
        return k(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunFragmentGeoFenceV3Binding i(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return j(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunFragmentGeoFenceV3Binding j(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunFragmentGeoFenceV3Binding) ViewDataBinding.inflateInternal(inflater, R.layout.run_fragment_geo_fence_v3, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunFragmentGeoFenceV3Binding k(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunFragmentGeoFenceV3Binding) ViewDataBinding.inflateInternal(inflater, R.layout.run_fragment_geo_fence_v3, null, false, component);
    }

    @Nullable
    public GeoFenceFragment.a f() {
        return this.f11839a;
    }

    @Nullable
    public GeoFenceV2VM g() {
        return this.f11840a;
    }

    public abstract void l(@Nullable GeoFenceFragment.a click);

    public abstract void m(@Nullable GeoFenceV2VM mState);
}
