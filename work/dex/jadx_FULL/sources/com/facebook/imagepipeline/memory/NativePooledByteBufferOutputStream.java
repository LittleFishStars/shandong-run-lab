package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.VisibleForTesting;
import com.zj.adlib.ax6;
import com.zj.adlib.rm1;
import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@NotThreadSafe
public class NativePooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f29996a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public rm1<NativeMemoryChunk> f1656a;

    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public NativePooledByteBufferOutputStream(b bVar) {
        this(bVar, bVar.n());
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        rm1.p(this.f1656a);
        this.f1656a = null;
        this.K = -1;
        super.close();
    }

    public final void h() {
        if (!rm1.F(this.f1656a)) {
            throw new InvalidStreamException();
        }
    }

    @VisibleForTesting
    public void j(int i) throws Throwable {
        h();
        if (i <= this.f1656a.s().g()) {
            return;
        }
        NativeMemoryChunk nativeMemoryChunk = this.f29996a.get(i);
        this.f1656a.s().c(0, nativeMemoryChunk, 0, this.K);
        this.f1656a.close();
        this.f1656a = rm1.J(nativeMemoryChunk, this.f29996a);
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBufferOutputStream
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public c g() {
        h();
        return new c(this.f1656a, this.K);
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBufferOutputStream
    public int size() {
        return this.K;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public NativePooledByteBufferOutputStream(b bVar, int i) {
        ax6.d(i > 0);
        b bVar2 = (b) ax6.i(bVar);
        this.f29996a = bVar2;
        this.K = 0;
        this.f1656a = rm1.J(bVar2.get(i), bVar2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws Throwable {
        if (i >= 0 && i2 >= 0 && i + i2 <= bArr.length) {
            h();
            j(this.K + i2);
            this.f1656a.s().j(this.K, bArr, i, i2);
            this.K += i2;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i + "; regionLength=" + i2);
    }
}
