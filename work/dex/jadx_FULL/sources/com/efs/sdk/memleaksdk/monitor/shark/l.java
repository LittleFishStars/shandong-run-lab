package com.efs.sdk.memleaksdk.monitor.shark;

import com.alibaba.ariver.resource.parser.a.e;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class l implements m, n, Cloneable, ByteChannel {
    private static final byte[] c = {e.i, e.j, e.k, e.l, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, 97, 98, 99, 100, 101, 102};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    r f29879a;
    long b;

    public long a() {
        return this.b;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public boolean b() {
        return this.b == 0;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public byte c() {
        long j = this.b;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        r rVar = this.f29879a;
        int i = rVar.b;
        int i2 = rVar.c;
        int i3 = i + 1;
        byte b = rVar.f29884a[i];
        this.b = j - 1;
        if (i3 == i2) {
            this.f29879a = rVar.b();
            s.a(rVar);
        } else {
            rVar.b = i3;
        }
        return b;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, com.efs.sdk.memleaksdk.monitor.shark.v
    public void close() {
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public short d() {
        long j = this.b;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.b);
        }
        r rVar = this.f29879a;
        int i = rVar.b;
        int i2 = rVar.c;
        if (i2 - i < 2) {
            return (short) (((c() & 255) << 8) | (c() & 255));
        }
        byte[] bArr = rVar.f29884a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.b = j - 2;
        if (i4 == i2) {
            this.f29879a = rVar.b();
            s.a(rVar);
        } else {
            rVar.b = i4;
        }
        return (short) i5;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public int e() {
        long j = this.b;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.b);
        }
        r rVar = this.f29879a;
        int i = rVar.b;
        int i2 = rVar.c;
        if (i2 - i < 4) {
            return ((c() & 255) << 24) | ((c() & 255) << 16) | ((c() & 255) << 8) | (c() & 255);
        }
        byte[] bArr = rVar.f29884a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.b = j - 4;
        if (i8 == i2) {
            this.f29879a = rVar.b();
            s.a(rVar);
        } else {
            rVar.b = i8;
        }
        return i9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        long j = this.b;
        if (j != lVar.b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        r rVar = this.f29879a;
        r rVar2 = lVar.f29879a;
        int i = rVar.b;
        int i2 = rVar2.b;
        while (j2 < this.b) {
            long jMin = Math.min(rVar.c - i, rVar2.c - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (rVar.f29884a[i] != rVar2.f29884a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == rVar.c) {
                rVar = rVar.f;
                i = rVar.b;
            }
            if (i2 == rVar2.c) {
                rVar2 = rVar2.f;
                i2 = rVar2.b;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public long f() {
        long j = this.b;
        if (j < 8) {
            throw new IllegalStateException("size < 8: " + this.b);
        }
        r rVar = this.f29879a;
        int i = rVar.b;
        int i2 = rVar.c;
        if (i2 - i < 8) {
            return ((((long) e()) & 4294967295L) << 32) | (4294967295L & ((long) e()));
        }
        byte[] bArr = rVar.f29884a;
        int i3 = i + 1;
        long j2 = (((long) bArr[i]) & 255) << 56;
        int i4 = i3 + 1;
        long j3 = ((((long) bArr[i3]) & 255) << 48) | j2;
        int i5 = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 40);
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24);
        int i8 = i7 + 1;
        long j6 = j5 | ((((long) bArr[i7]) & 255) << 16);
        int i9 = i8 + 1;
        long j7 = j6 | ((((long) bArr[i8]) & 255) << 8);
        int i10 = i9 + 1;
        long j8 = j7 | (((long) bArr[i9]) & 255);
        this.b = j - 8;
        if (i10 == i2) {
            this.f29879a = rVar.b();
            s.a(rVar);
        } else {
            rVar.b = i10;
        }
        return j8;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public void g() {
        try {
            c(this.b);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public l clone() {
        l lVar = new l();
        if (this.b == 0) {
            return lVar;
        }
        r rVarA = this.f29879a.a();
        lVar.f29879a = rVarA;
        rVarA.g = rVarA;
        rVarA.f = rVarA;
        r rVar = this.f29879a;
        while (true) {
            rVar = rVar.f;
            if (rVar == this.f29879a) {
                lVar.b = this.b;
                return lVar;
            }
            lVar.f29879a.g.a(rVar.a());
        }
    }

    public int hashCode() {
        r rVar = this.f29879a;
        if (rVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = rVar.c;
            for (int i3 = rVar.b; i3 < i2; i3++) {
                i = (i * 31) + rVar.f29884a[i3];
            }
            rVar = rVar.f;
        } while (rVar != this.f29879a);
        return i;
    }

    public o i() {
        long j = this.b;
        if (j <= 2147483647L) {
            return b((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.b);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        r rVar = this.f29879a;
        if (rVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), rVar.c - rVar.b);
        byteBuffer.put(rVar.f29884a, rVar.b, iMin);
        int i = rVar.b + iMin;
        rVar.b = i;
        this.b -= (long) iMin;
        if (i == rVar.c) {
            this.f29879a = rVar.b();
            s.a(rVar);
        }
        return iMin;
    }

    public String toString() {
        return i().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            r rVarA = a(1);
            int iMin = Math.min(i, 8192 - rVarA.c);
            byteBuffer.get(rVarA.f29884a, rVarA.c, iMin);
            i -= iMin;
            rVarA.c += iMin;
        }
        this.b += (long) iRemaining;
        return iRemaining;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public String a(long j) throws EOFException {
        return a(j, x.f29887a);
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public byte[] b(long j) throws EOFException {
        x.a(this.b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public String a(long j, Charset charset) throws EOFException {
        x.a(this.b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        r rVar = this.f29879a;
        int i = rVar.b;
        if (((long) i) + j > rVar.c) {
            return new String(b(j), charset);
        }
        String str = new String(rVar.f29884a, i, (int) j, charset);
        int i2 = (int) (((long) rVar.b) + j);
        rVar.b = i2;
        this.b -= j;
        if (i2 == rVar.c) {
            this.f29879a = rVar.b();
            s.a(rVar);
        }
        return str;
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.v
    public long b(l lVar, long j) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.b;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            lVar.a(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    public o b(int i) {
        if (i == 0) {
            return o.b;
        }
        return new t(this, i);
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public void c(long j) throws EOFException {
        while (j > 0) {
            r rVar = this.f29879a;
            if (rVar != null) {
                int iMin = (int) Math.min(j, rVar.c - rVar.b);
                long j2 = iMin;
                this.b -= j2;
                j -= j2;
                r rVar2 = this.f29879a;
                int i = rVar2.b + iMin;
                rVar2.b = i;
                if (i == rVar2.c) {
                    this.f29879a = rVar2.b();
                    s.a(rVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iA = a(bArr, i, bArr.length - i);
            if (iA == -1) {
                throw new EOFException();
            }
            i += iA;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        x.a(bArr.length, i, i2);
        r rVar = this.f29879a;
        if (rVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, rVar.c - rVar.b);
        System.arraycopy(rVar.f29884a, rVar.b, bArr, i, iMin);
        int i3 = rVar.b + iMin;
        rVar.b = i3;
        this.b -= (long) iMin;
        if (i3 == rVar.c) {
            this.f29879a = rVar.b();
            s.a(rVar);
        }
        return iMin;
    }

    public r a(int i) {
        if (i >= 1 && i <= 8192) {
            r rVar = this.f29879a;
            if (rVar == null) {
                r rVarA = s.a();
                this.f29879a = rVarA;
                rVarA.g = rVarA;
                rVarA.f = rVarA;
                return rVarA;
            }
            r rVar2 = rVar.g;
            return (rVar2.c + i > 8192 || !rVar2.e) ? rVar2.a(s.a()) : rVar2;
        }
        throw new IllegalArgumentException();
    }

    public void a(l lVar, long j) {
        if (lVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (lVar != this) {
            x.a(lVar.b, 0L, j);
            while (j > 0) {
                r rVar = lVar.f29879a;
                if (j < rVar.c - rVar.b) {
                    r rVar2 = this.f29879a;
                    r rVar3 = rVar2 != null ? rVar2.g : null;
                    if (rVar3 != null && rVar3.e) {
                        if ((((long) rVar3.c) + j) - ((long) (rVar3.d ? 0 : rVar3.b)) <= 8192) {
                            rVar.a(rVar3, (int) j);
                            lVar.b -= j;
                            this.b += j;
                            return;
                        }
                    }
                    lVar.f29879a = rVar.a((int) j);
                }
                r rVar4 = lVar.f29879a;
                long j2 = rVar4.c - rVar4.b;
                lVar.f29879a = rVar4.b();
                r rVar5 = this.f29879a;
                if (rVar5 == null) {
                    this.f29879a = rVar4;
                    rVar4.g = rVar4;
                    rVar4.f = rVar4;
                } else {
                    rVar5.g.a(rVar4).c();
                }
                lVar.b -= j2;
                this.b += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // com.efs.sdk.memleaksdk.monitor.shark.n
    public long a(byte b) {
        return a(b, 0L, Long.MAX_VALUE);
    }

    public long a(byte b, long j, long j2) {
        r rVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.b;
            long j5 = j2 > j4 ? j4 : j2;
            if (j == j5 || (rVar = this.f29879a) == null) {
                return -1L;
            }
            if (j4 - j < j) {
                while (j4 > j) {
                    rVar = rVar.g;
                    j4 -= (long) (rVar.c - rVar.b);
                }
            } else {
                while (true) {
                    long j6 = ((long) (rVar.c - rVar.b)) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    rVar = rVar.f;
                    j3 = j6;
                }
                j4 = j3;
            }
            long j7 = j;
            while (j4 < j5) {
                byte[] bArr = rVar.f29884a;
                int iMin = (int) Math.min(rVar.c, (((long) rVar.b) + j5) - j4);
                for (int i = (int) ((((long) rVar.b) + j7) - j4); i < iMin; i++) {
                    if (bArr[i] == b) {
                        return ((long) (i - rVar.b)) + j4;
                    }
                }
                j4 += (long) (rVar.c - rVar.b);
                rVar = rVar.f;
                j7 = j4;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.b), Long.valueOf(j), Long.valueOf(j2)));
    }
}
