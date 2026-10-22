package com.byazt.om;

import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 554, 158})
public class sl implements c {
    @Override // com.byazt.om.c
    public void c(c.InterfaceC0486c interfaceC0486c) {
        com.byazt.iz.tt ttVarC = interfaceC0486c.c();
        com.byazt.ll.tt ttVarGu = ttVarC.gu();
        ttVarGu.gt();
        if (!ttVarGu.tk()) {
            interfaceC0486c.c(interfaceC0486c.c());
            return;
        }
        String str = com.byazt.eu.uj.c(ttVarGu.gt()) + "V2 公共缓存池广告请求......";
        String str2 = MediationConstant.TAG;
        com.byazt.eu.tt.tt(MediationConstant.TAG, str);
        String strLo = ttVarC.m() != null ? ttVarC.m().lo() : null;
        boolean z = !ttVarC.yv();
        if (!com.byazt.bp.tt.tt().x()) {
            com.byazt.vy.c.c(ttVarGu, "-2");
            com.byazt.bnd.c cVar = new com.byazt.bnd.c(41007, com.byazt.pp.c.c(41007));
            com.byazt.ng.a.c(ttVarGu, strLo, z, ttVarC.pf().c, cVar.c, (Map<String, Object>) null);
            ttVarC.c(cVar);
            return;
        }
        List<com.byazt.ix.sp> listC = com.byazt.vy.c.c().c(ttVarGu);
        if (listC == null || listC.isEmpty()) {
            com.byazt.vy.c.c(ttVarGu, "-1");
            com.byazt.bnd.c cVar2 = new com.byazt.bnd.c(41008, com.byazt.pp.c.c(41008));
            com.byazt.ng.a.c(ttVarGu, strLo, z, ttVarC.pf().c, cVar2.c, (Map<String, Object>) null);
            ttVarC.c(cVar2);
            return;
        }
        com.byazt.ng.a.c(listC.get(0).c, ttVarGu, ttVarC.m(), 0L, ttVarC.pf().c, z, listC.size(), ttVarC.pf().n, false);
        int size = listC.size() - 1;
        String strA = null;
        while (size >= 0) {
            com.byazt.ix.sp spVar = listC.get(size);
            com.byazt.yl.ve veVar = spVar.c;
            veVar.setOriginPrimeRit(spVar.a());
            veVar.setOriginLinkId(spVar.uj() != null ? spVar.uj().c() : null);
            if (size == 0) {
                strA = spVar.a();
            }
            String str3 = strA;
            ArrayList arrayList = new ArrayList();
            arrayList.add(veVar);
            com.byazt.vy.c.c(ttVarGu, spVar.a());
            com.byazt.ll.tt ttVar = ttVarGu;
            com.byazt.ng.a.c(com.byazt.bp.tt.tt().c(spVar.a(), ttVarGu.my(), 102).a(veVar.getAdNetworkSlotId()), ttVarGu, com.byazt.hk.c.c().c(veVar.getAdNetworkSlotId()), true, 1, 0, 3, 3, null, -1L, false, false, spVar.uj() != null ? spVar.uj().c() : null, SystemClock.elapsedRealtime() - ttVarC.cu());
            com.byazt.tjo.a.c(ttVarC.ve(), ttVarC.c(veVar), ttVarC.cu());
            ttVarC.tt(arrayList);
            com.byazt.ng.a.c(veVar, 0, "adn cache命中", 0L, ttVar, 0, arrayList.size(), 2, null, 0L, -1L);
            com.byazt.tjo.a.c(ttVarC.ve(), ttVarC.tt(veVar), ttVarC.cu());
            size--;
            ttVarGu = ttVar;
            strA = str3;
            listC = listC;
            str2 = str2;
        }
        com.byazt.ll.tt ttVar2 = ttVarGu;
        com.byazt.vy.c.c(ttVar2, strA);
        com.byazt.eu.tt.tt(str2, com.byazt.eu.uj.c(ttVar2.gt()) + "V2 resetAdLinkInfo......");
        com.byazt.ng.a.c(ttVar2, strLo, z, ttVarC.pf().c, 0, (Map<String, Object>) null);
        ttVarC.x();
    }

    @Override // com.byazt.om.c
    public void tt(c.InterfaceC0486c interfaceC0486c) {
        interfaceC0486c.c((String) null);
    }
}
