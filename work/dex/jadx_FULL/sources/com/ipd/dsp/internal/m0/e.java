package com.ipd.dsp.internal.m0;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e extends IOException {
    public final long f;
    public final long g;

    public e(long j, long j2) {
        super("There is Free space less than Require space: " + j2 + " < " + j);
        this.f = j;
        this.g = j2;
    }

    public long a() {
        return this.g;
    }

    public long b() {
        return this.f;
    }
}
