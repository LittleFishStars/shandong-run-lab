package com.alibaba.ariver.resource.runtime;

import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24467a = "H5ByteBufferUtil";
    public static byte[] b = "<!-- start path=".getBytes();
    public static byte[] c = " -->".getBytes();
    public static byte[] d = "<script>\n".getBytes();
    public static byte[] e = "\n</script>".getBytes();

    public static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, String str, a aVar) {
        int iPosition;
        ByteBuffer byteBufferAllocate;
        boolean z;
        boolean z2;
        boolean z3;
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            if (byteBufferWrap != null && bArr2 != null && bArr3 != null) {
                int i = -1;
                ByteBuffer byteBuffer = null;
                int i2 = -1;
                int iPosition2 = -1;
                int iPosition3 = -1;
                int length = 0;
                while (byteBufferWrap.hasRemaining()) {
                    while (byteBufferWrap.hasRemaining()) {
                        int length2 = bArr2.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length2) {
                                z3 = true;
                                break;
                            }
                            if (byteBufferWrap.get() != bArr2[i3]) {
                                z3 = false;
                                break;
                            }
                            i3++;
                        }
                        if (z3) {
                            iPosition2 = byteBufferWrap.position() - bArr2.length;
                            break;
                        }
                    }
                    while (byteBufferWrap.hasRemaining()) {
                        int length3 = bArr3.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length3) {
                                z2 = true;
                                break;
                            }
                            if (byteBufferWrap.get() != bArr3[i4]) {
                                z2 = false;
                                break;
                            }
                            i4++;
                        }
                        if (z2) {
                            iPosition3 = byteBufferWrap.position() - bArr3.length;
                            break;
                        }
                    }
                    while (true) {
                        if (!byteBufferWrap.hasRemaining()) {
                            iPosition = i2;
                            break;
                        }
                        int length4 = bArr3.length;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length4) {
                                z = true;
                                break;
                            }
                            if (byteBufferWrap.get() != bArr3[i5]) {
                                z = false;
                                break;
                            }
                            i5++;
                        }
                        if (z) {
                            iPosition = byteBufferWrap.position() - bArr3.length;
                            break;
                        }
                    }
                    if (iPosition == i) {
                        RVLogger.d(f24467a, "replaceJsFile not find TAG in appx.js");
                        return null;
                    }
                    if (i2 == iPosition) {
                        int length5 = iPosition + bArr3.length;
                        int iCapacity = byteBufferWrap.capacity() - length5;
                        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(iCapacity);
                        byteBufferWrap.position(length5);
                        byteBufferWrap.get(byteBufferAllocate2.array(), 0, iCapacity);
                        ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(byteBufferAllocate2.capacity() + byteBuffer.capacity());
                        byteBuffer.position(0);
                        byteBufferAllocate3.put(byteBuffer);
                        byteBufferAllocate3.put(byteBufferAllocate2);
                        return byteBufferAllocate3.array();
                    }
                    ByteBuffer byteBufferA = a(bArr, iPosition2, iPosition3, str, aVar);
                    ByteBuffer byteBufferAllocate4 = ByteBuffer.allocate((iPosition2 - length) + byteBufferA.capacity());
                    ByteBuffer byteBufferA2 = a(byteBufferWrap, length, iPosition2);
                    byteBufferA2.position(0);
                    byteBufferA.position(0);
                    byteBufferAllocate4.put(byteBufferA2);
                    byteBufferAllocate4.put(byteBufferA);
                    if (byteBuffer == null) {
                        byteBufferAllocate = ByteBuffer.allocate(byteBufferAllocate4.capacity());
                        byteBufferAllocate4.position(0);
                        byteBufferAllocate.put(byteBufferAllocate4);
                    } else {
                        byteBufferAllocate = ByteBuffer.allocate(byteBuffer.capacity() + byteBufferAllocate4.capacity());
                        byteBuffer.position(0);
                        byteBufferAllocate4.position(0);
                        byteBufferAllocate.put(byteBuffer);
                        byteBufferAllocate.put(byteBufferAllocate4);
                    }
                    byteBuffer = byteBufferAllocate;
                    length = iPosition + c.length;
                    i2 = iPosition;
                    i = -1;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            RVLogger.e(f24467a, "replaceJsFile error: ", th);
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        int iPosition = byteBuffer.position();
        byteBuffer.position(i);
        int i3 = i2 - i;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i3);
        byteBuffer.get(byteBufferAllocate.array(), 0, i3);
        byteBuffer.position(iPosition);
        return byteBufferAllocate;
    }

    private static ByteBuffer a(byte[] bArr, int i, int i2, String str, a aVar) {
        byte[] bytes;
        byte[] bArr2 = b;
        int length = (i2 - i) - bArr2.length;
        if (length <= 0) {
            return null;
        }
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, i + bArr2.length, bArr3, 0, length);
        String str2 = new String(bArr3);
        Resource rawResource = aVar.getRawResource(new ResourceQuery(str2));
        if ((rawResource == null && (rawResource = aVar.getRawResource(new ResourceQuery(FileUtils.combinePath(str, str2)))) == null) || (bytes = rawResource.getBytes()) == null) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length + d.length + e.length);
        byteBufferAllocate.put(d);
        byteBufferAllocate.put(bytes);
        byteBufferAllocate.put(e);
        return byteBufferAllocate;
    }
}
