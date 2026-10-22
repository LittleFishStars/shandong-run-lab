package com.google.android.exoplayer2;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface LivePlaybackSpeedControl {
    void a(g.C0682g c0682g);

    float getAdjustedPlaybackSpeed(long j, long j2);

    long getTargetLiveOffsetUs();

    void notifyRebuffer();

    void setTargetLiveOffsetOverrideUs(long j);
}
