package com.alibaba.ariver.resource.parser.a;

import com.alibaba.ariver.kernel.common.utils.IOUtils;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24454a = 2048;
    private c b;
    private long c;
    private long d;
    private boolean e;

    public f(InputStream inputStream) {
        super(inputStream);
        this.e = false;
        this.c = 0L;
        this.d = 0L;
    }

    public c a() throws IOException {
        c();
        byte[] buf = IOUtils.getBuf(512);
        byte[] buf2 = IOUtils.getBuf(512);
        boolean z = false;
        int i = 0;
        while (i < 512) {
            int i2 = read(buf2, 0, 512 - i);
            if (i2 < 0) {
                break;
            }
            System.arraycopy(buf2, 0, buf, i, i2);
            i += i2;
        }
        int length = buf.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                z = true;
                break;
            }
            if (buf[i3] != 0) {
                break;
            }
            i3++;
        }
        if (!z) {
            this.b = new c(buf);
        }
        IOUtils.returnBuf(buf);
        IOUtils.returnBuf(buf2);
        return this.b;
    }

    public long b() {
        return this.d;
    }

    public void c() throws IOException {
        c cVar = this.b;
        if (cVar != null) {
            if (cVar.i() > this.c) {
                long j = 0;
                while (j < this.b.i() - this.c) {
                    long jSkip = skip((this.b.i() - this.c) - j);
                    if (jSkip == 0 && this.b.i() - this.c > 0) {
                        throw new IOException("Possible tar file corruption");
                    }
                    j += jSkip;
                }
            }
            this.b = null;
            this.c = 0L;
            d();
        }
    }

    public void d() {
        int i;
        long j = this.d;
        long jSkip = 0;
        if (j <= 0 || (i = (int) (j % 512)) <= 0) {
            return;
        }
        while (true) {
            long j2 = 512 - i;
            if (jSkip >= j2) {
                return;
            } else {
                jSkip += skip(j2 - jSkip);
            }
        }
    }

    public boolean e() {
        return this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int i = read(bArr, 0, 1);
        return i != -1 ? bArr[0] & 255 : i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (this.e) {
            long jSkip = super.skip(j);
            this.d += jSkip;
            return jSkip;
        }
        if (j <= 0) {
            return 0L;
        }
        byte[] buf = IOUtils.getBuf(2048);
        long j2 = j;
        while (j2 > 0) {
            int i = read(buf, 0, (int) (j2 < 2048 ? j2 : 2048L));
            if (i < 0) {
                break;
            }
            j2 -= (long) i;
        }
        IOUtils.returnBuf(buf);
        return j - j2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        c cVar = this.b;
        if (cVar != null) {
            if (this.c == cVar.i()) {
                return -1;
            }
            if (this.b.i() - this.c < i2) {
                i2 = (int) (this.b.i() - this.c);
            }
        }
        int i3 = super.read(bArr, i, i2);
        if (i3 != -1) {
            if (this.b != null) {
                this.c += (long) i3;
            }
            this.d += (long) i3;
        }
        return i3;
    }

    public void a(boolean z) {
        this.e = z;
    }
}
