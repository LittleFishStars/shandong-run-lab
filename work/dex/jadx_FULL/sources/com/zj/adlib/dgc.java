package com.zj.adlib;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class dgc {
    public static int a(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    public static int b(@CheckForNull Object obj, @CheckForNull Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, @CheckForNull Object[] objArr2) {
        int iA = ggc.a(obj);
        int i2 = iA & i;
        int iC = c(obj3, i2);
        if (iC != 0) {
            int i3 = ~i;
            int i4 = iA & i3;
            int i5 = -1;
            while (true) {
                int i6 = iC - 1;
                int i7 = iArr[i6];
                if ((i7 & i3) != i4 || !wac.a(obj, objArr[i6]) || (objArr2 != null && !wac.a(obj2, objArr2[i6]))) {
                    int i8 = i7 & i;
                    if (i8 == 0) {
                        break;
                    }
                    i5 = i6;
                    iC = i8;
                } else {
                    int i9 = i7 & i;
                    if (i5 == -1) {
                        e(obj3, i2, i9);
                    } else {
                        iArr[i5] = (i9 & i) | (iArr[i5] & i3);
                    }
                    return i6;
                }
            }
        }
        return -1;
    }

    public static int c(Object obj, int i) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & 255;
        }
        return obj instanceof short[] ? (char) ((short[]) obj)[i] : ((int[]) obj)[i];
    }

    public static Object d(int i) {
        if (i >= 2 && i <= 1073741824 && Integer.highestOneBit(i) == i) {
            if (i <= 256) {
                return new byte[i];
            }
            return i <= 65536 ? new short[i] : new int[i];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i);
    }

    public static void e(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }
}
