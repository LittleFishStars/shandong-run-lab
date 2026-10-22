package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ll implements com.kwad.sdk.core.d<com.kwad.sdk.monitor.b.C1305b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.monitor.b.C1305b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.monitor.b.C1305b) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.monitor.b.C1305b c1305b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c1305b.bjh = jSONObject.optInt("enable_monitor");
        c1305b.bji = jSONObject.optString("c_sc_name");
        if (JSONObject.NULL.toString().equals(c1305b.bji)) {
            c1305b.bji = "";
        }
        c1305b.bjj = jSONObject.optString("c_pcl_name");
        if (JSONObject.NULL.toString().equals(c1305b.bjj)) {
            c1305b.bjj = "";
        }
        c1305b.bjk = jSONObject.optString("m_gam_name");
        if (JSONObject.NULL.toString().equals(c1305b.bjk)) {
            c1305b.bjk = "";
        }
        c1305b.bjl = jSONObject.optString("m_gsv_name");
        if (JSONObject.NULL.toString().equals(c1305b.bjl)) {
            c1305b.bjl = "";
        }
        c1305b.bjm = jSONObject.optString("m_gpv_name");
        if (JSONObject.NULL.toString().equals(c1305b.bjm)) {
            c1305b.bjm = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.monitor.b.C1305b c1305b, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = c1305b.bjh;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enable_monitor", i);
        }
        String str = c1305b.bji;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "c_sc_name", c1305b.bji);
        }
        String str2 = c1305b.bjj;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "c_pcl_name", c1305b.bjj);
        }
        String str3 = c1305b.bjk;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "m_gam_name", c1305b.bjk);
        }
        String str4 = c1305b.bjl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "m_gsv_name", c1305b.bjl);
        }
        String str5 = c1305b.bjm;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "m_gpv_name", c1305b.bjm);
        }
        return jSONObject;
    }
}
