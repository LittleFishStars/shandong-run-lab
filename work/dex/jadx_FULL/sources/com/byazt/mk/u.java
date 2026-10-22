package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 67})
public final class u implements uj {
    public final ve c = new ve();
    public final rh tt;
    public boolean ve;

    public u(rh rhVar) {
        if (rhVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.tt = rhVar;
    }

    @Override // com.byazt.mk.rh
    public void a_(ve veVar, long j) throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        this.c.a_(veVar, j);
        rl();
    }

    @Override // com.byazt.mk.rh
    public gt c() {
        return this.tt.c();
    }

    @Override // com.byazt.mk.rh, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.ve) {
            return;
        }
        ve veVar = this.c;
        long j = veVar.tt;
        if (j > 0) {
            this.tt.a_(veVar, j);
        }
        th = null;
        try {
            this.tt.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.ve = true;
        if (th != null) {
            rl.c(th);
        }
    }

    @Override // com.byazt.mk.uj, com.byazt.mk.rh, java.io.Flushable
    public void flush() throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        ve veVar = this.c;
        long j = veVar.tt;
        if (j > 0) {
            this.tt.a_(veVar, j);
        }
        this.tt.flush();
    }

    @Override // com.byazt.mk.uj
    public uj i(int i) throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        this.c.i(i);
        return rl();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.ve;
    }

    @Override // com.byazt.mk.uj
    public uj rl() throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        long jSp = this.c.sp();
        if (jSp > 0) {
            this.tt.a_(this.c, jSp);
        }
        return this;
    }

    @Override // com.byazt.mk.uj
    public uj sl(long j) throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        this.c.sl(j);
        return rl();
    }

    @Override // com.byazt.mk.uj
    public uj sp(int i) throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        this.c.sp(i);
        return rl();
    }

    @Override // com.byazt.mk.uj
    public uj t(long j) throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        this.c.t(j);
        return rl();
    }

    public String toString() {
        return "buffer(" + this.tt + ")";
    }

    @Override // com.byazt.mk.uj
    public uj tt(a aVar) throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        this.c.tt(aVar);
        return rl();
    }

    @Override // com.byazt.mk.uj
    public ve ve() {
        return this.c;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.c.write(byteBuffer);
        rl();
        return iWrite;
    }

    @Override // com.byazt.mk.uj
    public uj x(int i) throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        this.c.x(i);
        return rl();
    }

    @Override // com.byazt.mk.uj
    public uj ve(byte[] bArr) throws IOException {
        if (this.ve) {
            throw new IllegalStateException("closed");
        }
        this.c.ve(bArr);
        return rl();
    }

    @Override // com.byazt.mk.uj
    public uj tt(String str) throws IOException {
        if (!this.ve) {
            this.c.tt(str);
            return rl();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.byazt.mk.uj
    public uj ve(byte[] bArr, int i, int i2) throws IOException {
        if (!this.ve) {
            this.c.ve(bArr, i, i2);
            return rl();
        }
        throw new IllegalStateException("closed");
    }
}
