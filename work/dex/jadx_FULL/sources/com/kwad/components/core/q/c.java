package com.kwad.components.core.q;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends InputStream {
    private int akA;
    private volatile float akC;
    private volatile long akD;
    private InputStream akz;
    private int akw = -1;
    private int akx = 10000;
    private long aky = -1;
    private long akB = -1;
    private int akE = 20480;

    public c(@NonNull InputStream inputStream, int i) {
        i = i < 20480 ? 20480 : i;
        this.akz = inputStream;
        this.akC = i / 1000.0f;
    }

    @WorkerThread
    private static void T(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static long g(long j, long j2) {
        if (j <= 0) {
            return 0L;
        }
        if (j2 <= 0) {
            return -1L;
        }
        return j / j2;
    }

    private void wk() {
        this.akw = 0;
        this.aky = System.currentTimeMillis();
    }

    private void wl() {
        if (this.akw < this.akx) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.aky;
        float f = this.akw / this.akC;
        this.akD = g(this.akA, jCurrentTimeMillis - this.akB);
        float f2 = j;
        if (f > f2) {
            T((long) (f - f2));
        }
        wk();
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.akz.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.akz.close();
        b.a(this);
        this.akB = -1L;
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i) {
        this.akz.mark(i);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.akz.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this.akB <= 0) {
            this.akB = System.currentTimeMillis();
        }
        this.akA++;
        if (!(b.aku && b.akt)) {
            return this.akz.read();
        }
        if (this.akw < 0) {
            wk();
        }
        int i = this.akz.read();
        this.akw++;
        wl();
        return i;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.akz.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        return this.akz.skip(j);
    }

    public final long wj() {
        return this.akD;
    }
}
