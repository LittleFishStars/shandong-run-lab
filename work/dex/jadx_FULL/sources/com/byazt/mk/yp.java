package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 215})
public final class yp implements n {
    public final ve c = new ve();
    public final my tt;
    public boolean ve;

    public yp(my myVar) {
        if (myVar == null) {
            throw new NullPointerException("source == null");
        }
        this.tt = myVar;
    }

    @Override // com.byazt.mk.n
    public InputStream a() {
        return new InputStream() { // from class: com.byazt.mk.yp.1
            @Override // java.io.InputStream
            public int available() throws IOException {
                yp ypVar = yp.this;
                if (ypVar.ve) {
                    throw new IOException("closed");
                }
                return (int) Math.min(ypVar.c.tt, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                yp.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                yp ypVar = yp.this;
                if (ypVar.ve) {
                    throw new IOException("closed");
                }
                ve veVar = ypVar.c;
                if (veVar.tt == 0 && ypVar.tt.c(veVar, 8192L) == -1) {
                    return -1;
                }
                return yp.this.c.x() & 255;
            }

            public String toString() {
                return yp.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!yp.this.ve) {
                    rl.c(bArr.length, i, i2);
                    yp ypVar = yp.this;
                    ve veVar = ypVar.c;
                    if (veVar.tt == 0 && ypVar.tt.c(veVar, 8192L) == -1) {
                        return -1;
                    }
                    return yp.this.c.c(bArr, i, i2);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // com.byazt.mk.my
    public long c(ve veVar, long j) throws IOException {
        if (veVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        ve veVar2 = this.c;
        if (veVar2.tt == 0 && this.tt.c(veVar2, 8192L) == -1) {
            return -1L;
        }
        return this.c.c(veVar, Math.min(j, this.c.tt));
    }

    @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.ve) {
            return;
        }
        this.ve = true;
        this.tt.close();
        this.c.rh();
    }

    @Override // com.byazt.mk.n
    public int da() throws IOException {
        c(4L);
        return this.c.da();
    }

    @Override // com.byazt.mk.n
    public short i() throws IOException {
        c(2L);
        return this.c.i();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.ve;
    }

    @Override // com.byazt.mk.n
    public String m() throws IOException {
        return n(Long.MAX_VALUE);
    }

    @Override // com.byazt.mk.n
    public boolean n() throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        return this.c.n() && this.tt.c(this.c, 8192L) == -1;
    }

    @Override // com.byazt.mk.n
    public byte[] nu() throws IOException {
        this.c.c(this.tt);
        return this.c.nu();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        ve veVar = this.c;
        if (veVar.tt == 0 && this.tt.c(veVar, 8192L) == -1) {
            return -1;
        }
        return this.c.read(byteBuffer);
    }

    @Override // com.byazt.mk.n
    public short sl() throws IOException {
        c(2L);
        return this.c.sl();
    }

    @Override // com.byazt.mk.n
    public byte[] sp(long j) throws IOException {
        c(j);
        return this.c.sp(j);
    }

    @Override // com.byazt.mk.n
    public int t() throws IOException {
        c(4L);
        return this.c.t();
    }

    public String toString() {
        return "buffer(" + this.tt + ")";
    }

    public boolean tt(long j) throws IOException {
        ve veVar;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        do {
            veVar = this.c;
            if (veVar.tt >= j) {
                return true;
            }
        } while (this.tt.c(veVar, 8192L) != -1);
        return false;
    }

    @Override // com.byazt.mk.n
    public long u() throws IOException {
        c(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!tt(i2)) {
                break;
            }
            byte bTt = this.c.tt(i);
            if ((bTt < 48 || bTt > 57) && ((bTt < 97 || bTt > 102) && (bTt < 65 || bTt > 70))) {
                if (i != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bTt)));
            }
            i = i2;
        }
        return this.c.u();
    }

    @Override // com.byazt.mk.n, com.byazt.mk.uj
    public ve ve() {
        return this.c;
    }

    @Override // com.byazt.mk.n
    public byte x() throws IOException {
        c(1L);
        return this.c.x();
    }

    @Override // com.byazt.mk.n
    public a ve(long j) throws IOException {
        c(j);
        return this.c.ve(j);
    }

    @Override // com.byazt.mk.n
    public void x(long j) throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            ve veVar = this.c;
            if (veVar.tt == 0 && this.tt.c(veVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.c.tt());
            this.c.x(jMin);
            j -= jMin;
        }
    }

    @Override // com.byazt.mk.n
    public String n(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            long jC = c((byte) 10, 0L, j2);
            if (jC != -1) {
                return this.c.a(jC);
            }
            if (j2 < Long.MAX_VALUE && tt(j2) && this.c.tt(j2 - 1) == 13 && tt(1 + j2) && this.c.tt(j2) == 10) {
                return this.c.a(j2);
            }
            ve veVar = new ve();
            ve veVar2 = this.c;
            veVar2.c(veVar, 0L, Math.min(32L, veVar2.tt()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.c.tt(), j) + " content=" + veVar.yp().n() + (char) 8230);
        }
        throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
    }

    @Override // com.byazt.mk.n
    public void c(long j) throws IOException {
        if (!tt(j)) {
            throw new EOFException();
        }
    }

    @Override // com.byazt.mk.n
    public void c(byte[] bArr) throws IOException {
        try {
            c(bArr.length);
            this.c.c(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                ve veVar = this.c;
                long j = veVar.tt;
                if (j > 0) {
                    int iC = veVar.c(bArr, i, (int) j);
                    if (iC == -1) {
                        throw new AssertionError();
                    }
                    i += iC;
                } else {
                    throw e;
                }
            }
        }
    }

    @Override // com.byazt.mk.n
    public String c(Charset charset) throws IOException {
        if (charset != null) {
            this.c.c(this.tt);
            return this.c.c(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // com.byazt.mk.n
    public long c(byte b) throws IOException {
        return c(b, 0L, Long.MAX_VALUE);
    }

    public long c(byte b, long j, long j2) throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jC = this.c.c(b, j, j2);
            if (jC != -1) {
                return jC;
            }
            ve veVar = this.c;
            long j3 = veVar.tt;
            if (j3 >= j2 || this.tt.c(veVar, 8192L) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // com.byazt.mk.n
    public boolean c(long j, a aVar) throws IOException {
        return c(j, aVar, 0, aVar.sp());
    }

    public boolean c(long j, a aVar, int i, int i2) throws IOException {
        if (!this.ve) {
            if (j < 0 || i < 0 || i2 < 0 || aVar.sp() - i < i2) {
                return false;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = ((long) i3) + j;
                if (!tt(1 + j2) || this.c.tt(j2) != aVar.c(i + i3)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.byazt.mk.my
    public gt c() {
        return this.tt.c();
    }
}
