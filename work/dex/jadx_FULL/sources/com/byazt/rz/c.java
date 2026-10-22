package com.byazt.rz;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1947, 20})
public class c {
    public int c;
    public int tt;

    public c(int i, int i2, long j) {
        if (i2 < i) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.c = i;
        this.tt = i2;
    }

    public static c ve() {
        return new c(1, 100, 172800000L);
    }

    public int c() {
        return this.c;
    }

    public int tt() {
        return this.tt;
    }

    public static c c(int i, int i2) {
        return new c(i, i2, 172800000L);
    }

    public static c c(int i, int i2, long j) {
        return new c(i, i2, j);
    }
}
