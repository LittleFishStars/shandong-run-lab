package com.byazt.o;

import com.alibaba.android.arouter.utils.Consts;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME, 13})
public class tt {
    public static final void c(uj ujVar, int i) throws IOException {
        int iTt = ujVar.tt();
        if (iTt == i) {
            return;
        }
        throw new IOException("Expected chunk of type 0x" + Integer.toHexString(i) + ", read 0x" + Integer.toHexString(iTt) + Consts.DOT);
    }
}
