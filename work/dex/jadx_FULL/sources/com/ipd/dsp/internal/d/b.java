package com.ipd.dsp.internal.d;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements Closeable {
    public static final byte k = 13;
    public static final byte l = 10;
    public final InputStream f;
    public final Charset g;
    public byte[] h;
    public int i;
    public int j;

    public class a extends ByteArrayOutputStream {
        public a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0) {
                int i2 = i - 1;
                if (((ByteArrayOutputStream) this).buf[i2] == 13) {
                    i = i2;
                }
            }
            return new String(((ByteArrayOutputStream) this).buf, 0, i, b.this.g);
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public boolean b() {
        return this.j == -1;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public String c() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f) {
            if (this.h == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.i >= this.j) {
                a();
            }
            for (int i3 = this.i; i3 != this.j; i3++) {
                byte[] bArr2 = this.h;
                if (bArr2[i3] == 10) {
                    int i4 = this.i;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] != 13) {
                            i2 = i3;
                        }
                    } else {
                        i2 = i3;
                    }
                    String str = new String(bArr2, i4, i2 - i4, this.g);
                    this.i = i3 + 1;
                    return str;
                }
            }
            a aVar = new a((this.j - this.i) + 80);
            loop1: while (true) {
                byte[] bArr3 = this.h;
                int i5 = this.i;
                aVar.write(bArr3, i5, this.j - i5);
                this.j = -1;
                a();
                i = this.i;
                while (i != this.j) {
                    bArr = this.h;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.i;
            if (i != i6) {
                aVar.write(bArr, i6, i - i6);
            }
            this.i = i + 1;
            return aVar.toString();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f) {
            if (this.h != null) {
                this.h = null;
                this.f.close();
            }
        }
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f38271a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f = inputStream;
        this.g = charset;
        this.h = new byte[i];
    }

    public final void a() throws IOException {
        InputStream inputStream = this.f;
        byte[] bArr = this.h;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.i = 0;
        this.j = i;
    }
}
