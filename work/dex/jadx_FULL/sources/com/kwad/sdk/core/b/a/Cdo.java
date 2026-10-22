package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.kwad.sdk.core.b.a.do, reason: invalid class name */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class Cdo implements com.kwad.sdk.core.d<com.kwad.sdk.crash.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.crash.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.crash.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.bds = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("appIdList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                aVar.bds.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        aVar.bdt = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("sdkVersionList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                aVar.bdt.add((String) jSONArrayOptJSONArray2.opt(i2));
            }
        }
        aVar.bdu = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("stacktraceList");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                aVar.bdu.add((String) jSONArrayOptJSONArray3.opt(i3));
            }
        }
        aVar.bdv = jSONObject.optDouble("crashUploadRate", new Double("1.0").doubleValue());
    }

    private static JSONObject b(com.kwad.sdk.crash.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "appIdList", aVar.bds);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkVersionList", aVar.bdt);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "stacktraceList", aVar.bdu);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "crashUploadRate", aVar.bdv);
        return jSONObject;
    }
}
