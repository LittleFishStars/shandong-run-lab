package com.byazt.b;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 13})
public class tt implements com.byazt.zz.sp {
    @Override // com.byazt.zz.sp
    public int c(int i, com.byazt.hs.t tVar) {
        if (tVar.ordinal() <= com.byazt.hs.t.MODERATE.ordinal()) {
            return 1;
        }
        return tVar == com.byazt.hs.t.GOOD ? i - 1 : i;
    }
}
