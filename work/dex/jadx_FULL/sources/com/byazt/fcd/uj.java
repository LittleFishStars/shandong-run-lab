package com.byazt.fcd;

import com.byazt.ete.ic;
import com.byazt.lcf.TTBaseVideoActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_RTT, 15})
public class uj {
    public static int c(ic icVar) {
        if (ve.c(icVar)) {
            return ve.tt(icVar);
        }
        if (da.c(icVar)) {
            return da.tt(icVar);
        }
        if (sl.c(icVar)) {
            return sl.tt(icVar);
        }
        if (sp.c(icVar)) {
            return sp.tt(icVar);
        }
        if (n.c(icVar)) {
            return n.tt(icVar);
        }
        if (a.c(icVar)) {
            return a.tt(icVar);
        }
        if (x.c(icVar)) {
            return x.tt(icVar);
        }
        if (t.c(icVar)) {
            return t.tt(icVar);
        }
        return -1;
    }

    public static c c(TTBaseVideoActivity tTBaseVideoActivity, ic icVar) {
        if (i.c(tTBaseVideoActivity, icVar)) {
            return new i(tTBaseVideoActivity, icVar);
        }
        if (da.c(icVar)) {
            return new da(tTBaseVideoActivity, icVar);
        }
        if (ve.c(icVar)) {
            return new ve(tTBaseVideoActivity, icVar);
        }
        if (sl.c(icVar)) {
            return new sl(tTBaseVideoActivity, icVar);
        }
        if (sp.c(icVar)) {
            return new sp(tTBaseVideoActivity, icVar);
        }
        if (n.c(icVar)) {
            return new n(tTBaseVideoActivity, icVar);
        }
        if (a.c(icVar)) {
            return new a(tTBaseVideoActivity, icVar);
        }
        if (x.c(icVar)) {
            return new x(tTBaseVideoActivity, icVar);
        }
        if (t.c(icVar)) {
            return new t(tTBaseVideoActivity, icVar);
        }
        return null;
    }
}
