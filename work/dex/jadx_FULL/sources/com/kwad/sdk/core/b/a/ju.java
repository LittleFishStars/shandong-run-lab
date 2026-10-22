package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ju implements com.kwad.sdk.core.d<com.kwad.sdk.core.config.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.config.d) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.config.d) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aQR = jSONObject.optInt("enableDialog", new Integer("0").intValue());
        dVar.aQS = jSONObject.optInt("delayTime", new Integer("800").intValue());
        dVar.aQT = jSONObject.optInt("showTimesPerDay", new Integer("3").intValue());
        dVar.aQU = jSONObject.optInt("maxShowTimes", new Integer("100000").intValue());
    }

    private static JSONObject b(com.kwad.sdk.core.config.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "enableDialog", dVar.aQR);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "delayTime", dVar.aQS);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "showTimesPerDay", dVar.aQT);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "maxShowTimes", dVar.aQU);
        return jSONObject;
    }
}
