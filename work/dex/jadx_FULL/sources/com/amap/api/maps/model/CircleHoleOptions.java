package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class CircleHoleOptions extends BaseHoleOptions implements Parcelable {

    @JBindingExclude
    public static final Parcelable.Creator<CircleHoleOptions> CREATOR = new Parcelable.Creator<CircleHoleOptions>() { // from class: com.amap.api.maps.model.CircleHoleOptions.1
        private static CircleHoleOptions a(Parcel parcel) {
            return new CircleHoleOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CircleHoleOptions createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CircleHoleOptions[] newArray(int i) {
            return a(i);
        }

        private static CircleHoleOptions[] a(int i) {
            return new CircleHoleOptions[i];
        }
    };
    private LatLng point;
    private double radius;

    public CircleHoleOptions() {
        this.point = null;
        this.radius = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.isPolygonHoleOptions = false;
    }

    public CircleHoleOptions center(LatLng latLng) {
        this.point = latLng;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getCenter() {
        return this.point;
    }

    public double getRadius() {
        return this.radius;
    }

    public CircleHoleOptions radius(double d) {
        this.radius = d;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
    }

    @JBindingExclude
    public CircleHoleOptions(Parcel parcel) {
        this.point = null;
        this.radius = AudioStats.AUDIO_AMPLITUDE_NONE;
        Bundle bundle = parcel.readBundle();
        this.point = new LatLng(bundle.getDouble("lat"), bundle.getDouble("lng"));
        this.radius = parcel.readDouble();
    }
}
