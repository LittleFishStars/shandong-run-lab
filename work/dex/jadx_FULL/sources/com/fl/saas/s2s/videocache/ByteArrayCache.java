package com.fl.saas.s2s.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ByteArrayCache implements Cache {
    private volatile boolean completed;
    private volatile byte[] data;

    public ByteArrayCache() {
        this(new byte[0]);
    }

    public ByteArrayCache(byte[] bArr) {
        this.data = (byte[]) Preconditions.checkNotNull(bArr);
    }

    @Override // com.fl.saas.s2s.videocache.Cache
    public void append(byte[] bArr, int i) {
        Preconditions.checkNotNull(this.data);
        Preconditions.checkArgument(i >= 0 && i <= bArr.length);
        byte[] bArrCopyOf = Arrays.copyOf(this.data, this.data.length + i);
        System.arraycopy(bArr, 0, bArrCopyOf, this.data.length, i);
        this.data = bArrCopyOf;
    }

    @Override // com.fl.saas.s2s.videocache.Cache
    public long available() {
        return this.data.length;
    }

    @Override // com.fl.saas.s2s.videocache.Cache
    public void close() {
    }

    @Override // com.fl.saas.s2s.videocache.Cache
    public void complete() {
        this.completed = true;
    }

    @Override // com.fl.saas.s2s.videocache.Cache
    public boolean isCompleted() {
        return this.completed;
    }

    @Override // com.fl.saas.s2s.videocache.Cache
    public int read(byte[] bArr, long j, int i) {
        if (j >= this.data.length) {
            return -1;
        }
        if (j <= 2147483647L) {
            return new ByteArrayInputStream(this.data).read(bArr, (int) j, i);
        }
        throw new IllegalArgumentException("Too long offset for memory cache " + j);
    }
}
