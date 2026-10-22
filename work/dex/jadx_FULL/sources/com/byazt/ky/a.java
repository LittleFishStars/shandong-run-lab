package com.byazt.ky;

import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 677, 34})
public class a implements com.byazt.zyd.n {
    public com.byazt.ha.n n;
    public boolean uj;
    public List<com.byazt.qcl.tt> ve = new CopyOnWriteArrayList();
    public boolean c = false;
    public com.byazt.aas.c.tt tt = new com.byazt.aas.c.tt() { // from class: com.byazt.ky.a.1
        @Override // com.byazt.aas.c.tt
        public void onAppBackground() {
            if (com.byazt.omf.x.m().d()) {
                return;
            }
            a aVar = a.this;
            if (aVar.c || aVar.n == null || a.this.n.i == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", a.this.n.c());
                jSONObject.putOpt("container_rect", a.this.n.c);
                jSONObject.putOpt("image_rect", a.this.n.tt);
                jSONObject.putOpt("video_rect", a.this.n.ve);
                if (a.this.n.uj > 0) {
                    jSONObject.putOpt("image_mode", Integer.valueOf(a.this.n.uj));
                }
                jSONObject.putOpt("node_line_name", "view_node_line");
                com.byazt.qcl.uj.c(jSONObject, a.this.n, (List<com.byazt.qcl.tt>) a.this.ve, "view");
            } catch (Throwable unused) {
            }
        }

        @Override // com.byazt.aas.c.tt
        public void onAppExit() {
        }

        @Override // com.byazt.aas.c.tt
        public void onAppForeground() {
        }

        @Override // com.byazt.aas.c.tt
        public void onAppStart() {
        }
    };

    @Override // com.byazt.zyd.n
    public void a(com.byazt.ha.n nVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdViewNodeLineObserver onDetached " + nVar.c() + " rit:" + nVar.x + "  adType:" + nVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        c(nVar);
        this.uj = true;
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("view", "detached", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, nVar.i, nVar);
    }

    @Override // com.byazt.zyd.n
    public void n(com.byazt.ha.n nVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdViewNodeLineObserver onInvisibled " + nVar.c() + " rit:" + nVar.x + "  adType:" + nVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        c(nVar);
        this.uj = true;
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("view", "invisibled", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, nVar.i, nVar);
    }

    @Override // com.byazt.zyd.n
    public void sp(com.byazt.ha.n nVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdViewNodeLineObserver onEnd " + nVar.c() + " rit:" + nVar.x + "  adType:" + nVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        if (this.c) {
            return;
        }
        this.c = true;
        com.byazt.omf.x.m().ve().tt(this.tt);
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("view", "end", xVar != null ? xVar.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar));
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, nVar.i, nVar);
        if (this.uj) {
            tt(nVar);
        }
    }

    @Override // com.byazt.zyd.n
    public void uj(com.byazt.ha.n nVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdViewNodeLineObserver onVisibled " + nVar.c() + " rit:" + nVar.x + "  adType:" + nVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        c(nVar);
        this.uj = true;
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("view", "visibled", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, nVar.i, nVar);
    }

    @Override // com.byazt.zyd.n
    public void ve(com.byazt.ha.n nVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdViewNodeLineObserver onFocused " + nVar.c() + " rit:" + nVar.x + "  adType:" + nVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        c(nVar);
        this.uj = true;
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("view", "focused", xVar != null ? xVar.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar));
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, nVar.i, nVar);
    }

    private boolean c() {
        return gt.tt().vl();
    }

    @Override // com.byazt.zyd.n
    public void tt(com.byazt.ha.n nVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdViewNodeLineObserver onAttached " + nVar.c() + " rit:" + nVar.x + "  adType:" + nVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        c(nVar);
        this.uj = true;
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("view", "attached", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, nVar.i, nVar);
    }

    private void c(com.byazt.ha.n nVar) {
        if (this.n == null) {
            this.n = nVar;
        }
        if (!c() || this.c) {
            return;
        }
        this.n = nVar;
        com.byazt.omf.x.m().ve().c(this.tt);
    }

    private void tt(com.byazt.ha.n nVar) {
        if (nVar == null || nVar.i == null) {
            return;
        }
        m.c("Tme_node_line", "view_observer_send  l_id:" + nVar.c() + "  n_l:" + com.byazt.qcl.uj.c(this.ve));
        for (com.byazt.qcl.tt ttVar : this.ve) {
            m.c("Tme_node_line", "lifecycleType:" + ttVar.tt() + "  eventType:" + ttVar.c() + "  ts:" + ttVar.ve() + "  source:" + ttVar.uj());
        }
        if (c()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", this.n.c());
                jSONObject.putOpt("container_rect", this.n.c);
                jSONObject.putOpt("image_rect", this.n.tt);
                jSONObject.putOpt("video_rect", this.n.ve);
                int i = this.n.uj;
                if (i > 0) {
                    jSONObject.putOpt("image_mode", Integer.valueOf(i));
                }
                com.byazt.qcl.uj.c(this.ve, nVar, "view_node_line", jSONObject);
                com.byazt.qcl.uj.c(com.byazt.qcl.c.c("view") + nVar.c(), nVar.sl);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.zyd.n
    public void c(com.byazt.ha.n nVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdViewNodeLineObserver onCreated " + nVar.c() + " rit:" + nVar.x + "  adType:" + nVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("view", "created", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, nVar.i, nVar);
    }
}
