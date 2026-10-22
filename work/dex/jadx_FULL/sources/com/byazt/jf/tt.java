package com.byazt.jf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LATENCYTIME, 13})
public class tt {
    public static ve c(com.byazt.of.tt ttVar, com.byazt.pty.tt ttVar2, int i) throws Exception {
        try {
            com.byazt.tdd.tt.c cVarC = com.byazt.tdd.tt.c(ttVar, ttVar2);
            long jC = cVarC.c();
            com.byazt.of.tt ttVarTt = cVarC.tt();
            ByteBuffer byteBufferC = ttVarTt.c(0L, (int) ttVarTt.c());
            byteBufferC.order(ByteOrder.LITTLE_ENDIAN);
            return new ve(c(byteBufferC, i), jC, ttVar2.c(), ttVar2.uj(), ttVar2.n());
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    private static ByteBuffer tt(ByteBuffer byteBuffer, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (i2 < iPosition || i2 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    public static byte[] ve(ByteBuffer byteBuffer) throws Exception {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new Exception("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        }
        throw new Exception("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
    }

    public static ByteBuffer tt(ByteBuffer byteBuffer) throws Exception {
        if (byteBuffer.remaining() >= 4) {
            int i = byteBuffer.getInt();
            if (i >= 0) {
                if (i <= byteBuffer.remaining()) {
                    return tt(byteBuffer, i);
                }
                throw new Exception("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new Exception("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    public static ByteBuffer c(ByteBuffer byteBuffer, int i) throws Exception {
        c(byteBuffer);
        ByteBuffer byteBufferC = c(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (byteBufferC.hasRemaining()) {
            i2++;
            if (byteBufferC.remaining() >= 8) {
                long j = byteBufferC.getLong();
                if (j >= 4 && j <= 2147483647L) {
                    int i3 = (int) j;
                    int iPosition = byteBufferC.position() + i3;
                    if (i3 <= byteBufferC.remaining()) {
                        if (byteBufferC.getInt() == i) {
                            return tt(byteBufferC, i3 - 4);
                        }
                        byteBufferC.position(iPosition);
                    } else {
                        throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + byteBufferC.remaining());
                    }
                } else {
                    throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + j);
                }
            } else {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i2)));
            }
        }
        throw new Exception("No APK Signature Scheme block in APK Signing Block with ID: ".concat(String.valueOf(i)));
    }

    public static void c(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
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
