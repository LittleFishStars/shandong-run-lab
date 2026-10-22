package com.byazt.qx;

import com.byazt.el.SSWebView;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 184})
public class zb extends com.byazt.pct.n<JSONObject, JSONObject> {
    public SSWebView c;
    public String tt;

    public zb(SSWebView sSWebView, String str) {
        this.c = sSWebView;
        this.tt = str;
    }

    public JSONObject ve() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.byazt.omf.x.m().c(com.byazt.omf.gt.getContext()) && this.c != null) {
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "success");
                this.c.O_();
                return jSONObject;
            }
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static void c(com.byazt.pct.nu nuVar, SSWebView sSWebView, String str) {
        nuVar.c("close_wobble_observer", (com.byazt.pct.n<?, ?>) new zb(sSWebView, str));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        return ve();
    }
}
