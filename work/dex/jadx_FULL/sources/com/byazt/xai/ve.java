package com.byazt.xai;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1690, 54})
public class ve {
    public static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> pairC = c(randomAccessFile, 0);
        return pairC != null ? pairC : c(randomAccessFile, 65535);
    }

    public static long tt(ByteBuffer byteBuffer) {
        uj(byteBuffer);
        return tt(byteBuffer, byteBuffer.position() + 12);
    }

    private static void uj(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int ve(ByteBuffer byteBuffer) {
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

    private static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile, int i) throws IOException {
        if (i >= 0 && i <= 65535) {
            long length = randomAccessFile.length();
            if (length < 22) {
                return null;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.min(i, length - 22)) + 22);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            long jCapacity = length - ((long) byteBufferAllocate.capacity());
            randomAccessFile.seek(jCapacity);
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            int iVe = ve(byteBufferAllocate);
            if (iVe == -1) {
                return null;
            }
            byteBufferAllocate.position(iVe);
            ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
            byteBufferSlice.order(byteOrder);
            return Pair.create(byteBufferSlice, Long.valueOf(jCapacity + ((long) iVe)));
        }
        throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
    }

    private static long tt(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    public static final boolean c(RandomAccessFile randomAccessFile, long j) throws IOException {
        long j2 = j - 20;
        if (j2 < 0) {
            return false;
        }
        randomAccessFile.seek(j2);
        return randomAccessFile.readInt() == 1347094023;
    }

    public static long c(ByteBuffer byteBuffer) {
        uj(byteBuffer);
        return tt(byteBuffer, byteBuffer.position() + 16);
    }

    private static int c(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & 65535;
    }

    public static void c(ZipFile zipFile) {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (Throwable unused) {
        }
    }
}
