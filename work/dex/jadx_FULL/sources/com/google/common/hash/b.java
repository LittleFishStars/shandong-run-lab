package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class b extends AbstractNonStreamingHashFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f32141a = -4348849565147123417L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final HashFunction f6317a = new b();
    public static final long b = -5435081209227447693L;
    public static final long c = -7286425919675154353L;

    @VisibleForTesting
    public static long a(byte[] bArr, int i, int i2) {
        if (i2 <= 32) {
            return i2 <= 16 ? b(bArr, i, i2) : d(bArr, i, i2);
        }
        return i2 <= 64 ? e(bArr, i, i2) : f(bArr, i, i2);
    }

    public static long b(byte[] bArr, int i, int i2) {
        if (i2 >= 8) {
            long j = ((long) (i2 * 2)) + c;
            long jB = LittleEndianByteArray.b(bArr, i) + c;
            long jB2 = LittleEndianByteArray.b(bArr, (i + i2) - 8);
            return c((Long.rotateRight(jB2, 37) * j) + jB, (Long.rotateRight(jB, 25) + jB2) * j, j);
        }
        if (i2 >= 4) {
            return c(((long) i2) + ((((long) LittleEndianByteArray.a(bArr, i)) & 4294967295L) << 3), ((long) LittleEndianByteArray.a(bArr, (i + i2) - 4)) & 4294967295L, ((long) (i2 * 2)) + c);
        }
        if (i2 <= 0) {
            return c;
        }
        return g((((long) ((bArr[i] & 255) + ((bArr[(i2 >> 1) + i] & 255) << 8))) * c) ^ (((long) (i2 + ((bArr[i + (i2 - 1)] & 255) << 2))) * f32141a)) * c;
    }

    public static long c(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    public static long d(byte[] bArr, int i, int i2) {
        long j = ((long) (i2 * 2)) + c;
        long jB = LittleEndianByteArray.b(bArr, i) * b;
        long jB2 = LittleEndianByteArray.b(bArr, i + 8);
        int i3 = i + i2;
        long jB3 = LittleEndianByteArray.b(bArr, i3 - 8) * j;
        return c((LittleEndianByteArray.b(bArr, i3 - 16) * c) + Long.rotateRight(jB + jB2, 43) + Long.rotateRight(jB3, 30), jB + Long.rotateRight(jB2 + c, 18) + jB3, j);
    }

    public static long e(byte[] bArr, int i, int i2) {
        long j = ((long) (i2 * 2)) + c;
        long jB = LittleEndianByteArray.b(bArr, i) * c;
        long jB2 = LittleEndianByteArray.b(bArr, i + 8);
        int i3 = i + i2;
        long jB3 = LittleEndianByteArray.b(bArr, i3 - 8) * j;
        long jRotateRight = Long.rotateRight(jB + jB2, 43) + Long.rotateRight(jB3, 30) + (LittleEndianByteArray.b(bArr, i3 - 16) * c);
        long jC = c(jRotateRight, jB3 + Long.rotateRight(jB2 + c, 18) + jB, j);
        long jB4 = LittleEndianByteArray.b(bArr, i + 16) * j;
        long jB5 = LittleEndianByteArray.b(bArr, i + 24);
        long jB6 = (jRotateRight + LittleEndianByteArray.b(bArr, i3 - 32)) * j;
        return c(((jC + LittleEndianByteArray.b(bArr, i3 - 24)) * j) + Long.rotateRight(jB4 + jB5, 43) + Long.rotateRight(jB6, 30), jB4 + Long.rotateRight(jB5 + jB, 18) + jB6, j);
    }

    public static long f(byte[] bArr, int i, int i2) {
        long jG = g(-7956866745689871395L) * c;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long jB = 95310865018149119L + LittleEndianByteArray.b(bArr, i);
        int i3 = i2 - 1;
        int i4 = i + ((i3 / 64) * 64);
        int i5 = i3 & 63;
        int i6 = (i4 + i5) - 63;
        long j = 2480279821605975764L;
        int i7 = i;
        while (true) {
            long jRotateRight = Long.rotateRight(jB + j + jArr[0] + LittleEndianByteArray.b(bArr, i7 + 8), 37) * b;
            long jRotateRight2 = Long.rotateRight(j + jArr[1] + LittleEndianByteArray.b(bArr, i7 + 48), 42) * b;
            long j2 = jRotateRight ^ jArr2[1];
            long jB2 = jRotateRight2 + jArr[0] + LittleEndianByteArray.b(bArr, i7 + 40);
            long jRotateRight3 = Long.rotateRight(jG + jArr2[0], 33) * b;
            h(bArr, i7, jArr[1] * b, j2 + jArr2[0], jArr);
            h(bArr, i7 + 32, jRotateRight3 + jArr2[1], jB2 + LittleEndianByteArray.b(bArr, i7 + 16), jArr2);
            i7 += 64;
            if (i7 == i4) {
                long j3 = ((j2 & 255) << 1) + b;
                long j4 = jArr2[0] + ((long) i5);
                jArr2[0] = j4;
                long j5 = jArr[0] + j4;
                jArr[0] = j5;
                jArr2[0] = jArr2[0] + j5;
                long jRotateRight4 = Long.rotateRight(jRotateRight3 + jB2 + jArr[0] + LittleEndianByteArray.b(bArr, i6 + 8), 37) * j3;
                long jRotateRight5 = Long.rotateRight(jB2 + jArr[1] + LittleEndianByteArray.b(bArr, i6 + 48), 42) * j3;
                long j6 = jRotateRight4 ^ (jArr2[1] * 9);
                long jB3 = jRotateRight5 + (jArr[0] * 9) + LittleEndianByteArray.b(bArr, i6 + 40);
                long jRotateRight6 = Long.rotateRight(j2 + jArr2[0], 33) * j3;
                h(bArr, i6, jArr[1] * j3, j6 + jArr2[0], jArr);
                h(bArr, i6 + 32, jRotateRight6 + jArr2[1], LittleEndianByteArray.b(bArr, i6 + 16) + jB3, jArr2);
                return c(c(jArr[0], jArr2[0], j3) + (g(jB3) * f32141a) + j6, c(jArr[1], jArr2[1], j3) + jRotateRight6, j3);
            }
            jG = j2;
            j = jB2;
            jB = jRotateRight3;
        }
    }

    public static long g(long j) {
        return j ^ (j >>> 47);
    }

    public static void h(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long jB = LittleEndianByteArray.b(bArr, i);
        long jB2 = LittleEndianByteArray.b(bArr, i + 8);
        long jB3 = LittleEndianByteArray.b(bArr, i + 16);
        long jB4 = LittleEndianByteArray.b(bArr, i + 24);
        long j3 = j + jB;
        long j4 = jB2 + j3 + jB3;
        long jRotateRight = Long.rotateRight(j2 + j3 + jB4, 21) + Long.rotateRight(j4, 44);
        jArr[0] = j4 + jB4;
        jArr[1] = jRotateRight + j3;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        i.f0(i, i + i2, bArr.length);
        return HashCode.fromLong(a(bArr, i, i2));
    }

    public String toString() {
        return "Hashing.farmHashFingerprint64()";
    }
}
