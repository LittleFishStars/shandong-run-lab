package com.byazt.ouz;

import android.text.TextUtils;
import com.byazt.aas.nb;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 42})
public class i {
    public static void c(final String str, final String str2, final ic icVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        com.byazt.ukr.yp.c().c(new com.byazt.ee.c() { // from class: com.byazt.ouz.i.1
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c(i.c(str)).ve(str2).a(nb.m(icVar)).c("dynamic_backup_render_new");
                ttVarC.c(jCurrentTimeMillis);
                return ttVarC;
            }
        }, "dynamic_backup_render_new");
    }

    public static void c(final int i, final String str, final String str2, final ic icVar) {
        com.byazt.ukr.yp.c().n(new com.byazt.ee.c() { // from class: com.byazt.ouz.i.2
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                return com.byazt.qal.tt.tt().c(i.c(str)).ve(str2).a(nb.m(icVar)).tt(i).sp(com.byazt.omf.sp.c(i));
            }
        });
    }

    public static int c(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5;
        }
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 1;
            case "rewarded_video":
                return 7;
            case "stream":
                return 6;
            case "fullscreen_interstitial_ad":
                return 8;
            case "splash_ad":
                return 3;
            case "interaction":
                return 2;
            case "draw_ad":
                return 9;
            default:
                return 5;
        }
    }
}
