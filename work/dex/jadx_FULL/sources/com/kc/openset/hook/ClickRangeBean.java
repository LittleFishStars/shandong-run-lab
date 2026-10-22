package com.kc.openset.hook;

import androidx.camera.video.AudioStats;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ClickRangeBean {
    private double range = AudioStats.AUDIO_AMPLITUDE_NONE;
    private double rangeProbability = AudioStats.AUDIO_AMPLITUDE_NONE;

    static {
        OSETSDKProtected.interface11(4440);
    }

    public native double getRange();

    public native double getRangeProbability();

    public native void setRange(double d);

    public native void setRangeProbability(double d);

    public native String toString();
}
