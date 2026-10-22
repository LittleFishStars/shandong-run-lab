package com.kc.bw.common.bean;

import androidx.camera.video.AudioStats;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class WMLocation {
    public float accuracy;
    public double latitude;
    public double longitude;

    public WMLocation() {
        this.latitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.longitude = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.accuracy = 0.0f;
    }

    public WMLocation(double d, double d2) {
        this.accuracy = 0.0f;
        this.latitude = d;
        this.longitude = d2;
    }

    public WMLocation(double d, double d2, float f) {
        this.latitude = d;
        this.longitude = d2;
        this.accuracy = f;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setAccuracy(float f) {
        this.accuracy = f;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public String toString() {
        return dexg.dexa("XNMpdbujpo|mbujuvef>") + this.latitude + dexg.dexa("-!mpohjuvef>") + this.longitude + dexg.dexa("-!bddvsbdz>") + this.accuracy + '}';
    }
}
