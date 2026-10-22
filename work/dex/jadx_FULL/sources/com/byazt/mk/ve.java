package com.byazt.mk;

import com.alibaba.ariver.resource.parser.a.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 54})
public final class ve implements n, uj, Cloneable, ByteChannel {
    public static final byte[] ve = {e.i, e.j, e.k, e.l, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, 97, 98, 99, 100, 101, 102};
    public z c;
    public long tt;

    @Override // com.byazt.mk.n
    public InputStream a() {
        return new InputStream() { // from class: com.byazt.mk.ve.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(ve.this.tt, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                ve veVar = ve.this;
                if (veVar.tt > 0) {
                    return veVar.x() & 255;
                }
                return -1;
            }

            public String toString() {
                return ve.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return ve.this.c(bArr, i, i2);
            }
        };
    }

    @Override // com.byazt.mk.rh
    public void a_(ve veVar, long j) {
        z zVar;
        if (veVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (veVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        rl.c(veVar.tt, 0L, j);
        while (j > 0 && (zVar = veVar.c) != null) {
            if (j < zVar.ve - zVar.tt) {
                z zVar2 = this.c;
                z zVar3 = zVar2 != null ? zVar2.sp : null;
                if (zVar3 != null && zVar3.n) {
                    if ((((long) zVar3.ve) + j) - ((long) (zVar3.uj ? 0 : zVar3.tt)) <= 8192) {
                        zVar.c(zVar3, (int) j);
                        veVar.tt -= j;
                        this.tt += j;
                        return;
                    }
                }
                veVar.c = zVar.c((int) j);
            }
            z zVar4 = veVar.c;
            long j2 = zVar4.ve - zVar4.tt;
            veVar.c = zVar4.tt();
            z zVar5 = this.c;
            if (zVar5 == null) {
                this.c = zVar4;
                zVar4.sp = zVar4;
                zVar4.f28794a = zVar4;
            } else {
                zVar5.sp.c(zVar4).ve();
            }
            veVar.tt -= j2;
            this.tt += j2;
            j -= j2;
        }
    }

    @Override // com.byazt.mk.n
    public void c(long j) throws EOFException {
        if (this.tt < j) {
            throw new EOFException();
        }
    }

    @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.byazt.mk.n
    public int da() {
        long j = this.tt;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.tt);
        }
        z zVar = this.c;
        int i = zVar.tt;
        int i2 = zVar.ve;
        if (i2 - i < 4) {
            return ((x() & 255) << 24) | ((x() & 255) << 16) | ((x() & 255) << 8) | (x() & 255);
        }
        byte[] bArr = zVar.c;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.tt = j - 4;
        if (i8 == i2) {
            this.c = zVar.tt();
            m.c(zVar);
        } else {
            zVar.tt = i8;
        }
        return i9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ve)) {
            return false;
        }
        ve veVar = (ve) obj;
        long j = this.tt;
        if (j != veVar.tt) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        z zVar = this.c;
        z zVar2 = veVar.c;
        int i = zVar.tt;
        int i2 = zVar2.tt;
        while (j2 < this.tt) {
            long jMin = Math.min(zVar.ve - i, zVar2.ve - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (zVar.c[i] != zVar2.c[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == zVar.ve) {
                zVar = zVar.f28794a;
                i = zVar.tt;
            }
            if (i2 == zVar2.ve) {
                zVar2 = zVar2.f28794a;
                i2 = zVar2.tt;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // com.byazt.mk.uj, com.byazt.mk.rh, java.io.Flushable
    public void flush() {
    }

    public final a gt() {
        long j = this.tt;
        if (j <= 2147483647L) {
            return a((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.tt);
    }

    public int hashCode() {
        z zVar = this.c;
        if (zVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = zVar.ve;
            for (int i3 = zVar.tt; i3 < i2; i3++) {
                i = (i * 31) + zVar.c[i3];
            }
            zVar = zVar.f28794a;
        } while (zVar != this.c);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.byazt.mk.n
    public String m() throws EOFException {
        return n(Long.MAX_VALUE);
    }

    /* JADX INFO: renamed from: my, reason: merged with bridge method [inline-methods] */
    public ve clone() {
        ve veVar = new ve();
        if (this.tt == 0) {
            return veVar;
        }
        z zVarC = this.c.c();
        veVar.c = zVarC;
        zVarC.sp = zVarC;
        zVarC.f28794a = zVarC;
        z zVar = this.c;
        while (true) {
            zVar = zVar.f28794a;
            if (zVar == this.c) {
                veVar.tt = this.tt;
                return veVar;
            }
            veVar.c.sp.c(zVar.c());
        }
    }

    @Override // com.byazt.mk.n
    public boolean n() {
        return this.tt == 0;
    }

    @Override // com.byazt.mk.n
    public byte[] nu() throws EOFException {
        try {
            return sp(this.tt);
        } catch (EOFException e) {
            throw e;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        z zVar = this.c;
        if (zVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), zVar.ve - zVar.tt);
        byteBuffer.put(zVar.c, zVar.tt, iMin);
        int i = zVar.tt + iMin;
        zVar.tt = i;
        this.tt -= (long) iMin;
        if (i == zVar.ve) {
            this.c = zVar.tt();
            m.c(zVar);
        }
        return iMin;
    }

    public final void rh() {
        try {
            x(this.tt);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String toString() {
        return gt().toString();
    }

    @Override // com.byazt.mk.n
    public long u() {
        int i;
        int i2;
        if (this.tt == 0) {
            throw new IllegalStateException("size == 0");
        }
        int i3 = 0;
        boolean z = false;
        long j = 0;
        do {
            z zVar = this.c;
            byte[] bArr = zVar.c;
            int i4 = zVar.tt;
            int i5 = zVar.ve;
            while (i4 < i5) {
                byte b = bArr[i4];
                if (b < 48 || b > 57) {
                    if (b >= 97 && b <= 102) {
                        i = b - 97;
                    } else {
                        if (b < 65 || b > 70) {
                            if (i3 != 0) {
                                z = true;
                                break;
                            }
                            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(b));
                        }
                        i = b - 65;
                    }
                    i2 = i + 10;
                } else {
                    i2 = b - 48;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    throw new NumberFormatException("Number too large: " + new ve().sl(j).i((int) b).z());
                }
                j = (j << 4) | ((long) i2);
                i4++;
                i3++;
            }
            if (i4 == i5) {
                this.c = zVar.tt();
                m.c(zVar);
            } else {
                zVar.tt = i4;
            }
            if (z) {
                break;
            }
        } while (this.c != null);
        this.tt -= (long) i3;
        return j;
    }

    @Override // com.byazt.mk.uj
    /* JADX INFO: renamed from: uj, reason: merged with bridge method [inline-methods] */
    public ve rl() {
        return this;
    }

    public String uj(long j) throws EOFException {
        return c(j, rl.c);
    }

    @Override // com.byazt.mk.n, com.byazt.mk.uj
    public ve ve() {
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            z zVarN = n(1);
            int iMin = Math.min(i, 8192 - zVarN.ve);
            byteBuffer.get(zVarN.c, zVarN.ve, iMin);
            i -= iMin;
            zVarN.ve += iMin;
        }
        this.tt += (long) iRemaining;
        return iRemaining;
    }

    public a yp() throws EOFException {
        return new a(nu());
    }

    public String z() {
        try {
            return c(this.tt, rl.c);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String a(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (tt(j2) == 13) {
                String strUj = uj(j2);
                x(2L);
                return strUj;
            }
        }
        String strUj2 = uj(j);
        x(1L);
        return strUj2;
    }

    public final ve c(ve veVar, long j, long j2) {
        if (veVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        rl.c(this.tt, j, j2);
        if (j2 == 0) {
            return this;
        }
        veVar.tt += j2;
        z zVar = this.c;
        while (true) {
            int i = zVar.ve;
            int i2 = zVar.tt;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            zVar = zVar.f28794a;
        }
        while (j2 > 0) {
            z zVarC = zVar.c();
            int i3 = (int) (((long) zVarC.tt) + j);
            zVarC.tt = i3;
            zVarC.ve = Math.min(i3 + ((int) j2), zVarC.ve);
            z zVar2 = veVar.c;
            if (zVar2 == null) {
                zVarC.sp = zVarC;
                zVarC.f28794a = zVarC;
                veVar.c = zVarC;
            } else {
                zVar2.sp.c(zVarC);
            }
            j2 -= (long) (zVarC.ve - zVarC.tt);
            zVar = zVar.f28794a;
            j = 0;
        }
        return this;
    }

    @Override // com.byazt.mk.n
    public short i() {
        long j = this.tt;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.tt);
        }
        z zVar = this.c;
        int i = zVar.tt;
        int i2 = zVar.ve;
        if (i2 - i < 2) {
            return (short) (((x() & 255) << 8) | (x() & 255));
        }
        byte[] bArr = zVar.c;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.tt = j - 2;
        if (i4 == i2) {
            this.c = zVar.tt();
            m.c(zVar);
        } else {
            zVar.tt = i4;
        }
        return (short) i5;
    }

    @Override // com.byazt.mk.n
    public String n(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jC = c((byte) 10, 0L, j2);
        if (jC != -1) {
            return a(jC);
        }
        if (j2 < tt() && tt(j2 - 1) == 13 && tt(j2) == 10) {
            return a(j2);
        }
        ve veVar = new ve();
        c(veVar, 0L, Math.min(32L, tt()));
        throw new EOFException("\\n not found: limit=" + Math.min(tt(), j) + " content=" + veVar.yp().n() + (char) 8230);
    }

    @Override // com.byazt.mk.n
    public short sl() {
        return rl.c(i());
    }

    public final long sp() {
        long j = this.tt;
        if (j == 0) {
            return 0L;
        }
        z zVar = this.c.sp;
        int i = zVar.ve;
        return (i >= 8192 || !zVar.n) ? j : j - ((long) (i - zVar.tt));
    }

    @Override // com.byazt.mk.n
    public int t() {
        return rl.c(da());
    }

    @Override // com.byazt.mk.uj
    /* JADX INFO: renamed from: uj, reason: merged with bridge method [inline-methods] */
    public ve sp(int i) {
        z zVarN = n(4);
        byte[] bArr = zVarN.c;
        int i2 = zVarN.ve;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        zVarN.ve = i5 + 1;
        this.tt += 4;
        return this;
    }

    @Override // com.byazt.mk.n
    public byte x() {
        long j = this.tt;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        z zVar = this.c;
        int i = zVar.tt;
        int i2 = zVar.ve;
        int i3 = i + 1;
        byte b = zVar.c[i];
        this.tt = j - 1;
        if (i3 == i2) {
            this.c = zVar.tt();
            m.c(zVar);
        } else {
            zVar.tt = i3;
        }
        return b;
    }

    public final long tt() {
        return this.tt;
    }

    @Override // com.byazt.mk.n
    public a ve(long j) throws EOFException {
        return new a(sp(j));
    }

    public final byte tt(long j) {
        int i;
        rl.c(this.tt, j, 1L);
        long j2 = this.tt;
        if (j2 - j > j) {
            z zVar = this.c;
            while (true) {
                int i2 = zVar.ve;
                int i3 = zVar.tt;
                long j3 = i2 - i3;
                if (j < j3) {
                    return zVar.c[i3 + ((int) j)];
                }
                j -= j3;
                zVar = zVar.f28794a;
            }
        } else {
            long j4 = j - j2;
            try {
                z zVar2 = this.c;
                do {
                    zVar2 = zVar2.sp;
                    int i4 = zVar2.ve;
                    i = zVar2.tt;
                    j4 += (long) (i4 - i);
                } while (j4 < 0);
                return zVar2.c[i + ((int) j4)];
            } catch (NullPointerException unused) {
                return (byte) 0;
            }
        }
    }

    @Override // com.byazt.mk.uj
    /* JADX INFO: renamed from: ve, reason: merged with bridge method [inline-methods] */
    public ve x(int i) {
        z zVarN = n(2);
        byte[] bArr = zVarN.c;
        int i2 = zVarN.ve;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        zVarN.ve = i3 + 1;
        this.tt += 2;
        return this;
    }

    @Override // com.byazt.mk.n
    public byte[] sp(long j) throws EOFException {
        rl.c(this.tt, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            c(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
    }

    public final a a(int i) {
        if (i == 0) {
            return a.tt;
        }
        return new nu(this, i);
    }

    public z n(int i) {
        if (i > 0 && i <= 8192) {
            z zVar = this.c;
            if (zVar == null) {
                z zVarC = m.c();
                this.c = zVarC;
                zVarC.sp = zVarC;
                zVarC.f28794a = zVarC;
                return zVarC;
            }
            z zVar2 = zVar.sp;
            return (zVar2.ve + i > 8192 || !zVar2.n) ? zVar2.c(m.c()) : zVar2;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.byazt.mk.uj
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public ve ve(byte[] bArr) {
        if (bArr != null) {
            return ve(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.byazt.mk.n
    public void x(long j) throws EOFException {
        z zVar;
        while (j > 0 && (zVar = this.c) != null) {
            int iMin = (int) Math.min(j, zVar.ve - zVar.tt);
            long j2 = iMin;
            this.tt -= j2;
            j -= j2;
            z zVar2 = this.c;
            int i = zVar2.tt + iMin;
            zVar2.tt = i;
            if (i == zVar2.ve) {
                this.c = zVar2.tt();
                m.c(zVar2);
            }
        }
    }

    @Override // com.byazt.mk.n
    public String c(Charset charset) {
        try {
            return c(this.tt, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // com.byazt.mk.uj
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public ve t(long j) {
        boolean z;
        if (j == 0) {
            return i(48);
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return tt("-9223372036854775808");
            }
            z = true;
        } else {
            z = false;
        }
        if (j < 100000000) {
            if (j < 10000) {
                if (j >= 100) {
                    i = j < 1000 ? 3 : 4;
                } else if (j >= 10) {
                    i = 2;
                }
            } else if (j < 1000000) {
                i = j < 100000 ? 5 : 6;
            } else {
                i = j < 10000000 ? 7 : 8;
            }
        } else if (j < 1000000000000L) {
            if (j < 10000000000L) {
                i = j < 1000000000 ? 9 : 10;
            } else {
                i = j < 100000000000L ? 11 : 12;
            }
        } else if (j < 1000000000000000L) {
            if (j < 10000000000000L) {
                i = 13;
            } else {
                i = j < 100000000000000L ? 14 : 15;
            }
        } else if (j < 100000000000000000L) {
            i = j < 10000000000000000L ? 16 : 17;
        } else {
            i = j < 1000000000000000000L ? 18 : 19;
        }
        if (z) {
            i++;
        }
        z zVarN = n(i);
        byte[] bArr = zVarN.c;
        int i2 = zVarN.ve + i;
        while (j != 0) {
            i2--;
            bArr[i2] = ve[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = com.google.android.exoplayer2.text.cea.a.n;
        }
        zVarN.ve += i;
        this.tt += (long) i;
        return this;
    }

    @Override // com.byazt.mk.uj
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public ve ve(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            rl.c(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                z zVarN = n(1);
                int iMin = Math.min(i3 - i, 8192 - zVarN.ve);
                System.arraycopy(bArr, i, zVarN.c, zVarN.ve, iMin);
                i += iMin;
                zVarN.ve += iMin;
            }
            this.tt += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // com.byazt.mk.uj
    /* JADX INFO: renamed from: da, reason: merged with bridge method [inline-methods] */
    public ve sl(long j) {
        if (j == 0) {
            return i(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        z zVarN = n(iNumberOfTrailingZeros);
        byte[] bArr = zVarN.c;
        int i = zVarN.ve;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = ve[(int) (15 & j)];
            j >>>= 4;
        }
        zVarN.ve += iNumberOfTrailingZeros;
        this.tt += (long) iNumberOfTrailingZeros;
        return this;
    }

    public String c(long j, Charset charset) throws EOFException {
        rl.c(this.tt, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        z zVar = this.c;
        int i = zVar.tt;
        if (((long) i) + j > zVar.ve) {
            return new String(sp(j), charset);
        }
        String str = new String(zVar.c, i, (int) j, charset);
        int i2 = (int) (((long) zVar.tt) + j);
        zVar.tt = i2;
        this.tt -= j;
        if (i2 == zVar.ve) {
            this.c = zVar.tt();
            m.c(zVar);
        }
        return str;
    }

    @Override // com.byazt.mk.uj
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public ve i(int i) {
        z zVarN = n(1);
        byte[] bArr = zVarN.c;
        int i2 = zVarN.ve;
        zVarN.ve = i2 + 1;
        bArr[i2] = (byte) i;
        this.tt++;
        return this;
    }

    @Override // com.byazt.mk.n
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

    public int c(byte[] bArr, int i, int i2) {
        rl.c(bArr.length, i, i2);
        z zVar = this.c;
        if (zVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, zVar.ve - zVar.tt);
        System.arraycopy(zVar.c, zVar.tt, bArr, i, iMin);
        int i3 = zVar.tt + iMin;
        zVar.tt = i3;
        this.tt -= (long) iMin;
        if (i3 == zVar.ve) {
            this.c = zVar.tt();
            m.c(zVar);
        }
        return iMin;
    }

    @Override // com.byazt.mk.uj
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ve tt(a aVar) {
        if (aVar != null) {
            aVar.c(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.byazt.mk.uj
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ve tt(String str) {
        return c(str, 0, str.length());
    }

    public ve c(String str, int i, int i2) {
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
                    z zVarN = n(1);
                    byte[] bArr = zVarN.c;
                    int i3 = zVarN.ve - i;
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
                    int i5 = zVarN.ve;
                    int i6 = (i3 + i) - i5;
                    zVarN.ve = i5 + i6;
                    this.tt += (long) i6;
                } else {
                    if (cCharAt2 < 2048) {
                        i((cCharAt2 >> 6) | 192);
                        i((cCharAt2 & '?') | 128);
                    } else if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        int i7 = i + 1;
                        char cCharAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (cCharAt2 <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i8 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                            i((i8 >> 18) | 240);
                            i(((i8 >> 12) & 63) | 128);
                            i(((i8 >> 6) & 63) | 128);
                            i((i8 & 63) | 128);
                            i += 2;
                        } else {
                            i(63);
                            i = i7;
                        }
                    } else {
                        i((cCharAt2 >> '\f') | 224);
                        i(((cCharAt2 >> 6) & 63) | 128);
                        i((cCharAt2 & '?') | 128);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public ve c(int i) {
        if (i < 128) {
            i(i);
        } else if (i < 2048) {
            i((i >> 6) | 192);
            i((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                i(63);
            } else {
                i((i >> 12) | 224);
                i(((i >> 6) & 63) | 128);
                i((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            i((i >> 18) | 240);
            i(((i >> 12) & 63) | 128);
            i(((i >> 6) & 63) | 128);
            i((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public ve c(String str, int i, int i2, Charset charset) {
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
                if (charset.equals(rl.c)) {
                    return c(str, i, i2);
                }
                byte[] bytes = str.substring(i, i2).getBytes(charset);
                return ve(bytes, 0, bytes.length);
            }
            throw new IllegalArgumentException("charset == null");
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public long c(my myVar) throws IOException {
        if (myVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jC = myVar.c(this, 8192L);
            if (jC == -1) {
                return j;
            }
            j += jC;
        }
    }

    @Override // com.byazt.mk.my
    public long c(ve veVar, long j) {
        if (veVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.tt;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            veVar.a_(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
    }

    @Override // com.byazt.mk.n
    public long c(byte b) {
        return c(b, 0L, Long.MAX_VALUE);
    }

    public long c(byte b, long j, long j2) {
        z zVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.tt;
            long j5 = j2 > j4 ? j4 : j2;
            if (j == j5 || (zVar = this.c) == null) {
                return -1L;
            }
            if (j4 - j < j) {
                while (j4 > j) {
                    zVar = zVar.sp;
                    j4 -= (long) (zVar.ve - zVar.tt);
                }
            } else {
                while (true) {
                    long j6 = ((long) (zVar.ve - zVar.tt)) + j3;
                    if (j6 >= j) {
                        break;
                    }
                    zVar = zVar.f28794a;
                    j3 = j6;
                }
                j4 = j3;
            }
            long j7 = j;
            while (j4 < j5) {
                byte[] bArr = zVar.c;
                int iMin = (int) Math.min(zVar.ve, (((long) zVar.tt) + j5) - j4);
                for (int i = (int) ((((long) zVar.tt) + j7) - j4); i < iMin; i++) {
                    if (bArr[i] == b) {
                        return ((long) (i - zVar.tt)) + j4;
                    }
                }
                j4 += (long) (zVar.ve - zVar.tt);
                zVar = zVar.f28794a;
                j7 = j4;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.tt), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // com.byazt.mk.n
    public boolean c(long j, a aVar) {
        return c(j, aVar, 0, aVar.sp());
    }

    public boolean c(long j, a aVar, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.tt - j < i2 || aVar.sp() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (tt(((long) i3) + j) != aVar.c(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.byazt.mk.my
    public gt c() {
        return gt.ve;
    }
}
