package com.byazt.xt;

import android.os.SystemClock;
import android.util.Pair;
import com.byazt.hr.i;
import com.byazt.hr.sl;
import com.byazt.hr.t;
import com.byazt.hr.yp;
import com.byazt.nbs.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE, 15})
public class uj implements c {
    @Override // com.byazt.xt.c
    public void c(c.InterfaceC0584c interfaceC0584c) {
        com.byazt.pp.c cVar;
        com.byazt.dv.tt ttVarC = interfaceC0584c.c();
        com.byazt.iz.tt ttVarTt = interfaceC0584c.tt();
        da daVarX = ttVarC.x();
        String strGt = ttVarTt.gu().gt();
        if (daVarX != null) {
            if (daVarX.uj() && !sl.c().ve(strGt, daVarX.rh())) {
                com.byazt.eu.tt.tt("TMe", "adn 请求触发次数拦截............");
                Pair<String, String> pairC = sl.c().c(strGt, daVarX.rh());
                com.byazt.pp.c ttVar = pairC != null ? new com.byazt.bnd.tt(41041, com.byazt.pp.c.c(41041), (String) pairC.second, (String) pairC.first) : new com.byazt.pp.c(41041, com.byazt.pp.c.c(41041));
                com.byazt.ng.a.c(daVarX, ttVarTt.gu(), com.byazt.hk.c.c().c(daVarX.rh()), ttVarC.n(), 2, ttVarC.ve(), ttVarC.sp(), ttVarC.a(), ttVar, -1L, ttVarTt.pf().n, false, SystemClock.elapsedRealtime() - ttVarTt.cu());
                com.byazt.tjo.a.c(ttVarTt.ve(), ttVarTt.c(daVarX), ttVarTt.cu());
                com.byazt.ng.a.c(ttVar, ttVarTt.gu(), daVarX, ttVarC.ve(), ttVarC.sp(), ttVarC.a(), com.byazt.hk.c.c().c(daVarX.rh()), 0L, (String) null, (String) null, (String) null, 0L);
                com.byazt.tjo.a.c(ttVarTt.ve(), ttVarTt.ve(daVarX), ttVarTt.cu());
                ttVarC.c(ttVar, daVarX);
                return;
            }
            if (daVarX.uj() && !t.c().ve(strGt, daVarX.rh())) {
                com.byazt.eu.tt.tt("TMe", "adn 请求触发时间间隔拦截............");
                i iVarUj = t.c().uj(strGt, daVarX.rh());
                if (iVarUj != null) {
                    String strC = com.byazt.pp.c.c(41042);
                    StringBuilder sb = new StringBuilder();
                    sb.append(t.c().c(strGt, daVarX.rh()));
                    cVar = new com.byazt.bnd.ve(41042, strC, sb.toString(), iVarUj.da());
                } else {
                    cVar = new com.byazt.pp.c(41042, com.byazt.pp.c.c(41042));
                }
                com.byazt.pp.c cVar2 = cVar;
                com.byazt.ng.a.c(daVarX, ttVarTt.gu(), com.byazt.hk.c.c().c(daVarX.rh()), ttVarC.n(), 2, ttVarC.ve(), ttVarC.sp(), ttVarC.a(), cVar2, -1L, ttVarTt.pf().n, false, SystemClock.elapsedRealtime() - ttVarTt.cu());
                com.byazt.tjo.a.c(ttVarTt.ve(), ttVarTt.c(daVarX), ttVarTt.cu());
                com.byazt.ng.a.c(cVar2, ttVarTt.gu(), daVarX, ttVarC.ve(), ttVarC.sp(), ttVarC.a(), com.byazt.hk.c.c().c(daVarX.rh()), 0L, (String) null, (String) null, (String) null, 0L);
                com.byazt.tjo.a.c(ttVarTt.ve(), ttVarTt.ve(daVarX), ttVarTt.cu());
                ttVarC.c(cVar2, daVarX);
                return;
            }
            if (yp.c().c(strGt, daVarX.nu())) {
                com.byazt.pp.c cVarC = yp.c().c(strGt, daVarX.z(), daVarX.rh());
                if (cVarC != null) {
                    com.byazt.eu.tt.tt("TMe", "adn 请求触发了rit级别的错误码拦截............");
                    com.byazt.ng.a.c(daVarX, ttVarTt.gu(), com.byazt.hk.c.c().c(daVarX.rh()), ttVarC.n(), 2, ttVarC.ve(), ttVarC.sp(), ttVarC.a(), cVarC, -1L, ttVarTt.pf().n, false, SystemClock.elapsedRealtime() - ttVarTt.cu());
                    com.byazt.tjo.a.c(ttVarTt.ve(), ttVarTt.c(daVarX), ttVarTt.cu());
                    com.byazt.ng.a.c(cVarC, ttVarTt.gu(), daVarX, ttVarC.ve(), ttVarC.sp(), ttVarC.a(), com.byazt.hk.c.c().c(daVarX.rh()), 0L, (String) null, (String) null, (String) null, 0L);
                    com.byazt.tjo.a.c(ttVarTt.ve(), ttVarTt.ve(daVarX), ttVarTt.cu());
                    ttVarC.c(cVarC, daVarX);
                    return;
                }
            } else {
                com.byazt.pp.c cVarC2 = com.byazt.hr.ve.c().c(daVarX.z(), daVarX.rh());
                if (cVarC2 != null) {
                    com.byazt.eu.tt.tt("TMe", "adn 请求触发了错误码拦截............");
                    com.byazt.ng.a.c(daVarX, ttVarTt.gu(), com.byazt.hk.c.c().c(daVarX.rh()), ttVarC.n(), 2, ttVarC.ve(), ttVarC.sp(), ttVarC.a(), cVarC2, -1L, ttVarTt.pf().n, false, SystemClock.elapsedRealtime() - ttVarTt.cu());
                    com.byazt.tjo.a.c(ttVarTt.ve(), ttVarTt.c(daVarX), ttVarTt.cu());
                    com.byazt.ng.a.c(cVarC2, ttVarTt.gu(), daVarX, ttVarC.ve(), ttVarC.sp(), ttVarC.a(), com.byazt.hk.c.c().c(daVarX.rh()), 0L, (String) null, (String) null, (String) null, 0L);
                    com.byazt.tjo.a.c(ttVarTt.ve(), ttVarTt.ve(daVarX), ttVarTt.cu());
                    ttVarC.c(cVarC2, daVarX);
                    return;
                }
            }
        }
        interfaceC0584c.c(this);
    }
}
