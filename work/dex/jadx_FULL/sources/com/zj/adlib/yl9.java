package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class yl9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f46061a = {128, 64, 32, 16, 8, 4, 2, 1};
    public static final int c = 0;
    public static final int d = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f20881a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f20882a = new byte[8];
    public int b;

    public static long a(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= ~f46061a[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }

    public static int c(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = f46061a;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public int b() {
        return this.b;
    }

    public long d(ExtractorInput extractorInput, boolean z, boolean z2, int i) throws IOException {
        if (this.f20881a == 0) {
            if (!extractorInput.readFully(this.f20882a, 0, 1, z)) {
                return -1L;
            }
            int iC = c(this.f20882a[0] & 255);
            this.b = iC;
            if (iC == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f20881a = 1;
        }
        int i2 = this.b;
        if (i2 > i) {
            this.f20881a = 0;
            return -2L;
        }
        if (i2 != 1) {
            extractorInput.readFully(this.f20882a, 1, i2 - 1);
        }
        this.f20881a = 0;
        return a(this.f20882a, this.b, z2);
    }

    public void e() {
        this.f20881a = 0;
        this.b = 0;
    }
}
