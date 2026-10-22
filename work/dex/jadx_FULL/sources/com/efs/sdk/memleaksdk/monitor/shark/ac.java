package com.efs.sdk.memleaksdk.monitor.shark;

import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ac extends ae {
    private float b = 0.0f;
    private int c = 0;

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public boolean b() {
        float f = ah.i.e;
        if (f <= a().getHeapThreshold() || f < this.b - 0.05f) {
            c();
        } else {
            int i = this.c + 1;
            this.c = i;
            Locale locale = Locale.US;
            ai aiVar = ai.f29650a;
            g.c("UMonitor.Heap", String.format(locale, "match overThresholdCount: %d, heapRatio: %f, used: %fMB, max: %fMB", Integer.valueOf(i), Float.valueOf(f), Float.valueOf(aiVar.b(ah.i.d)), Float.valueOf(aiVar.b(ah.i.f29647a))));
        }
        this.b = f;
        return this.c >= a().getMaxOverThresholdCount();
    }

    public void c() {
        this.b = 0.0f;
        this.c = 0;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.ae
    public String d() {
        return "reason_heap_memory";
    }
}
