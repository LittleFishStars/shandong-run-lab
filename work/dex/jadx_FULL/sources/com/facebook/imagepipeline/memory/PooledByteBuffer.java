package com.facebook.imagepipeline.memory;

import java.io.Closeable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface PooledByteBuffer extends Closeable {

    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void f0(int i, byte[] bArr, int i2, int i3);

    boolean isClosed();

    long o();

    int size();

    byte z(int i);
}
