package com.byazt.jb;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 72})
public final class da implements Closeable {
    public static final Logger tt = Logger.getLogger(n.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28684a;
    public final uj.tt c;
    public final com.byazt.mk.ve n;
    public boolean sp;
    public final boolean uj;
    public final com.byazt.mk.uj ve;

    public da(com.byazt.mk.uj ujVar, boolean z) {
        this.ve = ujVar;
        this.uj = z;
        com.byazt.mk.ve veVar = new com.byazt.mk.ve();
        this.n = veVar;
        this.c = new uj.tt(veVar);
        this.f28684a = 16384;
    }

    public synchronized void c() throws IOException {
        if (this.sp) {
            throw new IOException("closed");
        }
        if (this.uj) {
            Logger logger = tt;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(com.byazt.kh.ve.c(">> CONNECTION %s", n.c.n()));
            }
            this.ve.ve(n.c.x());
            this.ve.flush();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.sp = true;
        this.ve.close();
    }

    public synchronized void tt() throws IOException {
        if (this.sp) {
            throw new IOException("closed");
        }
        this.ve.flush();
    }

    public int ve() {
        return this.f28684a;
    }

    public synchronized void tt(yp ypVar) throws IOException {
        int i;
        if (!this.sp) {
            int i2 = 0;
            c(0, ypVar.tt() * 6, (byte) 4, (byte) 0);
            while (i2 < 10) {
                if (ypVar.c(i2)) {
                    if (i2 == 4) {
                        i = 3;
                    } else {
                        i = i2 == 7 ? 4 : i2;
                    }
                    this.ve.x(i);
                    this.ve.sp(ypVar.tt(i2));
                }
                i2++;
            }
            this.ve.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void c(yp ypVar) throws IOException {
        if (!this.sp) {
            this.f28684a = ypVar.uj(this.f28684a);
            if (ypVar.ve() != -1) {
                this.c.c(ypVar.ve());
            }
            c(0, 0, (byte) 4, (byte) 1);
            this.ve.flush();
        } else {
            throw new IOException("closed");
        }
    }

    private void tt(int i, long j) throws IOException {
        while (j > 0) {
            int iMin = (int) Math.min(this.f28684a, j);
            long j2 = iMin;
            j -= j2;
            c(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.ve.a_(this.n, j2);
        }
    }

    public synchronized void c(int i, int i2, List<ve> list) throws IOException {
        if (!this.sp) {
            this.c.c(list);
            long jTt = this.n.tt();
            int iMin = (int) Math.min(this.f28684a - 4, jTt);
            long j = iMin;
            c(i, iMin + 4, (byte) 5, jTt == j ? (byte) 4 : (byte) 0);
            this.ve.sp(i2 & Integer.MAX_VALUE);
            this.ve.a_(this.n, j);
            if (jTt > j) {
                tt(i, jTt - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void c(boolean z, int i, int i2, List<ve> list) throws IOException {
        if (!this.sp) {
            c(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void c(int i, tt ttVar) throws IOException {
        if (!this.sp) {
            if (ttVar.sp != -1) {
                c(i, 4, (byte) 3, (byte) 0);
                this.ve.sp(ttVar.sp);
                this.ve.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void c(boolean z, int i, com.byazt.mk.ve veVar, int i2) throws IOException {
        if (!this.sp) {
            c(i, z ? (byte) 1 : (byte) 0, veVar, i2);
        } else {
            throw new IOException("closed");
        }
    }

    public void c(int i, byte b, com.byazt.mk.ve veVar, int i2) throws IOException {
        c(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.ve.a_(veVar, i2);
        }
    }

    public synchronized void c(boolean z, int i, int i2) throws IOException {
        if (!this.sp) {
            c(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
            this.ve.sp(i);
            this.ve.sp(i2);
            this.ve.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void c(int i, tt ttVar, byte[] bArr) throws IOException {
        if (!this.sp) {
            if (ttVar.sp != -1) {
                c(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.ve.sp(i);
                this.ve.sp(ttVar.sp);
                if (bArr.length > 0) {
                    this.ve.ve(bArr);
                }
                this.ve.flush();
            } else {
                throw n.c("errorCode.httpCode == -1", new Object[0]);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void c(int i, long j) throws IOException {
        if (this.sp) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            c(i, 4, (byte) 8, (byte) 0);
            this.ve.sp((int) j);
            this.ve.flush();
        } else {
            throw n.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        }
    }

    public void c(int i, int i2, byte b, byte b2) throws IOException {
        Logger logger = tt;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(n.c(false, i, i2, b, b2));
        }
        int i3 = this.f28684a;
        if (i2 > i3) {
            throw n.c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw n.c("reserved bit set: %s", Integer.valueOf(i));
        }
        c(this.ve, i2);
        this.ve.i(b & 255);
        this.ve.i(b2 & 255);
        this.ve.sp(i & Integer.MAX_VALUE);
    }

    private static void c(com.byazt.mk.uj ujVar, int i) throws IOException {
        ujVar.i((i >>> 16) & 255);
        ujVar.i((i >>> 8) & 255);
        ujVar.i(i & 255);
    }

    public void c(boolean z, int i, List<ve> list) throws IOException {
        if (!this.sp) {
            this.c.c(list);
            long jTt = this.n.tt();
            int iMin = (int) Math.min(this.f28684a, jTt);
            long j = iMin;
            byte b = jTt == j ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            c(i, iMin, (byte) 1, b);
            this.ve.a_(this.n, j);
            if (jTt > j) {
                tt(i, jTt - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
