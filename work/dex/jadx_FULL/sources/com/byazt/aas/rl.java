package com.byazt.aas;

import com.byazt.ete.b;
import com.byazt.ete.ic;
import com.byazt.ete.lt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 117})
public class rl {
    public static int a(ic icVar) {
        if (icVar == null) {
            return -1;
        }
        if (x(icVar) != 3) {
            return 0;
        }
        return com.byazt.ete.my.t(icVar);
    }

    public static String c(ic icVar) {
        if (icVar == null) {
            return "";
        }
        int iX = x(icVar);
        if (iX != 3) {
            return iX != 4 ? "" : b.n(icVar);
        }
        return com.byazt.ete.my.x(icVar);
    }

    public static int n(ic icVar) {
        if (icVar != null && x(icVar) == 3) {
            return com.byazt.ete.my.sl(icVar);
        }
        return 0;
    }

    public static boolean sp(ic icVar) {
        return x(icVar) == 3;
    }

    public static boolean tt(ic icVar) {
        return (icVar == null || x(icVar) == 0) ? false : true;
    }

    public static boolean uj(ic icVar) {
        return icVar != null && x(icVar) == 4;
    }

    public static boolean ve(ic icVar) {
        if (icVar == null || lt.c(icVar) || x(icVar) != 3) {
            return false;
        }
        return com.byazt.ete.my.c(icVar);
    }

    private static int x(ic icVar) {
        if (com.byazt.ete.my.c(icVar)) {
            return 3;
        }
        return b.c(icVar) ? 4 : 0;
    }
}
