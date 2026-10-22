package com.byazt.xt;

import android.os.SystemClock;
import com.byazt.nbs.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE, 34})
public class a implements c {
    @Override // com.byazt.xt.c
    public void c(c.InterfaceC0584c interfaceC0584c) {
        List<com.byazt.ix.sp> listC;
        da daVarX = interfaceC0584c.c().x();
        com.byazt.ll.tt ttVarGu = interfaceC0584c.tt().gu();
        if (daVarX != null) {
            String strRh = daVarX.rh();
            if (daVarX.gt() && com.byazt.hk.c.c().uj(ttVarGu.gt(), strRh, ttVarGu.n())) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, "--==-- 广告复用，模式：" + com.byazt.hk.c.c().n(ttVarGu.gt(), strRh, ttVarGu.n()));
                int iC = com.byazt.hk.c.c().c(strRh, ttVarGu, true);
                interfaceC0584c.c().ve(iC);
                if (iC == 3) {
                    interfaceC0584c.c().c(2);
                    if (c(interfaceC0584c.tt(), interfaceC0584c.c(), ttVarGu, strRh, daVarX, 2)) {
                        return;
                    }
                } else if (iC == 2 && (listC = com.byazt.hk.c.c().c(strRh, ttVarGu, ttVarGu.n())) != null && listC.size() > 0) {
                    interfaceC0584c.c().tt(listC.get(0).c.getMediationRitReqType(ttVarGu.c()));
                }
            }
        }
        interfaceC0584c.c(this);
    }

    private boolean c(com.byazt.iz.tt ttVar, com.byazt.dv.tt ttVar2, com.byazt.ll.tt ttVar3, String str, da daVar, int i) {
        com.byazt.hk.c.c().c(ttVar3.gt(), str, daVar, i);
        List<com.byazt.ix.sp> listC = com.byazt.hk.c.c().c(str, ttVar3, ttVar3.n());
        if (listC == null || listC.size() <= 0) {
            return false;
        }
        int mediationRitReqType = listC.get(0).c.getMediationRitReqType(ttVar3.c());
        da daVar2 = daVar;
        com.byazt.ng.a.c(daVar, ttVar3, com.byazt.hk.c.c().c(str), !ttVar.yv(), 1, i, 3, mediationRitReqType, null, -1L, false, false, SystemClock.elapsedRealtime() - ttVar.cu());
        com.byazt.tjo.a.c(ttVar.ve(), ttVar.c(daVar2), ttVar.cu());
        ArrayList arrayList = new ArrayList();
        for (com.byazt.ix.sp spVar : listC) {
            spVar.c.setMediationRitReqType(3);
            spVar.c.setMediationRitReqTypeSrc(mediationRitReqType);
            spVar.c.setTimeoutFill(false);
            spVar.c.setIsCallback(false);
            com.byazt.qv.a.c(spVar.c, ttVar3.gt(), str);
            arrayList.add(spVar.c);
            daVar2 = daVar2;
        }
        da daVar3 = daVar2;
        com.byazt.ng.a.c(listC.get(0).c, 0, "adn cache命中", 0L, ttVar3, i, arrayList.size(), 2, null, 0L, -1L);
        com.byazt.tjo.a.c(ttVar.ve(), ttVar.tt(daVar3), ttVar.cu());
        ttVar2.c(arrayList, daVar3);
        return true;
    }
}
