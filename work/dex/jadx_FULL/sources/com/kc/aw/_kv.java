package com.kc.aw;

import com.google.common.io.b;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _kv extends InputStream {
    public volatile InputStream _a;
    public int _c;
    public int _d;
    public int _f;
    public int _e = -1;
    public volatile byte[] _b = _ax._a();

    public _kv(InputStream inputStream) {
        this._a = inputStream;
    }

    public final void _c() throws IOException {
        byte[] bArr = this._b;
        int i = this._e;
        if (i >= 0) {
            int i2 = this._d;
            if (i2 >= bArr.length) {
                if (i > 0) {
                    int i3 = i2 - i;
                    System.arraycopy(bArr, i, bArr, 0, i3);
                    this._d = i3;
                    this._e = 0;
                } else {
                    int length = bArr.length;
                    int i4 = this._f;
                    if (length >= i4) {
                        this._e = -1;
                        this._d = 0;
                    } else {
                        int length2 = bArr.length;
                        int i5 = b.c;
                        if (length2 >= 2147483639) {
                            throw new OutOfMemoryError("Required array size too large");
                        }
                        if (i2 <= b.c - i2) {
                            i5 = i2 * 2;
                        }
                        if (i5 <= i4) {
                            i4 = i5;
                        }
                        byte[] bArr_a = _ax._a(i4);
                        System.arraycopy(bArr, 0, bArr_a, 0, this._d);
                        _ax._a(bArr);
                        this._b = bArr_a;
                        bArr = bArr_a;
                    }
                }
            }
        } else {
            this._d = 0;
        }
        this._c = this._d;
        InputStream inputStream = this._a;
        int i6 = this._d;
        int i7 = inputStream.read(bArr, i6, bArr.length - i6);
        if (i7 > 0) {
            this._c = i7 + this._d;
        }
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        int i = this._c - this._d;
        int iAvailable = this._a.available();
        if (i > Integer.MAX_VALUE - iAvailable) {
            return Integer.MAX_VALUE;
        }
        return i + iAvailable;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this._a != null) {
            this._a.close();
            this._a = null;
        }
        if (this._b != null) {
            _ax._a(this._b);
            this._b = null;
        }
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this._f = i;
        this._e = this._d;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        if (this._d >= this._c) {
            _c();
            if (this._d >= this._c) {
                return -1;
            }
        }
        byte[] bArr = this._b;
        int i = this._d;
        this._d = i + 1;
        return bArr[i] & 255;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0036 A[PHI: r3
      0x0036: PHI (r3v2 int) = (r3v1 int), (r3v7 int) binds: [B:8:0x0018, B:15:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = i + i2;
        if ((i | i2 | i4 | (bArr.length - i4)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i5 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (true) {
            int i6 = i + i5;
            int i7 = i2 - i5;
            int i8 = this._c - this._d;
            if (i8 > 0) {
                int iMin = Math.min(i8, i7);
                System.arraycopy(this._b, this._d, bArr, i6, iMin);
                this._d += iMin;
                i3 = iMin;
            } else if (i7 < this._b.length || this._e >= 0) {
                _c();
                i8 = this._c - this._d;
                if (i8 <= 0) {
                    i3 = -1;
                } else {
                    int iMin2 = Math.min(i8, i7);
                    System.arraycopy(this._b, this._d, bArr, i6, iMin2);
                    this._d += iMin2;
                    i3 = iMin2;
                }
            } else {
                i3 = this._a.read(bArr, i6, i7);
            }
            if (i3 <= 0) {
                return i5 == 0 ? i3 : i5;
            }
            i5 += i3;
            if (i5 >= i2) {
                return i5;
            }
            InputStream inputStream = this._a;
            if (inputStream != null && inputStream.available() <= 0) {
                return i5;
            }
        }
    }

    @Override // java.io.InputStream
    public final void reset() throws IOException {
        int i = this._e;
        if (i < 0) {
            throw new IOException("Resetting to invalid mark");
        }
        this._d = i;
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        long j2 = this._c - this._d;
        if (j2 <= 0) {
            if (this._e < 0) {
                return this._a.skip(j);
            }
            _c();
            j2 = this._c - this._d;
            if (j2 <= 0) {
                return 0L;
            }
        }
        long jMin = Math.min(j2, j);
        this._d = (int) (((long) this._d) + jMin);
        return jMin;
    }
}
