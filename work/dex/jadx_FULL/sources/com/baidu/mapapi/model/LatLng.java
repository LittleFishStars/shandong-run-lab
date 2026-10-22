package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class LatLng implements Parcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f26499a = "LatLng";
    public final double latitude;
    public final double latitudeE6;
    public final double longitude;
    public final double longitudeE6;

    public static class a implements Parcelable.Creator<LatLng> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LatLng createFromParcel(Parcel parcel) {
            return new LatLng(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LatLng[] newArray(int i) {
            return new LatLng[i];
        }
    }

    public LatLng(double d, double d2) {
        if (Double.isNaN(d) || Double.isNaN(d2) || Double.isInfinite(d) || Double.isInfinite(d2)) {
            this.latitudeE6 = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.longitudeE6 = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.latitude = AudioStats.AUDIO_AMPLITUDE_NONE;
            this.longitude = AudioStats.AUDIO_AMPLITUDE_NONE;
            return;
        }
        double d3 = d * 1000000.0d;
        double d4 = d2 * 1000000.0d;
        this.latitudeE6 = d3;
        this.longitudeE6 = d4;
        this.latitude = d3 / 1000000.0d;
        this.longitude = d4 / 1000000.0d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((new String("latitude: ") + this.latitude) + ", longitude: ") + this.longitude;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitudeE6);
        parcel.writeDouble(this.longitudeE6);
    }

    public LatLng(Parcel parcel) {
        this.latitude = parcel.readDouble();
        this.longitude = parcel.readDouble();
        this.latitudeE6 = parcel.readDouble();
        this.longitudeE6 = parcel.readDouble();
    }
}
