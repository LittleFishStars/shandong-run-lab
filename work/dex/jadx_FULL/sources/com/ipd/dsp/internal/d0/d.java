package com.ipd.dsp.internal.d0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Deprecated
public class d extends InputStream {
    public static final Queue<d> h = o.a(0);
    public InputStream f;
    public IOException g;

    @NonNull
    public static d a(@NonNull InputStream inputStream) {
        d dVarPoll;
        Queue<d> queue = h;
        synchronized (queue) {
            dVarPoll = queue.poll();
        }
        if (dVarPoll == null) {
            dVarPoll = new d();
        }
        dVarPoll.b(inputStream);
        return dVarPoll;
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
        Queue<d> queue = h;
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
    public int read(byte[] bArr) {
        try {
            return this.f.read(bArr);
        } catch (IOException e) {
            this.g = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f.skip(j);
        } catch (IOException e) {
            this.g = e;
            return 0L;
        }
    }

    @Nullable
    public IOException b() {
        return this.g;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f.read(bArr, i, i2);
        } catch (IOException e) {
            this.g = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f.read();
        } catch (IOException e) {
            this.g = e;
            return -1;
        }
    }

    public static void a() {
        while (true) {
            Queue<d> queue = h;
            if (queue.isEmpty()) {
                return;
            } else {
                queue.remove();
            }
        }
    }
}
