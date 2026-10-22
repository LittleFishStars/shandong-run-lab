package com.hailiang.advlib.core;

import androidx.camera.video.AudioStats;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class QLocation implements IQLocation {
    private double lat;
    private double lot;
    private int type;

    public QLocation() {
        this.lat = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.lot = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.type = 0;
    }

    public QLocation(double d, double d2, int i) {
        this.lat = d;
        this.lot = d2;
        this.type = i;
    }

    @Override // com.hailiang.advlib.core.IQLocation
    public double getLatitude() {
        return this.lat;
    }

    @Override // com.hailiang.advlib.core.IQLocation
    public double getLongitude() {
        return this.lot;
    }

    @Override // com.hailiang.advlib.core.IQLocation
    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
