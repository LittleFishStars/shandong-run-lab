package com.byazt.mk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt {
    public static final gt ve = new gt() { // from class: com.byazt.mk.gt.1
        @Override // com.byazt.mk.gt
        public gt c(long j) {
            return this;
        }

        @Override // com.byazt.mk.gt
        public gt c(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // com.byazt.mk.gt
        public void sp() throws IOException {
        }
    };
    public boolean c;
    public long tt;
    public long uj;

    public gt a() {
        this.c = false;
        return this;
    }

    public gt c(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0: ".concat(String.valueOf(j)));
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.uj = timeUnit.toNanos(j);
        return this;
    }

    public gt n() {
        this.uj = 0L;
        return this;
    }

    public long n_() {
        return this.uj;
    }

    public long o_() {
        if (this.c) {
            return this.tt;
        }
        throw new IllegalStateException("No deadline");
    }

    public void sp() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.c && this.tt - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public boolean ve() {
        return this.c;
    }

    public gt c(long j) {
        this.c = true;
        this.tt = j;
        return this;
    }
}
