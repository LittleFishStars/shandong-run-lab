package com.byazt.om;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 554, 15})
public class uj implements c {
    @Override // com.byazt.om.c
    public void c(c.InterfaceC0486c interfaceC0486c) {
        com.byazt.iz.tt ttVarC = interfaceC0486c.c();
        ttVarC.nu().c(0);
        int iVe = ttVarC.gu().ve();
        List<com.byazt.nbs.da> list = ttVarC.m().md().get(0);
        JSONObject jSONObject = new JSONObject();
        String strC = com.byazt.ug.c.c().c(ttVarC.gr(), ttVarC.getContext(), ttVarC.gu(), list, ttVarC.m(), iVe, !ttVarC.yv(), jSONObject);
        com.byazt.ng.a.c(ttVarC.gu(), jSONObject);
        ttVarC.c(strC);
    }

    @Override // com.byazt.om.c
    public void tt(c.InterfaceC0486c interfaceC0486c) {
        interfaceC0486c.c((String) null);
    }
}
