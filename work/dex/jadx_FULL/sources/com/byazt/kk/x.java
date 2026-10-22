package com.byazt.kk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 71})
public class x {
    public float c;
    public int tt;

    public void c(float f) {
        float f2 = this.c + f;
        this.c = f2;
        int i = this.tt + 1;
        this.tt = i;
        if (i == Integer.MAX_VALUE) {
            this.c = f2 / 2.0f;
            this.tt = i / 2;
        }
    }
}
