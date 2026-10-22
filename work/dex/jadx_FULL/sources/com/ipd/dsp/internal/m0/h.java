package com.ipd.dsp.internal.m0;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h extends IOException {
    public final int f;

    public h(int i, long j) {
        super("Response code can't handled on internal " + i + " with current offset " + j);
        this.f = i;
    }

    public int a() {
        return this.f;
    }
}
