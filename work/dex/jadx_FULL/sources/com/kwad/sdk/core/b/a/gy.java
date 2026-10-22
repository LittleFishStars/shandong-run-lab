package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class gy implements com.kwad.sdk.core.d<com.kwad.components.ad.j.b.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.components.ad.j.b.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.components.ad.j.b.a) bVar, jSONObject);
    }

    private static void a(com.kwad.components.ad.j.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.Np = jSONObject.optString("device_model");
        if (JSONObject.NULL.toString().equals(aVar.Np)) {
            aVar.Np = "";
        }
        aVar.Nq = jSONObject.optString("device_brand");
        if (JSONObject.NULL.toString().equals(aVar.Nq)) {
            aVar.Nq = "";
        }
        aVar.Nr = jSONObject.optString("os_version");
        if (JSONObject.NULL.toString().equals(aVar.Nr)) {
            aVar.Nr = "";
        }
        aVar.Ns = jSONObject.optString("rom_name");
        if (JSONObject.NULL.toString().equals(aVar.Ns)) {
            aVar.Ns = "";
        }
        aVar.Nt = jSONObject.optString("device_id");
        if (JSONObject.NULL.toString().equals(aVar.Nt)) {
            aVar.Nt = "";
        }
        aVar.status = jSONObject.optInt("status");
        aVar.Nu = jSONObject.optString("install_check_record");
        if (JSONObject.NULL.toString().equals(aVar.Nu)) {
            aVar.Nu = "";
        }
        aVar.Nv = jSONObject.optString("local_installer_pkgs");
        if (JSONObject.NULL.toString().equals(aVar.Nv)) {
            aVar.Nv = "";
        }
    }

    private static JSONObject b(com.kwad.components.ad.j.b.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.Np;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "device_model", aVar.Np);
        }
        String str2 = aVar.Nq;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "device_brand", aVar.Nq);
        }
        String str3 = aVar.Nr;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "os_version", aVar.Nr);
        }
        String str4 = aVar.Ns;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rom_name", aVar.Ns);
        }
        String str5 = aVar.Nt;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "device_id", aVar.Nt);
        }
        int i = aVar.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        String str6 = aVar.Nu;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "install_check_record", aVar.Nu);
        }
        String str7 = aVar.Nv;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "local_installer_pkgs", aVar.Nv);
        }
        return jSONObject;
    }
}
