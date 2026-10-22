package com.byazt.b;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 66})
public class t {
    public static volatile com.byazt.zz.u c;
    public static volatile com.byazt.zz.u tt;

    public static com.byazt.zz.u c(boolean z) {
        if (z && com.byazt.zz.ve.lo()) {
            if (tt == null) {
                synchronized (t.class) {
                    if (tt == null) {
                        tt = com.byazt.zz.ve.pu().tt();
                    }
                }
            }
            return tt;
        }
        if (c == null) {
            synchronized (t.class) {
                if (c == null) {
                    c = new m();
                }
            }
        }
        return c;
    }
}
