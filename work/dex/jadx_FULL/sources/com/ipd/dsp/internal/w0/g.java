package com.ipd.dsp.internal.w0;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g extends d {
    public final long c;

    public g(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.c = j;
    }

    @Override // com.ipd.dsp.internal.w0.d
    public boolean a(File file, long j, int i) {
        return j <= this.c;
    }
}
