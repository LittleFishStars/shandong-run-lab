package cj.mobile.wm;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h2 implements Closeable {
    public final InputStream dexa;
    public final Charset dexb;
    public byte[] dexc;
    public int dexd;
    public int dexe;

    public class dexa extends ByteArrayOutputStream {
        public dexa(int i) {
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
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, h2.this.dexb.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public h2(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(i2.dexa)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.dexa = inputStream;
        this.dexb = charset;
        this.dexc = new byte[i];
    }

    public h2(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void dexc() throws IOException {
        InputStream inputStream = this.dexa;
        byte[] bArr = this.dexc;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.dexd = 0;
        this.dexe = i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.dexa) {
            if (this.dexc != null) {
                this.dexc = null;
                this.dexa.close();
            }
        }
    }

    public boolean dexa() {
        return this.dexe == -1;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public String dexb() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.dexa) {
            if (this.dexc == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.dexd >= this.dexe) {
                dexc();
            }
            for (int i3 = this.dexd; i3 != this.dexe; i3++) {
                byte[] bArr2 = this.dexc;
                if (bArr2[i3] == 10) {
                    int i4 = this.dexd;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] != 13) {
                            i2 = i3;
                        }
                    } else {
                        i2 = i3;
                    }
                    String str = new String(bArr2, i4, i2 - i4, this.dexb.name());
                    this.dexd = i3 + 1;
                    return str;
                }
            }
            dexa dexaVar = new dexa((this.dexe - this.dexd) + 80);
            loop1: while (true) {
                byte[] bArr3 = this.dexc;
                int i5 = this.dexd;
                dexaVar.write(bArr3, i5, this.dexe - i5);
                this.dexe = -1;
                dexc();
                i = this.dexd;
                while (i != this.dexe) {
                    bArr = this.dexc;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.dexd;
            if (i != i6) {
                dexaVar.write(bArr, i6, i - i6);
            }
            this.dexd = i + 1;
            return dexaVar.toString();
        }
    }
}
