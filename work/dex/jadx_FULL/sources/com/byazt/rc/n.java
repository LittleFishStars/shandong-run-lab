package com.byazt.rc;

import com.byazt.yj.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME, 46})
public class n implements x {
    public long c;
    public long tt;
    public long ve;

    public void c(long j) {
        this.c = j;
    }

    @Override // com.byazt.yj.x
    public long getEndRequestTime() {
        return this.ve;
    }

    @Override // com.byazt.yj.x
    public long getFirstFrameTime() {
        return this.tt;
    }

    @Override // com.byazt.yj.x
    public long getStartRequestTime() {
        return this.c;
    }

    public void tt(long j) {
        this.tt = j;
    }

    public void ve(long j) {
        this.ve = j;
    }
}
