package com.byazt.zb;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 184, 13})
public class tt {
    public x tt;
    public int uj;
    public ScheduledExecutorService c = null;
    public long ve = 0;

    public tt(x xVar, int i) {
        this.tt = xVar;
        this.uj = i;
    }

    public void c(long j) {
        this.ve = j;
    }

    public boolean tt() {
        ScheduledExecutorService scheduledExecutorService = this.c;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }

    public void c(int i) {
        ScheduledExecutorService scheduledExecutorServiceC = com.byazt.bwm.tt.c(1, new com.byazt.bwm.x("/CrashMonitor"));
        this.c = scheduledExecutorServiceC;
        scheduledExecutorServiceC.scheduleAtFixedRate(new Runnable() { // from class: com.byazt.zb.tt.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (System.currentTimeMillis() - tt.this.ve > tt.this.uj) {
                    tt.this.c.shutdown();
                    if (tt.this.tt != null) {
                        tt.this.tt.tt(0, "自动检测卡死");
                    }
                }
            }
        }, 0L, i, TimeUnit.MILLISECONDS);
    }

    public void c() {
        ScheduledExecutorService scheduledExecutorService = this.c;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }
}
