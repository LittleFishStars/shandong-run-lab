package com.byazt.ky;

import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 677, 91})
public class sp implements com.byazt.zyd.a {
    public List<com.byazt.qcl.tt> tt = new CopyOnWriteArrayList();
    public boolean c = false;

    private boolean c() {
        return gt.tt().vl();
    }

    @Override // com.byazt.zyd.a
    public void tt(com.byazt.ha.a aVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAppNodeLineObserver onForegrounded " + aVar.c() + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt(NativeCallContext.DOMAIN_APP, "foregrounded", xVar != null ? xVar.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar));
        this.tt.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, aVar.i, aVar);
    }

    @Override // com.byazt.zyd.a
    public void uj(com.byazt.ha.a aVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAppNodeLineObserver onEnd " + aVar.c() + " source:" + com.byazt.qcl.uj.c(xVar));
        if (this.c) {
            return;
        }
        this.c = true;
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt(NativeCallContext.DOMAIN_APP, "end", xVar != null ? xVar.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar));
        this.tt.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, aVar.i, aVar);
        c(aVar);
    }

    @Override // com.byazt.zyd.a
    public void ve(com.byazt.ha.a aVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAppNodeLineObserver onBackgrounded " + aVar.c() + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt(NativeCallContext.DOMAIN_APP, "backgrounded", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.tt.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, aVar.i, aVar);
        if (this.c) {
            return;
        }
        c(aVar);
    }

    @Override // com.byazt.zyd.a
    public void c(com.byazt.ha.a aVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAppNodeLineObserver onStarted " + aVar.c() + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt(NativeCallContext.DOMAIN_APP, "started", xVar != null ? xVar.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar));
        this.tt.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, aVar.i, aVar);
    }

    private void c(com.byazt.ha.a aVar) {
        if (aVar == null) {
            return;
        }
        m.c("Tme_node_line", "app_observer_send  l_id:" + aVar.c() + "  n_l:" + com.byazt.qcl.uj.c(this.tt));
        for (com.byazt.qcl.tt ttVar : this.tt) {
            m.c("Tme_node_line", "lifecycleType:" + ttVar.tt() + "  eventType:" + ttVar.c() + "  ts:" + ttVar.ve() + "  source:" + ttVar.uj());
        }
        if (c()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", aVar.c());
                jSONObject.putOpt("node_line_name", "app_node_line");
                com.byazt.qcl.uj.c(jSONObject, aVar, this.tt, NativeCallContext.DOMAIN_APP);
            } catch (Throwable unused) {
            }
        }
    }
}
