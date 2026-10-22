package com.byazt.on;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE, 13})
public class tt extends uj {
    public void c(int i) {
        c((byte) (i & 255));
        c((byte) ((i >> 8) & 255));
        c((byte) ((i >> 16) & 255));
        c((byte) ((i >> 24) & 255));
    }

    public void tt(int i) {
        c((byte) ((i >> 24) & 255));
        c((byte) ((i >> 16) & 255));
        c((byte) ((i >> 8) & 255));
        c((byte) (i & 255));
    }

    @Override // com.byazt.on.uj
    public void ve(int i) {
        super.ve(i);
        this.c.order(ByteOrder.BIG_ENDIAN);
    }
}
