package com.aliyun.common.g;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends OutputStream {
    private static final byte[] f = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<byte[]> f25574a;
    private int b;
    private int c;
    private byte[] d;
    private int e;

    public a() {
        this(1024);
    }

    public a(int i) {
        this.f25574a = new ArrayList();
        if (i >= 0) {
            synchronized (this) {
                a(i);
            }
        } else {
            throw new IllegalArgumentException("Negative initial size: " + i);
        }
    }

    private void a(int i) {
        int length;
        if (this.b < this.f25574a.size() - 1) {
            this.c += this.d.length;
            int i2 = this.b + 1;
            this.b = i2;
            this.d = this.f25574a.get(i2);
            return;
        }
        byte[] bArr = this.d;
        if (bArr == null) {
            length = 0;
        } else {
            i = Math.max(bArr.length << 1, i - this.c);
            length = this.c + this.d.length;
        }
        this.c = length;
        this.b++;
        byte[] bArr2 = new byte[i];
        this.d = bArr2;
        this.f25574a.add(bArr2);
    }

    public synchronized byte[] a() {
        int i = this.e;
        if (i == 0) {
            return f;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] bArr2 : this.f25574a) {
            int iMin = Math.min(bArr2.length, i);
            System.arraycopy(bArr2, 0, bArr, i2, iMin);
            i2 += iMin;
            i -= iMin;
            if (i == 0) {
                break;
            }
        }
        return bArr;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public String toString() {
        return new String(a());
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        int i2 = this.e;
        int i3 = i2 - this.c;
        if (i3 == this.d.length) {
            a(i2 + 1);
            i3 = 0;
        }
        this.d[i3] = (byte) i;
        this.e++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3;
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        synchronized (this) {
            int i4 = this.e;
            int i5 = i4 + i2;
            int i6 = i4 - this.c;
            while (i2 > 0) {
                int iMin = Math.min(i2, this.d.length - i6);
                System.arraycopy(bArr, i3 - i2, this.d, i6, iMin);
                i2 -= iMin;
                if (i2 > 0) {
                    a(i5);
                    i6 = 0;
                }
            }
            this.e = i5;
        }
    }
}
