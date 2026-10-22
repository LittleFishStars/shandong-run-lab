package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class jo implements com.kwad.sdk.core.d<com.kwad.components.core.offline.moitor.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.core.offline.moitor.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.core.offline.moitor.b) bVar, jSONObject);
    }

    private static void a(com.kwad.components.core.offline.moitor.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.acX = jSONObject.optString("load_module");
        if (JSONObject.NULL.toString().equals(bVar.acX)) {
            bVar.acX = "";
        }
        bVar.acY = jSONObject.optLong("load_status");
        bVar.acZ = jSONObject.optLong("load_duration_ms");
        bVar.ada = jSONObject.optLong("thread_core_size", new Long("0").longValue());
        bVar.adb = jSONObject.optString("load_source");
        if (JSONObject.NULL.toString().equals(bVar.adb)) {
            bVar.adb = "";
        }
    }

    private static JSONObject b(com.kwad.components.core.offline.moitor.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.acX;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_module", bVar.acX);
        }
        long j = bVar.acY;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_status", j);
        }
        long j2 = bVar.acZ;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_duration_ms", j2);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "thread_core_size", bVar.ada);
        String str2 = bVar.adb;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "load_source", bVar.adb);
        }
        return jSONObject;
    }
}
