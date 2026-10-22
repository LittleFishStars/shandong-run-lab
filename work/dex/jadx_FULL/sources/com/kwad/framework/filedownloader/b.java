package com.kwad.framework.filedownloader;

import android.os.SystemClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b implements s.a, s.b {
    private long ayR;
    private long ayS;
    private long ayT;
    private int ayU;
    private int ayV = 1000;
    private long mStartTime;

    @Override // com.kwad.framework.filedownloader.s.b
    public final void aa(long j) {
        if (this.ayV <= 0) {
            return;
        }
        boolean z = true;
        if (this.ayR != 0) {
            long jUptimeMillis = SystemClock.uptimeMillis() - this.ayR;
            if (jUptimeMillis >= this.ayV || (this.ayU == 0 && jUptimeMillis > 0)) {
                int i = (int) ((j - this.ayS) / jUptimeMillis);
                this.ayU = i;
                this.ayU = Math.max(0, i);
            } else {
                z = false;
            }
        }
        if (z) {
            this.ayS = j;
            this.ayR = SystemClock.uptimeMillis();
        }
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void end(long j) {
        if (this.mStartTime <= 0) {
            return;
        }
        long j2 = j - this.ayT;
        this.ayR = 0L;
        long jUptimeMillis = SystemClock.uptimeMillis() - this.mStartTime;
        if (jUptimeMillis <= 0) {
            this.ayU = (int) j2;
        } else {
            this.ayU = (int) (j2 / jUptimeMillis);
        }
    }

    @Override // com.kwad.framework.filedownloader.s.a
    public final int getSpeed() {
        return this.ayU;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void reset() {
        this.ayU = 0;
        this.ayR = 0L;
    }

    @Override // com.kwad.framework.filedownloader.s.b
    public final void start(long j) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.ayT = j;
    }
}
