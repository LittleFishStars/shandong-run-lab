package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.soloader.SoLoaderShim;
import com.zj.adlib.ax6;
import java.io.Closeable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@DoNotStrip
public class NativeMemoryChunk implements Closeable {
    public static final String f = "NativeMemoryChunk";
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f29995a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1655a;

    static {
        SoLoaderShim.a("memchunk");
    }

    public NativeMemoryChunk(int i) {
        ax6.d(i > 0);
        this.K = i;
        this.f29995a = nativeAllocate(i);
        this.f1655a = false;
    }

    @DoNotStrip
    private static native long nativeAllocate(int i);

    @DoNotStrip
    private static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeFree(long j);

    @DoNotStrip
    private static native void nativeMemcpy(long j, long j2, int i);

    @DoNotStrip
    private static native byte nativeReadByte(long j);

    public final int a(int i, int i2) {
        return Math.min(Math.max(0, this.K - i), i2);
    }

    public final void b(int i, int i2, int i3, int i4) {
        ax6.d(i4 >= 0);
        ax6.d(i >= 0);
        ax6.d(i3 >= 0);
        ax6.d(i + i4 <= this.K);
        ax6.d(i3 + i4 <= i2);
    }

    public void c(int i, NativeMemoryChunk nativeMemoryChunk, int i2, int i3) {
        ax6.i(nativeMemoryChunk);
        if (nativeMemoryChunk.f29995a == this.f29995a) {
            Log.w(f, "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(nativeMemoryChunk)) + " which share the same address " + Long.toHexString(this.f29995a));
            ax6.d(false);
        }
        if (nativeMemoryChunk.f29995a < this.f29995a) {
            synchronized (nativeMemoryChunk) {
                synchronized (this) {
                    e(i, nativeMemoryChunk, i2, i3);
                }
            }
        } else {
            synchronized (this) {
                synchronized (nativeMemoryChunk) {
                    e(i, nativeMemoryChunk, i2, i3);
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.f1655a) {
            this.f1655a = true;
            nativeFree(this.f29995a);
        }
    }

    public final void e(int i, NativeMemoryChunk nativeMemoryChunk, int i2, int i3) {
        ax6.o(!isClosed());
        ax6.o(!nativeMemoryChunk.isClosed());
        b(i, nativeMemoryChunk.K, i2, i3);
        nativeMemcpy(nativeMemoryChunk.f29995a + ((long) i2), this.f29995a + ((long) i), i3);
    }

    public void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        Log.w(f, "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. Underlying address = " + Long.toHexString(this.f29995a));
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public int g() {
        return this.K;
    }

    public synchronized int h(int i, byte[] bArr, int i2, int i3) {
        int iA;
        ax6.i(bArr);
        ax6.o(!isClosed());
        iA = a(i, i3);
        b(i, bArr.length, i2, iA);
        nativeCopyToByteArray(this.f29995a + ((long) i), bArr, i2, iA);
        return iA;
    }

    public synchronized boolean isClosed() {
        return this.f1655a;
    }

    public synchronized int j(int i, byte[] bArr, int i2, int i3) {
        int iA;
        ax6.i(bArr);
        ax6.o(!isClosed());
        iA = a(i, i3);
        b(i, bArr.length, i2, iA);
        nativeCopyFromByteArray(this.f29995a + ((long) i), bArr, i2, iA);
        return iA;
    }

    public long o() {
        return this.f29995a;
    }

    public synchronized byte z(int i) {
        boolean z = true;
        ax6.o(!isClosed());
        ax6.d(i >= 0);
        if (i >= this.K) {
            z = false;
        }
        ax6.d(z);
        return nativeReadByte(this.f29995a + ((long) i));
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        this.K = 0;
        this.f29995a = 0L;
        this.f1655a = true;
    }
}
