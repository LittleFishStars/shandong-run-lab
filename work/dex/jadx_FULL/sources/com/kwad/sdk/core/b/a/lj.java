package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.SDKInitMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class lj implements com.kwad.sdk.core.d<SDKInitMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SDKInitMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SDKInitMsg) bVar, jSONObject);
    }

    private static void a(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sDKInitMsg.launchIntervalTime = jSONObject.optLong("init_launch_interval_time");
        sDKInitMsg.totalDurationTime = jSONObject.optLong("init_total_duration_time");
        sDKInitMsg.initStatus = jSONObject.optInt("init_status", new Integer("0").intValue());
        sDKInitMsg.errorReason = jSONObject.optString("error_reason");
        if (JSONObject.NULL.toString().equals(sDKInitMsg.errorReason)) {
            sDKInitMsg.errorReason = "";
        }
        sDKInitMsg.initCount = jSONObject.optInt("init_count");
        sDKInitMsg.initProcess = jSONObject.optInt("init_process");
        sDKInitMsg.initThread = jSONObject.optInt("init_thread");
        sDKInitMsg.intDynamicSDK = jSONObject.optInt("init_dynamic_sdk");
        sDKInitMsg.intBuildNumber = jSONObject.optInt("init_build_number");
    }

    private static JSONObject b(SDKInitMsg sDKInitMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = sDKInitMsg.launchIntervalTime;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "init_launch_interval_time", j);
        }
        long j2 = sDKInitMsg.totalDurationTime;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "init_total_duration_time", j2);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "init_status", sDKInitMsg.initStatus);
        String str = sDKInitMsg.errorReason;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "error_reason", sDKInitMsg.errorReason);
        }
        int i = sDKInitMsg.initCount;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "init_count", i);
        }
        int i2 = sDKInitMsg.initProcess;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "init_process", i2);
        }
        int i3 = sDKInitMsg.initThread;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "init_thread", i3);
        }
        int i4 = sDKInitMsg.intDynamicSDK;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "init_dynamic_sdk", i4);
        }
        int i5 = sDKInitMsg.intBuildNumber;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "init_build_number", i5);
        }
        return jSONObject;
    }
}
