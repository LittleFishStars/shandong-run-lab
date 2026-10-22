package com.fl.saas.s2s.videocache;

import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ByteArraySource implements Source {
    private ByteArrayInputStream arrayInputStream;
    private final byte[] data;

    public ByteArraySource(byte[] bArr) {
        this.data = bArr;
    }

    @Override // com.fl.saas.s2s.videocache.Source
    public void close() {
    }

    @Override // com.fl.saas.s2s.videocache.Source
    public long length() {
        return this.data.length;
    }

    @Override // com.fl.saas.s2s.videocache.Source
    public void open(long j) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.data);
        this.arrayInputStream = byteArrayInputStream;
        byteArrayInputStream.skip(j);
    }

    @Override // com.fl.saas.s2s.videocache.Source
    public int read(byte[] bArr) {
        return this.arrayInputStream.read(bArr, 0, bArr.length);
    }
}
