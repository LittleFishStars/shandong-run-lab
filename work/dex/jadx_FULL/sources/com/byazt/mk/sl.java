package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 158})
public final class sl implements my {
    public final n c;
    public final Inflater tt;
    public boolean uj;
    public int ve;

    public sl(n nVar, Inflater inflater) {
        if (nVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        }
        this.c = nVar;
        this.tt = inflater;
    }

    private void ve() throws IOException {
        int i = this.ve;
        if (i == 0) {
            return;
        }
        int remaining = i - this.tt.getRemaining();
        this.ve -= remaining;
        this.c.x(remaining);
    }

    @Override // com.byazt.mk.my
    public long c(ve veVar, long j) throws IOException {
        boolean zTt;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.uj) {
            throw new IllegalStateException("closed");
        }
        if (j == 0) {
            return 0L;
        }
        do {
            zTt = tt();
            try {
                z zVarN = veVar.n(1);
                int iInflate = this.tt.inflate(zVarN.c, zVarN.ve, (int) Math.min(j, 8192 - zVarN.ve));
                if (iInflate > 0) {
                    zVarN.ve += iInflate;
                    long j2 = iInflate;
                    veVar.tt += j2;
                    return j2;
                }
                if (!this.tt.finished() && !this.tt.needsDictionary()) {
                }
                ve();
                if (zVarN.tt != zVarN.ve) {
                    return -1L;
                }
                veVar.c = zVarN.tt();
                m.c(zVarN);
                return -1L;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        } while (!zTt);
        throw new EOFException("source exhausted prematurely");
    }

    @Override // com.byazt.mk.my, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.uj) {
            return;
        }
        this.tt.end();
        this.uj = true;
        this.c.close();
    }

    public final boolean tt() throws IOException {
        if (!this.tt.needsInput()) {
            return false;
        }
        ve();
        if (this.tt.getRemaining() != 0) {
            throw new IllegalStateException("?");
        }
        if (this.c.n()) {
            return true;
        }
        z zVar = this.c.ve().c;
        int i = zVar.ve;
        int i2 = zVar.tt;
        int i3 = i - i2;
        this.ve = i3;
        this.tt.setInput(zVar.c, i2, i3);
        return false;
    }

    @Override // com.byazt.mk.my
    public gt c() {
        return this.c.c();
    }
}
