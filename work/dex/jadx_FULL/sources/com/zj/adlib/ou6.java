package com.zj.adlib;

import com.facebook.common.references.ResourceReleaser;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@NotThreadSafe
public class ou6 extends InputStream {
    public static final String f = "PooledByteInputStream";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ResourceReleaser<byte[]> f43834a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final InputStream f18723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f18725a;
    public int K = 0;
    public int L = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18724a = false;

    public ou6(InputStream inputStream, byte[] bArr, ResourceReleaser<byte[]> resourceReleaser) {
        this.f18723a = (InputStream) ax6.i(inputStream);
        this.f18725a = (byte[]) ax6.i(bArr);
        this.f43834a = (ResourceReleaser) ax6.i(resourceReleaser);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        ax6.o(this.L <= this.K);
        h();
        return (this.K - this.L) + this.f18723a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f18724a) {
            return;
        }
        this.f18724a = true;
        this.f43834a.a(this.f18725a);
        super.close();
    }

    public void finalize() throws Throwable {
        if (!this.f18724a) {
            ad3.u(f, "Finalized without closing");
            close();
        }
        super.finalize();
    }

    public final boolean g() throws IOException {
        if (this.L < this.K) {
            return true;
        }
        int i = this.f18723a.read(this.f18725a);
        if (i <= 0) {
            return false;
        }
        this.K = i;
        this.L = 0;
        return true;
    }

    public final void h() throws IOException {
        if (this.f18724a) {
            throw new IOException("stream already closed");
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        ax6.o(this.L <= this.K);
        h();
        if (!g()) {
            return -1;
        }
        byte[] bArr = this.f18725a;
        int i = this.L;
        this.L = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        ax6.o(this.L <= this.K);
        h();
        int i = this.K;
        int i2 = this.L;
        long j2 = i - i2;
        if (j2 >= j) {
            this.L = (int) (((long) i2) + j);
            return j;
        }
        this.L = i;
        return j2 + this.f18723a.skip(j - j2);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        ax6.o(this.L <= this.K);
        h();
        if (!g()) {
            return -1;
        }
        int iMin = Math.min(this.K - this.L, i2);
        System.arraycopy(this.f18725a, this.L, bArr, i, iMin);
        this.L += iMin;
        return iMin;
    }
}
