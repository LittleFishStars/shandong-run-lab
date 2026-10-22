package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class bh implements com.kwad.sdk.core.d<com.kwad.sdk.m.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.m.a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.m.a.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.m.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.bnf = jSONObject.optString("nodeClassName");
        if (JSONObject.NULL.toString().equals(bVar.bnf)) {
            bVar.bnf = "";
        }
        bVar.bng = jSONObject.optString("childFieldName");
        if (JSONObject.NULL.toString().equals(bVar.bng)) {
            bVar.bng = "";
        }
        bVar.bnh = jSONObject.optBoolean("childFieldIsStatic");
        bVar.bni = jSONObject.optString("reportKey");
        if (JSONObject.NULL.toString().equals(bVar.bni)) {
            bVar.bni = "";
        }
        com.kwad.sdk.m.a.b.C1302b c1302b = new com.kwad.sdk.m.a.b.C1302b();
        bVar.bnj = c1302b;
        c1302b.parseJson(jSONObject.optJSONObject("childMethod"));
        com.kwad.sdk.m.a.b bVar2 = new com.kwad.sdk.m.a.b();
        bVar.bnk = bVar2;
        bVar2.parseJson(jSONObject.optJSONObject("deepNode"));
    }

    private static JSONObject b(com.kwad.sdk.m.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.bnf;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "nodeClassName", bVar.bnf);
        }
        String str2 = bVar.bng;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "childFieldName", bVar.bng);
        }
        boolean z = bVar.bnh;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "childFieldIsStatic", z);
        }
        String str3 = bVar.bni;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "reportKey", bVar.bni);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "childMethod", bVar.bnj);
        com.kwad.sdk.utils.ac.a(jSONObject, "deepNode", bVar.bnk);
        return jSONObject;
    }
}
