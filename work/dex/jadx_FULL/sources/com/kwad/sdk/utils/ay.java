package com.kwad.sdk.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ay {
    private static volatile ay bpT = new ay();
    private volatile boolean bpU;
    private volatile long bpV = 0;
    private volatile PowerManager bpW;

    public static ay VX() {
        return bpT;
    }

    public final boolean dL(Context context) {
        if (this.bpV > 0 && SystemClock.elapsedRealtime() - this.bpV < 600) {
            return this.bpU;
        }
        if (this.bpW == null && context != null) {
            synchronized (this) {
                if (this.bpW == null) {
                    this.bpW = (PowerManager) context.getApplicationContext().getSystemService("power");
                }
            }
        }
        this.bpU = this.bpW != null ? this.bpW.isInteractive() : false;
        this.bpV = SystemClock.elapsedRealtime();
        return this.bpU;
    }
}
