package com.byazt.qv;

import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 20})
public class c {
    public static void c(com.byazt.iz.tt ttVar, List<com.byazt.yl.ve> list, boolean z) {
        if (ttVar == null) {
            return;
        }
        com.byazt.yl.ve veVarC = c(list);
        if (ttVar.nb()) {
            return;
        }
        ttVar.ve(SystemClock.elapsedRealtime());
        com.byazt.ng.a.c(veVarC, ttVar.gu(), ttVar.m(), ttVar.qp() - ttVar.cu(), ttVar.pf().c, !ttVar.yv(), list != null ? list.size() : 0, ttVar.pf().n, z);
        ttVar.n(true);
    }

    private static com.byazt.yl.ve c(List<com.byazt.yl.ve> list) {
        com.byazt.yl.ve veVar = null;
        if (list != null && list.size() != 0) {
            for (com.byazt.yl.ve veVar2 : list) {
                if (veVar == null || veVar2.getFillTime() < veVar.getFillTime()) {
                    veVar = veVar2;
                }
            }
        }
        return veVar;
    }
}
