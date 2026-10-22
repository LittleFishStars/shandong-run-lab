package com.byazt.ky;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 677, 15})
public class uj implements com.byazt.zyd.ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.ha.ve f28759a;
    public int c = 0;
    public int tt = 0;
    public int ve = 0;
    public boolean uj = false;
    public com.byazt.aas.c.tt n = new com.byazt.aas.c.tt() { // from class: com.byazt.ky.uj.1
        @Override // com.byazt.aas.c.tt
        public void onAppBackground() {
            if (com.byazt.omf.x.m().d()) {
                return;
            }
            uj ujVar = uj.this;
            if (ujVar.uj || ujVar.f28759a == null || uj.this.f28759a.i == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("ad_load_id", uj.this.f28759a.c);
                jSONObject.putOpt("ad_show_id", uj.this.f28759a.c());
                jSONObject.putOpt("node_line_name", "ad_node_line");
                uj ujVar2 = uj.this;
                ujVar2.c(ujVar2.f28759a.c(), jSONObject);
                com.byazt.qcl.uj.c(jSONObject, uj.this.f28759a, uj.this.f28759a.f28600a, "ad_show");
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

    @Override // com.byazt.zyd.ve
    public void a(com.byazt.ha.ve veVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdShowNodeLineObserver onClicked : " + veVar.c() + " rit:" + veVar.x + "  adType:" + veVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        if (c() && !this.uj) {
            this.f28759a = veVar;
            com.byazt.omf.x.m().ve().c(this.n);
        }
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("ad_show", "clicked", xVar != null ? xVar.c() : System.currentTimeMillis());
        veVar.f28600a.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, veVar.i, veVar);
        this.ve++;
        if (this.tt == 0) {
            veVar.da = 2;
        }
    }

    @Override // com.byazt.zyd.ve
    public void n(com.byazt.ha.ve veVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdShowNodeLineObserver onInvisibled : " + veVar.c() + " rit:" + veVar.x + "  adType:" + veVar.sp + " source:" + veVar.ve);
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("ad_show", "invisibled", xVar != null ? xVar.c() : System.currentTimeMillis(), veVar.ve);
        veVar.f28600a.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, veVar.i, veVar);
    }

    @Override // com.byazt.zyd.ve
    public void sp(com.byazt.ha.ve veVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdShowNodeLineObserver onEnd : " + veVar.c() + " rit:" + veVar.x + "  adType:" + veVar.sp + " source:" + veVar.tt);
        if (this.uj) {
            return;
        }
        this.uj = true;
        com.byazt.omf.x.m().ve().tt(this.n);
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("ad_show", "end", xVar != null ? xVar.c() : System.currentTimeMillis(), veVar.tt);
        veVar.f28600a.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, veVar.i, veVar);
        c(veVar);
    }

    @Override // com.byazt.zyd.ve
    public void tt(com.byazt.ha.ve veVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdShowNodeLineObserver onStarted : " + veVar.c() + " rit:" + veVar.x + "  adType:" + veVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        if (c() && !this.uj) {
            this.f28759a = veVar;
            com.byazt.omf.x.m().ve().c(this.n);
        }
        this.c++;
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("ad_show", "started", xVar != null ? xVar.c() : System.currentTimeMillis());
        veVar.f28600a.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, veVar.i, veVar);
    }

    @Override // com.byazt.zyd.ve
    public void uj(com.byazt.ha.ve veVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdShowNodeLineObserver onVisibled : " + veVar.c() + " rit:" + veVar.x + "  adType:" + veVar.sp + " source:" + veVar.ve);
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("ad_show", "visibled", xVar != null ? xVar.c() : System.currentTimeMillis(), veVar.ve);
        veVar.f28600a.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, veVar.i, veVar);
    }

    @Override // com.byazt.zyd.ve
    public void ve(com.byazt.ha.ve veVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdShowNodeLineObserver onShowed : " + veVar.c() + " rit:" + veVar.x + "  adType:" + veVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        if (c() && !this.uj) {
            this.f28759a = veVar;
            com.byazt.omf.x.m().ve().c(this.n);
        }
        boolean zOq = gt.tt().oq();
        if (!veVar.uj || zOq) {
            com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("ad_show", "showed", xVar != null ? xVar.c() : System.currentTimeMillis());
            ttVar.c(veVar.n);
            this.tt++;
            veVar.f28600a.add(ttVar);
            com.byazt.qcl.ve.c(ttVar, veVar.i, veVar);
            if (this.tt > 1) {
                veVar.da = 1;
            }
        }
    }

    @Override // com.byazt.zyd.ve
    public void c(com.byazt.ha.ve veVar, com.byazt.ip.x xVar) {
        m.c("Tme_node_line", "TTAdShowNodeLineObserver onCreated : " + veVar.c() + " rit:" + veVar.x + "  adType:" + veVar.sp + " source:" + com.byazt.qcl.uj.c(xVar));
        com.byazt.qcl.tt ttVar = new com.byazt.qcl.tt("ad_show", "created", xVar != null ? xVar.c() : System.currentTimeMillis());
        veVar.f28600a.add(ttVar);
        com.byazt.qcl.ve.c(ttVar, veVar.i, veVar);
    }

    private void c(com.byazt.ha.ve veVar) {
        if (veVar == null || veVar.i == null) {
            return;
        }
        m.c("Tme_node_line", "show_observer_send  l_id:" + veVar.c() + "  load_l_id:" + veVar.c + "  n_l:" + com.byazt.qcl.uj.c(veVar.f28600a));
        for (com.byazt.qcl.tt ttVar : veVar.f28600a) {
            m.c("Tme_node_line", "lifecycleType:" + ttVar.tt() + "  eventType:" + ttVar.c() + "  ts:" + ttVar.ve() + "  source:" + ttVar.uj());
        }
        if (!(this.tt == 0 && this.ve == 0 && this.c == 0) && c()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("ad_load_id", veVar.c);
                jSONObject.putOpt("ad_show_id", veVar.c());
                c(veVar.c(), jSONObject);
                com.byazt.qcl.uj.c(veVar.f28600a, veVar, "ad_node_line", jSONObject);
                com.byazt.qcl.uj.c(com.byazt.qcl.c.c("ad_show") + veVar.c(), veVar.sl);
                com.byazt.rgb.tt.uj(veVar.c());
            } catch (Throwable unused) {
            }
        }
    }

    private boolean c() {
        return gt.tt().vl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        Object objUj = com.byazt.rgb.tt.uj(str, 0);
        Object objUj2 = com.byazt.rgb.tt.uj(str, 1);
        Object objUj3 = com.byazt.rgb.tt.uj(str, 2);
        try {
            if (objUj instanceof JSONObject) {
                jSONObject.putOpt("key_element_info", objUj);
            }
            if (objUj2 instanceof JSONArray) {
                jSONObject.putOpt("no_action_array", objUj2);
            }
            if (objUj3 instanceof JSONObject) {
                jSONObject.putOpt("motion_info", objUj3);
            }
        } catch (JSONException unused) {
        }
    }
}
