package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.VisibleForTesting;
import com.zj.adlib.ax6;
import com.zj.adlib.rm1;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class c implements PooledByteBuffer {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    @GuardedBy("this")
    public rm1<NativeMemoryChunk> f30000a;

    public c(rm1<NativeMemoryChunk> rm1Var, int i) {
        ax6.i(rm1Var);
        ax6.d(i >= 0 && i <= rm1Var.s().g());
        this.f30000a = rm1Var.clone();
        this.K = i;
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBuffer, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        rm1.p(this.f30000a);
        this.f30000a = null;
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBuffer
    public synchronized void f0(int i, byte[] bArr, int i2, int i3) {
        g();
        ax6.d(i + i3 <= this.K);
        this.f30000a.s().h(i, bArr, i2, i3);
    }

    public synchronized void g() {
        if (isClosed()) {
            throw new PooledByteBuffer.ClosedException();
        }
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !rm1.F(this.f30000a);
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBuffer
    public synchronized long o() {
        g();
        return this.f30000a.s().o();
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBuffer
    public synchronized int size() {
        g();
        return this.K;
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBuffer
    public synchronized byte z(int i) {
        g();
        boolean z = true;
        ax6.d(i >= 0);
        if (i >= this.K) {
            z = false;
        }
        ax6.d(z);
        return this.f30000a.s().z(i);
    }
}
