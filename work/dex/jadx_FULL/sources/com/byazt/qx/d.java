package com.byazt.qx;

import com.byazt.el.SSWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 512})
public class d extends com.byazt.pct.n<JSONObject, JSONObject> {
    public WeakReference<SSWebView> c;

    public d(SSWebView sSWebView) {
        this.c = new WeakReference<>(sSWebView);
    }

    public static void c(com.byazt.pct.nu nuVar, SSWebView sSWebView) {
        nuVar.c("preventTouchEvent", (com.byazt.pct.n<?, ?>) new d(sSWebView));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = this.c.get();
            if (sSWebView != null) {
                sSWebView.setIsPreventTouchEvent(zOptBoolean);
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        } catch (Throwable unused) {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
