package com.byazt.ie;

import com.byazt.c.nu;
import com.byazt.c.rh;
import com.byazt.gq.t;
import com.byazt.hu.sl;
import com.byazt.hu.u;
import com.byazt.nr.m;
import com.byazt.t.DownloadInfo;
import com.byazt.zz.Downloader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1041, 20})
public class c implements rh {
    public int c;

    private long tt(com.byazt.k.c cVar) {
        long jC = cVar.c("clear_space_sleep_time", 0L);
        if (jC <= 0) {
            return 0L;
        }
        if (jC > 5000) {
            jC = 5000;
        }
        sl.tt("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = ".concat(String.valueOf(jC)), null);
        try {
            Thread.sleep(jC);
        } catch (InterruptedException e) {
            m.c(e);
        }
        sl.tt("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return jC;
    }

    public void c(int i) {
        this.c = i;
    }

    @Override // com.byazt.c.rh
    public boolean c(long j, long j2, nu nuVar) throws Throwable {
        long j3;
        com.byazt.k.c cVarC = com.byazt.k.c.c(this.c);
        if (!c(cVarC)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        uj.c().ve();
        long jTt = u.tt(0L);
        c();
        long jTt2 = u.tt(0L);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jTt2 < j2) {
            long jTt3 = tt(cVarC);
            if (jTt3 > 0) {
                jTt2 = u.tt(0L);
            }
            j3 = jTt3;
        } else {
            j3 = 0;
        }
        sl.tt("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + jTt2 + ", cleaned = " + (jTt2 - jTt), null);
        long j4 = jTt2;
        c(jTt, jTt2, j2, jCurrentTimeMillis2, j3);
        if (j4 < j2) {
            return false;
        }
        if (nuVar == null) {
            return true;
        }
        nuVar.c();
        return true;
    }

    private boolean c(com.byazt.k.c cVar) {
        if (cVar.c("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - uj.c().tt() >= cVar.c("clear_space_min_time_interval", 600000L);
    }

    private void c() throws Throwable {
        t.m();
        ve.c();
        ve.tt();
    }

    private void c(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo downloadInfo = Downloader.getInstance(t.getContext()).getDownloadInfo(this.c);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.byazt.di.c.c().c(downloadInfo, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception e) {
            m.c(e);
        }
    }
}
