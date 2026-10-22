package com.byazt.nb;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.b85;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 91})
public class sp {
    public final float c;
    public final float tt;
    public final String ve;

    public sp(String str, float f, float f2) {
        this.ve = str;
        this.tt = f2;
        this.c = f;
    }

    public boolean c(String str) {
        if (this.ve.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.ve.endsWith(b85.b)) {
            String str2 = this.ve;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
