package com.byazt.xai;

import android.util.Pair;
import com.byazt.uq.a;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1690, 13})
public class tt {
    public static String c = "";

    public static String[] c(File file) {
        String str;
        String strC = "";
        try {
            ByteBuffer byteBufferTt = tt(file);
            if (c(byteBufferTt)) {
                strC = a.c(byteBufferTt.array());
                str = "";
            } else {
                str = "without v2 & v3 signature.";
            }
        } catch (Exception unused) {
            str = strC;
        }
        return new String[]{strC, c, str};
    }

    private static ByteBuffer tt(File file) throws Exception {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
            try {
                Pair<ByteBuffer, Long> pairC = c(randomAccessFile2);
                ByteBuffer byteBuffer = (ByteBuffer) pairC.first;
                long jLongValue = ((Long) pairC.second).longValue();
                if (ve.c(randomAccessFile2, jLongValue)) {
                    throw new Exception("ZIP64 APK not supported");
                }
                ByteBuffer byteBuffer2 = (ByteBuffer) c(randomAccessFile2, c(byteBuffer, jLongValue)).first;
                randomAccessFile2.close();
                return byteBuffer2;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile) throws Exception {
        Pair<ByteBuffer, Long> pairC = ve.c(randomAccessFile);
        if (pairC != null) {
            return pairC;
        }
        throw new Exception("Not an APK file: ZIP End of Central Directory record not found");
    }

    private static long c(ByteBuffer byteBuffer, long j) throws Exception {
        long jC = ve.c(byteBuffer);
        if (jC <= j) {
            if (ve.tt(byteBuffer) + jC == j) {
                return jC;
            }
            throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new Exception("ZIP Central Directory offset out of range: " + jC + ". ZIP End of Central Directory offset: " + j);
    }

    public static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile, long j) throws Exception {
        if (j >= 32) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            randomAccessFile.seek(j - ((long) byteBufferAllocate.capacity()));
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            if (byteBufferAllocate.getLong(8) == 2334950737559900225L && byteBufferAllocate.getLong(16) == 3617552046287187010L) {
                long j2 = byteBufferAllocate.getLong(0);
                if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
                    throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
                }
                int i = (int) (8 + j2);
                long j3 = j - ((long) i);
                if (j3 >= 0) {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
                    byteBufferAllocate2.order(byteOrder);
                    randomAccessFile.seek(j3);
                    randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
                    long j4 = byteBufferAllocate2.getLong(0);
                    if (j4 == j2) {
                        return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
                    }
                    throw new Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
                }
                throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
            }
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
    }

    private static void tt(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static boolean c(ByteBuffer byteBuffer) throws Exception {
        tt(byteBuffer);
        ByteBuffer byteBufferC = c(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (byteBufferC.hasRemaining()) {
            i++;
            if (byteBufferC.remaining() >= 8) {
                long j = byteBufferC.getLong();
                if (j >= 4 && j <= 2147483647L) {
                    int i2 = (int) j;
                    int iPosition = byteBufferC.position() + i2;
                    if (i2 <= byteBufferC.remaining()) {
                        int i3 = byteBufferC.getInt();
                        if (i3 == -262969152) {
                            c = "V3";
                            return true;
                        }
                        if (i3 == 1896449818) {
                            c = "V2";
                            return true;
                        }
                        byteBufferC.position(iPosition);
                    } else {
                        throw new Exception("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + byteBufferC.remaining());
                    }
                } else {
                    throw new Exception("APK Signing Block entry #" + i + " size out of range: " + j);
                }
            } else {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
            }
        }
        return false;
    }

    private static ByteBuffer c(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i)));
        }
        if (i2 >= i) {
            int iCapacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int iLimit = byteBuffer.limit();
                int iPosition = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
                    byteBuffer.position(i);
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    return byteBufferSlice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(iLimit);
                    byteBuffer.position(iPosition);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
    }
}
