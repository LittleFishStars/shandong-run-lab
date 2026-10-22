package com.zj.adlib;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.oned.UPCEANReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class hf9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f42118a = {1, 1, 2};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ff9 f16981a = new ff9();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final gf9 f16982a = new gf9();

    public ug7 a(int i, qv0 qv0Var, int i2) throws NotFoundException {
        int[] iArrH = UPCEANReader.h(qv0Var, i2, false, f42118a);
        try {
            return this.f16982a.b(i, qv0Var, iArrH);
        } catch (ReaderException unused) {
            return this.f16981a.b(i, qv0Var, iArrH);
        }
    }
}
