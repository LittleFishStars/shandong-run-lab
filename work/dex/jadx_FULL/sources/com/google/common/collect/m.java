package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31987a = 1073741824;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f6207a = -862048943;
    public static final long b = 461845907;

    public static int a(int i, double d) {
        int iMax = Math.max(i, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax <= ((int) (d * ((double) iHighestOneBit)))) {
            return iHighestOneBit;
        }
        int i2 = iHighestOneBit << 1;
        if (i2 > 0) {
            return i2;
        }
        return 1073741824;
    }

    public static boolean b(int i, int i2, double d) {
        return ((double) i) > d * ((double) i2) && i2 < 1073741824;
    }

    public static int c(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * f6207a), 15)) * b);
    }

    public static int d(@CheckForNull Object obj) {
        return c(obj == null ? 0 : obj.hashCode());
    }
}
