package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class lt implements com.kwad.sdk.core.d<com.kwad.components.core.innerEc.live.f.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.innerEc.live.f.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.innerEc.live.f.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.innerEc.live.f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Xt = jSONObject.optString("sellerId");
        if (JSONObject.NULL.toString().equals(aVar.Xt)) {
            aVar.Xt = "";
        }
        aVar.liveStreamId = jSONObject.optString("liveStreamId");
        if (JSONObject.NULL.toString().equals(aVar.liveStreamId)) {
            aVar.liveStreamId = "";
        }
        aVar.Xu = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pendantInfoList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                com.kwad.components.core.innerEc.live.f.b bVar = new com.kwad.components.core.innerEc.live.f.b();
                bVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                aVar.Xu.add(bVar);
            }
        }
    }

    private static JSONObject b(com.kwad.components.core.innerEc.live.f.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.Xt;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sellerId", aVar.Xt);
        }
        String str2 = aVar.liveStreamId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveStreamId", aVar.liveStreamId);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "pendantInfoList", aVar.Xu);
        return jSONObject;
    }
}
