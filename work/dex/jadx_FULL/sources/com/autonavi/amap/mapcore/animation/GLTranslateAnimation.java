package com.autonavi.amap.mapcore.animation;

import androidx.camera.video.AudioStats;
import com.amap.api.maps.model.LatLng;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GLTranslateAnimation extends GLAnimation {
    public double mToXDelta;
    public double mToYDelta;
    public double mFromXDelta = AudioStats.AUDIO_AMPLITUDE_NONE;
    public double mFromYDelta = AudioStats.AUDIO_AMPLITUDE_NONE;
    public double mCurXDelta = AudioStats.AUDIO_AMPLITUDE_NONE;
    public double mCurYDelta = AudioStats.AUDIO_AMPLITUDE_NONE;

    public GLTranslateAnimation(LatLng latLng) {
        this.mToXDelta = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mToYDelta = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mToXDelta = latLng.longitude;
        this.mToYDelta = latLng.latitude;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f, GLTransformation gLTransformation) {
        double d = this.mFromXDelta;
        this.mCurXDelta = d;
        double d2 = this.mFromYDelta;
        this.mCurYDelta = d2;
        double d3 = this.mToXDelta;
        if (d != d3) {
            this.mCurXDelta = d + ((d3 - d) * ((double) f));
        }
        double d4 = this.mToYDelta;
        if (d2 != d4) {
            this.mCurYDelta = d2 + ((d4 - d2) * ((double) f));
        }
        gLTransformation.x = this.mCurXDelta;
        gLTransformation.y = this.mCurYDelta;
    }

    public void setFromPoint(LatLng latLng) {
        this.mFromXDelta = latLng.longitude;
        this.mFromYDelta = latLng.latitude;
    }
}
