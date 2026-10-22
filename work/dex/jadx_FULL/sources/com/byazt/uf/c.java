package com.byazt.uf;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME, 20})
public abstract class c {
    public List<com.byazt.vb.tt> c(int i, com.byazt.vb.tt ttVar, boolean z, List<String> list, String str) {
        if (com.byazt.ml.c.c(i)) {
            return tt(i, ttVar, z, list, str);
        }
        if (c(ttVar)) {
            return tt(i, ttVar, z, list, str);
        }
        return null;
    }

    public abstract boolean c(com.byazt.vb.tt ttVar);

    public abstract boolean c(String str);

    public abstract List<com.byazt.vb.tt> tt(int i, com.byazt.vb.tt ttVar, boolean z, List<String> list, String str);

    public abstract boolean tt(int i, String str, com.byazt.vb.tt ttVar);

    public boolean c(int i, String str, com.byazt.vb.tt ttVar) {
        if (com.byazt.ml.c.c(i)) {
            return c(str);
        }
        if (c(ttVar)) {
            return tt(i, str, ttVar);
        }
        return false;
    }
}
