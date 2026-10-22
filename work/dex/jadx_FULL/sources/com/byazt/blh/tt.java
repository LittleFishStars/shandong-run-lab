package com.byazt.blh;

import com.bytedance.pangle.log.ZeusLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1729, 13})
public class tt {
    public String c;
    public long n;
    public String tt;
    public long uj;
    public String ve;

    private tt(String str, String str2, String str3) {
        this.c = str;
        this.tt = str2;
        this.ve = str3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.n = jCurrentTimeMillis;
        this.uj = jCurrentTimeMillis;
        ZeusLogger.i(this.c, this.tt + String.format(" watcher[%s]-start", str3));
    }

    public static tt c(String str, String str2, String str3) {
        return new tt(str, str2, str3);
    }

    public long c(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.n;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.uj;
        ZeusLogger.i(this.c, this.tt + String.format(" watcher[%s]-%s cost=%s, total=%s", this.ve, str, Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis2)));
        return jCurrentTimeMillis2;
    }

    public long c() {
        return System.currentTimeMillis() - this.uj;
    }
}
