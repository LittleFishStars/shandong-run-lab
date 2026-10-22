package com.byazt.ss;

import com.ali.auth.third.core.model.SystemMessageConstants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SystemMessageConstants.JS_BRIDGE_METHOD_NOT_FOUND, 54})
public class ve implements Closeable {
    public final InputStream c;
    public int n;
    public final Charset tt;
    public int uj;
    public byte[] ve;

    public ve(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void ve() throws IOException {
        InputStream inputStream = this.c;
        byte[] bArr = this.ve;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.uj = 0;
        this.n = i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.c) {
            if (this.ve != null) {
                this.ve = null;
                this.c.close();
            }
        }
    }

    public boolean tt() {
        return this.n == -1;
    }

    public ve(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(uj.c)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.c = inputStream;
        this.tt = charset;
        this.ve = new byte[i];
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public String c() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.c) {
            if (this.ve == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.uj >= this.n) {
                ve();
            }
            for (int i3 = this.uj; i3 != this.n; i3++) {
                byte[] bArr2 = this.ve;
                if (bArr2[i3] == 10) {
                    int i4 = this.uj;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] != 13) {
                            i2 = i3;
                        }
                    } else {
                        i2 = i3;
                    }
                    String str = new String(bArr2, i4, i2 - i4, this.tt.name());
                    this.uj = i3 + 1;
                    return str;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.n - this.uj) + 80) { // from class: com.byazt.ss.ve.1
                @Override // java.io.ByteArrayOutputStream
                public String toString() {
                    int i5 = ((ByteArrayOutputStream) this).count;
                    if (i5 > 0 && ((ByteArrayOutputStream) this).buf[i5 - 1] == 13) {
                        i5--;
                    }
                    try {
                        return new String(((ByteArrayOutputStream) this).buf, 0, i5, ve.this.tt.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1: while (true) {
                byte[] bArr3 = this.ve;
                int i5 = this.uj;
                byteArrayOutputStream.write(bArr3, i5, this.n - i5);
                this.n = -1;
                ve();
                i = this.uj;
                while (i != this.n) {
                    bArr = this.ve;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.uj;
            if (i != i6) {
                byteArrayOutputStream.write(bArr, i6, i - i6);
            }
            this.uj = i + 1;
            return byteArrayOutputStream.toString();
        }
    }
}
