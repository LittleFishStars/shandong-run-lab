package com.kc.aw.lib.model;

import androidx.camera.video.AudioStats;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AdLocation {
    private double mLatitude = AudioStats.AUDIO_AMPLITUDE_NONE;
    private double mLongitude = AudioStats.AUDIO_AMPLITUDE_NONE;

    public double getLatitude() {
        return this.mLatitude;
    }

    public double getLongitude() {
        return this.mLongitude;
    }

    public void setLatitude(double d) {
        this.mLatitude = d;
    }

    public void setLongitude(double d) {
        this.mLongitude = d;
    }
}
