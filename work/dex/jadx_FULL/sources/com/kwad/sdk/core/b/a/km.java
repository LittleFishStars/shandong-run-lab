package com.kwad.sdk.core.b.a;

import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class km implements com.kwad.sdk.core.d<com.kwad.sdk.m.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.m.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.m.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.m.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.funcSwitch = jSONObject.optLong("funcSwitch");
        dVar.bmQ = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("urlList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                dVar.bmQ.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        dVar.bmR = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                com.kwad.sdk.m.d.a aVar = new com.kwad.sdk.m.d.a();
                aVar.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                dVar.bmR.add(aVar);
            }
        }
        dVar.byteCount = jSONObject.optLong("byteCount");
        dVar.sampleRate = jSONObject.optDouble("sampleRate");
        dVar.bmS = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                com.kwad.sdk.m.a.b bVar = new com.kwad.sdk.m.a.b();
                bVar.parseJson(jSONArrayOptJSONArray3.optJSONObject(i3));
                dVar.bmS.add(bVar);
            }
        }
        dVar.bmI = new ArrayList();
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("aggregationCheckConfigList");
        if (jSONArrayOptJSONArray4 != null) {
            for (int i4 = 0; i4 < jSONArrayOptJSONArray4.length(); i4++) {
                com.kwad.sdk.m.a.a aVar2 = new com.kwad.sdk.m.a.a();
                aVar2.parseJson(jSONArrayOptJSONArray4.optJSONObject(i4));
                dVar.bmI.add(aVar2);
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.m.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = dVar.funcSwitch;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "funcSwitch", j);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "urlList", dVar.bmQ);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "actConfigList", dVar.bmR);
        long j2 = dVar.byteCount;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "byteCount", j2);
        }
        double d = dVar.sampleRate;
        if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sampleRate", d);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "anchorNodeList", dVar.bmS);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "aggregationCheckConfigList", dVar.bmI);
        return jSONObject;
    }
}
