package com.byazt.rgb;

import com.byazt.ete.ic;
import com.byazt.ip.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE, 54})
public class ve {
    public static void a(String str) {
        com.byazt.lh.uj ujVarC = c();
        if (ujVarC != null) {
            ujVarC.c(str, com.byazt.hi.uj.COMPLETED);
        }
    }

    public static void c(final ic icVar, final String str, final int i, final int i2, String str2) {
        if (icVar == null) {
            return;
        }
        com.byazt.lh.uj ujVarC = c();
        ujVarC.tt(str2, icVar.jl());
        ujVarC.c(str2, new com.byazt.ky.n());
        ujVarC.c(str2, new com.byazt.ip.uj.c() { // from class: com.byazt.rgb.ve.1
            @Override // com.byazt.ip.uj.c
            public void c(com.byazt.ip.tt ttVar) {
                if (ttVar instanceof com.byazt.ha.uj) {
                    com.byazt.ha.uj ujVar = (com.byazt.ha.uj) ttVar;
                    ujVar.i = icVar;
                    ujVar.sp = i;
                    ujVar.x = str;
                    ujVar.c = i2;
                }
            }
        });
        c(str2);
    }

    public static void n(String str) {
        com.byazt.lh.uj ujVarC = c();
        if (ujVarC != null) {
            ujVarC.c(str, com.byazt.hi.uj.PAUSED);
        }
    }

    public static void tt(String str) {
        com.byazt.lh.uj ujVarC = c();
        if (ujVarC != null) {
            ujVarC.c(str, com.byazt.hi.uj.INITIALIZED);
        }
    }

    public static void uj(String str) {
        com.byazt.lh.uj ujVarC = c();
        if (ujVarC != null) {
            ujVarC.c(str, com.byazt.hi.uj.BUFFERED);
        }
    }

    public static void ve(String str) {
        com.byazt.lh.uj ujVarC = c();
        if (ujVarC != null) {
            ujVarC.c(str, com.byazt.hi.uj.PREPARED);
        }
    }

    public static void tt(String str, int i) {
        com.byazt.lh.uj ujVarC = c();
        if (ujVarC != null) {
            x xVar = new x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            ujVarC.c(str, com.byazt.hi.uj.PLAYED, xVar);
        }
    }

    public static void ve(String str, int i) {
        com.byazt.lh.uj ujVarC = c();
        if (ujVarC != null) {
            x xVar = new x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            ujVarC.c(str, com.byazt.hi.uj.END, xVar);
        }
    }

    public static void c(String str) {
        com.byazt.lh.uj ujVarC = c();
        if (ujVarC != null) {
            ujVarC.c(str, com.byazt.hi.uj.CREATED);
        }
    }

    public static void c(String str, int i) {
        com.byazt.lh.uj ujVarC = c();
        if (ujVarC != null) {
            x xVar = new x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            ujVarC.c(str, com.byazt.hi.uj.STARTED, xVar);
        }
    }

    public static com.byazt.lh.uj c() {
        return (com.byazt.lh.uj) com.byazt.ip.n.c(2);
    }
}
