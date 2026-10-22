package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class jn implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.network.j) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.network.j) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.aTx = jSONObject.optLong("request_prepare_cost");
        jVar.aTy = jSONObject.optLong("request_add_params_cost");
        jVar.aTz = jSONObject.optLong("request_create_cost");
        jVar.aTA = jSONObject.optInt("keep_alive");
        jVar.aTB = jSONObject.optLong("dns_start");
        jVar.aTC = jSONObject.optLong("dns_cost");
        jVar.aTD = jSONObject.optLong("connect_establish_start");
        jVar.aTE = jSONObject.optLong("connect_establish_cost");
        jVar.aTF = jSONObject.optLong("request_start");
        jVar.aTG = jSONObject.optLong("request_cost");
        jVar.aTH = jSONObject.optLong("request_size");
        jVar.aTI = jSONObject.optLong("response_start");
        jVar.aTJ = jSONObject.optLong("response_cost");
        jVar.aTK = jSONObject.optLong("response_parse_cost");
        jVar.aTL = jSONObject.optLong("response_size");
        jVar.aTM = jSONObject.optLong("waiting_response_cost");
        jVar.aTN = jSONObject.optLong("total_cost");
        jVar.aTO = jSONObject.optInt("proxy_used");
        jVar.aTP = jSONObject.optString("request_id");
        if (JSONObject.NULL.toString().equals(jVar.aTP)) {
            jVar.aTP = "";
        }
        jVar.aTQ = jSONObject.optInt("has_data_v2");
        jVar.result = jSONObject.optInt("result");
        jVar.aTR = jSONObject.optLong("response_done_cost");
        jVar.aTS = jSONObject.optString("host_ip");
        if (JSONObject.NULL.toString().equals(jVar.aTS)) {
            jVar.aTS = "";
        }
        jVar.aTT = jSONObject.optInt("ip_type");
        jVar.aTU = jSONObject.optInt("recommend_ping_time");
        jVar.aTV = jSONObject.optInt("backup_ping_time");
        jVar.aTW = jSONObject.optInt("other_ping_time");
    }

    private static JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = jVar.aTx;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_prepare_cost", j);
        }
        long j2 = jVar.aTy;
        if (j2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_add_params_cost", j2);
        }
        long j3 = jVar.aTz;
        if (j3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_create_cost", j3);
        }
        int i = jVar.aTA;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "keep_alive", i);
        }
        long j4 = jVar.aTB;
        if (j4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "dns_start", j4);
        }
        long j5 = jVar.aTC;
        if (j5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "dns_cost", j5);
        }
        long j6 = jVar.aTD;
        if (j6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "connect_establish_start", j6);
        }
        long j7 = jVar.aTE;
        if (j7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "connect_establish_cost", j7);
        }
        long j8 = jVar.aTF;
        if (j8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_start", j8);
        }
        long j9 = jVar.aTG;
        if (j9 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_cost", j9);
        }
        long j10 = jVar.aTH;
        if (j10 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_size", j10);
        }
        long j11 = jVar.aTI;
        if (j11 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "response_start", j11);
        }
        long j12 = jVar.aTJ;
        if (j12 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "response_cost", j12);
        }
        long j13 = jVar.aTK;
        if (j13 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "response_parse_cost", j13);
        }
        long j14 = jVar.aTL;
        if (j14 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "response_size", j14);
        }
        long j15 = jVar.aTM;
        if (j15 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "waiting_response_cost", j15);
        }
        long j16 = jVar.aTN;
        if (j16 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "total_cost", j16);
        }
        int i2 = jVar.aTO;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "proxy_used", i2);
        }
        String str = jVar.aTP;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "request_id", jVar.aTP);
        }
        int i3 = jVar.aTQ;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "has_data_v2", i3);
        }
        int i4 = jVar.result;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "result", i4);
        }
        long j17 = jVar.aTR;
        if (j17 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "response_done_cost", j17);
        }
        String str2 = jVar.aTS;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "host_ip", jVar.aTS);
        }
        int i5 = jVar.aTT;
        if (i5 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ip_type", i5);
        }
        int i6 = jVar.aTU;
        if (i6 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "recommend_ping_time", i6);
        }
        int i7 = jVar.aTV;
        if (i7 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "backup_ping_time", i7);
        }
        int i8 = jVar.aTW;
        if (i8 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "other_ping_time", i8);
        }
        return jSONObject;
    }
}
