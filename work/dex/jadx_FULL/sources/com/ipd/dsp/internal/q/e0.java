package com.ipd.dsp.internal.q;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e0 extends FilterInputStream {
    public volatile byte[] f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final com.ipd.dsp.internal.j.b k;

    public static class a extends IOException {
        public static final long f = -4338378848813561757L;

        public a(String str) {
            super(str);
        }
    }

    public e0(@NonNull InputStream inputStream, @NonNull com.ipd.dsp.internal.j.b bVar) {
        this(inputStream, bVar, 65536);
    }

    public static IOException c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void a() {
        this.h = this.f.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f == null || inputStream == null) {
            throw c();
        }
        return (this.g - this.j) + inputStream.available();
    }

    public synchronized void b() {
        if (this.f != null) {
            this.k.put(this.f);
            this.f = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f != null) {
            this.k.put(this.f);
            this.f = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.h = Math.max(this.h, i);
        this.i = this.j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw c();
        }
        if (this.j >= this.g && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f && (bArr = this.f) == null) {
            throw c();
        }
        int i = this.g;
        int i2 = this.j;
        if (i - i2 <= 0) {
            return -1;
        }
        this.j = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.i;
        if (-1 == i) {
            throw new a("Mark has been invalidated, pos: " + this.j + " markLimit: " + this.h);
        }
        this.j = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f;
        if (bArr == null) {
            throw c();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw c();
        }
        int i = this.g;
        int i2 = this.j;
        if (i - i2 >= j) {
            this.j = (int) (((long) i2) + j);
            return j;
        }
        long j2 = ((long) i) - ((long) i2);
        this.j = i;
        if (this.i == -1 || j > this.h) {
            long jSkip = inputStream.skip(j - j2);
            if (jSkip > 0) {
                this.i = -1;
            }
            return j2 + jSkip;
        }
        if (a(inputStream, bArr) == -1) {
            return j2;
        }
        int i3 = this.g;
        int i4 = this.j;
        if (i3 - i4 >= j - j2) {
            this.j = (int) ((((long) i4) + j) - j2);
            return j;
        }
        long j3 = (j2 + ((long) i3)) - ((long) i4);
        this.j = i3;
        return j3;
    }

    @VisibleForTesting
    public e0(@NonNull InputStream inputStream, @NonNull com.ipd.dsp.internal.j.b bVar, int i) {
        super(inputStream);
        this.i = -1;
        this.k = bVar;
        this.f = (byte[]) bVar.b(i, byte[].class);
    }

    public final int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i = this.i;
        if (i != -1) {
            int i2 = this.j - i;
            int i3 = this.h;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.g == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.k.b(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f = bArr2;
                    this.k.put(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.j - this.i;
                this.j = i4;
                this.i = 0;
                this.g = 0;
                int i5 = inputStream.read(bArr, i4, bArr.length - i4);
                this.g = i5 <= 0 ? this.j : this.j + i5;
                return i5;
            }
        }
        int i6 = inputStream.read(bArr);
        if (i6 > 0) {
            this.i = -1;
            this.j = 0;
            this.g = i6;
        }
        return i6;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        byte[] bArr2 = this.f;
        if (bArr2 == null) {
            throw c();
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i5 = this.j;
            int i6 = this.g;
            if (i5 < i6) {
                int i7 = i6 - i5;
                if (i7 >= i2) {
                    i7 = i2;
                }
                System.arraycopy(bArr2, i5, bArr, i, i7);
                this.j += i7;
                if (i7 == i2 || inputStream.available() == 0) {
                    return i7;
                }
                i += i7;
                i3 = i2 - i7;
            } else {
                i3 = i2;
            }
            while (true) {
                if (this.i == -1 && i3 >= bArr2.length) {
                    i4 = inputStream.read(bArr, i, i3);
                    if (i4 == -1) {
                        if (i3 == i2) {
                            return -1;
                        }
                        return i2 - i3;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        if (i3 == i2) {
                            return -1;
                        }
                        return i2 - i3;
                    }
                    if (bArr2 != this.f && (bArr2 = this.f) == null) {
                        throw c();
                    }
                    int i8 = this.g;
                    int i9 = this.j;
                    i4 = i8 - i9;
                    if (i4 >= i3) {
                        i4 = i3;
                    }
                    System.arraycopy(bArr2, i9, bArr, i, i4);
                    this.j += i4;
                }
                i3 -= i4;
                if (i3 == 0) {
                    return i2;
                }
                if (inputStream.available() == 0) {
                    return i2 - i3;
                }
                i += i4;
            }
        } else {
            throw c();
        }
    }
}
