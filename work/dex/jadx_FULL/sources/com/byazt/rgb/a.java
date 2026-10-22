package com.byazt.rgb;

import com.byazt.ete.ic;
import com.byazt.ky.x;
import com.byazt.lh.sp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE, 34})
public class a {
    public static void c(final ic icVar, final String str, final int i, final int i2, String str2) {
        if (icVar == null) {
            return;
        }
        sp spVarC = c();
        spVarC.tt(str2, icVar.jl());
        spVarC.c(str2, new x());
        spVarC.c(str2, new com.byazt.ip.uj.c() { // from class: com.byazt.rgb.a.1
            @Override // com.byazt.ip.uj.c
            public void c(com.byazt.ip.tt ttVar) {
                if (ttVar instanceof com.byazt.ha.x) {
                    com.byazt.ha.x xVar = (com.byazt.ha.x) ttVar;
                    xVar.i = icVar;
                    xVar.sp = i;
                    xVar.x = str;
                    xVar.c = i2;
                }
            }
        });
        c(str2);
    }

    public static void tt(String str) {
        sp spVarC = c();
        if (spVarC != null) {
            spVarC.c(str, com.byazt.hi.sp.STARTED);
        }
    }

    public static void uj(String str) {
        sp spVarC = c();
        if (spVarC != null) {
            spVarC.c(str, com.byazt.hi.sp.CLICKED);
        }
    }

    public static void ve(String str) {
        sp spVarC = c();
        if (spVarC != null) {
            spVarC.c(str, com.byazt.hi.sp.RENDER_STARTED);
        }
    }

    public static void tt(String str, int i) {
        sp spVarC = c();
        if (spVarC != null) {
            com.byazt.ip.x xVar = new com.byazt.ip.x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            spVarC.c(str, com.byazt.hi.sp.RENDERED, xVar);
        }
    }

    public static void uj(String str, int i) {
        sp spVarC = c();
        if (spVarC != null) {
            com.byazt.ip.x xVar = new com.byazt.ip.x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            spVarC.c(str, com.byazt.hi.sp.END, xVar);
        }
    }

    public static void ve(String str, int i) {
        sp spVarC = c();
        if (spVarC != null) {
            com.byazt.ip.x xVar = new com.byazt.ip.x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            spVarC.c(str, com.byazt.hi.sp.SHOWED, xVar);
        }
    }

    public static void c(String str) {
        sp spVarC = c();
        if (spVarC != null) {
            spVarC.c(str, com.byazt.hi.sp.CREATED);
        }
    }

    public static void c(String str, int i) {
        sp spVarC = c();
        if (spVarC != null) {
            com.byazt.ip.x xVar = new com.byazt.ip.x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            spVarC.c(str, com.byazt.hi.sp.LOADED, xVar);
        }
    }

    public static sp c() {
        return (sp) com.byazt.ip.n.c(6);
    }
}
