package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f31970a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f6202a = 5;
    public static final int b = 32;
    public static final int c = 31;
    public static final int d = 1073741823;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 256;
    public static final int h = 255;
    public static final int i = 65536;
    public static final int j = 65535;

    public static Object a(int i2) {
        if (i2 >= 2 && i2 <= 1073741824 && Integer.highestOneBit(i2) == i2) {
            if (i2 <= 256) {
                return new byte[i2];
            }
            return i2 <= 65536 ? new short[i2] : new int[i2];
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("must be power of 2 between 2^1 and 2^30: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int b(int i2, int i3) {
        return i2 & (~i3);
    }

    public static int c(int i2, int i3) {
        return i2 & i3;
    }

    public static int d(int i2, int i3, int i4) {
        return (i2 & (~i4)) | (i3 & i4);
    }

    public static int e(int i2) {
        return (i2 < 32 ? 4 : 2) * (i2 + 1);
    }

    public static int f(@CheckForNull Object obj, @CheckForNull Object obj2, int i2, Object obj3, int[] iArr, Object[] objArr, @CheckForNull Object[] objArr2) {
        int iD = m.d(obj);
        int i3 = iD & i2;
        int iH = h(obj3, i3);
        if (iH == 0) {
            return -1;
        }
        int iB = b(iD, i2);
        int i4 = -1;
        while (true) {
            int i5 = iH - 1;
            int i6 = iArr[i5];
            if (b(i6, i2) == iB && com.google.common.base.g.a(obj, objArr[i5]) && (objArr2 == null || com.google.common.base.g.a(obj2, objArr2[i5]))) {
                int iC = c(i6, i2);
                if (i4 == -1) {
                    i(obj3, i3, iC);
                } else {
                    iArr[i4] = d(iArr[i4], iC, i2);
                }
                return i5;
            }
            int iC2 = c(i6, i2);
            if (iC2 == 0) {
                return -1;
            }
            i4 = i5;
            iH = iC2;
        }
    }

    public static void g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    public static int h(Object obj, int i2) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i2] & 255;
        }
        return obj instanceof short[] ? ((short[]) obj)[i2] & 65535 : ((int[]) obj)[i2];
    }

    public static void i(Object obj, int i2, int i3) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i2] = (byte) i3;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i2] = (short) i3;
        } else {
            ((int[]) obj)[i2] = i3;
        }
    }

    public static int j(int i2) {
        return Math.max(4, m.a(i2 + 1, 1.0d));
    }
}
