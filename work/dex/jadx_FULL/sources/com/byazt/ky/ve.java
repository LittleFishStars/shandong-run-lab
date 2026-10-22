package com.byazt.ky;

import com.byazt.nr.m;
import com.igexin.push.core.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 677, 54})
public class ve implements com.byazt.zyd.tt {
    public List<com.byazt.qcl.tt> c = new CopyOnWriteArrayList();

    @Override // com.byazt.zyd.tt
    public void tt(com.byazt.ha.tt ttVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdLoadNodeLineObserver onReqed " + ttVar.c() + " rit:" + ttVar.x + "  adType:" + ttVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar2 = new com.byazt.qcl.tt("ad_load", "reqed", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.c.add(ttVar2);
        com.byazt.qcl.ve.c(ttVar2, ttVar.i, ttVar);
    }

    @Override // com.byazt.zyd.tt
    public void uj(com.byazt.ha.tt ttVar, com.byazt.ip.x xVar) {
        StringBuilder sb = new StringBuilder("TTAdLoadNodeLineObserver onLoaded ");
        sb.append(ttVar.c());
        sb.append(" rit:");
        sb.append(ttVar.x);
        sb.append("  adType:");
        sb.append(ttVar.sp);
        sb.append(" source:");
        sb.append(ttVar.ve ? 1 : 2);
        m.c("Tme_node_line", sb.toString());
        com.byazt.qcl.tt ttVar2 = new com.byazt.qcl.tt("ad_load", "loaded", xVar != null ? xVar.c() : System.currentTimeMillis(), ttVar.ve ? 1 : 2);
        this.c.add(ttVar2);
        com.byazt.qcl.ve.c(ttVar2, ttVar.i, ttVar);
        Iterator<String> it = ttVar.n.iterator();
        while (it.hasNext()) {
            ((com.byazt.lh.ve) com.byazt.ip.n.c(1)).c(it.next(), new com.byazt.ip.uj.c() { // from class: com.byazt.ky.ve.1
                @Override // com.byazt.ip.uj.c
                public void c(com.byazt.ip.tt ttVar3) {
                    if (ttVar3 instanceof com.byazt.ha.ve) {
                        ((com.byazt.ha.ve) ttVar3).f28600a.addAll(0, ve.this.c);
                    }
                }
            });
        }
    }

    @Override // com.byazt.zyd.tt
    public void ve(com.byazt.ha.tt ttVar, com.byazt.ip.x xVar) {
        StringBuilder sb = new StringBuilder("TTAdLoadNodeLineObserver onReceived ");
        sb.append(ttVar.c());
        sb.append(" rit:");
        sb.append(ttVar.x);
        sb.append("  adType:");
        sb.append(ttVar.sp);
        sb.append(" source:");
        sb.append(ttVar.tt ? 1 : 2);
        m.c("Tme_node_line", sb.toString());
        com.byazt.qcl.tt ttVar2 = new com.byazt.qcl.tt("ad_load", b.F, xVar != null ? xVar.c() : System.currentTimeMillis(), ttVar.tt ? 1 : 2);
        this.c.add(ttVar2);
        com.byazt.qcl.ve.c(ttVar2, ttVar.i, ttVar);
    }

    @Override // com.byazt.zyd.tt
    public void c(com.byazt.ha.tt ttVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdLoadNodeLineObserver onStarted " + ttVar.c() + " rit:" + ttVar.x + "  adType:" + ttVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar2 = new com.byazt.qcl.tt("ad_load", "started", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.c.add(ttVar2);
        com.byazt.qcl.ve.c(ttVar2, ttVar.i, ttVar);
    }
}
