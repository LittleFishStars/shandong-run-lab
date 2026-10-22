package com.kwad.sdk.core.diskcache.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b implements Closeable {
    private final Charset aRS;
    private byte[] buf;
    private int end;
    private final InputStream in;
    private int pos;

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void Lw() throws IOException {
        InputStream inputStream = this.in;
        byte[] bArr = this.buf;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.pos = 0;
        this.end = i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                com.kwad.sdk.crash.utils.b.closeQuietly(this.in);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public final String readLine() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.in) {
            if (this.buf == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.pos >= this.end) {
                Lw();
            }
            for (int i3 = this.pos; i3 != this.end; i3++) {
                byte[] bArr2 = this.buf;
                if (bArr2[i3] == 10) {
                    int i4 = this.pos;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] != 13) {
                            i2 = i3;
                        }
                    } else {
                        i2 = i3;
                    }
                    String str = new String(bArr2, i4, i2 - i4, this.aRS.name());
                    this.pos = i3 + 1;
                    return str;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                @Override // java.io.ByteArrayOutputStream
                public final String toString() {
                    int i5 = ((ByteArrayOutputStream) this).count;
                    if (i5 > 0 && ((ByteArrayOutputStream) this).buf[i5 - 1] == 13) {
                        i5--;
                    }
                    try {
                        return new String(((ByteArrayOutputStream) this).buf, 0, i5, b.this.aRS.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1: while (true) {
                byte[] bArr3 = this.buf;
                int i5 = this.pos;
                byteArrayOutputStream.write(bArr3, i5, this.end - i5);
                this.end = -1;
                Lw();
                i = this.pos;
                while (i != this.end) {
                    bArr = this.buf;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.pos;
            if (i != i6) {
                byteArrayOutputStream.write(bArr, i6, i - i6);
            }
            this.pos = i + 1;
            return byteArrayOutputStream.toString();
        }
    }

    private b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(com.kwad.sdk.crash.utils.a.US_ASCII)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.in = inputStream;
        this.aRS = charset;
        this.buf = new byte[8192];
    }
}
