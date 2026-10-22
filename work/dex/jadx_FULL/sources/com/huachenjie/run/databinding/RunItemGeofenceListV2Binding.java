package com.huachenjie.run.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.Bindable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.widget.CheckTextView;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public abstract class RunItemGeofenceListV2Binding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ImageView f35616a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f11931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f11932a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public GeoFenceDetail f11933a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final CheckTextView f11934a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Boolean f11935a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Bindable
    public Integer f11936a;

    @NonNull
    public final CheckTextView b;

    @NonNull
    public final CheckTextView c;

    @NonNull
    public final CheckTextView d;

    @Bindable
    public String f;

    public RunItemGeofenceListV2Binding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivGeoFenceLocation, LinearLayout llGeoFenceSub, CheckTextView tvGeoFenceDistance, TextView tvGeoFenceDistanceOnly, CheckTextView tvGeoFenceIndex, CheckTextView tvGeoFenceName, CheckTextView tvGeoFenceOpen) {
        super(_bindingComponent, _root, _localFieldCount);
        this.f35616a = ivGeoFenceLocation;
        this.f11931a = llGeoFenceSub;
        this.f11934a = tvGeoFenceDistance;
        this.f11932a = tvGeoFenceDistanceOnly;
        this.b = tvGeoFenceIndex;
        this.c = tvGeoFenceName;
        this.d = tvGeoFenceOpen;
    }

    public static RunItemGeofenceListV2Binding c(@NonNull View view) {
        return d(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RunItemGeofenceListV2Binding d(@NonNull View view, @Nullable Object component) {
        return (RunItemGeofenceListV2Binding) ViewDataBinding.bind(component, view, R.layout.run_item_geofence_list_v2);
    }

    @NonNull
    public static RunItemGeofenceListV2Binding k(@NonNull LayoutInflater inflater) {
        return n(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static RunItemGeofenceListV2Binding l(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return m(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RunItemGeofenceListV2Binding m(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (RunItemGeofenceListV2Binding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_geofence_list_v2, root, attachToRoot, component);
    }

    @NonNull
    @Deprecated
    public static RunItemGeofenceListV2Binding n(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (RunItemGeofenceListV2Binding) ViewDataBinding.inflateInternal(inflater, R.layout.run_item_geofence_list_v2, null, false, component);
    }

    @Nullable
    public Boolean f() {
        return this.f11935a;
    }

    @Nullable
    public GeoFenceDetail g() {
        return this.f11933a;
    }

    @Nullable
    public String h() {
        return this.f;
    }

    @Nullable
    public Integer j() {
        return this.f11936a;
    }

    public abstract void o(@Nullable Boolean contains);

    public abstract void p(@Nullable GeoFenceDetail data);

    public abstract void q(@Nullable String distance);

    public abstract void r(@Nullable Integer index);
}
