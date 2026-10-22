package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.convert.AdLinkMonitorMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class ac implements com.kwad.sdk.core.d<AdLinkMonitorMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdLinkMonitorMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdLinkMonitorMsg) bVar, jSONObject);
    }

    private static void a(AdLinkMonitorMsg adLinkMonitorMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLinkMonitorMsg.status = jSONObject.optInt("status");
        adLinkMonitorMsg.durationTime = jSONObject.optLong("duration_time");
        adLinkMonitorMsg.renderType = jSONObject.optInt("render_type");
        adLinkMonitorMsg.adStyle = jSONObject.optInt("ad_style");
        adLinkMonitorMsg.materialLoadType = jSONObject.optInt("material_load_type");
    }

    private static JSONObject b(AdLinkMonitorMsg adLinkMonitorMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adLinkMonitorMsg.status;
        if (i != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", i);
        }
        long j = adLinkMonitorMsg.durationTime;
        if (j != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "duration_time", j);
        }
        int i2 = adLinkMonitorMsg.renderType;
        if (i2 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "render_type", i2);
        }
        int i3 = adLinkMonitorMsg.adStyle;
        if (i3 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_style", i3);
        }
        int i4 = adLinkMonitorMsg.materialLoadType;
        if (i4 != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_load_type", i4);
        }
        return jSONObject;
    }
}
