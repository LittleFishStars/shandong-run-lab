package cj.mobile.wm;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class y8 extends FilterInputStream {
    public final long dexa;
    public int dexb;

    public y8(InputStream inputStream, long j) {
        super(inputStream);
        this.dexa = j;
    }

    private int dexa(int i) throws IOException {
        if (i >= 0) {
            this.dexb += i;
        } else if (this.dexa - ((long) this.dexb) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.dexa + ", but read: " + this.dexb);
        }
        return i;
    }

    public static InputStream dexa(InputStream inputStream, long j) {
        return new y8(inputStream, j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        return (int) Math.max(this.dexa - ((long) this.dexb), ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        return dexa(super.read());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        return dexa(super.read(bArr, i, i2));
    }
}
