package com.byazt.ouc;

import com.byazt.aas.nb;
import com.byazt.ete.ic;
import com.byazt.ete.pu;
import com.byazt.xl.u;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 162, 20})
public abstract class c implements tt {
    private static int n(ic icVar) {
        int iSl;
        if (icVar == null) {
            return -1;
        }
        com.byazt.dj.tt ttVarIj = icVar.ij();
        int iGt = ttVarIj != null ? ttVarIj.gt() : -1;
        return ((iGt <= 0 || iGt >= 10) && (iSl = nb.sl(icVar)) > 0 && iSl < 10) ? iSl : iGt;
    }

    public static boolean tt(ic icVar) {
        if (icVar == null) {
            return false;
        }
        return (pu.ve(icVar) == 2) && ve(icVar);
    }

    private int uj(ic icVar) {
        if (icVar == null) {
            return -1;
        }
        return icVar.id();
    }

    public static boolean ve(ic icVar) {
        return n(icVar) == 5;
    }

    @Override // com.byazt.ouc.tt
    public String c(ic icVar) {
        int iN = n(icVar);
        int iUj = uj(icVar);
        if (iN <= 0 || iN > 9 || iUj == -1) {
            return null;
        }
        return c(icVar, iN, iUj);
    }

    public abstract String c(ic icVar, int i, int i2);

    public static tt c(ic icVar, u uVar) {
        if (icVar == null || n(icVar) != 5) {
            return null;
        }
        if ((uVar instanceof com.byazt.atv.tt) && ((com.byazt.atv.tt) uVar).cu()) {
            return new com.byazt.zdj.c();
        }
        return new com.byazt.ot.c();
    }
}
