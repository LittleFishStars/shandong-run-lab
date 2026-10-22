package com.googlecode.mp4parser.util;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class Math {
    public static long gcd(long j, long j2) {
        while (true) {
            long j3 = j;
            j = j2;
            if (j <= 0) {
                return j3;
            }
            j2 = j3 % j;
        }
    }

    public static long lcm(long j, long j2) {
        return j * (j2 / gcd(j, j2));
    }

    public static int gcd(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i <= 0) {
                return i4;
            }
            i2 = i4 % i;
        }
    }

    public static long lcm(long[] jArr) {
        long jLcm = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            jLcm = lcm(jLcm, jArr[i]);
        }
        return jLcm;
    }

    public static int lcm(int i, int i2) {
        return i * (i2 / gcd(i, i2));
    }
}
