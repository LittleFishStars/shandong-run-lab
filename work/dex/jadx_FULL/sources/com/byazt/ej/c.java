package com.byazt.ej;

import android.util.Pair;
import com.byazt.of.tt;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2427, 20})
public abstract class c {
    public static long c(ByteBuffer byteBuffer) {
        uj(byteBuffer);
        return tt(byteBuffer, byteBuffer.position() + 16);
    }

    private static int n(ByteBuffer byteBuffer) {
        uj(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i = iCapacity - 22;
        int iMin = Math.min(i, 65535);
        for (int i2 = 0; i2 <= iMin; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && c(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static long tt(ByteBuffer byteBuffer) {
        uj(byteBuffer);
        return tt(byteBuffer, byteBuffer.position() + 12);
    }

    public static void uj(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int ve(ByteBuffer byteBuffer) {
        uj(byteBuffer);
        return c(byteBuffer, byteBuffer.position() + 10);
    }

    public static Pair<ByteBuffer, Long> c(tt ttVar) throws IOException {
        if (ttVar.c() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> pairC = c(ttVar, 0);
        return pairC != null ? pairC : c(ttVar, 65535);
    }

    public static long tt(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    private static Pair<ByteBuffer, Long> c(tt ttVar, int i) throws IOException {
        if (i >= 0 && i <= 65535) {
            long jC = ttVar.c();
            if (jC < 22) {
                return null;
            }
            int iMin = ((int) Math.min(i, jC - 22)) + 22;
            long j = jC - ((long) iMin);
            ByteBuffer byteBufferC = ttVar.c(j, iMin);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferC.order(byteOrder);
            int iN = n(byteBufferC);
            if (iN == -1) {
                return null;
            }
            byteBufferC.position(iN);
            ByteBuffer byteBufferSlice = byteBufferC.slice();
            byteBufferSlice.order(byteOrder);
            return new Pair<>(byteBufferSlice, Long.valueOf(j + ((long) iN)));
        }
        throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
    }

    public static int c(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & 65535;
    }
}
