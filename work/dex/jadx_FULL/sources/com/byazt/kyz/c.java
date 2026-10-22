package com.byazt.kyz;

import android.content.Context;
import com.byazt.ete.ic;
import com.byazt.ete.p;
import com.byazt.ete.u;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 546, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f28760a;
    public com.byazt.lsp.tt c;
    public ic n;
    public JSONObject tt;
    public final Context uj = gt.getContext();
    public tt ve;

    public c(ic icVar, u uVar) {
        this.n = icVar;
        this.f28760a = uVar;
    }

    public void c(com.byazt.lsp.tt ttVar) {
        this.c = ttVar;
    }

    public Context getContext() {
        return this.uj;
    }

    public JSONObject tt() {
        JSONObject jSONObject = new JSONObject();
        if (!p.c()) {
            return jSONObject;
        }
        try {
            com.byazt.lsp.tt ttVar = this.c;
            if (ttVar != null) {
                JSONObject jSONObjectC = ttVar.c();
                this.tt = jSONObjectC;
                return jSONObjectC;
            }
        } catch (Exception e) {
            m.tt("xeasy", e.getMessage());
        }
        return jSONObject;
    }

    public void ve() {
        if (p.c()) {
            m.c("xeasy", "oc");
            com.byazt.lsp.tt ttVar = this.c;
            if (ttVar != null) {
                ttVar.tt();
            }
        }
    }

    public void c(tt ttVar) {
        this.ve = ttVar;
    }

    public ic c() {
        return this.n;
    }

    public void c(ic icVar) {
        if (this.c != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("style_category", String.valueOf(p.uj(icVar)));
            } catch (JSONException e) {
                m.c(e);
            }
            this.c.c(jSONObject);
        }
    }

    public void c(boolean z, JSONObject jSONObject) {
        if (p.c()) {
            m.c("xeasy", "er:".concat(String.valueOf(z)));
            com.byazt.lsp.tt ttVar = this.c;
            if (ttVar != null) {
                if (z) {
                    ttVar.tt(jSONObject);
                    return;
                }
                HashMap map = new HashMap();
                map.put("estimatedArea", this.tt);
                map.put("realArea", this.ve.getMaxRectJson());
                map.put("exceedAreaRate", Double.valueOf(this.ve.getExceedAreaRate()));
                map.put("widgetArea", this.ve.getActualRectJson());
                com.byazt.sy.ve.tt(this.n, this.f28760a, false, 100, new JSONObject(map));
                this.c.ve(jSONObject);
            }
        }
    }

    public void c(ic icVar, float f, float f2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("convert", 0);
            jSONObject.put("down_x", f);
            jSONObject.put("down_y", f2);
        } catch (Exception e) {
            m.c("xeasy", "e:" + e.getMessage());
        }
        com.byazt.sy.ve.tt(icVar, this.f28760a, false, jSONObject);
    }
}
