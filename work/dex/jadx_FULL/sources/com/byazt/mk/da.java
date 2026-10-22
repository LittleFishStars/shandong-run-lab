package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 72})
public final class da implements my {
    public int c = 0;
    public final CRC32 n = new CRC32();
    public final n tt;
    public final sl uj;
    public final Inflater ve;

    public da(my myVar) {
        if (myVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        Inflater inflater = new Inflater(true);
        this.ve = inflater;
        n nVarC = t.c(myVar);
        this.tt = nVarC;
        this.uj = new sl(nVarC, inflater);
    }

    private void tt() throws IOException {
        this.tt.c(10L);
        byte bTt = this.tt.ve().tt(3L);
        boolean z = ((bTt >> 1) & 1) == 1;
        if (z) {
            c(this.tt.ve(), 0L, 10L);
        }
        c("ID1ID2", 8075, this.tt.i());
        this.tt.x(8L);
        if (((bTt >> 2) & 1) == 1) {
            this.tt.c(2L);
            if (z) {
                c(this.tt.ve(), 0L, 2L);
            }
            long jSl = this.tt.ve().sl();
            this.tt.c(jSl);
            if (z) {
                c(this.tt.ve(), 0L, jSl);
            }
            this.tt.x(jSl);
        }
        if (((bTt >> 3) & 1) == 1) {
            long jC = this.tt.c((byte) 0);
            if (jC == -1) {
                throw new EOFException();
            }
            if (z) {
                c(this.tt.ve(), 0L, jC + 1);
            }
            this.tt.x(jC + 1);
        }
        if (((bTt >> 4) & 1) == 1) {
            long jC2 = this.tt.c((byte) 0);
            if (jC2 == -1) {
                throw new EOFException();
            }
            if (z) {
                c(this.tt.ve(), 0L, jC2 + 1);
            }
            this.tt.x(jC2 + 1);
        }
        if (z) {
            c("FHCRC", this.tt.sl(), (short) this.n.getValue());
            this.n.reset();
        }
    }

    private void ve() throws IOException {
        c("CRC", this.tt.t(), (int) this.n.getValue());
        c("ISIZE", this.tt.t(), (int) this.ve.getBytesWritten());
    }

    @Override // com.byazt.mk.my
    public long c(ve veVar, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return 0L;
        }
        if (this.c == 0) {
            tt();
            this.c = 1;
        }
        if (this.c == 1) {
            long j2 = veVar.tt;
            long jC = this.uj.c(veVar, j);
            if (jC != -1) {
                c(veVar, j2, jC);
                return jC;
            }
            this.c = 2;
        }
        if (this.c == 2) {
            ve();
            this.c = 3;
            if (!this.tt.n()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.uj.close();
    }

    @Override // com.byazt.mk.my
    public gt c() {
        return this.tt.c();
    }

    private void c(ve veVar, long j, long j2) {
        z zVar = veVar.c;
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
            int i3 = (int) (((long) zVar.tt) + j);
            int iMin = (int) Math.min(zVar.ve - i3, j2);
            this.n.update(zVar.c, i3, iMin);
            j2 -= (long) iMin;
            zVar = zVar.f28794a;
            j = 0;
        }
    }

    private void c(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }
}
