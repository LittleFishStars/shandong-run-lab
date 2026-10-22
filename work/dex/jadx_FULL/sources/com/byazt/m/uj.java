package com.byazt.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 130, 15})
public class uj extends BaseException {
    public final long c;
    public final long tt;

    public uj(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.c = j;
        this.tt = j2;
    }

    public long c() {
        return this.c;
    }

    public long tt() {
        return this.tt;
    }
}
