package com.byazt.om;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 554, 54})
public class ve implements c {
    @Override // com.byazt.om.c
    public void c(c.InterfaceC0486c interfaceC0486c) {
        com.byazt.iz.tt ttVarC = interfaceC0486c.c();
        com.byazt.ll.tt ttVarGu = ttVarC.gu();
        com.byazt.nbs.tt ttVarM = ttVarC.m();
        com.byazt.nbs.tt ttVarC2 = com.byazt.xx.ve.c(ttVarGu, ttVarM);
        if (ttVarC2 != null) {
            if (ttVarGu.ve() == 2 || ttVarGu.ve() == 4 || ttVarGu.ve() == 5) {
                com.byazt.ix.uj.c().c(ttVarGu.gt(), ttVarGu);
            }
            ttVarM = ttVarC2;
        }
        if (ttVarM.l() == null || ttVarM.l().size() == 0) {
            com.byazt.ng.a.c(ttVarGu, ttVarC.m() != null ? ttVarC.m().lo() : null, !ttVarC.yv(), ttVarC.pf().c, 810085, (Map<String, Object>) null);
            ttVarC.c(new com.byazt.pp.c(810085, com.byazt.pp.c.c(810085)));
        } else {
            ttVarC.c(ttVarM);
            interfaceC0486c.c(interfaceC0486c.c());
        }
    }

    @Override // com.byazt.om.c
    public void tt(c.InterfaceC0486c interfaceC0486c) {
        interfaceC0486c.c((String) null);
    }
}
