package com.googlecode.mp4parser;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface DataSource extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    ByteBuffer map(long j, long j2) throws IOException;

    long position() throws IOException;

    void position(long j) throws IOException;

    int read(ByteBuffer byteBuffer) throws IOException;

    long size() throws IOException;

    long transferTo(long j, long j2, WritableByteChannel writableByteChannel) throws IOException;
}
