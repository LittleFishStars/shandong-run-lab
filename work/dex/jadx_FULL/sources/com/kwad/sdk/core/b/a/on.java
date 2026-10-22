package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class on implements com.kwad.sdk.core.d<com.kwad.sdk.wrapper.l.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.wrapper.l.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.wrapper.l.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.wrapper.l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bue = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("c_cns");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                aVar.bue.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        aVar.bug = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("s_cns");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                com.kwad.sdk.wrapper.l.a.C1312a c1312a = new com.kwad.sdk.wrapper.l.a.C1312a();
                c1312a.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                aVar.bug.add(c1312a);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.wrapper.l.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "c_cns", aVar.bue);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "s_cns", aVar.bug);
        return jSONObject;
    }
}
