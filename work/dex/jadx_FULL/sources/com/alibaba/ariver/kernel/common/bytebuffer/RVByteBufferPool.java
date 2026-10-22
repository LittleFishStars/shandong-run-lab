package com.alibaba.ariver.kernel.common.bytebuffer;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class RVByteBufferPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24234a = "AriverKernel:RVByteBufferPool";
    private static final int b = 16;
    private static final int c = 5242880;
    static List<ByteBuffer> sBufferPool = new CopyOnWriteArrayList();

    private static void a(ByteBuffer byteBuffer, byte[] bArr) {
        try {
            byteBuffer.clear();
            byteBuffer.put(bArr);
            byteBuffer.flip();
        } catch (Throwable th) {
            RVLogger.e(f24234a, "fillData: ", th);
        }
    }

    private static ByteBuffer b(int i) {
        for (ByteBuffer byteBuffer : sBufferPool) {
            if (byteBuffer != null && !byteBuffer.hasRemaining() && byteBuffer.capacity() >= i) {
                return byteBuffer;
            }
        }
        return null;
    }

    private static ByteBuffer c(int i) {
        try {
            return ByteBuffer.allocateDirect(i);
        } catch (Throwable th) {
            RVLogger.e(f24234a, "allocateBuffer: ", th);
            return null;
        }
    }

    public static ByteBuffer get(byte[] bArr, int i) {
        if (bArr == null) {
            RVLogger.w(f24234a, "get, data is null");
            return null;
        }
        if (i > 0 && i <= 5242880) {
            ByteBuffer byteBufferA = a(i);
            a(byteBufferA, bArr);
            return byteBufferA;
        }
        RVLogger.w(f24234a, "length is smaller than zero or too large: " + i);
        return null;
    }

    private static ByteBuffer a(int i) {
        if (sBufferPool.size() >= 16) {
            ByteBuffer byteBufferB = b(i);
            return byteBufferB == null ? c(i) : byteBufferB;
        }
        return c(i);
    }
}
