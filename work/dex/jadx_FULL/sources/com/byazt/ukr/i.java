package com.byazt.ukr;

import android.content.Context;
import android.os.Looper;
import com.byazt.dna.qp;
import com.byazt.nr.m;
import com.byazt.nr.rh;
import com.byazt.omf.gt;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1081, 42})
public class i implements com.byazt.vb.uj {
    @Override // com.byazt.vb.uj
    public boolean a() {
        return true;
    }

    @Override // com.byazt.vb.uj
    public com.byazt.vb.tt c(JSONObject jSONObject) {
        try {
            jSONObject.put("is_new", true);
            jSONObject.put("sdk_session_id", tt.c);
        } catch (JSONException e) {
            m.c(e);
        }
        com.byazt.fo.c cVar = new com.byazt.fo.c(UUID.randomUUID().toString(), com.byazt.qal.tt.tt().c("new_adlog_monitor").tt(jSONObject.toString()).c());
        cVar.ve((byte) 0);
        cVar.tt((byte) 2);
        cVar.c((byte) 1);
        return cVar;
    }

    @Override // com.byazt.vb.uj
    public boolean c() {
        return false;
    }

    @Override // com.byazt.vb.uj
    public int da() {
        return 0;
    }

    @Override // com.byazt.vb.uj
    public Executor i() {
        return com.byazt.bwm.n.c();
    }

    @Override // com.byazt.vb.uj
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public ExecutorService x() {
        return com.byazt.bwm.n.tt();
    }

    @Override // com.byazt.vb.uj
    public String n() {
        return ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getWebViewUA(false);
    }

    @Override // com.byazt.vb.uj
    public com.byazt.epi.ve sl() {
        return null;
    }

    @Override // com.byazt.vb.uj
    public com.byazt.gs.tt sp() {
        return new da(com.byazt.hy.n.c().tt().ve());
    }

    @Override // com.byazt.vb.uj
    public com.byazt.vb.x t() {
        return c.c;
    }

    @Override // com.byazt.vb.uj
    public String tt() {
        return "csj_";
    }

    @Override // com.byazt.vb.uj
    public String tt(String str) {
        return com.byazt.nr.c.tt(str);
    }

    @Override // com.byazt.vb.uj
    public boolean u() {
        return false;
    }

    @Override // com.byazt.vb.uj
    public boolean uj() {
        return com.byazt.ogz.i.c();
    }

    @Override // com.byazt.vb.uj
    public boolean ve() {
        return gt.tt().or();
    }

    @Override // com.byazt.vb.uj
    public boolean yp() {
        return gt.tt().zb();
    }

    @Override // com.byazt.vb.uj
    public Looper z() {
        return ((qp) com.byazt.ut.uj.getService("thread_service")).getIOHandler().getLooper();
    }

    @Override // com.byazt.vb.uj
    public boolean c(Context context) {
        return rh.c(context);
    }

    @Override // com.byazt.vb.uj
    public String c(String str) {
        return com.byazt.nr.c.ve(str);
    }

    @Override // com.byazt.vb.uj
    public void c(JSONObject jSONObject, JSONObject jSONObject2) {
        boolean zAz = gt.tt().az();
        boolean z = false;
        if (jSONObject2 != null && jSONObject2.optInt("success") == 1) {
            z = true;
        }
        if (z && zAz) {
            return;
        }
        com.byazt.ddx.uj.c(jSONObject, jSONObject2);
    }
}
