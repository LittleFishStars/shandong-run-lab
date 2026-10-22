package cj.mobile.wm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class z8 extends InputStream {
    public static final Queue<z8> dexc = e9.dexa(0);
    public InputStream dexa;
    public IOException dexb;

    public static z8 dexb(InputStream inputStream) {
        z8 z8VarPoll;
        Queue<z8> queue = dexc;
        synchronized (queue) {
            z8VarPoll = queue.poll();
        }
        if (z8VarPoll == null) {
            z8VarPoll = new z8();
        }
        z8VarPoll.dexa(inputStream);
        return z8VarPoll;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.dexa.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.dexa.close();
    }

    public IOException dexa() {
        return this.dexb;
    }

    public void dexa(InputStream inputStream) {
        this.dexa = inputStream;
    }

    public void dexb() {
        this.dexb = null;
        this.dexa = null;
        Queue<z8> queue = dexc;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.dexa.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.dexa.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.dexa.read();
        } catch (IOException e) {
            this.dexb = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.dexa.read(bArr);
        } catch (IOException e) {
            this.dexb = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.dexa.read(bArr, i, i2);
        } catch (IOException e) {
            this.dexb = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.dexa.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.dexa.skip(j);
        } catch (IOException e) {
            this.dexb = e;
            return 0L;
        }
    }
}
