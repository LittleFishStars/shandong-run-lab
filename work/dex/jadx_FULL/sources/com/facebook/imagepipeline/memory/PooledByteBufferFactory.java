package com.facebook.imagepipeline.memory;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface PooledByteBufferFactory {
    PooledByteBuffer a(InputStream inputStream, int i) throws IOException;

    PooledByteBuffer b(int i);

    PooledByteBuffer c(byte[] bArr);

    PooledByteBufferOutputStream d();

    PooledByteBuffer e(InputStream inputStream) throws IOException;

    PooledByteBufferOutputStream f(int i);
}
