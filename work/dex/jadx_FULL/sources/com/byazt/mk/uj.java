package com.byazt.mk;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface uj extends rh, WritableByteChannel {
    @Override // com.byazt.mk.rh, java.io.Flushable
    void flush() throws IOException;

    uj i(int i) throws IOException;

    uj rl() throws IOException;

    uj sl(long j) throws IOException;

    uj sp(int i) throws IOException;

    uj t(long j) throws IOException;

    uj tt(a aVar) throws IOException;

    uj tt(String str) throws IOException;

    uj ve(byte[] bArr) throws IOException;

    uj ve(byte[] bArr, int i, int i2) throws IOException;

    ve ve();

    uj x(int i) throws IOException;
}
