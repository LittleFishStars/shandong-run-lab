package com.fl.saas;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class d1 extends AbstractC1410g0 {
    private final long b;

    public d1(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("Max size must be positive number!");
        }
        this.b = j;
    }

    @Override // com.fl.saas.AbstractC1410g0
    public boolean a(File file, long j, int i) {
        return j <= this.b;
    }
}
