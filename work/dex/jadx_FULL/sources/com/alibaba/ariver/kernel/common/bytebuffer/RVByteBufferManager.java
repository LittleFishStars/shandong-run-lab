package com.alibaba.ariver.kernel.common.bytebuffer;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVByteBufferManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24233a = "AriverKernel:RVByteBufferManager";

    private static void a(ByteBuffer byteBuffer) {
        try {
            Method method = byteBuffer.getClass().getMethod("cleaner", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(byteBuffer, new Object[0]);
            Method method2 = objInvoke.getClass().getMethod("clean", new Class[0]);
            method2.setAccessible(true);
            method2.invoke(objInvoke, new Object[0]);
        } catch (Throwable th) {
            RVLogger.e(f24233a, "releaseBuffer: ", th);
        }
    }

    public static void releaseAllBuffer() {
        try {
            Iterator<ByteBuffer> it = RVByteBufferPool.sBufferPool.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            RVByteBufferPool.sBufferPool.clear();
        } catch (Throwable th) {
            RVLogger.e(f24233a, "releaseAllBuffer: ", th);
        }
    }
}
