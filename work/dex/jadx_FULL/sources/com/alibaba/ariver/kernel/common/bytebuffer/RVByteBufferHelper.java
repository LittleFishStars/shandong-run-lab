package com.alibaba.ariver.kernel.common.bytebuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVByteBufferHelper {
    public static ByteBuffer wrap(byte[] bArr, int i) {
        return RVByteBufferPool.get(bArr, i);
    }
}
