package com.bykv.vk.component.ttvideo.player;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public interface IMediaDataSource extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @Keep
    void close() throws IOException;

    @Keep
    long getSize() throws IOException;

    @Keep
    int readAt(long j, byte[] bArr, int i, int i2) throws IOException;
}
