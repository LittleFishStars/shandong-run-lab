package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class nh implements com.kwad.sdk.core.d<com.kwad.sdk.core.threads.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.threads.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.threads.b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aYy = jSONObject.optString("pool_name");
        if (JSONObject.NULL.toString().equals(bVar.aYy)) {
            bVar.aYy = "";
        }
        bVar.aYz = jSONObject.optInt("core_pool_size");
        bVar.aYA = jSONObject.optInt("max_pool_size");
        bVar.aYB = jSONObject.optInt("current_pool_size");
        bVar.aYC = jSONObject.optInt("active_count");
        bVar.aYD = jSONObject.optLong("task_wait_avg_ms");
        bVar.aYE = jSONObject.optLong("task_succ_count");
        bVar.interval = jSONObject.optLong("interval_ms");
        bVar.aYF = jSONObject.optInt("queue_size");
        bVar.aYG = jSONObject.optLong("pass_timestamp");
        bVar.aYH = jSONObject.optInt("func_ratio_count");
    }

    private static JSONObject b(com.kwad.sdk.core.threads.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aYy;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pool_name", bVar.aYy);
        }
        int i = bVar.aYz;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "core_pool_size", i);
        }
        int i2 = bVar.aYA;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "max_pool_size", i2);
        }
        int i3 = bVar.aYB;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "current_pool_size", i3);
        }
        int i4 = bVar.aYC;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "active_count", i4);
        }
        long j = bVar.aYD;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "task_wait_avg_ms", j);
        }
        long j2 = bVar.aYE;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "task_succ_count", j2);
        }
        long j3 = bVar.interval;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interval_ms", j3);
        }
        int i5 = bVar.aYF;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "queue_size", i5);
        }
        long j4 = bVar.aYG;
        if (j4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pass_timestamp", j4);
        }
        int i6 = bVar.aYH;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "func_ratio_count", i6);
        }
        return jSONObject;
    }
}
