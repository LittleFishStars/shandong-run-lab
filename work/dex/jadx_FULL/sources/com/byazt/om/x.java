package com.byazt.om;

import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 554, 71})
public class x implements c {
    public int c = 0;

    @Override // com.byazt.om.c
    public void tt(c.InterfaceC0486c interfaceC0486c) {
        interfaceC0486c.c((String) null);
    }

    @Override // com.byazt.om.c
    public void c(c.InterfaceC0486c interfaceC0486c) {
        String strNb = interfaceC0486c.c().m().nb();
        com.byazt.ll.tt ttVarGu = interfaceC0486c.c().gu();
        boolean zYv = interfaceC0486c.c().yv();
        if (com.byazt.ix.uj.c().ve(strNb, ttVarGu.n())) {
            boolean z = com.byazt.ix.uj.c().c(strNb) == null;
            if (!zYv && !z && c(strNb, ttVarGu, interfaceC0486c.c())) {
                interfaceC0486c.c().uj(true);
                c(ttVarGu, strNb, interfaceC0486c.c().m(), interfaceC0486c.c());
                return;
            }
            com.byazt.ix.uj.c().c(strNb, ttVarGu);
        }
        interfaceC0486c.c(interfaceC0486c.c());
    }

    private boolean c(String str, com.byazt.ll.tt ttVar, com.byazt.iz.tt ttVar2) {
        List<com.byazt.ix.sp> listUj;
        com.byazt.nbs.tt ttVarM = ttVar2.m();
        if (com.byazt.ix.uj.c().c(str, ttVar, ttVarM != null ? ttVarM.lo() : null) && (listUj = com.byazt.ix.uj.c().uj(str)) != null && listUj.size() > 0) {
            for (com.byazt.ix.sp spVar : listUj) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(spVar.c);
                ttVar2.tt(arrayList);
            }
            if (ttVar2.sl().size() > 0 || ttVar2.yp().size() > 0 || ttVar2.t().size() > 0) {
                com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(str) + "--==-- hit cache!!! -----");
                return true;
            }
        }
        com.byazt.eu.tt.tt(MediationConstant.TAG, com.byazt.eu.uj.c(str) + "--==-- not hit cache!!! -----");
        return false;
    }

    private void c(com.byazt.ll.tt ttVar, String str, com.byazt.nbs.tt ttVar2, final com.byazt.iz.tt ttVar3) {
        com.byazt.ll.tt ttVarTt = com.byazt.ix.uj.c().tt(str);
        if (ttVarTt != null) {
            ttVar.c(ttVarTt.c());
            ttVar.tt(ttVarTt.ve());
        }
        com.byazt.ix.uj.c().c(str, ttVar);
        com.byazt.ng.a.c(ttVar3.gu(), ttVar2.lo(), !ttVar3.yv(), ttVar3.pf().c, 0, (Map<String, Object>) null);
        com.byazt.yl.ve veVar = null;
        com.byazt.qv.c.c(ttVar3, null, false);
        com.byazt.ix.tt ttVarVe = com.byazt.ix.uj.c().ve(str);
        if (ttVarVe != null) {
            ttVar3.c(ttVarVe.uj() != null ? ttVarVe.uj().pf() : null);
            ttVar3.c(ttVarVe.e_());
        }
        final int iTt = com.byazt.ix.uj.c().tt(str, ttVar.n());
        if (iTt == 2) {
            this.c = 1;
            ttVar3.c(1);
            ttVar3.x();
            return;
        }
        if (iTt != 3 && iTt != 4) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==-- 预缓存reqType错误：reqType = ".concat(String.valueOf(iTt)));
            return;
        }
        long jN = com.byazt.ix.uj.n(str);
        long jCurrentTimeMillis = System.currentTimeMillis() - jN;
        if (jN != -1 && jCurrentTimeMillis < ttVar2.sp()) {
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==-- 预缓存补充请求无需发起，时间间隔不够，interval：" + jCurrentTimeMillis + ", config interval: " + ttVar2.sp());
            this.c = 3;
            ttVar3.c(3);
            ttVar3.x();
            return;
        }
        List<com.byazt.yl.ve> listC = ttVar3.c(false);
        if (listC != null && listC.size() > 0) {
            veVar = listC.get(0);
        }
        com.byazt.yl.ve veVar2 = veVar;
        final double dC = c(str, ttVar.my());
        if (veVar2 != null && !veVar2.isPAd() && veVar2.getCpm() < dC) {
            com.byazt.ix.uj.c().c(ttVar3.getContext(), str, iTt, ttVar, veVar2, new com.byazt.ix.uj.ve() { // from class: com.byazt.om.x.1
                @Override // com.byazt.ix.uj.ve
                public void c(String str2, boolean z, int i, List<com.byazt.yl.ve> list) {
                    x.this.c(str2, z, i, list, iTt, dC, ttVar3);
                }
            });
            return;
        }
        com.byazt.eu.tt.tt(MediationConstant.TAG, "--==-- 预缓存补充请求无需发起，已经命中最优");
        this.c = 4;
        ttVar3.c(4);
        ttVar3.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, boolean z, int i, List<com.byazt.yl.ve> list, int i2, double d, com.byazt.iz.tt ttVar) {
        if (z) {
            if (i2 == 4) {
                com.byazt.yl.ve veVar = (list == null || list.size() <= 0) ? null : list.get(0);
                if (veVar != null && veVar.getCpm() >= d) {
                    this.c = 6;
                } else {
                    this.c = 7;
                }
            } else if (i2 == 3) {
                this.c = 5;
            }
        } else if (i == 10003) {
            this.c = 9;
        } else if (i == 10086) {
            this.c = 8;
        }
        ttVar.c(this.c);
        ttVar.tt(list);
        com.byazt.eu.tt.tt(MediationConstant.TAG, "--==-- 预缓存补充请求结束，对外给出回调");
        ttVar.x();
    }

    private double c(String str, int i) {
        com.byazt.nbs.tt ttVarC = com.byazt.ck.uj.c().c(str, i, 102);
        double dGr = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (ttVarC == null) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        for (com.byazt.nbs.da daVar : ttVarC.l()) {
            if (daVar.pf() && daVar.gr() > dGr) {
                dGr = daVar.gr();
            }
        }
        return dGr;
    }
}
