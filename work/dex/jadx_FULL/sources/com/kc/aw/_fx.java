package com.kc.aw;

import com.google.common.base.a;
import com.google.common.hash.Murmur3_128HashFunction;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _fx {
    public static long _a(int i, byte[] bArr) {
        return (((long) bArr[i + 7]) << 56) + (((long) (bArr[i + 6] & 255)) << 48) + (((long) (bArr[i + 5] & 255)) << 40) + (((long) (bArr[i + 4] & 255)) << 32) + (((long) (bArr[i + 3] & 255)) << 24) + ((long) ((bArr[i + 2] & 255) << 16)) + ((long) ((bArr[i + 1] & 255) << 8)) + ((long) (bArr[i] & 255));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static long[] _a(byte[] bArr) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        int length = bArr.length;
        int i = length & 15;
        long jRotateLeft = 3782874213L;
        long jRotateLeft2 = 3782874213L;
        int i2 = 0;
        while (i2 < length - i) {
            long j_a = _a(i2, bArr);
            long j_a2 = _a(i2 + 8, bArr);
            long j8 = jRotateLeft2;
            jRotateLeft = ((Long.rotateLeft(jRotateLeft ^ (Long.rotateLeft(j_a * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d), 27) + j8) * 5) + 1390208809;
            jRotateLeft2 = ((Long.rotateLeft(j8 ^ (Long.rotateLeft(Murmur3_128HashFunction.a.f6307d * j_a2, 33) * Murmur3_128HashFunction.a.c), 31) + jRotateLeft) * 5) + 944331445;
            i2 += 16;
        }
        long jRotateLeft3 = jRotateLeft2;
        long j9 = 0;
        switch (i) {
            case 1:
                j = jRotateLeft3;
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 2:
                j = jRotateLeft3;
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 3:
                j = jRotateLeft3;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 4:
                j = jRotateLeft3;
                j9 ^= ((long) bArr[i2 + 3]) << 24;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 5:
                j9 ^= ((long) bArr[i2 + 4]) << 32;
                j = jRotateLeft3;
                j9 ^= ((long) bArr[i2 + 3]) << 24;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 6:
                j9 ^= ((long) bArr[i2 + 5]) << 40;
                j9 ^= ((long) bArr[i2 + 4]) << 32;
                j = jRotateLeft3;
                j9 ^= ((long) bArr[i2 + 3]) << 24;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 7:
                j9 ^= ((long) bArr[i2 + 6]) << 48;
                j9 ^= ((long) bArr[i2 + 5]) << 40;
                j9 ^= ((long) bArr[i2 + 4]) << 32;
                j = jRotateLeft3;
                j9 ^= ((long) bArr[i2 + 3]) << 24;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 8:
                j9 = (((long) bArr[i2 + 7]) << 56) ^ 0;
                j9 ^= ((long) bArr[i2 + 6]) << 48;
                j9 ^= ((long) bArr[i2 + 5]) << 40;
                j9 ^= ((long) bArr[i2 + 4]) << 32;
                j = jRotateLeft3;
                j9 ^= ((long) bArr[i2 + 3]) << 24;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 9:
                j2 = 0;
                jRotateLeft3 ^= Long.rotateLeft((j2 ^ ((long) bArr[i2 + 8])) * Murmur3_128HashFunction.a.f6307d, 33) * Murmur3_128HashFunction.a.c;
                j9 = (((long) bArr[i2 + 7]) << 56) ^ 0;
                j9 ^= ((long) bArr[i2 + 6]) << 48;
                j9 ^= ((long) bArr[i2 + 5]) << 40;
                j9 ^= ((long) bArr[i2 + 4]) << 32;
                j = jRotateLeft3;
                j9 ^= ((long) bArr[i2 + 3]) << 24;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 10:
                j3 = 0;
                j2 = j3 ^ ((long) (bArr[i2 + 9] << 8));
                jRotateLeft3 ^= Long.rotateLeft((j2 ^ ((long) bArr[i2 + 8])) * Murmur3_128HashFunction.a.f6307d, 33) * Murmur3_128HashFunction.a.c;
                j9 = (((long) bArr[i2 + 7]) << 56) ^ 0;
                j9 ^= ((long) bArr[i2 + 6]) << 48;
                j9 ^= ((long) bArr[i2 + 5]) << 40;
                j9 ^= ((long) bArr[i2 + 4]) << 32;
                j = jRotateLeft3;
                j9 ^= ((long) bArr[i2 + 3]) << 24;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 11:
                j4 = 0;
                j3 = j4 ^ ((long) (bArr[i2 + 10] << a.r));
                j2 = j3 ^ ((long) (bArr[i2 + 9] << 8));
                jRotateLeft3 ^= Long.rotateLeft((j2 ^ ((long) bArr[i2 + 8])) * Murmur3_128HashFunction.a.f6307d, 33) * Murmur3_128HashFunction.a.c;
                j9 = (((long) bArr[i2 + 7]) << 56) ^ 0;
                j9 ^= ((long) bArr[i2 + 6]) << 48;
                j9 ^= ((long) bArr[i2 + 5]) << 40;
                j9 ^= ((long) bArr[i2 + 4]) << 32;
                j = jRotateLeft3;
                j9 ^= ((long) bArr[i2 + 3]) << 24;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 12:
                j5 = 0;
                j4 = j5 ^ (((long) bArr[i2 + 11]) << 24);
                j3 = j4 ^ ((long) (bArr[i2 + 10] << a.r));
                j2 = j3 ^ ((long) (bArr[i2 + 9] << 8));
                jRotateLeft3 ^= Long.rotateLeft((j2 ^ ((long) bArr[i2 + 8])) * Murmur3_128HashFunction.a.f6307d, 33) * Murmur3_128HashFunction.a.c;
                j9 = (((long) bArr[i2 + 7]) << 56) ^ 0;
                j9 ^= ((long) bArr[i2 + 6]) << 48;
                j9 ^= ((long) bArr[i2 + 5]) << 40;
                j9 ^= ((long) bArr[i2 + 4]) << 32;
                j = jRotateLeft3;
                j9 ^= ((long) bArr[i2 + 3]) << 24;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 13:
                j6 = 0;
                j5 = j6 ^ (((long) bArr[i2 + 12]) << 32);
                j4 = j5 ^ (((long) bArr[i2 + 11]) << 24);
                j3 = j4 ^ ((long) (bArr[i2 + 10] << a.r));
                j2 = j3 ^ ((long) (bArr[i2 + 9] << 8));
                jRotateLeft3 ^= Long.rotateLeft((j2 ^ ((long) bArr[i2 + 8])) * Murmur3_128HashFunction.a.f6307d, 33) * Murmur3_128HashFunction.a.c;
                j9 = (((long) bArr[i2 + 7]) << 56) ^ 0;
                j9 ^= ((long) bArr[i2 + 6]) << 48;
                j9 ^= ((long) bArr[i2 + 5]) << 40;
                j9 ^= ((long) bArr[i2 + 4]) << 32;
                j = jRotateLeft3;
                j9 ^= ((long) bArr[i2 + 3]) << 24;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 14:
                j7 = 0;
                j6 = j7 ^ (((long) bArr[i2 + 13]) << 40);
                j5 = j6 ^ (((long) bArr[i2 + 12]) << 32);
                j4 = j5 ^ (((long) bArr[i2 + 11]) << 24);
                j3 = j4 ^ ((long) (bArr[i2 + 10] << a.r));
                j2 = j3 ^ ((long) (bArr[i2 + 9] << 8));
                jRotateLeft3 ^= Long.rotateLeft((j2 ^ ((long) bArr[i2 + 8])) * Murmur3_128HashFunction.a.f6307d, 33) * Murmur3_128HashFunction.a.c;
                j9 = (((long) bArr[i2 + 7]) << 56) ^ 0;
                j9 ^= ((long) bArr[i2 + 6]) << 48;
                j9 ^= ((long) bArr[i2 + 5]) << 40;
                j9 ^= ((long) bArr[i2 + 4]) << 32;
                j = jRotateLeft3;
                j9 ^= ((long) bArr[i2 + 3]) << 24;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            case 15:
                j7 = (((long) bArr[i2 + 14]) << 48) ^ 0;
                j6 = j7 ^ (((long) bArr[i2 + 13]) << 40);
                j5 = j6 ^ (((long) bArr[i2 + 12]) << 32);
                j4 = j5 ^ (((long) bArr[i2 + 11]) << 24);
                j3 = j4 ^ ((long) (bArr[i2 + 10] << a.r));
                j2 = j3 ^ ((long) (bArr[i2 + 9] << 8));
                jRotateLeft3 ^= Long.rotateLeft((j2 ^ ((long) bArr[i2 + 8])) * Murmur3_128HashFunction.a.f6307d, 33) * Murmur3_128HashFunction.a.c;
                j9 = (((long) bArr[i2 + 7]) << 56) ^ 0;
                j9 ^= ((long) bArr[i2 + 6]) << 48;
                j9 ^= ((long) bArr[i2 + 5]) << 40;
                j9 ^= ((long) bArr[i2 + 4]) << 32;
                j = jRotateLeft3;
                j9 ^= ((long) bArr[i2 + 3]) << 24;
                j9 ^= (long) (bArr[i2 + 2] << a.r);
                j9 ^= (long) (bArr[i2 + 1] << 8);
                jRotateLeft ^= Long.rotateLeft((j9 ^ ((long) bArr[i2])) * Murmur3_128HashFunction.a.c, 31) * Murmur3_128HashFunction.a.f6307d;
                break;
            default:
                j = jRotateLeft3;
                break;
        }
        long j10 = length;
        long j11 = j10 ^ j;
        long j12 = (j10 ^ jRotateLeft) + j11;
        long j13 = j11 + j12;
        long j14 = (j12 ^ (j12 >>> 33)) * (-49064778989728563L);
        long j15 = (j14 ^ (j14 >>> 33)) * (-4265267296055464877L);
        long j16 = (j13 ^ (j13 >>> 33)) * (-49064778989728563L);
        long j17 = ((j16 >>> 33) ^ j16) * (-4265267296055464877L);
        long j18 = j17 ^ (j17 >>> 33);
        long j19 = (j15 ^ (j15 >>> 33)) + j18;
        return new long[]{j19, j18 + j19};
    }
}
