package com.byazt.gq;

import com.byazt.e.DownloadShortInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 52, 72})
public class da {
    public static int c(int i, int i2) {
        return (i2 <= 0 || i2 >= 100 || !c(i)) ? i2 : (int) (Math.sqrt(i2) * 10.0d);
    }

    public static long c(int i, long j, long j2) {
        if (!c(i)) {
            return j;
        }
        if (j <= 0) {
            return 0L;
        }
        return j2 <= 0 ? j : (j2 * ((long) c(i, (int) ((j * 100) / j2)))) / 100;
    }

    public static DownloadShortInfo c(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && c((int) downloadShortInfo.id)) {
            downloadShortInfo.currentBytes = c((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean c(int i) {
        return com.byazt.k.c.c(i).c("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.byazt.k.c.c(i).c("pause_optimise_switch", 0) == 1;
    }
}
