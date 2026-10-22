package com.zj.adlib;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class f9b implements Closeable {
    public static final Charset c = Charset.forName("US-ASCII");
    public int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f41626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f16489a;
    public final Charset b;

    public class a extends ByteArrayOutputStream {
        public a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0 && ((ByteArrayOutputStream) this).buf[i - 1] == 13) {
                i--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, f9b.this.b.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public f9b(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public final String a() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f41626a) {
            if (this.f16489a == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.K >= this.L) {
                b();
            }
            for (int i3 = this.K; i3 != this.L; i3++) {
                byte[] bArr2 = this.f16489a;
                if (bArr2[i3] == 10) {
                    int i4 = this.K;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] != 13) {
                            i2 = i3;
                        }
                    } else {
                        i2 = i3;
                    }
                    String str = new String(bArr2, i4, i2 - i4, this.b.name());
                    this.K = i3 + 1;
                    return str;
                }
            }
            a aVar = new a((this.L - this.K) + 80);
            loop1: while (true) {
                byte[] bArr3 = this.f16489a;
                int i5 = this.K;
                aVar.write(bArr3, i5, this.L - i5);
                this.L = -1;
                b();
                i = this.K;
                while (i != this.L) {
                    bArr = this.f16489a;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.K;
            if (i != i6) {
                aVar.write(bArr, i6, i - i6);
            }
            this.K = i + 1;
            return aVar.toString();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this.f41626a) {
            if (this.f16489a != null) {
                this.f16489a = null;
                this.f41626a.close();
            }
        }
    }

    public f9b(InputStream inputStream, Charset charset, byte b) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(c)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f41626a = inputStream;
        this.b = charset;
        this.f16489a = new byte[8192];
    }

    public final void b() throws IOException {
        InputStream inputStream = this.f41626a;
        byte[] bArr = this.f16489a;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.K = 0;
        this.L = i;
    }
}
