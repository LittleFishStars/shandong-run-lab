package com.kwad.sdk.core.b.a;

import com.kc.openset.constant.DeviceIdType;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class gk implements com.kwad.sdk.core.d<com.kwad.sdk.core.config.item.i.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.config.item.i.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.config.item.i.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.config.item.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aQZ = jSONObject.optString(DeviceIdType.IMEI);
        if (JSONObject.NULL.toString().equals(aVar.aQZ)) {
            aVar.aQZ = "";
        }
        aVar.aRa = jSONObject.optString(DeviceIdType.OAID);
        if (JSONObject.NULL.toString().equals(aVar.aRa)) {
            aVar.aRa = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.config.item.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.aQZ;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, DeviceIdType.IMEI, aVar.aQZ);
        }
        String str2 = aVar.aRa;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, DeviceIdType.OAID, aVar.aRa);
        }
        return jSONObject;
    }
}
