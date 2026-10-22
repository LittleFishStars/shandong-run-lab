package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.webview.d.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.webview.d.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aqY = jSONObject.optBoolean("clickActionButton");
        aVar.ara = jSONObject.optInt("area");
        aVar.nm = jSONObject.optInt("itemClickType");
        aVar.bdg = jSONObject.optInt("convertPageType", new Integer("-1").intValue());
        com.kwad.sdk.core.webview.d.b.d dVar = new com.kwad.sdk.core.webview.d.b.d();
        aVar.arb = dVar;
        dVar.parseJson(jSONObject.optJSONObject("logParam"));
        aVar.needReport = jSONObject.optBoolean("needReport", new Boolean("true").booleanValue());
        aVar.creativeId = jSONObject.optLong("creativeId", new Long("-1").longValue());
        aVar.Rk = jSONObject.optString("liveItemId");
        if (JSONObject.NULL.toString().equals(aVar.Rk)) {
            aVar.Rk = "";
        }
        aVar.bdh = jSONObject.optInt("sceneType");
        aVar.adStyle = jSONObject.optInt("adStyle", new Integer("-1").intValue());
        aVar.bdi = jSONObject.optBoolean("isCallbackOnly");
        aVar.bdj = jSONObject.optBoolean("disableCallback");
    }

    private static JSONObject b(com.kwad.sdk.core.webview.d.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.aqY;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clickActionButton", z);
        }
        int i = aVar.ara;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "area", i);
        }
        int i2 = aVar.nm;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "itemClickType", i2);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "convertPageType", aVar.bdg);
        com.kwad.sdk.utils.ac.a(jSONObject, "logParam", aVar.arb);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "needReport", aVar.needReport);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", aVar.creativeId);
        String str = aVar.Rk;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveItemId", aVar.Rk);
        }
        int i3 = aVar.bdh;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sceneType", i3);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "adStyle", aVar.adStyle);
        boolean z2 = aVar.bdi;
        if (z2) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isCallbackOnly", z2);
        }
        boolean z3 = aVar.bdj;
        if (z3) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableCallback", z3);
        }
        return jSONObject;
    }
}
