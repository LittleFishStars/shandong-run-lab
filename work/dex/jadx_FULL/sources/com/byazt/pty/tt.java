package com.byazt.pty;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_TIMEOUT, 13})
public class tt {
    public final long c;
    public final ByteBuffer n;
    public final long tt;
    public final long uj;
    public final int ve;

    public tt(long j, long j2, int i, long j3, ByteBuffer byteBuffer) {
        this.c = j;
        this.tt = j2;
        this.ve = i;
        this.uj = j3;
        this.n = byteBuffer;
    }

    public long c() {
        return this.c;
    }

    public ByteBuffer n() {
        return this.n;
    }

    public long tt() {
        return this.tt;
    }

    public long uj() {
        return this.uj;
    }

    public int ve() {
        return this.ve;
    }
}
