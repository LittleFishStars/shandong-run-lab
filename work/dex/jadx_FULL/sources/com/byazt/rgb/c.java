package com.byazt.rgb;

import com.byazt.ete.ic;
import com.byazt.ip.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE, 20})
public class c {
    public static void c(final ic icVar, final String str, final int i, final int i2, String str2) {
        if (icVar == null) {
            return;
        }
        com.byazt.lh.c cVarC = c();
        cVarC.tt(str2, icVar.jl());
        cVarC.c(str2, new com.byazt.ky.tt());
        cVarC.c(str2, new com.byazt.ky.c());
        cVarC.c(str2, new com.byazt.ip.uj.c() { // from class: com.byazt.rgb.c.1
            @Override // com.byazt.ip.uj.c
            public void c(com.byazt.ip.tt ttVar) {
                if (ttVar instanceof com.byazt.ha.c) {
                    com.byazt.ha.c cVar = (com.byazt.ha.c) ttVar;
                    cVar.i = icVar;
                    cVar.sp = i;
                    cVar.x = str;
                    cVar.c = i2;
                }
            }
        });
        c(str2);
    }

    public static void n(String str) {
        com.byazt.lh.c cVarC = c();
        if (cVarC != null) {
            cVarC.c(str, com.byazt.hi.c.DOWNLOAD_FINISHED);
        }
    }

    public static void tt(String str, int i) {
        com.byazt.lh.c cVarC = c();
        if (cVarC != null) {
            x xVar = new x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            cVarC.c(str, com.byazt.hi.c.MARKET_OPENED, xVar);
        }
    }

    public static void uj(String str, int i) {
        com.byazt.lh.c cVarC = c();
        if (cVarC != null) {
            x xVar = new x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            cVarC.c(str, com.byazt.hi.c.DOWNLOAD_FAILED, xVar);
        }
    }

    public static void ve(String str, int i) {
        com.byazt.lh.c cVarC = c();
        if (cVarC != null) {
            x xVar = new x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            cVarC.c(str, com.byazt.hi.c.DOWNLOAD_STARTED, xVar);
        }
    }

    public static void n(String str, int i) {
        com.byazt.lh.c cVarC = c();
        if (cVarC != null) {
            x xVar = new x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            cVarC.c(str, com.byazt.hi.c.END, xVar);
        }
    }

    public static void tt(String str) {
        com.byazt.lh.c cVarC = c();
        if (cVarC != null) {
            cVarC.c(str, com.byazt.hi.c.MARKET_CLOSED);
        }
    }

    public static void uj(String str) {
        com.byazt.lh.c cVarC = c();
        if (cVarC != null) {
            cVarC.c(str, com.byazt.hi.c.DOWNLOAD_CANCELED);
        }
    }

    public static void ve(String str) {
        com.byazt.lh.c cVarC = c();
        if (cVarC != null) {
            cVarC.c(str, com.byazt.hi.c.DOWNLOAD_PAUSED);
        }
    }

    public static void c(String str) {
        com.byazt.lh.c cVarC = c();
        if (cVarC != null) {
            cVarC.c(str, com.byazt.hi.c.CREATED);
        }
    }

    public static void c(String str, int i) {
        com.byazt.lh.c cVarC = c();
        if (cVarC != null) {
            x xVar = new x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            cVarC.c(str, com.byazt.hi.c.STARTED, xVar);
        }
    }

    public static com.byazt.lh.c c() {
        return (com.byazt.lh.c) com.byazt.ip.n.c(3);
    }
}
