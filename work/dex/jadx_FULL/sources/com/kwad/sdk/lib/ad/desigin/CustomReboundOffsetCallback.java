package com.kwad.sdk.lib.ad.desigin;

import androidx.annotation.FloatRange;
import androidx.annotation.Keep;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface CustomReboundOffsetCallback {
    public static final int REBOUND_TYPE_FLING = 2;
    public static final int REBOUND_TYPE_TOUCH = 1;

    void rebound(int i, @FloatRange(from = AudioStats.AUDIO_AMPLITUDE_NONE, to = 1.0d) float f, int i2);
}
