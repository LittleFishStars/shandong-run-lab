package com.kwad.sdk.api;

import androidx.annotation.Keep;
import androidx.camera.video.AudioStats;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkApi
@Keep
public class KsLocation {
    private double mLatitude;
    private double mLongitude;
    private double mAltitude = AudioStats.AUDIO_AMPLITUDE_NONE;
    private float mSpeed = 0.0f;
    private float mBearing = 0.0f;

    public KsLocation(double d, double d2) {
        this.mLatitude = d;
        this.mLongitude = d2;
    }

    public double getAltitude() {
        return this.mAltitude;
    }

    public float getBearing() {
        return this.mBearing;
    }

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public void setAltitude(double d) {
        this.mAltitude = d;
    }

    public void setBearing(float f) {
        this.mBearing = f;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }

    public void setSpeed(float f) {
        this.mSpeed = f;
    }
}
