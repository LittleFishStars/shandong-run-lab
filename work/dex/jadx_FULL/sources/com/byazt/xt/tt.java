package com.byazt.xt;

import android.os.SystemClock;
import com.byazt.nbs.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE, 13})
public class tt implements c {
    @Override // com.byazt.xt.c
    public void c(c.InterfaceC0584c interfaceC0584c) {
        com.byazt.dv.tt ttVarC = interfaceC0584c.c();
        com.byazt.iz.tt ttVarTt = interfaceC0584c.tt();
        da daVarX = ttVarC.x();
        if (daVarX != null) {
            interfaceC0584c.c(this);
            return;
        }
        com.byazt.pp.c cVar = new com.byazt.pp.c(840040, com.byazt.pp.c.c(840040));
        cVar.c("is_dex_adapter", Integer.valueOf(ttVarC.pf() ? 1 : 0));
        com.byazt.ng.a.c(daVarX, ttVarTt.gu(), "", ttVarC.n(), 2, ttVarC.ve(), ttVarC.sp(), ttVarC.a(), cVar, -1L, ttVarTt.pf().n, false, SystemClock.elapsedRealtime() - ttVarTt.cu());
        com.byazt.tjo.a.c(ttVarTt.ve(), ttVarTt.c(daVarX), ttVarTt.cu());
        com.byazt.ng.a.c(cVar, ttVarTt.gu(), daVarX, ttVarC.ve(), ttVarC.sp(), ttVarC.a(), "", 0L, (String) null, (String) null, (String) null, 0L);
        com.byazt.tjo.a.c(ttVarTt.ve(), ttVarTt.ve(daVarX), ttVarTt.cu());
        ttVarC.c(cVar, daVarX);
    }
}
