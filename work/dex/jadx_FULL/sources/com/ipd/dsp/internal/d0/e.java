package com.ipd.dsp.internal.d0;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e extends InputStream {

    @GuardedBy("POOL")
    public static final Queue<e> h = o.a(0);
    public InputStream f;
    public IOException g;

    @NonNull
    public static e a(@NonNull InputStream inputStream) {
        e eVarPoll;
        Queue<e> queue = h;
        synchronized (queue) {
            eVarPoll = queue.poll();
        }
        if (eVarPoll == null) {
            eVarPoll = new e();
        }
        eVarPoll.b(inputStream);
        return eVarPoll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f.available();
    }

    public void b(@NonNull InputStream inputStream) {
        this.f = inputStream;
    }

    public void c() {
        this.g = null;
        this.f = null;
        Queue<e> queue = h;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        try {
            return this.f.read();
        } catch (IOException e) {
            this.g = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return this.f.skip(j);
        } catch (IOException e) {
            this.g = e;
            throw e;
        }
    }

    @Nullable
    public IOException b() {
        return this.g;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            return this.f.read(bArr);
        } catch (IOException e) {
            this.g = e;
            throw e;
        }
    }

    public static void a() {
        synchronized (h) {
            while (true) {
                Queue<e> queue = h;
                if (!queue.isEmpty()) {
                    queue.remove();
                }
            }
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            return this.f.read(bArr, i, i2);
        } catch (IOException e) {
            this.g = e;
            throw e;
        }
    }
}
