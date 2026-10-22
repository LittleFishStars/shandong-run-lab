package cj.mobile.wm;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c9 extends FilterInputStream {
    public int dexa;

    public c9(InputStream inputStream) {
        super(inputStream);
        this.dexa = Integer.MIN_VALUE;
    }

    private long dexa(long j) {
        int i = this.dexa;
        if (i == 0) {
            return -1L;
        }
        if (i != Integer.MIN_VALUE) {
            long j2 = i;
            if (j > j2) {
                return j2;
            }
        }
        return j;
    }

    private void dexb(long j) {
        int i = this.dexa;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.dexa = (int) (((long) i) - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i = this.dexa;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        super.mark(i);
        this.dexa = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (dexa(1L) == -1) {
            return -1;
        }
        int i = super.read();
        dexb(1L);
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iDexa = (int) dexa(i2);
        if (iDexa == -1) {
            return -1;
        }
        int i3 = super.read(bArr, i, iDexa);
        dexb(i3);
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.dexa = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jDexa = dexa(j);
        if (jDexa == -1) {
            return -1L;
        }
        long jSkip = super.skip(jDexa);
        dexb(jSkip);
        return jSkip;
    }
}
