package com.ipd.dsp.internal.w0;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f extends d {
    public final int c;

    public f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.c = i;
    }

    @Override // com.ipd.dsp.internal.w0.d
    public boolean a(File file, long j, int i) {
        return i <= this.c;
    }
}
