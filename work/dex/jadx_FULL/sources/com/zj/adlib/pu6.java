package com.zj.adlib;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@NotThreadSafe
public class pu6 extends InputStream {

    @VisibleForTesting
    public int K;

    @VisibleForTesting
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final PooledByteBuffer f44061a;

    public pu6(PooledByteBuffer pooledByteBuffer) {
        ax6.d(!pooledByteBuffer.isClosed());
        this.f44061a = (PooledByteBuffer) ax6.i(pooledByteBuffer);
        this.K = 0;
        this.L = 0;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f44061a.size() - this.K;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.L = this.K;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (available() <= 0) {
            return -1;
        }
        PooledByteBuffer pooledByteBuffer = this.f44061a;
        int i = this.K;
        this.K = i + 1;
        return pooledByteBuffer.z(i) & 255;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.K = this.L;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        ax6.d(j >= 0);
        int iMin = Math.min((int) j, available());
        this.K += iMin;
        return iMin;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (i >= 0 && i2 >= 0 && i + i2 <= bArr.length) {
            int iAvailable = available();
            if (iAvailable <= 0) {
                return -1;
            }
            if (i2 <= 0) {
                return 0;
            }
            int iMin = Math.min(iAvailable, i2);
            this.f44061a.f0(this.K, bArr, i, iMin);
            this.K += iMin;
            return iMin;
        }
        throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i + "; regionLength=" + i2);
    }
}
