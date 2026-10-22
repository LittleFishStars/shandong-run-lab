package com.byazt.ky;

import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 677, 13})
public class tt implements com.byazt.zyd.c {
    public boolean n;
    public com.byazt.ha.c uj;
    public List<com.byazt.qcl.tt> ve = new CopyOnWriteArrayList();
    public boolean c = false;
    public com.byazt.aas.c.tt tt = new com.byazt.aas.c.tt() { // from class: com.byazt.ky.tt.1
        @Override // com.byazt.aas.c.tt
        public void onAppBackground() {
            if (!com.byazt.omf.x.m().d() && tt.this.n) {
                tt ttVar = tt.this;
                if (ttVar.c || ttVar.uj == null || tt.this.uj.i == null) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("lifecycle_id", tt.this.uj.c());
                    jSONObject.putOpt("download_type", Integer.valueOf(tt.this.uj.c));
                    jSONObject.putOpt("node_line_name", "download_node_line");
                    com.byazt.qcl.uj.c(jSONObject, tt.this.uj, (List<com.byazt.qcl.tt>) tt.this.ve, "download");
                } catch (Throwable unused) {
                }
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

    @Override // com.byazt.zyd.c
    public void a(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.n = true;
        m.c("Tme_node_line", "TTAdDownloadNodeLineObserver onDownloadPaused " + cVar.c() + " rit:" + cVar.x + "  adType:" + cVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("download", "download_paused", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, cVar.i, cVar);
    }

    @Override // com.byazt.zyd.c
    public void da(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdDownloadNodeLineObserver onEnd " + cVar.c() + " rit:" + cVar.x + "  adType:" + cVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        if (this.c) {
            return;
        }
        this.c = true;
        com.byazt.omf.x.m().ve().tt(this.tt);
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("download", "end", xVar != null ? xVar.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar));
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, cVar.i, cVar);
        if (this.n) {
            tt(cVar);
        }
    }

    @Override // com.byazt.zyd.c
    public void i(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.n = true;
        m.c("Tme_node_line", "TTAdDownloadNodeLineObserver onDownloadFinished " + cVar.c() + " rit:" + cVar.x + "  adType:" + cVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("download", "download_finished", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, cVar.i, cVar);
    }

    @Override // com.byazt.zyd.c
    public void n(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.n = true;
        m.c("Tme_node_line", "TTAdDownloadNodeLineObserver onDownloadStarted " + cVar.c() + " rit:" + cVar.x + "  adType:" + cVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("download", "download_started", xVar != null ? xVar.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar));
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, cVar.i, cVar);
    }

    @Override // com.byazt.zyd.c
    public void sp(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.n = true;
        m.c("Tme_node_line", "TTAdDownloadNodeLineObserver onDownloadFailed " + cVar.c() + " rit:" + cVar.x + "  adType:" + cVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("download", "download_failed", xVar != null ? xVar.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar));
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, cVar.i, cVar);
    }

    @Override // com.byazt.zyd.c
    public void uj(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.n = true;
        m.c("Tme_node_line", "TTAdDownloadNodeLineObserver onMarketClosed " + cVar.c() + " rit:" + cVar.x + "  adType:" + cVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("download", "market_closed", xVar != null ? xVar.c() : System.currentTimeMillis(), 1);
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, cVar.i, cVar);
    }

    @Override // com.byazt.zyd.c
    public void x(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.n = true;
        m.c("Tme_node_line", "TTAdDownloadNodeLineObserver onDownloadCanceled " + cVar.c() + " rit:" + cVar.x + "  adType:" + cVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("download", "download_canceled", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, cVar.i, cVar);
    }

    private boolean c() {
        return gt.tt().vl();
    }

    @Override // com.byazt.zyd.c
    public void tt(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.n = true;
        m.c("Tme_node_line", "TTAdDownloadNodeLineObserver onStarted " + cVar.c() + " rit:" + cVar.x + "  adType:" + cVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("download", "started", xVar != null ? xVar.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar));
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, cVar.i, cVar);
    }

    @Override // com.byazt.zyd.c
    public void ve(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.n = true;
        m.c("Tme_node_line", "TTAdDownloadNodeLineObserver onMarketOpened " + cVar.c() + " rit:" + cVar.x + "  adType:" + cVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("download", "market_opened", xVar != null ? xVar.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar));
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, cVar.i, cVar);
    }

    private void c(com.byazt.ha.c cVar) {
        if (this.uj == null) {
            this.uj = cVar;
        }
        if (!c() || this.c) {
            return;
        }
        com.byazt.omf.x.m().ve().c(this.tt);
    }

    @Override // com.byazt.zyd.c
    public void c(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdDownloadNodeLineObserver onCreated " + cVar.c() + " rit:" + cVar.x + "  adType:" + cVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("download", "created", xVar != null ? xVar.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, cVar.i, cVar);
    }

    private void tt(com.byazt.ha.c cVar) {
        if (cVar == null || cVar.i == null) {
            return;
        }
        m.c("Tme_node_line", "download_observer_send  l_id:" + cVar.c() + "  n_l:" + com.byazt.qcl.uj.c(this.ve));
        for (com.byazt.qcl.tt ttVar : this.ve) {
            m.c("Tme_node_line", "lifecycleType:" + ttVar.tt() + "  eventType:" + ttVar.c() + "  ts:" + ttVar.ve() + "  source:" + ttVar.uj());
        }
        if (c()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", cVar.c());
                jSONObject.putOpt("download_type", Integer.valueOf(this.uj.c));
                com.byazt.qcl.uj.c(this.ve, cVar, "download_node_line", jSONObject);
                com.byazt.qcl.uj.c(com.byazt.qcl.c.c("download") + cVar.c(), cVar.tt());
            } catch (Throwable unused) {
            }
        }
    }
}
