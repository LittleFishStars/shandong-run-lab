package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 91})
public abstract class sp implements rh {
    public final rh c;

    public sp(rh rhVar) {
        if (rhVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.c = rhVar;
    }

    @Override // com.byazt.mk.rh
    public void a_(ve veVar, long j) throws IOException {
        this.c.a_(veVar, j);
    }

    @Override // com.byazt.mk.rh
    public gt c() {
        return this.c.c();
    }

    @Override // com.byazt.mk.rh, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
    }

    @Override // com.byazt.mk.rh, java.io.Flushable
    public void flush() throws IOException {
        this.c.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.c.toString() + ")";
    }
}
