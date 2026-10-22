package com.byazt.ky;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 677, 71})
public class x implements com.byazt.zyd.sp {
    public com.byazt.ha.x n;
    public boolean uj;
    public List<com.byazt.qcl.tt> ve = new CopyOnWriteArrayList();
    public boolean c = false;
    public com.byazt.aas.c.tt tt = new com.byazt.aas.c.tt() { // from class: com.byazt.ky.x.1
        @Override // com.byazt.aas.c.tt
        public void onAppBackground() {
            if (com.byazt.omf.x.m().d()) {
                return;
            }
            x xVar = x.this;
            if (xVar.c || xVar.n == null || x.this.n.i == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", x.this.n.c());
                if (!TextUtils.isEmpty(x.this.n.tt)) {
                    jSONObject.putOpt("style_id", x.this.n.tt);
                }
                jSONObject.putOpt("style_category", Integer.valueOf(x.this.n.ve));
                jSONObject.putOpt("component_type", Integer.valueOf(x.this.n.c));
                jSONObject.putOpt("render_sequence", Integer.valueOf(x.this.n.uj));
                jSONObject.putOpt("display_area", Integer.valueOf(x.this.n.n));
                jSONObject.putOpt("node_line_name", "easy_play_node_line");
                com.byazt.qcl.uj.c(jSONObject, x.this.n, (List<com.byazt.qcl.tt>) x.this.ve, "easy_play");
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

    @Override // com.byazt.zyd.sp
    public void a(com.byazt.ha.x xVar, com.byazt.ip.x xVar2) {
        c(xVar);
        this.uj = true;
        m.c("Tme_node_line", "TTEasyPlayNodeLineObserver onShowed " + xVar.c() + " rit:" + xVar.x + "  adType:" + xVar.sp + " source:" + com.byazt.qcl.uj.c(xVar2));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("easy_play", "showed", xVar2 != null ? xVar2.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar2));
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, xVar.i, xVar);
    }

    @Override // com.byazt.zyd.sp
    public void n(com.byazt.ha.x xVar, com.byazt.ip.x xVar2) {
        c(xVar);
        this.uj = true;
        m.c("Tme_node_line", "TTEasyPlayNodeLineObserver onRendered " + xVar.c() + " rit:" + xVar.x + "  adType:" + xVar.sp + " source:" + com.byazt.qcl.uj.c(xVar2));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("easy_play", "rendered", xVar2 != null ? xVar2.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar2));
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, xVar.i, xVar);
    }

    @Override // com.byazt.zyd.sp
    public void sp(com.byazt.ha.x xVar, com.byazt.ip.x xVar2) {
        c(xVar);
        this.uj = true;
        m.c("Tme_node_line", "TTEasyPlayNodeLineObserver onClicked " + xVar.c() + " rit:" + xVar.x + "  adType:" + xVar.sp + " source:" + com.byazt.qcl.uj.c(xVar2));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("easy_play", "clicked", xVar2 != null ? xVar2.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, xVar.i, xVar);
    }

    @Override // com.byazt.zyd.sp
    public void uj(com.byazt.ha.x xVar, com.byazt.ip.x xVar2) {
        c(xVar);
        this.uj = true;
        m.c("Tme_node_line", "TTEasyPlayNodeLineObserver onRenderStarted " + xVar.c() + " rit:" + xVar.x + "  adType:" + xVar.sp + " source:" + com.byazt.qcl.uj.c(xVar2));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("easy_play", "render_started", xVar2 != null ? xVar2.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, xVar.i, xVar);
    }

    @Override // com.byazt.zyd.sp
    public void ve(com.byazt.ha.x xVar, com.byazt.ip.x xVar2) {
        c(xVar);
        this.uj = true;
        m.c("Tme_node_line", "TTEasyPlayNodeLineObserver onLoaded " + xVar.c() + " rit:" + xVar.x + "  adType:" + xVar.sp + " source:" + com.byazt.qcl.uj.c(xVar2));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("easy_play", "loaded", xVar2 != null ? xVar2.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar2));
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, xVar.i, xVar);
    }

    @Override // com.byazt.zyd.sp
    public void x(com.byazt.ha.x xVar, com.byazt.ip.x xVar2) {
        m.c("Tme_node_line", "TTEasyPlayNodeLineObserver onEnd " + xVar.c() + " rit:" + xVar.x + "  adType:" + xVar.sp + " source:" + com.byazt.qcl.uj.c(xVar2));
        if (this.c) {
            return;
        }
        this.c = true;
        com.byazt.omf.x.m().ve().tt(this.tt);
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("easy_play", "end", xVar2 != null ? xVar2.c() : System.currentTimeMillis(), com.byazt.qcl.uj.c(xVar2));
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, xVar.i, xVar);
        if (this.uj) {
            tt(xVar);
        }
    }

    private boolean c() {
        return gt.tt().vl();
    }

    @Override // com.byazt.zyd.sp
    public void tt(com.byazt.ha.x xVar, com.byazt.ip.x xVar2) {
        c(xVar);
        this.uj = true;
        m.c("Tme_node_line", "TTEasyPlayNodeLineObserver onStarted " + xVar.c() + " rit:" + xVar.x + "  adType:" + xVar.sp + " source:" + com.byazt.qcl.uj.c(xVar2));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("easy_play", "started", xVar2 != null ? xVar2.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, xVar.i, xVar);
    }

    private void c(com.byazt.ha.x xVar) {
        if (this.n == null) {
            this.n = xVar;
        }
        if (!c() || this.c) {
            return;
        }
        this.n = xVar;
        com.byazt.omf.x.m().ve().c(this.tt);
    }

    private void tt(com.byazt.ha.x xVar) {
        if (xVar == null || xVar.i == null) {
            return;
        }
        m.c("Tme_node_line", "easy_play_observer_send  l_id:" + xVar.c() + "  n_l:" + com.byazt.qcl.uj.c(this.ve));
        for (com.byazt.qcl.tt ttVar : this.ve) {
            m.c("Tme_node_line", "lifecycleType:" + ttVar.tt() + "  eventType:" + ttVar.c() + "  ts:" + ttVar.ve() + "  source:" + ttVar.uj());
        }
        if (c()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("lifecycle_id", this.n.c());
                if (!TextUtils.isEmpty(this.n.tt)) {
                    jSONObject.putOpt("style_id", this.n.tt);
                }
                jSONObject.putOpt("style_category", Integer.valueOf(this.n.ve));
                jSONObject.putOpt("component_type", Integer.valueOf(this.n.c));
                jSONObject.putOpt("render_sequence", Integer.valueOf(this.n.uj));
                jSONObject.putOpt("display_area", Integer.valueOf(this.n.n));
                com.byazt.qcl.uj.c(this.ve, xVar, "easy_play_node_line", jSONObject);
                com.byazt.qcl.uj.c(com.byazt.qcl.c.c("easy_play") + xVar.c(), xVar.sl);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.zyd.sp
    public void c(com.byazt.ha.x xVar, com.byazt.ip.x xVar2) {
        m.c("Tme_node_line", "TTEasyPlayNodeLineObserver onCreated " + xVar.c() + " rit:" + xVar.x + "  adType:" + xVar.sp + " source:" + com.byazt.qcl.uj.c(xVar2));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("easy_play", "created", xVar2 != null ? xVar2.c() : System.currentTimeMillis());
        this.ve.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, xVar.i, xVar);
    }
}
