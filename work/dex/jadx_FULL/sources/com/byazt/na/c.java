package com.byazt.na;

import com.alibaba.ariver.resource.parser.a.e;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 662, 20})
public final class c implements tt, ve, Cloneable, ByteChannel {
    public static final byte[] ve = {e.i, e.j, e.k, e.l, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, 97, 98, 99, 100, 101, 102};
    public a c;
    public long tt;

    public boolean c() {
        return this.tt == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.tt;
        if (j != cVar.tt) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        a aVar = this.c;
        a aVar2 = cVar.c;
        int i = aVar.tt;
        int i2 = aVar2.tt;
        while (j2 < this.tt) {
            long jMin = Math.min(aVar.ve - i, aVar2.ve - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (aVar.c[i] != aVar2.c[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == aVar.ve) {
                aVar = aVar.f28805a;
                i = aVar.tt;
            }
            if (i2 == aVar2.ve) {
                aVar2 = aVar2.f28805a;
                i2 = aVar2.tt;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        a aVar = this.c;
        if (aVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = aVar.ve;
            for (int i3 = aVar.tt; i3 < i2; i3++) {
                i = (i * 31) + aVar.c[i3];
            }
            aVar = aVar.f28805a;
        } while (aVar != this.c);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final uj n() {
        long j = this.tt;
        if (j <= 2147483647L) {
            return uj((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.tt);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        a aVar = this.c;
        if (aVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), aVar.ve - aVar.tt);
        byteBuffer.put(aVar.c, aVar.tt, iMin);
        int i = aVar.tt + iMin;
        aVar.tt = i;
        this.tt -= (long) iMin;
        if (i == aVar.ve) {
            this.c = aVar.tt();
            sp.c(aVar);
        }
        return iMin;
    }

    public String toString() {
        return n().toString();
    }

    public byte tt() {
        long j = this.tt;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        a aVar = this.c;
        int i = aVar.tt;
        int i2 = aVar.ve;
        int i3 = i + 1;
        byte b = aVar.c[i];
        this.tt = j - 1;
        if (i3 == i2) {
            this.c = aVar.tt();
            sp.c(aVar);
        } else {
            aVar.tt = i3;
        }
        return b;
    }

    /* JADX INFO: renamed from: uj, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c();
        if (this.tt == 0) {
            return cVar;
        }
        a aVarC = this.c.c();
        cVar.c = aVarC;
        aVarC.sp = aVarC;
        aVarC.f28805a = aVarC;
        a aVar = this.c;
        while (true) {
            aVar = aVar.f28805a;
            if (aVar == this.c) {
                cVar.tt = this.tt;
                return cVar;
            }
            cVar.c.sp.c(aVar.c());
        }
    }

    public String ve() {
        try {
            return c(this.tt, da.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            a aVarVe = ve(1);
            int iMin = Math.min(i, 8192 - aVarVe.ve);
            byteBuffer.get(aVarVe.c, aVarVe.ve, iMin);
            i -= iMin;
            aVarVe.ve += iMin;
        }
        this.tt += (long) iRemaining;
        return iRemaining;
    }

    public String c(long j, Charset charset) throws EOFException {
        da.c(this.tt, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        a aVar = this.c;
        int i = aVar.tt;
        if (((long) i) + j > aVar.ve) {
            return new String(c(j), charset);
        }
        String str = new String(aVar.c, i, (int) j, charset);
        int i2 = (int) (((long) aVar.tt) + j);
        aVar.tt = i2;
        this.tt -= j;
        if (i2 == aVar.ve) {
            this.c = aVar.tt();
            sp.c(aVar);
        }
        return str;
    }

    public a ve(int i) {
        if (i > 0 && i <= 8192) {
            a aVar = this.c;
            if (aVar == null) {
                a aVarC = sp.c();
                this.c = aVarC;
                aVarC.sp = aVarC;
                aVarC.f28805a = aVarC;
                return aVarC;
            }
            a aVar2 = aVar.sp;
            return (aVar2.ve + i > 8192 || !aVar2.n) ? aVar2.c(sp.c()) : aVar2;
        }
        throw new IllegalArgumentException();
    }

    public final uj uj(int i) {
        if (i == 0) {
            return uj.ve;
        }
        return new x(this, i);
    }

    public c tt(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            da.c(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                a aVarVe = ve(1);
                int iMin = Math.min(i3 - i, 8192 - aVarVe.ve);
                System.arraycopy(bArr, i, aVarVe.c, aVarVe.ve, iMin);
                i += iMin;
                aVarVe.ve += iMin;
            }
            this.tt += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public byte[] c(long j) throws EOFException {
        da.c(this.tt, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            c(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
    }

    public void c(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iC = c(bArr, i, bArr.length - i);
            if (iC == -1) {
                throw new EOFException();
            }
            i += iC;
        }
    }

    public c tt(int i) {
        a aVarVe = ve(1);
        byte[] bArr = aVarVe.c;
        int i2 = aVarVe.ve;
        aVarVe.ve = i2 + 1;
        bArr[i2] = (byte) i;
        this.tt++;
        return this;
    }

    public int c(byte[] bArr, int i, int i2) {
        da.c(bArr.length, i, i2);
        a aVar = this.c;
        if (aVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, aVar.ve - aVar.tt);
        System.arraycopy(aVar.c, aVar.tt, bArr, i, iMin);
        int i3 = aVar.tt + iMin;
        aVar.tt = i3;
        this.tt -= (long) iMin;
        if (i3 == aVar.ve) {
            this.c = aVar.tt();
            sp.c(aVar);
        }
        return iMin;
    }

    public c tt(long j) {
        if (j == 0) {
            return tt(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        a aVarVe = ve(iNumberOfTrailingZeros);
        byte[] bArr = aVarVe.c;
        int i = aVarVe.ve;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = ve[(int) (15 & j)];
            j >>>= 4;
        }
        aVarVe.ve += iNumberOfTrailingZeros;
        this.tt += (long) iNumberOfTrailingZeros;
        return this;
    }

    public c c(String str) {
        return c(str, 0, str.length());
    }

    public c c(String str, int i, int i2) {
        char cCharAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            while (i < i2) {
                char cCharAt2 = str.charAt(i);
                if (cCharAt2 < 128) {
                    a aVarVe = ve(1);
                    byte[] bArr = aVarVe.c;
                    int i3 = aVarVe.ve - i;
                    int iMin = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt2;
                    while (true) {
                        i = i4;
                        if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                            break;
                        }
                        i4 = i + 1;
                        bArr[i + i3] = (byte) cCharAt;
                    }
                    int i5 = aVarVe.ve;
                    int i6 = (i3 + i) - i5;
                    aVarVe.ve = i5 + i6;
                    this.tt += (long) i6;
                } else {
                    if (cCharAt2 < 2048) {
                        tt((cCharAt2 >> 6) | 192);
                        tt((cCharAt2 & '?') | 128);
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i7 = i + 1;
                        char cCharAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (cCharAt2 <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i8 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                            tt((i8 >> 18) | 240);
                            tt(((i8 >> 12) & 63) | 128);
                            tt(((i8 >> 6) & 63) | 128);
                            tt((i8 & 63) | 128);
                            i += 2;
                        } else {
                            tt(63);
                            i = i7;
                        }
                    } else {
                        tt((cCharAt2 >> '\f') | 224);
                        tt(((cCharAt2 >> 6) & 63) | 128);
                        tt((cCharAt2 & '?') | 128);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public c c(int i) {
        if (i < 128) {
            tt(i);
        } else if (i < 2048) {
            tt((i >> 6) | 192);
            tt((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                tt(63);
            } else {
                tt((i >> 12) | 224);
                tt(((i >> 6) & 63) | 128);
                tt((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            tt((i >> 18) | 240);
            tt(((i >> 12) & 63) | 128);
            tt(((i >> 6) & 63) | 128);
            tt((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public c c(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            if (charset != null) {
                if (charset.equals(da.c)) {
                    return c(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return tt(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }
}
