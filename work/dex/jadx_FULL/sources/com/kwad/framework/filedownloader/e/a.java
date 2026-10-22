package com.kwad.framework.filedownloader.e;

import java.io.Closeable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface a extends Closeable {
    void Du();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void seek(long j);

    void setLength(long j);

    void write(byte[] bArr, int i, int i2);
}
