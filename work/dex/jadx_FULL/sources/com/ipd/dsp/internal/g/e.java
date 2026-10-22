package com.ipd.dsp.internal.g;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.q.u;
import com.zj.adlib.aq6;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e extends FilterInputStream {
    public static final int h = 2;
    public static final byte[] i = {-1, u.B7, 0, com.google.common.base.a.F, 69, aq6.f40585a, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, com.google.common.base.a.u, 0, 2, 0, 0, 0, 1, 0};
    public static final int j = 29;
    public static final int k = 31;
    public final byte f;
    public int g;

    public e(InputStream inputStream, int i2) {
        super(inputStream);
        if (i2 >= -1 && i2 <= 8) {
            this.f = (byte) i2;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i2;
        int i3;
        int i4 = this.g;
        if (i4 < 2 || i4 > (i3 = k)) {
            i2 = super.read();
        } else {
            i2 = i4 == i3 ? this.f : i[i4 - 2] & 255;
        }
        if (i2 != -1) {
            this.g++;
        }
        return i2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        long jSkip = super.skip(j2);
        if (jSkip > 0) {
            this.g = (int) (((long) this.g) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.g;
        int i6 = k;
        if (i5 > i6) {
            i4 = super.read(bArr, i2, i3);
        } else if (i5 == i6) {
            bArr[i2] = this.f;
            i4 = 1;
        } else if (i5 < 2) {
            i4 = super.read(bArr, i2, 2 - i5);
        } else {
            int iMin = Math.min(i6 - i5, i3);
            System.arraycopy(i, this.g - 2, bArr, i2, iMin);
            i4 = iMin;
        }
        if (i4 > 0) {
            this.g += i4;
        }
        return i4;
    }
}
