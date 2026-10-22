package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class md9 {
    public static int a(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static boolean b(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        for (int i5 = -4; i5 <= 4; i5++) {
            int i6 = (i5 * 188) + i3;
            if (i6 < i || i6 >= i2 || bArr[i6] != 71) {
                i4 = 0;
            } else {
                i4++;
                if (i4 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long c(om6 om6Var, int i, int i2) {
        om6Var.S(i);
        if (om6Var.a() < 5) {
            return -9223372036854775807L;
        }
        int iO = om6Var.o();
        if ((8388608 & iO) != 0 || ((2096896 & iO) >> 8) != i2) {
            return -9223372036854775807L;
        }
        if (((iO & 32) != 0) && om6Var.G() >= 7 && om6Var.a() >= 7) {
            if ((om6Var.G() & 16) == 16) {
                byte[] bArr = new byte[6];
                om6Var.k(bArr, 0, 6);
                return d(bArr);
            }
        }
        return -9223372036854775807L;
    }

    public static long d(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
