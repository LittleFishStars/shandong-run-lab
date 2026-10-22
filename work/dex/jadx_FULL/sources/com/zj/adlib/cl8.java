package com.zj.adlib;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class cl8 {
    public static final int b = 1024;
    public static final int c = 440786851;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final om6 f15853a = new om6(8);

    public final long a(ExtractorInput extractorInput) throws IOException {
        int i = 0;
        extractorInput.peekFully(this.f15853a.d(), 0, 1);
        int i2 = this.f15853a.d()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        extractorInput.peekFully(this.f15853a.d(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.f15853a.d()[i] & 255) + (i5 << 8);
        }
        this.f40992a += i4 + 1;
        return i5;
    }

    public boolean b(ExtractorInput extractorInput) throws IOException {
        long length = extractorInput.getLength();
        long j = 1024;
        if (length != -1 && length <= 1024) {
            j = length;
        }
        int i = (int) j;
        extractorInput.peekFully(this.f15853a.d(), 0, 4);
        long jI = this.f15853a.I();
        this.f40992a = 4;
        while (jI != 440786851) {
            int i2 = this.f40992a + 1;
            this.f40992a = i2;
            if (i2 == i) {
                return false;
            }
            extractorInput.peekFully(this.f15853a.d(), 0, 1);
            jI = ((jI << 8) & (-256)) | ((long) (this.f15853a.d()[0] & 255));
        }
        long jA = a(extractorInput);
        long j2 = this.f40992a;
        if (jA == Long.MIN_VALUE) {
            return false;
        }
        if (length != -1 && j2 + jA >= length) {
            return false;
        }
        while (true) {
            int i3 = this.f40992a;
            long j3 = j2 + jA;
            if (i3 >= j3) {
                return ((long) i3) == j3;
            }
            if (a(extractorInput) == Long.MIN_VALUE) {
                return false;
            }
            long jA2 = a(extractorInput);
            if (jA2 < 0 || jA2 > 2147483647L) {
                return false;
            }
            if (jA2 != 0) {
                int i4 = (int) jA2;
                extractorInput.advancePeekPosition(i4);
                this.f40992a += i4;
            }
        }
    }
}
