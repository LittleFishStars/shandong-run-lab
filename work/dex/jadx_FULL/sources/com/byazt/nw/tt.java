package com.byazt.nw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OPEN_SUB_RETRY_TIMES, 13})
public class tt {
    public static int c(boolean z, int i, int i2) {
        if (i2 == 0 || !z) {
            return i;
        }
        int i3 = i - 512;
        int iAbs = Math.abs(i3) % i2;
        return (i3 >= 0 || iAbs == 0) ? iAbs : i2 - iAbs;
    }

    public static boolean c(int i, Collection<?> collection) {
        return i >= 0 && i < collection.size();
    }
}
