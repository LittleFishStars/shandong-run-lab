package com.kwad.sdk.core.b.a;

import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ed implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.a.C1232a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.webview.a.a.C1232a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.webview.a.a.C1232a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.webview.a.a.C1232a c1232a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1232a.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(c1232a.url)) {
            c1232a.url = "";
        }
        c1232a.packageName = jSONObject.optString(ALPParamConstant.PACKAGENAME);
        if (JSONObject.NULL.toString().equals(c1232a.packageName)) {
            c1232a.packageName = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.webview.a.a.C1232a c1232a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c1232a.url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "url", c1232a.url);
        }
        String str2 = c1232a.packageName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, ALPParamConstant.PACKAGENAME, c1232a.packageName);
        }
        return jSONObject;
    }
}
