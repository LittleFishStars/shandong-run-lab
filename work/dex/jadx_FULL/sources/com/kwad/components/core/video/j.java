package com.kwad.components.core.video;

import android.os.SystemClock;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class j {
    private volatile boolean anQ;
    private long anR;
    private a anS = new a();

    public static class a {
        private long anT = 0;
        private int anU = 0;

        public final void accumulate(long j) {
            this.anT += j;
            this.anU++;
        }

        public final void reset() {
            this.anT = 0L;
            this.anU = 0;
        }

        public final int xV() {
            return this.anU;
        }

        public final long xW() {
            return this.anT;
        }
    }

    public final void reset() {
        this.anQ = false;
        this.anR = 0L;
        this.anS.reset();
    }

    public final void xQ() {
        if (this.anQ) {
            return;
        }
        this.anQ = true;
        this.anR = SystemClock.elapsedRealtime();
        com.kwad.sdk.core.video.a.a.a.fs("videoStartBlock");
    }

    public final void xR() {
        if (this.anQ) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.anR;
            this.anS.accumulate(jElapsedRealtime);
            this.anQ = false;
            com.kwad.sdk.core.video.a.a.a.fs("videoEndBlock");
            com.kwad.sdk.core.video.a.a.a.fs("videoBlockTime_" + jElapsedRealtime);
        }
    }

    public final boolean xS() {
        return this.anQ;
    }

    @NonNull
    public final a xT() {
        if (this.anQ) {
            this.anS.accumulate(SystemClock.elapsedRealtime() - this.anR);
            this.anQ = false;
        }
        return this.anS;
    }

    public final long xU() {
        return this.anR;
    }
}
