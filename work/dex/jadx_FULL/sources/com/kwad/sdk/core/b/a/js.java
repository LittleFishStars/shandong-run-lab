package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class js implements com.kwad.sdk.core.d<com.kwad.sdk.h.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.h.a.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.h.a.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.h.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.sceneId = jSONObject.optString("sceneId");
        if (JSONObject.NULL.toString().equals(aVar.sceneId)) {
            aVar.sceneId = "";
        }
        aVar.bgF = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("packages");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                com.kwad.sdk.h.a.b bVar = new com.kwad.sdk.h.a.b();
                bVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                aVar.bgF.add(bVar);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.h.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.sceneId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sceneId", aVar.sceneId);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "packages", aVar.bgF);
        return jSONObject;
    }
}
