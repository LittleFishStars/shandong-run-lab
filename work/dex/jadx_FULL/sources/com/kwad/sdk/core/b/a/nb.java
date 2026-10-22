package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class nb implements com.kwad.sdk.core.d<com.kwad.sdk.m.a.b.C1302b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.m.a.b.C1302b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.m.a.b.C1302b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.m.a.b.C1302b c1302b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1302b.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(c1302b.name)) {
            c1302b.name = "";
        }
        c1302b.bns = jSONObject.optBoolean("isStatic");
        c1302b.bnt = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("paramList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                com.kwad.sdk.m.a.b.a aVar = new com.kwad.sdk.m.a.b.a();
                aVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                c1302b.bnt.add(aVar);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.m.a.b.C1302b c1302b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c1302b.name;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "name", c1302b.name);
        }
        boolean z = c1302b.bns;
        if (z) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isStatic", z);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "paramList", c1302b.bnt);
        return jSONObject;
    }
}
