package com.byazt.xt;

import android.os.SystemClock;
import com.byazt.nbs.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE, 91})
public class sp implements c {
    @Override // com.byazt.xt.c
    public void c(c.InterfaceC0584c interfaceC0584c) {
        com.byazt.qv.n.c cVarC;
        com.byazt.iz.tt ttVarTt = interfaceC0584c.tt();
        com.byazt.dv.tt ttVarC = interfaceC0584c.c();
        if (ttVarTt != null && ttVarC != null) {
            com.byazt.ll.tt ttVarGu = ttVarTt.gu();
            da daVarX = ttVarC.x();
            if (ttVarGu != null && daVarX != null && (cVarC = com.byazt.qv.n.c(ttVarGu, daVarX)) != null) {
                com.byazt.pp.c cVar = new com.byazt.pp.c(81018, cVarC.c);
                cVar.c("is_dex_adapter", Integer.valueOf(ttVarC.pf() ? 1 : 0));
                com.byazt.ng.a.c(daVarX, ttVarGu, com.byazt.hk.c.c().c(daVarX.rh()), ttVarC.n(), 2, ttVarC.ve(), ttVarC.sp(), ttVarC.a(), cVar, -1L, false, false, SystemClock.elapsedRealtime() - ttVarTt.cu());
                com.byazt.tjo.a.c(ttVarTt.ve(), ttVarTt.c(daVarX), ttVarTt.cu());
                com.byazt.ng.a.c(cVar, ttVarGu, daVarX, ttVarC.ve(), ttVarC.sp(), ttVarC.a(), com.byazt.hk.c.c().c(daVarX.rh()), 0L, (String) null, (String) null, (String) null, 0L);
                com.byazt.tjo.a.c(ttVarTt.ve(), ttVarTt.ve(daVarX), ttVarTt.cu());
                ttVarC.c(cVar, daVarX);
                return;
            }
        }
        interfaceC0584c.c(this);
    }
}
