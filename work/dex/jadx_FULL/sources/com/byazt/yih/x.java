package com.byazt.yih;

import android.content.Context;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ogz.da;
import com.byazt.omf.rl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 730, 71})
public class x {
    public static com.byazt.wz.c c(Context context, ic icVar, String str) {
        com.byazt.wz.a aVar = new com.byazt.wz.a(context, icVar, str, "");
        if (icVar != null) {
            com.byazt.rgb.c.c(icVar, String.valueOf(nb.t(icVar)), nb.sl(icVar), 1, icVar.zm());
            rl.tt(icVar.lw(), aVar, com.byazt.pop.ve.class);
            icVar.lw();
        }
        return aVar;
    }

    public static com.byazt.pop.ve tt(Context context, ic icVar, String str) {
        if (icVar != null) {
            com.byazt.rgb.c.c(icVar, String.valueOf(nb.t(icVar)), nb.sl(icVar), 2, icVar.zm());
        }
        if (da.sp()) {
            return new com.byazt.wz.a(context, icVar, str, "");
        }
        return nb.yv() ? new com.byazt.wz.n(context, icVar, str) : new com.byazt.wz.ve(context, icVar, str);
    }

    public static com.byazt.pop.ve c(Context context, String str, ic icVar, String str2) {
        if (icVar != null) {
            com.byazt.rgb.c.c(icVar, String.valueOf(nb.t(icVar)), nb.sl(icVar), 3, icVar.zm());
        }
        if (da.sp()) {
            com.byazt.wz.a aVar = new com.byazt.wz.a(context, icVar, str2, str);
            aVar.x(true);
            return aVar;
        }
        return new com.byazt.wz.sp(context, str, icVar, str2);
    }
}
