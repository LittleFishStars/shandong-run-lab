package com.googlecode.mp4parser.authoring;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class Edit {
    private double mediaRate;
    private long mediaTime;
    private double segmentDuration;
    private long timeScale;

    public Edit(long j, long j2, double d, double d2) {
        this.timeScale = j2;
        this.segmentDuration = d2;
        this.mediaTime = j;
        this.mediaRate = d;
    }

    public double getMediaRate() {
        return this.mediaRate;
    }

    public long getMediaTime() {
        return this.mediaTime;
    }

    public double getSegmentDuration() {
        return this.segmentDuration;
    }

    public long getTimeScale() {
        return this.timeScale;
    }
}
