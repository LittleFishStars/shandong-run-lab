package com.byazt.rgb;

import com.byazt.ete.ic;
import com.byazt.ip.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE, 15})
public class uj {
    public static boolean a(String str) {
        com.byazt.ip.tt context = c().getContext(str);
        return (context instanceof com.byazt.ha.n) && ((com.byazt.ha.n) context).c != null;
    }

    public static void c(final ic icVar, final String str, final int i, String str2) {
        if (icVar == null) {
            return;
        }
        com.byazt.lh.n nVarC = c();
        nVarC.tt(str2, icVar.jl());
        nVarC.c(str2, new com.byazt.ky.a());
        nVarC.c(str2, new com.byazt.ip.uj.c() { // from class: com.byazt.rgb.uj.1
            @Override // com.byazt.ip.uj.c
            public void c(com.byazt.ip.tt ttVar) {
                if (ttVar instanceof com.byazt.ha.n) {
                    com.byazt.ha.n nVar = (com.byazt.ha.n) ttVar;
                    ic icVar2 = icVar;
                    nVar.i = icVar2;
                    nVar.sp = i;
                    nVar.x = str;
                    nVar.uj = icVar2.id();
                }
            }
        });
        c(str2);
    }

    public static void n(String str) {
        com.byazt.lh.n nVarC = c();
        if (nVarC != null) {
            nVarC.c(str, com.byazt.hi.n.DETACHED);
        }
    }

    public static void tt(String str) {
        com.byazt.lh.n nVarC = c();
        if (nVarC != null) {
            nVarC.c(str, com.byazt.hi.n.ATTACHED);
        }
    }

    public static void uj(String str) {
        com.byazt.lh.n nVarC = c();
        if (nVarC != null) {
            nVarC.c(str, com.byazt.hi.n.INVISIBLED);
        }
    }

    public static void ve(String str) {
        com.byazt.lh.n nVarC = c();
        if (nVarC != null) {
            nVarC.c(str, com.byazt.hi.n.VISIBLED);
        }
    }

    public static void tt(String str, int i) {
        com.byazt.lh.n nVarC = c();
        if (nVarC != null) {
            x xVar = new x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            nVarC.c(str, com.byazt.hi.n.END, xVar);
        }
    }

    public static void c(String str) {
        com.byazt.lh.n nVarC = c();
        if (nVarC != null) {
            nVarC.c(str, com.byazt.hi.n.CREATED);
        }
    }

    public static void c(String str, int i) {
        com.byazt.lh.n nVarC = c();
        if (nVarC != null) {
            x xVar = new x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            nVarC.c(str, com.byazt.hi.n.FOCUSED, xVar);
        }
    }

    public static com.byazt.lh.n c() {
        return (com.byazt.lh.n) com.byazt.ip.n.c(5);
    }
}
