package com.kwad.sdk.core.b.a;

import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class gu implements com.kwad.sdk.core.d<com.kwad.components.core.webview.jshandler.m.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.jshandler.m.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.jshandler.m.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.jshandler.m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.apH = jSONObject.optString("apkUrl");
        if (JSONObject.NULL.toString().equals(aVar.apH)) {
            aVar.apH = "";
        }
        aVar.packageName = jSONObject.optString(ALPParamConstant.PACKAGENAME);
        if (JSONObject.NULL.toString().equals(aVar.packageName)) {
            aVar.packageName = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.jshandler.m.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.apH;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "apkUrl", aVar.apH);
        }
        String str2 = aVar.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, ALPParamConstant.PACKAGENAME, aVar.packageName);
        }
        return jSONObject;
    }
}
