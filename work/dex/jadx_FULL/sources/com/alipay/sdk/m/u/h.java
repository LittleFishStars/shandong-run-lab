package com.alipay.sdk.m.u;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h extends com.alipay.sdk.m.t.e {
    @Override // com.alipay.sdk.m.t.e
    public JSONObject a() throws JSONException {
        return com.alipay.sdk.m.t.e.a("cashier", "sdkPreheat");
    }

    @Override // com.alipay.sdk.m.t.e
    public boolean c() {
        return false;
    }

    @Override // com.alipay.sdk.m.t.e
    public String a(com.alipay.sdk.m.w.a aVar, String str, JSONObject jSONObject) {
        String strA = super.a(aVar, str, jSONObject);
        try {
            JSONObject jSONObject2 = new JSONObject(strA);
            jSONObject2.put("trdfrom", "0");
            jSONObject2.put("sourceBundleId", aVar.b().getPackageName());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("invokeFromAppName", aVar.b().getPackageName());
            jSONObject2.put("env", jSONObject3);
            return jSONObject2.toString();
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "buildBody", th);
            com.alipay.sdk.m.y.g.a(th);
            return strA;
        }
    }
}
