package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.BitSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public final class j extends CharMatcher.NamedFastMatcher {
    public static final int L = 1023;
    public static final int M = -862048943;
    public static final int N = 461845907;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f31603a = 0.5d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f5951a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5952a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final char[] f5953a;

    public j(char[] cArr, long j, boolean z, String str) {
        super(str);
        this.f5953a = cArr;
        this.f5951a = j;
        this.f5952a = z;
    }

    @VisibleForTesting
    public static int Z(int i) {
        if (i == 1) {
            return 2;
        }
        int iHighestOneBit = Integer.highestOneBit(i - 1) << 1;
        while (((double) iHighestOneBit) * 0.5d < i) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static CharMatcher a0(BitSet bitSet, String str) {
        int i;
        int iCardinality = bitSet.cardinality();
        boolean z = bitSet.get(0);
        int iZ = Z(iCardinality);
        char[] cArr = new char[iZ];
        int i2 = iZ - 1;
        int iNextSetBit = bitSet.nextSetBit(0);
        long j = 0;
        while (iNextSetBit != -1) {
            long j2 = (1 << iNextSetBit) | j;
            int iB0 = b0(iNextSetBit);
            while (true) {
                i = iB0 & i2;
                if (cArr[i] == 0) {
                    break;
                }
                iB0 = i + 1;
            }
            cArr[i] = (char) iNextSetBit;
            iNextSetBit = bitSet.nextSetBit(iNextSetBit + 1);
            j = j2;
        }
        return new j(cArr, j, z, str);
    }

    public static int b0(int i) {
        return Integer.rotateLeft(i * M, 15) * N;
    }

    @Override // com.google.common.base.CharMatcher
    public boolean B(char c) {
        if (c == 0) {
            return this.f5952a;
        }
        if (!Y(c)) {
            return false;
        }
        int length = this.f5953a.length - 1;
        int iB0 = b0(c) & length;
        int i = iB0;
        do {
            char c2 = this.f5953a[i];
            if (c2 == 0) {
                return false;
            }
            if (c2 == c) {
                return true;
            }
            i = (i + 1) & length;
        } while (i != iB0);
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    public void Q(BitSet bitSet) {
        if (this.f5952a) {
            bitSet.set(0);
        }
        for (char c : this.f5953a) {
            if (c != 0) {
                bitSet.set(c);
            }
        }
    }

    public final boolean Y(int i) {
        return 1 == ((this.f5951a >> i) & 1);
    }
}
